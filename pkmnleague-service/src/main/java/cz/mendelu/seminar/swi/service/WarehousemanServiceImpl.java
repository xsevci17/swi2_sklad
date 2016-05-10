package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.Warehouseman;
import cz.mendelu.seminar.swi.domain.WarehousemanEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;



/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class WarehousemanServiceImpl implements WarehousemanService {

    @Inject
    private Warehouseman warehouseman;

    @Override
    public void save(WarehousemanEntity whmEnt) {
        warehouseman.save(whmEnt);
    }

    @Override
    public WarehousemanEntity findById(int id) {
        return warehouseman.findById(id);
    }

    @Override
    public List<WarehousemanEntity> findAll() {
        return warehouseman.findAll();
    }

    @Override
    public void delete(WarehousemanEntity whmEnt) {
        warehouseman.delete(whmEnt);
    }
  
}
