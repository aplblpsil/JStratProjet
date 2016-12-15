package com.lpsil.jstratprojet;

/**
 * Created by Léo on 07/12/2016.
 */

public class Case {
    private int X;
    private int Y;
    private boolean obstacle; //si cette case peur acceuillir un Perso
    private Personnage Perso;   //contien un personnage ou null
    private int IDImage;        //ID du décor sur la case
    private boolean deplacement;//si le perso focus peut atteinde cette case
    private boolean attaque;    //si le perso focus peut attaquer cette case

    public Case(){
        setX(0);
        setY(0);
        setObstacle(false);
        setIDImage(0);
        setDeplacement(false);
        setDeplacement(false);
    }

    public Case(int x, int y, int id , boolean obs){
        setX(0);
        setY(0);
        setObstacle(obs);
        setIDImage(id);
        setDeplacement(false);
        setDeplacement(false);
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }


    public Personnage getPerso() {
        return Perso;
    }

    public void setPerso(Personnage perso) {
        Perso = perso;
    }

    public int getIDImage() {
        return IDImage;
    }

    public void setIDImage(int IDImage) {
        this.IDImage = IDImage;
    }

    public boolean isDeplacement() {
        return deplacement;
    }

    public void setDeplacement(boolean deplacement) {
        this.deplacement = deplacement;
    }

    public boolean isAttaque() {
        return attaque;
    }

    public void setAttaque(boolean attaque) {
        this.attaque = attaque;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }
}
