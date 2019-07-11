/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.de.adivinhaçao;

import EasySocket.nsocket;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author MarcosB
 */
public class Player {
    static Ranking Rank = new Ranking();
    static int contador=0;
    static int Limite=100;
    private nsocket player;
    private int pontuaçao=0;
    private int id;
    private int NumeroSorteado;
    private String nome="sumido";
    private Random rand=new Random();
    private Thread Atualizador;
    
    public Player(nsocket player, String nome) {
        this.player = player;
        this.nome = nome;
        id=contador;
        contador++;
        NumeroSorteado=rand.nextInt(Limite);
        Rank.getRanking().add(this);
        Atualizador=new Thread(proc1);
        Atualizador.start();
    }
    
    Runnable proc1=new Runnable() {
        @Override
        public void run() {
            while(true){
                System.out.print("");
                if(!player.copyEntrada().equalsIgnoreCase("")){
                    String entrada=player.getEntrada();
                    if(entrada.contains("nome,") || entrada.contains("Nome,")){
                        nome=entrada.split(",")[1];
                        NumeroSorteado=rand.nextInt(Limite);
                        player.Enviar("Nome setado");
                    }else
                    try{
                    if(entrada.equalsIgnoreCase("ranking")){
                        player.Enviar(Rank.getPontos());
                    }
                    if(Integer.parseInt(entrada)==NumeroSorteado){
                        player.Enviar("Acertou! pontos:"+pontuaçao);
                        pontuaçao++;
                        NumeroSorteado=rand.nextInt(Limite);
                        Rank.UpdateList();
                        player.Enviar(Rank.getPontos());
                    }else
                    if(Integer.parseInt(entrada)<NumeroSorteado){
                        player.Enviar("O numero é maior que:"+entrada);
                    }else
                    if(Integer.parseInt(entrada)>NumeroSorteado){
                        player.Enviar("O numero é menor que:"+entrada);
                    }
                    }catch(Exception e){
                        
                    }
                }
            }
        }
    };

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Player.contador = contador;
    }

    public static int getLimite() {
        return Limite;
    }

    public static void setLimite(int Limite) {
        Player.Limite = Limite;
    }

    public nsocket getPlayer() {
        return player;
    }

    public void setPlayer(nsocket player) {
        this.player = player;
    }

    public int getPontuaçao() {
        return pontuaçao;
    }

    public void setPontuaçao(int pontuaçao) {
        this.pontuaçao = pontuaçao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroSorteado() {
        return NumeroSorteado;
    }

    public void setNumeroSorteado(int NumeroSorteado) {
        this.NumeroSorteado = NumeroSorteado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public Thread getAtualizador() {
        return Atualizador;
    }

    public void setAtualizador(Thread Atualizador) {
        this.Atualizador = Atualizador;
    }

    public Runnable getProc1() {
        return proc1;
    }

    public void setProc1(Runnable proc1) {
        this.proc1 = proc1;
    }
    
}
