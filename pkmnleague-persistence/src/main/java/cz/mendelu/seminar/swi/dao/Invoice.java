/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IInvoice;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cz.mendelu.seminar.swi.utils.DaoLayerException;

/**
 *
 * @author pirochta.jiri@gmail.com
 */
@Repository
public class Invoice implements IInvoice {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public InvoiceEntity findById(int id)
	{
        try {
            return entityManager.find(InvoiceEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(InvoiceEntity invoice) {
        if (findById(invoice.getId_invoice()) != null) {
            try {
                entityManager.merge(invoice);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(invoice);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(InvoiceEntity invoice) {
        try {
            entityManager.remove(findById(invoice.getId_invoice()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<InvoiceEntity> findAll(){
        try {
            return entityManager.createQuery("select c from InvoiceEntity c", InvoiceEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
