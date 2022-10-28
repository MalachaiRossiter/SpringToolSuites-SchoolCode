package com.malachai.DojoAndNinja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malachai.DojoAndNinja.models.Dojo;
import com.malachai.DojoAndNinja.models.Ninja;
import com.malachai.DojoAndNinja.repositories.DojoRepository;
import com.malachai.DojoAndNinja.repositories.NinjaRepository;

@Service
public class AppService {
	@Autowired
	private NinjaRepository ninjaRepo;
	@Autowired
	private DojoRepository dojoRepo;
	
	public List<Dojo> allDojos(){
		return this.dojoRepo.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return this.dojoRepo.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return this.ninjaRepo.save(ninja);
	}
	
	public Dojo getOneDojo(Long id) {
		return this.dojoRepo.findById(id).orElse(null);
	}
}
