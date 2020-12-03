class Ansi {
    public static void main(String[] args) {
        //String texto_vermelho = "\u001B["+ "31" + "m"+"Texto vermelho";
        //String texto_verde = "\u001B["+ "32" + "m"+"Texto verde";
        //String texto_amarelo = "\u001B["+ "33" + "m"+"Texto amarelo";
        String texto_preto = "\u001B["+ "30" + "m"+"Texto preto";
        String texto_fundo = "\u001B["+ "41" + "m" + "Texto fundo";
        String limpar_texto = "\u001B["+"m";

        //System.out.println (texto_vermelho);
        
        //System.out.println (texto_verde);
        
        //System.out.println (texto_amarelo);
        
        //System.out.println (texto);

        for (int i = 0; i < 108; i++) {
            System.out.print("\u001B["+ Integer.toString(i) + "m"+"Texto esquerda: " + i+"                            -");
            System.out.println("\u001B["+"m");
        }

        //System.out.print(texto_fundo);
        //System.out.print(texto_preto+ "               -");

        //System.out.println(limpar_texto);
        
    }
}