package cz.mendelu.seminar.swi.service;


import cz.mendelu.seminar.swi.domain.InvoiceEntity;

import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface InvoiceService {

    void save(InvoiceEntity invoice);

    InvoiceEntity findById(int id);

    List<InvoiceEntity> findAll();

    void delete(InvoiceEntity invoice);

   
}
