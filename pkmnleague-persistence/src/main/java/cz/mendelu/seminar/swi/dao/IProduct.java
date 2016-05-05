/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.ProductEntity;

/**
 * Data Access Object providing access to database operations for Product entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IProduct
{
    /**
     * Finds Product by given ID (primary key)
	 * @param id
	 * @return 
     */
    ProductEntity findById(int id);

    /**
     * Saves Product entity to database, can either update existing Product or save new one
	 * @param product
     */
    void save(ProductEntity product);

    /**
     * Deletes given entity from database
	 * @param product
     */
    void delete(ProductEntity product);

    /**
     * Returns all existing Product entities in database
	 * @return 
     */
    List<ProductEntity> findAll();
}
