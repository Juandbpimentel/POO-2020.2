package Mobs;

import java.util.Random;
import java.util.Scanner;

public class Mob{
    String name;
    long vidaAtual;
    long vidaMax;
    long manaAtual;
    long manaMax;
    int forca;
    int constituicao;
    int inteligencia;
    int nivel;
    boolean vivo;
    
    public static Scanner scan = new Scanner(System.in);

    //Construtores
    public Mob(String name, int nivel,int forca ,int constituicao ,int inteligencia){
        this.vivo = true;
        this.name = name;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.forca = forca;

        for (int i = 0; i < nivel; i++) {
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 5) * nivel);
        }
        
        this.vidaAtual=vidaMax;
        this.manaAtual=manaMax;
    }
    
    public Mob(int nivel, String nome){
        this.name = nome;
        this.vivo = true;
        this.nivel = nivel;
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
    
    public Mob(){
        this.vivo = true;
        this.name = "Slime";
        this.nivel = 1;
        this.vidaMax=5;
        this.manaMax=5;
        this.vidaAtual = vidaMax;
        this.manaAtual = manaMax;
        this.constituicao = 1;
        this.inteligencia = 1;
        this.forca = 1;
    }
    
    
    
    public String toString(){
        String nome = "| Monstro: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax,
        nivel= " | Nivel: "+ this.nivel,
        forca= " | Força: "+ this.forca,
        inteligencia= " | Inteligência: "+this.inteligencia,
        constituicao= " | Constituição: "+ this.constituicao+" |";
        
        String saida = nome + mana + vida + nivel + forca + inteligencia + constituicao;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }
    
    long dropar_xp(){
        return ( 10 * (long) Math.pow(2,this.nivel));
    }

    void sofrer_dano(long dano, long defesa){
        if(!vivo){
            return;
        }
        Random rand = new Random();
        long calculo_dano = defesa-dano; 
        this.vidaAtual += calculo_dano;

        if(defesa-dano<=0){
            if(vidaAtual>= vidaMax/2){
                switch (rand.nextInt(3)) {
                    case 0:
                        System.out.println(this.name+" diz - Ai!!! Seu merdinha, você vai pagar!\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.name+" diz - Ouch! Seu maldito, quero ver você acertar de novo, tenho certeza que foi pura sorte!\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                    case 2:
                        System.out.println(this.name+" diz - Humpf! *Cospe um dente* É só isso que você tem? Não dá nem pro gasto!\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                }
            }else if(vidaAtual< vidaMax/2 && vidaAtual > vidaMax/4){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println(this.name+" diz - Grrrrrrr! *O inimigo grune de dor*\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.name+" diz - Ahrg hurrrm *Seu inimigo está bem machucado e sangrando*\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                }
            }else if(vidaAtual < vidaMax/4 && vidaAtual > 0){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println(this.name+" diz - Agrhrrr que dor, eu não vou aguentar muito mais, mas não vou deixar que passe por mim\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.name+" diz - Ughrrr *Seu inimigo cospe sangue*\n"+"Seu inimigo levou "+calculo_dano+" de dano");   
                        break;
                }
            }else if(vidaAtual <= 0){
                System.out.println(this.name+" diz - Aahhgrrrrrr! *O inimigo cai inerte no chão*\n"+"Seu inimigo levou "+calculo_dano+" de dano e morreu");
                this.vivo=false;
            }
                
        }else{
            System.out.println("Hahahaha, não foi dessa vez moleque! - diz " + this.name);
        }
    }

    long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1){
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.forca * (rand2+1)*this.forca);
            System.out.println(">>> Ataque Normal: "+atacar);
        }else{
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * (rand2+1)*this.forca);   
            System.out.println(">>> Ataque Crítico: "+atacar);    
        }
        return atacar;
    }

    long defender(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long defender = 0;
        long rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1){
            rand2 = (random.nextInt(this.nivel));

            defender = (this.constituicao *(rand2+1)*this.constituicao);
            System.out.println(">>> Defesa: "+defender);

        }else{
            rand2 = (random.nextInt(this.nivel));

            defender = (long) 4*(this.constituicao*(rand2+1)*this.constituicao);   
            System.out.println(">>> Defesa Perfeita: "+defender); 

        }
        return defender;
    }

    public String show(){
        String nome = "| Nome: "+ this.name, 
        mana   = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida   = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax;

        String saida = nome + mana + vida;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }

    public void morrer(){
        this.vivo = false;
    }
    
}
