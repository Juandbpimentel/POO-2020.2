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

    public Item(long nivel, String nome){

        Random randomizador = new Random();
        this.nivel = nivel;
        this.nome = nome;

        preco = 20 * (long) Math.pow(2,randomizador.nextInt((int) nivel)+1);

        durabilidadeMax = (10+nivel) * (long) (randomizador.nextInt((int) nivel*10)+1);

        durabilidade = durabilidadeMax;

        quebrado = false;
        
        tipoDeItem = "Item Básico";
    }

    public boolean serComprado(Jogador jogador){
        if(jogador.getMoney() >= this.preco){
            if(jogador.guardarItem(this)){
                jogador.gastarDinheiro(preco);
                return true;
            }
            return false;    
        }
        return false;
    }

    //public boolean dropar(Jogador jogador){
    //    if(jogador.guardarItem(this)){
    //        return true;
    //    }
    //    return false;
    //}

    public boolean concertar(Jogador jogador){
        if (jogador.getMoney() >= this.preco) {
            jogador.gastarDinheiro(preco);
            this.durabilidade = this.durabilidadeMax;
            return true;
        }
        return false;
    }

    public void quebrar(long dano) {
        if (this.quebrado){
            System.out.println("Desequipe sua arma ou concerte ela");
            return;
        }
        if (dano <= 10) {
            durabilidade--;
        } else if (dano > 10) {
            durabilidade -= dano / 10;
        }
    }

    public String toString() {
        String nome = " | Nome: " + this.nome, nivel = " | Nivel: " + this.nivel, preco = " | Preço: " + this.preco,
                durabilidade = " | Durabilidade: " + this.durabilidade + "/" + durabilidadeMax + " |",
                quebrado = " | Quebrado: " + this.quebrado + " |";

        String saida = nome + nivel + preco + durabilidade + quebrado;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        }
        return "\n\n\n" + saida + "\n\n\n";
    }

    public String getTipoDeItem() {
        return tipoDeItem;
    }
}
