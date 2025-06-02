package com.example.app;

public class Mago extends Personagens {
   
    public Mago(int linha, int coluna) {
        super(linha, coluna);

        forcaAtaque = 10;
        alcanceAtaque = 3;
        forcaDefesa = 7;
    }

    @Override
    public void defender() {
        forcaDefesa = 7;
    }
}
