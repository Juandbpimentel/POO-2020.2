import java.util.Scanner;

public class Mago extends Personagens{
    
    double xp_atual;
    double xp_para_upar;

    Mago(String name, int manaMax, int vidaMax){
        super(name, manaMax,vidaMax,1);
        this.xp_para_upar = 1*Math.pow(10, 2);
    }

    public String toString(){
        String nome = "| Nome: "+ this.name, 
        mana = " | Mana: "+ this.manaAtual+"/"+this.manaMax,
        vida = " | Vida: "+ this.vidaAtual+"/"+this.vidaMax,
        xp   = " | Xp: " + this.xp_atual+"/" + this.xp_para_upar,
        nivel= " | Nivel: "+ this.nivel;
        return nome + mana + vida + xp + nivel;
    }

    public static void main(String[] args) {
        Mago mago = new Mago("Patolino", 10,10);
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("init")){
                mago = new Mago(ui[1], Integer.parseInt(ui[2]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("show")){
                System.out.println(mago);
            }else{
                System.out.println("Comando Inválido");
            }
        }
        in.close();
    }
}
