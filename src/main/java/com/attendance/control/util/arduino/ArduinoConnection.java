package com.attendance.control.util.arduino;
        
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

public class ArduinoConnection implements SerialPortEventListener {

    SerialPort serialPort;
    private SerialDataListener dataListener;
    private static ArduinoConnection instance;

    private static final String PORT_NAMES[] = {
        "/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyACM0", // Raspberry Pi
        "/dev/ttyUSB0", // Linux
        "COM3", // Windows
    };

    private BufferedReader input;
    private OutputStream output;
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    
    private ArduinoConnection(){}
    
    public static ArduinoConnection getInstance(){
        if(instance == null){
            instance = new ArduinoConnection();
        }
        return instance;
    }

    public void setDataListener(SerialDataListener dataListener) {
        this.dataListener = dataListener;
    }

    public void initialize() {

        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : PORT_NAMES) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {

            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));

            output = serialPort.getOutputStream();

            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }
    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                System.out.println(inputLine);
                if(dataListener != null){
                    dataListener.onDataReceived(inputLine);
                }
            } catch (IOException e) {
                System.err.println(e.toString());
            }
        }
    }

    public void send(String data) {
        try {
            if(output!=null){   
                output.write(data.getBytes());
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    public String receive() {
        String result = "";
        try {
            result = input.readLine();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
        return result;

    }

}
