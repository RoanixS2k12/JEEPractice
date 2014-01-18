/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.github.roanixs.autocreate;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joani
 */
@Entity
@Table(name = "ADMINISTRATOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdministratorId", query = "SELECT a FROM Administrator a WHERE a.administratorId = :administratorId"),
    @NamedQuery(name = "Administrator.findByAdministratorUsername", query = "SELECT a FROM Administrator a WHERE a.administratorUsername = :administratorUsername"),
    @NamedQuery(name = "Administrator.findByAdministratorPassword", query = "SELECT a FROM Administrator a WHERE a.administratorPassword = :administratorPassword")})
public class Administrator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_ID")
    private Integer administratorId;
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_USERNAME")
    private String administratorUsername;
    @Basic(optional = false)
    @Column(name = "ADMINISTRATOR_PASSWORD")
    private String administratorPassword;

    public void addApplication(Application app, String platformName, String platformVersion)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("simpleAppShopPU");
        EntityManager em = emf.createEntityManager();

        Platform p = em.createNamedQuery("Platform.findByPlatformNameAndVersion", Platform.class)
                            .setParameter("platformName", platformName)
                            .setParameter("platformVersion", platformVersion)
                            .getSingleResult();

        if(p != null)
        {
            app.setApplicationPlatformId(p);

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

            System.out.println("Administrator adding application succeded");
        }
        else
        {
            System.out.println("Administrator couldn't add an app to the db");
        }

        em.close();
        emf.close();
    }

    public Administrator() {

    }

    public Administrator(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public Administrator(Integer administratorId, String administratorUsername, String administratorPassword) {
        this.administratorId = administratorId;
        this.administratorUsername = administratorUsername;
        this.administratorPassword = administratorPassword;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorUsername() {
        return administratorUsername;
    }

    public void setAdministratorUsername(String administratorUsername) {
        this.administratorUsername = administratorUsername;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administratorId != null ? administratorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.administratorId == null && other.administratorId != null) || (this.administratorId != null && !this.administratorId.equals(other.administratorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.github.roanixs.autocreate.Administrator[ administratorId=" + administratorId + " ]";
    }
    
}
