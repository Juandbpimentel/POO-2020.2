import java.util.ArrayList;

class Crianca {
    String nome;
    int idade;

    Crianca(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return nome+":"+idade;
    }
}

public class PulaPula{
    ArrayList<Crianca> esperando;
    ArrayList<Crianca> brincando;

    
    PulaPula(){
        esperando = new ArrayList<Crianca>();
        brincando = new ArrayList<Crianca>();
    }
    
    void chegarCriança(Crianca crianca){
        esperando.add(0,crianca);    
    }

    void entrar(){
        if(esperando.isEmpty())
            return;
        Crianca primeira = esperando.remove(esperando.size()-1);
        brincando.add(0,primeira);
    }
    
    void sair(){
        if(brincando.isEmpty())
            return;

        Crianca primeira = brincando.remove(brincando.size()-1);
        esperando.add(0,primeira);
    }

    public Crianca remover(String nome){
        for (Crianca crianca : brincando) {
            if(crianca.nome.equals(nome)){
                return brincando.remove(brincando.indexOf(crianca));
            }
        }

        for (Crianca crianca : esperando) {
            if(crianca.nome.equals(nome)){
                return esperando.remove(esperando.indexOf(crianca));
            }
        }
        System.out.println("Criança não encontrada");
        return null;
    }
    
    public String toString() {
        return "Esperando => "+ ((esperando.size()>0)?esperando:"[Vazio]") +"\nBrincando => "+ ((brincando.size()>0)?brincando:"[Vazio]") +"\n\n";
    }

    public static void main(String[] args){
        PulaPula pula = new PulaPula();
        System.out.println(pula);
        pula.chegarCriança(new Crianca("Robertinho",5));
        System.out.println(pula);
        pula.chegarCriança(new Crianca("Anna",3));
        System.out.println(pula);
        pula.chegarCriança(new Crianca("Pedro",1));
        System.out.println(pula);
        pula.entrar();
        System.out.println(pula);
        pula.entrar();
        System.out.println(pula);
        pula.entrar();
        System.out.println(pula);
        pula.sair();
        System.out.println(pula);
        pula.remover("Robertinho");
        System.out.println(pula);
        pula.remover("Pedro");
        System.out.println(pula);
        pula.sair();
        System.out.println(pula);
        pula.remover("Anna");
        System.out.println(pula);
    }
}
