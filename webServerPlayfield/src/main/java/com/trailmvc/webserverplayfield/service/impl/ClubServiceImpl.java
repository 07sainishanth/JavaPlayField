package com.trailmvc.webserverplayfield.service.impl;

import com.trailmvc.webserverplayfield.dto.ClubDto;
import com.trailmvc.webserverplayfield.models.Club;
import com.trailmvc.webserverplayfield.repository.ClubRepository;
import com.trailmvc.webserverplayfield.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubDto> collect = clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
        return collect;
    }

    private ClubDto mapToClubDto(Club club) {
        ClubDto clubDto;
        clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();

        return clubDto;
    }
}
