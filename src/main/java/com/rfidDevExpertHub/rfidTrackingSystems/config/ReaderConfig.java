package com.rfidDevExpertHub.rfidTrackingSystems.config;
import com.rfidDevExpertHub.rfidTrackingSystems.reader.SerialPortReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// For integrating physical RFID reader via serial/USB:
@Configuration
public class ReaderConfig {

    @Bean
    public SerialPortReader serialPortReader() {
        return new SerialPortReader("COM3", 9600); // To be Replaced with actual port and baud rate
    }
}

