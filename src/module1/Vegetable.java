
 /*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;

/**
 *
 * @author AS2019576
 */
public class Vegetable extends Plant{
    private float area;
    private float thickness;
    private boolean status = false;

    public Vegetable(String plantName, int growingDuration, int croppingInterval, int lifetime, float area, float thickness) {
        super(plantName, growingDuration, croppingInterval, lifetime);
        this.area = area;
        this.thickness = thickness;
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
     
      public boolean isStatus() {
        return status;
    }
    
@Override
    public String toString(){
        String msg;
        msg=super.toString();
        msg+=" Standard area per leaf" +getArea() +" mm^2";
        msg+=" Standard thickness" +getThickness() + " mm " +"\n";
       
        
        return msg;
    }

    public float getArea() {
        return area;
    }

    public float getThickness() {
        return thickness;
    }
}
