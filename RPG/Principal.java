import java.util.ArrayList;
import java.util.Scanner;

import itens.*;
import jogadores.*;
import mobs.*;

public class Principal {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Item> vetorDeItens = new ArrayList<Item>();
        //vetorDeItens.add(new Item());
        vetorDeItens.add(new Escudo(10));
        vetorDeItens.add(new Armadura(10));
        vetorDeItens.add(new Arma(10));

        for (int i = 0; i < 1; i++) {
            vetorDeItens.add(new Item(1));
            vetorDeItens.add(new Item(11));
            vetorDeItens.add(new Item(51));
            vetorDeItens.add(new Item(101));
        } 

        Jogador jogador = new Jogador("Juan",1);

        //System.out.println(jogador);
        //System.out.println(jogador.atacar());

        jogador.receberDinheiro(111111111);

        System.out.println(jogador);

        while(vetorDeItens.size()>0){
            jogador.comprarItem(vetorDeItens.remove(0),true);
        }
        
        jogador.verEquipados();
        jogador.verInventario();
        
        jogador.desequiparArma();
        jogador.desequiparArmadura();
        jogador.desequiparEscudo();
        
        System.out.println(jogador);
        jogador.verEquipados();
        jogador.verInventario();
        in.close();
    }
    
    public void lutarMenu(Jogador jogador,Mob inimigo){
        while (true){
            if(!jogador.checarVivo()){
                System.out.println("Você foi derrotado por "+inimigo.getNome());
                break;
            }

            if(!inimigo.checarVivo()){
                System.out.println("Você derrotou "+inimigo.getNome());
                break;
            }
        }
    }

    

}
