package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Game2.this, Game2_game.class);
                startActivity(intent);
            }
        });
        // ImageViewの用意
        ImageView myImage = findViewById(R.id.myImage);

// 画像名
        String imageName = "24581593_l";

// 画像のリソースIDを取得
        int resId = getResources().getIdentifier(imageName, "drawable", getPackageName());

// ImageViewに画像をセット
        myImage.setImageResource(resId);
    }
}