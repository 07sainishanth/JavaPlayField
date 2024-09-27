package com.trailmvc.webserverplayfield.service;

import com.trailmvc.webserverplayfield.dto.ClubDto;
import com.trailmvc.webserverplayfield.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubByID(long clubID);

    void updateClub(ClubDto clubDto);

    void delete(Long clubId);

    List<ClubDto> searchClubs(String query);
}
