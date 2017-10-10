/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlazyfetch.jpa.openjpa;

import controllers.CustomerJpaController;
import controllers.DiscountCodeJpaController;
import controllers.ManufacturerJpaController;
import entita.Customer;
import entita.DiscountCode;
import entita.Manufacturer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mauro
 */
public class TestLazyFetchJPAOpenJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory EMF= Persistence.createEntityManagerFactory("JPA-OpenJPA-PU");
      
        DiscountCodeJpaController discontroller= new DiscountCodeJpaController(EMF);
          System.out.println("\n-------DiscountCode List --------\n");
        List<DiscountCode> list= discontroller.findDiscountCodeEntities();
      System.out.println("\n");
        for(DiscountCode discode:list) {
           System.out.println("discode="+discode);} 

        CustomerJpaController cuscontroller =  new CustomerJpaController(EMF);
                 System.out.println("\n-------customer List --------\n");

        List<Customer> list2= cuscontroller.findCustomerEntities();
       System.out.println("\n");
       for(Customer customer:list2) {
           System.out.println("customer="+customer);}  
       
       ManufacturerJpaController manufController= new ManufacturerJpaController(EMF);
        System.out.println("\n-------Manufacturer List --------\n");
         List<Manufacturer> list3= manufController.findManufacturerEntities();
       System.out.println("\n");
       for(Manufacturer manufacturer:list3) {
           System.out.println("manufacturer="+manufacturer);} 
    EMF.close();
    }
    
}
