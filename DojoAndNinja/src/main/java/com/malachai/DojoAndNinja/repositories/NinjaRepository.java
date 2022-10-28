package com.malachai.DojoAndNinja.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.malachai.DojoAndNinja.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>  {
	
}
