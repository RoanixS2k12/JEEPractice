/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeepractice;

import java.net.URL;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.*;

/**
 *
 * @author jocouma1
 */
@Entity
public class Application {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "APPLICATION_ID", nullable = false)
    private int ID;
    
    @Basic(optional = false)
    @Column(name = "APPLICATION_NAME", nullable = false, length = 255)
    private String name;
    
    @Basic(optional = false)
    @Column(name = "APPLICATION_VERSION", nullable = false)
    private int version;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "APPLICATION_RLSDATE", nullable = false)
    private Date releaseDate;
    
    @Basic(optional = false)
    @Column(name = "APPLICATION_URL", nullable = false, length = 255)
    private URL website;

    public Application()
    {
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getVersion()
    {
        return version;
    }
    
    public void setVersion(int version)
    {
        this.version = version;
    }
    
    public Date getReleaseDate()
    {
        return releaseDate;
    }
    
    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }
    
    public URL getWebsite()
    {
        return website;
    }
    
    public void setWebsite(URL url)
    {
        this.website = url;
    }
    
}
