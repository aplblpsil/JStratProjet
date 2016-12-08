package com.lpsil.jstratprojet;

/**
 * Created by Léo on 13/10/2016.
 */


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.WindowManager;



public class CustomView extends View implements View.OnTouchListener, View.OnClickListener{



    private Paint paint;

    private Bitmap bitmap;

    private Plateau plateau;


    public CustomView(Context context) {
        super(context);
        int x = 50;
        int y = 50;
        int sideLength = 200;
        plateau = new Plateau();

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

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Compute the height required to render the view
        // Assume Width will always be MATCH_PARENT.
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 3000 + 50; // Since 3000 is bottom of last Rect to be drawn added and 50 for padding.
        setMeasuredDimension(width, height);
    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw");


        bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);

        //canvas.drawRect(0, 0, 32, 32, paint);




        /*DisplayMetrics metrics = getResources().getSystem().getDisplayMetrics();
        System.out.println();

        WindowManager w = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        w.getDefaultDisplay().getMetrics(metrics);
        int width= getContext().getResources().getDisplayMetrics().widthPixels;
        int height= getContext().getResources().getDisplayMetrics().heightPixels;
        System.out.println("taille : "+width+" "+height);
        System.out.println(metrics.widthPixels);


        canvas.drawRect(0, 0, 32, 32, paint);
        */
        System.out.println("draw long : "+plateau.getLongueur()+" larg : "+plateau.getLargeur());

        for(int x = 0; x< plateau.getLongueur(); x++){
            for(int y = 0; y< plateau.getLargeur(); y++) {

                if(plateau.getTabCase()[x][y].getIDImage()==1){
                    System.out.println("dessin herbe");
                    bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.herbe);
                    canvas.drawBitmap(bitmap, x * bitmap.getWidth(), y * bitmap.getHeight(), paint);
                }

                if(plateau.getTabCase()[x][y].getPerso()!=null){
                    bitmap = BitmapFactory.decodeResource(this.getContext().getResources(), R.drawable.joueur1);
                    canvas.drawBitmap(bitmap, x * bitmap.getWidth(), y * bitmap.getHeight(), paint);
                }
                //canvas.drawBitmap(bitmap, x * bitmap.getW.getWidth(), y * bitmap.getHeight(), paint);
                //canvas.drawBitmap(bitmap, x * 32, y * 32, paint);


                //Bitmap resized = Bitmap.createScaledBitmap(bitmap, metrics.widthPixels/plateau.getLarg(), metrics.heightPixels/plateau.getLong(), true);

                //canvas.drawBitmap(resized, i * resized.getWidth(), j * resized.getHeight(), paint);


            }System.out.println("");
        }






    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            /*double xClic = event.getX();
            double yClic = event.getY();

            int xTab =(int) xClic/ bitmap.getWidth();
            int yTab =(int) yClic/bitmap.getHeight();

            //move
            plateau.getGrilleJoueur()[xTab][yTab]=plateau.getJoueur();
            plateau.getGrilleJoueur()[plateau.getJoueur().getX()][plateau.getJoueur().getY()]=null;

            plateau.getJoueur().setX(xTab);
            plateau.getJoueur().setY(yTab);

            System.out.println("touche en  "+xClic+" "+yClic);*/
            this.invalidate();
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        System.out.println("clic de base");
    }



    /*@Override
    public boolean onDrag(View v, DragEvent event) {

        JViewport viewPort = scroll.getViewport();
        Point vpp = viewPort.getViewPosition();
        vpp.translate(xPressed-e.getX(), yPressed-e.getY());
        scrollRectToVisible(new Rectangle(vpp, viewPort.getSize()));

        return false;
    }*/
}
