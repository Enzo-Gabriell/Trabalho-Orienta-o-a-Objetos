package com.example.app;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogo game = new Jogo();
        int turnos = 1, acao;
        boolean rendicao = game.getRender();


        acao = game.telaInical();
        if(acao == 1){
            while(rendicao && turnos <= 50){
                
                game.tabuleiro.imprimeTabuleiro();
                game.tabuleiro.imprimeSituacao(game.player1, game.player2);

                game.acao(game.player1, game.player2);

                if (!rendicao) // caso player 1 se renda
                    break;

                    if (game.player2.getPontosDeVida() == 0) {
                    System.out.println(game.player2.getNome() + " faleceu!!");
                    break;
                }

                game.acao(game.player2, game.player1);

                if (game.player1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
                }
            }
        } else if(acao == 2){
            while(rendicao && turnos <= 50){
                
                game.tabuleiro.imprimeTabuleiro();
                game.tabuleiro.imprimeSituacao(game.player1, game.player2);

                game.acao(game.player1, game.player2);

                if (!rendicao) // caso player 1 se renda
                    break;

                    if (game.player2.getPontosDeVida() == 0) {
                    System.out.println(game.player2.getNome() + " faleceu!!");
                    break;
                }

                game.acao(game.player2, game.player1);

                if (game.player1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
                }
                turnos++;
            }
        }
    }
}