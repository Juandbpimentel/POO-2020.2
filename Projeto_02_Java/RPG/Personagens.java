import java.util.Scanner;
public class Personagens {
    String name;
    long vidaAtual;
    long vidaMax;
    long manaAtual;
    long manaMax;
    long xp_atual;
    long xp_para_upar;
    int forca;
    int constituicao;
    int inteligencia;
    int nivel;

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    void setForca(int forca){
        this.forca = forca;
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

    public Personagens(String name, int nivel){
        this.name = name;
        this.vidaMax = 10;
        this.manaMax = 10;
        this.nivel=nivel;
        this.constituicao=1;
        this.inteligencia=1;
        this.forca=1;
        this.xp_para_upar = 5 * (int)Math.pow(2, nivel);

        int pontos_de_habilidade = nivel-1;
        Scanner in = new Scanner(System.in);
        int count_nivel = 1;
        
        if(pontos_de_habilidade>0)
            while (pontos_de_habilidade > 0){
                System.out.println("Distribua seus pontos de habilidade - " + "Pontos disponíveis: " + pontos_de_habilidade);
                System.out.println("Pontos de Força: "+ this.forca);
                System.out.println("Pontos de Inteligência: "+ this.inteligencia);
                System.out.println("Pontos de Constituição: "+this.constituicao);
                System.out.print("Selecione a opção para adicionar 1 ponto de habilidade:\n   (1) - Força\n   (2) - Inteligência\n   (3) - Constituição\n\n>");
                int opt = in.nextInt();
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
        in.close();
    }

    public String toString(){
        String nome = "| Nome: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax,
        xp   = " | Xp: " + this.xp_atual+"/" + this.xp_para_upar,
        nivel= " | Nivel: "+ this.nivel +" |";
        String saida = nome + mana + vida + xp + nivel;
        int n = saida.length();
        saida = "\n" + saida + "\n";
        for (int i = 0; i < n; i++) {
            saida = "-" + saida + "-";
        } 
        return "\n\n"+saida;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do seu personagem");
        String nome = in.nextLine();
        System.out.println("Agora digite o nível do seu personagem");
        int nivel = in.nextInt();
        Personagens teste = new Personagens(nome,nivel);
        System.out.println(teste);
        in.close();
    }
}


