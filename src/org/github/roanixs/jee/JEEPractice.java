/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.roanixs.jee;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.github.roanixs.autocreate.Administrator;
import org.github.roanixs.autocreate.Application;
import org.github.roanixs.autocreate.Platform;

/**
 *
 * @author jocouma1
 */
public class JEEPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        JEEPractice jee = new JEEPractice();
        
        jee.testAddAdmin();
       
    }
    
    
    public void testAddAdmin()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleAppShopPU");
        EntityManager em = emf.createEntityManager();
        
        Administrator admin = new Administrator();
        admin.setAdministratorId(Integer.MIN_VALUE);
        admin.setAdministratorUsername("Administrator");
        admin.setAdministratorPassword("terminator");
        
        em.getTransaction().begin();
        
        try 
        {
            em.persist(admin);
            System.out.println("Admin persist ok");
        }
        catch (EntityExistsException e)
        {
            e.printStackTrace();
        }
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
    public void testAddMember()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleAppShopPU");
        EntityManager em = emf.createEntityManager();
    }
    
    public void testAddApp()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleAppShopPU");
        EntityManager em = emf.createEntityManager();
    
        
        Platform p = em.find(Platform.class, 1);
        Application app = new Application();
    
        app.setApplicationName("Test app");
        app.setApplicationReleaseDate(Calendar.getInstance().getTime());
        app.setApplicationVersion("1.0.0");
        app.setApplicationWebsite("http://google.com");
        app.setApplicationPlatformId(p);
        app.setApplicationId(Integer.MIN_VALUE);
        
        em.getTransaction().begin();
        
        try
        {
            em.persist(app);
            System.out.println("Application now in persistence");
        }
        catch(EntityExistsException e)
        {
            System.out.println("App already exists");
            em.getTransaction().rollback();
        }
        
        em.getTransaction().commit();
        
        em.close();
        emf.close(); 
    
    }
    
}
