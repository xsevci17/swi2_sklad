/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.CustomerEntity;
import cz.mendelu.seminar.swi.domain.InvoiceEntity;
import cz.mendelu.seminar.swi.domain.InvoiceItemEntity;
import cz.mendelu.seminar.swi.domain.ProductEntity;
import cz.mendelu.seminar.swi.utils.EmbeddedDerbyDatabase;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author pirochta.jiri@gmail.com
 * @author Vít
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class InvoiceItemTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IInvoiceItem iinvoiceitem;
	
    @Test
    public void testSave() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity inv = new InvoiceEntity(cust, new Date());
        ProductEntity prod = new ProductEntity("Title","type","Desc");
        InvoiceItemEntity invoice = new InvoiceItemEntity(inv, prod, "Unit", 50.0, "description");
	  
	iinvoiceitem.save(invoice);
	   
	InvoiceItemEntity result = iinvoiceitem.findById(invoice.getId_invoiceItem());
        assertEquals(invoice, result);

        invoice.setUnit("Unit");
        iinvoiceitem.save(invoice);

        InvoiceItemEntity resultUpdate = iinvoiceitem.findById(invoice.getId_invoiceItem());
        assertEquals(resultUpdate.getUnit(), "Unit");
	  
    }
	
    @Test
    public void testDelete() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity inv = new InvoiceEntity(cust, new Date());
        ProductEntity prod = new ProductEntity("Title","type","Desc");
        InvoiceItemEntity invoice = new InvoiceItemEntity(inv, prod, "Unit", 50.0, "description");

        iinvoiceitem.save(invoice);
        iinvoiceitem.delete(invoice);

        assertEquals(0, iinvoiceitem.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
        InvoiceEntity inv = new InvoiceEntity(cust, new Date());
        ProductEntity prod = new ProductEntity("Title","type","Desc");
        InvoiceItemEntity invoice = new InvoiceItemEntity(inv, prod, "Unit", 50.0, "description");

        iinvoiceitem.save(invoice);

        assertEquals(1, iinvoiceitem.findAll().size());
    }
}

