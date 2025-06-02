package com.example.app;

public class Guerreiro extends Personagens {
    
    public Guerreiro(int linha, int coluna) {
        super(linha, coluna);

        forcaAtaque = 15;
        alcanceAtaque = 1;
        forcaDefesa = 10;
    }

    @Override
    public void defender() {
        forcaDefesa = 10;
    }
}
