package Jogadores;

import java.util.Random;
import java.util.Scanner;

import Mobs.Mob;
public class Jogador{

    public static void main(String[] args){
        
    }

    //public static String texto_verde = "\u001B["+ "32" + "m";
    private String cor_defesa = "\u001B["+ "33" + "m";
    private String cor_critico = "\u001B["+ "33" + "m";
    private String cor_levelup = "\u001B["+ "33" + "m";
    private String cor_show = "\u001B["+ "36" + "m";
    private String limpar_texto = "\u001B["+"m";
    
    protected String nome;
    protected double money;
    protected long vida;
    protected long vidaMax;
    protected long pocoes;
    protected long pocoesMax;
    protected long mana;
    protected long manaMax;
    protected long xp;
    protected long xp_para_upar;
    protected int forca;
    protected int constituicao;
    protected int inteligencia;
    protected int nivel;
    protected boolean vivo;
    private static Scanner scan = new Scanner(System.in);

    public Jogador(String nome, int nivel){
        this.vivo = true;
        this.nome = nome;
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
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>>> ");
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
        this.vida = vidaMax;
        this.mana= manaMax;

        System.out.print(cor_show+"\n\n\nSeu personagem foi criado, olhe os dados dele:"+this);
        System.out.println(limpar_texto);
    }

    public Jogador(){
        System.out.println("-----Menu de criação de personagem-----");
        System.out.print("\n\n\nDigite o nome do seu personagem:\n\n>>> ");
        this.nome = scan.nextLine();

        System.out.print("\n\n\nAgora digite o nivel do seu personagem:\n\n>>> ");
        this.nivel = scan.nextInt();
        
        this.vivo = true;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xp_para_upar = 10 * (int)Math.pow(2, nivel);
        this.pocoesMax = this.nivel;
        this.pocoes = this.nivel;

        long pontos_de_habilidade = nivel-1;
        long count_nivel = 1;
        
        if(pontos_de_habilidade>0)
            while (pontos_de_habilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontos_de_habilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>>> ");
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
        this.vida = vidaMax;
        this.mana= manaMax;

        System.out.print(cor_show+"\n\n\nSeu personagem foi criado, olhe os dados dele:"+this);
        System.out.println(limpar_texto);
        clearBuffer(scan);
    }

    public String toString(){
        String nome = "| Nome: "+ this.nome, 
        mana        = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida        = " | Vida: "+ this.vida+"/"+this.vidaMax,
        xp          = " | Xp: " + this.xp+"/" + this.xp_para_upar,
        pocoes      = " | Poções: "+ this.pocoes+"/"+this.pocoesMax,
        nivel       = " | Nivel: "+ this.nivel,
        forca       = " | Força: "+ this.forca,
        inteligencia= " | Inteligência: "+this.inteligencia,
        constituicao= " | Constituição: "+ this.constituicao +" |";

        String saida = nome + mana + vida + xp + pocoes + nivel + forca + inteligencia + constituicao;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n\n"+saida+"\n\n\n";
    }

    public void upar(long xp_sobrando){
        System.out.println("\n\n\n");
        System.out.print(cor_levelup+"!!!!!!!!!!!!!!!!!!!!!!!!!!!! Você Subiu de Nível !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(limpar_texto);

        System.out.println("\n\n\nVocê tem um ponto para aumentar um atributo");
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
        this.xp = 0;
        this.vida = vidaMax;
        this.mana= manaMax;
        this.pocoesMax = nivel;
        this.receber_xp_puro(xp_sobrando);
    }
    
    public void receber_xp(long xp_inimigo){
        if(xp_inimigo == 0){
            return;
        }
        long xp_ganho = (int) ( xp_inimigo / (this.nivel*2) );
        if(xp_ganho == 0)
            xp_ganho = 1;
        System.out.println("Xp ganho : "+xp_ganho);
        if(xp_ganho+this.xp>this.xp_para_upar){
            this.upar(xp_ganho+this.xp-this.xp_para_upar);
        }else
            this.xp+=xp_ganho;
    }

    public void receber_xp_puro(long xp_inimigo){
        if(xp_inimigo == 0){
            return;
        }
        long xp_ganho = xp_inimigo;

        if(xp_ganho+this.xp>=this.xp_para_upar){
            this.upar(xp_ganho+this.xp-this.xp_para_upar);
        }else
            this.xp+=xp_ganho;
    }

    public long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1+(0.1*nivel)+(0.1*forca)){
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.forca * (rand2+1)*this.forca);
            return atacar;
        }else{
            rand = (random.nextInt(this.forca));
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * (rand2+1)*this.forca);   
            System.out.print(cor_critico+"!!!Você acertou um Ataque Crítico!!!");
            System.out.println(limpar_texto);
            return atacar;    
        }
    }

    public long defender(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long defender = 0;
        long rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1+(0.1*nivel)){
            rand2 = (random.nextInt(this.nivel));

            defender = (this.constituicao *(rand2+1)*this.constituicao);

        }else{
            rand2 = (random.nextInt(this.nivel));

            defender = (long) 4*(this.constituicao*(rand2+1)*this.constituicao);   
            System.out.print(cor_defesa+"!!! Sua defesa é perfeita e inabalável !!!"); 
            System.out.println(limpar_texto);
        }
        return defender;
    }

    public void potar(){
        if(!vivo){
            return;
        }
        if(pocoes>0){
            if(vida<vidaMax && vida>vidaMax/4){
            System.out.println("*Glup*");
            System.out.println("Você sente sua energia vital sendo preenchida");
            vida += ( 3*vidaMax/10 );
            }else if(vida<=vidaMax/4){
                System.out.println("*Glup*");
                System.out.println("A luz que você estava vendo ao longe vai se afastando e você sente suas feridas profundas fechando");
                vida += (5*vidaMax/10);
            }else{
                System.out.println("Você já está com a vida cheia, guarde sua poção para depois");
            }
        }else{
            System.out.println("Você não tem mais poções para utilizar");
        }
    }
    
    public void receber_ataque(Mob inimigo, boolean defender){
        if(!vivo){
            System.out.println("Seu inimigo chutou seu corpo morto no chão");
            return;
        }
        long defesa = 0;
        long dano = inimigo.atacar();

        if(defender){
            defesa = this.defender();
        }
        
        long calculo_dano = defesa-dano; 
        this.vida += calculo_dano;

        if(defesa-dano<=0){
            if(vida>= vidaMax/2){
                System.out.println("Cuidado! você levou "+(-1*calculo_dano)+" de dano de seu inimigo");
            }else if(vida< vidaMax/2 && vida > vidaMax/4){
                System.out.println("Preste atenção! você já está com a metade da vida, é melhor você se defender ou se curar com uma poção, seu adversário te causou "+(-1*calculo_dano)+" de dano");
            }else if(vida < vidaMax/4 && vida > 0){
                System.out.println("Pelo amor das Deusas, você precisa se curar urgentemente, sua vida já está abaixo dos 25%, seu adversário te causou "+(-1*calculo_dano)+" de dano");
            }else if(vida <= 0){
                System.out.println("Infelizmente você não continuou sua caminhada após essa jornada, você caiu mas sua morte não será em vão, ouros verão seu exemplo e irão lutar por um mundo melhor sem esses monstros\n"+"Seu inimigo te causou "+(-1*calculo_dano)+" de dano e com isso causou também sua morte");
                this.vivo=false;
            }
        }else{
            System.out.println("Graças a sua robustez estrema, você conseguiu absorver o golpe de seu inimigo com sucesso");
        }
    }

    public void show(){
        String nome = "| Nome: "+ this.nome, 
        mana   = " | Mana: "+ this.mana+"/"+this.manaMax,
        pocoes = " | Poções: "+ this.pocoes+"/"+this.pocoesMax,
        vida   = " | Vida: "+ this.vida+"/"+this.vidaMax+" |";

        String saida = nome + mana + pocoes + vida;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        System.out.print("\n\n\n"+cor_show+saida);
        System.out.println(limpar_texto+"\n\n");
    }

    public void reabastecerPocoes(){
        if(!vivo){
            return;
        }

        if(pocoes==pocoesMax){
            System.out.println("Você já está com sua bolsa de poções cheia");
            return;
        }else{
            System.out.println("Bolsa de poções reabastecida");
            
        }
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public void morrer(){
        this.vivo = false;
    }

    public boolean checarVivo(){
        return this.vivo;
    }
}


