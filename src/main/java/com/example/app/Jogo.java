package com.example.app;

import java.util.Scanner;

public class Jogo {
    private static boolean rendicao = true;
    protected Tabuleiro tabuleiro;
    protected Personagens player1;
    protected Personagens player2;
    static Scanner sc = new Scanner(System.in);

    private char selecionaPersonagem() {
        char tipoPersonagem;
        System.out.print("Escolha o tipo de personagem, Mago(M), Guerreiro(G) e Arqueiro(A): ");
        do {
            tipoPersonagem = sc.next().charAt(0);
            sc.nextLine();

            if (tipoPersonagem != 'M' && tipoPersonagem != 'm' && tipoPersonagem != 'G' && tipoPersonagem != 'g'
                    && tipoPersonagem != 'A' && tipoPersonagem != 'a')
                System.out.print("Opção inválida, tente novamente: ");
        } while (tipoPersonagem != 'M' && tipoPersonagem != 'm' && tipoPersonagem != 'G' && tipoPersonagem != 'g'
                && tipoPersonagem != 'A' && tipoPersonagem != 'a');
        return tipoPersonagem;
    }

    private void acao(Personagens p1, Personagens p2) {
        int acao;
        System.out.println("Turno de " + p1.getNome() + ":");
        do {
            System.out.print("Atacar(1) Defender(2) Andar(3) Especial(4) Render(5): ");
            acao = Integer.parseInt(sc.nextLine());
        } while (acao != 1 && acao != 2 && acao != 3 && acao != 4 && acao != 5);
        switch (acao) {
            case 1 -> atacar(p1, p2);
            case 2 -> p1.defender();
            case 3 -> andar(p1);
            case 4 -> p1.specialPower(p2);
            case 5 -> setRender(false);
        }
    }

    private void setRender(boolean parametro) {
        rendicao = parametro;
    }

    public Jogo() {
        this.tabuleiro = new Tabuleiro(10, 10);

        char tipoPersonagem;
        tipoPersonagem = selecionaPersonagem();
        this.player1 = inicializaPlayer(tipoPersonagem, true);

        tipoPersonagem = selecionaPersonagem();
        this.player2 = inicializaPlayer(tipoPersonagem, false);
    }

    public static void main(String[] args) {
        Jogo game = new Jogo();
        int turnos = 1;

        while (rendicao && turnos <= 50) {
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

    protected Personagens inicializaPlayer(char personagem, boolean p1) {
        Personagens player;
        int linha, coluna;

        do {
            linha = gera();
            coluna = gera();
        } while (tabuleiro.grade[linha][coluna] != null);

        switch (personagem) {
            case 'M' -> player = new Mago(linha, coluna, p1);
            case 'm' -> player = new Mago(linha, coluna, p1);
            case 'G' -> player = new Guerreiro(linha, coluna, p1);
            case 'g' -> player = new Guerreiro(linha, coluna, p1);
            case 'A' -> player = new Arqueiro(linha, coluna, p1);
            case 'a' -> player = new Arqueiro(linha, coluna, p1);
            default -> player = null;
        }
        this.tabuleiro.grade[linha][coluna] = player;

        return player;

    }

    protected int gera() { // gera um número aleatório de 0 a 10 para posições dos personagens
        int num = (int) (Math.random() * tabuleiro.getLinhas());

        return num;
    }

    protected void andar(Personagens p) {
        char move;

        do {
            System.out.print("Escollha a direção: cima(C) baixo(B) direita(D) esquerda(E): ");
            move = sc.nextLine().charAt(0);
            System.out.println();

            if (move != 'C' && move != 'c' && move != 'B' && move != 'b' && move != 'D' && move != 'd' && move != 'E'
                    && move != 'e')
                System.out.print("Opção inválida, tente novamente: ");

        } while (move != 'C' && move != 'c' && move != 'B' && move != 'b' && move != 'D' && move != 'd' && move != 'E'
                && move != 'e');

        if (this.tabuleiro.validacaoDeMovimento(p, move)) {
            int linhaAntiga = p.getLinha();
            int colunaAntiga = p.getColuna();

            p.mover(move);

            tabuleiro.atualizaGrade(p, linhaAntiga, colunaAntiga);
            ;
        } else
            System.out.println("Movimento inválido!!");
        System.out.println();
    }

    protected void atacar(Personagens p1, Personagens p2) {
        if (Tabuleiro.validaAlcance(p1, p2)) {
            System.out.println();
            System.out.println(p1.getNome() + " ataca " + p2.getNome());
            System.out.println();
            p2.calculoDeDano(p1.getForcaAtaque());
            System.out.println();
        }
    }
}