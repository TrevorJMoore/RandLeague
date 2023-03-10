package com.trevorjmoore.randleague.controllers;

import com.trevorjmoore.randleague.models.Champion;
import com.trevorjmoore.randleague.repositories.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league/champion")
public class ChampionController {

    @Autowired
    private ChampionRepository championRepository;

    @GetMapping("/{name}")
    public Champion getChampion(@PathVariable("name") String championName) {
        return championRepository.findByChampionNameIgnoreCase(championName);
    }

    @GetMapping("/all")
    public int getNumberCampions() {
        return (int)championRepository.count();
    }

}
