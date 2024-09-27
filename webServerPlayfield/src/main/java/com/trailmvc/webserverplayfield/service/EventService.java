package com.trailmvc.webserverplayfield.service;

import com.trailmvc.webserverplayfield.dto.EventDto;

import java.util.List;

public interface EventService {
    public void createEvent(Long clubId, EventDto eventDto);

    List<EventDto> findAllevents();

    EventDto findByEventId(Long eventId);

    void updateEvent(EventDto eventDto);

    void deleteEvent(long eventId);

    List<EventDto> findAllEvents();
}
