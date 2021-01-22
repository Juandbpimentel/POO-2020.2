package menus;

import mobs.Mob;
import jogadores.Jogador;
import itens.Item;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Luta{
    private static Scanner in = new Scanner(System.in);

    public void gerarLuta(Mob mob, Jogador jogador){
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<     Menu de luta     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        boolean defenderJog=false;

        boolean defenderMob=false;
        System.out.println(mob);
        while (true){
            
            defenderJog=false;
            jogador.show();
            mob.show();
            while (true) {

                System.out.println("Opções de luta:");
                System.out.println("1) atacar");
                System.out.println("2) potar");
                System.out.println("3) defender");
                System.out.println("4) fugir");
                System.out.println("Escolha a opção: ");

                String line = in.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("atacar")||ui[0].equals("1")){
                    mob.receberAtaque(jogador, defenderMob);
                    if(!mob.checarVivo()){
                        ArrayList<Item> drops = new ArrayList<Item>(mob.droparItens());
                        if(!drops.isEmpty()){
                            while(!drops.isEmpty()){
                                System.out.println(drops.get(0));
                                System.out.print("Você quer ficar com esse item?(y/n): ");
                                line = in.nextLine();
                                if(line.equals("y")||line.equals("Y")) 
                                    jogador.pegarDrop(drops.remove(0));
                                else
                                    drops.remove(0);
                            }
                        }
                        jogador.receberDinheiro(mob.droparDinheiro());
                        jogador.receberXp(mob.droparXp());
                        return;
                    }
                    break;
                }else if(ui[0].equals("potar")||ui[0].equals("2")){
                    if(jogador.potar())
                        break;
                }else if(ui[0].equals("fugir")||ui[0].equals("4")){
                    if( new Random().nextInt(100)+1 < 5 + jogador.getNivel()- mob.getNivel() ){
                        System.out.println("Você conseguiu fugir do seu inimigo :D");
                        return;
                    }else
                        break;
                }else if(ui[0].equals("defender")||ui[0].equals("3")){
                    System.out.println("Você armou sua pose de defesa OuO!");
                    defenderJog=true;
                    break;
                }else{
                    System.out.println("Opção inválida");
                }
            }

            defenderMob=false;

            while (true) {
        
                int randNum = new Random().nextInt(100)+1;
                if(randNum>30){
                    jogador.receberAtaque(mob, defenderJog);
                    if(!jogador.checarVivo())
                        return;
                    break;
                }else if(randNum<=30){
                    if (mob.checarVidaBaixa()) {
                        int randVidaBaixa = new Random().nextInt(100)+1;
                        if (randVidaBaixa<=10){
                            int randFugir = new Random().nextInt(100)+1;
                            if(randFugir<30){
                                System.out.println("O seu inimigo fugiu");
                                return;
                            }else
                                break;
                        }else if(randVidaBaixa<=30 && randVidaBaixa>10 ){
                            if(mob.potar())
                                break;
                        }else if(randVidaBaixa>30){
                            System.out.println("O mob está em pose de defesa");
                            defenderMob=true;
                            break;
                        }
                    }else{
                        System.out.println("O mob está em pose de defesa");
                        defenderMob=true;
                        break;
                    }
                }
            }
        }
    }

    
}
