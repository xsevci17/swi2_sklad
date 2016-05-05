/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.ProductEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import cz.mendelu.seminar.swi.utils.DaoLayerException;
import cz.mendelu.seminar.swi.dao.IProduct;

/**
 *
 * @author pirochta.jiri@gmail.com
 */
@Repository
public class Product implements IProduct {

    @PersistenceContext
    private EntityManager entityManager;

	@Override
	public ProductEntity findById(int id)
	{
        try {
            return entityManager.find(ProductEntity.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
	}

	@Override
    public void save(ProductEntity product) {
        if (findById(product.getId_product()) != null) {
            try {
                entityManager.merge(product);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(product);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }
    }

	@Override
	public void delete(ProductEntity product) {
        try {
            entityManager.remove(findById(product.getId_product()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

	@Override
	public List<ProductEntity> findAll(){
        try {
            return entityManager.createQuery("select c from ProductEntity c", ProductEntity.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
}
