/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Viikko 7 tehtävät
 * @author Tommi Wäänänen
 */
/*
public class Mainclass {
    private Bank bank = new Bank();
    private BufferedReader br;
    
    public static void main(String[] args) {
        try{
        Mainclass program = new Mainclass();
        program.run(args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(String[] args) throws Exception
    {
        bank = new Bank();
        br = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            mainMenu();
        }
    }
    
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
        switch (choise) {
            case 1:
                bank.addAccount(1);
                break;
            case 2:
                bank.addAccount(2);
                break;
            case 3:
                bank.addMoney();
                break;
            case 4:
                bank.withdrawMoney();
                break;
            case 5:
                bank.deleteAccount();
                break;
            case 6:
                bank.printAccounts(1);
                break;
            case 7:
                bank.printAccounts(2);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Valinta ei kelpaa.");
                break;
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
*/