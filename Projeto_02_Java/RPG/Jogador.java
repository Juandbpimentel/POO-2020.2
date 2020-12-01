//import java.util.Scanner;
public class Jogador extends Personagens{

    Jogador(String name, int manaMax, int vidaMax){
        super(name, 1);
    }

    public String toString(){
        String nome = "| Nome: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax,
        xp   = " | Xp: " + this.xp_atual+"/" + this.xp_para_upar,
        nivel= " | Nivel: "+ this.nivel;
        return nome + mana + vida + xp + nivel;
    }

    void receber_xp(int xp){

    }

    int atacar(){
        int atacar = (this.forca + this.forca*nivel);
        if(atacar <= 0){
            return 1;
        }else
            return atacar;
    }

    int defender(){
        int defender = (this.constituicao + (this.constituicao*nivel)/2);
        if (defender <=0){
            return 1;
        }else
            return defender;
    }
}
