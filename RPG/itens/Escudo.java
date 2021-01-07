package itens;

import java.util.Random;

import jogadores.*;

import java.lang.Math;

public class Escudo extends Item{
    private long bonusDefesa;
    
    public Escudo(){
        this.tipoDeItem = "Escudo";
        this.bonusDefesa = 5;
        nivel = 1;
        nome = "Escudo de treino";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public Escudo(long nivel){
        super(nivel);
        Random randomizador = new Random();

        if (nivel <= 10){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Pedaço de porta";
            }else{
                this.preco+=5000;
                this.nome = "Escudo de treino velho";
            }
        }else if (nivel <=50 && nivel > 10) {
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Escudo de treino";
            }else{
                this.preco+=20000;
                this.nome = "Escudo de Soldado Raso";
            }
        }else if (nivel <=100 && nivel > 50){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Escudo de Ferro";
            }else{
                this.nome = "Escudo de Aço";
                this.preco+=50000;
            }
        }else if (nivel > 100) {
            if(randomizador.nextInt(10000)+1>1){
                this.nome = "Escudo de Ouro";
                this.preco+= (long) 9999999;
            }else{
                this.nome = "Escudo de aço valiriano do herói";
                this.preco = 0;
            }
        }
        
        this.bonusDefesa = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
        this.tipoDeItem = "Escudo";   
    }
    
    public boolean serComprado(Jogador jogador, boolean equipar){
        if(jogador.getDinheiro() >= this.preco){
            if(equipar){
                if(jogador.equiparEscudo(this)){
                    jogador.gastarDinheiro(preco);
                    return true;
                }else if(jogador.guardarNaMochila(this)){
                    jogador.gastarDinheiro(preco);
                    return true;    
                }else
                    return false;

            }else if(jogador.guardarNaMochila(this)){
                jogador.gastarDinheiro(preco);
                return true;    
            }else
                return false;    
        }
        return false;
    }

    public long getBonusDefesa(){
        Random randomizador = new Random();
        return (long) (bonusDefesa + randomizador.nextInt( (int) bonusDefesa/ (int) nivel) );
    }
    
    public String toString() {
        String nome   = " | Nome: "+ this.nome, 
        nivel         = " | Nivel: "+ this.nivel,
        bonusDefesa   = " | Proteção: "+ this.bonusDefesa,
        preco         = " | Preço: "+ this.preco,
        durabilidade  = " | Durabilidade: "+this.durabilidade +"/"+durabilidadeMax,
        quebrado      = " | Estado: "+ ((this.quebrado)?"Quebrado":"Utilizável") ;

        String saida = nome + nivel + bonusDefesa+ preco + durabilidade + quebrado;
        
        return saida;
    }
}
