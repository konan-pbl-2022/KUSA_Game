package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;



public class Game4Play extends AppCompatActivity {

    //爆発する爆弾以外を押したときに加算される値。この値が(爆弾の総数-爆発する爆弾の個数)と等しくなったとき、ゲームクリアの判定。
    int count=0;
    //各爆弾に割り振られている値。この値とランダムに発生した値が等しい爆弾は、ボタンを押されたとき爆発する
    int bomb1 = 1, bomb2 = 2, bomb3 = 3, bomb4 = 4, bomb5 = 5, bomb6 = 6, bomb7 = 7, bomb8 = 8, bomb9 = 9, bomb10 = 10, bomb11 = 11, bomb12 = 12, bomb13 = 13, bomb14 = 14, bomb15 = 15, bomb16 = 16, bomb17 = 17, bomb18 = 18, bomb19 = 19, bomb20 = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4_play);

        //背景画像。
        ImageView imageView = (ImageView) findViewById(R.id.MetalbackView);

        //乱数の設定。乱数は0~19までの値を発生させ、+1している。
        //発生させた乱数の値に対応するボタンを押したら爆弾が爆発するようにする。
        //発生した乱数と各ボタン(爆弾)を押したときに返される値が等しいとき、爆発する判定にする。
        Random r = new Random();
        int random = r.nextInt(20) + 1;
        System.out.println(random);

        //ゲーム中の説明文
        TextView textView = findViewById(R.id.commandtitle);

        //ゲーム終了時に表示する文章。通常は非表示。成功、失敗の両方で用いる。
        TextView endgametext = (TextView)findViewById(R.id.EndGameText);

        //ゲームオーバー時に表示する画像。通常は非表示にする。
        ImageView  imageViewexplode =(ImageView)findViewById(R.id.explodeView) ;
        imageViewexplode.setVisibility(View.INVISIBLE);

        //クリア時に表示する画像。通常は非表示にする。
        ImageView imageViewsuccess =(ImageView)findViewById(R.id.SuccessView);
        imageViewsuccess.setVisibility(View.INVISIBLE);

        //ゲーム画面からタイトルへ戻るボタンの設定
        Button button5 = (Button) findViewById(R.id.Backgame4Button);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game4Play.this, Game4.class);
                startActivity(intent);
            }
        });


        //爆弾を選び、クリック出来るようにするための設定。以下繰り返し20個あり

        ImageButton imageButton1 = (ImageButton) findViewById(R.id.BombButton1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (random != bomb1){
                    imageButton1.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });


        ImageButton imageButton2 = (ImageButton) findViewById(R.id.BombButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb2){
                    imageButton2.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton3 = (ImageButton) findViewById(R.id.BombButton3);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb3){
                    imageButton3.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton4 = (ImageButton) findViewById(R.id.BombButton4);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb4){
                    imageButton4.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton5 = (ImageButton) findViewById(R.id.BombButton5);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb5){
                    imageButton5.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton6 = (ImageButton) findViewById(R.id.BombButton6);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb6){
                    imageButton6.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton7 = (ImageButton) findViewById(R.id.BombButton7);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb7){
                    imageButton7.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton8 = (ImageButton) findViewById(R.id.BombButton8);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb8){
                    imageButton8.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton9 = (ImageButton) findViewById(R.id.BombButton9);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb9){
                    imageButton9.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton10 = (ImageButton) findViewById(R.id.BombButton10);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb10){
                    imageButton10.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton11 = (ImageButton) findViewById(R.id.BombButton11);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb11){
                    imageButton11.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton12 = (ImageButton) findViewById(R.id.BombButton12);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb12){
                    imageButton12.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton13 = (ImageButton) findViewById(R.id.BombButton13);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb13){
                    imageButton13.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton14 = (ImageButton) findViewById(R.id.BombButton14);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb14){
                    imageButton14.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton15 = (ImageButton) findViewById(R.id.BombButton15);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb15){
                    imageButton15.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton16 = (ImageButton) findViewById(R.id.BombButton16);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb16){
                    imageButton16.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton17 = (ImageButton) findViewById(R.id.BombButton17);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb17){
                    imageButton17.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton18 = (ImageButton) findViewById(R.id.BombButton18);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb18){
                    imageButton18.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton19 = (ImageButton) findViewById(R.id.BombButton19);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb19){
                    imageButton19.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });

        ImageButton imageButton20 = (ImageButton) findViewById(R.id.BombButton20);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( random != bomb20){
                    imageButton20.setImageResource(R.drawable.safe);
                    count += 1;
                    if(count == 19){
                        imageViewsuccess.setVisibility(View.VISIBLE);
                        endgametext.setText("成功！！");
                    }
                }else{
                    imageViewexplode.setVisibility(View.VISIBLE);
                    endgametext.setText("爆発してしまった…");

                }

            }

        });
    }
}