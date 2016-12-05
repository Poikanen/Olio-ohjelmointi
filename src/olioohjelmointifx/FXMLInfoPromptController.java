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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tommi
 */
public class FXMLInfoPromptController implements Initializable {

    @FXML
    private TextField nameField;
    
    ShapeHandler sh = ShapeHandler.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setName(ActionEvent event) {
        ((Point)sh.getPoints().get(sh.getPoints().size()-1)).setName(nameField.getText());
        nameField.clear();
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
    
}
