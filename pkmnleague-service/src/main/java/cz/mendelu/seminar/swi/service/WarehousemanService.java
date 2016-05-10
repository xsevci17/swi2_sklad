package cz.mendelu.seminar.swi.service;


import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;
import cz.mendelu.seminar.swi.domain.WarehousemanEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface WarehousemanService {

    void save(WarehousemanEntity warehouseman);

    WarehousemanEntity findById(int id);

    List<WarehousemanEntity> findAll();

    void delete(WarehousemanEntity warehouseman);

   
}
