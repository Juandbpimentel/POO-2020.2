import java.util.Scanner;

import jogadores.*;
import mobs.*;
import menus.*;

public class Main {
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args){
        Jogador jogador = new Jogador("Juan",1);
        String line = new String();
        Loja loja = new Loja(jogador);
        jogador.receberDinheiro(10000000);
        while (true) {
            System.out.println(jogador);
            jogador.reviver();
            System.out.print("Digite a opção: ");
            line = in.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("loja")){
                loja.menuCompra(jogador);
            }else if(ui[0].equals("lutar")){
                Luta luta = new Luta();

                int nivelMob = (ui.length>1)?Integer.parseInt(ui[1]):1; 

                luta.gerarLuta(Mob.criarMob(nivelMob),jogador);
                jogador.encherHP();
            }else if(ui[0].equals("sair")||ui[0].equals("-1")){
                break;
            }
            
        }
        //compra de itens


        in.close();
    }
}