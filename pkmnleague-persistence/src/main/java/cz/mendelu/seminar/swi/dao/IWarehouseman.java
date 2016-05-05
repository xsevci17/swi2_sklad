/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.WarehousemanEntity;

/**
 * Data Access Object providing access to database operations for Warehouseman entity
 *
 * @author pirochta.jiri@gmail.com
* @author Peter Smatana
 */
public interface IWarehouseman
{
    /**
     * Finds Warehouseman by given ID (primary key)
	 * @param id
	 * @return 
     */
    WarehousemanEntity findById(int id);

    /**
     * Saves Warehouseman entity to database, can either update existing Warehouseman or save new one
	 * @param warehouseman
     */
    void save(WarehousemanEntity warehouseman);

    /**
     * Deletes given entity from database
	 * @param warehouseman
     */
    void delete(WarehousemanEntity warehouseman);

    /**
     * Returns all existing Warehouseman entities in database
	 * @return 
     */
    List<WarehousemanEntity> findAll();
}
