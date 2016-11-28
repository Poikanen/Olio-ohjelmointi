/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.io.IOException;
import java.io.StringReader;
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
public class TheaterXML {
    private HashMap map;
    private Document doc;
    
    public TheaterXML(String content)
    {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new InputSource(new StringReader(content)));
            doc.getDocumentElement().normalize();
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(TheaterXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap getMap()
    {
        map = new HashMap();
        getCurrentData();
        return map;
    }
    
    protected void getCurrentData()
    {
        NodeList nodes = doc.getElementsByTagName("TheatreArea");
        for (int i = 0; i<nodes.getLength(); i++)
        {
            Node node = nodes.item(i);
            Element e = (Element)node;
            map.put("ID", getValue("ID",e,"ID"));
            map.put("Name", getValue("Name",e,"Name"));
        }
    }
    
    protected String getValue(String tag, Element e,String attr)
    {
        return ((Element)e.getElementsByTagName(tag).item(0)).getAttribute(attr);
    }
}
