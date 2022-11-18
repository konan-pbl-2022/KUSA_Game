package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        //ゲームのタイトルを表示
        TextView textView = (TextView)findViewById(R.id.titleView);



    //ゲーム画面に移動するボタンの設定
        Button button1 = (Button) findViewById(R.id.StartGame4Button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Game4.this,Game4Play.class);
                startActivity(intent);
            }
        });

    //説明画面に移動するボタンの設定
        Button button2 = (Button) findViewById(R.id.Backgame4Button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView1 = (TextView) findViewById(R.id.setumeiView);
                textView1.setText("説明");
            }
        });
    }
}