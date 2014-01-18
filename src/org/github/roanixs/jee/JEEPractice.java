/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.roanixs.autocreate;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jocouma1
 */
public class JEEPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleAppShopPU");
        EntityManager em = emf.createEntityManager();
        
        Application app = new Application();
    
        app.setApplicationName("Test app");
        app.setApplicationReleaseDate(Calendar.getInstance().getTime());
        app.setApplicationVersion("1.0.0");
        app.setApplicationWebsite("http://google.com");
        
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
