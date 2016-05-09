package cz.fi.muni.pa165.seminar.pkmnleague.service;


import cz.mendelu.seminar.swi.dao.Address;
import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.CustomerEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface CustomerService {

    void save(CustomerEntity customer);

    CustomerEntity findById(int id);

    public List<CustomerEntity> findAll();

    void delete(CustomerEntity customer);

   
}
