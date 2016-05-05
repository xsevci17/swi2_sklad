/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IItem;
import cz.mendelu.seminar.swi.domain.ItemEntity;
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
public class Item implements IItem {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public ItemEntity findById(int id)
	{
        try {
            return entityManager.find(ItemEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(ItemEntity item) {
        if (findById(item.getId_item()) != null) {
            try {
                entityManager.merge(item);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(item);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(ItemEntity item) {
        try {
            entityManager.remove(findById(item.getId_item()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<ItemEntity> findAll(){
        try {
            return entityManager.createQuery("select c from ItemEntity c", ItemEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
