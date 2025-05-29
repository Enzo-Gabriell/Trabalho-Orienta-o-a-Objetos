package com.example.app;

import javax.swing.JOptionPane;

public abstract class Personagens {
    String nome;
    int pontosDeVida;
    int forcaAtaque;
    int alcanceAtaque;
    int forcaDefesa;
    int linha;
    int coluna;

    public Personagens(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        nome = JOptionPane.showInputDialog("Digite o nome do personagem: ");
        pontosDeVida = 100;
    }

    public abstract void defender();
    public abstract void calculoDeDano(int ataque);
}
