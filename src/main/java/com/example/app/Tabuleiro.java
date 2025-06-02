package com.example.app;

public class Tabuleiro {
    int linhas = 10;
    int colunas = 10;

    public boolean validacaoDeMovimento(Personagens p, char move) {
        if(move == 'C')
            if(p.getLinha() < 9)
                return true;
            else
                return false;
        if(move == 'B')
            if(p.getLinha() >= 0)
                return true;
            else
                return false;
        if(move == 'D')
            if(p.getColuna() < 9)
                return true;
            else
                return false;
        if(move == 'E')
            if(p.getColuna() >=  0)
                return true;
            else
                return false;
        return false;
    }

    public void imprimeTabuleiro() {

    }
}
