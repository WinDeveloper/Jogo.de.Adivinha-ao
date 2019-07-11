/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo.de.adivinhaçao;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author MarcosB
 */
public class Ranking {
    private LinkedList<Player> Ranking=new LinkedList<>();
    
    public LinkedList<Player> getRanking(){
        return Ranking;
    }
    public void UpdateList(){
        Collections.sort(Ranking, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if(o1.getPontuaçao()>o2.getPontuaçao()){
                    return -1;
                }else
                    if(o1.getPontuaçao()==o2.getPontuaçao()){
                        return 0;
                    }else
                        return 1;
            }
        });
    }
    public String getPontos(){
        String pontuaçao="";
        for(int i=0;i<Ranking.size();i++){
            pontuaçao+= (i+1)+":Lugar "+Ranking.get(i).getNome()+" Pontos:"+Ranking.get(i).getPontuaçao()+"|";
        }
        return pontuaçao;
    }
}
