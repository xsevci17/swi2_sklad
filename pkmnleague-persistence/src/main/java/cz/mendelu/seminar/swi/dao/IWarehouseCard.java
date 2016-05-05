/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;

/**
 * Data Access Object providing access to database operations for WarehouseCard entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IWarehouseCard
{
    /**
     * Finds WarehouseCard by given ID (primary key)
	 * @param id
	 * @return 
     */
    WarehouseCardEntity findById(int id);

    /**
     * Saves WarehouseCard entity to database, can either update existing WarehouseCard or save new one
	 * @param warehouseCard
     */
    void save(WarehouseCardEntity warehouseCard);

    /**
     * Deletes given entity from database
	 * @param warehouseCard
     */
    void delete(WarehouseCardEntity warehouseCard);

    /**
     * Returns all existing WarehouseCard entities in database
	 * @return 
     */
    List<WarehouseCardEntity> findAll();
}
