package com.malachai.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malachai.saveTravels.models.Expence;
import com.malachai.saveTravels.repositories.ExpenceRepository;

@Service
public class ExpenceService {
	@Autowired
	private ExpenceRepository expenceRepo;
	
	public Expence createExpence(Expence u) {
		return expenceRepo.save(u);
	}
	
	public List<Expence> getAll(){
		return expenceRepo.findAll();
	}
	
	public Expence getOne(Long id) {
		Optional<Expence> expence = expenceRepo.findOneById(id);
		if (expence.isPresent()) {
			return expence.get();
		}
		else return null;
	}
	
	public Expence updateExpence(Expence u) {
		return expenceRepo.save(u);
	}
	
	public void deleteExpence(Long id) {
		expenceRepo.deleteById(id);
	}
}
