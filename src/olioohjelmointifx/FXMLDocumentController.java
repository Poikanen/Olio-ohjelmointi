/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import OlioOhjelmointi.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author tommi
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button buyButton;
    @FXML
    private Button moneyButton;
    @FXML
    private Button returnButton;
    @FXML
    private ComboBox<Bottle> bottleDisplay;
    @FXML
    private TextArea outputField;
    
    BottleDispenser d = BottleDispenser.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        d = BottleDispenser.getInstance();
    
    }
    @FXML
    private void buyBottle(ActionEvent event) {
        outputField.setText(d.buyBottle(1)+outputField.getText());
    }

    @FXML
    private void insertMoney(ActionEvent event) {
        outputField.setText(d.addMoney(1.23)+outputField.getText());
    }

    @FXML
    private void returnMoney(ActionEvent event) {
        outputField.setText(d.returnMoney()+outputField.getText());
    }
    
}
