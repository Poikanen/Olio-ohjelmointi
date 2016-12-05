/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author tommi
 */
public class Point {
    private String name;
    private Circle circle;
    ShapeHandler sh = ShapeHandler.getInstance();
    
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
        sh.getPoints().add(this);
    }
    
    private void setHandle()
    {
        circle.setOnMousePressed(new EventHandler<MouseEvent>()
                {
                    ShapeHandler sh = ShapeHandler.getInstance();
                    public void handle(MouseEvent me)
                    {
                        sh.isPointClicked(Boolean.TRUE);
                        if (sh.getStartPoint() == null)
                        {
                            sh.setStartPoint(circle);
                            //System.out.println(circle.toString());
                        }
                        else if (sh.getEndPoint() == null)
                        {
                            sh.setEndPoint((Circle)me.getSource());
                            Line line = new Line();
                            line.setStartX(sh.getStartPoint().getCenterX());
                            line.setStartY(sh.getStartPoint().getCenterY());
                            line.setEndX(sh.getEndPoint().getCenterX());
                            line.setEndY(sh.getEndPoint().getCenterY());
                            sh.setEndPoint(null);
                            sh.setStartPoint(null);
                            sh.setLine(line);
                            
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