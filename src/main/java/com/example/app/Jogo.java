package com.example.app;

public class Jogo {
    // Personagens p1 = new Mago(4, 0);
    // Personagens p2 = new Mago(4, 9);
    Tabuleiro tabuleiro;

    public Jogo () {
        this.tabuleiro = new Tabuleiro(10, 10);
    }

    public void andar(Personagens p, char move) {
        if (tabuleiro.validacaoDeMovimento(p, move)) {
            switch (move) {
                case 'C' -> p.linha++;
                case 'B' -> p.linha--;
                case 'D' -> p.coluna++;
                default -> p.coluna--;
            }
        }
    }
}
