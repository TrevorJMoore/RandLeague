package com.trevorjmoore.randleague.repositories;

import com.trevorjmoore.randleague.models.Item;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    //Item has name, description, cost, and isMythic

    //Single searches
    public List<Item> findByItemName(String name);
    public List<Item> findByItemDescription(String description);
    public List<Item> findByItemCost(Integer cost);
    public List<Item> findByIsMythic(Boolean isMythic);

    //Multi searches
    public List<Item> findByItemNameAndItemCost(String name, Integer cost);
    public List<Item> findByItemNameAndIsMythic(String name, Boolean isMythic);


}
