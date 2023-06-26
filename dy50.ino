   #include <Adafruit_Fingerprint.h>


#if (defined(__AVR__) || defined(ESP8266)) && !defined(__AVR_ATmega2560__)
// For UNO and others without hardware serial, we must use software serial...
// pin #2 is IN from sensor (GREEN wire)
// pin #3 is OUT from arduino  (WHITE wire)
// Set up the serial port to use softwareserial..
SoftwareSerial mySerial(2, 3);

#else
// On Leonardo/M0/etc, others with hardware serial, use hardware serial!
// #0 is green wire, #1 is white
#define mySerial Serial1

#endif

Adafruit_Fingerprint finger = Adafruit_Fingerprint(&mySerial);

uint8_t id;

void setup() {
  Serial.begin(9600);
  while (!Serial)
    ;  // For Yun/Leo/Micro/Zero/...
  delay(100);
  Serial.println("\n\nAdafruit Fingerprint sensor enrollment");

  // set the data rate for the sensor serial port
  finger.begin(57600);

  if (finger.verifyPassword()) {
    Serial.println("Found fingerprint sensor!");
  } else {
    Serial.println("Did not find fingerprint sensor :(");
    while (1) { delay(1); }
  }
  /*
  Serial.println(F("Reading sensor parameters"));
  finger.getParameters();
  Serial.print(F("Status: 0x"));
  Serial.println(finger.status_reg, HEX);
  Serial.print(F("Sys ID: 0x"));
  Serial.println(finger.system_id, HEX);
  Serial.print(F("Capacity: "));
  Serial.println(finger.capacity);
  Serial.print(F("Security level: "));
  Serial.println(finger.security_level);
  Serial.print(F("Device address: "));
  Serial.println(finger.device_addr, HEX);
  Serial.print(F("Packet len: "));
  Serial.println(finger.packet_len);
  Serial.print(F("Baud rate: "));
  Serial.println(finger.baud_rate);
  */
}

int op = 4;

void loop() {

  while (Serial.available() > 0) {
    
    uint8_t input = readnumber();
    op = input;
  }

  if (op == 1) {

    int id = getFingerprintIDez();

    if (id > 0){
      Serial.println(id);
    } else if(id == -2) {
      Serial.println("Huella no encontrada!");
    }

  } else if(op == 2){
    op = -1;

    Serial.println("Coloque el dedo en el sensor");
    
    while(! getFingerprintEnroll());

  } else if(op == 3){
    op = -1;

    Serial.println("Ingrese el id de huella a eliminar");
    uint8_t idToDelete = readnumber();
    deleteFingerprint(idToDelete);
    finger.getTemplateCount();

  } else if(op == 4){
    op = -1;

    finger.LEDcontrol(0);

  } else if(op == 5){
    op = -1;

    finger.emptyDatabase();
    Serial.println("Base de datos borrada");
  }

  delay(50);
}

uint8_t readnumber(void) {
  uint8_t num = 0;

  while (num == 0) {
    while (! Serial.available());
    num = Serial.parseInt();
  }
  return num;
}

uint8_t findNextAvailableTemplate() {

  finger.getTemplateCount();

  uint8_t lastOccupiedTemplate = 0;

  for (uint8_t i = 1; i <= finger.templateCount; i++) {
    if (finger.loadModel(i) == FINGERPRINT_OK) {
      lastOccupiedTemplate = i;
    } else {
      return 0;
    }

    if (i < finger.templateCount && finger.loadModel(i + 1) != FINGERPRINT_OK) {
      return i + 1;
    }
  }

  return lastOccupiedTemplate + 1;  
}



uint8_t getFingerprintEnroll() {

  int p = -1;

  id = findNextAvailableTemplate();

  while (p != FINGERPRINT_OK) {
    p = finger.getImage();

    switch (p) {
      case FINGERPRINT_OK:
        Serial.println("Imagen capturada");
        break;
      case FINGERPRINT_NOFINGER:
        break;
      case FINGERPRINT_PACKETRECIEVEERR:
        Serial.println("Error de comunicacion");
        break;
      case FINGERPRINT_IMAGEFAIL:
        Serial.println("Imaging error");
        break;
      default:
        Serial.println("Unknown error");
        break;
    }
  }

  p = finger.image2Tz(1);

  switch (p) {
    case FINGERPRINT_OK:
      //Serial.println("Imagen convertida");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Image too messy");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicacion");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("Huella dactilar no detectada");
      Serial.println("Reinicie la captura");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("Huella dactilar no detectada");
      Serial.println("Reinicie la captura");
      return p;
    default:
      Serial.println("Unknown error");
      return p;
  }

  Serial.println("Retire el dedo");
  delay(2000);
  p = 0;
  
  while (p != FINGERPRINT_NOFINGER) {
    p = finger.getImage();
  }
  
  p = -1;
  Serial.println("Vuelva a colocar el dedo");
  while (p != FINGERPRINT_OK) {
    p = finger.getImage();
    switch (p) {
      case FINGERPRINT_OK:
        Serial.println("Imagen capturada");
        break;
      case FINGERPRINT_NOFINGER:
        
        break;
      case FINGERPRINT_PACKETRECIEVEERR:
        Serial.println("Error de comunicacion");
        break;
      case FINGERPRINT_IMAGEFAIL:
        Serial.println("Imaging error");
        break;
      default:
        Serial.println("Unknown error");
        break;
    }
  }

  p = finger.image2Tz(2);
  switch (p) {
    case FINGERPRINT_OK:
      //Serial.println("Imagen convertida");
      break;
    case FINGERPRINT_IMAGEMESS:
      Serial.println("Image too messy");
      return p;
    case FINGERPRINT_PACKETRECIEVEERR:
      Serial.println("Error de comunicacion");
      return p;
    case FINGERPRINT_FEATUREFAIL:
      Serial.println("Huella dactilar no detecta");
      Serial.println("Reinicie la captura");
      return p;
    case FINGERPRINT_INVALIDIMAGE:
      Serial.println("Huella dactilar no detecta");
      Serial.println("Reinicie la captura");
      return p;
    default:
      Serial.println("Unknown error");
      return p;
  }

  p = finger.createModel();

  if (p == FINGERPRINT_OK) {

  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error de comunicacion");
    return p;
  } else if (p == FINGERPRINT_ENROLLMISMATCH) {
    Serial.println("Las huellas dactilares no coinciden");
    Serial.println("Reinicie la captura");
    return p;
  } else {
    Serial.println("Unknown error");
    return p;
  }

  p = finger.storeModel(id);
  
  if (p == FINGERPRINT_OK) {
    Serial.println("Huella registrada!");
    delay(100);
    Serial.println(id);
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error de comunicacion");
    return p;
  } else if (p == FINGERPRINT_BADLOCATION) {
    Serial.println("Could not store in that location");
    return p;
  } else if (p == FINGERPRINT_FLASHERR) {
    Serial.println("Error writing to flash");
    return p;
  } else {
    Serial.println("Unknown error");
    return p;
  }

  return true;
}


int getFingerprintIDez() {
  uint8_t p = finger.getImage();
  if (p != FINGERPRINT_OK) return -1;

  p = finger.image2Tz();
  if (p != FINGERPRINT_OK) return -1;

  p = finger.fingerFastSearch();
  if (p != FINGERPRINT_OK) return -2;

  return finger.fingerID;
}

uint8_t deleteFingerprint(uint8_t id) {
  
  uint8_t p = -1;
  p = finger.deleteModel(id);

  if (p == FINGERPRINT_OK) {
    Serial.println("Huella eliminada!");
  } else if (p == FINGERPRINT_PACKETRECIEVEERR) {
    Serial.println("Error de comunicacion");
  } else if (p == FINGERPRINT_BADLOCATION) {
    Serial.println("Could not delete in that location");
  } else if (p == FINGERPRINT_FLASHERR) {
    Serial.println("Error writing to flash");
  } else {
    Serial.print("Unknown error: 0x"); Serial.println(p, HEX);
  }

  return p;
}
