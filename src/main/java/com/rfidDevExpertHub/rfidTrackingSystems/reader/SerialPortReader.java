package com.rfidDevExpertHub.rfidTrackingSystems.reader;

import org.springframework.stereotype.Component;
import java.util.Random;

/**
 * Serial Port Reader Mock Implementation
 * This mock simulates RFID tag reads and location detection.
 * We can later replace this with a hardware-based
 * version using jSerialComm or similar libraries
 * ***********************************************************/

public class SerialPortReader {

    private String port;
    private int baudRate;

    // ✅ Constructor with parameters
    public SerialPortReader(String port, int baudRate) {
        this.port = port;
        this.baudRate = baudRate;
        // Initialize serial connection here if needed
    }

    // Optional: default constructor for Spring autowiring
    public SerialPortReader() {
        this.port = "COM3";
        this.baudRate = 9600;
    }

    public String readTagId() {
        return "TAG001"; // Simulated read
    }

    public String readLocation() {
        return "Warehouse A"; // Simulated location
    }
}