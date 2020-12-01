package cods;

public class Calango {

    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int vida;
    int maxVida;
    boolean vivo;

    //mesmo nome da classe = sombreamento de variavel
    public Calango(int bucho, int maxBucho,int maxVida){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.vida = maxVida;
        this.maxVida = maxVida;
        this.vivo = true;
    }

    public void comer(int qtd){
        if(!vivo){
            System.out.println("Seu calango não reage (tá mortinho ;-;)");
            return;
        }

        if(vida < maxVida){
            int aux = maxVida - vida;
            if(qtd >= aux){
                vida += aux;
                qtd-=aux;
                System.out.println("Me sinto revigorado!");
            }else{
                vida+=qtd;
                qtd=0;
            }
            if(qtd <= 0)
                return;
        }
        if(bucho+qtd < maxBucho){
            bucho+=qtd;
            System.out.println("Nham Nham");
        }else if(bucho != maxBucho && bucho+qtd >= maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Já tô cheio");
        }
    }

    public void andar(int qtd){
        if(!vivo){
            System.out.println("Seu calango não reage (tá mortinho ;-;)");
            return;
        }

        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho == 0){
            vida-=qtd;
            if(vida>0){
                System.out.println("Minhas patas estão doendo muito, mas eu consegui terminar a caminhada vivo º-º");
            }else{
                System.out.println("Minhas patas estão doendo muito, eu não consigo mais andar, minhas forças acabaram, adeus mundo cruel X( (Calango Died ;-;)");
                vivo = false;
            }
        }else{
            if(bucho-qtd >= 0){
                bucho -= qtd;
                System.out.println("Que passeio agradavel");
                return;
            }else{
                bucho-= qtd;
                vida -= bucho*-1;
                bucho = 0;
                if(vida>0){
                    System.out.println("No início o passeio estava agradável, mas depois de um tempo fui muito exaustivo");
                }else{
                    System.out.println("Minhas patas estão doendo muito, eu não consigo mais andar, minhas forças acabaram, adeus mundo cruel X( (Calango Died ;-;)");
                    vivo=false;
                }
            }
        }
    }

    public void acidentar(){
        if(!vivo){
            System.out.println("Seu calango não reage (tá mortinho ;-;)");
            return;
        }

        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            if(nPatas == 0)
                System.out.println("Ai não, vão me esmagar ;-;(Calango Died ;-;)");
                vivo = false;
        }
    }

    public void regenerar(){
        if(!vivo){
            System.out.println("Seu calango não reage (tá mortinho ;-;)");
            return;
        }

        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        if (vivo){
            return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Vida: " + vida + "/" + maxVida;
        }else
            return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Vida: " + vida + "/" + maxVida + " (Seu Calango está morto)";
    }
}


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();