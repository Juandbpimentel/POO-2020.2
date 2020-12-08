import jogadores.*;
import mobs.*;

public class Principal {
    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
        //int defesa_jogador=0,defesa_mob=0,ataque_jogador=0,ataque_mob=0;
    
        //Mob inimigo = new Goblin();
        //Mago mago = new Mago();
        //jogador.main(args);
        Jogador mago = new Mago();
        Goblin goblin = new Goblin();
        System.out.println(goblin);
        mago.show();
        System.out.println(mago);
        for (int i = 0; i < 100; i++) {
            mago.atacar();
        }
    }
    

}
