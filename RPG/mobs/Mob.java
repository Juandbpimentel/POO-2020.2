package mobs;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

import itens.*;
import jogadores.Jogador;
public class Mob{
    public static String corCritico = "\u001B["+ "31" + "m";
    public static String limparCorTexto = "\u001B["+"m";

    String nome;
    protected long vida;
    protected long vidaMax;
    protected long mana;
    protected long manaMax;
    protected long pocoes;
    protected long dinheiro;
    protected int forca;
    protected int constituicao;
    protected int inteligencia;
    protected int nivel;
    protected boolean vivo;
    Arma arma;
    Armadura armadura;
    Escudo escudo;

    public ArrayList<Item> droparItens(){
        ArrayList<Item> drops = new ArrayList<Item>();  
        if(arma!=null){
            int chanceDrop = new Random().nextInt(100)+1;
            if(chanceDrop<=5 + this.nivel/10)
                drops.add(arma);
        }
        if(escudo!=null){
            int chanceDrop = new Random().nextInt(100)+1;
            if(chanceDrop<=5 + this.nivel/10)
                drops.add(escudo);
        }
        if(armadura!=null){
            int chanceDrop = new Random().nextInt(100)+1;
            if(chanceDrop<=5 + this.nivel/10)
                drops.add(armadura);
        }
        return drops;
    }

    protected void gerarItens(long nivel){
        Random rand = new Random();
        
        escudo = (rand.nextInt(100)+1> 1 + (0.5*this.nivel) )? new Escudo(nivel): null;

        arma = (rand.nextInt(100)+1> 1 + (0.5*this.nivel) )? new Arma(nivel): null;

        armadura = (rand.nextInt(100)+1> 1 + (0.5*this.nivel) )? new Armadura(nivel): null;
    }

    //Construtores
    public Mob(String nome, int nivel,int forca ,int constituicao ,int inteligencia){
        this.vivo = true;
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.forca = forca;
        this.gerarItens(this.nivel);
        this.dinheiro = ( 5 * (long) Math.pow(2,this.nivel));

        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }

        for (int i = 0; i < nivel; i++){
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 5) * nivel);
        }
        
        this.vida=vidaMax;
        this.mana=manaMax;
    }
    
    public Mob(int nivel, String nome){
        this.nome = nome;
        this.vivo = true;
        this.nivel = nivel;
        this.vidaMax=0;
        this.manaMax=0;
        this.gerarItens(this.nivel);
        this.dinheiro = ( 5 * (long) Math.pow(2,this.nivel));
        this.pocoes = nivel/4;
        if (pocoes<=0) {
            pocoes =1;
        }

        if(nivel>1){
            int div = (nivel-1) /2;
            int div2 = (nivel-1)-div;
            this.constituicao = 1 + div;
            this.inteligencia = 1;
            this.forca = 1 + div2;    
        }else{
            this.constituicao = 1;
            this.inteligencia = 1;
            this.forca = 1;
        }
        for(int i = 0; i < nivel; i++){
            this.vidaMax += ( (this.constituicao + 5) * nivel);
            this.manaMax += ( (this.inteligencia + 2) * nivel);
        }
        
        this.vida=vidaMax;
        this.mana=manaMax;
        
        if(this.nivel >= 1 &&  this.nivel < 50) {
            this.nome += " Desatrado";
        }else if(this.nivel>=50 && this.nivel<250){
            this.nome += " Escudeiro";
        }else if(this.nivel>=250 && this.nivel<500){
            this.nome += " Veterano";
        }else if(this.nivel>=500 && this.nivel<1000){
            this.nome += " Comandante";
        }else if(this.nivel>=1000){
            this.nome = "Rei dos(as) "+this.nome+"s" ;
        }
    }
    
    public Mob(){
        this.nome = "Slime";
        this.vivo = true;
        this.nivel = 1;
        this.vidaMax=0;
        this.manaMax=0;
        this.pocoes = nivel;
        this.constituicao = 1;
        this.inteligencia = 1;
        this.forca = 1;
        this.gerarItens(this.nivel);
        this.dinheiro = ( 5 * (long) Math.pow(2,this.nivel));
    }

    public static Mob criarMob(int nivel){
        if(nivel<=0)
            nivel = 1;
        if(nivel<10){
            return (Mob) new Slime(nivel);
        }else if(nivel>=10 && nivel<50){
            return (Mob) new Goblin(nivel);
        }else if(nivel>=50 && nivel<100){
            return (Mob) new Vampiro(nivel);
        }else if(nivel>=100 && nivel<500){
            return (Mob) new Demonio(nivel);
        }else{
            return (Mob) new Entidade(nivel);
        }
    } 
    
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }
    
    public String toString(){
        String nome = "| Monstro: "+ this.nome, 
        mana = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida = " | Vida: "+ this.vida+"/"+this.vidaMax,
        nivel= " | Nivel: "+ this.nivel,
        forca= " | Força: "+ this.forca,
        inteligencia= " | Inteligência: "+this.inteligencia,
        constituicao= " | Constituição: "+ this.constituicao+" |";
        
        String saida = nome + mana + vida + nivel + forca + inteligencia + constituicao;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }
    
    public long droparXp(){
        return (long)( 1.25 * Math.pow(2,this.nivel));
    }

    public long droparDinheiro(){
        return this.dinheiro;
    }

    public void receberAtaque(Jogador inimigo, boolean defender){
        if(!this.checarVivo()){
            System.out.println("\n"+"Seu inimigo já está morto, não seja um monstro como ele"+"\n");
            return;
        }
        long defesa = 0;
        long dano = inimigo.atacar();

        if(defender){
            defesa = this.defender();
        }

        Random rand = new Random();
        long calculoDano = defesa-dano;
        if(calculoDano>0)
            calculoDano=0;

        this.vida += calculoDano;

        if(defesa-dano<=0){
            if(vida>= vidaMax/2){
                switch (rand.nextInt(3)) {
                    case 0:
                        System.out.println("\n"+this.nome+" diz - Ai!!! Seu merdinha, você vai pagar!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    case 1:
                        System.out.println("\n"+this.nome+" diz - Ouch! Seu maldito, quero ver você acertar de novo, tenho certeza que foi pura sorte!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    case 2:
                        System.out.println("\n"+this.nome+" diz - Humpf! *Cospe um dente* É só isso que você tem? Não dá nem pro gasto!\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    default:
                        break;
                }
            }else if(vida< vidaMax/2 && vida > vidaMax/4){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println("\n"+this.nome+" diz - Grrrrrrr! *O inimigo grune de dor*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    case 1:
                        System.out.println("\n"+this.nome+" diz - Ahrg hurrrm *Seu inimigo está bem machucado e sangrando*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    default:
                        break;
                }
            }else if(vida < vidaMax/4 && vida > 0){
                switch(rand.nextInt(2)){
                    case 0:
                        System.out.println("\n"+this.nome+" diz - Agrhrrr que dor, eu não vou aguentar muito mais, mas não vou deixar que passe por mim\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    case 1:
                        System.out.println("\n"+this.nome+" diz - Ughrrr *Seu inimigo cospe sangue*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano"+"\n");   
                        break;
                    default:
                        break;
                }
            }else if(vida <= 0){
                System.out.println("\n"+this.nome+" diz - Aahhgrrrrrr! *O inimigo cai inerte no chão*\n"+"Seu inimigo levou "+-1*calculoDano+" de dano e morreu"+"\n");
                this.morrer();
            }
                
        }else{
            System.out.println("\n"+"Hahahaha, não foi dessa vez moleque! - diz " + this.nome+"\n");
        }
    }

    public long atacar(){
        if(!vivo){
            return 0;
        }

        Random random = new Random();
        long atacar = 0;
        int rand = random.nextInt(100);
        
        if((rand+1)>1+(0.1*nivel)+(0.1*forca)){
            rand = (random.nextInt(this.nivel));
            atacar = (this.forca * ((rand+1)+this.forca) + ((arma!=null)? arma.getBonusAtaque():0));
            return atacar;
        }else{
            rand = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * ((rand+1)+this.forca)+ ((arma!=null)? arma.getBonusAtaque():0));   
            System.out.print(corCritico+"!!! O seu inimigo acertou um ataque crítico !!!");
            System.out.println(limparCorTexto);
            return atacar;    
        }
    }

    public long defender(){
        if(!vivo){
            return 0;
        }
        Random random = new Random();
        long defender = 0;
        long rand = random.nextInt(100);
        if((rand+1)>1+(0.1*nivel)){
            rand = (random.nextInt(this.nivel));

            defender = (this.constituicao *(rand+1)*this.constituicao+ ((armadura!=null)? armadura.getBonusDefesa():0) + ((escudo!=null)? escudo.getBonusDefesa():0));

        }else{
            rand = (random.nextInt(this.nivel));

            defender = (long) 4*(this.constituicao*(rand+1)*this.constituicao+ ((armadura!=null)? armadura.getBonusDefesa():0) + ((escudo!=null)? escudo.getBonusDefesa():0));   
            System.out.print(corCritico+"!!! Sua defesa é perfeita e inabalável !!!"); 
            System.out.println(limparCorTexto);
        }
        return defender;
    }

    public boolean potar(){
        if(!vivo){
            return false;
        }
        if(pocoes>0){
            if(vida<vidaMax && vida>vidaMax/4){
                System.out.println("*Glup* -Seu inimigo toma uma poção-");
                vida += ( 3*vidaMax/10 );
                this.pocoes--;
                return true;
            }else if(vida<=vidaMax/4){
                System.out.println("*Glup* -Seu inimigo toma uma poção-");
                vida += (5*vidaMax/10);
                this.pocoes--;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void show(){
        String nome = "| Inimigo: "+ this.nome, 
        mana   = " | Mana: "+ this.mana+"/"+this.manaMax,
        vida   = " | Vida: "+ this.vida+"/"+this.vidaMax,
        nivel  = " | Nivel:"+ this.nivel+" |";
        String saida = nome + mana + vida + nivel;
        long n = saida.length();
        saida = "\n" + saida + "\n";
        for (long i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        System.out.print("\n\n"+saida+corCritico);
        System.out.println(limparCorTexto);
    }

    public void morrer(){
        this.vivo = false;
    }

    public boolean checarVivo(){
        return this.vivo;
    }

    public boolean checarVidaBaixa(){
        if( ( (float)((int)vida) / (float)((int)vidaMax)*100)<=20)
            return true;
        else
            return false;
    }
    
}
