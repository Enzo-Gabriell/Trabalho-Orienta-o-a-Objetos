package com.example.app;

public class Menu {
    public static void main(String[] args) {
        boolean jogarNovamente = true;
        int modoDeJogo;
        
        Jogo game;

        while(jogarNovamente) {
            modoDeJogo = Jogo.telaInical();
            
            if(modoDeJogo == 3)// caso jogador escolha sair
                break;
        
            game = new Jogo(modoDeJogo);
            jogarNovamente = game.iniciar(modoDeJogo == 2);
        }
        
        System.out.println("OBRIGADO POR TER JOGADO!!!");
    }
}