/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeepractice;

import java.util.Date;

/**
 *
 * @author jocouma1
 */
public class Member {
    
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
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
