package cz.mendelu.seminar.swi.service;


import cz.mendelu.seminar.swi.domain.PersonEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface PersonService {

    void save(PersonEntity person);

    PersonEntity findById(int id);

    List<PersonEntity> findAll();

    void delete(PersonEntity person);

   
}
