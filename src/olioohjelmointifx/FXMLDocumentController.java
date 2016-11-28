/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;



/**
 *
 * @author tommi
 */
public class FXMLDocumentController implements Initializable {

    MovieInfo mi;
    @FXML
    private ComboBox<Theater> combo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            mi = new MovieInfo();
        } catch (MalformedURLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateCombo();
    }
    
    public void updateCombo ()
    {
        combo.getItems().addAll(mi.getTheaters());
        combo.setValue(combo.getItems().get(0));
    }
}
