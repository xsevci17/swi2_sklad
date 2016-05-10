package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import cz.mendelu.seminar.swi.dao.Product;

import cz.mendelu.seminar.swi.domain.ProductEntity;

/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Inject
    private Product product;

    @Override
    public void save(ProductEntity prodEnt) {
        product.save(prodEnt);
    }

    @Override
    public ProductEntity findById(int id) {
        return product.findById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return product.findAll();
    }

    @Override
    public void delete(ProductEntity prodEnt) {
        product.delete(prodEnt);
    }
  
}
