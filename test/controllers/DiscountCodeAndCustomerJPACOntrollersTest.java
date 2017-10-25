/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entita.Customer;
import entita.DiscountCode;
import entita.PurchaseOrder;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mauro
 */
public class DiscountCodeAndCustomerJPACOntrollersTest {

    private static String NAME_PU = "JPA-OpenJPA-PU";
    private static EntityManagerFactory EMF = null;
    
    private DiscountCodeJpaController disController;
    private CustomerJpaController custController;

    public DiscountCodeAndCustomerJPACOntrollersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
  EMF = Persistence.createEntityManagerFactory(NAME_PU);
        System.out.println("\ninstanziato EMF= " + EMF+"\n");
   }

    
    @AfterClass
    public static void tearDownClass() {
       EMF.close(); }

    @Before
    public void setUp() {
 disController= new DiscountCodeJpaController(EMF);
         custController = new CustomerJpaController(EMF)  ;}

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
   public void testVerifySameDIscountCode()    {
   System.out.println("findDiscountCode");
        String id_discountcode = "L";
   
               DiscountCode result1 = disController.findDiscountCode(id_discountcode);
               assertNotNull(result1);
               int id_customer=3;
               Customer cust= this.custController.findCustomer(id_customer);
           assertNotNull(cust);
          DiscountCode result2= cust.getDiscountCode();
          assertNotNull(result2);
          assertEquals("i discountcode non corrispondono", result1, result2);
          List<Customer> listcutomers= this.custController.findCustomerEntities();
          assertTrue(listcutomers.contains(cust));
        List<PurchaseOrder> listPurchaseOrder=  cust.getPurchaseOrderList();
        assertNotNull("la lista ovviamente è nulla perchè si è tentato di recuperarlo da un customer detached", listPurchaseOrder);
            
  
   }
}
