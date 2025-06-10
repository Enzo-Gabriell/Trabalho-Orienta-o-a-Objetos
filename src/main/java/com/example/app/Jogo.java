package com.example.app;

import java.util.Scanner;

public class Jogo {
    protected Tabuleiro tabuleiro;
    protected Personagens player1;
    protected Personagens player2;
    static Scanner sc = new Scanner(System.in);

    public Jogo () {
        this.tabuleiro = new Tabuleiro(10, 10);

        char tipoPersonagem;
        System.out.println("Escolha o tipo de personagem, Mago(M), Guerreiro(G) e Arqueiro(A)");
        do {
            tipoPersonagem = sc.next().charAt(0);
            sc.nextLine();

            if(tipoPersonagem != 'M' && tipoPersonagem != 'G' && tipoPersonagem != 'A')
                System.out.println("Opção inválida, tente novamente!!!");
        } while(tipoPersonagem != 'M' && tipoPersonagem != 'G' && tipoPersonagem != 'A');
        
        this.player1 = inicializaPlayer(tipoPersonagem, true);

        System.out.println("Escolha o tipo de personagem, Mago(M), Guerreiro(G) e Arqueiro(A)");
        do {
            tipoPersonagem = sc.next().charAt(0);
            sc.nextLine();

            if(tipoPersonagem != 'M' && tipoPersonagem != 'G' && tipoPersonagem != 'A')
                System.out.println("Opção inválida, tente novamente!!!");
        } while(tipoPersonagem != 'M' && tipoPersonagem != 'G' && tipoPersonagem != 'A');
        this.player2 = inicializaPlayer(tipoPersonagem, false);
    }

    public static void main(String[] args) {
        Jogo game = new Jogo();

        while(true) {
            game.tabuleiro.imprimeTabuleiro();
            
            game.tabuleiro.imprimeSituacao(game.player1, game.player2);

            int acao;
            System.out.println("Player1 Escolha atacar(1), defender(2), andar(3) ou special(4)");
            acao = Integer.parseInt(sc.nextLine()); 
            switch (acao) {
                case 1 -> game.atacar(game.player1, game.player2);
                case 2 -> game.player1.defender();
                case 3 -> game.andar(game.player1);
                case 4 -> game.player1.specialPower(game.player2);
            }

            if(game.player2.getPontosDeVida() == 0) {
                System.out.println(game.player2.getNome() + " faleceu!!");
                break;
            }

            System.out.println("Player2 Escolha atacar(1), defender(2), andar(3) ou special(4)");
            acao = Integer.parseInt(sc.nextLine());
            switch (acao) {
                case 1 -> game.atacar(game.player2, game.player1);
                case 2 -> game.player2.defender();
                case 3 -> game.andar(game.player2);
                case 4 -> game.player2.specialPower(game.player1);
            }

            if(game.player1.getPontosDeVida() == 0) {
                    System.out.println(game.player1.getNome() + " faleceu!!");
                    break;
            }
        }
    }

    protected Personagens inicializaPlayer(char personagem, boolean p1) {
        Personagens player;
        int linha, coluna;

        do {
            linha = gera();
            coluna = gera();
        }while(tabuleiro.grade[linha][coluna] != null);

        switch (personagem) {
            case 'M' -> player = new Mago(linha, coluna, p1);
            case 'G' -> player = new Guerreiro(linha, coluna, p1);
            case 'A' -> player = new Arqueiro(linha, coluna, p1);
            default -> player = null;
        }
        this.tabuleiro.grade[linha][coluna] = player;

        return player;

    }

    protected int gera() { // gera um número aleatório de 0 a 10 para posições dos personagens
        int num = (int)(Math.random() * tabuleiro.getLinhas());

        return num;
    }

    protected void andar(Personagens p) {
        char move;
        
        do {
            System.out.println("Pra qual direção? cima(C), baixo(B), direita(D) ou esquerda(E)");
            move = sc.nextLine().charAt(0);
            System.out.println();

            if(move != 'C' && move != 'B' && move != 'D' && move != 'E')
                System.out.println("Opção inválida, tente novamente");

        } while(move != 'C' && move != 'B' && move != 'D' && move != 'E');

        if (this.tabuleiro.validacaoDeMovimento(p, move)) {
            int linhaAntiga = p.getLinha();
            int colunaAntiga = p.getColuna();
            
            p.mover(move);
            
            tabuleiro.atualizaGrade(p, linhaAntiga, colunaAntiga);;
        }
        else
            System.out.println("Movimento inválido!!");
    }

    protected void atacar(Personagens p1, Personagens p2) {
        if(Tabuleiro.validaAlcance(p1, p2)) {
            System.out.println();
            System.out.println(p1.getNome() + " ataca " + p2.getNome());
            System.out.println();
            p2.calculoDeDano(p1.getForcaAtaque());
        }
    }
}