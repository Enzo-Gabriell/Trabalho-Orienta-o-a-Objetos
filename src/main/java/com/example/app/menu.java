package com.example.app;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int modoDeJogo = Jogo.telaInical();
        if(modoDeJogo == 3)
            return;

        Jogo game = new Jogo(modoDeJogo);
        int turnos = 1;

        if(modoDeJogo == 1){
            
            while(game.getRender() && turnos <= 50){
                
                game.tabuleiro.imprimeTabuleiro();
                game.tabuleiro.imprimeSituacao(game.player1, game.player2);

                game.acao(game.player1, game.player2, false);

                if (!game.getRender()) { // caso player 1 se renda
                    System.out.println(game.player1.getNome() + " se rendeu.");
                    break;
                }

                    if (game.player2.getPontosDeVida() == 0) {
                    System.out.println(game.player2.getNome() + " faleceu!!");
                    break;
                }

                game.acao(game.player2, game.player1, false);

                if (game.player1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
                }
                turnos++;
            }
        } else if(modoDeJogo == 2){
            while(game.getRender() && turnos <= 50){
                game.tabuleiro.imprimeTabuleiro();
                game.tabuleiro.imprimeSituacao(game.player1, game.player2);

                game.acao(game.player1, game.player2, false);

                if (!game.getRender()) // caso player 1 se renda
                    break;

                    if (game.player2.getPontosDeVida() == 0) {
                    System.out.println(game.player2.getNome() + " faleceu!!");
                    break;
                }

                game.acao(game.player2, game.player1, true);

                if (game.player1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
                }
                turnos++;
            }
        }
    }
}