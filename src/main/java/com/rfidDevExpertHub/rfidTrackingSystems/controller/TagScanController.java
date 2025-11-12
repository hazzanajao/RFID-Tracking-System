package com.rfidDevExpertHub.rfidTrackingSystems.controller;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import com.rfidDevExpertHub.rfidTrackingSystems.service.TagScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scan")
public class TagScanController {

    @Autowired
    private TagScanService tagScanService;

    // Manual scan: provide tagId and location
    @PostMapping
    public Tag scanTag(@RequestParam String tagId, @RequestParam String location) {
        return tagScanService.processScan(tagId, location);
    }

    // Auto scan: simulate tagId and location from SerialPortReader
    @PostMapping("/auto")
    public Tag autoScanTag() {
        return tagScanService.autoScan();
    }
}