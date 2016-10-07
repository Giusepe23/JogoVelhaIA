package jogovelha;

/**
 *
 * @author Giusepe Chagas < giusepe@outlook.com>
 */
public class JogoVelhaIA {

    public Coordenada MiniMax(JogoVelhaConfig jogoVelha, int profundidade, int valor) {
        int[][] tabuleiro = jogoVelha.getTabuleiro();
        int[][] medidas = new int[3][3];

        if (profundidade != -1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == jogoVelha.VALOR_VAZIO) {
                        if (jogoVelha.VALOR_X == valor) {
                            jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_O);
                            MiniMax(jogoVelha, profundidade - 1, jogoVelha.VALOR_O);
                            medidas[i][j] = avaliadorContagem(jogoVelha);
                        } else {
                            jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_X);
                            MiniMax(jogoVelha, profundidade - 1, jogoVelha.VALOR_X);
                            medidas[i][j] = avaliadorContagem(jogoVelha);
                        }
                        jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_VAZIO);
                    } else {
                        medidas[i][j] = -100;
                    }
                }
            }
        }

        if (jogoVelha.VALOR_X == valor) {
            return maiorValor(medidas);
        } else {
            return menorValor(medidas);
        }

    }

    public int avaliadorContagem(JogoVelhaConfig jogoVelha) {
        int tabuleiro[][] = jogoVelha.getTabuleiro();
        int contagemX = 0, contagemO = 0;
        int X[] = {0, 0, 0};
        int O[] = {0, 0, 0};

        //Verificador de colunas
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == jogoVelha.VALOR_X) {
                    contagemX++;
                } else if (tabuleiro[linha][coluna] == jogoVelha.VALOR_O) {
                    contagemO++;
                }
            }

            if (!(contagemX > 0 && contagemO > 0)) {
                if (contagemX > 0) {
                    X[contagemX - 1]++;
                } else if (contagemO > 0) {
                    O[contagemO - 1]++;
                }
            }
            contagemO = 0;
            contagemX = 0;
        }

        //Verificador de colunas
        for (int coluna = 0; coluna < 3; coluna++) {
            for (int linha = 0; linha < 3; linha++) {
                if (tabuleiro[linha][coluna] == jogoVelha.VALOR_X) {
                    contagemX++;
                } else if (tabuleiro[linha][coluna] == jogoVelha.VALOR_O) {
                    contagemO++;
                }
            }

            if (!(contagemX > 0 && contagemO > 0)) {
                if (contagemX > 0) {
                    X[contagemX - 1]++;
                } else if (contagemO > 0) {
                    O[contagemO - 1]++;
                }
            }
            contagemO = 0;
            contagemX = 0;
        }

        //Verificação da diagonal primária
        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][linha] == jogoVelha.VALOR_X) {
                contagemX++;
            } else if (tabuleiro[linha][linha] == jogoVelha.VALOR_O) {
                contagemO++;
            }
        }

        if (!(contagemX > 0 && contagemO > 0)) {
            if (contagemX > 0) {
                X[contagemX - 1]++;
            } else if (contagemO > 0) {
                O[contagemO - 1]++;
            }
        }
        contagemO = 0;
        contagemX = 0;

        //Verificação da diagonal secundária
        if (tabuleiro[2][0] == jogoVelha.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[2][0] == jogoVelha.VALOR_O) {
            contagemO++;
        }

        if (tabuleiro[1][1] == jogoVelha.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[1][1] == jogoVelha.VALOR_O) {
            contagemO++;
        }

        if (tabuleiro[0][2] == jogoVelha.VALOR_X) {
            contagemX++;
        } else if (tabuleiro[0][2] == jogoVelha.VALOR_O) {
            contagemO++;
        }

        if (!(contagemX > 0 && contagemO > 0)) {
            if (contagemX > 0) {
                X[contagemX - 1]++;
            } else if (contagemO > 0) {
                O[contagemO - 1]++;
            }
        }
        contagemO = 0;
        contagemX = 0;

        int valor;
        if (jogoVelha.isSimboloXJogador()) {
            valor = 150 * X[2] - 63 * O[1] + 31 * X[1] - 15 * O[0] + 7 * X[0];
        } else {
            valor = 128 * O[2] - 63 * X[1] + 31 * O[1] - 15 * X[0] + 7 * O[0];
        }

        return valor;
    }

    public Coordenada avaliadorCompleto(JogoVelhaConfig jogoVelha) {
        int matriz[][] = jogoVelha.getTabuleiro();
        int medidas[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == jogoVelha.VALOR_VAZIO) {
                    if (jogoVelha.isSimboloXJogador()) {
                        jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_X);
                    } else {
                        jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_O);
                    }

                    medidas[i][j] = this.avaliadorContagem(jogoVelha);
                    jogoVelha.setTabuleiro(i, j, jogoVelha.VALOR_VAZIO);
                } else {
                    medidas[i][j] = -1000;
                }
            }
        }

        Coordenada valor = this.maiorValor(medidas);
        return valor;
    }

    public Coordenada maiorValor(int[][] matriz) {
        Coordenada valor = new Coordenada();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] > matriz[valor.X][valor.Y]) {
                    valor.X = i;
                    valor.Y = j;
                }
            }
        }
        return valor;
    }

    public Coordenada menorValor(int[][] matriz) {
        Coordenada valor = new Coordenada();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] > matriz[valor.X][valor.Y]) {
                    valor.X = i;
                    valor.Y = j;
                }
            }
        }
        return valor;
    }

}
