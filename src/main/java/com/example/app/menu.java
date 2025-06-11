package com.example.app;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean jogarNovamente = true;
        int modoDeJogo;
        
        Jogo game;

        while(jogarNovamente) {
            modoDeJogo = Jogo.telaInical();
            
            if(modoDeJogo == 3) // caso jogador escolha sair
                return;
        
            game = new Jogo(modoDeJogo);
            jogarNovamente = game.iniciar(modoDeJogo == 2);
        }
    }
}