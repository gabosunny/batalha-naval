package batalhanaval;

import java.util.Random;

/**
 *@author Thalles Prado Ribeiro - RA: 20195091 Gabriel Graseffe - RA: 20293658
 */
public class BatalhaNaval {
    
    private int tabuleiro[][] = new int[4][4];
    
       Random RandomBarco = new Random();
       String Barco[] = new String[4];
       int i;
       int j;
       /**
     * Método para iniciar o jogo, sorteando os 4 navios.
     * 
     */
       public void sortearNavios() {
        int x = -1,y = -1;
        String a,b,c;
        for (int k = 0; k<=3; k++){
        
        i = (int)(Math.random()*4);
        j = (int)(Math.random()*4);

        
        if(i==x && j==y){
            i = (int)(Math.random()*4);
            j = (int)(Math.random()*4);
        }
        x=i;
        y=j;
        tabuleiro[i][j] = 1;
        a = Integer.toString(x);
        b = Integer.toString(y);
        c = a + b;
        Barco[k] = c;
        }
    }

    /**
     * Método para verificar se o tiro acertou algum navio.
     *
     * @param i = linha escolhida pelo jogador.
     * @param j = coluna escolhida pelo jogador.
     * @return = true-acertou ; false-errou.
     */
    public boolean verificarTiro(int i, int j) {
        if (tabuleiro[i][j] == 1) {
            return true;
        } else {
            return false;
                       
        }
    }
    /**
     * Metodo para calculo da distancia PS: tem que puxar do JFrame a linha e 
     * coluna do tiro! (COMO SE FAZ?)
     * Converte a coordernada do tiro em numero x = i e y = j de acordo 
     * @param i = linha escolhida pelo jogador.
     * @param j = coluna escolhida pelo jogador.
     * @return int DistanciaMaior
     */
    public int verificarDistancia (int i, int j){
        
        int distanciaX,distanciaY;
        int DintanciaMaior = 0;
        int x,y;
        for (int k = 0;k<4;k++){
            
           x = Integer.parseInt( Character.toString(Barco[k].charAt(0)));
           y = Integer.parseInt( Character.toString(Barco[k].charAt(1)));
           distanciaX = x - i;// linha do barco - linha de tiro
           distanciaY = y - j;// coluna do barco - coluna do tiro
           if(distanciaX>distanciaY && distanciaX>DintanciaMaior){
            DintanciaMaior = distanciaX;
            }
            else {
            DintanciaMaior = distanciaY;
            }
        }
        
        

        return DintanciaMaior;
    }
    /**metodo para dica quando errar o tiro "somente se errar"
     * 
     * @return  String dica
     */
    public String dica() {
        int DistanciaMaior = verificarDistancia(i,j);
        String dica = "Tem um barco a " + DistanciaMaior + " de distancia";
        return dica;
    }
}
