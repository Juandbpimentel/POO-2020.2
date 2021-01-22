package mobs;

import java.util.Random;

public class Slime extends Mob {
    public static String corCritico = "\u001B["+ "36" + "m";
    
    Slime(int nivel){
        this.nome = "Slime";
        this.vivo = true;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.gerarItens((long)nivel);
        this.dinheiro = ( 5 * (long) Math.pow(2,this.nivel));
        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }

        if(nivel>0){
            int div = (nivel-1) /2;
            int div2 = (nivel-1)-div;
            this.constituicao = 1 + div2+div/2;
            this.inteligencia = 1;
            this.forca = 1 + div/2;    
        }
        for(int i = 0; i < nivel; i++){
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 2) * nivel);
        }
        
        this.vida=vidaMax;
        this.mana=manaMax;
        
        if(this.nivel >= 1 &&  this.nivel < 50) {
            this.nome += " Azul";
        }else if(this.nivel>=50 && this.nivel<250){
            this.nome += " Grande";
        }else if(this.nivel>=250 && this.nivel<500){
            this.nome += " Espinhoso";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.nome += " Alado";
        }else if(this.nivel>=1000){
            this.nome = "Rei dos Slimes";
        }
    }

    Slime(int nivel, String nome){
        this.nome = nome;
        this.vivo = true;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.gerarItens((long)nivel);
        this.pocoes = nivel/4;
        this.dinheiro = ( 5 * (long) Math.pow(2,this.nivel));
        if (pocoes<=0) {
            pocoes =1;
        }

        if(nivel>1){
            int div = (nivel-1) /2;
            int div2 = (nivel-1)-div;
            this.constituicao = 1 + div2;
            this.inteligencia = 1;
            this.forca = 1 + div;    
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
        
        if(this.nivel >= 1 &&  this.nivel < 50){
            this.nome += ", o Slime Azul";
        }else if(this.nivel>=50 && this.nivel<250){
            this.nome += ", o Slime Grande";
        }else if(this.nivel>=250 && this.nivel<500){
            this.nome += ", o Slime Espinhoso";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.nome += ", o Slime Alado";
        }else if(this.nivel>=1000){
            this.nome += ", o Rei dos Slimes";
        }
    }
    @Override
    public long atacar(){
        if(!vivo){
            return 0;
        }

        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100);
        
        if((rand+1)>1+(0.1*nivel)+(0.1*forca)){

            rand = (random.nextInt(this.nivel));
            atacar = (this.forca * ((rand+1)+this.forca) );
            return atacar;
        }else{
            rand = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * ((rand+1)+this.forca));   
            System.out.print(corCritico+"!!! O seu inimigo acertou um ataque crítico !!!");
            System.out.println(limparCorTexto);
            return atacar;    
        }
    }
    @Override
    public long defender(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long defender = 0;
        long rand = random.nextInt(100);
        if((rand+1)>1+(0.1*nivel)){
            rand = (random.nextInt(this.nivel));

            defender = (constituicao *(rand+1));

        }else{
            rand = (random.nextInt(this.nivel));

            defender = (long) 4*(constituicao*(rand+1));   
            System.out.print(corCritico+"!!! Seu inimigo executou uma desefa perfeita !!!"); 
            System.out.println(limparCorTexto);
        }
        return defender;
    }
}
