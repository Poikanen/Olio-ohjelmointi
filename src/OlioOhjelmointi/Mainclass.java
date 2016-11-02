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
 * Viikko 6 tehtävät
 * @author Tommi Wäänänen
 */
public class Mainclass {
    
    /**
     * @param args the command line arguments
     */
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
        while (true)
        {
            mainMenu();
        }
    }
    
    int userChoise =-1;
    Character user;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public void mainMenu()
    {
        int choise =-1;
        System.out.println("*** TAISTELUSIMULAATTORI ***");
        System.out.println("1) Luo hahmo");
        System.out.println("2) Taistele hahmolla");
        System.out.println("0) Lopeta");
        System.out.print("Valintasi: ");
        try{
        choise = Integer.parseInt(br.readLine());
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
        if (choise == 1){characterMenu();}
        else if (choise ==2){user.fight();}
        else if (choise ==0){System.exit(0);}
    }
    public void weaponMenu()
    {
        int choise =-1;
        System.out.println("Valitse aseesi: ");
        System.out.println("1) Veitsi");
        System.out.println("2) Kirves");
        System.out.println("3) Miekka");
        System.out.println("4) Nuija");
        System.out.print("Valintasi: ");
        try{
        choise = Integer.parseInt(br.readLine());
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
        if (choise == 1){user.weapon = new Knife();}
        else if (choise ==2){user.weapon = new Axe();}
        else if (choise ==3){user.weapon = new Sword();}
        else if (choise ==4){user.weapon = new Club();}
        else {}
    }
    
    public void characterMenu()
    {
        int choise =-1;
        System.out.println("Valitse hahmosi: ");
        System.out.println("1) Kuningas");
        System.out.println("2) Ritari");
        System.out.println("3) Kuningatar");
        System.out.println("4) Peikko");
        System.out.print("Valintasi: ");
        try{
        choise = Integer.parseInt(br.readLine());
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
        if (choise == 1){user = new King();}
        else if (choise ==2){user = new Knight();}
        else if (choise ==3){user = new Queen();}
        else if (choise ==4){user = new Troll();}
        else{}
        weaponMenu();
    }
}
