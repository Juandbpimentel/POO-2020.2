import java.util.Scanner;

import cods.Calango;
import cods.Carro;


public class Interativo{
    void mainCalango(){
        //referencia      = criando objeto
        Calango deadlango = new Calango(20,20,10);
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.print(">");
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            //System.out.println("$"+ui[0]+"\n");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("comer")){
                if(ui.length == 2)
                    deadlango.comer(Integer.parseInt(ui[1]));
                else
                    System.out.println("Você esqueceu de botar quantos bichos ele comeu");
            }else if(ui[0].equals("andar") && ui.length == 2){
                if(ui.length == 2)
                    deadlango.andar(Integer.parseInt(ui[1]));
                else
                    System.out.println("Você esqueceu de botar a distância que ele andou");
            }else if(ui[0].equals("acidentar")){
                deadlango.acidentar();
            }else if(ui[0].equals("regenerar")){
                deadlango.regenerar();
            }else if(ui[0].equals("show")){
                System.out.println(deadlango);
            }else if(ui[0].equals("caçarCalangoNovo")){
                if(ui.length == 4){
                    deadlango = new Calango(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]),Integer.parseInt(ui[3]));
                    System.out.println("Toma aqui seu calango novo ;D");
                }else
                    System.out.println("Me dá as informações do calango novo pra eu ir caçar ele pra você");
            }
        }
        scanner.close();;
    }
    
    void mainCarro(){
        Scanner in = new Scanner(System.in);
        Carro carro = new Carro();
        while(true){
            System.out.print(">");
            String line = in.nextLine();
            String ui[] = line.split(" ");
            
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("entrar") ||ui[0].equals("in")){
                carro.entrar_passageiro();
            }else if(ui[0].equals("sair") || ui[0].equals("out")){
                carro.sair_passageiro();
            }else if(ui[0].equals("abastecer") || ui[0].equals("fuel")){
                if(ui.length == 2)
                    carro.abastecer(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("dirigir") || ui[0].equals("drive")){
                if(ui.length == 2)
                    carro.dirigir(Integer.parseInt(ui[1]));
    
            }else if(ui[0].equals("show")){
                System.out.println(carro);
            }else
                System.out.println("Operação inválida");
        }
        in.close();
    }
    public static void main(String[] args) {
        Interativo teste = new Interativo();
        System.out.println("Escolha entre abrir o código do carro ou o do calango, digite car para carro ou calan para calango");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line.equals("car")){
            teste.mainCarro();
        }else if(line.equals("calan")){
            teste.mainCalango();
        }else
            System.out.println("Opção inválida!");
        scanner.close();
    }

}