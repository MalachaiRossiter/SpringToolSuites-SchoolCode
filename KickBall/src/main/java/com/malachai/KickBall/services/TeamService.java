package com.malachai.KickBall.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malachai.KickBall.models.Team;
import com.malachai.KickBall.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	
	public Team findById(Long id) {
		Optional<Team> result = teamRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	
	public List<Team> getAll(){
		return teamRepo.findAll();
	}
	
	public Team update(Team team) {
		return teamRepo.save(team);
	}
	
	public Team create(Team team) {
		return teamRepo.save(team);
	}
	
	public void delete(Long id) {
		teamRepo.deleteById(id);
	}
}
