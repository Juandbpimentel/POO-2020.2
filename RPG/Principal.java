import Mobs.*;

//import java.util.Scanner;

import Jogadores.*;

public class Principal {
    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
        //int defesa_jogador=0,defesa_mob=0,ataque_jogador=0,ataque_mob=0;
    
        //Mob inimigo = new Goblin();
        //Mago mago = new Mago();
        //jogador.main(args);
        Jogador Mago = new Mago();
        Goblin goblin = new Goblin();
        System.out.println(goblin);
        Mago.show();
        System.out.println(Mago);
        for (int i = 0; i < 100; i++) {
            Mago.atacar();
        }

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
