package com.jerome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jerome.model.Podium;

public interface PodiumRepository extends CrudRepository<Podium, Long> {
	
	List<Podium> findByName(String name);

	@Query("Select p from Podium p where ROWNUM <=3 order by p.numberOfVotes DESC")
    public List<Podium> voteRank();

}
