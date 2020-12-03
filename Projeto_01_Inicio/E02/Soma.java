import java.util.Scanner;

public class Soma {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count=0;
        while(true){
            char opt;
            int a = 0, b = 0;
            if(count == 0){
                System.out.println("\n\n\nPrograma de Soma");
                count++;
            }
            System.out.println("\n\n\nDigite o primeiro número");
            a = in.nextInt();
            System.out.println("\nDigite agora o segundo número");
            b = in.nextInt();
            System.out.println("\n\nA soma entre "+a+ " e "+ b +" é igual a "+(a+b));
            System.out.println("\n\nVocê quer continuar somando? se sim digite y, se não digite n");
            opt = in.next().charAt(0);
            if(opt == 'n'){
                break;
            }
        }
        in.close();
    }
}
