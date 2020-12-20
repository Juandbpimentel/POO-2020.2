package Mobs;

import java.util.Random;
import java.util.Scanner;

import Jogadores.Jogador;
public class Mob{
    public static String corCritico = "\u001B["+ "31" + "m";
    public static String limparTexto = "\u001B["+"m";

    String nome;
    protected long vida;
    protected long vidaMax;
    protected long mana;
    protected long manaMax;
    protected long pocoes;
    protected long dinheiro;
    protected int forca;
    protected int constituicao;
    protected int inteligencia;
    protected int nivel;
    protected boolean vivo;
    
    public static Scanner scan = new Scanner(System.in);

    //Construtores
    public Mob(String nome, int nivel,int forca ,int constituicao ,int inteligencia){
        this.vivo = true;
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.forca = forca;

        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }

        for (int i = 0; i < nivel; i++){
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 5) * nivel);
        }
        
        this.vida=vidaMax;
        this.mana=manaMax;
    }
    
    public Mob(int nivel, String nome){
        this.nome = nome;
        this.vivo = true;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        
        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }

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
        
        this.vida=vidaMax;
        this.mana=manaMax;
        
        if(this.nivel >= 1 &&  this.nivel < 50) {
            this.nome += " Desatrado";
        }else if(this.nivel>=50 && this.nivel<250){
            this.nome += " Escudeiro";
        }else if(this.nivel>=250 && this.nivel<500){
            this.nome += " Veterano";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.nome += " Comandante";
        }else if(this.nivel>=1000){
            this.nome = "Rei dos(as) "+this.nome+"s" ;
        }
    }
    
    public Mob(){
        this.nome = "Slime";
        this.vivo = true;
        this.nivel = 1;
        this.vidaMax=0;
        this.manaMax=0;
        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }
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
        
        this.vida=vidaMax;
        this.mana=manaMax;
        
        if(this.nivel >= 1 &&  this.nivel < 50) {
            this.nome += " Desatrado";
        }else if(this.nivel>=50 && this.nivel<250){
            this.nome += " Experiente";
        }else if(this.nivel>=250 && this.nivel<500){
            this.nome += " Veterano";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.nome += " Mestre";
        }else if(this.nivel>=1000){
            this.nome = "Rei dos Slimes";
        }
    }
    
    public String getNome() {
        return nome;
    }
    
    public String toString(){
        String nome = "| Monstro: "+ this.nome, 
        mana = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida = " | Vida: "+ this.vida+"/"+this.vidaMax,
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
    
    long droparXp(){
        return (long)( 1.25 * Math.pow(2,this.nivel));
    }

    long droparDinheiro(){
        return ( 5 * (long) Math.pow(2,this.nivel));
    }

    void receberAtaque(Jogador inimigo, boolean defender){
        if(!vivo){
            System.out.println("Seu inimigo já está morto, não seja um monstro como ele");
            return;
        }
        long defesa = 0;
        long dano = inimigo.atacar();

        if(defender){
            defesa = this.defender();
        }

        Random rand = new Random();
        long calculoDano = defesa-dano; 
        this.vida += calculoDano;

        if(defesa-dano<=0){
            if(vida>= vidaMax/2){
                switch (rand.nextInt(3)) {
                    case 0:
                        System.out.println(this.nome+" diz - Ai!!! Seu merdinha, você vai pagar!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.nome+" diz - Ouch! Seu maldito, quero ver você acertar de novo, tenho certeza que foi pura sorte!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    case 2:
                        System.out.println(this.nome+" diz - Humpf! *Cospe um dente* É só isso que você tem? Não dá nem pro gasto!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    default:
                        break;
                }
            }else if(vida< vidaMax/2 && vida > vidaMax/4){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println(this.nome+" diz - Grrrrrrr! *O inimigo grune de dor*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.nome+" diz - Ahrg hurrrm *Seu inimigo está bem machucado e sangrando*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    default:
                        break;
                }
            }else if(vida < vidaMax/4 && vida > 0){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println(this.nome+" diz - Agrhrrr que dor, eu não vou aguentar muito mais, mas não vou deixar que passe por mim\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    case 1:
                        System.out.println(this.nome+" diz - Ughrrr *Seu inimigo cospe sangue*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano");   
                        break;
                    default:
                        break;
                }
            }else if(vida <= 0){
                System.out.println(this.nome+" diz - Aahhgrrrrrr! *O inimigo cai inerte no chão*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano e morreu");
                this.vivo=false;
            }
                
        }else{
            System.out.println("Hahahaha, não foi dessa vez moleque! - diz " + this.nome);
        }
    }

    public long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1+(0.1*nivel)+(0.1*forca)){
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.forca * ((rand2+1)+this.forca));
        }else{
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * ((rand2+1)+this.forca));   
            System.out.print(corCritico+"!!!Você acertou um Ataque Crítico!!!");
            System.out.println(limparTexto);    
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
            System.out.print(corCritico+">>> Defesa Perfeita do inimigo: "+defender);
            System.out.println(limparTexto); 

        }
        return defender;
    }

    public String show(){
        String nome = "| Nome: "+ this.nome, 
        mana   = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida   = " | Vida: "+ this.vida+"/"+this.vidaMax;

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

    public boolean checarVivo(){
        return this.vivo;
    }
    
}
