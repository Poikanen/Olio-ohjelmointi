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
    private static BottleDispenser instance = null;
    private static double money;
    private static ArrayList<Bottle> bottle_array;
    
    private BottleDispenser () 
    {
        money = 0.0;
        
        bottle_array = new ArrayList();
        bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.5, 0.5, 1.8));
        bottle_array.add(new Bottle("Pepsi", "Pepsi Max", 0.5, 1.5, 2.2));
        bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.5, 0.5, 2.0));
        bottle_array.add(new Bottle("Coca-Cola", "Coca-Cola Zero", 0.5, 1.5, 2.5));
        bottle_array.add(new Bottle("Fanta", "Fanta Zero", 0.5, 0.5, 1.95));
        bottle_array.add(new Bottle("Fanta", "Fanta Zero", 0.5, 0.5, 1.95));
    }
    
    public static BottleDispenser getInstance()
    {
        if (instance == null){
            instance = new BottleDispenser();}
        return instance;
    }
    
    public static String addMoney (double m)
    {
        money += m;
        return "Klink! Lisättiin "+String.format("%.2f",m)+" rahaa laitteeseen!\n";
    }
    
    public static String buyBottle(int index)
    {
        if (bottle_array.size() != 0 && money >= bottle_array.get(index-1).getPrice())
        {
            money -= bottle_array.get(index-1).getPrice();
            String tmp = "KACHUNK! "+bottle_array.get(index-1).getName()+" tipahti masiinasta!\n";
            bottle_array.remove(index-1);
            return tmp;
        }
        else
        {
            return "Syötä rahaa ensin!\n";
        }
    }
    
    public static String returnMoney()
    {
        String rahat = String.format("%.2f",money);
        money = 0;
        return "Klink klink. Sinne menivät rahat! Rahaa tuli ulos " + rahat +"€\n";
    }
    
    public static void listBottles()
    {
        if (bottle_array.size() != 0) {
            int i = 1;
            for (Bottle bottle : bottle_array)
            {
                System.out.println(i + ". Nimi: " +bottle.getName());
                System.out.println("	Koko: " + Double.toString(bottle.getVolume()) + "	Hinta: " + Double.toString(bottle.getPrice()));
                i++;
            }
        }
    }
}
