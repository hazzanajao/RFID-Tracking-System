package com.rfidDevExpertHub.rfidTrackingSystems.repository;

import com.rfidDevExpertHub.rfidTrackingSystems.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {

}