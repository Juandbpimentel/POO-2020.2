import java.util.Scanner;

public class Soma {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int nivel = 1, constituicao = 1, inteli = 1;
        long mana=0, vida=0;
        
        while(true){

            if (nivel%2==0){
                mana += ( (inteli * 5) * 2*nivel);
                constituicao++;
                vida += ( (constituicao * 5) * 4 *nivel);
            } else {
                vida += ( (constituicao * 5) * 4 *nivel);
                inteli++;
                mana += ( (inteli * 5) * 2*nivel);
            }
            if(nivel==10000)
                break;
            nivel++;
        }
        System.out.println("Mana: "+mana+" | "+"Vida: "+vida+"   "+constituicao+"   "+inteli);
        in.close();
    }
}
