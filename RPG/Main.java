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
            System.out.print("Digite a opção: ");
            line = in.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("Loja")){
                loja.menuCompra(jogador);
            }else if(ui[0].equals("Batalhar")){
                new Luta( Mob.criarMob(Integer.parseInt(ui[1])),jogador);
            
            }else if(ui[0].equals("Sair")){
                break;
            }
            
        }
        //compra de itens


        in.close();
    }

    public void lutarMenu(Jogador jogador, Mob inimigo) {
        while (true) {
            if (!jogador.checarVivo()) {
                System.out.println("Você foi derrotado por " + inimigo.getNome());
                break;
            }

            if (!inimigo.checarVivo()) {
                System.out.println("Você derrotou " + inimigo.getNome());
                break;
            }
        }
    }
}