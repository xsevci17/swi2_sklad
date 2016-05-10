package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import cz.mendelu.seminar.swi.dao.Customer;

import cz.mendelu.seminar.swi.domain.CustomerEntity;

/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private Customer customer;

    @Override
    public void save(CustomerEntity cusent) {
        customer.save(cusent);
    }

    @Override
    public CustomerEntity findById(int id) {
        return customer.findById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customer.findAll();
    }

    @Override
    public void delete(CustomerEntity cusent) {
        customer.delete(cusent);
    }
  
}
