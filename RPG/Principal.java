import java.util.ArrayList;

import itens.*;
import jogadores.*;
import mobs.*;

public class Principal {
    
    public static void main(String[] args){
        ArrayList<Item> vetorDeItens = new ArrayList<Item>();
        //vetorDeItens.add(new Item());
        vetorDeItens.add(new Escudo(10,"Escudo de Aço"));
        vetorDeItens.add(new Armadura(10,"Armadura de Couro Trabalhado"));
        vetorDeItens.add(new Arma(10,"Espada de Aço Trabalhado"));

        Jogador jogador = new Jogador("Juan",1);
        //System.out.println(jogador);
        //System.out.println(jogador.atacar());

        for (Item item : vetorDeItens) {
            if(eEscudo(item)){
                Escudo escudo = (Escudo)item;
                escudo.dropar(jogador);
            } else if(eArmadura(item)){
                Armadura armadura = (Armadura)item;
                armadura.dropar(jogador);
            } else if(eArma(item)){
                Arma arma = (Arma) item;
                arma.dropar(jogador);
            }
            jogador.guardarItem(item);
        }
        
        jogador.verEquipados();

        jogador.desequiparArma();
        jogador.desequiparArmadura();
        jogador.desequiparEscudo();

        jogador.verEquipados();
        jogador.verInventario();
        
    }



    public static boolean eEscudo(Item item){
        if(item.getTipoDeItem().contains("Escudo "))
            return true;
        return false;
    }

    public static boolean eArmadura(Item item){
        if(item.getTipoDeItem().contains("Armadura "))
            return true;
        return false;
    }

    public static boolean eArma(Item item){
        if(item.getTipoDeItem().contains("Arma "))
            return true;
        return false;
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
