package Usuario;

import java.util.ArrayList;

public class Usuario {
    String nomeDeUsuario;
    ArrayList<Mensagem> inbox;
    int contadorMsgNaoLidas;
    static int idProximaMensagem = 0;

    public static void main(String[] args){
        /*Sistema sistema = new Sistema();
        sistema.addUser("Juan");
        sistema.addUser("Sarah;");

        sistema.sendMsg("Juan","Sarah","Minha fofinha :3");
        sistema.sendMsg("Juan","Sarah","e gostosona tbm :^");

        sistema.readMsgs("Sarah");*/

        Usuario user1 = new Usuario("Juan");
        Usuario user2 = new Usuario("Sarah");

        user1.sendMsg(user2, "Eu te amo muitão amor");
        user1.sendMsg(user2, "Mais que tudo nesse mundo");
        user1.sendMsg(user2, "Casa comigo? :3 <3");

        user2.sendMsg(user1, "Eu tbm amo voce mais que tudo");
        user2.sendMsg(user1, "eh claro que eu caso contigo <3");
        user2.sendMsg(user1, "voce eh tudo pra mim, amor");

        System.out.println(user2.getNaoLidas()+user1.getNaoLidas());
    }

    Usuario(String nome){
        this.nomeDeUsuario = nome;
        inbox = new ArrayList<Mensagem>();
    }

    public void sendMsg(Usuario dest, String text){
        dest.inbox.add(new Mensagem(idProximaMensagem,this.nomeDeUsuario,text));
        dest.contadorMsgNaoLidas++;
        Usuario.idProximaMensagem++;
    }

    public ArrayList<Mensagem> getInbox(){
        ArrayList<Mensagem> saida = new ArrayList<Mensagem>();

        for(int i = (this.inbox.size() - 1) - (this.contadorMsgNaoLidas-1); i < this.inbox.size();i++){
            saida.add(inbox.get(0));
        }
        this.contadorMsgNaoLidas=0;
        inbox.clear();
        return saida;
    }
// 0 1 2 3 ** **
    public String getNaoLidas(){
        String saida = "";
        for(int i = (this.inbox.size()) - (this.contadorMsgNaoLidas); i < this.inbox.size();i++){
            saida += inbox.get(i)+"\n";
        }
        this.contadorMsgNaoLidas = 0;
        return (saida.equals(""))?"- vazio -":saida;
    }
    public String getTodasMensagens(){
        String saida = "";
        for(int i = 0; i < this.inbox.size();i++){
            saida += inbox.get(i)+"\n";
        }
        this.contadorMsgNaoLidas = 0;
        return (saida.equals(""))?"- vazio -":saida;
    }
    
    public String toString() {
        return "Nome de Usuário: " + this.nomeDeUsuario + "\nMensagens não lidas: " + this.contadorMsgNaoLidas;
    }
}   

class Mensagem{
    int id;
    String emissor;
    String texto;

    public Mensagem(int id,String emissor, String texto){
        this.emissor = emissor;
        this.texto = texto;
        this.id = id;
    }

    public String toString(){
        return id +" : "+ emissor + " : "+texto;
    }
}
