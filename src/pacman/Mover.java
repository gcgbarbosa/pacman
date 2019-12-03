/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

/**
 *
 * @author Ohack
 */
public class Mover {
    
    PacMan pacman;
    Labirinto labirinto;
    
    public Mover(PacMan pacman, Labirinto labirinto){
        this.pacman = pacman;
        this.labirinto = labirinto;
    }
    
    void Movimenta(){
        int x = pacman.getPacX();
        int y = pacman.getPacY();
        switch(pacman.getDirecao()){
            case 0: //cima
                
                if(labirinto.labirinto[x-1][y] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x-1][y] = 3;
                    pacman.setPacX(x-1);
                    pacman.setDirecaoAnt(-1);
                }
            break; 
            case 1: //baixo
                if(labirinto.labirinto[x+1][y] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x+1][y] = 3;
                    pacman.setPacX(x+1);
                    pacman.setDirecaoAnt(-1);
                }
                break;
            case 2: //Esquerda
                if(labirinto.labirinto[x][y-1] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y-1] = 3;
                    pacman.setPacY(y-1);
                    pacman.setDirecaoAnt(-1);
                }
                break;
            case 3: //Direita
                if(labirinto.labirinto[x][y+1] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y+1] = 3;
                    pacman.setPacY(y+1);
                    pacman.setDirecaoAnt(-1);
                }
                break;

        }switch(pacman.getDirecaoAnt()){
            case 0: 
                if(labirinto.labirinto[x-1][y] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x-1][y] = 3;
                    pacman.setPacX(x-1);
                }
            break;
            case 1:
                if(labirinto.labirinto[x+1][y] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x+1][y] = 3;
                    pacman.setPacX(x+1);
                }
                break;
            case 2:
                if(labirinto.labirinto[x][y-1] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y-1] = 3;
                    pacman.setPacY(y-1);
                }
                break;
            case 3:
                if(labirinto.labirinto[x][y+1] != 0){
                    labirinto.labirinto[x][y] = 4;
                    labirinto.labirinto[x][y+1] = 3;
                    pacman.setPacY(y+1);
                }
                break;

        }
    }

}
