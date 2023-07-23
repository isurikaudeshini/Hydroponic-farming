
/*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author AS2019576
 */
public abstract class Plant {
    private String plantName;
    private long growingDuration;
    private long croppingInterval;
    private long lifetime;
    private Date dateOfHarvest;
    ArrayList<Harvest> harvests = new ArrayList<>();

    public Plant(String plantName, int growingDuration, int croppingInterval, int lifetime) {
        this.plantName = plantName;
        this.growingDuration = growingDuration;
        this.croppingInterval = croppingInterval;
        this.lifetime = lifetime;
    }

    public long getLifetime() {
        return lifetime;
    }

    public String getPlantName() {
        return plantName;
    }

    public long getGrowingDuration() {
        return growingDuration;
    }

    public long getCroppingInterval() {
        return croppingInterval;
    }

    public Date getDateOfHarvest() {
        return dateOfHarvest;
    }

    public ArrayList<Harvest> getHarvests() {
        return harvests;
    }

    
    
  

    @Override
    public String toString(){
        String msg;
        msg=" Plant Name: " +getPlantName();
        msg+=" Growing Duration " +getGrowingDuration() +" Days ";
        msg+=" Cropping Interval " +getCroppingInterval() +" Days ";
        msg+=" Life Time " +getCroppingInterval() +" Day s ";
        msg+=harvests.toString();
        
        return msg;
    }
    
   
    
}
