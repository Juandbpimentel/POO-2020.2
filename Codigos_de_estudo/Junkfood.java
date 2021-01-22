import java.util.Scanner;
import java.util.ArrayList;

public class Junkfood{
    public static void main(String[] args){
        Maquina teste = new Maquina(5,20);
        teste.inserirDinheiro(15);
        System.out.println(teste);
        if(teste.inserirDinheiro(15)){
            System.out.println("Inserção bem sucedida");
        }else{
            System.out.println("Inserção mal sucedida");
        }
        System.out.println(teste);
        // altera 0 nome 15 2.50
    }
}

class Espiral {
    String nome; 
    int qtd;
    float preco;

    Espiral(String nome, int qtd, float preco){
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String toString(){
        return this.nome + ":" + this.qtd + ":" + this.preco;
    }
}

class Maquina {
    private ArrayList<Espiral> espirais;

    private float saldoCliente;
    private float lucro;
    private int maxProdutos;

    private int indexOf(String nome){
        for(int i = 0; i < espirais.size(); i++){
            Espiral espiral = espirais.get(i);
            if(espiral != null && espiral.nome.equals(nome)){
                return i;
            }
        }
        return -1;
    }

    private Espiral find(String nome){
        for(int i = 0; i < espirais.size(); i++){
            Espiral espiral = espirais.get(i);
            if(espiral != null && espiral.nome.equals(nome)){
                return espiral;
            }
        }
        return null;
    }

    boolean inserirDinheiro(int valor){
        if(valor<=0)
            return false;
        this.saldoCliente += valor;
        return true;
    }

    void pedirTroco(){

    }

    void vender(int index){

    }

    void alterarEspiral(int index, String nome, int qtd, float preco){

    }

    boolean limparEspiral(int index){
        if(index < 0 || index > espirais.size())
            return false;
        if(espirais.get(index) == null)
            return false;
        
        this.espirais.set(index,null);
        return true;
    }


    public Maquina (int tamanho, int maxProdutos){
        espirais = new ArrayList<Espiral>();
        for(int i = 0; i < tamanho; i++)
            espirais.add(null);
    }

    public String toString(){
        String saida = new String("[ ");
        for(Espiral espiral : espirais){
            if(espiral == null)
                saida += "- ";
            else 
                saida += espiral + " ";
        }
        return saida + "]\nSaldo Atual: "+ this.saldoCliente;
    }

}