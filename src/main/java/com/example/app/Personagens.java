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
        System.out.println(nome + " restaura força de defesa para " + defesaBase);
        forcaDefesa = defesaBase;
    }
    
    public void calculoDeDano(int ataque) {
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

    public void mover(char direcao) {
        switch (direcao) {
            case 'C' -> linha--; // trocados pois tabuleiro é
            case 'B' -> linha++; // impresso invertido
            case 'D' -> coluna++;
            case 'E' -> coluna--;
        }
    }

    public abstract void specialPower(Personagens alvo);
}
