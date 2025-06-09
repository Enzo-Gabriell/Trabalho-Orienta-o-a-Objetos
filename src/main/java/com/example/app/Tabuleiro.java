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

    public static void imprimeTabuleiro() {
        for(int i=0; i<10; i++) 
            System.out.print((char)(i+65) + " ");
        for(int i=0; i<10; i++)
            System.out.println(i);
    }

    public boolean validacaoDeMovimento(Personagens p, char move) { // falta cuidar para p1 e p2 não ficarem "juntos" em uma casa    
        if(move == 'C') // mudar para switch?
            return p.linha < 9;
        if(move == 'B')
            return p.linha > 0;
        if(move == 'D')
            return p.coluna < 9;
        if(move == 'E')
            return p.coluna > 0;
        return false;
    }

    public static boolean validaAlcance(Personagens p1, Personagens p2) {
        int max = Math.abs(p1.linha - p2.linha);
        if(max < Math.abs(p1.coluna - p2.coluna));
            max = Math.abs(p1.coluna - p2.coluna);

        return p1.alcanceAtaque >= max;
    }
}
