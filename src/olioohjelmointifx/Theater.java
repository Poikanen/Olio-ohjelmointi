/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olioohjelmointifx;

import java.util.HashMap;

/**
 *
 * @author tommi
 */
public class Theater {
    private HashMap map;
    
    public Theater()
    {
        map = new HashMap();
    }
    public String getMapValue(String key)
    {
        return map.get(key).toString();
    }
    public void setMapValue(String key, String value)
    {
        map.put(key, value);
    }
    @Override
    public String toString()
    {
        return map.get("Name").toString();
    }
}
