/*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AS2019576
 */
public class Asii {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Fruit> fruits = new ArrayList<Fruit>(); 
    static ArrayList<Vegetable> vegetables = new ArrayList<Vegetable>();
    static ArrayList<Batch> batches = new ArrayList<Batch>();
    static Scanner obj = new Scanner(System.in);
    static Scanner obj1 = new Scanner(System.in);
    
    
    
    static void PrintMain(){
        System.out.println("%5s"," Hydroponic farming Management");
        System.out.println("Main Menu");
        System.out.println("1.Add a batch");
        System.out.println("2.Show batch details");
        System.out.println("3.View Plant Details");
        System.out.println("4.View All crop details");
        System.out.println("5.add harvest of a plant");
        
        
        fruits.add(new Fruit("apple", 30, 2, 50, 500, 9000, 3));
        fruits.add(new Fruit("Orange", 20, 2, 40, 400, 8000, 6));
        fruits.add(new Fruit("Mango", 18, 2, 30, 450, 8060, 5));
        fruits.get(0).addHarvest(LocalDate.MAX, 0, LocalDate.MIN);
        vegetables.add(new Vegetable("Gowa", 18, 2, 30, 300, 8));
        vegetables.add(new Vegetable("leaf", 32, 3, 40, 400, 2));
        
        LocalDate Mydate = LocalDate.of(2020, 1, 8);
        batches.add(new Batch(Mydate, fruits, vegetables));
        
      //  Batch b1 = new Batch(Mydate, fruits, vegetables);
        
       
    }
    
    
    public static void main(String[] args) {
          int choice = 0;
        do{
            PrintMain();
            choice = obj.nextInt();
            switch(choice){
                case 1:
                    addBatch();
                    break;
                case 2:
                    showBatchDetails();
                    break;
                case 3:
                     viewPlantList();
                    break;
                case 4:
                     viewAllCropDetails();
                    break;
                case 5:
                     addHarvestToSelectedPlant();
            }
        }while(choice !=6);
    }
    
    
    
    static void addFruit(){
        System.out.println("Enter Name Fruit Name:");
        String name =obj.nextLine();
        name =obj.nextLine();
        
        System.out.println("Enter Grow Duration in Days:");
        int growDur = obj1.nextInt();
        
        System.out.println("Enter Cropping Interval in days:");
        int cropInt = obj1.nextInt();
        
        System.out.println("Enter Life time of plant in days:");
        int lifetime = obj1.nextInt();
        
        System.out.println("Enter Standard Volume in cubic millimeter:");
        float stdVol = obj1.nextFloat();
        
        System.out.println("Enter Standard Average color in between 0-16777215:");
        int colorVal = obj1.nextInt();
        
        System.out.println("Enter Standard PH value for tree:");
        int phVal = obj1.nextInt();
        
        fruits.add(new Fruit(name, growDur, cropInt, lifetime, stdVol, colorVal, phVal));
    }
    
    static void addVegetable(){
        System.out.println("Enter Name Vegitable Name:");
        String name =obj.nextLine();
        name =obj.nextLine();
        
        System.out.println("Enter Grow Duration in Days:");
        int growDur = obj1.nextInt();
        
        System.out.println("Enter Cropping Interval in days:");
        int cropInt = obj1.nextInt();
        
        System.out.println("Enter Life time of plant in days:");
        int lifetime = obj1.nextInt();
        
        System.out.println("Enter Standard area per Leaf:");
        float stdAr = obj1.nextFloat();
        
        System.out.println("Enter Standard thickness in micrometers:");
        float thickness = obj1.nextFloat();
        
        vegetables.add(new Vegetable(name, growDur, cropInt, lifetime, stdAr, thickness));
    }
    
    static void addBatch(){
        System.out.println("Enter Growing Year of batch");
        int growYr = obj1.nextInt();
        
        System.out.println("Enter Growing Month of batch");
        int growMo = obj1.nextInt();
        
        System.out.println("Enter Growing day of month:");
        int growDay = obj1.nextInt();
        
        
       LocalDate batchDate = LocalDate.of(growYr, growMo, growDay);
        
        System.out.println("Do you want to add Fruits to batch press 1 else press 0");
        int frui = obj1.nextInt();
        boolean fru;
        if(frui==1){
            fru = true;
        }
        else
            fru = false;
        
        while (fru) {            
            addFruit();
            System.out.println("Do you want add more fruits then press 1 else press 0");
            int che = obj1.nextInt();
            if(che == 1){
                fru = true;
            }
            else
                fru = false;
                break;
        }
        
        System.out.println("Do you want to add Vegitables to batch press 1 else press 0");
        int vegs = obj1.nextInt();
        boolean veg;
        if(vegs==1){
            veg = true;
        }
        else
            veg = false;
        
        while (veg) {            
            addVegetable();
            System.out.println("Do you want add more vegetables then press 1 else press 0");
            int che = obj1.nextInt();
            if(che == 1){
                veg = true;
            }
            else
                veg = false;
            break;
                    
        }
       batches.add(new Batch(batchDate, fruits, vegetables));
     
        
       
        batches.size();
    }
    
    static void showBatchDetails(){
        System.out.println(batches.toString());
    }
    
    static void addHarvestToSelectedPlant(){
        System.out.println("If you wants to add harvest of fruit press 1 if you wants add harvest of vegetable press 0");
        int select = obj1.nextInt();
        int index = batches.size() - 1;
            if(select==1){

                System.out.println("Enter index of fruit you wants to add harverst (index are starting with 0):");
                int idx = obj1.nextInt();
                System.out.println("Enter harvesting year");
                int yr = obj1.nextInt();
                System.out.println("Enter harvesting month");
                int month = obj1.nextInt();
                System.out.println("Enter harvesting day");
                int day = obj1.nextInt();
                LocalDate hrDate = LocalDate.of(yr, month, day);

                batches.get(index).fruits.get(idx).addHarvest(hrDate, 0, batches.get(index).getDateOfPlanted());
            }
            
            else if(select == 0){
                System.out.println("Enter index of Vegitable you wants to add harverst (index are starting with 0):");
                int idx2 = obj1.nextInt();
                System.out.println("Enter harvesting year");
                int yr2 = obj1.nextInt();
                System.out.println("Enter harvesting month");
                int month2 = obj1.nextInt();
                System.out.println("Enter harvesting day");
                int day2 = obj1.nextInt();
                LocalDate hrDate = LocalDate.of(yr2, month2, 2);

                batches.get(index).vegetables.get(idx2).addHarvest(hrDate, 0, batches.get(index).getDateOfPlanted());
            }
    }
    
    static void viewPlantList(){
        int index = batches.size()-1;
        int fruitIndex = batches.get(index).fruits.size();
        int vegIndex = batches.get(index).vegetables.size();
        System.out.println(fruitIndex);
        for (int i = 0; i < fruitIndex; i++) {
            System.out.println(batches.get(index).fruits.get(i).toString());
        }
        
        
        for (int j = 0; j < vegIndex; j++) {
            System.out.println(batches.get(index).vegetables.get(j).toString());
        }
    }
    
    static void viewAllCropDetails(){
        int index = batches.size()-1;
        System.out.println("to see harvest of fruit enter 1 for vegitable enter 0");
        int myobj = obj1.nextInt();
        
        if(myobj == 1){
            System.out.println("Enter fruit index starting with 0");
            int id = obj1.nextInt();
            
            System.out.println(batches.get(index).fruits.get(id).harvests.toString());
            if(fruits.get(index).isStatus()==true){
                System.out.println("plant has reach its maximum potential");
            }
            else
                 System.out.println("Plant hasn't reach its maximum potential");
            
        }
        else if(myobj==0){
            System.out.println("Enter vegetable index starting with 0");
            int id2 = obj1.nextInt();
            
            System.out.println(batches.get(index).vegetables.get(id2).harvests.toString());
            if(vegetables.get(index).isStatus()==true){
                System.out.println("plant has reach its maximum potential");
            }
            else
                 System.out.println("Plant hasn't reach its maximum potential");
        }
    }
   
}
