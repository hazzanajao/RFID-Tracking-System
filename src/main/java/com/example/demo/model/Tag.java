package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    private String id;

    @Column(nullable = false)
    private String assetName;

    private String location;

    private LocalDateTime lastSeen;
    /**
     * "active", "missing", "inactive"
     * **********************************/
    private String status;

    // Constructors
    public Tag() {}

    public Tag(String id, String assetName, String location, LocalDateTime lastSeen, String status) {
        this.id = id;
        this.assetName = assetName;
        this.location = location;
        this.lastSeen = lastSeen;
        this.status = status;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAssetName() { return assetName; }
    public void setAssetName(String assetName) { this.assetName = assetName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
