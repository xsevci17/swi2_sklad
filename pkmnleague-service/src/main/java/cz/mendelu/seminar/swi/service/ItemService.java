package cz.mendelu.seminar.swi.service;


import cz.mendelu.seminar.swi.dao.Address;
import cz.mendelu.seminar.swi.domain.ItemEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface ItemService {

    void save(ItemEntity item);

    ItemEntity findById(int id);

    public List<ItemEntity> findAll();

    void delete(ItemEntity item);

   
}
