package com.trevorjmoore.randleague.controllers;

import com.trevorjmoore.randleague.repositories.ItemRepository;
import com.trevorjmoore.randleague.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;


    //Update/create parameter searching within method to obtain correct result.
    @GetMapping
    public List<Item> getItems(
            @RequestParam(name="name", required=false) String name,
            @RequestParam(name="cost", required = false) Integer cost) {
        return itemRepository.findByItemNameIgnoreCase(name);
    }

}
