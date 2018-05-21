/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import model.Packet;
import model.Packet.Packet01Message;
import model.Packet.Packet02Message;
import model.Student;

/**
 *
 * @author Elina
 */
public class KD2ClientListener extends Listener{
    private Client client;

    public KD2ClientListener() {
    }

    
    public void init(Client client) {
        
    }
    
    public void connected(Connection c) {
        System.out.println("Cleint connected..");
    }
    
    public void disconnected(Connection c) {
        System.out.println("Cleint disconnected..");
    }
    
    //Jasanem saraksts bez atzimem
    public void received(Connection c, Object o) {
        if(o instanceof ArrayList) {
//           if(ArrayList.get(0).getGrade()..) {
//           
//           }
           System.out.println("Recievd Students");
           ArrayList vTemp = ((ArrayList)o);
            
           System.out.println("I have recieved! (CleintListener)");
        }
        
    }
    
    public ArrayList<Student> fillGrades(ArrayList<Student> students) throws IOException {
        ArrayList<Student> studWithGrades = new ArrayList<>();
        int atz = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < students.size(); i++) {
            System.out.println("Ievadiet atzimi studentam "+students.get(i).getFirstname()+" "
                    + students.get(i).getLastname()+" ");
            atz = Integer.parseInt(br.readLine());
            students.get(i).setGrade(atz);
        }
        
        return studWithGrades;
    }
}
