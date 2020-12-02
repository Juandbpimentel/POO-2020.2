import Mobs.*;

import java.util.Scanner;

import Jogadores.*;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //int defesa_jogador=0,defesa_mob=0,ataque_jogador=0,ataque_mob=0;
    
        Mob inimigo = new Goblin();
        Mago mago = new Mago();

        System.out.println(mago);
        System.out.println(inimigo);

        in.close();
    }
    

}
