package com.example.app;

public abstract class Personagens {
    protected String nome;
    protected int pontosDeVida;
    protected int forcaAtaque;
    protected int alcanceAtaque;
    protected int defesaBase;
    protected int forcaDefesa;
    protected int linha;
    protected int coluna;
    protected char simbolo;

    public Personagens(int linha, int coluna) {
        this.linha = linha; 
        this.coluna = coluna;
        System.out.print("Digite o nome do personagem: ");
        this.nome = Jogo.sc.nextLine();
        this.pontosDeVida = 100;
    }

    protected int getLinha() {
        return linha;
    }

    protected int getColuna() {
        return coluna;
    }
    
    protected char getSimbolo() {
        return simbolo;
    }

    protected int atacar() {
        return forcaAtaque; 
    }

    protected void defender() {
        System.out.println(nome + " restaura força de defesa para " + defesaBase);
        forcaDefesa = defesaBase;
    }
    
    protected void calculoDeDano(int ataque) {
        if( forcaDefesa == 0 ) {
            System.out.println(nome + " recebe " + ataque + " de dano!");
            pontosDeVida -= ataque;
        }
        else if( forcaDefesa > ataque) {
            System.out.println(nome + " perde " + (forcaDefesa-ataque) + " de defesa!");
            forcaDefesa -= ataque;
        }
        else {
            System.out.println(nome + " recebe " + (ataque-forcaDefesa) + " de dano!");
            pontosDeVida += (forcaDefesa-ataque);
            forcaDefesa = 0;
        }

        if(pontosDeVida < 0)
            pontosDeVida = 0;
        System.out.println();
    }

    protected void mover(char direcao) {
        switch (direcao) {
            case 'C' -> linha--; // trocados pois tabuleiro é
            case 'B' -> linha++; // impresso invertido
            case 'D' -> coluna++;
            case 'E' -> coluna--;
        }
    }

    protected abstract void specialPower(Personagens alvo);
}
