package Jogadores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Itens.*;
import Mobs.Mob;

public class Jogador{

    public static void main(String[] args){
        System.out.println("teste");
    }

    //public static String texto_verde = "\u001B["+ "32" + "m";
    private String corDefesa = "\u001B["+ "33" + "m";
    private String corCritico = "\u001B["+ "33" + "m";
    private String corLevelUp = "\u001B["+ "33" + "m";
    private String corShow = "\u001B["+ "36" + "m";
    private String limparTexto = "\u001B["+"m";
    private static Scanner scan = new Scanner(System.in);
    
    protected long gold;
    protected String nome;
    protected long money;
    protected long vida,vidaMax,pocoes,pocoesMax,mana,manaMax,xp,xpPraUpar;
    protected int forca, constituicao, inteligencia, nivel;
    protected boolean vivo;

    protected ArrayList<Item> mochila;
    protected Armadura armadura;
    protected Arma arma;
    protected Escudo escudo;

    public long getMoney(){
        return money;    
    }

    public void gastarDinheiro(long preco){
        if(preco<0)
            preco *=-1;

        this.money -= preco;
    }

    public Jogador(String nome, int nivel){
        this.mochila = new ArrayList<Item>();
        this.gold = 0;
        this.vivo = true;
        this.nome = nome;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.nivel = nivel;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xpPraUpar = 10 * (int)Math.pow(2, nivel);

        long pontosDeHabilidade = nivel-1;
        long countNivel = 1;
        
        if(pontosDeHabilidade>0)
            while (pontosDeHabilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontosDeHabilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>>> ");
                int opt = scan.nextInt();
                clearBuffer(scan);
                switch (opt) {
                    case 1:
                        countNivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        this.forca++;
                        pontosDeHabilidade--;
                        break;
                    case 2:
                        countNivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        this.inteligencia ++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        pontosDeHabilidade--;
                        break;
                    case 3:
                        countNivel++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        this.constituicao++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        pontosDeHabilidade--;
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente");
                        break;
                }
            }
        this.vida = vidaMax;
        this.mana= manaMax;

        System.out.print(corShow+"\n\n\nSeu personagem foi criado, olhe os dados dele:"+this);
        System.out.println(limparTexto);
    }

    public Jogador(){
        System.out.println("-----Menu de criação de personagem-----");
        System.out.print("\n\n\nDigite o nome do seu personagem:\n\n>>> ");
        this.nome = scan.nextLine();

        System.out.print("\n\n\nAgora digite o nivel do seu personagem:\n\n>>> ");
        this.nivel = scan.nextInt();
        this.mochila = new ArrayList<Item>();
        this.gold = 0;
        this.vivo = true;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xpPraUpar = 10 * (int)Math.pow(2, nivel);
        this.pocoesMax = this.nivel;
        this.pocoes = this.nivel;

        long pontosDeHabilidade = nivel-1;
        long countNivel = 1;
        
        if(pontosDeHabilidade>0)
            while (pontosDeHabilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontosDeHabilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>>> ");
                int opt = scan.nextInt();
                switch (opt) {
                    case 1:
                        countNivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        this.forca++;
                        pontosDeHabilidade--;
                        break;
                    case 2:
                        countNivel++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        this.inteligencia ++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        pontosDeHabilidade--;
                        break;
                    case 3:
                        countNivel++;
                        this.manaMax += ( (this.inteligencia + 5) * 2 * countNivel);
                        this.constituicao++;
                        this.vidaMax += ( (this.constituicao + 5) * 4 * countNivel);
                        pontosDeHabilidade--;
                        break;
                    default:
                        System.out.println("Opção inválida, digite novamente");
                        break;
                }
            }
        this.vida = vidaMax;
        this.mana= manaMax;

        System.out.print(corShow+"\n\n\nSeu personagem foi criado, olhe os dados dele:"+this);
        System.out.println(limparTexto);
        clearBuffer(scan);
    }

    public String getNome() {
        return nome;
    }
    
    public String toString(){
        String nome = "| Nome: "+ this.nome, 
        mana        = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida        = " | Vida: "+ this.vida+"/"+this.vidaMax,
        xp          = " | Xp: " + this.xp+"/" + this.xpPraUpar,
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

    public void upar(long xpSobrando){
        System.out.println("\n\n\n");
        System.out.print(corLevelUp+"!!!!!!!!!!!!!!!!!!!!!!!!!!!! Você Subiu de Nível !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(limparTexto);

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
        this.xpPraUpar = 10 * (int)Math.pow(2, nivel);
        this.xp = 0;
        this.vida = vidaMax;
        this.mana= manaMax;
        this.pocoesMax = nivel;
        this.receberXpPuro(xpSobrando);
    }
    
    public void receberXp(long xpInimigo){
        if(xpInimigo == 0){
            return;
        }
        long xpGanho = (int) ( xpInimigo / (this.nivel*2) );
        if(xpGanho == 0)
            xpGanho = 1;
        System.out.println("Xp ganho : "+xpGanho);
        if(xpGanho+this.xp>this.xpPraUpar){
            this.upar(xpGanho+this.xp-this.xpPraUpar);
        }else
            this.xp+=xpGanho;
    }

    public void receberXpPuro(long xpInimigo){
        if(xpInimigo == 0){
            return;
        }
        long xpGanho = xpInimigo;

        if(xpGanho+this.xp>=this.xpPraUpar){
            this.upar(xpGanho+this.xp-this.xpPraUpar);
        }else
            this.xp+=xpGanho;
    }

    public long atacar(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100), rand2 = 0;
        if((rand+1)>1+(0.1*nivel)+(0.1*forca)){
            rand2 = (random.nextInt(this.nivel));
            atacar = (this.forca * ((rand2+1)+this.forca));
            return atacar;
        }else{
            rand2 = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * ((rand2+1)+this.forca));   
            System.out.print(corCritico+"!!!Você acertou um Ataque Crítico!!!");
            System.out.println(limparTexto);
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
            System.out.print(corDefesa+"!!! Sua defesa é perfeita e inabalável !!!"); 
            System.out.println(limparTexto);
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
    
    public void receberAtaque(Mob inimigo, boolean defender){
        if(!vivo){
            System.out.println("Seu inimigo chutou seu corpo morto no chão");
            return;
        }
        long defesa = 0;
        long dano = inimigo.atacar();

        if(defender){
            defesa = this.defender();
        }
        
        long calculoDano = defesa-dano; 
        this.vida += calculoDano;

        if(defesa-dano<=0){
            if(vida>= vidaMax/2){
                System.out.println("Cuidado! você levou "+(-1*calculoDano)+" de dano de seu inimigo");
            }else if(vida< vidaMax/2 && vida > vidaMax/4){
                System.out.println("Preste atenção! você já está com a metade da vida, é melhor você se defender ou se curar com uma poção, seu adversário te causou "+(-1*calculoDano)+" de dano");
            }else if(vida < vidaMax/4 && vida > 0){
                System.out.println("Pelo amor das Deusas, você precisa se curar urgentemente, sua vida já está abaixo dos 25%, seu adversário te causou "+(-1*calculoDano)+" de dano");
            }else if(vida <= 0){
                System.out.println("Infelizmente você não continuou sua caminhada após essa jornada, você caiu mas sua morte não será em vão, ouros verão seu exemplo e irão lutar por um mundo melhor sem esses monstros\n"+"Seu inimigo te causou "+(-1*calculoDano)+" de dano e com isso causou também sua morte");
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
        System.out.print("\n\n\n"+corShow+saida);
        System.out.println(limparTexto+"\n\n");
    }

    public void reabastecerPocoes(){
        if(!vivo)
            return;

        if(pocoes==pocoesMax)
            System.out.println("Você já está com sua bolsa de poções cheia");
        else
            System.out.println("Bolsa de poções reabastecida");  
        
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

    
    public boolean guardarItem(Item item){
        if(item!=null){
            mochila.add(item);
            return true;
        }
        return false;
    }
    
    public boolean equiparEscudo(Escudo escudo) {
        if(escudo!=null && this.escudo == null){
            this.escudo=escudo;
            return true;
        }
        return false;
    }
    
	public boolean equiparArmadura(Armadura armadura) {
        if(armadura!=null && this.armadura == null){
            this.armadura=armadura;
            return true;
        }
        return false;
	}

	public boolean equiparArma(Arma arma) {
        if(arma!=null && this.arma == null){
            this.arma=arma;
            return true;
        }
        return false;
    }
    
    public Escudo desequiparEscudo() {
        Escudo aux = this.escudo;
        this.escudo = null;
        return aux;
    }

	public Armadura desequiparArmadura(){
        Armadura aux = this.armadura;
        this.armadura = null;
        return aux;
	}

	public Arma desequiparArma(){
        Arma aux = this.arma;
        this.arma = null;
        return aux;
    }

    public void verInventario(){
        if(this.mochila.size()>0){
            System.out.println("Itens na mochila:\n");
            int count=1;
            for (Item item : mochila) {
                System.out.println("Item "+count+":"+item);
                count++;
            }
            System.out.println();
        }
    }

    public void verEquipados(){
        System.out.println("\n\n\nItens equipados:\n\n    Armadura equipada: "+ ( (armadura!=null) ? armadura.toString()+"\n" : "Sem armadura equipada\n" ) );

        System.out.println("    Arma equipada: "+ ( (arma!=null) ? arma.toString()+"\n" : "Sem arma equipada\n" ) );

        System.out.println("    Escudo equipado: "+ ( (escudo!=null) ? escudo.toString()+"\n" : "Sem escudo equipado\n" ) );
        
    }
}


