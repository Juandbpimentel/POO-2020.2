package itens;

import java.util.Random;

import jogadores.*;

public class Item {
    protected String tipoDeItem;
    protected long nivel;
    protected String nome;
    protected long preco;
    protected long durabilidade;
    protected long durabilidadeMax;
    protected boolean quebrado;

    public Item(){
        tipoDeItem = "Item Básico";
        nivel = 1;
        nome = "Item básico";
        preco = 10;
        durabilidade = 5;
        durabilidadeMax = 5;
        quebrado = false;
    }

    public Item(long nivel){

        Random randomizador = new Random();
        if(nivel<0)
        nivel=1;
        
        this.nivel = nivel;
        
        preco = 20 * (long) Math.pow(2,randomizador.nextInt((int) nivel)+1);

        if (nivel <= 5){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Osso";
            }else{
                this.preco+=5000;
                this.nome = "Frasco de água da fonte de juventude";
            }
        }else if (nivel <=50 && nivel > 5) {
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Livro de Magias";
            }else{
                this.preco+=20000;
                this.nome = "Espelho de nobre";
            }
        }else if (nivel <=100 && nivel > 50){
            if(randomizador.nextInt(100)+1>5){
                this.nome = "Pergaminho com runas estranhas";
            }else{
                this.nome = "Colar de chifre de unicórnio";
                this.preco+=50000;
            }
        }else if (nivel > 100) {
            if(randomizador.nextInt(10000)+1>1){
                this.nome = "Estátua de ouro";
                this.preco+= (long) 9999999;
            }else{
                this.nome = "Chave pra outro universo";
                this.preco = 0;
            }
        }


        durabilidadeMax = (10+nivel) * (long) (randomizador.nextInt((int) nivel*10)+1);

        durabilidade = durabilidadeMax;

        quebrado = false;
        
        tipoDeItem = "Item Básico";
    }

    public boolean serComprado(Jogador jogador){
        if(jogador.getDinheiro() >= this.preco){
            if(jogador.guardarNaMochila(this)){
                jogador.gastarDinheiro(preco);
                return true;    
            }else
                return false;    
        }
        return false;
    }

    public boolean concertar(Jogador jogador){
        if (jogador.getDinheiro() >= this.preco) {
            jogador.gastarDinheiro(preco);
            this.durabilidade = this.durabilidadeMax;
            return true;
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
            if (durabilidade <= 0) {
                quebrado = true;
            }
        }else if(dano > 10){
            durabilidade -= dano/10; 
            if (durabilidade <= 0) {
                quebrado = true;
            }
        }
    }

    public String toString() {
        String nome = " | Nome: " + this.nome, nivel = " | Nivel: " + this.nivel, preco = " | Preço: " + this.preco,
                durabilidade = " | Durabilidade: " + this.durabilidade + "/" + durabilidadeMax,
                quebrado = " | Estado: " + ((this.quebrado)?"Quebrado":"Utilizável");

        String saida = nome + nivel + preco + durabilidade + quebrado;

        return saida ;
    }

    public String getTipoDeItem() {
        return tipoDeItem;
    }

    public boolean eEscudo(){
        if(this.getTipoDeItem().equals("Escudo"))
            return true;
        return false;
    }

    public boolean eArmadura(){
        if(this.getTipoDeItem().equals("Armadura"))
            return true;
        return false;
    }

    public boolean eArma(){
        if(this.getTipoDeItem().equals("Arma"))
            return true;
        return false;
    }

    public long getPreco() {
        return preco;
    }

    public long getDurabilidade() {
        return durabilidade;
    }
    
}
