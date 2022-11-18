package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class Game4Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4_play);

        //爆発する爆弾以外を押したときに加算される値。(爆弾の総数-爆発する爆弾の個数)と等しくなったとき、ゲームクリアの判定。
        int count;

         //乱数の設定。乱数は0~7までの値を発生させ、+1している。
        //発生させた乱数の値に対応するボタンを押したら爆弾が爆発するようにする。
        //発生した乱数と各ボタン(爆弾)を押したときに返される値が等しいとき、爆発する判定にする。
        final Random r = new Random();
        final int random = r.nextInt(2) + 1;
        System.out.println(random);

        //各爆弾に割り振られている値。この値とランダムに発生した値が等しい爆弾は、ボタンを押されたとき爆発する
            final int bomb1 = 1, bomb2 = 2, bomb3 = 3, bomb4 = 4, bomb5 = 5, bomb6 = 6, bomb7 = 7, bomb8 = 8;


        //ゲーム中の説明文
        TextView textView = findViewById(R.id.commandtitle);

        //ゲームオーバー時に表示する画像。通常時は非表示にする。
        final ImageView  imageView =(ImageView)findViewById(R.id.explodeView) ;
        imageView.setVisibility(View.INVISIBLE);

        //クリア時に表示する画像。

        //ゲーム画面からタイトルへ戻るボタンの設定
//        Button button5 = (Button) findViewById(R.id.Backgame4Button);
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Game4Play.this, Game4.class);
//                startActivity(intent);
//            }
//        });
//
//        //爆弾を選び、クリック出来るようにするための設定
//
//        final ImageButton imageButton = (ImageButton) findViewById(R.id.BombButton1);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (random != bomb1){
//                    imageButton.setImageResource(R.drawable.safe);
//                }else{
//                    imageView.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });
//
//        ImageButton imageButton1 = (ImageButton) findViewById(R.id.BombButton2);
//        imageButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if ( random != bomb2){
//                    imageButton.setImageResource(R.drawable.safe);
//                }else{
//                    imageView.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });

    }
}