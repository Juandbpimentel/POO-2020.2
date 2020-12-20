package Itens;

import java.util.Random;
import Jogadores.*;
public class Arma extends Item{
    private long bonusAtaque;

    public Arma(){
        this.bonusAtaque = 5;
        this.tipoDeItem = "Arma ";
        nivel = 1;
        nome = "Espada de madeira";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public Arma(long nivel, String nome){
        super(nivel,nome);
        Random randomizador = new Random();
        this.bonusAtaque = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
        this.tipoDeItem = "Arma ";
    }
    
    @Override
    public boolean serComprado(Jogador jogador){
        if(jogador.getMoney() >= this.preco){
            if(jogador.equiparArma(this)){
                jogador.gastarDinheiro(preco);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean dropar(Jogador jogador){
        if(jogador.equiparArma(this)){
            return true;
        }
        return false;
    }
    
    @Override
    public void quebrar(long dano){
        if(this.quebrado){
            System.out.println("Desequipe sua arma ou concerte ela");
            return;
        }
        if(dano <= 10){
            durabilidade--;
        }else if(dano > 10){
            durabilidade -= dano/100; 
        }
    }

    public long getBonusAtaque() {
        Random randomizador = new Random();
        return (bonusAtaque + randomizador.nextInt((int)bonusAtaque/(int)nivel) );
    }
    @Override
    public String toString() {
        String nome          = "| Nome: "+ this.nome, 
        nivel         = " | Nivel: "+ this.nivel,
        bonusAtaque   = " | Dano extra: "+ this.bonusAtaque,
        preco         = " | Preço: "+ this.preco,
        durabilidade  = " | Durabilidade: "+this.durabilidade +"/"+durabilidadeMax+" |",
        quebrado      = " | Estado: "+ ((this.quebrado)?"Quebrado":"Utilizável")+" |" ;

        String saida = nome + nivel + bonusAtaque+ preco + durabilidade + quebrado;
        
        return saida;
    }
}
