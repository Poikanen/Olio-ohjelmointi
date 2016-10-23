/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tommi
 */
public class ReadAndWriteIO {
    
    
    public ReadAndWriteIO ()
    {
        
    }
    
    public void readFile(String target)
    {
        try {
            BufferedReader in = new BufferedReader(new FileReader(target));
            String inputLine = in.readLine();
            while (!(inputLine == null))
            {
                
                System.out.println(inputLine);
                inputLine = in.readLine();
            }
            in.close();
            
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void readAndWrite(String source, String target)
    {
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(source));
            String inputLine = in.readLine();
            BufferedWriter out = new BufferedWriter(new FileWriter(target));
            
            while (!(inputLine == null))
            {
                if (inputLine.length() < 30 && inputLine.trim().isEmpty() == false && inputLine.contains("v"))
                {
                    out.write(inputLine.trim()+"\n");
                }
                //System.out.println(inputLine);
                inputLine = in.readLine();
            }
            in.close();
            out.close();
            
        }
        catch (IOException i) {
            i.printStackTrace();
        }
    }
}
