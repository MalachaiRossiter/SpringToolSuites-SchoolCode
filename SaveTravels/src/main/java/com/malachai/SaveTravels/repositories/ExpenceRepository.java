package com.malachai.saveTravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malachai.saveTravels.models.Expence;

@Repository
public interface ExpenceRepository extends CrudRepository<Expence, Long>{
	List<Expence> findAll();
	
	Optional<Expence> findOneById(Long id);
}
