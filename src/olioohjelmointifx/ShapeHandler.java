/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.util.ArrayList;

/**
 *
 * @author tommi
 */
public class ShapeHandler {
    private static ShapeHandler instance = null;
    private ArrayList<Point> points = new ArrayList();
    private Point startPoint = null;
    private Point endPoint = null;
    
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

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
    
    
}
