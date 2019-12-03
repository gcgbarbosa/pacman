/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPrinc.java
 *
 * Created on 27/07/2011, 16:33:39
 */

package pacman;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author Agnaldo
 */                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
public class Tela extends javax.swing.JFrame {
    PacMan pacman;
    /** Creates new form TelaPrinc */
    public Tela(Labirinto labirinto) throws FileNotFoundException {
        //initComponents();
        Score score = new Score();
        
        
        
        Fantasma[] fantasma = new Fantasma[4];
        fantasma[0] = new Fantasma(11, 13, "Vermelho", score);
        fantasma[1] = new Fantasma(13, 13, "Azul", score);
        fantasma[2] = new Fantasma(13, 14, "Laranja", score);
        fantasma[3] = new Fantasma(15, 15, "Rosa", score);
        
        PacMan pacman = new PacMan(score, labirinto, fantasma);
        
        this.pacman = pacman;
        Status status = new Status(labirinto, fantasma, pacman);
        
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Painel p = new Painel(labirinto, score, pacman, fantasma);
        

    //    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
    //        public void actionPerformed(java.awt.event.ActionEvent evt) {
  //              System.exit(0);
  //          }
  //      });

        setBackground(Color.black);
        setSize(563, 653);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ImageIcon img = new ImageIcon("src/img/mapa.jpg");
        JLabel label = new JLabel(img);

        add(label);

        add(p);
        
        
        
        Audio.tocar(new FileInputStream("src/mp3/openingSong.wav"), false);
        
        Temporizador t = new Temporizador(5000,this,fantasma, pacman, labirinto);
        Temporizador2 t2 = new Temporizador2(100,this, status,score, 3, t);
        Temporizador3 t3 = new Temporizador3(5000,this,fantasma, pacman, labirinto);
        t.start();
        t2.start();
        t3.start();
        

        setVisible(true);
        
    }
    
    private void formKeyPressed(java.awt.event.KeyEvent evt) {  
        int dir = pacman.getDirecao();
        //JOptionPane.showMessageDialog(null, evt.getKeyCode());
        if (evt.getKeyCode() == 37){
            pacman.setDirecaoAnt(dir);
            pacman.setDirecao(2);
//            canhao.moveesquerda();
            
        }
        if (evt.getKeyCode() == 38){
            pacman.setDirecaoAnt(dir);
            pacman.setDirecao(0);
//            canhao.movecima();
        }
        if (evt.getKeyCode() == 39){  
            pacman.setDirecaoAnt(dir);
            pacman.setDirecao(3);
            
//            canhao.movedireita();
        }
        if (evt.getKeyCode() == 40){
            pacman.setDirecaoAnt(dir);
            pacman.setDirecao(1);
//            canhao.movebaixo();
        }
        if (evt.getKeyCode() == 65){//tiro para esquerda
//            m = new Municao(canhao.getX(),canhao.getY()+15,1);
//            vettiros.add(m);
        }
        if (evt.getKeyCode() == 83){//tiro para direita
//            m = new Municao(canhao.getX()+30,canhao.getY()+15,2);
//            vettiros.add(m);
        }
        if (evt.getKeyCode() == 68){//tiro para cima
//            m = new Municao(canhao.getX()+50,canhao.getY(),3);
//            vettiros.add(m);
        }
        if (evt.getKeyCode() == 70){//tiro para baixo
//            m = new Municao(canhao.getX()+50,canhao.getY()+30,4);
//            vettiros.add(m);
        }

    }//

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
