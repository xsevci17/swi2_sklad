/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.dao.IWarehouseman;
import cz.mendelu.seminar.swi.domain.WarehousemanEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cz.mendelu.seminar.swi.utils.DaoLayerException;

/**
 *
 * @author pirochta.jiri@gmail.com
* @author Peter Smatana
 */
@Repository
public class Warehouseman implements IWarehouseman {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public WarehousemanEntity findById(int id)
	{
        try {
            return entityManager.find(WarehousemanEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(WarehousemanEntity warehouseman) {
        if (findById(warehouseman.getId_warehouseman()) != null) {
            try {
                entityManager.merge(warehouseman);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(warehouseman);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(WarehousemanEntity warehouseman) {
        try {
            entityManager.remove(findById(warehouseman.getId_warehouseman()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<WarehousemanEntity> findAll(){
        try {
            return entityManager.createQuery("select c from WarehousemanEntity c", WarehousemanEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
