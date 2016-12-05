/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.util.ArrayList;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author tommi
 */
public class ShapeHandler {
    private static ShapeHandler instance = null;
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<Line> lines = new ArrayList<Line>();
    private Circle startPoint = null;
    private Circle endPoint = null;
    private Boolean pointClicked = false;
    
    protected ShapeHandler () {}
    
    public static ShapeHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ShapeHandler();
        }
        return instance;
    }

    public ArrayList getPoints() {
        return points;
    }

    public Circle getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Circle startPoint) {
        this.startPoint = startPoint;
    }

    public Circle getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Circle endPoint) {
        this.endPoint = endPoint;
    }

    public Boolean isPointClicked() {
        return pointClicked;
    }

    public void isPointClicked(Boolean pointClicked) {
        this.pointClicked = pointClicked;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
    
    
}
