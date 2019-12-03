/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

//import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Temporizador extends Thread{
       private int tempo;
       private Tela t;

       private Fantasma[] fantasma;
       private PacMan pacman;
       private Labirinto labirinto;
       public int tempoDoido = 0;
       private int count=0;

       public Temporizador(int tempo, Tela t, Fantasma[] fantasma, PacMan pacman, Labirinto labirinto){
          this.tempo = tempo;
          this.t = t;
          this.fantasma = fantasma;
          this.pacman = pacman;
          this.labirinto = labirinto;
       }

    @Override
       public void run(){
              boolean ativo = true;
              while (ativo){
                    if(tempo == 5000 || tempo == 1000){
                        if(count >=1){
                            tempo = 300;
                            count=0;
                        }
                        count++;
                    }
                    try {
                        pacman.Movimenta();
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedAudioFileException ex) {
                        Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //mover.Movimenta();
                    if(pacman.isComeuVitamina()){
                        tempoDoido=50;
                        fantasma[0].setDoido(true);
                        fantasma[1].setDoido(true);
                        fantasma[2].setDoido(true);
                        fantasma[3].setDoido(true);
                    }
                    
                    if(tempoDoido!=0)
                        tempoDoido--;
                    if(tempoDoido ==1){
                        fantasma[0].setDoido(false);
                        fantasma[1].setDoido(false);
                        fantasma[2].setDoido(false);
                        fantasma[3].setDoido(false);
                    }
//            try {
//                Audio.tocar(new FileInputStream("src/mp3/siren.wav"), false);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
//            }
                    fantasma[0].direcao(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[0].seguir(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[1].direcao(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[1].seguir(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[2].direcao(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[2].seguir(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[3].direcao(pacman.getPacX(), pacman.getPacY(), labirinto);
                    fantasma[3].seguir(pacman.getPacX(), pacman.getPacY(), labirinto);
                    
                    t.repaint();
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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
       }


