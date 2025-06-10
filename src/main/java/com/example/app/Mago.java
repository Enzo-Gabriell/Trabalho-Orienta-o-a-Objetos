package com.example.app;

public class Mago extends Personagens {

    public Mago(int linha, int coluna, boolean isPlayer1, String nome) {
        super(linha, coluna, 10, 3, 7, isPlayer1, 'M', nome);
    }

    @Override
    protected void specialPower(Personagens alvo) {
        if (!isSpecialAtivo()) {
            System.out.println(getNome() + " ativa Trocar vida");
            int aux = getPontosDeVida();
            setPontosDeVida(alvo.getPontosDeVida());
            alvo.setPontosDeVida(aux);
            setSpecialAtivo(true);
        } else
            System.out.println(getNome() + " já ativou Trocar vida nessa partida");
    }
}
