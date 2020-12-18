import java.util.Scanner;

import cods.Tamagotchi;

public class InterativoTamagotchi {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Tamagotchi pet = new Tamagotchi();
        while(true){
            System.out.print("\n> ");
            String line = in.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                System.out.println("$"+ui[0]);
                break;
            }else if(ui[0].equals("brincar")){
                System.out.println("$"+ui[0]);
                pet.brincar();
            }else if(ui[0].equals("comer")){
                System.out.println("$"+ui[0]);
                pet.comer();
            }else if(ui[0].equals("dormir")){
                System.out.println("$"+ui[0]);
                pet.dormir();
            }else if(ui[0].equals("banhar")){
                System.out.println("$"+ui[0]);
                pet.tomarBanho();
            }else if(ui[0].equals("mostrar")){
                System.out.println("$"+ui[0]+"\n");
                System.out.println(pet);
            }else if(ui[0].equals("init")){
                if(ui.length == 5){
                    pet = new Tamagotchi(ui[1],Integer.parseInt(ui[2]),Integer.parseInt(ui[3]),Integer.parseInt(ui[4]));
                }else{
                    System.out.println("fail: passe todos os parâmetros novamente");
                }
            }else
                System.out.println("Comando inválido");
        }
        in.close();
    }
}
