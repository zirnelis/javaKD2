/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;

/**
 *
 * @author Elina
 */
public class MainClient {
    public static void main(String args[]) throws IOException {
        KD2Client client = new KD2Client();
        client.configureAndStartClient();
    }
}
