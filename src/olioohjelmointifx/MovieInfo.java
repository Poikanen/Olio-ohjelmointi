/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author tommi
 */
public class MovieInfo {
    private ArrayList<Theater> theaters;
    private final URL url;
    private Document doc;
    
    public MovieInfo() throws MalformedURLException
    {
        theaters = new ArrayList<Theater>();
        url = new URL("http://www.finnkino.fi/xml/TheatreAreas/");
        buildDBF();
        getCurrentData();
    }
    private void buildDBF()
    {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new InputSource(new StringReader(readURL(url))));
            doc.getDocumentElement().normalize();
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(TheaterXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private String readURL (URL url)
    {
        String content = "";
        String line;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = br.readLine()) != null)
            {
                content += line + "\n";
            }
            br.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(MovieInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }
    
    protected void getCurrentData()
    {
        NodeList nodes = doc.getElementsByTagName("TheatreArea");
        for (int i = 0; i < nodes.getLength(); i++)
        {
            theaters.add(new Theater());
            Theater theater = theaters.get(i);
            Node node = nodes.item(i);
            Element e = (Element)node;
            theater.setMapValue("ID", getValue("ID",e));
            theater.setMapValue("Name", getValue("Name",e));
            System.out.println(theaters.get(i).getMapValue("Name") +" "+theaters.get(i).getMapValue("ID"));
       }
    }
    protected String getValue(String tag, Element e,String attr)
    {
        return ((Element)e.getElementsByTagName(tag).item(0)).getAttribute(attr);
    }
    protected String getValue(String tag, Element e)
    {
        return ((Element)e.getElementsByTagName(tag).item(0)).getTextContent();
    }

    public ArrayList<Theater> getTheaters() {
        return theaters;
    }
    
}
