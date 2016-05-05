/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.PersonEntity;

/**
 * Data Access Object providing access to database operations for Person entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IPerson
{
    /**
     * Finds Person by given ID (primary key)
	 * @param id
	 * @return 
     */
    PersonEntity findById(int id);

    /**
     * Saves Person entity to database, can either update existing Person or save new one
	 * @param person
     */
    void save(PersonEntity person);

    /**
     * Deletes given entity from database
	 * @param person
     */
    void delete(PersonEntity person);

    /**
     * Returns all existing Person entities in database
	 * @return 
     */
    List<PersonEntity> findAll();
}
