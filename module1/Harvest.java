
 /*
 * **********AS2019576************
 */
package asii;

import java.time.LocalDate;

/**
 *
 * @author AS2019576
 */
public class Harvest {
    private float weight;
    private LocalDate date;
    enum Standard{STANDARD,STANDARDBELOW,STANDARDABOVE};

    public Harvest(float weight, LocalDate date) {
        this.weight = weight;
        this.date = date;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public String tostString(){
        String msg;
        msg= "Harvest "+getWeight()+" kgs" ;
        msg+=" Date of harvesting " +getDate();
        
        return msg;
        
        
    }
}
