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
public class Bottle {
    private String manufacturer;
    private String name;
    private double total_energy;
    private double volume;
    private double price;
    
    public Bottle ()
    {
        manufacturer = "Pepsi";
        name = "Pepsi Max";
        total_energy = 0.3;
        volume = 0.5;
        price = 1.8;
    }
    /**
     * String Name, String manuf, int totE, double volum, double pric
     */
    public Bottle (String manuf, String Name, double totE, double volum, double pric)
    {
        manufacturer = manuf;
        name = Name;
        total_energy = totE;
        volume = volum;
        price = pric;
    }
    public String getName()
    {
        return name;
    }
    public String getManufacturer()
    {
        return manufacturer;
    }
    public double getEnergy()
    {
        return total_energy;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double newprice)
    {
        price = newprice;
    }
    public double getVolume()
    {
        return volume;
    }
}
