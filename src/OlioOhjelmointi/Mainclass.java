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
 * Viikko 7 tehtävät
 * @author Tommi Wäänänen
 * 
 * Viopen antama virhe:
 * Virhe lausekkeessa:
 * Tarkista oletko kirjoittanut muita kuin määrittelylauseita metodin ulkopuolelle. 
 * Vain määrittelylauseet voivat sijaita metodien ulkopuolella, 
 * muu koodi tulee olla jonkin metodin sisällä.
 */
public class Mainclass {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainClassista uusi instanssi
        //tämä poisti ongelmia esim viikon 6 tehtävissä
        Bank bank = new Bank();
        bank.run();
    }
        /*
        try{
        Mainclass program = new Mainclass();
        program.run(args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(String[] args) throws Exception
    {
        while (true)
        {
            mainMenu();
        }
    }
    */
}

class Bank{
    private ArrayList<Account> accounts;
    private BufferedReader br;
    public Bank()
    {
        accounts = new ArrayList<>();
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void run ()
    {while (true){mainMenu();}}
    
    //päälooppi
    public void mainMenu()
    {
        int choise =-1;
        System.out.println();
        System.out.println("*** PANKKIJÄRJESTELMÄ ***");
        System.out.println("1) Lisää tavallinen tili");
        System.out.println("2) Lisää luotollinen tili");
        System.out.println("3) Tallenna tilille rahaa");
        System.out.println("4) Nosta tililtä");
        System.out.println("5) Poista tili");
        System.out.println("6) Tulosta tili");
        System.out.println("7) Tulosta kaikki tilit");
        System.out.println("0) Lopeta");
        System.out.print("Valintasi: ");
        choise = Integer.parseInt(getChoise());
        if (choise == 1){addAccount(1);}
        else if (choise ==2){addAccount(2);}
        else if (choise ==3){addMoney();}
        else if (choise ==4){withdrawMoney();}
        else if (choise ==5){deleteAccount();}
        else if (choise ==6){printAccounts(1);}
        else if (choise ==7){printAccounts(2);}
        else if (choise ==0){System.exit(0);}
        else {System.out.println("Valinta ei kelpaa");}
    }
    
    public void addAccount(int i)
    {
        
        System.out.print("Syötä tilinumero: ");
        String tiliNumero = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        if (i==1){
        accounts.add(new SavingsAccount(tiliNumero,raha));
        }
        else if (i == 2){
        System.out.print("Syötä luottoraja: ");
        int luotto = Integer.parseInt(getChoise());
        accounts.add(new CreditAccount(tiliNumero,raha,luotto));
        }
    }
    
    public void deleteAccount()
    {
        System.out.print("Syötä tilinumero: ");
        String tiliNumero = getChoise();
        for (Account a : accounts)
        {
            if (a.getAccountNumber().equals(tiliNumero))
            {
                accounts.remove(a);
                System.out.println("Tilinumero: "+tiliNumero);
            }
        }
    }
    
    public void printAccounts(int i)
    {
        if (i == 1)
        {
            System.out.print("Syötä tilinumero: ");
            String tiliNumero = getChoise();
            for (Account a : accounts)
            {
                if(a.getAccountNumber().equals(tiliNumero))
                {a.print();}
            }
        }
        else if (i == 2)
        {
            for (Account a : accounts)
            {
                a.print();
            }
        }
    }
    
    public void addMoney()
    {
        System.out.print("Syötä tilinumero: ");
        String tiliNumero = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        for (Account a : accounts)
        {
            if (a.getAccountNumber().equals(tiliNumero))
            {a.addMoney(raha);}
        }
    }
    
    public void withdrawMoney()
    {
        System.out.print("Syötä tilinumero: ");
        String tiliNumero = getChoise();
        System.out.print("Syötä rahamäärä: ");
        int raha = Integer.parseInt(getChoise());
        for (Account a : accounts)
        {
            if (a.getAccountNumber().equals(tiliNumero))
            {a.withdrawMoney(raha);}
        }
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
}

//abstrakti kantaluokka, jolla ei erikseen näkyvyysmäärettä(eli package?)
//protected ei kelpaa tietenkään ja publicilla haluaa uuden .java tiedoston
//jäsenmuuttujat protectedina ja jäsenfunktiot publicina
abstract class Account
{
    protected String accountNumber;
    protected int balance;
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public Account()
    {
        accountNumber = "Empty";
        balance = 0;
    }
    public Account(String n, int m)
    {
        accountNumber = n;
        balance = m;
        print();
    }
    public void addMoney(int m)
    {
        balance += m;
        print();
    }
    public void withdrawMoney(int m)
    {
        if (balance > m){
        balance -=m;}
        print();
    }
    public void print()
    {
        System.out.println("Tilinumero: "+accountNumber);
        System.out.println("Rahamäärä: "+balance);
    }
}

//Näille aliluokille ei myöskään käy mikään näkyvyysmääre
class SavingsAccount extends Account
{
    public SavingsAccount(String n, int m)
    {
        super(n,m);
    }
}

//Näille aliluokille ei myöskään käy mikään näkyvyysmääre
class CreditAccount extends Account
{
    private int credit;
    public CreditAccount()
    {
        super();
        credit = 0;
    }
    public CreditAccount(String n, int m, int c)
    {
        super(n,m);
        credit = c;
    }
    @Override
    public void print()
    {
        System.out.println("Tilinumero: "+accountNumber);
        System.out.println("Rahamäärä: "+balance);
        System.out.println("Luotto: "+credit);
    }
}