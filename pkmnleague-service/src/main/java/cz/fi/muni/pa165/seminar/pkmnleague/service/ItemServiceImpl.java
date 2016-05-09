package cz.fi.muni.pa165.seminar.pkmnleague.service;

import cz.fi.muni.pa165.seminar.pkmnleague.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.Item;
import cz.mendelu.seminar.swi.domain.ItemEntity;


import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Inject
    private Item item;

    @Override
    public void save(ItemEntity itemEnt) {
        item.save(itemEnt);
    }

    @Override
    public ItemEntity findById(int id) {
        return item.findById(id);
    }

    @Override
    public List<ItemEntity> findAll() {
        return item.findAll();
    }

    @Override
    public void delete(ItemEntity itemEnt) {
        item.delete(itemEnt);
    }
  
}
