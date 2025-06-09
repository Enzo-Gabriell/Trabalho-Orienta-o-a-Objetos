package com.example.app;

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
        System.out.print("Digite o nome do personagem: ");
        this.nome = Jogo.sc.nextLine();
        this.pontosDeVida = 100;
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
        if(pontosDeVida < 0)
            pontosDeVida = 0;
    }

    public void mover(char direcao) {
        switch (direcao) {
            case 'C' -> coluna++;
            case 'B' -> coluna--;
            case 'D' -> linha++;
            case 'E' -> linha--;
        }
    }

    public abstract void specialPower(Personagens alvo);
}
