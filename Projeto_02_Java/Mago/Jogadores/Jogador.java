package Jogadores;

import java.util.Random;
import java.util.Scanner;
public class Jogador{
    protected String name;
    protected long vidaAtual;
    protected long pocaoMax;
    protected long pocaoAtual;
    protected long vidaMax;
    protected long manaAtual;
    protected long manaMax;
    protected long xp_atual;
    protected long xp_para_upar;
    protected int forca;
    protected int constituicao;
    protected int inteligencia;
    protected int nivel;
    protected boolean vivo;
    public static Scanner scan = new Scanner(System.in);

    public Jogador(String name, int nivel){
        this.vivo = true;
        this.name = name;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.nivel = nivel;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xp_para_upar = 10 * (int)Math.pow(2, nivel);

        long pontos_de_habilidade = nivel-1;
        long count_nivel = 1;
        
        if(pontos_de_habilidade>0)
            while (pontos_de_habilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontos_de_habilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>");
                int opt = scan.nextInt();
                clearBuffer(scan);
                switch (opt) {
                    case 1:
                        count_nivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        this.forca++;
                        pontos_de_habilidade--;
                        break;
                    case 2:
                        count_nivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        this.inteligencia ++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        pontos_de_habilidade--;
                        break;
                    case 3:
                        count_nivel++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        this.constituicao++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        pontos_de_habilidade--;
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente");
                        break;
                }
            }
        this.vidaAtual = vidaMax;
        this.manaAtual= manaMax;

        System.out.println("Seu personagem foi criado, olhe os dados dele:"+this);
        clearBuffer(scan);
    }

    public Jogador(){
        System.out.println("-----Menu de criação de personagem-----");
        System.out.print("\n\n\nDigite o nome do seu personagem:\n\n>>>");
        this.name = scan.nextLine();

        System.out.print("\n\n\nAgora digite o nivel do seu personagem:\n\n>>>");
        this.nivel = scan.nextInt();
        
        this.vivo = true;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xp_para_upar = 10 * (int)Math.pow(2, nivel);
        this.pocaoMax = this.nivel;
        this.pocaoAtual = this.nivel;

        long pontos_de_habilidade = nivel-1;
        long count_nivel = 1;
        
        if(pontos_de_habilidade>0)
            while (pontos_de_habilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontos_de_habilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>");
                int opt = scan.nextInt();
                switch (opt) {
                    case 1:
                        count_nivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        this.forca++;
                        pontos_de_habilidade--;
                        break;
                    case 2:
                        count_nivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        this.inteligencia ++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        pontos_de_habilidade--;
                        break;
                    case 3:
                        count_nivel++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * count_nivel);
                        this.constituicao++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * count_nivel);
                        pontos_de_habilidade--;
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente");
                        break;
                }
            }
        this.vidaAtual = vidaMax;
        this.manaAtual= manaMax;

        System.out.println("Seu personagem foi criado, olhe os dados dele:"+this);
        clearBuffer(scan);
    }

    public String toString(){
        String nome = "| Nome: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax,
        xp   = " | Xp: " + this.xp_atual+"/" + this.xp_para_upar,
        nivel= " | Nivel: "+ this.nivel,
        forca= " | Força: "+ this.forca,
        constituicao= " | Constituição: "+ this.constituicao,
        inteligencia= " | Inteligência: "+this.inteligencia+" |";

        String saida = nome + mana + vida + xp + nivel + forca + inteligencia + constituicao;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }

    public void upar(long xp_sobrando){
        System.out.println("\n\n\n!!!!!!!Você Subiu de Nível!!!!!!!\n\n\nVocê tem um ponto para aumentar um atributo");
        System.out.println("Pontos Atuais: Força: "+ this.forca+" | Inteligência: "+this.inteligencia+" | Constituição: "+this.constituicao);
        System.out.print("\n\nSelecione a opção do atributo à ser aumentado:\n(1) - Força\n(2) - Inteligência\n(3) - Constituição\n\n>");
        String teste = scan.next();


        switch (Integer.parseInt(teste)){
            case 1:
                this.vidaMax += ( (this.constituicao + 5) * 4 * this.nivel);
                this.manaMax += ( (this.inteligencia + 5) * 2 * this.nivel);
                this.forca++;
                break;
            case 2:
                this.vidaMax += ( (this.constituicao + 5) * 4 * this.nivel);
                this.inteligencia ++;
                this.manaMax += ( (this.inteligencia + 5) * 2 * this.nivel);
                break;
            case 3:
                this.manaMax += ( (this.inteligencia + 5) * 2 * this.nivel);
                this.constituicao++;
                this.vidaMax += ( (this.constituicao + 5) * 4 * this.nivel);
                break;
            default:
                System.out.println("Opção inválida, digite novamente");
        }
        this.nivel++;
        this.xp_para_upar = 10 * (int)Math.pow(2, nivel);
        this.xp_atual = 0 + xp_sobrando;
        this.vidaAtual = vidaMax;
        this.manaAtual= manaMax;
        this.pocaoMax = nivel;
    }
    
    public void receber_xp(long xp_inimigo){
        long xp_ganho = (int) ( xp_inimigo / (this.nivel*2) );
        if(xp_ganho == 0)
            xp_ganho = 1;
        System.out.println("Xp ganho : "+xp_ganho);
        if(xp_ganho+this.xp_atual>this.xp_para_upar){
            this.upar(xp_ganho+this.xp_atual-this.xp_para_upar);
        }else
            this.xp_atual+=xp_ganho;
    }

    public long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1){
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.forca * (rand2+1)*this.forca);
            System.out.println(">>> Ataque Normal: "+atacar);
        }else{
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * (rand2+1)*this.forca);   
            System.out.println(">>> Ataque Crítico: "+atacar);    
        }
        return atacar;
    }

    public long defender(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long defender = 0;
        long rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1){
            rand2 = (random.nextInt(this.nivel));

            defender = (this.constituicao *(rand2+1)*this.constituicao);
            System.out.println(">>> Defesa: "+defender);

        }else{
            rand2 = (random.nextInt(this.nivel));

            defender = (long) 4*(this.constituicao*(rand2+1)*this.constituicao);   
            System.out.println(">>> Defesa Perfeita: "+defender); 

        }
        return defender;
    }

    public void regenerar(){
        if(pocaoAtual>0){
            if(vidaAtual<vidaMax && vidaAtual>vidaMax/4){
            System.out.println("*Glup*");
            System.out.println("Você sente sua energia vital sendo preenchida");
            vidaAtual += ( 3*vidaMax/10 );
            }else if(vidaAtual<=vidaMax/4){
                System.out.println("*Glup*");
                System.out.println("A luz que você estava vendo ao longe vai se afastando e você sente suas feridas profundas fechando");
                vidaAtual += (5*vidaMax/10);
            }else{
                System.out.println("Você já está com a vida cheia, guarde sua poção para depois");
            }
        }else{
            System.out.println("Você não tem mais poções para utilizar");
        }
    }
    
    public void sofrer_dano(long dano, long defesa){
        long calculo_dano = defesa-dano; 
        this.vidaAtual += calculo_dano;

        if(defesa-dano<=0){
            if(vidaAtual>= vidaMax/2){
                System.out.println("Cuidado! você levou "+calculo_dano+" de dano de seu inimigo");
            }else if(vidaAtual< vidaMax/2 && vidaAtual > vidaMax/4){
                System.out.println("Preste atenção! você já está com a metade da vida, é melhor você se defender ou se curar com uma poção, seu adversário te causou "+calculo_dano+" de dano");
            }else if(vidaAtual < vidaMax/4 && vidaAtual > 0){
                System.out.println("Pelo amor de Deus ou qualquer que seja ele(s) em sua fé, você precisa se curar urgentemente, sua vida já está abaixo dos 25%, seu adversário te causou "+calculo_dano+" de dano");
            }else if(vidaAtual <= 0){
                System.out.println("Infelizmente você não continuou sua caminhada após essa jornada, você caiu mas não será em vão, ouros verão seu exemplo e irão lutar por um mundo melhor\n"+"Seu inimigo te causou "+calculo_dano+" de dano e com isso causou também sua morte");
                this.vivo=false;
            }
        }else{
            System.out.println("Graças a sua robustez estrema, você conseguiu absorver o golpe de seu inimigo com sucesso");
        }
    }

    public String show(){
        String nome = "| Nome: "+ this.name, 
        mana   = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        pocoes = " | Poções: "+ this.pocaoAtual+"/"+this.pocaoMax,
        vida   = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax;

        String saida = nome + mana + pocoes + vida;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }

    public void reabastecerPocoes(){
        if(!vivo){
            return;
        }

        if(pocaoAtual==pocaoMax){
            System.out.println("Você já está com sua bolsa de poções cheia");
            return;
        }else{
            System.out.println("Bolsa de poções reabastecida");
            
        }
    }

    public static void main(String[] args){
        String nome;
        int nivel;
        Jogador teste = new Jogador();
        System.out.println("\n\n-----Menu de criação de personagem-----");
        System.out.print("\n\n\nDigite o nome do seu personagem:\n\n>>>");

        nome = scan.nextLine();

        System.out.print("\n\n\nAgora digite o nivel do seu personagem:\n\n>>>");
        
        nivel = scan.nextInt();
        
        teste = new Jogador(nome,nivel);
        teste.defender();
        clearBuffer(scan);
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public void morrer(){
        this.vivo = false;
    }
}


