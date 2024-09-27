package com.trailmvc.webserverplayfield.service.impl;

import com.trailmvc.webserverplayfield.dto.ClubDto;
import com.trailmvc.webserverplayfield.mapper.ClubMapper;
import com.trailmvc.webserverplayfield.models.Club;
import com.trailmvc.webserverplayfield.models.UserEntity;
import com.trailmvc.webserverplayfield.repository.ClubRepository;
import com.trailmvc.webserverplayfield.repository.UserRepository;
import com.trailmvc.webserverplayfield.security.SecurityUtil;
import com.trailmvc.webserverplayfield.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.trailmvc.webserverplayfield.mapper.ClubMapper.mapToClub;
import static com.trailmvc.webserverplayfield.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private UserRepository userRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        List<ClubDto> collect = clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity userEntity = userRepository.findByUsername(username);
        Club club  = mapToClub(clubDto);
        club.setCreatedBy(userEntity);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubByID(long clubID) {
        Club club = clubRepository.findById(clubID).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity userEntity = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(userEntity);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
