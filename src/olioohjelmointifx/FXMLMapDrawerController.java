/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tommi
 */
public class FXMLMapDrawerController implements Initializable {

    @FXML
    private AnchorPane panelView;
    private ShapeHandler sh;
    private TextField nameField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sh = ShapeHandler.getInstance();
        //setHandle();
    }    
    
    @FXML
    private void drawPoint(MouseEvent event)
        {
                        if (!sh.isPointClicked())
                        {
                            new Point("piste",new Circle(event.getSceneX(),event.getSceneY(),5d));
                            //System.out.println("Uusi piste "+sh.getPoints().size());
                            //System.out.println(me.getSource().toString());
                            startInfoPrompt();
                        }
                        updateMap();
                        sh.isPointClicked(false);
    }
    /*
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
    */
    
    public void updateMap()
    {
        //System.out.println("ennen "+panelView.getChildren().toString());
        panelView.getChildren().clear();
        //System.out.println("jälkeen "+panelView.getChildren().toString());
        //System.out.println(sh.getPoints().toString());
        Iterator itr = sh.getPoints().iterator();
        while (itr.hasNext())
        {
            Point p = (Point)itr.next();
            panelView.getChildren().add(p.getCircle());
            Text t = new Text();
            t.setText(p.getName());
            t.setX(p.getCircle().getCenterX()-p.getName().length()*3);
            t.setY(p.getCircle().getCenterY()-10);
            panelView.getChildren().add(t);
            
        }
        itr = sh.getLines().iterator();
        while (itr.hasNext())
        {
            panelView.getChildren().add((Line)itr.next());
        }
    }
    private void startInfoPrompt()
    {
        try {
            Stage infoPrompt = new Stage();
            Parent page = FXMLLoader.load(getClass().getResource("FXMLInfoPrompt.fxml"));
            Scene scene = new Scene(page);
            infoPrompt.setScene(scene);
            infoPrompt.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLMapDrawerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
