/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.util.Scanner;

/**
 *
 * @author tommi
 */
public class Dog {
    
    private String name;
    private String line;
    
    public Dog(String newname)
    {
        name = "Doge";
        line = "Much wow!";
        if (newname.trim().isEmpty()==false)
        {
            name = newname;
        }
        System.out.println("Hei, nimeni on "+name);
    }
    
    public void speak(String lause)
    {
        if (lause.trim().isEmpty()==false)
        {
        line = lause;
        }
        System.out.println(name +": "+ line);
    }
    
    public void speak()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mitä koira sanoo: ");
        String tempString = sc.nextLine();
        if (tempString.trim().isEmpty())
        {
        System.out.println(name +": "+line);
        speak();
        return;
        }
        line = tempString;
        sc = new Scanner(tempString);
        while (sc.hasNext())
                {
                    if (sc.hasNextBoolean())
                    {
                        System.out.println("Such boolean: "+sc.nextBoolean());
                    }
                    else if (sc.hasNextInt())
                    {
                        System.out.println("Such integer: "+sc.nextInt());
                    }
//                    else if (sc.hasNextFloat())
//                    {
//                        System.out.println("Such float: "+sc.nextFloat());
//                    }
                    else
                    {
                        System.out.println(sc.next());
                    }
                }
//        System.out.println(name +": "+line);
    }
    
    public void setName(String newname)
    {
        name = newname;
    }
    
    public void setLine(String whatTo)
    {
        line = whatTo;
    }
}
