/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

/**
 *
 * @author lab23
 */
public class Score {
    private int score;
    private int pacVidas=3;

    public int getScore() {
        return score;
    }

    public int getPacVidas() {
        return pacVidas;
    }

    public void setPacVidas(int pacVidas) {
        this.pacVidas = pacVidas;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
