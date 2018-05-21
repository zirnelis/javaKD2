/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import model.Packet;

/**
 *
 * @author Elina
 */
public class KD2Client implements Serializable{
    Client client = new Client();
    KD2ClientListener kcl = new KD2ClientListener();
    Kryo kryo = client.getKryo();

    public KD2Client() {
    }

    
    public void configureAndStartClient() throws IOException {
        this.registerPackets();
        
        client.start();
        client.addListener(kcl);
        client.connect(15, "127.0.0.1", 8000);
        
        System.out.println("Client has been started..");
    }
    
    private void registerPackets() {
        kryo.register(Packet.class);
        kryo.register(ArrayList.class); 
    }
    
}
