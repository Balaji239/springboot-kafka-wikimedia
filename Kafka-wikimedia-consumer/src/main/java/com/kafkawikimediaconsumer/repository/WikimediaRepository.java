package com.kafkawikimediaconsumer.repository;

import com.kafkawikimediaconsumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Integer> {
}
