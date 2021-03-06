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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private List<Theater> theaters;
    private final URL url;
    private URL moviesUrl;
    private Document doc;
    
    public MovieInfo() throws MalformedURLException
    {
        theaters = new ArrayList<Theater>();
        url = new URL("http://www.finnkino.fi/xml/TheatreAreas/");
        
        buildDBF(url);
        getCurrentData();
    }
    private void buildDBF(URL url)
    {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(new InputSource(new StringReader(readURL(url))));
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(MovieInfo.class.getName()).log(Level.SEVERE, null, ex);
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
//            System.out.println(theaters.get(i).getMapValue("Name") +" "+theaters.get(i).getMapValue("ID"));
       }
    }
    protected List getMoviesName(String area, String name, String date,String starttime, String endtime) throws Exception
    {
        List content = new ArrayList();
        List temp = new ArrayList();
        if (date.isEmpty()){date = getDateString();}
        // Kommentoitu on hieman toistoa, mutta tehdään, jotta saadaan tulosteeseen oikea nimi ja päivämäärä
        setURL(date, theaters.get(0).getMapValue("ID"));
        buildDBF(moviesUrl);
        temp.add(parseByName(parseByTime(new String(),new String()),name).get(0));
        content.add("**** "+getValue("Title",(Element)temp.get(0))+ " **** "+parseURLDate(getValue("dttmShowStart",(Element)temp.get(0)))+ " ****");
        //
        for (int i = 1 ; i < theaters.size() ; i++)
        {
            if (area.equals(theaters.get(0).getMapValue("ID")))
            {
                setURL(date, theaters.get(i).getMapValue("ID"));
                buildDBF(moviesUrl);
                temp.clear();
                temp.addAll(parseToString(parseByName(parseByTime(starttime,endtime),name)));
                Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
                content.add("**** "+theaters.get(i).getMapValue("Name")+" ****");
                content.addAll(temp);
            }
            else if (area.equals(theaters.get(i).getMapValue("ID")))
            {
                setURL(date, area);
                buildDBF(moviesUrl);
                temp.clear();
                temp.addAll(parseToString(parseByName(parseByTime(starttime,endtime),name)));
                Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
                content.add("**** "+theaters.get(i).getMapValue("Name")+" ****");
                content.addAll(temp);
                return content;
            }
        }
        return content;
    }
    protected List getMoviesDate(String area, String date,String starttime, String endtime) throws Exception
    {
        // Jos päivämäärää ei ole syötetty
        if (date.isEmpty()){date = getDateString();}
        List content = new ArrayList();
        Element temp;
        setURL(date, area);
        buildDBF(moviesUrl);
        // Päivämäärä otsikoksi
        temp = ((Element)(parseByTime(new String(),new String())).get(0));
        content.add("**** " +parseURLDate(getValue("dttmShowStart",temp))+ " ****");
        // Lisätään palautettavaan listaan jäljellä olevat Elementit
        content.addAll(parseToString(parseByTime(starttime,endtime)));
       // Järjestellään lista aikajärjestykseen(/aakkosjärjestykseen)
       Collections.sort(content, String.CASE_INSENSITIVE_ORDER);
       return content;
    }
    protected void setURL(String date, String area)
    {
        try {
            moviesUrl = new URL("http://www.finnkino.fi/xml/Schedule/?area="+area+"&dt="+date);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected List parseByTime(String starttime, String endtime)
    {
        List temp = new ArrayList();
        NodeList nodes = doc.getElementsByTagName("Show");
        // NodeListin sisältö käsittelylistaan
        for (int i = 0; i < nodes.getLength(); i++)
        {
            temp.add(nodes.item(i));
        }
        int i =0;
        // Poistetaan käsittelylistasta aikamääreiden ulkopuoliset Elementit
        while (i < temp.size())
        {
            if (!starttime.isEmpty() && !parseURLTime(getValue("dttmShowStart",(Element)temp.get(i))).isAfter(parseTime(starttime).minusMinutes(1)))
            {temp.remove(i);i--;}
            else if (!endtime.isEmpty() && !parseURLTime(getValue("dttmShowStart",(Element)temp.get(i))).isBefore(parseTime(endtime).plusMinutes(1)))
            {temp.remove(i);i--;}
            i++;
        }
        return temp;
    }
    protected List parseByName(List temp,String name)
    {
        int i =0;
        // Poistetaan käsittelylistasta kaikki jotka eivät vastaa nimeä
        while (i < temp.size())
        {
            if (!name.isEmpty() && !getValue("Title",(Element)temp.get(i)).toLowerCase().contains(name))
            {
                temp.remove(i);
                i--;
            }
            i++;
        }
        return temp;
    }
    protected List parseToString(List content)
    {
        for (int i = 0; i < content.size(); i++)
        {
            Element e = (Element)content.get(i);
            content.add(i,parseURLTime(getValue("dttmShowStart",e)).toString()
                    + " " + getValue("Title",e)
                    + " - " + getValue("Theatre",e)
                    + "\n");
            content.remove(i+1);
       }
        return content;
    }
    protected LocalDate parseURLDate(String source)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDate date = LocalDate.parse(source, formatter);
        return date;
    }
    protected LocalTime parseURLTime(String source)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalTime time = LocalTime.parse(source, formatter);
        return time;
    }
    protected LocalTime parseTime(String input)
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH.mm");
        if (input.contains(":")){
        format = DateTimeFormatter.ofPattern("HH:mm");}
        LocalTime time = LocalTime.parse(input, format);
//        System.out.println(time);
        return time; 
    }
    protected String getDateString()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().format(format);
//        System.out.println(date);
        return date;
    }
    protected String getValue(String tag, Element e,String attr)
    {
        return ((Element)e.getElementsByTagName(tag).item(0)).getAttribute(attr);
    }
    protected String getValue(String tag, Element e)
    {
        return ((Element)e.getElementsByTagName(tag).item(0)).getTextContent();
    }
    public List<Theater> getTheaters() {
        return theaters;
    }
    
}
