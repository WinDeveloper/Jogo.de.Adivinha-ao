/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.de.adivinhaçao;

import EasySocket.nsocket;

/**
 *
 * @author MarcosB
 */
public class servidor extends EasySocket.EasyMultServer{
    
    public servidor(int porta) {
        super(porta);
    }

    @Override
    public void funçaoExtra(nsocket Aceitado) {
        new Player(Aceitado, "anonimo");
        Aceitado.Enviar("Defina um nome usando nome,seu nome");
    }
    
}
