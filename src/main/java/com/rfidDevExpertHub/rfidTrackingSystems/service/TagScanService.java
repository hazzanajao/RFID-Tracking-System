package com.rfidDevExpertHub.rfidTrackingSystems.service;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import com.rfidDevExpertHub.rfidTrackingSystems.model.TagScanLog;
import com.rfidDevExpertHub.rfidTrackingSystems.repository.TagRepository;
import com.rfidDevExpertHub.rfidTrackingSystems.repository.TagScanLogRepository;
import com.rfidDevExpertHub.rfidTrackingSystems.exception.ResourceNotFoundException;
import com.rfidDevExpertHub.rfidTrackingSystems.reader.SerialPortReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TagScanService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagScanLogRepository tagScanLogRepository;

    @Autowired
    private SerialPortReader reader;

    // Manual scan via API
    public Tag processScan(String tagId, String location) {
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found: " + tagId));

        tag.setLastSeen(LocalDateTime.now());
        tag.setLocation(location);
        tag.setStatus("active");
        tagRepository.save(tag);

        TagScanLog log = new TagScanLog();
        log.setTagId(tagId);
        log.setLocation(location);
        log.setTimestamp(LocalDateTime.now());
        tagScanLogRepository.save(log);

        return tag;
    }

    // Auto scan using SerialPortReader
    public Tag autoScan() {
        String tagId = reader.readTagId();
        String location = reader.readLocation();
        return processScan(tagId, location);
    }
}