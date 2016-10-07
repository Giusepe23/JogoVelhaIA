package jogovelha;

import javax.swing.JOptionPane;

/**
 *
 * @author Giusepe Chagas < giusepe@outlook.com >
 */
public class JogoVelhaConfig {

    public JogoVelhaConfig() {

        this.zerarTabuleiro();

        this.setSimboloXJogador(
                (JOptionPane.showOptionDialog(null, "Você quer escolher o \"X\"?\n(Se recusar irá automaticamente ficará com \"O\")", "Escolha do símbolo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0)
                ? true : false);

        this.setInicioJogador(
                (JOptionPane.showOptionDialog(null, "Você quer iniciar jogando?", "Quem inicia jogando?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == 0)
                ? true : false);

    }

    public void zerarTabuleiro() {
        int tabuleiro[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        setTabuleiro(tabuleiro);
    }

    public int verificaVitoria() {
        int contagemX = 0, contagemO = 0;
        //Verificador de colunas
        int contador = 0;
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {

                if (tabuleiro[linha][coluna] == this.VALOR_X) {
                    contagemX++;
                } else if (tabuleiro[linha][coluna] == this.VALOR_O) {
                    contagemO++;
                }
                if (tabuleiro[linha][coluna] != this.VALOR_VAZIO) {
                    contador++;
                }
            }

            if (contagemX == 3) {
                return this.VITORIA_X;
            } else if (contagemO == 3) {
                return this.VITORIA_O;
            }
            if (contador == 9) {
                return this.EMPATE;
            }
            contagemO = 0;
            contagemX = 0;
        }

        //Verificador de colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            for (int linha = 0; linha < 3; linha++) {
                if (tabuleiro[linha][coluna] == this.VALOR_X) {
                    contagemX++;
                } else if (tabuleiro[linha][coluna] == this.VALOR_O) {
                    contagemO++;
                }
            }

            if (contagemX == 3) {
                return this.VITORIA_X;
            } else if (contagemO == 3) {
                return this.VITORIA_O;
            }
            contagemO = 0;
            contagemX = 0;
        }

        //Verificação da diagonal primária
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][linha] == this.VALOR_X) {
                contagemX++;
            } else if (tabuleiro[linha][linha] == this.VALOR_O) {
                contagemO++;
            }
        }

        if (contagemX == 3) {
            return this.VITORIA_X;
        } else if (contagemO == 3) {
            return this.VITORIA_O;
        }
        contagemO = 0;
        contagemX = 0;

        //Verificação da diagonal secundária
        if (tabuleiro[2][0] == this.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[2][0] == this.VALOR_O) {
            contagemO++;
        }

        if (tabuleiro[1][1] == this.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[1][1] == this.VALOR_O) {
            contagemO++;
        }

        if (tabuleiro[0][2] == this.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[0][2] == this.VALOR_O) {
            contagemO++;
        }

        if (contagemX == 3) {
            return this.VITORIA_X;
        } else if (contagemO == 3) {
            return this.VITORIA_O;
        } else {
            return this.NAO_VITORIA;
        }
    }

    //Se true o humano inicia o jogo
    private boolean inicioJogador;
    //Se true o humano inicia o jogo com X
    private boolean simboloXJogador;
    //Se true o modo de jogo é Computador vs computador
    private boolean computadorXComputador;

    //CONSTANTES
    public final int VALOR_VAZIO = 0;
    public final int VALOR_X = 1;
    public final int VALOR_O = 2;
    public final int NAO_VITORIA = 0;
    public final int VITORIA_X = 1;
    public final int VITORIA_O = 2;
    public final int EMPATE = 3;

    /*
        Se o campo for 0 está vazio,
        Se for 1 o campo está com X,
        Se for 2 o campo está com O,
     */
    private int[][] tabuleiro = new int[3][3];

    public boolean isInicioJogador() {
        return inicioJogador;
    }

    public void setInicioJogador(boolean inicioJogador) {
        this.inicioJogador = inicioJogador;
    }

    public boolean isSimboloXJogador() {
        return simboloXJogador;
    }

    public void setSimboloXJogador(boolean simboloXJogador) {
        this.simboloXJogador = simboloXJogador;
    }

    public boolean isComputadorXComputador() {
        return computadorXComputador;
    }

    public void setComputadorXComputador(boolean computadorXComputador) {
        this.computadorXComputador = computadorXComputador;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(int linha, int coluna, int valor) {
        this.tabuleiro[linha][coluna] = valor;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
}
