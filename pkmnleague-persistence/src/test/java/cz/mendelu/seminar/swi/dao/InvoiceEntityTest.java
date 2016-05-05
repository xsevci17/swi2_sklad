/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;
import cz.mendelu.seminar.swi.domain.CustomerEntity;
import cz.mendelu.seminar.swi.utils.EmbeddedDerbyDatabase;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

/**
 *
 * @author Vít
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class InvoiceEntityTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IInvoice iinvoice;
	
    @Test
    public void testSave() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity invoice = new InvoiceEntity(cust, new Date());
	  
	iinvoice.save(invoice);
	   
	InvoiceEntity result = iinvoice.findById(invoice.getId_invoice());
        assertEquals(invoice, result);

        Date tmpDate = new Date();
        
        invoice.setDateOfCreation(tmpDate);
        iinvoice.save(invoice);

        InvoiceEntity resultUpdate = iinvoice.findById(invoice.getId_invoice());
        assertEquals(resultUpdate.getDateOfCreation(), tmpDate);
	  
    }
	
    @Test
    public void testDelete() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity invoice = new InvoiceEntity(cust, new Date());

        iinvoice.save(invoice);
        iinvoice.delete(invoice);

        assertEquals(0, iinvoice.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity invoice = new InvoiceEntity(cust, new Date());

        iinvoice.save(invoice);

        assertEquals(1, iinvoice.findAll().size());
    }
}
