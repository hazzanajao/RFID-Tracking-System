package com.rfidDevExpertHub.rfidTrackingSystems.controller;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import com.rfidDevExpertHub.rfidTrackingSystems.service.TagScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scan")
public class TagScanController {

    @Autowired
    private TagScanService tagScanService;

    @PostMapping
    public Tag scanTag(@RequestParam String tagId, @RequestParam String location) {
        return tagScanService.processScan(tagId, location);
    }
}
