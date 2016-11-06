/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.util.ArrayList;

/**
 *
 * @author tommi
 */
public class BottleDispenser {
    private int bottles;
    private double money;
    private ArrayList<Bottle> bottle_array;
    
    public BottleDispenser () 
    {
        bottles = 6;
        money = 0.0;
        
        bottle_array = new ArrayList();
        bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.5, 0.5, 1.8));
        bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.5, 1.5, 2.2));
        bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.5, 0.5, 2.0));
        bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.5, 1.5, 2.5));
        bottle_array.add(new Bottle("Fanta", "Fanta Zero", 0.5, 0.5, 1.95));
        bottle_array.add(new Bottle("Fanta", "Fanta Zero", 0.5, 0.5, 1.95));
    }
    
    public void addMoney ()
    {
        money += 1.0;
        System.out.println("Klink! Lisää rahaa laitteeseen!");
    }
    
    public void buyBottle(int index)
    {
        if (bottles >0 & money >= bottle_array.get(index-1).getPrice())
        {
            money -= bottle_array.get(index-1).getPrice();
            System.out.println("KACHUNK! "+bottle_array.get(index-1).getName()+" tipahti masiinasta!");
            bottles -= 1;
            bottle_array.remove(index-1);
        }
        else
        {
            System.out.println("Syötä rahaa ensin!");
        }
    }
    
    public void returnMoney()
    {
        String rahat = String.format("%.2f",money);
        System.out.println("Klink klink. Sinne menivät rahat! Rahaa tuli ulos " +rahat +"€");
        money = 0;
    }
    
    public void listBottles()
    {
        int i = 1;
        for (Bottle bottle : bottle_array)
        {
            System.out.println(i + ". Nimi: " +bottle.getName());
            System.out.println("	Koko: " + Double.toString(bottle.getVolume()) + "	Hinta: " + Double.toString(bottle.getPrice()));
            i++;
        }
    }
}
