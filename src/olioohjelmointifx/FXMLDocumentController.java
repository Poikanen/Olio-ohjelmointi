/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import OlioOhjelmointi.ReadAndWriteIO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button button1;
    @FXML
    private TextField textField;
    @FXML
    private TextField loadField;
    @FXML
    private TextField saveField;
    @FXML
    private TextArea textArea;
    ReadAndWriteIO io;
    
    @FXML
    private void Button1Action(ActionEvent event) {
        textArea.setText(textArea.getText() + "\n");
        textField.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        io = new ReadAndWriteIO();
    }    

    @FXML
    private void updateFromTextField(KeyEvent event) {
//                System.out.println("textfield");
                textArea.setText(textArea.getText()+(event.getCharacter()));
    }

    @FXML
    private void textFieldAction(ActionEvent event) {
//        label.setText(label.getText()+textField.getText());
//        label.setText(label.getText() +textField.getText()+ "\n");
        textArea.setText(textArea.getText() + "\n");
        textField.clear();
    }

    @FXML
    private void backSpaceAction(KeyEvent event) {
        if (event.getCode().equals(event.getCode().BACK_SPACE))
        {
//            System.out.println("backspace");
            if (textArea.getText().length() > 0) {
                textArea.setText(textArea.getText().substring(0,textArea.getText().length()-1));
            }
        }
    }

    @FXML
    private void clearLoadFieldAction(ActionEvent event) {
        loadField.clear();
    }

    @FXML
    private void clearSaveFieldAction(ActionEvent event) {
        saveField.clear();
    }

    @FXML
    private void loadFileAction(ActionEvent event) {
        textArea.setText(io.readFile(loadField.getText()));
    }

    @FXML
    private void saveFileAction(ActionEvent event) {
        textArea.setText(io.writeFile(textArea.getText(), saveField.getText()));
    }
    
}
