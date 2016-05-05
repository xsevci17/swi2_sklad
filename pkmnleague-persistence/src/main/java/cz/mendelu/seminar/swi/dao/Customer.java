/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.ICustomer;
import cz.mendelu.seminar.swi.domain.CustomerEntity;
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
public class Customer implements ICustomer {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public CustomerEntity findById(int id)
	{
        try {
            return entityManager.find(CustomerEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(CustomerEntity customer) {
        if (findById(customer.getId_customer()) != null) {
            try {
                entityManager.merge(customer);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(customer);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(CustomerEntity customer) {
        try {
            entityManager.remove(findById(customer.getId_customer()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<CustomerEntity> findAll(){
        try {
            return entityManager.createQuery("select c from CustomerEntity c", CustomerEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
