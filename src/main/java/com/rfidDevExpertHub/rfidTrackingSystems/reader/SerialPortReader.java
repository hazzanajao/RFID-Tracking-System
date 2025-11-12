package com.rfidDevExpertHub.rfidTrackingSystems.reader;

import org.springframework.stereotype.Component;
import java.util.Random;

/**
 * Serial Port Reader Mock Implementation
 * This mock simulates RFID tag reads and location detection.
 * We can later replace this with a hardware-based
 * version using jSerialComm or similar libraries
 * ***********************************************************/
@Component
public class SerialPortReader {

    private final String[] mockTagIds = {"TAG001", "TAG002", "TAG003", "TAG004"};
    private final String[] mockLocations = {"Warehouse A", "Dock B", "Zone C"};

    public String readTagId() {
        Random random = new Random();
        return mockTagIds[random.nextInt(mockTagIds.length)];
    }

    public String readLocation() {
        Random random = new Random();
        return mockLocations[random.nextInt(mockLocations.length)];
    }
}