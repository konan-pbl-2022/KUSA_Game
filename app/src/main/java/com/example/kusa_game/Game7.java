package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

    public class Game7 extends AppCompatActivity {

        //選んだカードを比較するために用いる。
        int comapre_me = 0, compare_left = 0, compare_right = 0;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game7);

            Button backmainButton = (Button) findViewById(R.id.BackMainButton);
            backmainButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Game7.this, MainActivity.class);
                    startActivity(intent);
                }
            });

            TextView titletext = (TextView)findViewById(R.id.TitleText);
            titletext.setText("トランプゲーム");

            //カードを選ぶボタン。各ゲームが選ばれるまで非表示にする。
            ImageButton imageButtonleft = (ImageButton)findViewById(R.id.selectleftButton);
            imageButtonleft.setVisibility(View.INVISIBLE);
            ImageButton imageButtontright = (ImageButton)findViewById(R.id.selectrightButton);
            imageButtontright.setVisibility(View.INVISIBLE);

            //ランダムな画像を描画→非表示にする。
            ImageView card_left = (ImageView)findViewById(R.id.list_card_view_left);
            TypedArray typedArray_left = getResources().obtainTypedArray(R.array.card_list);
            card_left.setVisibility(View.INVISIBLE);
            ImageView card_right = (ImageView)findViewById(R.id.list_card_view_right);
            TypedArray typedArray_right = getResources().obtainTypedArray(R.array.card_list);
            card_right.setVisibility(View.INVISIBLE);

            //ランダムで最初から表示されるカードの画像が切り替わるようにする。なお、乱数は毎ボタン押し時に変更できるようここに記述はしない。
            ImageView card_me = (ImageView)findViewById(R.id.list_card_view);
            TypedArray typedArray_me = getResources().obtainTypedArray(R.array.card_list);
            card_me.setVisibility(View.INVISIBLE);




            //Game_1:「選んだカードと手持ちのカードの合計数が10を超えないようにする」の処理
            Button game1Button = (Button) findViewById(R.id.Gmae_1Button);
            game1Button.setOnClickListener(view -> {

                titletext.setText("10を超えないカードをえらべ！");
                card_left.setImageResource(R.drawable.reverse);
                card_right.setImageResource(R.drawable.reverse);
                card_left.setVisibility(View.VISIBLE);
                card_right.setVisibility(View.VISIBLE);


                //選ぶボタンを表示する。
                imageButtonleft.setVisibility(View.VISIBLE);
                imageButtontright.setVisibility(View.VISIBLE);


                //乱数を設定する。ここでの乱数はのちに値の判別で用いる。(発生させた乱数) % 13 でそのカードの数字も求めることができ、値が0の時は13を代入する。(jokerを除く)。
                int rand_me = (int) (Math.floor(Math.random() * 52));
                comapre_me = rand_me % 13;
                if(comapre_me == 0 || rand_me == 0){
                    comapre_me = 13;
                }

                int rand_left = (int) (Math.floor(Math.random() * 52));
                compare_left = rand_left % 13;
                if(compare_left == 0 || rand_left == 0){
                    compare_left = 13;
                }

                int rand_right = (int) (Math.floor(Math.random() * 52));
                compare_right = rand_right % 13;
                if(compare_right == 0|| rand_right == 0){
                    compare_right = 13;
                }

                //自分のカードをランダムで設定し、表示する。
                Drawable drawable_me = typedArray_me.getDrawable(rand_me);
                card_me.setImageDrawable(drawable_me);
                card_me.setVisibility(View.VISIBLE);


                //左カードを選択時、左のボタンが押されたとき画像変更。
                imageButtonleft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Drawable drawable_left = typedArray_left.getDrawable(rand_left);
                        card_left.setImageDrawable(drawable_left);
                        card_left.setVisibility(View.VISIBLE);
                        imageButtonleft.setVisibility(View.INVISIBLE);
                        imageButtontright.setVisibility(View.INVISIBLE);

                        if(comapre_me + compare_left < 10){
                            titletext.setText("成功！！！");
                        }else{
                            titletext.setText("失敗！！！");
                        }
                    }
                });

                //右カードを選択時、左のボタンが押されたとき画像変更。
                imageButtontright.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Drawable drawable_right = typedArray_right.getDrawable(rand_right);
                        card_right.setImageDrawable(drawable_right);
                        card_right.setVisibility(View.VISIBLE);
                        imageButtonleft.setVisibility(View.INVISIBLE);
                        imageButtontright.setVisibility(View.INVISIBLE);

                        if(comapre_me + compare_right < 10){
                            titletext.setText("成功！！！");
                        }else{
                            titletext.setText("失敗！！！");
                        }
                    }
                });

            });
        }


//        //Game_2:「ブラックジャック」の処理
//        Button game2Button = (Button) findViewById(R.id.Gmae_2Button);
//        game2Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//
//        });
//
//
//        //Game_3:「ハイアンドロー」の処理
//        Button game3Button = (Button) findViewById(R.id.Gmae_3Button);
//        game3Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//
//        });

    }