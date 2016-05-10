package cz.mendelu.seminar.swi.service;

import cz.mendelu.seminar.swi.exceptions.PokemonLeagueServiceException;
import cz.mendelu.seminar.swi.dao.Invoice;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhanak @domhanak on 11/25/15.
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Inject
    private Invoice invoice;

    @Override
    public void save(InvoiceEntity invent) {
        invoice.save(invent);
    }

    @Override
    public InvoiceEntity findById(int id) {
        return invoice.findById(id);
    }

    @Override
    public List<InvoiceEntity> findAll() {
        return invoice.findAll();
    }

    @Override
    public void delete(InvoiceEntity invent) {
        invoice.delete(invent);
    }
  
}
