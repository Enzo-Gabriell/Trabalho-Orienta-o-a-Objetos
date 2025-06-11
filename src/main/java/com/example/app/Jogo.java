package com.example.app;

import java.util.Scanner;

public class Jogo {
    private boolean rendicao;
    protected Tabuleiro tabuleiro;
    protected Personagens player1;
    protected Personagens player2;
    private Bot botControlador;
    static Scanner sc = new Scanner(System.in);

    public Jogo(int modoDeJogo) {
        this.tabuleiro = new Tabuleiro(10, 10);
        this.rendicao = true;

        char tipoPersonagem;
        tipoPersonagem = selecionaPersonagem();
        System.out.print("Digite o nome do personagem: ");
        String nome = sc.nextLine();
        this.player1 = inicializaPlayer(tipoPersonagem, true, nome);

        if(modoDeJogo == 1) {
            tipoPersonagem = selecionaPersonagem();
            System.out.print("Digite o nome do personagem: ");
            nome = sc.nextLine();
            this.player2 = inicializaPlayer(tipoPersonagem, false, nome);
        }
        else {
            botControlador = new Bot();
            String nome_bot = "Mata noob"; 
            int tipo = gera(3) + 1; // gera numero aleatorio de 1 a 3, para selecionar personagem do bot
            if(tipo == 1)
                player2 = inicializaPlayer('M', false, nome_bot);
            else if(tipo == 2)
                player2 = inicializaPlayer('G', false, nome_bot);
            else if(tipo == 3)
                player2 = inicializaPlayer('A', false, nome_bot);
        }
    }

    private void setRender(boolean parametro) {
        rendicao = parametro;
    }

    public boolean getRender() {
        return rendicao;
    }

    public boolean iniciar(boolean pve) {
        int turnos = 1;
        boolean jogarNovamente = false;

        while(getRender() && turnos <= 30) {

            tabuleiro.imprimeTabuleiro(turnos);
            tabuleiro.imprimeSituacao(player1, player2);

            acao(player1, player2, false);

            if(!this.getRender()) {
                jogarNovamente = telaFinal(player2.getNome(), false);
                break;
            }
            if(this.player2.getPontosDeVida() <= 0) {
                jogarNovamente = telaFinal(player1.getNome(), false);
                break;
            }

            acao(player2, player1, pve);

            if(!this.getRender()) {
                jogarNovamente = telaFinal(player1.getNome(), false);
                break;
            }
            if(this.player1.getPontosDeVida() <= 0) {
                jogarNovamente = telaFinal(player2.getNome(), false);
                break;
            }

            turnos++;
        }

        if(turnos == 51)
            telaFinal(null, true);

        return jogarNovamente;
    }
    
    protected static boolean telaFinal(String nome, boolean empate){
            int opcao;
            if(!empate) {
                System.out.println("\u001b[1m O jogador "+ nome + " ganhou!!! \u001b[0m");
                System.out.println();
            }
            else
                System.out.println("\u001b[1m Empate!!! \u001b[0m");

            System.out.println();
            System.out.print("Jogar de novo(1) Sair do Jogo(2): ");
            do {
                try {
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao < 1 || opcao > 2)
                        System.out.print("Opção inválida, digite 1 ou 2: ");
                }
                catch (NumberFormatException e){
                    System.out.print("Entrada inváida! Tente novamente: ");
                    opcao = 0;
                }
            } while (opcao != 1 && opcao != 2);
            return opcao == 1;
     }

    protected static int telaInical(){
        int acao;
        System.out.println("\033[H\033[2J \u001b[1m Duelo de Personagens! \u001b[0m");
        System.out.print("Jogar PvP(1) Jogar PvE(2) Sair do Jogo(3): ");
        do{
            try {
                acao = Integer.parseInt(sc.nextLine());
                if(acao != 1 && acao != 2 && acao != 3)
                    System.out.print("Opção inválida. Tente novamente: ");
            }
            catch (NumberFormatException e) {
                System.out.println("Entrada inálida. Tente novamente: ");
                acao = 0;
            }
            
        }while(acao != 1 && acao != 2 && acao != 3);
        return acao;
    }

    private char selecionaPersonagem() {
        char tipoPersonagem;
        System.out.print("Escolha o tipo de personagem, Mago(M), Guerreiro(G) e Arqueiro(A): ");
        do {
            tipoPersonagem = sc.next().charAt(0);
            sc.nextLine();

            if (tipoPersonagem != 'M' && tipoPersonagem != 'm' && tipoPersonagem != 'G' && tipoPersonagem != 'g' && tipoPersonagem != 'A' && tipoPersonagem != 'a')
                System.out.print("Opção inválida, tente novamente: ");
        } while (tipoPersonagem != 'M' && tipoPersonagem != 'm' && tipoPersonagem != 'G' && tipoPersonagem != 'g' && tipoPersonagem != 'A' && tipoPersonagem != 'a');
        return tipoPersonagem;
    }

    public void acao(Personagens p1, Personagens p2, boolean ehBot) {
        int acao;
        System.out.println("Turno de " + p1.getNome() + ":");
        if(!ehBot) {
            do {
                System.out.print("Atacar(1) Defender(2) Andar(3) Especial(4) Render(5): ");
                try {
                    acao = Integer.parseInt(sc.nextLine());
                    if(acao < 1 || acao > 5)
                        System.out.println("Opção inválida, digite um número entre 1 e 5");
                }
                catch (NumberFormatException e){
                    System.out.println("Entrada inváida! Tente novamente.");
                    acao = 0;
                }
            } while (acao != 1 && acao != 2 && acao != 3 && acao != 4 && acao != 5);
        }
        else
            acao = botControlador.decideAcao(p1, p2);
        switch (acao) {
            case 1 -> atacar(p1, p2);
            case 2 -> p1.defender();
            case 3 -> andar(p1, p2, ehBot);
            case 4 -> p1.specialPower(p2);
            case 5 -> setRender(false);
        }
    }

    protected Personagens inicializaPlayer(char personagem, boolean p1, String nome) {
        Personagens player;
        int linha, coluna;

        do {
            linha = gera(tabuleiro.getLinhas());
            coluna = gera(tabuleiro.getColunas());
        } while (tabuleiro.getPersonagens(linha, coluna) != null); // garante que na linha e coluna sorteadas o tabuleiro esteja vazio

        switch (personagem) {
            case 'M' -> player = new Mago(linha, coluna, p1, nome);
            case 'm' -> player = new Mago(linha, coluna, p1, nome);
            case 'G' -> player = new Guerreiro(linha, coluna, p1, nome);
            case 'g' -> player = new Guerreiro(linha, coluna, p1, nome);
            case 'A' -> player = new Arqueiro(linha, coluna, p1, nome);
            case 'a' -> player = new Arqueiro(linha, coluna, p1, nome);
            default -> player = null;
        }
        this.tabuleiro.adicionaPersonagem(player);

        return player;

    }

    protected int gera(int intervalo) { // gera um número aleatório de 0 a intervalo
        int num = (int) (Math.random() * intervalo);

        return num;
    }

    protected void andar(Personagens p1, Personagens p2, boolean ehBot) {
        char move;

        if(!ehBot) {
            do {
                do {
                    System.out.print("Escollha a direção: cima(C) baixo(B) direita(D) esquerda(E): ");
                    move = sc.nextLine().charAt(0);
                    System.out.println();

                    if (move != 'C' && move != 'c' && move != 'B' && move != 'b' && move != 'D' && move != 'd' && move != 'E' && move != 'e')
                        System.out.print("Opção inválida, tente novamente: ");

                } while (move != 'C' && move != 'c' && move != 'B' && move != 'b' && move != 'D' && move != 'd' && move != 'E' && move != 'e');

                if (!this.tabuleiro.validacaoDeMovimento(p1, move))
                    System.out.println("Movimento inválido!! Tente novamente.");
            } while(!this.tabuleiro.validacaoDeMovimento(p1, move));
        }
        else {
            move = botControlador.direcaoDeMovimento(p1, p2);
            System.out.println(p1.getNome() + " andou");
        }
        
        int linhaAntiga = p1.getLinha();
        int colunaAntiga = p1.getColuna();

        p1.mover(move);

        tabuleiro.atualizaGrade(p1, linhaAntiga, colunaAntiga);

        System.out.println();
    }

    protected void atacar(Personagens p1, Personagens p2) {
        if (Tabuleiro.validaAlcance(p1, p2)) {
            System.out.println();
            System.out.println(p1.getNome() + " ataca " + p2.getNome());
            System.out.println();
            p2.calculoDeDano(p1.getForcaAtaque());
            System.out.println();
        }
        else
            System.out.println("Alvo fora de alcance! " + p1.getNome() + " perdeu o turno.");
    }
}