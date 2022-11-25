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


//ゲーム画面に移動するボタンの設定
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            Intent intent = new Intent(Game4.this, Game4Play.class);
            startActivity(intent);
        });

//説明画面に移動するボタンの設定
//        Button button2 = findViewById(R.id.button2);
//        button2.setOnClickListener(view -> {
//            TextView textView = (TextView)findViewById(R.id.textView2);
//            textView.setText("説明");
//        });
    }
}