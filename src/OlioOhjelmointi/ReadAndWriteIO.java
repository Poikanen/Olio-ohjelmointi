/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OlioOhjelmointi;

import java.io.*;
import java.util.zip.*;

/**
 *
 * @author tommi
 */
public class ReadAndWriteIO {
    
    
    public ReadAndWriteIO ()
    {
        
    }
    
    public void readFile(String source)
    {
        try {
            BufferedReader in = new BufferedReader((new FileReader(source)));
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
    public void readZip(String source)
    {
        String filename = "";
        try
        {
            ZipInputStream zip = new ZipInputStream(new BufferedInputStream(new FileInputStream(source)));
            ZipEntry entry;
            BufferedOutputStream dest = null;
            while ((entry = zip.getNextEntry()) != null)
            {
                if (entry.getName().contains(".txt") && !entry.getName().contains("MACOS"))
                {
                    filename = entry.getName();
                    int BUFFER = 2048;
                    FileOutputStream fos = new FileOutputStream(entry.getName());
                    dest = new BufferedOutputStream(fos, BUFFER);
                    byte data[] = new byte[BUFFER];
                    int count;
                    while((count = zip.read(data, 0, BUFFER)) != -1)
                    {
                        dest.write(data, 0, count);
                    }
                }
                //System.out.println(entry.);
            }
            dest.flush();
            dest.close();
            zip.close();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        catch(Exception e) {
         e.printStackTrace();
        }
        readFile(filename);
    }
}
