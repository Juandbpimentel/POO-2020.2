package menus;

import mobs.*;
import jogadores.*;
import itens.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Luta{
    private static Scanner in = new Scanner(System.in);

    public Luta(Mob mob,Jogador jogador){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     Menu de luta     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        boolean sair = false;
        while (sair){
            int jogadorAtaque,jogadorDefesa;
            while (true) {
                String line = in.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("correr")){

                }else if(ui[0].equals("atacar")){

                }else if(ui[0].equals("potar")){

                }else if(ui[0].equals("lutar")){

                }
                    break;
            }
            while (true) {
                if(mob.checarVidaBaixa())
                    break;
                if(!mob.checarVivo()){
                    ArrayList<Item> drops = new ArrayList<Item>(mob.droparItens());
                    if(!drops.isEmpty()){
                        while(!drops.isEmpty()){
                            System.out.print("Você quer ficar com esse item?(y/n): ");
                            String line = in.nextLine();
                            if(line.equals("y")||line.equals("Y")) 
                                jogador.pegarDrop(drops.remove(0));
                            else
                                drops.remove(0);
                        }
                    }
                    jogador.receberDinheiro(mob.droparDinheiro());
                    jogador.receberXp(mob.droparXp());
                    return;
                }
            }
        }

    }
}
