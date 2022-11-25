package com.example.kusa_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class Game6 extends AppCompatActivity {
    private  TextView countView;
    int count = 0;                  //歩数のカウント
    int dist_x = 0, dist_y = 0;     //目的の座標までの距離計算に用いる
    int pointX;
    int pointY;                     // 両者ともクリックした位置の座標を取得するために用いる。

    //目的の座標を決めるための乱数。x座標は0~1070、y座標は600~1700までの間で乱数を発生させている。
    Random r_x = new Random();
    int random_x = r_x.nextInt(1070) + 1;
    Random r_y = new Random();
    int random_y = r_y.nextInt(1200) + 501;

    //背景をランダムで決めるための乱数。0~3までの数値を発生させ+1し、1~4を乱数として用いる。
    Random r_v = new Random();
    int random_view = r_v.nextInt(4) + 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game6);

        //背景画像。ランダムで選ばれるもの以外は非表示にしておく。
        ImageView imageView1 = (ImageView) findViewById(R.id.BackGroundView1);
        imageView1.setVisibility(View.INVISIBLE);
        ImageView imageView2 = (ImageView) findViewById(R.id.BackGroundView2);
        imageView2.setVisibility(View.INVISIBLE);
        ImageView imageView3 = (ImageView) findViewById(R.id.BackGroundView3);
        imageView3.setVisibility(View.INVISIBLE);
        ImageView imageView4 = (ImageView) findViewById(R.id.BackGroundView4);
        imageView4.setVisibility(View.INVISIBLE);

        //表示する背景を選択する。
        if(random_view == 1){
            imageView1.setVisibility(View.VISIBLE);
        }else if(random_view == 2){
            imageView2.setVisibility(View.VISIBLE);
        }else if(random_view == 3){
            imageView3.setVisibility(View.VISIBLE);
        }else if(random_view == 4){
            imageView4.setVisibility(View.VISIBLE);
        }

        //ゲーム画面からタイトルへ戻るボタンの設定
        Button button = (Button)findViewById(R.id.BackMainButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Game6.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


    public boolean onTouchEvent (MotionEvent event) {

        //タッチしたところの座標を取得する。タッチするごとにcount+1。
        pointX = (int) event.getX();
        pointY = (int) event.getY();
        count++;

        //現在の位置を表示
        TextView textView = (TextView) findViewById(R.id.NowWalkingText);
        textView.setText("( " + pointX + " , " + pointY + " ) を捜索中…");
        //現在の歩数(countの合計)を表示
        TextView textView1 = (TextView) findViewById(R.id.CountText);
        textView1.setText("現在の合計歩数は" + count + "歩です。");

        //目的の位置 - 現在の位置　の計算
        dist_x = random_x - pointX;
        dist_y = random_y - pointY;


        //現在の位置からどの方にゴールがあるかのヒントを表示する。
        if (dist_x > 0 && dist_y > 0) {
            TextView textView2 = (TextView) findViewById(R.id.HintText);
            textView2.setText("右下の方が怪しいぞ！");
        } else if (dist_x > 0 && dist_y < 0) {
            TextView textView2 = (TextView) findViewById(R.id.HintText);
            textView2.setText("右上の方が怪しいぞ！");
        } else if (dist_x < 0 && dist_y > 0) {
            TextView textView2 = (TextView) findViewById(R.id.HintText);
            textView2.setText("左下の方が怪しいぞ！");
        } else if (dist_x < 0 && dist_y < 0) {
            TextView textView2 = (TextView) findViewById(R.id.HintText);
            textView2.setText("左上の方が怪しいぞ！");
        }

        //以下クリア判定の際に①countストップ②非表示状態のテキスト、画像の表示③countに応じた判定の処理
        if(Math.sqrt( Math.pow(dist_x,2) + Math.pow(dist_y,2) ) <= 50 ){
            count--;
            ImageView imageViewtreasure = (ImageView) findViewById(R.id.TreasureBoxView);
            ImageView imageViewpaper = (ImageView) findViewById(R.id.PaperText);
            ImageView imageViewresultpaper = (ImageView) findViewById(R.id.ResultPaperText);
            TextView completetext = (TextView) findViewById(R.id.CompleteText);
            TextView resulttext1 = (TextView) findViewById(R.id.ResultText1);
            TextView resulttext2 = (TextView) findViewById(R.id.ResultText2);
            imageViewtreasure.setVisibility(View.VISIBLE);
            imageViewpaper.setVisibility(View.VISIBLE);
            imageViewresultpaper.setVisibility(View.VISIBLE);
            completetext.setVisibility(View.VISIBLE);
            resulttext1.setVisibility(View.VISIBLE);
            resulttext2.setVisibility(View.VISIBLE);
            resulttext1.setText("合計歩数:" + count);
            if(count < 10 ){
                resulttext2.setText("まさに神業！！！");
            }else if (count > 10 && count <20){
                resulttext2.setText("素晴らしい観察力！！！");
            }else if (count > 20 && count <50){
                resulttext2.setText("よくできました！！");
            }else if (count > 50 && count <100){
                resulttext2.setText("まずまずの出来栄えかな！");
            }else if (count > 100 && count <200){
                resulttext2.setText("まだまだ頑張れる！");
            }else if (count >200){
                resulttext2.setText("次はもっと頑張ろう！");
            }
        }

        return true;

    }
}