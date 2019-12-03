/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

//import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class Temporizador2 extends Thread{
       private int tempo;
       private Tela t;
       private Status status;
       private Score score;
       private int vidas;
       private Temporizador t2;
       public Temporizador2(int tempo, Tela t, Status status,Score score, int vidas, Temporizador t2){
          this.tempo = tempo;
          this.t = t;
          this.status = status;
          this.score = score;
          this.vidas = vidas;
          this.t2 = t2;
       }

    @Override
       public void run(){
              boolean ativo = true;
              while (ativo){
                    if(score.getPacVidas() < vidas){
                        status.pacManMorreu();
                        vidas = score.getPacVidas();
                        t2.setTempo(1000);
                    }
                    if(score.getPacVidas()<0){
                        status.gameOver(true);
                        score.setScore(0);
                        score.setPacVidas(3);
                        t2.setTempo(5000);
                        vidas = 3;
                    }
                    if(status.ganhou()){
                        status.gameOver(false);
                        t2.stop();
                        JOptionPane.showMessageDialog(null, "Você Ganhou!");
                        t2.start();
                    }
//                    t.repaint();
                    try {
                        Thread.sleep(tempo); //2.1.1.3.3
                    }
                    catch (InterruptedException exception) {
                          System.err.println(exception.toString());
                    }
              }
    }
              //JOptionPane.showMessageDialog(null,"Fim do jogo");
              //System.exit(0);
       }


