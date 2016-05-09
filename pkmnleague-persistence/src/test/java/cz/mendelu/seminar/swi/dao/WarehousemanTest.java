/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;


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
public class WarehousemanTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IWarehouseman iwarehouseman;
	
    @Test
    public void testSave() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
	  
	iwarehouseman.save(wareMan);
	   
	WarehousemanEntity result = iwarehouseman.findById(wareMan.getId_warehouseman());
        assertEquals(wareMan, result);

        Date tmpDate = new Date();
        wareMan.setEndDate(tmpDate);
        iwarehouseman.save(wareMan);

        WarehousemanEntity resultUpdate = iwarehouseman.findById(wareMan.getId_warehouseman());
        assertEquals(resultUpdate.getEndDate(), tmpDate);
    }
	
    @Test
    public void testDelete() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());

        iwarehouseman.save(wareMan);
        iwarehouseman.delete(wareMan);

        assertEquals(0, iwarehouseman.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());

        iwarehouseman.save(wareMan);

        assertEquals(1, iwarehouseman.findAll().size());
    }
}
