package com.lpsil.jstratprojet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.widget.*;
import android.view.ViewGroup.LayoutParams;

public class Partie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //nouveau
        GridLayout gridLayout=new GridLayout(this);
        RelativeLayout relativeLayout=new RelativeLayout(this);

        Button b = new Button (this);
        b.setText("bouton");
        b.setTextSize(10.0f);

        CustomView cv=new CustomView(this);

       /* LayoutParams params = (android.widget.RelativeLayout.LayoutParams) this.generateDefaultLayoutParams();
        params.height = 360;
        params.width = 360;
        params.addRule(CENTER_IN_PARENT);
        this.addView(board, params);*/




        RelativeLayout firstLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams firstLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        //firstLayout.setId(firstLayout.getId()+1);
        firstLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        firstLayoutParams.addRule(RelativeLayout.BELOW, firstLayout.getId() -1);
        firstLayoutParams.setMargins(0, 20, 0, 0);
        firstLayoutParams.addRule(RelativeLayout.ALIGN_LEFT, firstLayout.getId() -1);



        firstLayout.setLayoutParams(firstLayoutParams);



        //relativeLayout.addView(cv);
        firstLayout.addView(cv);
        firstLayout.addView(b);



        //setContentView(relativeLayout);
        setContentView(firstLayout);

        /*gridLayout.addView(new CustomView(this));
        gridLayout.addView(b);
        setContentView(gridLayout);*/


        //ancien
        //setContentView(new CustomView(this));


        System.out.println("Partie crée");
    }
}
