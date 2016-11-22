/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

//import java.util.Scanner;

import java.util.Scanner;



/**
 * Viikko 9 tehtävät
 * @author Tommi Wäänänen
 */
public class Mainclass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BottleDispenser dispenser;
        dispenser = BottleDispenser.getInstance();
        int userchoise = -1;
        while (userchoise != 0)
        {
            userchoise = mainMenu();
        if (userchoise == 0)
        {break;}
        else if (userchoise == 1)
        {dispenser.addMoney();}
        else if (userchoise == 2)
        {
            dispenser.listBottles();
            userchoise = Integer.parseInt(getInput());
            dispenser.buyBottle(userchoise);
        }
        else if (userchoise == 3)
        {dispenser.returnMoney();}
        else if (userchoise == 4)
        {dispenser.listBottles();}
        }
    }
    public static int mainMenu()
    {
        System.out.println();
        System.out.println("*** LIMSA-AUTOMAATTI ***");
        System.out.println("1) Lisää rahaa koneeseen");
        System.out.println("2) Osta pullo");
        System.out.println("3) Ota rahat ulos");
        System.out.println("4) Listaa koneessa olevat pullot");
        System.out.println("0) Lopeta");
        String temp_string = "";
        while (temp_string == "")
        {
            temp_string = getInput();
            Scanner tempsc = new Scanner(temp_string);
            if (tempsc.hasNextInt())
            {
                int temp_int = Integer.parseInt(temp_string);
                if (temp_int == 1 || temp_int == 2 || temp_int == 3 || temp_int == 4 || temp_int == 0)
                {
                    break;
                }
            }
            else 
            {
                    temp_string = "";
                    System.out.print("Virheellinen valinta. Valitse uudelleen: ");
            } 
        }
        return Integer.parseInt(temp_string);
    }
    public static String getInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Valintasi: ");
        String temp_string = sc.nextLine().trim();
        return temp_string;
    }
}