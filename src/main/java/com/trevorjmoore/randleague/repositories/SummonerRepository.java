package com.trevorjmoore.randleague.repositories;

import com.trevorjmoore.randleague.models.Summoner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SummonerRepository extends CrudRepository<Summoner, Integer> {

    public List<Summoner> findBySummonerNameIgnoreCase(String name);

}
