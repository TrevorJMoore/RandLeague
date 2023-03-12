package com.trevorjmoore.randleague.repositories;

import com.trevorjmoore.randleague.models.Rune;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RuneRepository extends CrudRepository<Rune, Integer> {

    //Basic searches
    public List<Rune> findByRuneNameIgnoreCase(String name);
    public List<Rune> findByRuneFamilyIgnoreCase(String family);
    //Complex searches
    public List<Rune> findByRuneNameIgnoreCaseAndRuneFamilyIgnoreCase(String name, String family);

}
