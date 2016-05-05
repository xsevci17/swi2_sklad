/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.CustomerEntity;

/**
 * Data Access Object providing access to database operations for Customer entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface ICustomer
{
    /**
     * Finds Customer by given ID (primary key)
	 * @param id
	 * @return 
     */
    CustomerEntity findById(int id);

    /**
     * Saves Customer entity to database, can either update existing Customer or save new one
	 * @param customer
     */
    void save(CustomerEntity customer);

    /**
     * Deletes given entity from database
	 * @param customer
     */
    void delete(CustomerEntity customer);

    /**
     * Returns all existing Customer entities in database
	 * @return 
     */
    List<CustomerEntity> findAll();
}
