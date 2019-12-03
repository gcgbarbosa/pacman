/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import javax.swing.JOptionPane;

/**
 *
 * @author Ohack
 */
public class Status {
    Labirinto labirinto;
    Fantasma[] fantasma;
    PacMan pacman;
    public Status(Labirinto labirinto, Fantasma[] fantasma, PacMan pacman) {
        this.labirinto = labirinto;
        this.fantasma = fantasma;
        this.pacman = pacman;
    }
    
    public boolean ganhou(){
        
        int count=0;
        for(int x=0; x<28;x++)
            for(int y=0; y<31; y++){
                if(labirinto.labirinto[y][x] == 1 || labirinto.labirinto[y][x] == 2)
                    count++;
            }
        if(count<=0)
            return true;
        return false;
    }
    public void pacManMorreu(){
        labirinto.labirinto[pacman.getPacX()][pacman.getPacY()] = 4;
        labirinto.labirinto[20][16] = 3;
        
        int atualPos = labirinto.labirinto[fantasma[0].getFantX()][fantasma[0].getFantY()];
        if(atualPos == 6)
            labirinto.labirinto[fantasma[0].getFantX()][fantasma[0].getFantY()] = 1;
        else if(atualPos == 7)
            labirinto.labirinto[fantasma[0].getFantX()][fantasma[0].getFantY()] = 2;
        else
            labirinto.labirinto[fantasma[0].getFantX()][fantasma[0].getFantY()] = 4;
        labirinto.labirinto[11][13]=5;
        
        atualPos = labirinto.labirinto[fantasma[1].getFantX()][fantasma[1].getFantY()];
        if(atualPos == 9)
            labirinto.labirinto[fantasma[1].getFantX()][fantasma[1].getFantY()] = 1;
        else if(atualPos == 10)
            labirinto.labirinto[fantasma[1].getFantX()][fantasma[1].getFantY()] = 2;
        else
            labirinto.labirinto[fantasma[1].getFantX()][fantasma[1].getFantY()] = 4;
        labirinto.labirinto[13][13]=8;
        
        atualPos = labirinto.labirinto[fantasma[2].getFantX()][fantasma[2].getFantY()];
        if(atualPos == 12)
            labirinto.labirinto[fantasma[2].getFantX()][fantasma[2].getFantY()] = 1;
        else if(atualPos == 13)
            labirinto.labirinto[fantasma[2].getFantX()][fantasma[2].getFantY()] = 2;
        else
            labirinto.labirinto[fantasma[2].getFantX()][fantasma[2].getFantY()] = 4;
        labirinto.labirinto[13][14]=11;
        
        atualPos = labirinto.labirinto[fantasma[3].getFantX()][fantasma[3].getFantY()];
        if(atualPos == 15)
            labirinto.labirinto[fantasma[3].getFantX()][fantasma[3].getFantY()] = 1;
        else if(atualPos == 16)
            labirinto.labirinto[fantasma[3].getFantX()][fantasma[3].getFantY()] = 2;
        else
            labirinto.labirinto[fantasma[3].getFantX()][fantasma[3].getFantY()] = 4;
        labirinto.labirinto[15][15]=14;
        
        pacman.setPacX(20); pacman.setPacY(16);
        fantasma[0].setFantX(11); fantasma[0].setFantY(13);
        fantasma[1].setFantX(13); fantasma[1].setFantY(13);
        fantasma[2].setFantX(13); fantasma[2].setFantY(14);
        fantasma[3].setFantX(15); fantasma[3].setFantY(15);
        
        fantasma[0].setVivo(true); fantasma[0].setDoido(false);
        fantasma[1].setVivo(true); fantasma[1].setDoido(false);
        fantasma[2].setVivo(true); fantasma[2].setDoido(false);
        fantasma[3].setVivo(true); fantasma[3].setDoido(false);
    }
    
    public void gameOver(boolean var){
        if(var)
            JOptionPane.showMessageDialog(null, "Fim de Jogo!");
        int x;
        int y;
        for(x=0; x<28;x++)
            for(y=0; y<31; y++){
                labirinto.labirinto[y][x] = labirinto.labirintoOrg[y][x];
            }
        
        pacman.setPacX(20); pacman.setPacY(16);
        fantasma[0].setFantX(11); fantasma[0].setFantY(13);
        fantasma[1].setFantX(13); fantasma[1].setFantY(13);
        fantasma[2].setFantX(13); fantasma[2].setFantY(14);
        fantasma[3].setFantX(15); fantasma[3].setFantY(15);
        
        fantasma[0].setVivo(true); fantasma[0].setDoido(false);
        fantasma[1].setVivo(true); fantasma[1].setDoido(false);
        fantasma[2].setVivo(true); fantasma[2].setDoido(false);
        fantasma[3].setVivo(true); fantasma[3].setDoido(false);
    }
}
