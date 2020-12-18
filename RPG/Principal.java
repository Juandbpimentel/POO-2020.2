import java.util.ArrayList;
import jogadores.*;
import mobs.*;

public class Principal {
    /*public static void main(String[] args){
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
<<<<<<< HEAD

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
||||||| 3f8a7b4
    }
=======
    }*/
>>>>>>> 47f899d345c66b5e2ad36f3811574cf733344df0
    
    public static void main(String[] args){
        ArrayList<Mob> batalha = new ArrayList<Mob>();
        batalha.add(new Mob(20,"Ogro"));
        batalha.add(new Mob(3,"Dobby"));
        Jogador sarah = new Mago();

        for (Mob mob : batalha) {
            System.out.println(mob);
        }

        System.out.println(sarah);
        for(int i =0; i<100;i++){
            System.out.println(sarah.atacar());
        }
    }

}
