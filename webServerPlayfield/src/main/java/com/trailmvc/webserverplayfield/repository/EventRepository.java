package com.trailmvc.webserverplayfield.repository;

import com.trailmvc.webserverplayfield.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
