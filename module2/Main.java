/*

*************AS2019576*******************

*/
import java.util.*; 

interface SensorListener{
    public void onValueUpdated(SensorTypes type, double value); 
}

enum SensorTypes {
    TEMPERATURE, PH, HUMIDITY; 
}

class Sensor extends Thread{
    private SensorTypes type; 
    private Random rnd;
    private SensorListener listener;
    
    public void setSensorListener(SensorListener listener){ 
        this.listener = listener;
    }
    public void setType(SensorTypes type){ 
        this.type = type;
    }
    public SensorTypes getType(){ 
        return this.type;
    }
    public Sensor(SensorTypes type){ 
        this.type = type;
        rnd = new Random();
    }
    public void startSensor(){
        start(); 
    }
    public void run(){ 
        while(true){
            try {
                if(listener != null){
                    listener.onValueUpdated(type, rnd.nextDouble());
                }
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                System.out.println("thread interrupted"); 
                
            }
        } 
    }
}

class SensorDetailsPrint implements SensorListener{
    @Override 
    public void onValueUpdated(SensorTypes type, double value){
        System.out.println("Sensor Name: " + type +", Measure: " + value);
    }
}

public class Main{
    public static void main (String[] args) {
        SensorDetailsPrint sdPrint = new SensorDetailsPrint();
        Sensor sensor = new Sensor(SensorTypes.TEMPERATURE);
        sensor.setSensorListener(sdPrint);
        sensor.startSensor();
    }
}