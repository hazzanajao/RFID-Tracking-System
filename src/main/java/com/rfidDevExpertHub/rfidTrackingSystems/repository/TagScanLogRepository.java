package com.rfidDevExpertHub.rfidTrackingSystems.repository;

import com.rfidDevExpertHub.rfidTrackingSystems.model.TagScanLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagScanLogRepository extends JpaRepository<TagScanLog, Long> {

    List<TagScanLog> findByTagIdOrderByTimestampDesc(String tagId);
}
