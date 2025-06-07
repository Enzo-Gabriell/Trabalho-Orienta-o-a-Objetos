package com.example.app;

public class Tabuleiro {

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
        for(int i=0; i<10; i++) 
            System.out.print(Character.toChars(i) + " ");
        for(int i=0; i<10; i++)
            System.out.println(i);
}
