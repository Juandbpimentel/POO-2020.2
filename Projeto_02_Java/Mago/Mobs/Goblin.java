package Mobs;
//import java.util.Random;

public class Goblin extends Mob {
    public Goblin(){
        super();
        super.name = "Goblin";
    }
    // x = 1/2 = 0 ; y = 1-x = 1-0 = 1;
    // x = 3/2 = 1 ; y = 2-x = 3-1 = 2;
    // x = 5/2 = 2 ; y = 5-x = 5-2 = 1;
    public Goblin(int nivel,String nome){
        super(nivel, nome);
        this.vivo = true;
        this.vidaMax=0;
        this.manaMax=0;
        if(nivel>1){
            int div = (nivel-1) /2;
            int div2 = (nivel-1)-div;
            this.constituicao = 1 + div;
            this.inteligencia = 1;
            this.forca = 1 + div2;    
        }else{
            this.constituicao = 1;
            this.inteligencia = 1;
            this.forca = 1;
        }
        for(int i = 0; i < nivel; i++){
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 2) * nivel);
        }

        this.vidaAtual=vidaMax;
        this.manaAtual=manaMax;

        if(this.nivel >= 1 &&  this.nivel < 50) {
            this.name += " Desatrado";
        }else if(this.nivel>=50 && this.nivel<250){
            this.name += " Escudeiro";
        }else if(this.nivel>=250 && this.nivel<500){
            this.name += " Veterano";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.name += " Comandante";
        }else if(this.nivel>=1000){
            this.name = "Rei dos Goblin";
        }
    }

}
