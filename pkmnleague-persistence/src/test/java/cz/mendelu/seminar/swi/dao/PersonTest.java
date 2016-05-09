/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;


import cz.mendelu.seminar.swi.domain.AddressEntity;
import cz.mendelu.seminar.swi.domain.PersonEntity;
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
 * @author pirochta.jiri@gmail.com
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PersonTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IPerson iperson;
	
    @Test
    public void testSave() {
		AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        PersonEntity person = new PersonEntity(adr, "Name", "Surname", new Date());
	  
	iperson.save(person);
	   
	PersonEntity result = iperson.findById(person.getId_person());
        assertEquals(person, result);

        Date tmpDate = new Date();
        person.setDateOfBirth(tmpDate);
        iperson.save(person);

        PersonEntity resultUpdate = iperson.findById(person.getId_person());
        assertEquals(resultUpdate.getDateOfBirth(), tmpDate);
    }
	
    @Test
    public void testDelete() {
		AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        PersonEntity person = new PersonEntity(adr, "Name", "Surname", new Date());

        iperson.save(person);
        iperson.delete(person);

        assertEquals(0, iperson.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
		AddressEntity adr = new AddressEntity("Brno","Hlavní",44);
        PersonEntity person = new PersonEntity(adr, "Name", "Surname", new Date());

        iperson.save(person);

        assertEquals(1, iperson.findAll().size());
    }
}
