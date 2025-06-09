package com.example.app;

public class Guerreiro extends Personagens {
    
    public Guerreiro(int linha, int coluna, boolean p1) {
        super(linha, coluna);

        forcaAtaque = 15;
        alcanceAtaque = 1;
        defesaBase = 10;
        if(p1)
            simbolo = 'G';
        else
            simbolo = 'g';
    }

    @Override
    protected void specialPower(Personagens alvo) {
        System.out.println(nome + " ativa Carga Brutal");
        if(forcaAtaque == 15)
            forcaAtaque *= 2;
    }
}
