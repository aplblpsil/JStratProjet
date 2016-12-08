package com.lpsil.jstratprojet;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup.LayoutParams;
import android.*;


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

        ScrollView scrollView = new ScrollView(this);
        CustomView cv=new CustomView(this);

        //scrollView.addView(cv);
        View v =(View)cv;
        //CustomView.OnFocusChangeListener(v);




        //scrollView.addView(cv);
        setContentView(scrollView);
        //setContentView(cv);

        cv.setFocusable(true);





        System.out.println("Partie crée");
    }
}
