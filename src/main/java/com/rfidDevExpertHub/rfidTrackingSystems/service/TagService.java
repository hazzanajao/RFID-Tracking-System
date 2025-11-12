package com.rfidDevExpertHub.rfidTrackingSystems.service;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;

import com.rfidDevExpertHub.rfidTrackingSystems.exception.ResourceNotFoundException;
import com.rfidDevExpertHub.rfidTrackingSystems.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    // Create
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    // Read
    public Tag getTagById(String id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with ID: " + id));
    }

    // Update
    public Tag updateTag(String id, Tag tagDetails) {
        Tag tag = getTagById(id);
        tag.setAssetName(tagDetails.getAssetName());
        tag.setLocation(tagDetails.getLocation());
        tag.setLastSeen(tagDetails.getLastSeen());
        tag.setStatus(tagDetails.getStatus());
        return tagRepository.save(tag);
    }

    // Delete
    public void deleteTag(String id) {
        Tag tag = getTagById(id);
        tagRepository.delete(tag);
    }

    // List all
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    // Filter by status
    public Page<Tag> getTagsByStatus(String status, Pageable pageable) {
        return tagRepository.findByStatus(status, pageable);
    }

    // Filter by location
    public Page<Tag> getTagsByLocation(String location, Pageable pageable) {
        return tagRepository.findByLocation(location, pageable);
    }

    // Search by asset name
    public Page<Tag> searchTags(String keyword, Pageable pageable) {
        return tagRepository.findByAssetNameContainingIgnoreCase(keyword, pageable);
    }
}