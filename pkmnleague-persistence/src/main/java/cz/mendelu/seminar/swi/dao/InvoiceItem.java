/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IInvoiceItem;
import cz.mendelu.seminar.swi.domain.InvoiceItemEntity;
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
public class InvoiceItem implements IInvoiceItem {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public InvoiceItemEntity findById(int id)
	{
        try {
            return entityManager.find(InvoiceItemEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(InvoiceItemEntity invoiceItem) {
        if (findById(invoiceItem.getId_invoiceItem()) != null) {
            try {
                entityManager.merge(invoiceItem);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(invoiceItem);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(InvoiceItemEntity invoiceItem) {
        try {
            entityManager.remove(findById(invoiceItem.getId_invoiceItem()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<InvoiceItemEntity> findAll(){
        try {
            return entityManager.createQuery("select c from InvoiceItemEntity c", InvoiceItemEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
