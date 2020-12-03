package Jogadores;

import java.util.Random;

public class Mago extends Jogador {
    public static String cor_critico = "\u001B["+ "35" + "m";
    public static String limpar_texto = "\u001B["+"m";

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
        }else{
            rand = (random.nextInt(this.inteligencia));
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.inteligencia * (rand2+1)*this.inteligencia);   
            System.out.print(cor_critico+"!!! A magia está do seu lado, você acertou um Ataque Crítico !!!");    
            System.out.println(limpar_texto);
        }
        return atacar;
    }


}
