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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;



/**
 *
 * @author tommi
 */
public class FXMLDocumentController implements Initializable {

    MovieInfo mi;
    @FXML
    private ComboBox<Theater> combo;
    @FXML
    private TextField dateField;
    @FXML
    private Button listByDateButton;
    @FXML
    private ListView<?> listField;
    @FXML
    private TextField startTimeField;
    @FXML
    private TextField endTimeField;
    
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

    @FXML
    private void listByDate(ActionEvent event) {
        listField.getItems().clear();
        listField.getItems().addAll(mi.getMoviesDate(combo.getValue().getMapValue("ID"),
                dateField.getText(),
                startTimeField.getText(),
                endTimeField.getText()));
        System.out.println(combo.getValue().getMapValue("ID"));
        System.out.println(dateField.getText());
    }

    @FXML
    private void listByName(ActionEvent event) {
        mi.parseTime("15.14");
    }
    
}
