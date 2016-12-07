package com.lpsil.jstratprojet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Rasta on 25/11/2016.
 */

public class Personnage {
    private String nom;
    private int pv;
    private int pm;
    private String image;

    public Personnage(){
        nom="nomJoueur";
        pv=10;
        pm=3;
        image = "joueur1";
    }
}
