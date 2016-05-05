/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.AddressEntity;

/**
 * Data Access Object providing access to database operations for Address entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IAddress
{
    /**
     * Finds Address by given ID (primary key)
	 * @param id
	 * @return 
     */
    AddressEntity findById(int id);

    /**
     * Saves Address entity to database, can either update existing Address or save new one
	 * @param address
     */
    void save(AddressEntity address);

    /**
     * Deletes given entity from database
	 * @param address
     */
    void delete(AddressEntity address);

    /**
     * Returns all existing Address entities in database
	 * @return 
     */
    List<AddressEntity> findAll();
}
