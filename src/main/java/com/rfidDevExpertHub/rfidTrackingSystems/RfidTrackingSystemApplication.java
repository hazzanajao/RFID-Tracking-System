package com.rfidDevExpertHub.rfidTrackingSystems;

import com.rfidDevExpertHub.rfidTrackingSystems.author.Author;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RfidTrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RfidTrackingSystemApplication.class, args);
        Author author = new Author();
        author.showAuthorDetails();
    }

}
