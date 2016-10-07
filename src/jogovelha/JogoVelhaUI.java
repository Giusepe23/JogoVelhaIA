package jogovelha;

import javax.swing.JOptionPane;

/**
 *
 * @author Giusepe Chagas < giusepe@outlook.com>
 */
public class JogoVelhaUI extends javax.swing.JFrame {

    JogoVelhaConfig jogoVelha = new JogoVelhaConfig();
    JogoVelhaIA jogoVelhaIA = new JogoVelhaIA();

    /**
     * Creates new form ContactEditorUI
     */
    public JogoVelhaUI() {
        initComponents();
        if (!jogoVelha.isInicioJogador()) {
            Coordenada valor = jogoVelhaIA.avaliadorCompleto(jogoVelha);
            this.jogar(valor.X, valor.Y);
        }
    }

    //Define a jogada diretamente no tabuleiro
    private void jogar(int linha, int coluna) {
        if (jogoVelha.isSimboloXJogador()) {
            jogoVelha.setTabuleiro(linha, coluna, jogoVelha.VALOR_X);
            Coordenada valor = jogoVelhaIA.avaliadorCompleto(jogoVelha);
            jogarPC(valor.X, valor.Y);
            int vitoria = jogoVelha.verificaVitoria();
            if (vitoria == jogoVelha.VITORIA_O) {
                JOptionPane.showMessageDialog(null, "\"O\" ganhou o jogo", "BOLA", JOptionPane.INFORMATION_MESSAGE);
            } else if (vitoria == jogoVelha.VITORIA_X) {
                JOptionPane.showMessageDialog(null, "\"X\" ganhou o jogo", "BOLA", JOptionPane.INFORMATION_MESSAGE);
            } else if (jogoVelha.EMPATE == vitoria) {
                JOptionPane.showMessageDialog(null, "O jogo terminou empatado", "EMPATE", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            jogoVelha.setTabuleiro(linha, coluna, jogoVelha.VALOR_O);
            Coordenada valor = jogoVelhaIA.avaliadorCompleto(jogoVelha);
            jogarPC(valor.X, valor.Y);
            int vitoria = jogoVelha.verificaVitoria();
            if (vitoria == jogoVelha.VITORIA_O) {
                JOptionPane.showMessageDialog(null, "\"O\" ganhou o jogo", "BOLA", JOptionPane.INFORMATION_MESSAGE);
            } else if (vitoria == jogoVelha.VITORIA_X) {
                JOptionPane.showMessageDialog(null, "\"X\" ganhou o jogo", "BOLA", JOptionPane.INFORMATION_MESSAGE);
            } else if (jogoVelha.EMPATE == vitoria) {
                JOptionPane.showMessageDialog(null, "O jogo empatou", "EMPATE", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private void jogarPC(int linha, int coluna) {
        if (jogoVelha.isSimboloXJogador()) {
            jogoVelha.setTabuleiro(linha, coluna, jogoVelha.VALOR_O);
            switch (linha) {
                case 0: {
                    switch (coluna) {
                        case 0: {
                            botao0x0.setText("O");
                            this.desabilitar(botao0x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao0x1.setText("O");
                            this.desabilitar(botao0x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao0x2.setText("O");
                            this.desabilitar(botao0x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (coluna) {
                        case 0: {
                            botao1x0.setText("O");
                            this.desabilitar(botao1x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao1x1.setText("O");
                            this.desabilitar(botao1x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao1x2.setText("O");
                            this.desabilitar(botao1x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (coluna) {
                        case 0: {
                            botao2x0.setText("O");
                            this.desabilitar(botao2x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao2x1.setText("O");
                            this.desabilitar(botao2x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao2x2.setText("O");
                            this.desabilitar(botao2x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
            }
            //!--Fim do Switch
        } else {
            jogoVelha.setTabuleiro(linha, coluna, jogoVelha.VALOR_X);
            switch (linha) {
                case 0: {
                    switch (coluna) {
                        case 0: {
                            botao0x0.setText("X");
                            this.desabilitar(botao0x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao0x1.setText("X");
                            this.desabilitar(botao0x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao0x2.setText("X");
                            this.desabilitar(botao0x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (coluna) {
                        case 0: {
                            botao1x0.setText("X");
                            this.desabilitar(botao1x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao1x1.setText("X");
                            this.desabilitar(botao1x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao1x2.setText("X");
                            this.desabilitar(botao1x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (coluna) {
                        case 0: {
                            botao2x0.setText("X");
                            this.desabilitar(botao2x0,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 1: {
                            botao2x1.setText("X");
                            this.desabilitar(botao2x1,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                        case 2: {
                            botao2x2.setText("X");
                            this.desabilitar(botao2x2,
                                    !jogoVelha.isSimboloXJogador());
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }

    //Desabilita os botões clicados
    private void desabilitar(javax.swing.JButton botao, boolean simbolo) {
        botao.setEnabled(false);
        if (simbolo) {
            botao.setText("X");
        } else {
            botao.setText("O");
        }
    }

    public void habilitar(javax.swing.JButton botao) {
        botao.setEnabled(true);
        botao.setText("-");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botao0x2 = new javax.swing.JButton();
        botao0x0 = new javax.swing.JButton();
        botao1x1 = new javax.swing.JButton();
        botao0x1 = new javax.swing.JButton();
        botao1x2 = new javax.swing.JButton();
        botao2x1 = new javax.swing.JButton();
        botao1x0 = new javax.swing.JButton();
        botao2x2 = new javax.swing.JButton();
        botao2x0 = new javax.swing.JButton();
        Reiniciar = new javax.swing.JButton();
        ComputadorvsComputador = new javax.swing.JButton();
        HumanovsComputador = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo da Velha");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        botao0x2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao0x2.setText("-");
        botao0x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao0x2ActionPerformed(evt);
            }
        });

        botao0x0.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao0x0.setText("-");
        botao0x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao0x0ActionPerformed(evt);
            }
        });

        botao1x1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao1x1.setText("-");
        botao1x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1x1ActionPerformed(evt);
            }
        });

        botao0x1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao0x1.setText("-");
        botao0x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao0x1ActionPerformed(evt);
            }
        });

        botao1x2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao1x2.setText("-");
        botao1x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1x2ActionPerformed(evt);
            }
        });

        botao2x1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao2x1.setText("-");
        botao2x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2x1ActionPerformed(evt);
            }
        });

        botao1x0.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao1x0.setText("-");
        botao1x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao1x0ActionPerformed(evt);
            }
        });

        botao2x2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao2x2.setText("-");
        botao2x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2x2ActionPerformed(evt);
            }
        });

        botao2x0.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        botao2x0.setText("-");
        botao2x0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao2x0ActionPerformed(evt);
            }
        });

        Reiniciar.setText("Reiniciar");
        Reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReiniciarActionPerformed(evt);
            }
        });

        ComputadorvsComputador.setText("Computador vs Computador");

        HumanovsComputador.setText("Humano vs Computador");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Humano vs Computador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botao0x0, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao1x0, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao2x0, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botao0x1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao2x1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao1x1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(botao0x2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(botao1x2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao2x2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HumanovsComputador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComputadorvsComputador)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao0x2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao0x0, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao0x1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao1x1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao1x2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao1x0, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao2x1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao2x2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao2x0, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ComputadorvsComputador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HumanovsComputador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reiniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(845, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao0x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao0x0ActionPerformed
        this.desabilitar(botao0x0, jogoVelha.isSimboloXJogador());
        this.jogar(0, 0);
    }//GEN-LAST:event_botao0x0ActionPerformed

    private void botao0x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao0x1ActionPerformed
        this.desabilitar(botao0x1, jogoVelha.isSimboloXJogador());
        this.jogar(0, 1);
    }//GEN-LAST:event_botao0x1ActionPerformed

    private void botao0x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao0x2ActionPerformed
        this.desabilitar(botao0x2, jogoVelha.isSimboloXJogador());
        this.jogar(0, 2);
    }//GEN-LAST:event_botao0x2ActionPerformed

    private void botao1x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao1x0ActionPerformed
        this.desabilitar(botao1x0, jogoVelha.isSimboloXJogador());
        this.jogar(1, 0);
    }//GEN-LAST:event_botao1x0ActionPerformed

    private void botao1x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao1x1ActionPerformed
        this.desabilitar(botao1x1, jogoVelha.isSimboloXJogador());
        this.jogar(1, 1);
    }//GEN-LAST:event_botao1x1ActionPerformed

    private void botao1x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao1x2ActionPerformed
        this.desabilitar(botao1x2, jogoVelha.isSimboloXJogador());
        this.jogar(1, 2);
    }//GEN-LAST:event_botao1x2ActionPerformed

    private void botao2x0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao2x0ActionPerformed
        this.desabilitar(botao2x0, jogoVelha.isSimboloXJogador());
        this.jogar(2, 0);
    }//GEN-LAST:event_botao2x0ActionPerformed

    private void botao2x1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao2x1ActionPerformed
        this.desabilitar(botao2x1, jogoVelha.isSimboloXJogador());
        this.jogar(2, 1);
    }//GEN-LAST:event_botao2x1ActionPerformed

    private void botao2x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao2x2ActionPerformed
        this.desabilitar(botao2x2, jogoVelha.isSimboloXJogador());
        this.jogar(2, 2);
    }//GEN-LAST:event_botao2x2ActionPerformed

    private void ReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReiniciarActionPerformed
        int[][] tabuleiro = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        jogoVelha.setTabuleiro(tabuleiro);
        habilitar(botao0x0);
        habilitar(botao0x1);
        habilitar(botao0x2);

        habilitar(botao1x0);
        habilitar(botao1x1);
        habilitar(botao1x2);

        habilitar(botao2x0);
        habilitar(botao2x1);
        habilitar(botao2x2);
    }//GEN-LAST:event_ReiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoVelhaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoVelhaUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ComputadorvsComputador;
    private javax.swing.JButton HumanovsComputador;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton botao0x0;
    private javax.swing.JButton botao0x1;
    private javax.swing.JButton botao0x2;
    private javax.swing.JButton botao1x0;
    private javax.swing.JButton botao1x1;
    private javax.swing.JButton botao1x2;
    private javax.swing.JButton botao2x0;
    private javax.swing.JButton botao2x1;
    private javax.swing.JButton botao2x2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
