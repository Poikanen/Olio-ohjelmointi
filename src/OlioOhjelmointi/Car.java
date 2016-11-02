/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

/**
 *
 * @author tommi
 */
public class Car {
   Body body;
   Chassis chassis;
   Engine engine;
   Wheel wheel1;
   Wheel wheel2;
   Wheel wheel3;
   Wheel wheel4;
   
    public Car () 
            {
            body = new Body();
            chassis = new Chassis();
            engine = new Engine();
            wheel1 = new Wheel();
            wheel2 = new Wheel();
            wheel3 = new Wheel();
            wheel4 = new Wheel();
            }
    public void print()
            {
            System.out.println("Autoon kuuluu:");
            System.out.println("	"+body.getClass().getSimpleName());
            System.out.println("	"+chassis.getClass().getSimpleName());
            System.out.println("	"+engine.getClass().getSimpleName());
            System.out.println("	4 "+wheel1.getClass().getSimpleName());
            }
}

class Body {
    public Body () 
            {
                System.out.println("Valmistetaan: "+ this.getClass().getSimpleName());
            }
    
}

class Chassis {
    public Chassis () 
            {
                System.out.println("Valmistetaan: "+ this.getClass().getSimpleName());
            }
    
}

class Wheel {
    public Wheel () 
            {
                System.out.println("Valmistetaan: "+ this.getClass().getSimpleName());
            }
    
}

class Engine {
    public Engine () 
            {
                System.out.println("Valmistetaan: "+ this.getClass().getSimpleName());
            }
    
}