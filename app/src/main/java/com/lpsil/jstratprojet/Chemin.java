package com.lpsil.jstratprojet;

import java.util.ArrayList;

/**
 * Created by Léo on 28/12/2016.
 */

public class Chemin {
    /*static ArrayList<Case> tabMaillon;
    static ArrayList<Case> tabChemin;


    public static void trouver(Case cD,Case cF,Case[][] tabCase){
        Boolean trouvé=false;
        tabMaillon = new ArrayList();
        tabChemin = new ArrayList();

        System.out.println("recherche de chemint");

        for(int i=0; i<tabCase.length;i++){
            for(int j=0; j<tabCase[0].length;j++){
                tabCase[i][j].setSuivant(null);
                tabCase[i][j].setCout(0);
                tabCase[i][j].setChemin(false);
            }
        }
        suivant(cD,-1,tabCase);

        //remonterChemin(cF);


    }
    public static void suivant(Case c,int dir,Case[][] tabCase){
        //System.out.println("Suivant en : "+c.getX()+" "+c.getY());
        if(c.getX()+1<tabCase.length&&dir!=2){

            //Case suiv=tabCase[c.getX()+1][c.getY()];
            Case suiv = new Case(tabCase[c.getX()+1][c.getY()]);
            suiv.setCout(suiv.getCout()+1);
            suiv.setSuivant(c);

            if(ajout(suiv)){
                suivant(suiv,1,tabCase);
            }
        }
        if(c.getX()-1>=0&&dir!=1){
            Case suiv = new Case(tabCase[c.getX()-1][c.getY()]);
            suiv.setCout(suiv.getCout()+1);
            suiv.setSuivant(c);
            if(ajout(suiv)){
                suivant(suiv,2,tabCase);
            }
        }
        if(c.getY()+1<tabCase[0].length&&dir!=4){
            Case suiv = new Case(tabCase[c.getX()][c.getY()+1]);
            suiv.setCout(suiv.getCout()+1);
            suiv.setSuivant(c);
            if(ajout(suiv)){
                suivant(suiv,3,tabCase);
            }
        }
        if(c.getY()-1>=0&&dir!=3){
            Case suiv = new Case(tabCase[c.getX()][c.getY()-1]);
            suiv.setCout(suiv.getCout()+1);
            suiv.setSuivant(c);
            if(ajout(suiv)){
                suivant(suiv,4,tabCase);
            }
        }



    }
    public static boolean ajout(Case c){
        boolean ajouté=false;
        boolean exist=false;
        for(int i=0;i<tabMaillon.size();i++){
            Case temp = tabMaillon.get(i);
            if(c.getX()==temp.getX()&&c.getY()==temp.getY()){
            //if(c==temp){
                exist=true;
                if(c.getCout()<temp.getCout()){
                    tabMaillon.remove(temp);
                    tabMaillon.add(c);
                    ajouté = true;

                }
            }
        }
        if(!exist&&!ajouté){
            tabMaillon.add(c);
            ajouté = true;
        }


        return ajouté;
    }

    public static void remonterChemin(Case c){

        for(int i=0;i<tabMaillon.size();i++){

            if(tabMaillon.get(i).getX()==c.getX()&&tabMaillon.get(i).getY()==c.getY()){
                c=new Case(tabMaillon.get(i));
            }
        }
        System.out.println("case chemin : "+c.getX()+" "+c.getY());

        c.setChemin(true);
        tabChemin.add(c);

        if(c.getCout()>0&&c.getSuivant()!=null){
            //System.out.println("case remonté cout : "+c.getCout());
            remonterChemin(c.getSuivant());
        }
    }*/
    private static ArrayList tabMaillon;
    private static ArrayList tabChemin;
    private static Maillon maillon;

    private static Case tabCase[][];
    private static String[][] grille;
    private static boolean trouvé;

    /*public Chemin(){
        tabMaillon = new ArrayList();
        maillon = new Maillon();
        tabChemin = new ArrayList();
        xDebut=0;
        yDebut=0;
        xFin=0;
        yFin=0;
        partie=null;
        grille = new String[0][0];
        trouvé=false;
    }

    public Chemin(partie p){
        tabMaillon = new ArrayList();
        //maillon = new Maillon();
        tabChemin = new ArrayList();
        xDebut=0;
        yDebut=0;
        xFin=0;
        yFin=0;
        partie=p;
        grille = new String[partie.getMap().getLongueur()][partie.getMap().getLargeur()];
        trouvé=false;
    }*/

    public static void trouver(Case cd,Case cf,Case[][] tab){
        trouvé=false;

        tabMaillon = new ArrayList();
        tabChemin = new ArrayList();
        maillon = new Maillon(cd.getX(),cd.getY(),0,null);
        tabCase=tab;
        grille= new String[tab.length][tab[0].length];

        for(int i=0; i<tabCase.length;i++){
            for(int j=0; j<tabCase[0].length;j++){
                grille[i][j]="";
                //tabCase[i][j].setChemin(false);
            }
        }
        suivant(maillon,-1);
        for(int i=0; i<tabMaillon.size();i++){
            Maillon temp=(Maillon) tabMaillon.get(i);
            if(temp.getX()==cf.getX()&&temp.getY()==cf.getY()){
                remonterChemin(temp);
            }
            else{

            }
        }
        for(int i=0; i<tabChemin.size();i++){
            Maillon temp=(Maillon) tabChemin.get(i);
            tabCase[temp.getX()][temp.getY()].setChemin(true);
        }


    }

    public static void suivant(Maillon m,int dir){
        if(m.getX()+1<tabCase.length&&dir!=2){
            Maillon mail =new Maillon(m.getX()+1,m.getY(),m.getCout()+1,m);
            if(ajout(mail)){
                suivant(mail,1);
            }
        }
        if(m.getX()-1>=0&&dir!=1){
            Maillon mail =new Maillon(m.getX()-1,m.getY(),m.getCout()+1,m);
            if(ajout(mail)){
                suivant(mail,2);
            }
        }
        if(m.getY()+1<tabCase[0].length&&dir!=4){
            Maillon mail =new Maillon(m.getX(),m.getY()+1,m.getCout()+1,m);
            if(ajout(mail)){
                suivant(mail,3);
            }
        }
        if(m.getY()-1>=0&&dir!=3){
            Maillon mail =new Maillon(m.getX(),m.getY()-1,m.getCout()+1,m);
            if(ajout(mail)){
                suivant(mail,4);
            }
        }



    }
    public static boolean ajout(Maillon m){
        boolean ajouté=false;
        boolean exist=false;
        for(int i=0;i<tabMaillon.size();i++){
            Maillon temp = (Maillon) tabMaillon.get(i);
            if(m.getX()==temp.getX()&&m.getY()==temp.getY()){
                exist=true;
                if(m.getCout()<temp.getCout()){
                    tabMaillon.remove(temp);
                    tabMaillon.add(m);
                    ajouté = true;

                }
            }
        }
        if(!exist&&!ajouté){
            tabMaillon.add(m);
            ajouté = true;
        }


        return ajouté;
    }

    public static void remonterChemin(Maillon m){
        grille[m.getX()][m.getY()]="1";

        tabChemin.add(m);
        if(m.getCout()>0){
            remonterChemin(m.getPrec());
        }
    }

    /*public static void transfert(){

    }*/

    /**
     * @return the tabMaillon
     */
    public ArrayList getTabMaillon() {
        return tabMaillon;
    }

    /**
     * @param tabMaillon the tabMaillon to set
     */
    public void setTabMaillon(ArrayList tabMaillon) {
        this.tabMaillon = tabMaillon;
    }

    /**
     * @return the maillon
     */
    public Maillon getMaillon() {
        return maillon;
    }

    /**
     * @param maillon the maillon to set
     */
    public void setMaillon(Maillon maillon) {
        this.maillon = maillon;
    }

    /**
     * @return the partie
     */






    /**
     * @return the xFin
     */


    /**
     * @return the grille
     */
    public String[][] getGrille() {
        return grille;
    }

    /**
     * @param grille the grille to set
     */
    public void setGrille(String[][] grille) {
        this.grille = grille;
    }

    /**
     * @return the trouvé
     */
    public boolean isTrouvé() {
        return trouvé;
    }

    /**
     * @param trouvé the trouvé to set
     */
    public void setTrouvé(boolean trouvé) {
        this.trouvé = trouvé;
    }

    /**
     * @return the tabChemin
     */
    public ArrayList getTabChemin() {
        return tabChemin;
    }

    /**
     * @param tabChemin the tabChemin to set
     */
    public void setTabChemin(ArrayList tabChemin) {
        this.tabChemin = tabChemin;
    }
}
