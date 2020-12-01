import java.util.Scanner;

public class Soma {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int soma =0;
        while(true){
            int a = in.nextInt();
            if(a==-1)
                break;
            soma+=a;
        }
        System.out.println(soma);
        in.close();
    }
}
