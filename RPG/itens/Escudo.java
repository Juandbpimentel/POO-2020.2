package itens;

import java.util.Random;

import jogadores.*;

import java.lang.Math;

public class Escudo extends Item{
    private long bonusDefesa;
    public Escudo(){
        this.tipoDeItem = "Escudo ";
        this.bonusDefesa = 5;
        nivel = 1;
        nome = "Escudo de treino";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public Escudo(long nivel, String nome){
        super(nivel,nome);
        Random randomizador = new Random();
        this.bonusDefesa = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
        this.tipoDeItem = "Escudo ";   
    }
    
    @Override
    public boolean serComprado(Jogador jogador){
        if(jogador.getMoney() >= this.preco){
            if(jogador.equiparEscudo(this)){
                jogador.gastarDinheiro(preco);
                return true;
            }
            return false;    
        }
        return false;
    }

    public boolean dropar(Jogador jogador){
        if(jogador.equiparEscudo(this)){
            return true;
        }
        return false;
    }

    public long getBonusDefesa(){
        Random randomizador = new Random();
        return (long) (bonusDefesa + randomizador.nextInt( (int) bonusDefesa/ (int) nivel) );
    }
    
    @Override
    public String toString() {
        String nome    = "| Nome: "+ this.nome, 
        nivel         = " | Nivel: "+ this.nivel,
        bonusDefesa   = " | Proteção: "+ this.bonusDefesa,
        preco         = " | Preço: "+ this.preco,
        durabilidade  = " | Durabilidade: "+this.durabilidade +"/"+durabilidadeMax,
        quebrado      = " | Estado: "+ ((this.quebrado)?"Quebrado":"Utilizável")+" |" ;

        String saida = nome + nivel + bonusDefesa+ preco + durabilidade + quebrado;
        
        return saida;
    }
}
