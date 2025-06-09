package com.example.app;

public final class Tabuleiro {
    int linhas;
    int colunas;
    Personagens[][] grade; // para salvar a posição dos personagens

    public Tabuleiro(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        
        this.grade = new Personagens[linhas][colunas];
    }

    public int getLinhas() {
        return this.linhas;
    }

    public void imprimeTabuleiro() {
        System.out.println("\n====== TABULEIRO ATUAL ======");
        for(int i=0; i<this.colunas; i++)
            System.out.print("  " + i);  
        for(int i=0; i<this.linhas; i++) {
            System.out.println();
            System.out.print(i);
            for(int j=0; j<this.colunas; j++)
                if(grade[i][j] != null)
                    System.out.print(" " + grade[i][j].getSimbolo());
                else
                    System.out.print("  ");
        }
        System.out.println();
    }

    public boolean validacaoDeMovimento(Personagens p, char move) { // falta cuidar para p1 e p2 não ficarem "juntos" em uma casa    
        int proximaLinha = p.getLinha();
        int proximaColuna = p.getColuna();

        switch (move) {
        case 'C' -> proximaColuna++;
        case 'B' -> proximaColuna--;
        case 'D' -> proximaLinha++;
        case 'E' -> proximaLinha--;
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
