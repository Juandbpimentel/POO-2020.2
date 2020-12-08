package cods;

public class Carro {
    int gasolina;
    int gasolinaMax;
    int passageiros;
    int passageirosMax;
    int quilometragem;

    public Carro(){
        this.gasolina = 0;
        this. gasolinaMax = 100;
        this.passageiros = 0;
        this.passageirosMax = 2;
        this.quilometragem = 0;
    }

    public boolean entrar_passageiro(){
        if(passageiros < passageirosMax){
            passageiros++;
            return true;
        }else{
            System.out.println("Não foi possível embarcar mais um passageiro pois o limite de passageiros foi alcançado");
            return false;
        }
    }

    public boolean sair_passageiro(){
        if (passageiros > 0) {
            passageiros--;
            return true;
        }else{
            System.out.println("Não foi possível desembarcar mais um passageiro pois não há nenhum passageiro no carro");
            return false;
        }
    }

    public void abastecer(int qtd){
        if(qtd+gasolina < gasolinaMax){
            gasolina += qtd;
        }else
            gasolina = gasolinaMax;
    }

    public boolean dirigir(int distancia){
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
    
}
