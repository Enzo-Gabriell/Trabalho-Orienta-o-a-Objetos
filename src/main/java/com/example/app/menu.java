package com.example.app;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    private static int telaInical(){
        int acao;
        System.out.println("\u001b[1m Duelo de Personagens! \u001b[0m");
        System.out.print("Jogar PvP(1) Jogar PvE(2) Sair do Jogo(3): ");
        do{
            try {
                acao = Integer.parseInt(sc.nextLine());
                if(acao != 1 && acao != 2 && acao != 3)
                    System.out.print("Opção inválida. Tente novamente: ");
            }
            catch (NumberFormatException e) {
                System.out.println("Entrada inálida. Tente novamente: ");
                acao = 0;
            }
            
        }while(acao != 1 && acao != 2 && acao != 3);
        return acao;
    }

    public static void main(String[] args) {
        Jogo game = new Jogo();
        int turnos = 1, acao;
        boolean rendicao = game.getRender();


        acao = telaInical();
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

                if (game.play
            Bot bot;er1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
                }
 gma=ame.palayrer2                turnos++;
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