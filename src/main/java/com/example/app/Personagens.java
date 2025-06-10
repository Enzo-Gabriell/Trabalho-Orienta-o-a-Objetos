package com.example.app;

public abstract class Personagens {
    private String nome;
    private int pontosDeVida;
    private int forcaAtaque;
    private int alcanceAtaque;
    private int defesaBase;
    private int forcaDefesa;
    private int linha;
    private int coluna;
    private char simbolo;
    private boolean isPlayer1;
    private boolean specialAtivo;

    public Personagens(int linha, int coluna, int forcaAtaque, int alcanceAtaque, int defesaBase, boolean isPlayer1,
            char simbolo) {
        this.linha = linha;
        this.coluna = coluna;
        System.out.print("Digite o nome do personagem: ");
        this.nome = Jogo.sc.nextLine();
        this.pontosDeVida = 100;
        this.specialAtivo = false;
        this.forcaAtaque = forcaAtaque;
        this.alcanceAtaque = alcanceAtaque;
        this.defesaBase = defesaBase;
        this.forcaDefesa = this.defesaBase;
        this.isPlayer1 = isPlayer1;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public int getForcaAtaque() {
        return forcaAtaque;
    }

    public int getAlcanceAtaque() {
        return alcanceAtaque;
    }

    public int getDefesaBase() {
        return defesaBase;
    }

    public int getForcaDefesa() {
        return forcaDefesa;
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

    public boolean getIsPlayer1() {
        return isPlayer1;
    }

    public boolean isSpecialAtivo() {
        return specialAtivo;
    }

    protected void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida > 100)
            this.pontosDeVida = 100;
        else if (pontosDeVida < 0)
            this.pontosDeVida = 0;
        else
            this.pontosDeVida = pontosDeVida;
    }

    protected void setForcaAtaque(int forcaAtaque) {
        this.forcaAtaque = forcaAtaque;
    }

    protected void setAlcanceAtaque(int alcanceAtaque) {
        this.alcanceAtaque = alcanceAtaque;
    }

    protected void defender() {
        System.out.println(nome + " restaura força de defesa para " + defesaBase);
        forcaDefesa = defesaBase;
    }

    protected void calculoDeDano(int ataque) {
        if (forcaDefesa == 0) {
            System.out.println(nome + " recebe " + ataque + " de dano!");
            pontosDeVida -= ataque;
        } else if (forcaDefesa > ataque) {
            System.out.println(nome + " perde " + (forcaDefesa - ataque) + " de defesa!");
            forcaDefesa -= ataque;
        } else {
            System.out.println(nome + " recebe " + (ataque - forcaDefesa) + " de dano!");
            pontosDeVida += (forcaDefesa - ataque);
            forcaDefesa = 0;
        }

        if (pontosDeVida < 0)
            pontosDeVida = 0;
        System.out.println();
    }

    protected void mover(char direcao) {
        switch (direcao) {
            case 'C' -> linha--; // trocados pois tabuleiro é
            case 'c' -> linha--; // impresso invertido
            case 'B' -> linha++;
            case 'b' -> linha++;
            case 'D' -> coluna++;
            case 'd' -> coluna++;
            case 'E' -> coluna--;
            case 'e' -> coluna--;
        }
    }

    protected abstract void specialPower(Personagens alvo);
}
