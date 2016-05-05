/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.ItemEntity;

/**
 * Data Access Object providing access to database operations for Item entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IItem
{
    /**
     * Finds Item by given ID (primary key)
	 * @param id
	 * @return 
     */
    ItemEntity findById(int id);

    /**
     * Saves Item entity to database, can either update existing Item or save new one
	 * @param item
     */
    void save(ItemEntity item);

    /**
     * Deletes given entity from database
	 * @param item
     */
    void delete(ItemEntity item);

    /**
     * Returns all existing Item entities in database
	 * @return 
     */
    List<ItemEntity> findAll();
}
