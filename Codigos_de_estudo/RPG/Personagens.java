public class Personagens {
    String name;
    int manaAtual;
    int manaMax;
    int vidaAtual;
    int vidaMax;
    int forca;
    int constituicao;
    int nivel;

    public Personagens(String name, int manaMax, int vidaMax, int nivel){
        this.name = name;
        this.manaAtual = manaMax;
        this.manaMax = manaMax;
        this.vidaAtual = vidaMax;
        this.vidaMax = vidaMax;
        this.setNivel(1);
        this.set_forca(1);
        this.setConstituicao(1);
    }

    public String toString(){
        String nome = "| Nome: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+this.vidaMax;
        return nome + mana + vida;
    }

    void set_forca(int qtd){
        this.forca = qtd;
    }

    int getForca() {
        return forca;
    }

    void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}


