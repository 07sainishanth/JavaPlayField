package com.trailmvc.webserverplayfield.service;

import com.trailmvc.webserverplayfield.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
