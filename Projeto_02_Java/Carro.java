import java.util.Scanner;

public class Carro {
    int gasolina;
    int gasolinaMax;
    int passageiros;
    int passageirosMax;
    int quilometragem;

    Carro(){
        this.gasolina = 0;
        this. gasolinaMax = 100;
        this.passageiros = 0;
        this.passageirosMax = 2;
        this.quilometragem = 0;
    }

    boolean entrar_passageiro(){
        if(passageiros < passageirosMax){
            passageiros++;
            return true;
        }else{
            System.out.println("Não foi possível embarcar mais um passageiro pois o limite de passageiros foi alcançado");
            return false;
        }
    }

    boolean sair_passageiro(){
        if (passageiros > 0) {
            passageiros--;
            return true;
        }else{
            System.out.println("Não foi possível desembarcar mais um passageiro pois não há nenhum passageiro no carro");
            return false;
        }
    }

    void abastecer(int qtd){
        if(qtd+gasolina < gasolinaMax){
            gasolina += qtd;
        }else
            gasolina = gasolinaMax;
    }

    boolean dirigir(int distancia){
        if(passageiros > 0){
            if(gasolina > 0){
                if(distancia >= gasolina){
                    quilometragem += gasolina;
                    System.out.println("Tanque vazio após viajar " + gasolina + " quilômetros");
                    gasolina = 0;
                    return true;
                }else{
                    quilometragem += distancia;
                    gasolina -= distancia;
                    return true;
                }
            }else{
                System.out.println("O seu tanque de gasolina está vazio");
                return false;
            }
        }else{
            System.out.println("Não há ninguém no carro");
            return false;
        }
    }

    public String toString(){
        return "Passageiros: " + passageiros + ", Gasolina: " + gasolina + ", Quilometragem: " + quilometragem;
    }

    public static void mainInterativa(){
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
        in.close();;
    }

    public static void main(String[] args){
        Carro.mainInterativa();
        /*
        Carro car = new Carro();
        System.out.println(car);
        //pass: 0, gas: 0, km: 0
        car.entrar_passageiro();
        car.entrar_passageiro();
        System.out.println(car);
        //pass: 2, gas: 0, km: 0
        car.entrar_passageiro();
        //fail: limite de pessoas atingido
        System.out.println(car);
        //pass: 2, gas: 0, km: 0
        car.sair_passageiro();
        car.sair_passageiro();
        car.sair_passageiro();
        //fail: nao ha ninguem no carro
        System.out.println(car);
        //pass: 0, gas: 0, km: 0

        car = new Carro();
        car.abastecer(60);
        System.out.println(car);
        //pass: 0, gas: 60, km: 0

        car.dirigir(10);
        //fail: nao ha ninguem no carro

        car.entrar_passageiro();
        car.dirigir(10);
        System.out.println(car);
        //pass: 1, gas: 50, km: 10

        car.dirigir(70);
        //fail: tanque vazio apos andar 50 km
        car.dirigir(10);
        //fail: tanque vazio
        System.out.println(car);
        //pass: 1, gas: 0, km: 60

        car.abastecer(200);
        System.out.println(car);
        //pass: 1, gas: 100, km: 60*/
    }
}
