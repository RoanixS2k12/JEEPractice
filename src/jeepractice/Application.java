/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeepractice;

import java.net.URL;
import java.util.Date;

/**
 *
 * @author jocouma1
 */
public class Application {
    
    private String name;
    
    private int version;
    
    private Date releaseDate;
    
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
