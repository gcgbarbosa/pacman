/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

//import javax.swing.JOptionPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Temporizador3 extends Thread{
       private int tempo;
       private Tela t;

       private Fantasma[] fantasma;
       private PacMan pacman;
       private Labirinto labirinto;
       public int tempoDoido = 0;
       private int count=0;

       public Temporizador3(int tempo, Tela t, Fantasma[] fantasma, PacMan pacman, Labirinto labirinto){
          this.tempo = tempo;
          this.t = t;
          this.fantasma = fantasma;
          this.pacman = pacman;
          this.labirinto = labirinto;
       }

    @Override
       public void run(){
                boolean tocar = false;
              boolean ativo = true;
              while (ativo){
                    if(tempo == 5000 || tempo == 1000){
                        if(count >=1){
                            tempo = 1600;
                            count=0;
                        }
                        count++;
                    }

                    if(pacman.isComeuVitamina()){

                    }
                    
                    if(tempoDoido!=0)
                        tempoDoido --;

                    if(tempoDoido ==1){
     
                    }
                    if(tocar)
                    try {
                        Audio.tocar(new FileInputStream("src/mp3/siren.wav"), false);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Temporizador3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tocar = true;
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


