/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.util.Scanner;


/**
 *
 * @author Tommi Wäänänen
 * Ohjelman, tiedoston ja tekijän nimet
 *Kuvaus tiedoston sisältämistä asioista
 *Kehitysympäristö
 *Muutoshistoria
 *Lisenssi
 *
 */
public class Mainclass {
    
    public static void main(String[] args)
    {
        String tempString;
        Scanner sc = new Scanner(System.in);
        System.out.print("Anna koiralle nimi: ");
        tempString = sc.nextLine();
        
        Dog dog1 = new Dog(tempString);
        dog1.speak();
        
        
        
//        System.out.print("Mitä koira sanoo: ");
//        tempString = sc.nextLine();
//        dog1.speak(tempString);

    }
}
