package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.Person;
import cz.mendelu.seminar.swi.domain.PersonEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Inject
    private Person person;

    @Override
    public void save(PersonEntity perEnt) {
        person.save(perEnt);
    }

    @Override
    public PersonEntity findById(int id) {
        return person.findById(id);
    }

    @Override
    public List<PersonEntity> findAll() {
        return person.findAll();
    }

    @Override
    public void delete(PersonEntity perEnt) {
        person.delete(perEnt);
    }
  
}
