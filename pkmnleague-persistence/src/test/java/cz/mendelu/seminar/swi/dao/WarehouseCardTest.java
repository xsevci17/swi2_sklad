/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;


import cz.mendelu.seminar.swi.domain.WarehouseCardEntity;
import cz.mendelu.seminar.swi.domain.WarehousemanEntity;
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
public class WarehouseCardTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IWarehouseCard iwarehouseCard;
	
    @Test
    public void testSave() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
	  
	iwarehouseCard.save(wareCard);
	   
	WarehouseCardEntity result = iwarehouseCard.findById(wareCard.getId_warehouseCard());
        assertEquals(wareCard, result);

        Date tmpDate = new Date();
        wareCard.setDateOfCreation(tmpDate);
        iwarehouseCard.save(wareCard);

        WarehouseCardEntity resultUpdate = iwarehouseCard.findById(wareCard.getId_warehouseCard());
        assertEquals(resultUpdate.getDateOfCreation(), tmpDate);
    }
	
    @Test
    public void testDelete() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());

        iwarehouseCard.save(wareCard);
        iwarehouseCard.delete(wareCard);

        assertEquals(0, iwarehouseCard.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());

        iwarehouseCard.save(wareCard);

        assertEquals(1, iwarehouseCard.findAll().size());
    }
}
