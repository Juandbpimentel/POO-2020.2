package itens;

import java.util.Random;

import jogadores.*;

import java.lang.Math;

public class Armadura extends Item {
    private long bonusDefesa;
    
    public Armadura(long nivel){
        super(nivel);
        
        Random randomizador = new Random();


        if (nivel <= 5){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Roupa rasgada";
            }else{
                this.preco+=5000;
                this.nome = "Roupa velha";
            }
        }else if (nivel <=50 && nivel > 5) {
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Armadura de couro velho";
            }else{
                this.nome = "Roupa de Guarda";
                this.preco+=20000;
            }
        }else if (nivel <=100 && nivel > 50){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Armadura de couro trabalhado";
            }else{
                this.nome = "Cota de malha";
                this.preco+=50000;
            }
        }else if (nivel > 100) {
            if(randomizador.nextInt(10000)+1>1){
                this.nome = "Armadura de ouro";
                this.preco+= (long) 9999999;
            }else{
                this.nome = "Armadura de anéis de Mithril do herói";
                this.preco = 0;
            }
        }
        
        this.tipoDeItem = "Armadura";
        this.bonusDefesa = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
    }

    public Armadura(){
        this.tipoDeItem = "Armadura";
        this.bonusDefesa = 5;
        nivel = 1;
        nome = "Armadura de Couro Velho";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public boolean serComprado(Jogador jogador, boolean equipar){
        if(jogador.getDinheiro() >= this.preco){
            if(equipar){
                if(jogador.equiparArmadura(this)){
                    jogador.gastarDinheiro(preco);
                    return true;
                }else if(jogador.guardarItem(this)){
                    jogador.gastarDinheiro(preco);
                    return true;    
                }else
                    return false;

            }else if(jogador.guardarItem(this)){
                jogador.gastarDinheiro(preco);
                return true;    
            }else
                return false;    
        }
        return false;
    }

    public boolean dropar(Jogador jogador, boolean equipar){
        if(equipar){
            if(jogador.equiparArmadura(this)){
                return true;
            }
            return false;

        }else if(jogador.guardarItem(this)){
            return true;    
        }else
            return false;   
    }

    public long getBonusDefesa() {
        Random randomizador = new Random();
        return (long) (bonusDefesa + randomizador.nextInt((int) bonusDefesa/ (int) nivel) );
    }

    public String toString() {
        String nome   = " | Nome: "+ this.nome, 
        nivel         = " | Nivel: "+ this.nivel,
        bonusDefesa   = " | Proteção: "+ this.bonusDefesa,
        preco         = " | Preço: "+ this.preco,
        durabilidade  = " | Durabilidade: "+this.durabilidade +"/"+durabilidadeMax,
        quebrado      = " | Estado: "+ ((this.quebrado)?"Quebrado":"Utilizável");

        String saida = nome + nivel + bonusDefesa+ preco + durabilidade + quebrado;

        return saida;
    }
}
