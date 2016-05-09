/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;


import cz.mendelu.seminar.swi.domain.IssueSlipEntity;
import cz.mendelu.seminar.swi.domain.ItemEntity;
import cz.mendelu.seminar.swi.domain.ProductEntity;
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
public class ItemTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IItem iitem;
	
    @Test
    public void testSave() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());
		ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");
		ItemEntity itemEntity = new ItemEntity(issueSlip, productEntity, "Unit", 20.0, "Item Nane");
	  
	iitem.save(itemEntity);
	   
	ItemEntity result = iitem.findById(itemEntity.getId_item());
        assertEquals(itemEntity, result);

        
        itemEntity.setUnit("Unit");
        iitem.save(itemEntity);

        ItemEntity resultUpdate = iitem.findById(itemEntity.getId_item());
        assertEquals(resultUpdate.getUnit(), "Unit");
    }
	
    @Test
    public void testDelete() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());
		ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");
		ItemEntity itemEntity = new ItemEntity(issueSlip, productEntity, "Unit", 20.0, "Item Nane");

        iitem.save(itemEntity);
        iitem.delete(itemEntity);

        assertEquals(0, iitem.findAll().size());
    }
	
	  
   @Test
   public void testFindAll() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());
		ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");
		ItemEntity itemEntity = new ItemEntity(issueSlip, productEntity, "Unit", 20.0, "Item Nane");

        iitem.save(itemEntity);

        assertEquals(1, iitem.findAll().size());
    }
}
