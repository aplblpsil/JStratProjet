package com.lpsil.jstratprojet;

/**
 * Created by Léo on 13/10/2016.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


public class CustomView extends View implements View.OnTouchListener, View.OnClickListener{



    private Paint paint;

    private Bitmap bitmap;
    private int bmpSize;
    private Plateau plateau;
    private float Xaffiche;
    private float Yaffiche;
    private float Xmove;
    private float Ymove;

    float Xclic;
    float Yclic;



    public CustomView(Context context) {
        super(context);
        bmpSize= BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1).getWidth();
        Xaffiche=0;
        Yaffiche=0;
        Xmove=0;
        Ymove=0;
        Xclic=0;
        Yclic=0;

        int x = 50;
        int y = 50;
        int sideLength = 200;
        Carte c =new Carte();
        plateau = new Plateau(c);
        //this.onSizeChanged(200,100,50,50);
        int height=plateau.getLongueur()*64;
        int width=plateau.getLargeur()*64;
        android.view.ViewGroup.LayoutParams lp = new android.view.ViewGroup.LayoutParams(height,width);//100 is width and 200 is height
        this.setLayoutParams(lp);
        init();
        System.out.println("Custum view créé");
    }

    public void init(){
        this.isFocusable();
        this.isFocusableInTouchMode();
        this.setOnClickListener(this);

        this.setOnTouchListener(this);


        this.invalidate();




    }


    @Override
    protected void onDraw(Canvas canvas) {


        paint=new Paint();
        bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);


        for(int x = 0; x< plateau.getLongueur(); x++){
            //canvas.drawLine(x*32,0,x*32,canvas.getHeight(),paint);

            for(int y = 0; y< plateau.getLargeur(); y++) {

                if(plateau.getTabCase()[x][y].getIDImage()==1){
                    //System.out.println("dessin herbe");
                    bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.herbe);
                    canvas.drawBitmap(bitmap, x * bitmap.getWidth(), y * bitmap.getHeight(), paint);
                }

                if(!plateau.getTabCase()[x][y].isObstacle()){

                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.BLACK);
                    canvas.drawRect(x*bmpSize,y*bmpSize,(x+1)*bmpSize,(y+1)*bmpSize,paint);
                    paint=new Paint();
                }



                if(plateau.getTabCase()[x][y].getPerso()!=null){
                    if(plateau.getTabCase()[x][y].getPerso()==plateau.getPersoActif()){
                        bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.selection);
                        canvas.drawBitmap(bitmap, x * bitmap.getWidth(), y * bitmap.getHeight(), paint);
                    }
                    bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);
                    canvas.drawBitmap(bitmap, x * bitmap.getWidth(), y * bitmap.getHeight(), paint);
                }

            }

        }






    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if(event.getAction()== MotionEvent.ACTION_DOWN){
            System.out.println("down");

            Xclic=event.getX();
            Yclic=event.getY();
            int indX=(int)(Xclic-Xaffiche)/bmpSize;
            int indY=(int)(Yclic-Yaffiche)/bmpSize;;
            System.out.println("clic en "+indX+" "+indY);
            if(plateau.getTabCase()[indX][indY].getPerso()!=null){
                plateau.setPersoActif(plateau.getTabCase()[indX][indY].getPerso());
                System.out.println(plateau.getTabCase()[indX][indY].getPerso().getNom()+" actif en "+indX+" "+indY);
            }

        }
        if(event.getAction()== MotionEvent.ACTION_UP){
            System.out.println("up");
        }

        if(event.getAction()== MotionEvent.ACTION_MOVE){
            System.out.println("move");



            Xmove=event.getRawX();
            Ymove=event.getRawY();
            Xaffiche-=(Xclic-Xmove);
            Yaffiche-=(Yclic-Ymove);
            Xclic=Xmove;
            Yclic=Ymove;


        }
        this.invalidate();
        return false;
    }

    @Override
    public void onClick(View v) {

        System.out.println("clic de base");
    }






}
