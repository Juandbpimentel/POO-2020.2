package Jogadores;

import java.util.Random;

public class Mago extends Jogador {

    Mago(String name){
        super("Mago Implacável "+name, 1);
    }

    Mago(String name, int nivel){
        super("Mago Implacável "+name, nivel);
    }

    public Mago() {
        super();
        this.name = "Mago Implacável " + name;
	}

	@Override
    public long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1){
            rand = (random.nextInt(this.inteligencia));
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.inteligencia * (rand2+1)*this.inteligencia);
            System.out.println(">>> Ataque Normal: "+atacar);
        }else{
            rand = (random.nextInt(this.inteligencia));
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.inteligencia * (rand2+1)*this.inteligencia);   
            System.out.println(">>> Ataque Crítico: "+atacar);    
        }
        return atacar;
    }


}
