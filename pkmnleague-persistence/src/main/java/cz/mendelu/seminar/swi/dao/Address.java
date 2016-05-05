/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;
 
import cz.mendelu.seminar.swi.dao.IAddress;
import cz.mendelu.seminar.swi.domain.AddressEntity;
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
public class Address implements IAddress {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public AddressEntity findById(int id)
	{
        try {
            return entityManager.find(AddressEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(AddressEntity address) {
        if (findById(address.getId_address()) != null) {
            try {
                entityManager.merge(address);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(address);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(AddressEntity address) {
        try {
            entityManager.remove(findById(address.getId_address()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<AddressEntity> findAll(){
        try {
            return entityManager.createQuery("select b from AddressEntity b", AddressEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
