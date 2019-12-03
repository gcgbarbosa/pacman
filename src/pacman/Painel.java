/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Painel.java
 *
 * Created on 27/07/2011, 16:02:32
 */

package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;



/**
 *
 * @author Agnaldo
 */
public class Painel extends javax.swing.JPanel {
    Labirinto labirinto;
    Score score;
    PacMan pacman;
    Fantasma[] fantasma;
    /** Creates new form Painel */
    public Painel(Labirinto labirinto, Score score, PacMan pacman, Fantasma[] fantasma) {

        initComponents();
        this.labirinto = labirinto;
        this.pacman = pacman;
        this.score = score;
        this.fantasma = fantasma;
    }


    @Override
    public void paintComponent(Graphics g){  
        ImageIcon mapa = new ImageIcon("src/img/mapa.jpg");
        ImageIcon ponto = new ImageIcon("src/img/ponto.png");
        ImageIcon vitamina = new ImageIcon("src/img/vitamina.png");
        
        ImageIcon pacUp = new ImageIcon("src/img/pacman_alto.png");
        ImageIcon pacDown = new ImageIcon("src/img/pacman_baixo.png");
        ImageIcon pacLeft = new ImageIcon("src/img/pacman_esq.png");
        ImageIcon pacRigth = new ImageIcon("src/img/pacman_dir.png");
        
        ImageIcon doido = new ImageIcon("src/img/doido_1.png");
        
        ImageIcon mortoUp = new ImageIcon("src/img/olho_alto.png");
        ImageIcon mortoDown = new ImageIcon("src/img/olho_baixo.png");
        ImageIcon mortoLeft = new ImageIcon("src/img/olho_esq.png");
        ImageIcon mortoRigth = new ImageIcon("src/img/olho_dir.png");
        
        ImageIcon redUp = new ImageIcon("src/img/red_alto.png");
        ImageIcon redDown = new ImageIcon("src/img/red_baixo.png");
        ImageIcon redLeft = new ImageIcon("src/img/red_esq.png");
        ImageIcon redRigth = new ImageIcon("src/img/red_dir.png");
        
        ImageIcon blueUp = new ImageIcon("src/img/blue_alto.png");
        ImageIcon blueDown = new ImageIcon("src/img/blue_baixo.png");
        ImageIcon blueLeft = new ImageIcon("src/img/blue_esq.png");
        ImageIcon blueRigth = new ImageIcon("src/img/blue_dir.png");
        
        ImageIcon orangeUp = new ImageIcon("src/img/orange_alto.png");
        ImageIcon orangeDown = new ImageIcon("src/img/orange_baixo.png");
        ImageIcon orangeLeft = new ImageIcon("src/img/orange_esq.png");
        ImageIcon orangeRigth = new ImageIcon("src/img/orange_dir.png");
        
        ImageIcon pinkUp = new ImageIcon("src/img/pink_alto.png");
        ImageIcon pinkDown = new ImageIcon("src/img/pink_baixo.png");
        ImageIcon pinkLeft = new ImageIcon("src/img/pink_esq.png");
        ImageIcon pinkRigth = new ImageIcon("src/img/pink_dir.png");
        
        g.drawImage(mapa.getImage(), 0, 0, null);

        g.setColor(Color.WHITE);
        Font font = new Font("Arial", 1, 20);

        g.setFont(font);
        g.drawString("Score", 480, 225);
        g.drawString(String.valueOf(score.getScore()), 490, 245);
        
        g.drawString("Vidas", 480, 345);
        g.drawString(String.valueOf(score.getPacVidas()), 490, 365);



        for(int x=0; x<28;x++)
            for(int y=0; y<31; y++){
                switch(labirinto.labirinto[y][x]){
                    case 1:
                        g.drawImage(ponto.getImage(), x*20 +7, y*20 +7, null);
                        break;
                    case 2:
                        g.drawImage(vitamina.getImage(), x*20 +3, y*20 +3, null);
                        break;
                    case 5:
                    case 6:
                    case 7:
                        if(fantasma[0].isDoido())
                            g.drawImage(doido.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                        else if (!fantasma[0].isVivo()){
                            switch (fantasma[0].getDirecao()){
                                case 0:
                                    g.drawImage(mortoUp.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                    break;
                                case 1:
                                    g.drawImage(mortoDown.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                    break;
                                case 2:
                                    g.drawImage(mortoLeft.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                    break;
                                case 3:
                                    g.drawImage(mortoRigth.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                    break;
                            }
                        }
                        else
                        switch(fantasma[0].getDirecao()){
                            case 0:
                                g.drawImage(redUp.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                break;
                            case 1:
                                g.drawImage(redDown.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                break;
                            case 2:
                                g.drawImage(redLeft.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                break;
                            case 3:
                                g.drawImage(redRigth.getImage(), fantasma[0].getFantY()*20, fantasma[0].getFantX()*20, null);
                                break;
                        }
                        break;
                    case 8:
                    case 9:
                    case 10:
                        if(fantasma[1].isDoido())
                            g.drawImage(doido.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                        else if (!fantasma[1].isVivo()){
                            switch (fantasma[1].getDirecao()){
                                case 0:
                                    g.drawImage(mortoUp.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                    break;
                                case 1:
                                    g.drawImage(mortoDown.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                    break;
                                case 2:
                                    g.drawImage(mortoLeft.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                    break;
                                case 3:
                                    g.drawImage(mortoRigth.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                    break;
                            }
                        }
                        else
                        switch(fantasma[1].getDirecao()){
                            case 0:
                                g.drawImage(blueUp.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                break;
                            case 1:
                                g.drawImage(blueDown.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                break;
                            case 2:
                                g.drawImage(blueLeft.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                break;
                            case 3:
                                g.drawImage(blueRigth.getImage(), fantasma[1].getFantY()*20, fantasma[1].getFantX()*20, null);
                                break;
                        }
                        break;
                    case 11:
                    case 12:
                    case 13:
                        if(fantasma[2].isDoido())
                            g.drawImage(doido.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                        else if (!fantasma[2].isVivo()){
                            switch (fantasma[2].getDirecao()){
                                case 0:
                                    g.drawImage(mortoUp.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                    break;
                                case 1:
                                    g.drawImage(mortoDown.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                    break;
                                case 2:
                                    g.drawImage(mortoLeft.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                    break;
                                case 3:
                                    g.drawImage(mortoRigth.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                    break;
                            }
                        }
                        else
                        switch(fantasma[2].getDirecao()){
                            case 0:
                                g.drawImage(orangeUp.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                break;
                            case 1:
                                g.drawImage(orangeDown.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                break;
                            case 2:
                                g.drawImage(orangeLeft.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                break;
                            case 3:
                                g.drawImage(orangeRigth.getImage(), fantasma[2].getFantY()*20, fantasma[2].getFantX()*20, null);
                                break;
                        }
                        break;
                    case 14:
                    case 15:
                    case 16:
                        if(fantasma[3].isDoido())
                            g.drawImage(doido.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                        else if (!fantasma[3].isVivo()){
                            switch (fantasma[3].getDirecao()){
                                case 0:
                                    g.drawImage(mortoUp.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                    break;
                                case 1:
                                    g.drawImage(mortoDown.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                    break;
                                case 2:
                                    g.drawImage(mortoLeft.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                    break;
                                case 3:
                                    g.drawImage(mortoRigth.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                    break;
                            }
                        }
                        else
                        switch(fantasma[3].getDirecao()){
                            case 0:
                                g.drawImage(pinkUp.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                break;
                            case 1:
                                g.drawImage(pinkDown.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                break;
                            case 2:
                                g.drawImage(pinkLeft.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                break;
                            case 3:
                                g.drawImage(pinkRigth.getImage(), fantasma[3].getFantY()*20, fantasma[3].getFantX()*20, null);
                                break;
                        }
                        break;
                    case 3:
                        
                        break;
                }
                switch (pacman.getDirecao()){
                            case 0:
                                g.drawImage(pacUp.getImage(), pacman.getPacY()*20, pacman.getPacX()*20, null);
                                break;
                            case 1:
                                g.drawImage(pacDown.getImage(), pacman.getPacY()*20, pacman.getPacX()*20, null);
                                break;
                            case 2:
                                g.drawImage(pacLeft.getImage(), pacman.getPacY()*20, pacman.getPacX()*20, null);
                                break;
                            case 3:
                                g.drawImage(pacRigth.getImage(), pacman.getPacY()*20, pacman.getPacX()*20, null);
                                break;
                            default:
                                g.drawImage(pacRigth.getImage(), pacman.getPacY()*20, pacman.getPacX()*20, null);
                                break;
                        }
            }
    }




    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
