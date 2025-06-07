package com.example.app;

public class Mago extends Personagens {
   
    public Mago(int linha, int coluna) {
        super(linha, coluna);

        forcaAtaque = 10;
        alcanceAtaque = 3;
        defesaBase = 7;
    }

    public int specialPower(int vidaOponente) {
        int aux = pontosDeVida;
        pontosDeVida = vidaOponente;
        return aux;
    }

    @Override
    public void specialPower() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
