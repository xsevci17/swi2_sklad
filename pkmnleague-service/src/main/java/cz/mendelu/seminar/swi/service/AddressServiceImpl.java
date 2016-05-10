package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import cz.mendelu.seminar.swi.dao.Address;
import cz.mendelu.seminar.swi.domain.AddressEntity;

/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Inject
    private Address address;

    @Override
    public void save(AddressEntity adent) {
        address.save(adent);
    }

    @Override
    public AddressEntity findById(int id) {
        return address.findById(id);
    }

    @Override
    public List<AddressEntity> findAll() {
        return address.findAll();
    }

    @Override
    public void delete(AddressEntity adent) {
        address.delete(adent);
    }
  
}
