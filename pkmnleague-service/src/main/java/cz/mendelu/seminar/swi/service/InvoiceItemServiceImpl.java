package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.Invoice;
import cz.mendelu.seminar.swi.dao.InvoiceItem;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;
import cz.mendelu.seminar.swi.domain.InvoiceItemEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Inject
    private InvoiceItem invoiceitem;

    @Override
    public void save(InvoiceItemEntity invitement) {
        invoiceitem.save(invitement);
    }

    @Override
    public InvoiceItemEntity findById(int id) {
        return invoiceitem.findById(id);
    }

    @Override
    public List<InvoiceItemEntity> findAll() {
        return invoiceitem.findAll();
    }

    @Override
    public void delete(InvoiceItemEntity invitement) {
        invoiceitem.delete(invitement);
    }
  
}
