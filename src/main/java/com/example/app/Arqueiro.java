package com.example.app;

public class Arqueiro extends Personagens {
    
    public Arqueiro(int linha, int coluna, boolean p1) {
        super(linha, coluna);

        forcaAtaque = 10;
        alcanceAtaque = 5;
        defesaBase = 5;
        if(p1)
            simbolo = 'A';
        else
            simbolo = 'a';
    }

    @Override
    public void specialPower(Personagens alvo) {
        alcanceAtaque++;
    }
}
