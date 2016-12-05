/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
        setHandle();
    }    
    
    /*@FXML
    private void drawPoint(MouseEvent event) {
        if (!sh.isPointClicked())
        {
            new Point("piste",new Circle(event.getSceneX(),event.getSceneY(),5d));
            System.out.println("Uusi piste");
        }
        updateMap();
        sh.isPointClicked(false);
        
    }*/
    
    private void setHandle()
    {
        panelView.setOnMouseReleased(new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent me)
                    {
                        if (!sh.isPointClicked())
                        {
                            new Point("piste",new Circle(me.getSceneX(),me.getSceneY(),5d));
                            //System.out.println("Uusi piste "+sh.getPoints().size());
                            //System.out.println(me.getSource().toString());
                        }
                        updateMap();
                        sh.isPointClicked(false);
                    }
                });
    }
    
    public void updateMap()
    {
        //System.out.println("ennen "+panelView.getChildren().toString());
        panelView.getChildren().clear();
        //System.out.println("jälkeen "+panelView.getChildren().toString());
        //System.out.println(sh.getPoints().toString());
        Iterator itr = sh.getPoints().iterator();
        while (itr.hasNext())
        {
            panelView.getChildren().add(((Point)(itr.next())).getCircle());
        }
        itr = sh.getLines().iterator();
        while (itr.hasNext())
        {
            panelView.getChildren().add((Line)itr.next());
        }
    }
}
