/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Ohack
 */

//0=esq, 1=dir, 2= cima, 3= baixo
public class PacMan {
    private int pacX=20;
    private int pacY=16;
    private int direcao = -1;
    private int direcaoAnt = -1;
    private Score score;
    private Labirinto labirinto;
    private boolean comeuVitamina = false;
    private Fantasma[] fantasma;

    public PacMan(Score score, Labirinto labirinto, Fantasma[] fantasma) {
        this.score = score;
        this.labirinto = labirinto;
        this.fantasma = fantasma;
    }

    public boolean isComeuVitamina() {
        return comeuVitamina;
    }

    public void setComeuVitamina(boolean comeuVitamina) {
        this.comeuVitamina = comeuVitamina;
    }



    public int getDirecaoAnt() {
        return direcaoAnt;
    }

    public void setDirecaoAnt(int direcaoAnt) {
        this.direcaoAnt = direcaoAnt;
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getPacX() {
        return pacX;
    }

    public void setPacX(int pacX) {
        this.pacX = pacX;
    }

    public int getPacY() {
        return pacY;
    }

    public void setPacY(int pacY) {
        this.pacY = pacY;
    }

    
    public void Movimenta() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
        comeuVitamina = false;
        int proxPos;
        int x = getPacX();
        int y = getPacY();
        
        switch(getDirecao()){
            case 0: //cima
                proxPos = labirinto.labirinto[x-1][y];
                
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && !fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(fantasma[1].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }

                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x-1][y] = 3;

                    setPacX(x-1);
                    setDirecaoAnt(-1);

                }
            break;
            case 1: //baixo
                proxPos = labirinto.labirinto[x+1][y];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x+1][y] = 3;

                    setPacX(x+1);
                    setDirecaoAnt(-1);

                }
                break;
            case 2: //Esquerda
                if(y==0 && x==14){
                    
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][27] = 3;
                    y = 27;
                    setPacY(27);
                    setDirecaoAnt(-1);
                }
                proxPos = labirinto.labirinto[x][y-1];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y-1] = 3;

                    setPacY(y-1);
                    setDirecaoAnt(-1);

                }
                break;
            case 3: //Direita
                if(y==27 && x==14){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][0] = 3;
                    y = 0;
                    setPacY(0);
                    setDirecaoAnt(-1);
                }
                proxPos = labirinto.labirinto[x][y+1];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y+1] = 3;

                    setPacY(y+1);
                    setDirecaoAnt(-1);

                }
                break;

        }switch(getDirecaoAnt()){
            case 0:
                proxPos = labirinto.labirinto[x-1][y];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x-1][y] = 3;
                    setPacX(x-1);
                }
            break;
            case 1:
                proxPos = labirinto.labirinto[x+1][y];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else  if(!fantasma[2].isDoido() && fantasma[2].isVivo()){
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x+1][y] = 3;
                    setPacX(x+1);
                }
                break;
            case 2:
                if(x==14 && y==0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][27] = 3;
                    y = 27;
                    setPacY(27);
                }
                proxPos = labirinto.labirinto[x][y-1];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y-1] = 3;
                    setPacY(y-1);
                }
                break;
            case 3:
                if(x==14 && y==27){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][0] = 3;
                    y = 0;
                    setPacY(0);
                    setPacY(y-1);
                }
                proxPos = labirinto.labirinto[x][y+1];
                if(proxPos != 0){
                    switch(proxPos){
                        case 1:
                            score.setScore(score.getScore()+10);
                            Audio.tocar(new FileInputStream("src/mp3/eating.wav"), false);
                            break;
                        case 2:
                            comeuVitamina = true;
                            break;
                        case 5:
                        case 6:
                        case 7:
                            if(fantasma[0].isDoido()){
                                fantasma[0].setVivo(false);
                                fantasma[0].setDoido(false);
                            } else if(!fantasma[0].isDoido() && fantasma[0].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 8:
                        case 9:
                        case 10:
                            if(fantasma[1].isDoido()){
                                fantasma[1].setVivo(false);
                                fantasma[1].setDoido(false);
                            } else if(!fantasma[1].isDoido() && fantasma[1].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 11:
                        case 12:
                        case 13:
                            if(fantasma[2].isDoido()){
                                fantasma[2].setVivo(false);
                                fantasma[2].setDoido(false);
                            } else if(!fantasma[2].isDoido() && fantasma[2].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                        case 14:
                        case 15:
                        case 16:
                            if(fantasma[3].isDoido()){
                                fantasma[3].setVivo(false);
                                fantasma[3].setDoido(false);
                            } else if(!fantasma[3].isDoido() && fantasma[3].isVivo()) {
                                if(score.getPacVidas()>0)
                                    score.setPacVidas(score.getPacVidas()-1);
                            }
                                
                            break;
                    }
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y+1] = 3;
                    setPacY(y+1);
                }
                break;

        }
    }

    
    
}
