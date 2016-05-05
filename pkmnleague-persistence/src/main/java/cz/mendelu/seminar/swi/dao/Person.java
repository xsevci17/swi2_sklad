/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IPerson;
import cz.mendelu.seminar.swi.domain.PersonEntity;
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
public class Person implements IPerson {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public PersonEntity findById(int id)
	{
        try {
            return entityManager.find(PersonEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(PersonEntity person) {
        if (findById(person.getId_person()) != null) {
            try {
                entityManager.merge(person);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(person);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(PersonEntity person) {
        try {
            entityManager.remove(findById(person.getId_person()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<PersonEntity> findAll(){
        try {
            return entityManager.createQuery("select c from PersonEntity c", PersonEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
