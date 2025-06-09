package com.example.app;

import javax.swing.JOptionPane;

public abstract class Personagens {
    String nome;
    int pontosDeVida;
    int forcaAtaque;
    int alcanceAtaque;
    int defesaBase;
    int forcaDefesa;
    int linha;
    int coluna;
    char simbolo;

    public Personagens(int linha, int coluna) {
        this.linha = linha; 
        this.coluna = coluna;

        nome = JOptionPane.showInputDialog("Digite o nome do personagem: ");
        pontosDeVida = 100;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
    
    public char getSimbolo() {
        return simbolo;
    }

    public int atacar() {
        return forcaAtaque;
        
    }

    public void defender() {
        forcaDefesa = defesaBase;
    }
    
    public void calculoDeDano(int ataque) {
        if( forcaDefesa == 0 )
            pontosDeVida -= ataque;
        else if( forcaDefesa > ataque)
                forcaDefesa -= ataque;
            else {
                pontosDeVida += (forcaDefesa-ataque);
                forcaDefesa = 0;
            }
    }

    public abstract void specialPower(Personagens alvo);
}
