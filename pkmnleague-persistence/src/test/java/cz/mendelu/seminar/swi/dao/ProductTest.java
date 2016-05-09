/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.dao;

import cz.mendelu.seminar.swi.domain.ProductEntity;
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
public class ProductTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private IProduct iproduct;
	
	
    @Test
    public void testSave() {
        ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");
	  
        iproduct.save(productEntity);
	  
        ProductEntity result = iproduct.findById(productEntity.getId_product());
        assertEquals(productEntity, result);

        
        productEntity.setTitle("title");
        iproduct.save(productEntity);

        ProductEntity resultUpdate = iproduct.findById(productEntity.getId_product());
        assertEquals(resultUpdate.getTitle(), "title");	  
    }
	
    @Test
    public void testDelete() { 
        ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");

        iproduct.save(productEntity);
        iproduct.delete(productEntity);

        assertEquals(0, iproduct.findAll().size());
    }
	
	  
    @Test
   public void testFindAll() {
        ProductEntity productEntity = new ProductEntity("ProductTitle","ProductType","productdescription");

        iproduct.save(productEntity);

        assertEquals(1, iproduct.findAll().size());
    }
	
	
}
