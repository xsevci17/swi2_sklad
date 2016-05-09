package cz.fi.muni.pa165.seminar.pkmnleague.service;


import cz.mendelu.seminar.swi.dao.Address;
import cz.mendelu.seminar.swi.domain.AddressEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface AddressService {

    void save(AddressEntity adent);

    AddressEntity findById(int id);

    List<AddressEntity> findAll();

    void delete(AddressEntity adent);

   
}
