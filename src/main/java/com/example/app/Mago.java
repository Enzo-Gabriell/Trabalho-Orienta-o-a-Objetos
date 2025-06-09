package com.example.app;

public class Mago extends Personagens {
   
    public Mago(int linha, int coluna, boolean p1) {
        super(linha, coluna);

        forcaAtaque = 10;
        alcanceAtaque = 3;
        defesaBase = 7;
        if(p1)
            simbolo = 'M';
        else
            simbolo = 'm';        
}

    @Override
    public void specialPower(Personagens alvo) {
        System.out.println(nome + " ativa Trocar vida");
        int aux = pontosDeVida;
        pontosDeVida = alvo.pontosDeVida;
        alvo.pontosDeVida = aux;
    }
}
