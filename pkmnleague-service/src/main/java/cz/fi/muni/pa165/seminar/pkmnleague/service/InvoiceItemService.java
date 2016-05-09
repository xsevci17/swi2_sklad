package cz.fi.muni.pa165.seminar.pkmnleague.service;



import cz.mendelu.seminar.swi.domain.InvoiceItemEntity;
import java.util.List;

/**
 * An interface that defines a service access to the {@link Badge} entity.
 *
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
public interface InvoiceItemService {

    void save(InvoiceItemEntity invoiceItem);

    InvoiceItemEntity findById(int id);

    List<InvoiceItemEntity> findAll();

    void delete(InvoiceItemEntity invoiceItem);

   
}
