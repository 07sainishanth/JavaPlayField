package com.trailmvc.webserverplayfield.service.impl;

import com.trailmvc.webserverplayfield.dto.EventDto;
import com.trailmvc.webserverplayfield.models.Club;
import com.trailmvc.webserverplayfield.models.Event;
import com.trailmvc.webserverplayfield.repository.ClubRepository;
import com.trailmvc.webserverplayfield.repository.EventRepository;
import com.trailmvc.webserverplayfield.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.trailmvc.webserverplayfield.mapper.EventMapper.mapToEventDto;
import static com.trailmvc.webserverplayfield.mapper.EventMapper.mapToEvent;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;
    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Optional<Club> club = clubRepository.findById(clubId);
        Event event = mapToEvent(eventDto);
        event.setClub(club.get());
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllevents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).orElse(null);
//        assert event != null;
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }
}
