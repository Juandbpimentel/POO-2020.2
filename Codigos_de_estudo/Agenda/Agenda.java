package Agenda;

import java.util.Collections;
import java.util.ArrayList;

public class Agenda{
    public static void main(String[] args){
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Sarah Pimentel",19));
        pessoas.add(new Pessoa("Anna Laura",3));
        pessoas.add(new Pessoa("Pedro Kalleby",1));
        pessoas.add(new Pessoa("Dulce Soares",61));
        pessoas.add(new Pessoa("Cesar Soares",67));
        pessoas.add(new Pessoa("Juan Pimentel",19));
        pessoas.add(new Pessoa("Davi Pimentel",0));
        pessoas.add(new Pessoa("Samuel Pimentel",0));

        Collections.sort(pessoas);
        System.out.println(pessoas);
        for(Pessoa pessoinha : pessoas){
            if(pessoinha.equals("Sarah Pimentel")){
                System.out.println(pessoinha);
            }
        }
    }
}

class Pessoa implements Comparable<Object>{
    public String id;
    public int idade;

    Pessoa(String id, int idade){
        this.idade = idade;
        this.id=id;
    }
    
    @Override
    public String toString(){
        return id+":"+idade;
    }
    
    @Override
    public boolean equals(Object arg0){
        if(arg0 instanceof Pessoa){
            Pessoa obj = (Pessoa) arg0;
            return this.id.equals(obj.id);
        }
        return false;
    }
    
    public boolean equals(String arg0){
        return this.id.equals(arg0);
    }
    
    @Override
    public int compareTo(Object arg0){
        if(arg0 instanceof Pessoa){
            Pessoa obj = (Pessoa) arg0;
            int retorno = Integer.compare(this.idade,obj.idade);
            if(retorno != 0){
                return retorno;
            }
            retorno = this.id.compareTo(obj.id);
            return retorno;
        
        
        }
        return -1;
    }
}