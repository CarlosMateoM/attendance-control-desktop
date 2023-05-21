package com.attendance.control.util.arduino;

public interface SerialDataListener {
    void onDataReceived(String data);
}
