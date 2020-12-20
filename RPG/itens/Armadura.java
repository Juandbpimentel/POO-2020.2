package itens;

import java.util.Random;

import jogadores.*;

import java.lang.Math;

public class Armadura extends Item {
    private long bonusDefesa;
    public Armadura(long nivel, String nome){
        super(nivel,nome);
        this.tipoDeItem = "Armadura ";
        Random randomizador = new Random();
        this.bonusDefesa = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
    }

    public Armadura(){
        this.tipoDeItem = "Armadura ";
        this.bonusDefesa = 5;
        nivel = 1;
        nome = "Armadura de Couro Velho";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    @Override
    public boolean serComprado(Jogador jogador){
        if(jogador.getMoney() >= this.preco){
            if(jogador.equiparArmadura(this)){
                jogador.gastarDinheiro(preco);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean dropar(Jogador jogador){
        if(jogador.equiparArmadura(this)){
            
            return true;
        }
        return false;
    }

    public long getBonusDefesa() {
        Random randomizador = new Random();
        return (long) (bonusDefesa + randomizador.nextInt((int) bonusDefesa/ (int) nivel) );
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
