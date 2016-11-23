/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import OlioOhjelmointi.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Slider moneySlider;
        
    BottleDispenser d;
    ReadAndWriteIO io;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        d = BottleDispenser.getInstance();
        io = new ReadAndWriteIO ();
        updateCombo();
    }
    @FXML
    private void buyBottle(ActionEvent event) {
        outputField.setText(d.buyBottle(bottleDisplay.getValue())+outputField.getText());
        updateCombo();
    }

    @FXML
    private void insertMoney(ActionEvent event) {
        outputField.setText(d.addMoney(moneySlider.getValue())+outputField.getText());
        moneySlider.setValue(1);
        moneyButton.setText("Insert\n" + String.format("%.2f", moneySlider.getValue()));
    }

    @FXML
    private void returnMoney(ActionEvent event) {
        outputField.setText(d.returnMoney()+outputField.getText());
    }

    @FXML
    private void updateSlider(MouseEvent event) {
        moneyButton.setText("Insert\n" + String.format("%.2f", moneySlider.getValue()));
    }
    
    private void updateCombo()
    {
        bottleDisplay.getItems().removeAll(bottleDisplay.getItems());
        bottleDisplay.getItems().addAll(d.getBottleArray());
    }

    @FXML
    private void printReceipt(ActionEvent event) {
        io.writeFile(d.getReceipt(), "output.txt");
        outputField.setText("Kuitti tulostettu!\n"+outputField.getText());
    }
}
