/*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author AS2019576
 */
public class Batch {
    private int batchNumber=0;
    private int batchdays;
    private LocalDate dateOfPlanted;
    ArrayList<Fruit> fruits = new ArrayList<>();
    ArrayList<Vegetable> vegetables = new ArrayList<>();

    public Batch(LocalDate dateOfPlanted, ArrayList<Fruit> fruits, ArrayList<Vegetable> vegetables) {
        
        
        this.dateOfPlanted = dateOfPlanted;
        this.fruits=fruits;
        this.vegetables=vegetables;
        batchNumber++;
    }

  
    

    public LocalDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public int getBatchdays() {
        return batchdays;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }
    
    
    
    
    public void findEndOfBatch(){
        int max1 = (int)(fruits.get(0).getLifetime());
        int max2 = (int)(vegetables.get(0).getLifetime());
        
         
        for (int i = 1; i < fruits.size(); i++) { 		      
          if(max1<fruits.get(i).getLifetime()){
              max1=(int) fruits.get(i).getLifetime();
          }
          
          if(max2<fruits.get(i).getLifetime()){
              max2=(int) fruits.get(i).getLifetime();
          }
          
      }   
        
        if(max1 > max2)
           batchdays=max1;
        else if(max1==max2)
            batchdays = max1;
        else
            batchdays = max2;
    }
    
    
    @Override
    public String toString(){
        String msg;
        msg=" Batch Number: " +getBatchNumber();
        msg+=" Batch Days " +getBatchdays() +"Days ";
        msg+=" Batch Planted Date " +getDateOfPlanted() +"\n";
        msg+=" fruit list " + fruits.toString() +"\n";
        msg+=" vegetable List" + vegetables.toString();
        
        return msg;
    }
}
