/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IWarehouseCard;
import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;
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
public class WarehouseCard implements IWarehouseCard {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public WarehouseCardEntity findById(int id)
	{
        try {
            return entityManager.find(WarehouseCardEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(WarehouseCardEntity warehouseCard) {
        if (findById(warehouseCard.getId_warehouseCard()) != null) {
            try {
                entityManager.merge(warehouseCard);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(warehouseCard);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(WarehouseCardEntity warehouseCard) {
        try {
            entityManager.remove(findById(warehouseCard.getId_warehouseCard()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<WarehouseCardEntity> findAll(){
        try {
            return entityManager.createQuery("select c from WarehouseCardEntity c", WarehouseCardEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
