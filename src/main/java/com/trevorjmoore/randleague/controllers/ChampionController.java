package com.trevorjmoore.randleague.controllers;

import com.trevorjmoore.randleague.models.Champion;
import com.trevorjmoore.randleague.repositories.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@ResponseBody
public class ChampionController {

    @Autowired
    private ChampionRepository championRepository;

    @GetMapping("/league/champion/{name}")
    public List<Champion> getChampion(@PathVariable("name") String championName) {
        return championRepository.findByChampionName(championName);
    }

    @GetMapping("/league")
    public String getString() {
        return "Hello World!";
    }



}
