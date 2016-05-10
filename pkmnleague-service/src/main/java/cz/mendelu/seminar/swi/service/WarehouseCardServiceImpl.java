package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import cz.mendelu.seminar.swi.dao.WarehouseCard;

import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;

/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class WarehouseCardServiceImpl implements WarehouseCardService {

    @Inject
    private WarehouseCard warehouseCard;

    @Override
    public void save(WarehouseCardEntity whcEnt) {
        warehouseCard.save(whcEnt);
    }

    @Override
    public WarehouseCardEntity findById(int id) {
        return warehouseCard.findById(id);
    }

    @Override
    public List<WarehouseCardEntity> findAll() {
        return warehouseCard.findAll();
    }

    @Override
    public void delete(WarehouseCardEntity whcEnt) {
        warehouseCard.delete(whcEnt);
    }
  
}
