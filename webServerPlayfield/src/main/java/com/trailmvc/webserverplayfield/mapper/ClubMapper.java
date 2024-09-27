package com.trailmvc.webserverplayfield.mapper;

import com.trailmvc.webserverplayfield.dto.ClubDto;
import com.trailmvc.webserverplayfield.models.Club;

import java.util.stream.Collectors;

import static com.trailmvc.webserverplayfield.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto;
        clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map( (event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();

        return clubDto;
    }

    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                .id(clubDto.getId())
                .title(clubDto.getTitle())
                .photoUrl(clubDto.getPhotoUrl())
                .content(clubDto.getContent())
                .createdBy(clubDto.getCreatedBy())
                .createdOn(clubDto.getCreatedOn())
                .updatedOn(clubDto.getUpdatedOn())
                .build();
        return club;
    }
}
