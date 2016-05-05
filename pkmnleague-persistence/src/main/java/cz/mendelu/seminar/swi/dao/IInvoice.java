/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;

/**
 * Data Access Object providing access to database operations for Invoice entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IInvoice
{
    /**
     * Finds Invoice by given ID (primary key)
	 * @param id
	 * @return 
     */
    InvoiceEntity findById(int id);

    /**
     * Saves Invoice entity to database, can either update existing Invoice or save new one
	 * @param invoice
     */
    void save(InvoiceEntity invoice);

    /**
     * Deletes given entity from database
	 * @param invoice
     */
    void delete(InvoiceEntity invoice);

    /**
     * Returns all existing Invoice entities in database
	 * @return 
     */
    List<InvoiceEntity> findAll();
}
