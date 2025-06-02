package com.example.app;

public class Arqueiro extends Personagens {
    
    public Arqueiro(int linha, int coluna) {
        super(linha, coluna);

        forcaAtaque = 10;
        alcanceAtaque = 5;
        forcaDefesa = 5;
    }

    @Override
    public void defender() {
        forcaDefesa = 5;
    }
}
