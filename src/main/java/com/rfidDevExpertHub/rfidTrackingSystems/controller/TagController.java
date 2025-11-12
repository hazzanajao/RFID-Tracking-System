package com.rfidDevExpertHub.rfidTrackingSystems.controller;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    // Create
    @PostMapping
    public Tag createTag(@RequestBody Tag tag) {
        return tagService.createTag(tag);
    }

    // Read by ID
    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable String id) {
        return tagService.getTagById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable String id, @RequestBody Tag tagDetails) {
        return tagService.updateTag(id, tagDetails);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable String id) {
        tagService.deleteTag(id);
    }

    // List all with pagination
    @GetMapping
    public Page<Tag> getAllTags(Pageable pageable) {
        return tagService.getAllTags(pageable);
    }

    // Filter by status
    @GetMapping("/status/{status}")
    public Page<Tag> getTagsByStatus(@PathVariable String status, Pageable pageable) {
        return tagService.getTagsByStatus(status, pageable);
    }

    // Filter by location
    @GetMapping("/location/{location}")
    public Page<Tag> getTagsByLocation(@PathVariable String location, Pageable pageable) {
        return tagService.getTagsByLocation(location, pageable);
    }

    // Search by asset name
    @GetMapping("/search")
    public Page<Tag> searchTags(@RequestParam String keyword, Pageable pageable) {
        return tagService.searchTags(keyword, pageable);
    }
}
