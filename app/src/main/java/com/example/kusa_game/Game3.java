package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.Random;

public class Game3 extends AppCompatActivity {

    int numHave = 0;
    int num1 = 1;
    int num2 = -1;
    int[] set = new int[2];

    TextView point;
    TextView print1;
    TextView print2;
    TextView GameOver;
    Random rand = new Random();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        point = (TextView) findViewById(R.id.point);
        print1 = (TextView) findViewById(R.id.button1);
        print2 = (TextView) findViewById(R.id.button2);
        GameOver = (TextView) findViewById(R.id.GO);

        num1 = rand.nextInt(10) - 5;//set[0];
        num2 = rand.nextInt(10) - 5;

        Button button1 = (Button) findViewById(R.id.button1);
        print1.setText("LEFT");
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numHave = changeText(num1);

                //setNum();
                //num1 = set[0];
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        print2.setText("RIGHT");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numHave = changeText(num2);
                //num2 = set[1];
            }
        });

    }

    public int changeText(int pushnum) {
        numHave += pushnum;
        point.setText("" + numHave);
        if ((numHave <= -10) || (10 <= numHave)) {
            //GameOver 画面に表示
            GameOver.setText("GameOver");
        }


            return numHave;

    }
}

//    public void setNum(){
//        //   set = new int[2];
//        Random rand = new Random();
//        for(int i=0;i<2;i++) {
//            set[i] = rand.nextInt(10) - 5;
//        }
//    }

