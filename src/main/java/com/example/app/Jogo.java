package com.example.app;

import java.util.Scanner;

public class Jogo {
    Tabuleiro tabuleiro;
    static Personagens player1;
    static Personagens player2;
    static Scanner sc = new Scanner(System.in);

    public Jogo () {
        this.tabuleiro = new Tabuleiro(10, 10);

    }

    public void main(String[] args) {
        System.out.print("Escolha seu personagem: ");
        inicializaPlayer(player1, sc.next().charAt(0), true);
        
    }

    public void inicializaPlayer(Personagens player, char personagem, boolean p1) {
        int linha = gera();
        int coluna = gera();
        switch (personagem) {
            case 'M' -> player = new Mago(linha, coluna, p1);
            case 'G' -> player = new Guerreiro(linha, coluna, p1);
            case 'A' -> player = new Arqueiro(linha, coluna, p1);
        }
        this.tabuleiro.grade[linha][coluna] = player;

    }

    public int gera() { // gera um número aleatório para posições dos personagens
        int num = (int)Math.random() * 9;

        return num;
    }

    public void andar(Personagens p, char move) {
        if (tabuleiro.validacaoDeMovimento(p, move)) {
            tabuleiro.grade[p.linha][p.coluna] = null;
            switch (move) {
                case 'C' -> p.linha++;
                case 'B' -> p.linha--;
                case 'D' -> p.coluna++;
                default -> p.coluna--;
            }
            tabuleiro.grade[p.linha][p.coluna] = p;
        }
    }

    public void atacar(Personagens p1, Personagens p2) {
        if(Tabuleiro.validaAlcance(p1, p2))
            p2.calculoDeDano(p1.atacar());
    }

    public void specialPower(Personagens atacante, Personagens alvo) {
        alvo.calculoDeDano(atacante.atacar());
    }


}
