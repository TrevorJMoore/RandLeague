package com.trevorjmoore.randleague.repositories;

import com.trevorjmoore.randleague.models.Champion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChampionRepository extends CrudRepository<Champion, Integer> {
    // Champion has Integer id, String name

    //Generic searches
    public Champion findByChampionNameIgnoreCase(String championName);



}
