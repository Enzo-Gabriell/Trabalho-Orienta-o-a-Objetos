package com.example.app;

public class Arqueiro extends Personagens {
    
    public Arqueiro(int linha, int coluna, boolean p1) {
        super(linha, coluna, 10, 5, 5, p1 ? 'A' : 'a');
    }

    @Override
    protected void specialPower(Personagens alvo) {
        System.out.println(getNome() + " ativa Flecha Precisa");
        setAlcanceAtaque(getAlcanceAtaque() + 1);
    }
}
