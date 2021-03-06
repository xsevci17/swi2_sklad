/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;


import cz.mendelu.seminar.swi.domain.IssueSlipEntity;
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
 * @author pirochta.jiri@gmail.com
 * @author Vít
 */
@ContextConfiguration(classes = EmbeddedDerbyDatabase.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class IssueSlipTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IIssueSlip iissueslip;
	
    @Test
    public void testSave() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());
	  
	iissueslip.save(issueSlip);
	   
	IssueSlipEntity result = iissueslip.findById(issueSlip.getId_issueSlip());
        assertEquals(issueSlip, result);

        Date tmpDate = new Date();
        
        issueSlip.setDateOfCreation(tmpDate);
        iissueslip.save(issueSlip);

        IssueSlipEntity resultUpdate = iissueslip.findById(issueSlip.getId_issueSlip());
        assertEquals(resultUpdate.getDateOfCreation(), tmpDate);
	
    }
	
    @Test
    public void testDelete() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());

        iissueslip.save(issueSlip);
        iissueslip.delete(issueSlip);

        assertEquals(0, iissueslip.findAll().size());
        
    }
	
	  
   @Test
   public void testFindAll() {
		WarehousemanEntity wareMan = new WarehousemanEntity(new Date(), new Date());
        WarehouseCardEntity wareCard = new WarehouseCardEntity(wareMan,new Date());
        IssueSlipEntity issueSlip = new IssueSlipEntity(wareCard, wareMan,new Date());

        iissueslip.save(issueSlip);

        assertEquals(1, iissueslip.findAll().size());
        
    }
}

