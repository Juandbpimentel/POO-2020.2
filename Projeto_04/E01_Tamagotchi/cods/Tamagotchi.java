package cods;

public class Tamagotchi {
    private String nome;
    private int maxEnergia,maxSaciedade,maxLimpeza;
    private int energia,saciedade,limpeza;
    private int diamantes;
    private int idade;
    private boolean alive;

    public Tamagotchi(){

        this.nome = "Pet";
        this.maxEnergia = 10;
        this.energia = maxEnergia;

        this.maxSaciedade = 10;
        this.saciedade = maxSaciedade;

        this.maxLimpeza = 10;
        this.limpeza = maxLimpeza;

        this.diamantes = 0;
        this.idade = 1;
        this.alive = true;
    }

    public Tamagotchi(String nome, int maxEnergia,int maxSaciedade, int maxLimpeza){
        this.nome = nome;
        
        this.maxEnergia = maxEnergia;
        this.energia = maxEnergia;

        this.maxSaciedade = maxSaciedade;
        this.saciedade = maxSaciedade;

        this.maxLimpeza = maxLimpeza;
        this.limpeza = maxLimpeza;

        this.diamantes = 0;
        this.idade = 1;
        this.alive = true;
    }

    public int getEnergia() {
        return this.energia;
    }
    
    public int getSaciedade() {
        return saciedade;
    }
    
    public int getLimpeza() {
        return this.limpeza;
    }
    
    public int getMaxEnergia() {
        return maxEnergia;
    }
    
    public int getMaxSaciedade() {
        return maxSaciedade;
    }    
    
    public int getMaxLimpeza() {
        return maxLimpeza;
    }

    public int getIdade() {
        return this.idade;
    }

    public int getDiamantes() {
        return diamantes;
    }

    public void setEnergia(int energia){
        this.energia = energia;
        if(this.energia<=0){
            this.energia = 0;
            System.out.println("fail: Seu pet morreu de cansaço");
            this.alive = false;
        }
        if(this.energia > this.maxEnergia){
            this.energia = maxEnergia;
        }
    }

    public void setSaciedade(int saciedade) {
        this.saciedade = saciedade;
        if(this.saciedade<=0){
            this.saciedade = 0;
            System.out.println("fail: Seu pet morreu de fome");
            this.alive = false;
        }
        if(this.saciedade > this.maxSaciedade){
            this.saciedade = maxSaciedade;
        }
    }

    public void setLimpeza(int limpeza){
        this.limpeza = limpeza;
        if(this.limpeza<=0){
            this.limpeza = 0;
            System.out.println("fail: Seu pet morreu de infecção bacteriana por causa da sujeira");
            this.alive = false;
        }
        if(this.limpeza > this.maxLimpeza){
            this.limpeza = maxLimpeza;
        }
    }

    private boolean estaVivo(){
        if(!alive){
            System.out.println("fail: Seu bichinho está morto, ele não pode mais fazer nada");
            return false;
        }
        return true;
    }

    public void brincar(){
        if(!this.estaVivo()){
            return;
        }

        this.setEnergia(this.getEnergia()-2);
        this.setSaciedade(this.getSaciedade()-1);
        this.setLimpeza(this.getLimpeza()-3);
        this.diamantes++;
        this.idade++;
    }

    public void comer(){
        if(!this.estaVivo()){
            return;
        }

        this.setEnergia(this.getEnergia()-1);
        this.setSaciedade(this.getSaciedade()+4);
        this.setLimpeza(this.getLimpeza()-2);
        this.idade++;
    }
    
    public void dormir(){
        if(!this.estaVivo()){
            return;
        }
        if(this.getMaxEnergia()-getEnergia() < 5){
            System.out.println("fail: Não estou com sono");
            return;
        }
        
        this.setEnergia(this.getMaxEnergia());
        this.idade++;
    }
    
    public void tomarBanho(){
        if(!this.estaVivo()){
            return;
        }

        this.setEnergia(this.getEnergia()-3);
        this.setSaciedade(this.getSaciedade()-1);
        this.setLimpeza(this.getMaxLimpeza());
        this.idade+=2;
    }

    public String toString() {
        //E:20/20, S:10/10, L:15/15, D:0, I:0
        String saida = "| Nome: " + this.nome
                    + " | E:"     + this.energia   + "/" + this.maxEnergia  
                    + " | S:"     + this.saciedade + "/" + this.maxSaciedade  
                    + " | L:"     + this.limpeza   + "/" + this.maxLimpeza 
                    + " | D:"     + this.diamantes
                    + " | I:"     + this.idade + " |";
        int saidaTamanho = saida.length();

                for(int i = 0 ; i<saidaTamanho; i++){
                    if(i == 0){
                        saida = "-\n"+saida+"\n-";
                    }else
                        saida = "-"+saida+"-";
                }
        return saida;
    }

    public static void main(String[] args) {
        System.out.println(new Tamagotchi("Pet",10,20,30));
    }


    
}
