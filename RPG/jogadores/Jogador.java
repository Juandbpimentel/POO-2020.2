package jogadores;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import itens.*;
import mobs.Mob;

public class Jogador{

//Vatiáveis de ambiente
    private static Scanner scan = new Scanner(System.in);
    private String corDefesa = "\u001B["+ "33" + "m", corCritico = "\u001B["+ "33" + "m", corLevelUp = "\u001B["+ "33" + "m";
    private String corShow = "\u001B["+ "36" + "m", limparCorTexto = "\u001B["+"m";


    protected String nome;
    
//Status
    protected long vida,vidaMax,pocoes,pocoesMax,mana,manaMax,xp,xpPraUpar;
    protected boolean vivo;
    protected long dinheiro;
    
//Atributos
    protected int forca, constituicao, inteligencia, nivel;

//Equipamento
    protected ArrayList<Item> mochila;
    protected Armadura armadura;
    protected Arma arma;
    protected Escudo escudo;

    public Jogador(String nome, int nivel){
        
        this.mochila = new ArrayList<Item>();
        this.dinheiro = 0;
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
        System.out.println(limparCorTexto);
        
    }

    public Jogador(){
        
        System.out.println("-----Menu de criação de personagem-----");
        System.out.print("\n\n\nDigite o nome do seu personagem:\n\n>>> ");
        this.nome = scan.nextLine();

        System.out.print("\n\n\nAgora digite o nivel do seu personagem:\n\n>>> ");
        this.nivel = scan.nextInt();
        this.mochila = new ArrayList<Item>();
        this.dinheiro = 0;
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
        System.out.println(limparCorTexto);
        
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
            atacar = (this.forca * ((rand+1)+this.forca)+ ((arma!=null)? arma.getBonusAtaque():0) );
            return atacar;
        }else{
            rand = (random.nextInt(this.nivel));
            atacar = 2*(this.forca * ((rand+1)+this.forca)+ ((arma!=null)? arma.getBonusAtaque():0) );   
            System.out.print(corCritico+"!!!Você acertou um Ataque Crítico!!!");
            System.out.println(limparCorTexto);
            return atacar;    
        }
    }

    public boolean checarVivo(){
        return this.vivo;
    }

    public static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    public boolean comprarItem(Item item){
        if(item == null){
            return false;
        }
        if(item.eEscudo()){          
            Escudo escudo = (Escudo)item;
            if(this.escudo!= null){
                System.out.println("\n\nEscudo Novo: "+item);
                System.out.println("Escudo equipado: "+this.escudo+"\n\n");

                System.out.print("Você quer trocar esse escudo pelo seu?(y/n): ");
                String temp = scan.next();

                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparEscudo(); 
                    return escudo.serComprado(this,true);
                }else
                    return escudo.serComprado(this,false);
            }

            System.out.println("\n\nEscudo novo: "+item);
            System.out.print("\n\nVocê quer equipar essa Escudo?(y/n): ");
            String temp = scan.next();
            return escudo.serComprado(this,(temp.equals("y")||temp.equals("Y"))? true: false);

        }else if(item.eArmadura()){
            Armadura armadura = (Armadura)item;
            if(this.armadura!= null){
                System.out.println("\n\nArmadura Nova: "+item);
                System.out.println("Armadura equipada: "+this.armadura+"\n\n");

                System.out.print("Você quer trocar essa armadura pela sua?(y/n): ");
                String temp = scan.next();

                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparArmadura(); 
                    return armadura.serComprado(this,true);
                }else
                    return armadura.serComprado(this,false);
            }

            System.out.println("\n\nArmadura nova: "+item);
            System.out.print("\n\nVocê quer equipar essa armadura?(y/n): ");
            String temp = scan.next();
            return armadura.serComprado(this,(temp.equals("y")||temp.equals("Y"))? true: false);
        
        }else if(item.eArma()){
            Arma arma = (Arma) item;

            if(this.arma!= null){
                System.out.println("\n\nArma Nova: "+item);
                System.out.println("Arma equipada: "+this.arma+"\n\n");

                System.out.print("Você quer trocar essa arma pela sua?(y/n): ");
                String temp = scan.next();

                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparArma(); 
                    return arma.serComprado(this,true);
                }else
                    return arma.serComprado(this,false);
            }

            System.out.println("\n\nArma nova: "+item);
            System.out.print("\n\nVocê quer equipar essa arma?(y/n): ");
            String temp = scan.next();
            return arma.serComprado(this,(temp.equals("y")||temp.equals("Y"))? true: false);

        }else{
            return item.serComprado(this);
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

            defender = (this.constituicao *(rand+1)*this.constituicao);

        }else{
            rand = (random.nextInt(this.nivel));

            defender = (long) 4*(this.constituicao*(rand+1)*this.constituicao);   
            System.out.print(corDefesa+"!!! Sua defesa é perfeita e inabalável !!!"); 
            System.out.println(limparCorTexto);
        }
        return defender;
    }

    public boolean desequiparArma(){
        if (arma != null){
            Arma temp = this.arma;
            this.arma = null;
            mochila.add(temp);
            return true;
        }
        return false;
    }

    public boolean desequiparArmadura(){
        if (armadura != null) {
            Armadura temp = this.armadura;
            this.armadura = null;
            mochila.add(temp);
            return true;
        }
        return false;
	}

    public boolean desequiparEscudo() {
        if (escudo != null) {
            Escudo temp = this.escudo;
            this.escudo = null;
            mochila.add(temp);
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

    public boolean equiparArmadura(Armadura armadura) {
        if(armadura!=null && this.armadura == null){
            this.armadura=armadura;
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
    
    public void gastarDinheiro(long preco){
        if(preco<0)
            preco *=-1;

        this.dinheiro -= preco;
    }

    public long getDinheiro(){
        return dinheiro;    
    }

    public String getNome() {
        return nome;
    }

    public boolean guardarNaMochila(Item item){
        if(item != null)
            return mochila.add(item);
        else
            return false;
    }

    public boolean pegarDrop(Item item){
        if(item == null){
            return false;
        }
        if(item.eEscudo()){          
            Escudo escudo = (Escudo)item;
            if(this.escudo!= null){
                System.out.println("\n\nEscudo novo: "+item);
                System.out.println("Escudo equipado: "+this.escudo+"\n\n");

                System.out.print("Você quer trocar esse escudo pelo seu?(y/n): ");
                String temp = scan.next();
                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparEscudo(); 
                    return this.equiparEscudo(escudo);
                }else
                    return guardarNaMochila(escudo);
            }
            System.out.println("\n\nEscudo novo: "+item);
            System.out.print("\n\nVocê quer equipar esse escudo?(y/n): ");
            String temp = scan.next();
            boolean saida = (temp.equals("y")) ? this.equiparEscudo(escudo) : guardarNaMochila(escudo);
            return saida;

        }else if(item.eArmadura()){
            Armadura armadura = (Armadura)item;
            if(this.armadura!= null){
                System.out.println("\n\nArmadura Nova: "+item);
                System.out.println("Armadura equipada: "+this.armadura+"\n\n");
                
                System.out.print("Você quer trocar essa armadura pela sua?(y/n): ");
                String temp = scan.next();
                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparArmadura(); 
                    return this.equiparArmadura(armadura);
                }else
                return guardarNaMochila(armadura);
            }
            System.out.println("\n\nArmadura Nova: "+item);
            System.out.print("\n\nVocê quer equipar essa armadura?(y/n): ");
            String temp = scan.next();
            boolean saida = (temp.equals("y")) ? this.equiparArmadura(armadura) : guardarNaMochila(armadura) ;
            return saida;
        
        }else if(item.eArma()){
            Arma arma = (Arma) item;
            if(this.arma!= null){
                System.out.println("\n\nArma Nova: "+item);
                System.out.println("Arma equipada: "+this.arma+"\n\n");

                System.out.print("Você quer trocar essa arma pela sua?(y/n): ");
                String temp = scan.next();
                if(temp.equals("y")||temp.equals("Y")){
                    this.desequiparArma(); 
                    return this.equiparArma(arma);
                }else
                    return guardarNaMochila(arma);
            }
            System.out.println("\n\nArma nova: "+item);
            System.out.print("\n\nVocê quer equipar essa arma?(y/n): ");
            String temp = scan.next();
            boolean saida = (temp.equals("y")) ? this.equiparArma(arma) : guardarNaMochila(arma) ;
            return saida;
        }else{
            return guardarNaMochila(item);
        }
    }

    public void morrer(){
        this.vivo = false;
    }

    public boolean potar(){
        if(!vivo){
            return false;
        }
        if(pocoes>0){
            if(vida<vidaMax && vida>vidaMax/4){
                System.out.println("*Glup*");
                System.out.println("Você sente sua energia vital sendo preenchida");
                vida += ( 3*vidaMax/10 );
                return true;
            }else if(vida<=vidaMax/4){
                System.out.println("*Glup*");
                System.out.println("A luz que você estava vendo ao longe vai se afastando e você sente suas feridas profundas fechando");
                vida += (5*vidaMax/10);
                return true;
            }else{
                System.out.println("Você já está com a vida cheia, guarde sua poção para depois");
                return false;
            }
        }else{
            System.out.println("Você não tem mais poções para utilizar");
            return false;
        }
    }
    
    public boolean reabastecerPocoes(){
        if(!vivo)
            return false;

        if(pocoes==pocoesMax){
            System.out.println("Você já está com sua bolsa de poções cheia");
            return false;
        }else{
            System.out.println("Bolsa de poções reabastecida");  
            return true;
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

    public void receberDinheiro(long dindin){
        if(dindin>0)
            this.dinheiro += dindin;
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

    protected void receberXpPuro(long xp){
        if(xp == 0){
            return;
        }
        long xpGanho = xp;

        if(xpGanho+this.xp>=this.xpPraUpar){
            this.upar(xpGanho+this.xp-this.xpPraUpar);
        }else
            this.xp+=xpGanho;
    }

    public void show(){
        String nome = "| Nome do Jogador: "+ this.nome, 
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
        System.out.println(limparCorTexto+"\n\n");
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
        constituicao= " | Constituição: "+ this.constituicao,
        dinheiro    = " | Dinheiro: "+ this.dinheiro+"g |";

        String saida = nome + mana + vida + xp + pocoes + nivel + forca + inteligencia + constituicao + dinheiro;
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
        System.out.println(limparCorTexto);

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

    public void verEquipados(){
        System.out.println("\n\n\nItens equipados:\n\n    << Armadura equipada >>: "+ ( (armadura!=null) ? armadura.toString()+"\n" : "Sem armadura equipada\n" ) );

        System.out.println("    <<   Arma equipada   >>: "+ ( (arma!=null) ? arma.toString()+"\n" : "Sem arma equipada\n" ) );

        System.out.println("    <<  Escudo equipado  >>: "+ ( (escudo!=null) ? escudo.toString()+"\n" : "Sem escudo equipado\n" ) );
        
    }

    public int getNivel() {
        return nivel;
    }

    public void verInventario(){
        System.out.println("\n\n<<<<< Inventário >>>>>");
        for (int i = 0; i < 4; i++) {
            if(i == 0)
                showEscudos();
            if(i == 1)
                showArmaduras();
            if(i == 2)
                showArmas();
            if(i == 3)
                showItens();
            }
    }

    public void vender(ArrayList<Item> inventario,int opt){
        String opt2="";
        int count=0;
        Item temp = null;
        boolean resultado = false;

        switch (opt) {
            case 1:
                showVenda(opt);
                System.out.println("Você tem "+this.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número do escudo que quer vender: ");
                opt2 = scan.next();
                for(Item item : mochila){
                    if (item.getTipoDeItem().equals("Escudo")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = mochila.remove(mochila.indexOf(item));
                            break;
                        }
                    }
                }
                if (temp != null) {
                    if(inventario.add(temp)){
                        resultado = true;
                        this.gastarDinheiro(temp.getPreco());
                    }else{
                        if(temp!= null) 
                            mochila.add(temp);
                    }    
                }

                if(resultado){
                    System.out.println("A venda deu certo");
                }else
                    System.out.println("A venda deu errado");
                break;
            case 2:
                showVenda(opt);
                System.out.println("Você tem "+this.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número da armadura que quer vender: ");
                opt2 = scan.next();
                for(Item item : mochila){
                    if (item.getTipoDeItem().equals("Armadura")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = mochila.remove(mochila.indexOf(item));
                            break;
                        }
                    }
                }
        
                if (temp != null) {
                    if(inventario.add(temp)){
                        resultado = true;
                        this.gastarDinheiro(temp.getPreco());
                    }else{
                        if(temp!= null) 
                            mochila.add(temp);
                    }    
                }

                if(resultado){
                    System.out.println("A venda deu certo");
                }else
                    System.out.println("A venda deu errado");
                break;
            case 3:
                showVenda(opt);
                System.out.println("Você tem "+this.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número da arma que quer vender: ");
                opt2 = scan.next();
                for(Item item : mochila){
                    if (item.getTipoDeItem().equals("Arma")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = mochila.remove(mochila.indexOf(item));
                            break;
                        }
                    }
                }
        
                if (temp != null) {
                    if(inventario.add(temp)){
                        resultado = true;
                        this.gastarDinheiro(temp.getPreco());
                    }else{
                        if(temp!= null) 
                            mochila.add(temp);
                    }    
                }

                if(resultado){
                    System.out.println("A venda deu certo");
                }else
                    System.out.println("A venda deu errado");
                break;
            case 4:
                showVenda(opt);
                System.out.println("Você tem "+this.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número da arma que quer vender: ");
                opt2 = scan.next();
                for(Item item : mochila){
                    if (item.getTipoDeItem().equals("Item Básico")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = mochila.remove(mochila.indexOf(item));
                            break;
                        }
                    }
                }
        
                if (temp != null) {
                    if(inventario.add(temp)){
                        resultado = true;
                        this.gastarDinheiro(temp.getPreco());
                    }else{
                        if(temp!= null) 
                            mochila.add(temp);
                    }    
                }

                if(resultado){
                    System.out.println("A venda deu certo");
                }else
                    System.out.println("A venda deu errado");
                break;
            default:
                System.out.println("Sessão de classe de item inválida");
                break;
        }
    }

    private void showVenda(int categoria){
        switch (categoria) {
            case 0:
                System.out.println("\n\n<<<<< Estoque da loja >>>>>");
            
                for (int i = 0; i < 4; i++) {
                    if(i == 0)
                        showEscudos();
                    if(i == 1)
                        showArmaduras();
                    if(i == 2)
                        showArmas();
                    if(i == 3)
                        showItens();
                    }
                    break;
                    
            case 1:
                showEscudos();    
                break;

            case 2:
                showArmaduras();
                break;
        
            case 3:
                showArmas();
                break;
        
            case 4:
                showItens();
                break;
        
            default:
                System.out.println("Categoria inválida");
                break;
        }
    }

    private void showEscudos(){
        int count = 0;
        System.out.println("\n  -Escudos:");        
        for (Item item : this.mochila)
        if(item.getTipoDeItem().equals("Escudo")){
            count++;
            System.out.println("\n    "+count+") "+item);
        }
        
        if(count == 0)
        System.out.println("\n  -O jogador não tem escudos no inventário");
    }

    private  void showArmaduras(){
        int count = 0;
        System.out.println("\n  -Armaduras:");
        for (Item item : this.mochila)
        if(item.getTipoDeItem().equals("Armadura")){
            count++;
            System.out.println("\n    "+count+") "+item);
        }
        
        if(count == 0)
        System.out.println("\n  -O jogador não tem armaduras no inventário");
    }

    private void showArmas(){
        int count = 0;
        System.out.println("\n  -Armas:");
        
        for (Item item : this.mochila)
        if(item.getTipoDeItem().equals("Arma")){
            count++;
            System.out.println("\n    "+count+") "+item);
        }
        
        if(count == 0)
        System.out.println("\n  -O jogador não tem armas no inventário");
    }

    private void showItens(){
        int count = 0;
        System.out.println("\n  -Itens:");
                        
        for (Item item : this.mochila)
            if(item.getTipoDeItem().equals("Item Básico")){
                count++;
                System.out.println("\n    "+count+") "+item);
            }
        
        if(count == 0)
            System.out.println("\n  -O jogador não tem itens no inventário");
                    
    }

}


