package com.trevorjmoore.randleague.controllers;

import com.trevorjmoore.randleague.repositories.ItemRepository;
import com.trevorjmoore.randleague.models.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;


    //Update/create parameter searching within method to obtain correct result.
    @GetMapping("/league/item")
    public List<Item> getItems(
            @RequestParam(name="name", required=false) String name,
            @RequestParam(name="cost", required = false) Integer cost) {
        System.out.println("I have received the blessed name of: " + name);
        return itemRepository.findByItemNameIgnoreCase(name);
    }

}
