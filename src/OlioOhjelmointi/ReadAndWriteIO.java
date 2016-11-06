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
    
    public String readFile(String source)
    {
        String total ="";
        try {
            BufferedReader in = new BufferedReader((new FileReader(source)));
            String inputLine = in.readLine();
            
            
            while (!(inputLine == null))
            {
                total += (inputLine + "\n");
                System.out.println(inputLine);
                inputLine = in.readLine();
            }
            in.close();
            return total;
            
        }
        catch (IOException i) {
            i.printStackTrace();
        }
        return "";
    }
    
    //Write input string to output file
    public String writeFile(String input, String output)
    {
        try {
            BufferedReader in = new BufferedReader(new StringReader(input));
            String inputLine = in.readLine();
            BufferedWriter out = new BufferedWriter(new FileWriter(output));
            while (inputLine != null)
            {
                out.write(inputLine + "\n");
                inputLine = in.readLine();
            }
            in.close();
            out.close();
            return "File saved.";
        }
        catch (IOException e) {
            e.printStackTrace();
            return "Action failed";
            }
    }
    
    // Write input file to output file
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
