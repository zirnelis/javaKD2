/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Elina
 */
public class Packet {
    
    
    public String message;
    public ArrayList<Student> list;
    
    public Packet()
    {
        
    }
   
    public static class Packet01Message {
        String message;
    }
    
    public static class Packet02Message {
        ArrayList<Student> list;
    }
}
