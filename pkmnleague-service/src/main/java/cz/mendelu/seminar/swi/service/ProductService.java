package cz.mendelu.seminar.swi.service;


import cz.mendelu.seminar.swi.dao.Address;
import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.ProductEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface ProductService {

    void save(ProductEntity product);

    ProductEntity findById(int id);

    List<ProductEntity> findAll();

    void delete(ProductEntity product);

   
}
