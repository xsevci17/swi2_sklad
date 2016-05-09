package cz.fi.muni.pa165.seminar.pkmnleague.service;


import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface WarehouseCardService {

    void save(WarehouseCardEntity warehouseCard);

    WarehouseCardEntity findById(int id);

    List<WarehouseCardEntity> findAll();

    void delete(WarehouseCardEntity warehouseCard);

   
}
