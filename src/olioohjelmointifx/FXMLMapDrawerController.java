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
    private ShapeHandler sh;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sh = ShapeHandler.getInstance();
    }    

    @FXML
    private void drawPoint(MouseEvent event) {
        Point point = new Point("piste",new Circle(event.getSceneX(),event.getSceneY(),5d));
        sh.getPoints().add(point);
        panelView.getChildren().add(point.getCircle());
    }
    
    
}
