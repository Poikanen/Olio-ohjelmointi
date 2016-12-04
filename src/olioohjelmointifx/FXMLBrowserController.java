/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author tommi
 */
public class FXMLBrowserController implements Initializable {

    @FXML
    private TextField addressField;
    @FXML
    private WebView web;
    
    List<String> history;
    ListIterator itr;
    ListIterator updater;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        history = new ArrayList<>();
        Collections.addAll(history, "","","","","","","","","","","");
        System.out.println(history);
        itr = history.listIterator(history.size());
        
    }    

    @FXML
    private void addressFieldAction(ActionEvent event) {
        if (addressField.getText().equals("index.html"))
        {
            web.getEngine().load(getClass().getResource("index.html").toExternalForm());
        }
        else web.getEngine().load("http://"+addressField.getText());
        
        itr = history.listIterator(history.size());
        if(!web.getEngine().getLocation().equals(itr.previous()))
        {
            updateHistory();
        }
    }

    @FXML
    private void refreshAction(ActionEvent event) {
        web.getEngine().reload();
    }

    @FXML
    private void shoutOutAction(ActionEvent event) {
        web.getEngine().executeScript("document.shoutOut()");
    }

    @FXML
    private void restoreAction(ActionEvent event) {
        web.getEngine().executeScript("initialize()");
    }

    @FXML
    private void previousAction(ActionEvent event) {
        if (itr.hasPrevious())
        {
            String temp = (String)itr.previous();
            if (!temp.isEmpty())
            {
                if (web.getEngine().getLocation().equals(temp))
                {
                    temp = (String)itr.previous();
                }
                web.getEngine().load((String)temp);
            }
            else 
            {
                temp = (String)itr.next();
            }
        }
    }

    @FXML
    private void nextAction(ActionEvent event) {
        if (itr.hasNext())
        {
            String temp = (String)itr.next();
            while (web.getEngine().getLocation().equals(temp))
            {
                temp = (String)itr.next();
            }
            web.getEngine().load((String)temp);
        }
    }
    
    private void updateHistory()
    {
        updater = history.listIterator(history.size());
        Object temp1 = updater.previous();
        Object temp2;
        while (updater.hasPrevious())
        {
            temp2= updater.previous();
            updater.set(temp1);
            temp1 = temp2;
        }
        itr.set(web.getEngine().getLocation());
        System.out.println(history);
    }
}
