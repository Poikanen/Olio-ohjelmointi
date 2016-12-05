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
    private String name;
    private Circle circle;
    
    public Point()
    {
        name = "piste";
        circle = new Circle();
        setHandle();
    }
    public Point(String n, Circle c)
    {
        name = n;
        circle = c;
        setHandle();
    }
    
    private void setHandle()
    {
        circle.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    ShapeHandler sh = ShapeHandler.getInstance();
                    public void handle(MouseEvent me)
                    {
                        if (sh.getStartPoint() == null)
                        {
                            sh.setStartPoint(new Point("alku",(Circle)me.getSource()));
                            System.out.println(sh.getStartPoint().getName());
                        }
                        else if (sh.getEndPoint() == null)
                        {
                            sh.setEndPoint(new Point("loppu",(Circle)me.getSource()));
                            System.out.println(sh.getEndPoint().getName());
                        }
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