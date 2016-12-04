/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author tommi
 */
public class FXMLMapDrawerController implements Initializable {

    @FXML
    private AnchorPane panelView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void drawPoint(MouseEvent event) {
        Point point = new Point("piste",event);
        panelView.getChildren().add(point.getCircle());
    }
    
    
}
