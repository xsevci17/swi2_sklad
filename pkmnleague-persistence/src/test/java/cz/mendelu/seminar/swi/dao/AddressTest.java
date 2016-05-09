/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;
import cz.mendelu.seminar.swi.utils.EmbeddedDerbyDatabase;

import static org.junit.Assert.*;


/**
 *
 * @author Martin Záboj
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class AddressTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IAddress iaddress;
	
    @Test
    public void testSave() {
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
	  
	iaddress.save(adr);
	   
	AddressEntity result = iaddress.findById(adr.getId_address());
        assertEquals(adr, result);

        adr.setHouseNumber(10);
        iaddress.save(adr);

        AddressEntity resultUpdate = iaddress.findById(adr.getId_address());
        assertEquals(resultUpdate.getHouseNumber(), 10);	  
    }
	
    @Test
    public void testDelete() {      
        AddressEntity adr = new AddressEntity("Brno","Hlavní",44);

        iaddress.save(adr);
        iaddress.delete(adr);

        assertEquals(0, iaddress.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
       AddressEntity adr = new AddressEntity("Brno","Hlavní",44);

        iaddress.save(adr);

        assertEquals(1, iaddress.findAll().size());
    }
}
