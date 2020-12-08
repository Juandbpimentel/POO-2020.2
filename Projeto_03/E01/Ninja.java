import java.util.Scanner;
    public class Ninja {
        public static void main(String[] args) {
            Calango dead = new Calango(100);
            Calango pool = new Calango(100);
            System.out.println(dead);
            System.out.println(pool);
    
            dead.brigar(pool);
            dead.brigar(pool);
            dead.brigar(pool);
            dead.brigar(pool);
            dead.brigar(pool);
    
            System.out.println(dead);
            System.out.println(pool);
            pool.brigar(dead);
        }
    }


class Mosquito {
    int tamanho;
    int energia;
    Mosquito(int tamanho, int energia){
        this.tamanho = tamanho;
        this.energia = energia;
    }
}

class Calango {
    Mosquito barriga;
    int energia; //atributos
    int maxEnergia;
    int nPatas;
    int vida;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxEnergia){ //parametros
        this.energia = maxEnergia;
        this.maxEnergia = maxEnergia;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
    }

    boolean comer(Mosquito mosquito){
        if(this.barriga != null){
            System.out.println("Barriga esta cheia");
            return false;
        }
        if(mosquito.tamanho > 3){
            System.out.println("Mosquito muito grande");
            return false;
        }
        barriga = mosquito;
        return true;
    }

    void digerir(Mosquito mosquito){
        if(barriga == null){
            System.out.println("Não tenho o que digerir");
            return;
        }
        energia += mosquito.energia;
        if(energia > maxEnergia){
            energia = maxEnergia;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
        barriga = null;
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(energia > 0){
            if(energia < dist){
                System.out.println("Andei só " + energia);
                energia = 0;
                return;
            }
            energia -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void brigar(Calango other){
        if(!this.alive){
            System.out.println("Morto nao luta");
            return;
        }
        if(other.nPatas > 0){
            other.nPatas -= 1;
            System.out.println("Arranquei uma pata sua com meu Ninjutso");
        }else{
            System.out.println("Morra com meu golpe do dedo das 4 folhas!!");
            other.alive = false;
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (energia > 0){
            nPatas += 1;
            energia -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    Mosquito arrotar(){
        if(barriga != null){
            Mosquito aux = this.barriga; 
            this.barriga = null;
            return aux;
        }
        return null;
    }

    public String toString() {
        return "energia: " + energia + "/" + maxEnergia + " Patas: " + nPatas  + " Alive:" + alive;
    }

    public static void main(String[] args) {

    }
}


