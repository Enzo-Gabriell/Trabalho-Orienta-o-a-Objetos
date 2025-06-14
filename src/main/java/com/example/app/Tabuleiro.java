package com.example.app;

public final class Tabuleiro { // valida movimentação e alcance, além de imprimir tabuleiro e atualizações da vida e etc.
    private int linhas;
    private int colunas;
    private Personagens[][] grade; // para salvar a posição dos personagens

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;

        this.grade = new Personagens[linhas][colunas];
    }

    public int getLinhas() {
        return this.linhas;
    }

    public int getColunas() {
        return this.colunas;
    }

    public Personagens getPersonagens(int linha, int coluna) {
        return grade[linha][coluna];
    }

    public void imprimeTabuleiro(int turno) {
        System.out.println("\n========== " + turno + "° Turno ==========");

        for (int i = 0; i < this.colunas; i++)
            System.out.print("  " + i);

        for (int i = 0; i < this.linhas; i++) {
            System.out.println();
            System.out.print(i);
            for (int j = 0; j < this.colunas; j++)
                if (grade[i][j] != null) {
                    if (grade[i][j].getIsPlayer1())
                        System.out.print(" " + "\u001b[34m" + grade[i][j].getSimbolo() + "\u001b[0m" + " ");
                    else
                        System.out.print(" " + "\u001b[31m" + grade[i][j].getSimbolo() + "\u001b[0m" + " ");
                } else
                    System.out.print(" + ");
        }
        System.out.println();
    }
    
    public void imprimeSituacao(Personagens p1, Personagens p2) {
        System.out.println();
        System.out.println("\u001b[34m" + "-------- " + p1.getNome() + " --------");
        System.out.println("Vida:               " + p1.getPontosDeVida());
        System.out.println("Escudo:             " + p1.getForcaDefesa());
        System.out.println("Dano de ataque:     " + p1.getForcaAtaque());
        System.out.println("Alcance de ataque:  " + p1.getAlcanceAtaque() + "\u001b[0m");
        System.out.println("\u001b[31m" + "-------- " + p2.getNome() + " --------");
        System.out.println("Vida:               " + p2.getPontosDeVida());
        System.out.println("Escudo:             " + p2.getForcaDefesa());
        System.out.println("Dano de ataque:     " + p2.getForcaAtaque());
        System.out.println("Alcance de ataque:  " + p2.getAlcanceAtaque() + "\u001b[0m");
        System.out.println();
    }

    public boolean validacaoDeMovimento(Personagens p, int move) {
        int proximaLinha = p.getLinha();
        int proximaColuna = p.getColuna();

        switch (move) {
            case 1 -> proximaLinha--; // linhas são imprimidas ao contrário
            case 2 -> proximaLinha++;
            case 3 -> proximaColuna++;
            case 4 -> proximaColuna--;
        }

        if (proximaColuna > 9 || proximaColuna < 0 || proximaLinha > 9 || proximaLinha < 0)
            return false;

        if (grade[proximaLinha][proximaColuna] != null)
            return false;

        return true;
    }

    protected void adicionaPersonagem(Personagens personagem) {
        grade[personagem.getLinha()][personagem.getColuna()] = personagem;
    }

    protected void atualizaGrade(Personagens p, int linhaAntiga, int colunaAntiga) {
        this.grade[linhaAntiga][colunaAntiga] = null;
        this.grade[p.getLinha()][p.getColuna()] = p;
    }

    public static boolean validaAlcance(Personagens p1, Personagens p2) {
        int max = Math.abs(p1.getLinha() - p2.getLinha());
        if (max < Math.abs(p1.getColuna() - p2.getColuna()))
            max = Math.abs(p1.getColuna() - p2.getColuna());

        return p1.getAlcanceAtaque() >= max;
    }
}
