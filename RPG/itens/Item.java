package itens;

public class Item {
    protected int nivel;
    protected int nome;
    protected int preco;
    protected int durabilidade;

    public Item comprar(){
        return null;
    }

    public boolean concertar(){
        return false;
    }

    public void quebrar(int dano){
        if(dano <= 10){
            durabilidade--;
        }else if(dano > 10){
            durabilidade -= dano/10; 
        }
    }
}
