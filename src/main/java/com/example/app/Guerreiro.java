package com.example.app;

public class Guerreiro extends Personagens {
    
    public Guerreiro(int linha, int coluna) {
        super(linha, coluna);

        forcaAtaque = 15;
        alcanceAtaque = 1;
        defesaBase = 10;
    }

    @Override
    public void specialPower() {
        if(forcaAtaque == 15)
            forcaAtaque *= 2;
    }
}
