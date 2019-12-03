/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

/**
 *
 * @author Ohack
 */

//0=esq, 1=dir, 2= cima, 3= baixo
public class Fantasma {
    
    public Fantasma(int x, int y, String nome, Score score){
        this.fantX = x;
        this.fantY = y;
        this.nome = nome;
        this.score = score;
    }
    
    private int fantX;
    private int fantY;
    private int direcao = -1;
    private int direcaoAnt = -1;
    private boolean vivo = true;
    private boolean doido = false;
    private boolean seguindo = false;
    private String nome;
    private Score score;


    public int getDirecao() {
        return direcao;
    }

    public boolean isDoido() {
        return doido;
    }

    public void setDoido(boolean doido) {
        this.doido = doido;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getDirecaoAnt() {
        return direcaoAnt;
    }

    public void setDirecaoAnt(int direcaoAnt) {
        this.direcaoAnt = direcaoAnt;
    }

    public int getFantX() {
        return fantX;
    }

    public void setFantX(int fantX) {
        this.fantX = fantX;
    }

    public int getFantY() {
        return fantY;
    }

    public void setFantY(int fantY) {
        this.fantY = fantY;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }


    public boolean isSeguindo() {
        return seguindo;
    }

    public void setSeguindo(boolean seguindo) {
        this.seguindo = seguindo;
    }
    
    public boolean noQuadrado(){
        if(fantX >= 13 && fantX <= 14 && fantY <= 16 && fantY >= 11)
            return true;
        return false;
    }
    public boolean posQuad(int x, int y){
        if(x >= 13 && x <= 14 && x <= 16 && x >= 11)
            return true;
        return false;
    }
    
    public void direcao(int pacX, int pacY, Labirinto labirinto){

        
        if(!vivo) {
            pacX=14;
            pacY=14;
        }
        
        if(fantX==14 && fantY == 14)
            vivo=true;
        
        int difX = pacX - fantX;
        int difY = pacY - fantY;
        int proxPos;
        int tmpDirec;
        //int atualPos;
        boolean subiu = false;
        boolean esquerda = false;
        boolean mudou=false;
        
        if(noQuadrado()){
            pacX = 13;
            pacY = 11;
        }
        
        if(doido && vivo){
            boolean fica = true;
            while(fica){
            tmpDirec = direcao;
            int direcaoTmp = (int) Math.round(3*Math.random());
            if(direcaoTmp==0){ //Cima
                if(tmpDirec!=1)
                    direcao=0;
                fica = false;
            }
            if(direcaoTmp==1){ //Baixo
                if(tmpDirec!=0)
                    direcao=1;
                fica = false;
            }
            
            if(direcaoTmp==2){ //Esquerda
                if(tmpDirec!=3)
                    direcao=2;
                fica = false;
            }
            if(direcaoTmp==3){ //Direita
                if(tmpDirec!=2)
                    direcao=3;
                fica = false;
            }

            }
            
        } else{
            tmpDirec = direcao;

    //        if((proxPos >= 1 && proxPos <=4) && difX >= difY)
    //            if(pacX<=fantX)
    //                direcao=3;
    //            else 
    //                direcao = 2;



            proxPos = labirinto.labirinto[fantX-1][fantY];           
            if((proxPos >= 1 && proxPos <=4) && pacX <= fantX && tmpDirec!=1 && !posQuad(fantX-1, fantY)){
                    direcao = 0;
                    mudou=true;
            }

            proxPos = labirinto.labirinto[fantX+1][fantY];
            if((proxPos >= 1 && proxPos <=4) && pacX > fantX && tmpDirec != 0 && !posQuad(fantX, fantY)){
                    direcao = 1;
                    mudou=true;
            }

            proxPos = labirinto.labirinto[fantX][fantY+1];
            if((proxPos >= 1 && proxPos <=4)&& pacY > fantY && tmpDirec!= 2 && !posQuad(fantX, fantY+1)){
                    direcao = 3;
                    mudou=true;
            }
            
            proxPos = labirinto.labirinto[fantX][fantY-1];
            if((proxPos >= 1 && proxPos <=4)&& pacY <= fantY && tmpDirec!=3 && !posQuad(fantX, fantY-1)){
                    direcao=2;
                    mudou=true;
            }
            

            if(labirinto.labirinto[fantX-1][fantY]==0 && labirinto.labirinto[fantX][fantY-1] == 0)
                if(tmpDirec==0)
                    direcao=3;
                else if(tmpDirec==2)
                    direcao=1;
            if(labirinto.labirinto[fantX-1][fantY]==0 && labirinto.labirinto[fantX][fantY+1] == 0)
                if(tmpDirec==0)
                    direcao=2;
                else if(tmpDirec==3)
                    direcao=1;
            if(labirinto.labirinto[fantX+1][fantY]==0 && labirinto.labirinto[fantX][fantY+1] == 0)
                if(tmpDirec==1)
                    direcao=2;
                else if(tmpDirec==3)
                    direcao=0;
            if(labirinto.labirinto[fantX+1][fantY]==0 && labirinto.labirinto[fantX][fantY-1] == 0)
                if(tmpDirec==1)
                    direcao=3;
                else if(tmpDirec==2)
                    direcao=0;
//
//            if(labirinto.labirinto[fantX-1][fantY-1]==0 && //cima esquerda
//                    labirinto.labirinto[fantX-1][fantY+1]==0 && //cima direita
//                    labirinto.labirinto[fantX+1][fantY]==0 && //baixo
//                    labirinto.labirinto[fantX-1][fantY]!=0 && //cima
//                    labirinto.labirinto[fantX][fantY-1]!=0 && //esquerda
//                    labirinto.labirinto[fantX][fantY+1]!=0 &&
//                    labirinto.labirinto[fantX+1][fantY-1]==0 && //baixo esquerda
//                    labirinto.labirinto[fantX+1][fantY+1]==0) { //baixo direita
//                if(fantY<pacY && direcao!=2 && direcao!=3 && !mudou)
//                    direcao=3;
//                if(fantY>=pacY && direcao!=2 && direcao!=3 && !mudou)
//                    direcao=2;
//            }
//            if(labirinto.labirinto[fantX+1][fantY-1]==0 &&
//                    labirinto.labirinto[fantX+1][fantY+1]==0 &&
//                    labirinto.labirinto[fantX-1][fantY]==0 &&
//                    labirinto.labirinto[fantX+1][fantY] !=0 &&
//                    labirinto.labirinto[fantX][fantY-1]!=0 &&
//                    labirinto.labirinto[fantX][fantY+1]!=0 &&
//                    labirinto.labirinto[fantX-1][fantY-1]==0 && //cima esquerda
//                    labirinto.labirinto[fantX-1][fantY+1]==0){ //cima direita)
//                if(fantY<pacY && direcao!=2 && direcao!=3 && !mudou)
//                    direcao=3;
//                if(fantY>=pacY && direcao!=2 && direcao!=3 && !mudou)
//                    direcao=2;
//            }
//            
            if(direcao == 0  && labirinto.labirinto[fantX-1][fantY] == 0)
                if(fantY>=pacY && labirinto.labirinto[fantX][fantY-1] != 0 && tmpDirec !=3)
                    direcao=2;
                else if(labirinto.labirinto[fantX][fantY+1] != 0 && direcao !=2)
                    direcao=3;
            
            if(direcao == 1  && labirinto.labirinto[fantX+1][fantY] == 0)
                if(fantY>=pacY && labirinto.labirinto[fantX][fantY-1] != 0 && tmpDirec !=3)
                    direcao=2;
                else if(labirinto.labirinto[fantX][fantY+1] != 0 && direcao !=2)
                    direcao=3;
            
            if(direcao == 2  && labirinto.labirinto[fantX][fantY-1] == 0)
                if(fantX>=pacX && labirinto.labirinto[fantX-1][fantY] != 0 && tmpDirec !=1)
                    direcao=0;
                else if(labirinto.labirinto[fantX+1][fantY] != 0 && tmpDirec !=0)
                    direcao=1;
            if(tmpDirec == 3  && labirinto.labirinto[fantX][fantY+1] == 0){
                if(fantX>=pacX && labirinto.labirinto[fantX-1][fantY] != 0 && tmpDirec != 1)
                    direcao=0;
                if(fantX<pacX && labirinto.labirinto[fantX+1][fantY] != 0 && tmpDirec != 0)
                    direcao=1;
            }
            
        if(tmpDirec != direcao)
            direcaoAnt = direcao;
        }
        
    }
    
    public void seguir(int pacX, int pacY, Labirinto labirinto){
        int x = fantX;
        int y = fantY;
        int fantN=5;
        int atualPos=-1;
        int proxPos=-1;
        
        if(nome.equals("Vermelho"))
            fantN=5;
        else if(nome.equals("Azul"))
            fantN=8;
        else if(nome.equals("Laranja"))
            fantN=11;
        else if(nome.equals("Rosa"))
            fantN=14;
        
        atualPos = labirinto.labirinto[fantX][fantY];
        switch(direcao){
            case 0: //cima
                   proxPos = labirinto.labirinto[fantX-1][fantY];
                   if(proxPos!=0){
                   if(atualPos == fantN+1)
                        labirinto.labirinto[fantX][fantY] = 1;
                    else if(atualPos == fantN+2)
                        labirinto.labirinto[fantX][fantY] = 2;
                    else
                        labirinto.labirinto[fantX][fantY] = 4;
                    
                    if(proxPos == 1)
                        labirinto.labirinto[fantX-1][fantY] = fantN+1;
                    else if(proxPos == 2)
                        labirinto.labirinto[fantX-1][fantY] = fantN+2;
                    else if(proxPos == 4)
                        labirinto.labirinto[fantX-1][fantY] = fantN;
                    else if(proxPos == 3 && !isDoido() && isVivo())
                        score.setPacVidas(score.getPacVidas()-1);
                    else if(proxPos == 3 && isDoido() && isVivo()){
                        setVivo(false);
                        setDoido(false);
                    }
                        
                    direcaoAnt=-1;
                    fantX -= 1;
                   }
            break; 
            case 1: //baixo
                    proxPos = labirinto.labirinto[fantX+1][fantY];
                    if(proxPos!=0){
                    if(atualPos == fantN+1)
                        labirinto.labirinto[fantX][fantY] = 1;
                    else if(atualPos == fantN+2)
                        labirinto.labirinto[fantX][fantY] = 2;
                    else
                        labirinto.labirinto[fantX][fantY] = 4;
                    
                    if(proxPos == 1)
                        labirinto.labirinto[fantX+1][fantY] = fantN+1;
                    else if(proxPos == 2)
                        labirinto.labirinto[fantX+1][fantY] = fantN+2;
                    else if(proxPos == 4)
                        labirinto.labirinto[fantX+1][fantY] = fantN;
                    else if(proxPos == 3 && !isDoido() && isVivo())
                        score.setPacVidas(score.getPacVidas()-1);
                    else if(proxPos == 3 && isDoido() && isVivo()){
                        setVivo(false);
                        setDoido(false);
                    }
                    fantX += 1;
                    direcaoAnt=-1;
                    }
                break;
            case 2: //Esquerda
                    
                    if(fantY==1 && fantX==14){
                        labirinto.labirinto[fantX][fantY] = 4;
                        labirinto.labirinto[fantX][27] = fantN;
                        fantY = 27;
                    }
                    proxPos = labirinto.labirinto[fantX][fantY-1];
                    if(proxPos!=0){
                    if(atualPos == fantN+1)
                        labirinto.labirinto[fantX][fantY] = 1;
                    else if(atualPos == fantN+2)
                        labirinto.labirinto[fantX][fantY] = 2;
                    else
                        labirinto.labirinto[fantX][fantY] = 4;
                    
                    if(proxPos == 1)
                        labirinto.labirinto[fantX][fantY-1] = fantN+1;
                    else if(proxPos == 2)
                        labirinto.labirinto[fantX][fantY-1] = fantN+2;
                    else if(proxPos == 4)
                        labirinto.labirinto[fantX][fantY-1] = fantN;
                    else if(proxPos == 3 && !isDoido() && isVivo())
                        score.setPacVidas(score.getPacVidas()-1);
                    else if(proxPos == 3 && isDoido() && isVivo()){
                        setVivo(false);
                        setDoido(false);
                    }
                    fantY-=1;
                    direcaoAnt=-1;
                    }
                break;
            case 3: //Direita
                    
                    if(fantY==26 && fantX==14){
                        labirinto.labirinto[fantX][fantY] = 4;
                        labirinto.labirinto[fantX][0] = fantN;
                        fantY = 0;
                    } 
                    proxPos = labirinto.labirinto[fantX][fantY+1];
                    if(proxPos!=0){
                    if(atualPos == fantN+1)
                        labirinto.labirinto[fantX][fantY] = 1;
                    else if(atualPos == fantN+2)
                        labirinto.labirinto[fantX][fantY] = 2;
                    else
                        labirinto.labirinto[fantX][fantY] = 4;
                    
                    if(proxPos == 1)
                        labirinto.labirinto[fantX][fantY+1] = fantN+1;
                    else if(proxPos == 2)
                        labirinto.labirinto[fantX][fantY+1] = fantN+2;
                    else if(proxPos == 4)
                        labirinto.labirinto[fantX][fantY+1] = fantN;
                    else if(proxPos == 3 && !isDoido() && isVivo())
                        score.setPacVidas(score.getPacVidas()-1);
                    else if(proxPos == 3 && isDoido() && isVivo()){
                        setVivo(false);
                        setDoido(false);
                    }
                    fantY += 1;
                    direcaoAnt=-1;
                    }
                break;

        } 
//        switch(direcaoAnt){
//            case 0: //cima
//                   proxPos = labirinto.labirinto[fantX-1][fantY];
//                   if(proxPos!=0){
//                   if(atualPos == fantN+1)
//                        labirinto.labirinto[fantX][fantY] = 1;
//                    else if(atualPos == fantN+2)
//                        labirinto.labirinto[fantX][fantY] = 2;
//                    else
//                        labirinto.labirinto[fantX][fantY] = 4;
//                    
//                    if(proxPos == 1)
//                        labirinto.labirinto[fantX-1][fantY] = fantN+1;
//                    else if(proxPos == 2)
//                        labirinto.labirinto[fantX-1][fantY] = fantN+2;
//                    else if(proxPos == 4)
//                        labirinto.labirinto[fantX-1][fantY] = fantN;
//
//                    fantX -= 1;
//                   }
//                    
//            break; 
//            case 1: //baixo
//                    proxPos = labirinto.labirinto[fantX+1][fantY];
//                    if(proxPos!=0){
//                    if(atualPos == fantN+1)
//                        labirinto.labirinto[fantX][fantY] = 1;
//                    else if(atualPos == fantN+2)
//                        labirinto.labirinto[fantX][fantY] = 2;
//                    else
//                        labirinto.labirinto[fantX][fantY] = 4;
//                    
//                    if(proxPos == 1)
//                        labirinto.labirinto[fantX+1][fantY] = fantN+1;
//                    else if(proxPos == 2)
//                        labirinto.labirinto[fantX+1][fantY] = fantN+2;
//                    else if(proxPos == 4)
//                        labirinto.labirinto[fantX+1][fantY] = fantN;
//                    fantX += 1;
//                    }
//                
//                break;
//            case 2: //Esquerda
//                    
//                    if(fantY==0 && fantX==14){
//                        labirinto.labirinto[fantX][fantY] = 4;
//                        labirinto.labirinto[fantX][27] = fantN;
//                        fantY = 27;
//                    }
//                    proxPos = labirinto.labirinto[fantX][fantY-1];
//                    if(proxPos!=0){
//                    if(atualPos == fantN+1)
//                        labirinto.labirinto[fantX][fantY] = 1;
//                    else if(atualPos == fantN+2)
//                        labirinto.labirinto[fantX][fantY] = 2;
//                    else
//                        labirinto.labirinto[fantX][fantY] = 4;
//                    
//                    if(proxPos == 1)
//                        labirinto.labirinto[fantX][fantY-1] = fantN+1;
//                    else if(proxPos == 2)
//                        labirinto.labirinto[fantX][fantY-1] = fantN+2;
//                    else if(proxPos == 4)
//                        labirinto.labirinto[fantX][fantY-1] = fantN;
//                    }
//                break;
//            case 3: //Direita
//                
//                    if(fantY==27 && fantX==14){
//                        labirinto.labirinto[fantX][fantY] = 4;
//                        labirinto.labirinto[fantX][0] = fantN;
//                        fantY = 0;
//                    }
//                    proxPos = labirinto.labirinto[fantX][fantY+1];
//
//                    if(proxPos!=0){
//                    if(atualPos == fantN+1)
//                        labirinto.labirinto[fantX][fantY] = 1;
//                    else if(atualPos == fantN+2)
//                        labirinto.labirinto[fantX][fantY] = 2;
//                    else
//                        labirinto.labirinto[fantX][fantY] = 4;
//                    
//                    if(proxPos == 1)
//                        labirinto.labirinto[fantX][fantY+1] = fantN+1;
//                    else if(proxPos == 2)
//                        labirinto.labirinto[fantX][fantY+1] = fantN+2;
//                    else if(proxPos == 4)
//                        labirinto.labirinto[fantX][fantY+1] = fantN;
//                    fantY += 1;
//                    }
//                break;
//        }
    }
}
