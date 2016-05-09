/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import cz.mendelu.seminar.swi.utils.EmbeddedDerbyDatabase;
import java.util.Date;

import static org.junit.Assert.*;

/**
 *
 * @author Vít
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CustomerTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private ICustomer icustomer;
	
	
    @Test
    public void testSave() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);
	  
	icustomer.save(cust);
	   
	CustomerEntity result = icustomer.findById(cust.getId_customer());
        assertEquals(cust, result);

        cust.setICO(10);
        icustomer.save(cust);

        CustomerEntity resultUpdate = icustomer.findById(cust.getId_customer());
        assertEquals(resultUpdate.getICO(), 10); 
    }
	
    @Test
    public void testDelete() { 
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);

        icustomer.save(cust);
        icustomer.delete(cust);

        assertEquals(0, icustomer.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        CustomerEntity cust = new CustomerEntity(adr,"Brno","Hlavní",new Date(), 569);

        icustomer.save(cust);

        assertEquals(1, icustomer.findAll().size());
    }	
}

