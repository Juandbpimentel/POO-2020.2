package itens;

import java.util.Random;

import jogadores.*;
public class Arma extends Item{
    private long bonusAtaque;

    public Arma(){
        this.bonusAtaque = 5;
        this.tipoDeItem = "Arma";
        nivel = 1;
        nome = "Espada de madeira";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public Arma(long nivel){
        super(nivel);
        Random randomizador = new Random();


        if (nivel <= 5){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Faca de cozinha";
            }else{
                this.preco+=5000;
                this.nome = "Peixeira";
            }
        }else if (nivel <=50 && nivel > 5) {
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Espada enferrujada";
            }else{
                this.preco+=20000;
                this.nome = "Espada de treino";
            }
        }else if (nivel <=100 && nivel > 50){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Espada de ferro";
            }else{
                this.nome = "Espada de aço";
                this.preco+=50000;
            }
        }else if (nivel > 100) {
            if(randomizador.nextInt(10000)+1>1){
                this.nome = "Espada Nobre";
                this.preco+= (long) 9999999;
            }else{
                this.nome = "Espada de aço valiriano do herói";
                this.preco = 0;
            }
        }          

        this.bonusAtaque = (5)*nivel + (long) Math.pow(2,randomizador.nextInt((int) nivel)) ;
        this.tipoDeItem = "Arma";
    }
    
    public boolean serComprado(Jogador jogador, boolean equipar){
        if(jogador.getDinheiro() >= this.preco){
            if(equipar){
                if(jogador.equiparArma(this)){
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
    
    public String toString() {
        String nome   = " | Nome: "+ this.nome, 
        nivel         = " | Nivel: "+ this.nivel,
        bonusAtaque   = " | Dano extra: "+ this.bonusAtaque,
        preco         = " | Preço: "+ this.preco,
        durabilidade  = " | Durabilidade: "+this.durabilidade +"/"+durabilidadeMax,
        quebrado      = " | Estado: "+ ((this.quebrado)?"Quebrado":"Utilizável") ;

        String saida = nome + nivel + bonusAtaque+ preco + durabilidade + quebrado;
        
        return saida;
    }
}
