/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.net.URL;
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
    
    private String previousPage;
    private String currentPage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        previousPage ="";
        currentPage = "";
    }    

    @FXML
    private void addressFieldAction(ActionEvent event) {
        if (addressField.getText().equals("index.html"))
        {
            web.getEngine().load(getClass().getResource("index.html").toExternalForm());
            currentPage = web.getEngine().getLocation();
        }
        else web.getEngine().load("http://"+addressField.getText());
        
        if(!web.getEngine().getLocation().equals(currentPage))
        {
        previousPage = currentPage;
        }
        currentPage = web.getEngine().getLocation();
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
            web.getEngine().load(previousPage);
        
    }

    @FXML
    private void nextAction(ActionEvent event) {
        web.getEngine().load(currentPage);
    }
    
}
