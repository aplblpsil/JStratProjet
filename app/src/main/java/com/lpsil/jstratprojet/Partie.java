package com.lpsil.jstratprojet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.*;

import com.lpsil.jstratprojet.classes.CustomView;


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
        scrollView.addView(cv);



        //scrollView.addView(cv);
        setContentView(scrollView);
        //setContentView(cv);







        System.out.println("Partie crée");
    }
}
