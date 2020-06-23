import java.util.Scanner;
import java.util.*;

interface Converter{

    Object Convert(Object obj);
}
abstract class TemperatureConverter implements Converter{

    abstract boolean isHot(double temp);
    public Object Convert(Object obj){
        return obj;
    }
}

abstract class SpeedConverter implements Converter{

    abstract boolean isFast(double speed);
    public Object Convert(Object obj){
        return obj;
    }
}
class Thermometer extends TemperatureConverter{

    public double Convert(double celsius){

        return ((celsius * 9.0 / 5.0) + 32.0); 
    }

    boolean isHot(double temp){

            if(temp > 100){
                return true;
            }
            else{
                return false;
            }
    }
}
class Thermocouple extends TemperatureConverter{

    double Convert(double celsius){

        return (celsius + 273.15); 
    }

    boolean isHot(double temp){

        if(temp > 100){
            return true;
        }
        else{
            return false;
        }
}
}

class PitotTube extends SpeedConverter{

    double Convert(double km){

        return km / 1.6;
    }

    boolean isFast(double speed){

        if(speed > 100.00){
            return true;
        }
        else{
            return false;
        }
    }
}
class ShaftLog extends SpeedConverter{

    double Convert(double kmph){

        return 0.6214 * kmph; 
    }

    boolean isFast(double speed){

        if(speed > 100){
            return true;
        }
        else{
            return false;
        }
    }
}

class assignment1{

    public static void main(String[] args){

        Converter converter;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        if(choice == 1){
            converter = new Thermometer();
            System.out.println(((Thermometer)converter).Convert(135.00));
            System.out.println(((Thermometer)converter).isHot(110));
        }
        else if(choice == 2){
            converter = new Thermocouple();
            System.out.println(((Thermocouple)converter).Convert(125.00));
            System.out.println(((Thermocouple)converter).isHot(90));
        }
        else if(choice == 3){
            converter = new PitotTube();
            System.out.println(((PitotTube)converter).Convert(145.00));
            System.out.println(((PitotTube)converter).isFast(90));
        }
        else if(choice == 4){
            converter = new ShaftLog();
            System.out.println(((ShaftLog)converter).Convert(115.00));
            System.out.println(((ShaftLog)converter).isFast(130));
        }
        else{
            System.out.println("invalid choice");
        }
    }
}