/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/**
 *
 * @author tommi
 */
public class Point {
    String name;
    Circle circle;
    
    public Point()
    {
        name = "piste";
        circle = new Circle();
        setHandle();
    }
    public Point(String n, MouseEvent e)
    {
        name = n;
        circle = new Circle(e.getSceneX(),e.getSceneY(),5d);
        setHandle();
    }
    
    private void setHandle()
    {
        circle.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent me)
                    {
                        System.out.println("Hei, olen "+name+"!");
                    }
                });
    }
    
    public String getName() {
        return name;
    }

    public Circle getCircle() {
        return circle;
    }
    
}