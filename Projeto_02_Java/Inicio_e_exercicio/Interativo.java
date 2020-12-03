import java.util.Scanner;
import cods.Calango;
import cods.Carro;


public class Interativo{
    public static String texto_preto = "\u001B["+ "30" + "m";
    public static String texto_vermelho = "\u001B["+ "31" + "m";
    public static String texto_verde = "\u001B["+ "32" + "m";
    public static String texto_amarelo = "\u001B["+ "33" + "m";
    public static String texto_fundo_amarelo = "\u001B["+ "43" + "m";
    public static String limpar_texto = "\u001B["+"m";
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Interativo teste = new Interativo();
        System.out.print(texto_verde+"-----------------------Menu de seleção de programas-----------------------\n Digite sua opção:\n  (1) Carro\n  (2) Calango\n\n>>");


        String line = scanner.nextLine();
        
        System.out.println(limpar_texto);

        if(line.equals("1")){
            teste.mainCarro();
        }else if(line.equals("2")){
            teste.mainCalango();
        }else
            System.out.println("Opção inválida!");
        scanner.close();
    }
    
    void mainCalango(){
        //referencia      = criando objeto
        System.out.println(texto_amarelo+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------- Calango Mutante ----------------------------\n\n\n- Digite help para ver os comandos\n");
        System.out.println(limpar_texto);

        Calango deadlango = new Calango(20,20,10);
        
        while(true){
            System.out.print(texto_amarelo+"> ");
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            //System.out.println("$"+ui[0]+"\n");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("comer")){
                if(ui.length == 2)
                    deadlango.comer(Integer.parseInt(ui[1]));
                else
                    System.out.println(texto_amarelo+"Você esqueceu de botar quantos bichos ele comeu");
                    System.out.println(limpar_texto);
            }else if(ui[0].equals("andar") && ui.length == 2){
                if(ui.length == 2)
                    deadlango.andar(Integer.parseInt(ui[1]));
                else
                    System.out.println(texto_amarelo+"Você esqueceu de botar a distância que ele andou");
                    System.out.println(limpar_texto);
            }else if(ui[0].equals("acidentar")){
                deadlango.acidentar();
            }else if(ui[0].equals("regenerar")){
                deadlango.regenerar();
            }else if(ui[0].equals("show")){
                System.out.println(texto_amarelo+deadlango);
            }else if(ui[0].equals("caçarCalangoNovo")){
                if(ui.length == 4){
                    deadlango = new Calango(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]),Integer.parseInt(ui[3]));
                    System.out.println(texto_amarelo+"Toma aqui seu calango novo ;D");
                    System.out.println(limpar_texto);
                }else
                    System.out.println(texto_amarelo+"Me dá as informações do calango novo pra eu ir caçar ele pra você");
                    System.out.println(limpar_texto);
            }else if(ui[0].equals("help")){
                helpCalango();
            }
        }
    }
    
    void mainCarro(){
        System.out.println(texto_vermelho+"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n---------------------------- Carro de Fuga ----------------------------\n\n\n- Digite help para ver os comandos\n");
        System.out.print(limpar_texto);

        Carro carro = new Carro();
        while(true){
            System.out.print(texto_vermelho+"> ");
            String line = scanner.nextLine();


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
    
            }else if(ui[0].equals("show")||ui[0].equals("mostrar")){
                System.out.println(texto_vermelho+carro);
            }else if(ui[0].equals("help")){
                helpCarro();
            }else{
                System.out.print(texto_vermelho+"Operação inválida");
                System.out.println(limpar_texto);
            }
        }
    }

    void helpCarro(){
        System.out.println("\n\n\n\n");
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);
        System.out.print(texto_vermelho+"|                                     Comandos do programa                                     |");
        System.out.println(limpar_texto);
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);
        System.out.print(texto_vermelho+"|       entrar      |         in        | Coloca um passageiro dentro do carro                 |");
        System.out.println(limpar_texto);
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"|        sair       |        out        | Tira um passageiro do carro                          |");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"|  abastecer <int>  |     fuel <int>    | Abastece o carro                                     |");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"|   dirigir <int>   |    drive <int>    | Dirige o carro por uma distância x se tiver gasolina |");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"|       mostrar     |        show       | Mostra as informações do carro                       |");
        System.out.println(limpar_texto);        
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);       
        System.out.print(texto_vermelho+"|                  end                  | Fecha o programa                                     |");
        System.out.println(limpar_texto);       
        System.out.print(texto_vermelho+"------------------------------------------------------------------------------------------------\n\n");
        System.out.println(limpar_texto);
    }

    void helpCalango(){
        System.out.println("\n\n\n\n");
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);
        System.out.print(texto_amarelo+"|                                                    Comandos do programa                                                   |");
        System.out.println(limpar_texto);
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);
        System.out.print(texto_amarelo+"|               comer <int>              | Dá uma quantidade de insetos para seu calango comer                              |");
        System.out.println(limpar_texto);
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"|               andar <int>              | Faz seu calango ir dar uma caminhada se tiver com o bucho cheio ou vivo          |");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"|                acidentar               | Faz seu calango sofrer um acidente e perder uma pata se ele tiver uma pra perder |");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"|                regenerar               | Recupera uma pata se seu calango estiver de estomago cheio                       |");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"|   caçarCalangoNovo <int> <int> <int>   | Caça um calango novo pra você caso o seu sofra uma fatalidade                    |");
        System.out.println(limpar_texto);
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);       
        System.out.print(texto_amarelo+"|                   show                 | Mostra as informações do seu calango mutante                                     |");
        System.out.println(limpar_texto);        
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println(limpar_texto);       
        System.out.print(texto_amarelo+"|                   end                  | Fecha o programa                                                                 |");
        System.out.println(limpar_texto);       
        System.out.print(texto_amarelo+"-----------------------------------------------------------------------------------------------------------------------------\n\n");
        System.out.println(limpar_texto);
    }

}