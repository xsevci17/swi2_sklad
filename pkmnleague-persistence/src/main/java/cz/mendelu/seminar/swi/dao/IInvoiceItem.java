/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import java.util.List;
import cz.mendelu.seminar.swi.domain.InvoiceItemEntity;

/**
 * Data Access Object providing access to database operations for InvoiceItem entity
 *
 * @author pirochta.jiri@gmail.com
 */
public interface IInvoiceItem
{
    /**
     * Finds InvoiceItem by given ID (primary key)
	 * @param id
	 * @return 
     */
    InvoiceItemEntity findById(int id);

    /**
     * Saves InvoiceItem entity to database, can either update existing InvoiceItem or save new one
	 * @param invoiceItem
     */
    void save(InvoiceItemEntity invoiceItem);

    /**
     * Deletes given entity from database
	 * @param invoiceItem
     */
    void delete(InvoiceItemEntity invoiceItem);

    /**
     * Returns all existing InvoiceItem entities in database
	 * @return 
     */
    List<InvoiceItemEntity> findAll();
}
