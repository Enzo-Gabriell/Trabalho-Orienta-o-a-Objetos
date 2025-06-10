package com.example.app;

public final class Tabuleiro {
    protected int linhas;
    protected int colunas;
    protected Personagens[][] grade; // para salvar a posição dos personagens

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        
        this.grade = new Personagens[linhas][colunas];
    }

    public int getLinhas() {
        return this.linhas;
    }

    public void imprimeTabuleiro() {
        System.out.println("\n======= TABULEIRO ATUAL =======");
        
        for(int i=0; i<this.colunas; i++)
            System.out.print("  " + i);
        
        for(int i=0; i<this.linhas; i++) 
        {
            System.out.println();
            System.out.print(i);
            for(int j=0; j<this.colunas; j++)
                if(grade[i][j] != null)
                    System.out.print(" " + grade[i][j].getSimbolo() + " ");
                else
                    System.out.print(" + ");
        }
        System.out.println();
    }

    public void imprimeSituacao(Personagens p1, Personagens p2) {
        System.out.println();
        System.out.println("----" + p1.nome + "----");
        System.out.println("Vida: " + p1.pontosDeVida);
        System.out.println("Dano de ataque: " + p1.forcaAtaque);
        System.out.println("Escudo: " + p1.forcaDefesa);
        System.out.println();
        System.out.println("----" + p2.nome + "----");
        System.out.println("Vida: " + p2.pontosDeVida);
        System.out.println("Dano de ataque: " + p2.forcaAtaque);
        System.out.println("Escudo: " + p2.forcaDefesa);
        System.out.println();
    }

    public boolean validacaoDeMovimento(Personagens p, char move) { // falta cuidar para p1 e p2 não ficarem "juntos" em uma casa    
        int proximaLinha = p.getLinha();
        int proximaColuna = p.getColuna();

        switch (move) {
        case 'C' -> proximaLinha--; // linhas são imprimidas
        case 'B' -> proximaLinha++; // ao contrário
        case 'D' -> proximaColuna++;
        case 'E' -> proximaColuna--;
        }
        
        if(proximaColuna > 9 || proximaColuna < 0 || proximaLinha > 9 || proximaLinha < 0)    
            return false;
        
        if(grade[proximaLinha][proximaColuna] != null)
            return false;

        return true;
    }

    public void atualizaGrade(Personagens p, int linhaAntiga, int colunaAntiga) {
        this.grade[linhaAntiga][colunaAntiga] = null;
        this.grade[p.linha][p.coluna] = p;
    }

    public static boolean validaAlcance(Personagens p1, Personagens p2) {
        int max = Math.abs(p1.linha - p2.linha);
        if(max < Math.abs(p1.coluna - p2.coluna))
            max = Math.abs(p1.coluna - p2.coluna);

        return p1.alcanceAtaque >= max;
    }
}
