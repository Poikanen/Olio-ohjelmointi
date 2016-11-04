/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author tommi
 */
public class Bank{
    ArrayList<Account> accounts;
    private BufferedReader br;
    public Bank()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        accounts = new ArrayList();
    }
    
    public String getChoise()
    {
        try{
        return br.readLine();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return "";
        }
    }
    
    public void printStuff(int i)
    {
        if (i == 1)
        {
            System.out.print("Syötä tilinumero: ");
            String tili = getChoise();
            System.out.print("Syötä rahamäärä: ");
            int raha = Integer.parseInt(getChoise());
            System.out.println("Pankkiin lisätään: "+tili+","+raha);
        }
        else if (i == 2)
        {
            System.out.print("Syötä tilinumero: ");
            String tili = getChoise();
            System.out.print("Syötä rahamäärä: ");
            int raha = Integer.parseInt(getChoise());
            System.out.print("Syötä luottoraja: ");
            int luotto = Integer.parseInt(getChoise());
            System.out.println("Pankkiin lisätään: "+tili+","+raha+","+luotto);
        }
        else if (i == 3)
        {
            System.out.print("Syötä tilinumero: ");
            String tili = getChoise();
            System.out.print("Syötä rahamäärä: ");
            int raha = Integer.parseInt(getChoise());
            System.out.println("Talletetaan tilille: "+tili+" rahaa "+raha);
        }
        else if (i == 4)
        {
            System.out.print("Syötä tilinumero: ");
            String tili = getChoise();
            System.out.print("Syötä rahamäärä: ");
            int raha = Integer.parseInt(getChoise());
            System.out.println("Nostetaan tililtä: "+tili+" rahaa "+raha);
        }
        else if (i == 5)
        {
            System.out.print("Syötä poistettava tilinumero: ");
            String tili = getChoise();
            System.out.println("Tili poistettu.");
        }
        else if (i == 6)
        {
            System.out.print("Syötä tulostettava tilinumero: ");
            String tili = getChoise();
            System.out.println("Etsitään tiliä: "+tili);
        }
        else if (i == 7)
        {
            System.out.println("Kaikki tilit:");
        }
    }
    
    public Account search (String n)
    {
        for (Account a : accounts)
            {
                if (a.getAccountNumber().equals(n))
                {return a;}
            }
        return null;
    }

    public void addAccount(int i)
    {
        
        System.out.print("Syötä tilinumero: ");
        String tili = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        if (i == 1){
            accounts.add(new SavingsAccount(tili,raha));
        }
        else if (i == 2){
            printStuff(2);
//            System.out.print("Syötä luottoraja: ");
//            int luotto = Integer.parseInt(getChoise());
//            accounts.add(new CreditAccount(tili,raha,luotto));
        }
    }
    
    
    public void deleteAccount()
    {
        System.out.print("Syötä poistettava tilinumero: ");
        String tili = getChoise();
        accounts.remove(search(tili));
        System.out.println("Tili poistettu.");
    }
    
    public void printAccounts(int i)
    {
        if (i == 1)
        {
            System.out.print("Syötä tulostettava tilinumero: ");
            String tili = getChoise();
            search(tili).print();
//            System.out.println("Etsitään tiliä: "+tili);
        }
        else if (i == 2)
        {
            System.out.println("Kaikki tilit:");
            for (Account a : accounts)
            {
                a.print();
            }
        }
    }
    
    public void addMoney()
    {
        System.out.print("Syötä tilinumero: ");
        String tili = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        search(tili).addMoney(raha);
    }
    
    public void withdrawMoney()
    {
        System.out.print("Syötä tilinumero: ");
        String tili = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        search(tili).withdrawMoney(raha);
    }
}
