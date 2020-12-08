enum Moeda {
    M10(0.10f, 1),
    M25(0.25f, 2),
    M50(0.50f, 3),
    M100(1f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString(){
        return "Valor: " + valor + "\nVolume: " + valor + "\n";
    }
}

class Coisa {
    String descricao;
    int volume;

    Coisa(String descricao, int volume) {
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString() {
        return "Descricao:" + descricao + "\nVolume: " + volume + "\n";
    }
}



class Porco{
    String itens = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;
    
    Porco(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    boolean adicionarDinheiro(Moeda moeda){
        if(estaQuebrado){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(moeda.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }
    boolean adicionarCoisa(Coisa itens){
        if(estaQuebrado){
            System.out.println("O porco está quebrado");
            return false;
        }
        if(itens.volume+this.volume > this.volumeMax){
            System.out.println("O porco está lotado");
            return false;
        }
        this.itens+=itens.descricao+" ";
        this.volume+= itens.volume;
        return true;
    }

    boolean quebrar(){
        if(estaQuebrado){
            System.out.println("O cofre já está quebrado");
            return false;
        }
        this.estaQuebrado = true;
        System.out.println("*crash*");
        return true;
    }

    float pegarDinheiro(){
        if(!estaQuebrado){
            System.out.println("O cofre ainda não foi quebrado, você precisa quebra-lo primeiro");
            return 0.0f;
        }
        float temp = this.valor;
        this.valor = 0;
        return temp;
    }

    String pegarCoisa(){
        if(!estaQuebrado){
            System.out.println("O cofre ainda não foi quebrado, você precisa quebra-lo primeiro");
            return "";
        }
        String temp = this.itens;
        this.itens = "";
        return temp;
    }

    public String toString(){
        return "Itens: " + this.itens + " | Valor: " + this.valor + " | " + this.volume + "/" + this.volumeMax + " | Quebrado: "+ estaQuebrado;
    }

    void mostrarPorco(){
        System.out.println(this);
    }
    
}

public class Riquinho{
    public static void main(String[] args) {
        Porco porco = new Porco(40);
        porco.mostrarPorco();
        porco.adicionarDinheiro(Moeda.M10);
        porco.mostrarPorco();
        porco.adicionarDinheiro(Moeda.M10);
        porco.adicionarDinheiro(Moeda.M25);
        porco.adicionarDinheiro(Moeda.M50);
        porco.mostrarPorco();
        porco.adicionarCoisa(new Coisa("Nota de 1 Real",5));
        porco.adicionarCoisa(new Coisa("Nota de 2 Reais",7));
        porco.adicionarCoisa(new Coisa("Nota de 5 Reais",9));
        porco.adicionarCoisa(new Coisa("Nota de 10 Reais",10));
        porco.mostrarPorco();
    }
}
