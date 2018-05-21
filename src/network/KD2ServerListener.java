/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.sql.Connection;
import java.sql.SQLException;
import model.Packet;

/**
 *
 * @author Elina
 */
public class KD2ServerListener extends Listener {

    Client client;
    KD2Server server;
    
    public KD2ServerListener() {
        
        
    }
    
    //Parbaudiit....!!!
    public void connected(Connection c) throws SQLException{
        System.out.println("Server is connected..");
        server.getAndSendStudents(c);
    }
    
    public void disconnected(Connection c) {
    
    }
    //Jasanem saraksts ar atzimem
    public void recieved (Connection c, Object o) {
        if (o instanceof Packet.Packet01Message) {
            System.out.println("Server recieved packet..");
        }
        if (o instanceof Packet.Packet02Message) {
            //Parbaudit vai sarakstā ir atzimes.. ??
            
            System.out.println("Server recieved packet..");
        }
    }
}
