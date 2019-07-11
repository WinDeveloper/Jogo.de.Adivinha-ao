/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.de.adivinhaçao;

import EasySocket.EasySocket;
import EasySocket.EasyMultServer;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author MarcosB
 */
public class JogoDeAdivinhaçao{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        servidor sv=new servidor(25565);
        sv.start();
        EasySocket player=new EasySocket("127.0.0.1", 25565, "cliente");
        player.ClientStart();
        player.startVerificador();
        Scanner AC=new Scanner(System.in);
        while(true){
            player.Enviar(""+AC.nextInt());
        }
    }
}
