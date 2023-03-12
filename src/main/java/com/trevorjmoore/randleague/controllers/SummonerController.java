package com.trevorjmoore.randleague.controllers;


import com.trevorjmoore.randleague.models.Summoner;
import com.trevorjmoore.randleague.repositories.SummonerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/league/summoner")
public class SummonerController {
    private SummonerRepository summonerRepository;

    @GetMapping
    public List<Summoner> getSummonerByName(@RequestParam(name="name", required=false) String name) {
        try {
            return summonerRepository.findBySummonerNameIgnoreCase(name);
        } catch (java.lang.NullPointerException ex) {
            return null;
        }
    }

}
