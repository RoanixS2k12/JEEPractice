/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeepractice;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jocouma1
 */
@Entity
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberId;
    
    @Basic(optional = false)
    @Column(name = "MEMBER_USERNAME", nullable = false)
    private String username;
    
    @Basic(optional = false)
    @Column(name = "MEMBER_PASSWORD", nullable = false)
    private String password;
    
    @Basic(optional = false)
    @Column(name = "MEMBER_EMAIL", nullable = false)
    private String email;
    
    @Basic(optional = false)
    @Column(name = "MEMBER_FIRSTNAME", nullable = false)
    private String firstName;
    
    @Basic(optional = false)
    @Column(name = "MEMBER_LASTNAME", nullable = false)
    private String lastName;
    
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "MEMBER_BIRTHDATE", nullable = false)
    private Date birthDate;
    
    public Member()
    {
        
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String firstname)
    {
        this.firstName = firstname;
    }
    
    public String getLastname()
    {
        return lastName;
    }
    
    public void setLastname(String lastname)
    {
        this.lastName = lastname;
    }
    
    
    
    
}
