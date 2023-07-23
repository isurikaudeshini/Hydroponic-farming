
 /*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;

/**
 *
 * @author AS2019576
 */
public class Fruit extends Plant{
    private float volume;
    private int color;
    private int phValue;
    private boolean status = false;

    

    public Fruit(String plantName, int growingDuration, int croppingInterval, int lifetime, float volume, int color,int phValue) {
        super(plantName, growingDuration, croppingInterval, lifetime);
        setVolume(volume);
        setColor(color);
        setPhValue(phValue);
        
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public boolean isStatus() {
        return status;
    }
    
    public void setPhValue(int phValue) {
        
        if(phValue >=0 || phValue <= 14 ){
        this.phValue = phValue;
        }
        else
            System.out.println("ph valuenshould be in range of 0-14");
    }

    public float getVolume() {
        return volume;
    }

    public int getColor() {
        return color;
    }

    public int getPhValue() {
        return phValue;
    }
        
//    public int getLifeTime() {
//        return getLifeTime();
//    }

    public void setColor(int color) {
        if(color >=0 || color <= 16777215 ){
        this.color = color;
        }
        else
            System.out.println("color value should be in range of 0-16777215");
    }

    
    public void addHarvest(LocalDate harvestDate,float harvestWeight, LocalDate dateOfPlanted){
        LocalDate possibleDateHarvest = dateOfPlanted.plusDays(getGrowingDuration());
        LocalDate lastPossibleDate = dateOfPlanted.plusDays(getLifetime());
        
        int maxCrops = (int)((getLifetime()-getGrowingDuration())/getCroppingInterval());
        
        if(harvestDate.isBefore(possibleDateHarvest)){
            status = true;
        }
        
        if(harvestDate.isAfter(possibleDateHarvest) && harvestDate.isBefore(lastPossibleDate) ){
            harvests.add(new Harvest(harvestWeight, harvestDate));
            possibleDateHarvest = possibleDateHarvest.plusDays(getCroppingInterval());
         }
        else{
            System.out.println("You cannot harvest on this date");
         }
            
        
    }

  
    @Override
    public String toString(){
        String msg;
        msg="\n";
        msg=super.toString();
        msg+=" Standard volume " +getVolume() +" mm^3 " ;
        msg+=" Standard Average color " +getColor();
        msg+=" ph value " +getPhValue() +"\n";
 
        
        return msg;
    }
    
    
}
