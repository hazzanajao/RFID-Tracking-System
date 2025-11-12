package com.rfidDevExpertHub.rfidTrackingSystems.repository;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

    // Filter by status
    Page<Tag> findByStatus(String status, Pageable pageable);

    // Filter by location
    Page<Tag> findByLocation(String location, Pageable pageable);

    // Search by asset name (partial match)
    Page<Tag> findByAssetNameContainingIgnoreCase(String keyword, Pageable pageable);
}