package menus;

import java.util.ArrayList;
import java.util.Scanner;

import itens.*;
import jogadores.Jogador;

public class Loja{
    private static Scanner in = new Scanner(System.in);
    private ArrayList<Item> inventario;

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();     
    }

    public Loja(Jogador jogador){
        this.inventario = new ArrayList<Item>();
        inventario.add(new Escudo(jogador.getNivel())   );
        inventario.add(new Escudo(jogador.getNivel())   );
        inventario.add(new Escudo(jogador.getNivel())   );
        inventario.add(new Armadura(jogador.getNivel()) );
        inventario.add(new Armadura(jogador.getNivel()) );
        inventario.add(new Armadura(jogador.getNivel()) );
        inventario.add(new Arma(jogador.getNivel())     );
        inventario.add(new Arma(jogador.getNivel())     );
        inventario.add(new Arma(jogador.getNivel())     );
        
        inventario.add(new Item(jogador.getNivel())     );
        inventario.add(new Item(jogador.getNivel())     );
        inventario.add(new Item(jogador.getNivel())     );
    }

    public void menuCompra(Jogador jogador){
        clearConsole();
        while (true){
            System.out.println("\n\n\n\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<    Inventário da loja    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n\n");
            String menuLoja =   "Dinheiro na bolsa: "+jogador.getDinheiro()+
                                "\nMenu de opções:"+
                                "\n-------------------------------------------------------------------------------------"+
                                "\n| 1 -   Ver o estoque               - Digite verEstoque ou 1 para escolher a opção     |\n"+
                                "\n| 2 -   Comprar                     - Digite comprar ou 2 para escolher a opção        |\n"+
                                "\n| 3 -   Vender                      - Digite vender ou 3 para escolher a opção         |\n"+
                                "\n| 4 -   Ver o inventário do jogador - Digite verInventario ou 4 para escolher a opção  |\n"+
                                "\n| 5 -   Comprar poções              - Digite poções ou 5 para escolher a opção         |\n"+
                                "\n| 6 -   Concertar Arma              - Digite concertar ou 6 para escolher a opção      |\n"+
                                "\n| 7 -   Sair da loja                - Digite sair ou 7 para escolher a opção           |\n"+
                                "\n-------------------------------------------------------------------------------------\n"+
                                "\nDigite o número ou o nome da opção desejada>>> ";
            System.out.print(menuLoja);
            String line = in.next();
            String[] ui = line.split(" ");

            if (ui[0].equals("1")||ui[0].equals("verEstoque")) {
                clearConsole();
                showLoja(0);
            }else if(ui[0].equals("2")||ui[0].equals("comprar")){
                clearConsole();
                System.out.print("\n\nDigite o número ou o nome da categoria do item para compra-lo:(1-Escudos | 2-Armaduras | 3-Armas | 4-Itens): ");
                String opt = in.next(); 
                
                if(opt.equals("1")||opt.equals("Escudos")){
                    compra(jogador,1);
                }
                
                else if(opt.equals("2")||opt.equals("Armaduras")){
                    compra(jogador, 2);
                }
                
                else if(opt.equals("3")||opt.equals("Armas")){
                    compra(jogador, 3);

                }
                
                else if(opt.equals("4")||opt.equals("Itens")){
                    compra(jogador, 4);
                }

            }else if(ui[0].equals("3")||ui[0].equals("vender")){
                clearConsole();
                jogador.showInventario();
                System.out.print("\n\nDigite o número ou o nome da categoria do item que quer vender:(1-Escudos | 2-Armaduras | 3-Armas | 4-Itens | 5-Equipados): ");
                String opt = in.next();

                if(opt.equals("1")||opt.equals("Escudos")){
                    jogador.vender(this.inventario,1);
                }
                
                else if(opt.equals("2")||opt.equals("Armaduras")){
                    jogador.vender(this.inventario,2);
                }
                
                else if(opt.equals("3")||opt.equals("Armas")){
                    jogador.vender(this.inventario,3);

                }
                else if(opt.equals("4")||opt.equals("Itens")){
                    jogador.vender(this.inventario,4);
                }
                else if(opt.equals("5")||opt.equals("Equipados")){
                    jogador.vender(this.inventario,5);
                }
            }else if(ui[0].equals("4")||ui[0].equals("verInventario")){
                clearConsole();
                jogador.showInventario();
            }else if(ui[0].equals("5")||ui[0].equals("pocoes")){
                System.out.print("\n\n>>>As poções são 50 peças de ouro, você quer reabastecer elas? Digite Y se quiser, ou qualquer outra coisa se não: ");
                if(in.next().equals("Y")){
                    jogador.reabastecerPocoes();
                }
                
            }else if(ui[0].equals("6")||ui[0].equals("concertar")){
                System.out.print("\n\n>>>As poções são 50 peças de ouro, você quer reabastecer elas? Digite Y se quiser, ou qualquer outra coisa se não: ");
                if(in.next().equals("Y")){
                    jogador.reabastecerPocoes();
                }
                
            }else if(ui[0].equals("7")||ui[0].equals("sair")){
                clearConsole();
                break;
            }else{
                clearConsole();
                System.out.println("Opção inválida");
            }
        }
    }

    
    private boolean showLoja(int categoria){
        switch (categoria) {
            case 0:
                System.out.println("\n\n<<<<< Estoque da loja >>>>>");
            
                for (int i = 0; i < 4; i++) {
                    if(i == 0)
                        showEscudos();
                    if(i == 1)
                        showArmaduras();
                    if(i == 2)
                        showArmas();
                    if(i == 3)
                        showItens();
                    }
                    break;
            case 1:
                return showEscudos();    
                /*
                fatorial = 10;
                
                for(int i = fatorial-1; i>0; i--){
                    fatorial /= i;
                }

                */
            case 2:
                return showArmaduras();
        
            case 3:
                return showArmas();
        
            case 4:
                return showItens();
        
            default:
                System.out.println("Categoria inválida");
                return false;
        }
        return false;
    }

    private boolean showEscudos(){
        int count = 0;
        System.out.println("\n  -Escudos:");        
        for (Item item : this.inventario)
            if(item.getTipoDeItem().equals("Escudo")){
                count++;
                System.out.println("\n    "+count+") "+item);
            }
        
        if(count == 0){
            System.out.println("\n  -As escudos do inventário acabaram");
            return false;
        }
        return true; 
    }

    private boolean showArmaduras(){
        int count = 0;
        System.out.println("\n  -Armaduras:");
        for(Item item : this.inventario)
            if(item.getTipoDeItem().equals("Armadura")){
                count++;
                System.out.println("\n    "+count+") "+item);
            }
        
        if(count == 0){
            System.out.println("\n  -As armadura do inventário acabaram");
            return false;
        }
        return true; 
    }

    private boolean showArmas(){
        int count = 0;
        System.out.println("\n  -Armas:");
        
        for (Item item : this.inventario)
            if(item.getTipoDeItem().equals("Arma")){
                count++;
                System.out.println("\n    "+count+") "+item);
            }
        
        if(count == 0){
            System.out.println("\n  -As armas do inventário acabaram");
            return false;
        }
        return true; 
    }

    private boolean showItens(){
        int count = 0;
        System.out.println("\n  -Itens:");
                        
        for (Item item : this.inventario)
            if(item.getTipoDeItem().equals("Item Básico")){
                count++;
                System.out.println("\n    "+count+") "+item);
            }
        
        if(count == 0){
            System.out.println("\n  -Os Itens do inventário acabaram");
            return false;
        }
        return true;       
    }

    private void compra(Jogador jogador, int opt) {
        String opt2="";
        int count=0;
        Item temp = null;
        boolean resultado = false;
        switch (opt) {
            case 1:
                if(!showLoja(opt)){
                    return;
                }
                System.out.println("Você tem "+jogador.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número do escudo que quer comprar: ");
                opt2 = in.next();
                for(Item item : this.inventario){
                    if (item.getTipoDeItem().equals("Escudo")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = this.inventario.remove(this.inventario.indexOf(item));
                            break;
                        }
                    }
                }
        
                resultado = ( (jogador.comprarItem(temp)) ? true : ((temp!= null)? this.inventario.add(temp): false) );
               
                if (resultado) {
                    System.out.println("A compra deu certo");
                }else
                    System.out.println("A compra deu errado");
                break;
            case 2:
                if(!showLoja(opt)){
                    return;
                }
                System.out.println("Você tem "+jogador.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número da armadura que quer comprar: ");
                opt2 = in.next();

                for(Item item : this.inventario){
                    if (item.getTipoDeItem().equals("Armadura")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = this.inventario.remove(this.inventario.indexOf(item));
                            break;
                        }
                    }
                }

                resultado = ( (jogador.comprarItem(temp))? true: ((temp!= null)? this.inventario.add(temp): false) );
                if (resultado) {
                    System.out.println("A compra deu certo");
                }else
                    System.out.println("A compra deu errado");
                break;
            case 3:
                if(!showLoja(opt)){
                    return;
                }
                System.out.println("Você tem "+jogador.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número da arma que quer comprar: ");
                opt2 = in.next();

                for(Item item : this.inventario){
                    if (item.getTipoDeItem().equals("Arma")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = this.inventario.remove(this.inventario.indexOf(item));
                            break;
                        }
                    }
                }

                resultado = ( (jogador.comprarItem(temp))? true: ((temp!= null)? this.inventario.add(temp): false) );
                if (resultado) {
                    System.out.println("A compra deu certo");
                }else
                    System.out.println("A compra deu errado");
                break;
            case 4:
                if(!showLoja(opt)){
                    return;
                }
                System.out.println("Você tem "+jogador.getDinheiro()+" de gold");
                System.out.print("\n\nAgora escolha o número do item que quer comprar: ");
                opt2 = in.next();

                for(Item item : this.inventario){
                    if (item.getTipoDeItem().equals("Item Básico")){
                        count++;
                        if(count == Integer.parseInt(opt2)){
                            temp = this.inventario.remove(this.inventario.indexOf(item));
                            break;
                        }
                    }
                }

                resultado = ( (jogador.comprarItem(temp))? true: ((temp!= null)? this.inventario.add(temp): false) );
                if (resultado) {
                    System.out.println("A compra deu certo");
                }else
                    System.out.println("A compra deu errado");
                break;
            
        
            default:
                break;
        }
    }

}

