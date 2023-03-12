package com.trevorjmoore.randleague.controllers;

import com.trevorjmoore.randleague.models.Rune;
import com.trevorjmoore.randleague.repositories.RuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/league/rune")
public class RuneController {

    @Autowired
    private RuneRepository runeRepository;

    @GetMapping
    public List<Rune> getRunesByName(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="family", required = false) String family){
        //If the name and family parameters are filled out return the appropriate list
        if (Objects.nonNull(name) && Objects.nonNull(family))
             return runeRepository.findByRuneNameIgnoreCaseAndRuneFamilyIgnoreCase(name, family);
        //Return the appropriate list if either name or family parameter is filled out
        List<Rune> runeList = Objects.nonNull(name) ?
                runeRepository.findByRuneNameIgnoreCase(name) :
                runeRepository.findByRuneFamilyIgnoreCase(family);
        return runeList;
    }

}
