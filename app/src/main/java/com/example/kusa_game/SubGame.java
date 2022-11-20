package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SubGame extends AppCompatActivity {

    /*private MediaPlayer option1 = new MediaPlayer();
    private String filePath_start = "金属ロゴ表示1.mp3";*/
    private Timer timer;
    private CountUpTimerTask timerTask;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private TextView textView_timer, textView_result, textView_action;
    private long delay, period, result, enemy;
    private long line, count;
    private int Dif;
    private int stage;
    private String zero;
    private Random random = new Random();




    @SuppressLint("MissingInflatedId")
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sub_game);
       /* MediaPlayer option1 = new MediaPlayer();*/

        Intent intent = getIntent();

        Dif = intent.getIntExtra("difficulty", 1);

        stage = 1;
        delay = 0;
        period = 10;
        zero = getString(R.string.zero);

        ImageView imageView_game1 = findViewById(R.id.imageView_game1);
        imageView_game1.setImageResource(R.drawable.nc77380);

        ImageView image_reimu = findViewById(R.id.reimu);
        //Drawable Drawable_reimu = getResources().getDrawable(R.drawable.reimu);
        //image_reimu.setImageDrawable(Drawable_reimu);
        Bitmap bitmap_R = BitmapFactory.decodeResource(getResources(), R.drawable.reimu);
        Matrix matrix_reimu = new Matrix();
        matrix_reimu.preScale(-1, 1);
        Bitmap bitmap_reimu = Bitmap.createBitmap(bitmap_R, 0, 0, bitmap_R.getWidth(), bitmap_R.getHeight(), matrix_reimu, false);
        image_reimu.setImageBitmap(bitmap_reimu);


        ImageView image_tiruno = findViewById(R.id.tiruno_start);
        ImageView image_remiria = findViewById(R.id.remiria_start);
        ImageView image_marisa = findViewById(R.id.marisa_start);
        Drawable Drawable_enemy = getResources().getDrawable(R.drawable.tiruno_before);
        Drawable Drawable_enemy_2 = getResources().getDrawable(R.drawable.remiria_start);
        Drawable Drawable_enemy_3 = getResources().getDrawable(R.drawable.marisa_start);
        image_tiruno.setImageDrawable(Drawable_enemy);
        image_remiria.setImageDrawable(Drawable_enemy_2);
        image_marisa.setImageDrawable(Drawable_enemy_3);

        if( stage == 1 ) {
            image_tiruno.setVisibility(View.VISIBLE);
            image_remiria.setVisibility(View.INVISIBLE);
            image_marisa.setVisibility(View.INVISIBLE);
        }else if(stage == 2) {
            image_tiruno.setVisibility(View.INVISIBLE);
            image_remiria.setVisibility(View.VISIBLE);
            image_marisa.setVisibility(View.INVISIBLE);
        }else if(stage == 3) {
            image_tiruno.setVisibility(View.INVISIBLE);
            image_remiria.setVisibility(View.INVISIBLE);
            image_marisa.setVisibility(View.VISIBLE);
        }

            //image_enemy.setImageDrawable(Drawable_enemy);



        ImageView image_reimu_after = findViewById(R.id.reimu_after);
        //Drawable Drawable_reimu = getResources().getDrawable(R.drawable.reimu);
        //image_reimu.setImageDrawable(Drawable_reimu);
        Bitmap bitmap_RA = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_after);
        Matrix matrix_reimu_after = new Matrix();
        matrix_reimu_after.preScale(-1, 1);
        Bitmap bitmap_reimu_after = Bitmap.createBitmap(bitmap_RA, 0, 0, bitmap_RA.getWidth(), bitmap_RA.getHeight(), matrix_reimu_after, false);
        image_reimu_after.setImageBitmap(bitmap_reimu_after);
        image_reimu_after.setVisibility(View.INVISIBLE);

        ImageView image_enemy_after = findViewById(R.id.enemy_after);
        Drawable Drawable_enemy_after = getResources().getDrawable(R.drawable.tiruno_after);
        image_enemy_after.setImageDrawable(Drawable_enemy_after);
        image_enemy_after.setVisibility(View.INVISIBLE);



        textView_timer = findViewById(R.id.timer);
        textView_timer.setText((zero));
        textView_result = findViewById(R.id.result_up);
        textView_result.setText((zero));
        textView_action = findViewById(R.id.action);
        textView_action.setText((zero));
        Button next_stage_Button = findViewById(R.id.next);
        next_stage_Button.setVisibility(View.GONE);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button back_Button = findViewById(R.id.back);
        back_Button.setVisibility(View.GONE);

        line = random.nextInt(400)+500;

        timer = new Timer();

        timerTask = new CountUpTimerTask();

        timer.schedule(timerTask, delay, period);

        /*try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_start))
        {
            option1.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            option1.prepare();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        if( count == 100 ) {
            option1.setLooping(true);
            option1.start();
        }

        if( count == 300 ) {
            option1.stop();
            option1.reset();
            // リソースの解放
            option1.release();
        }*/





        Button stopButton = findViewById(R.id.stop_b);
        stopButton.setOnClickListener(v -> {

            timer.cancel();
            result = count;
            if( enemy > result && result >= line) {

                textView_result.setText("You win");

                image_reimu_after.setVisibility(View.VISIBLE);
                image_enemy_after.setVisibility(View.VISIBLE);
                image_reimu.setVisibility(View.INVISIBLE);
                image_tiruno.setVisibility(View.INVISIBLE);

                stopButton.setVisibility(View.INVISIBLE);
                next_stage_Button.setVisibility(View.VISIBLE);
                next_stage_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count = 0;
                        line = random.nextInt(400)+500;

                        next_stage_Button.setVisibility(View.GONE);
                        stopButton.setVisibility(View.VISIBLE);
                        textView_result.setText((zero));
                        textView_action.setText((zero));
                        timer = new Timer();

                        timerTask = new CountUpTimerTask();

                        timer.schedule(timerTask, delay, period);

                        if( stage == 1) {
                            stage = 2;
                            image_reimu_after.setVisibility(View.INVISIBLE);
                            image_enemy_after.setVisibility(View.INVISIBLE);
                            image_reimu.setVisibility(View.VISIBLE);
                            image_remiria.setVisibility(View.VISIBLE);

                        } else if( stage == 2) {
                            stage = 3;
                        }
                    }
                });

            } else if ( result < line ) {
                textView_result.setText("仕切り直し");
                stopButton.setVisibility(View.INVISIBLE);
                back_Button.setVisibility(View.VISIBLE);
                back_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count = 0;
                        line = random.nextInt(400)+500;

                        back_Button.setVisibility(View.GONE);
                        stopButton.setVisibility(View.VISIBLE);
                        textView_action.setText((zero));
                        textView_result.setText((zero));
                        timer = new Timer();

                        timerTask = new CountUpTimerTask();

                        timer.schedule(timerTask, delay, period);


                    }
                });

            }

        });



    }

    class CountUpTimerTask extends TimerTask {
        Button back_Button = findViewById(R.id.back);


        @Override


        public void run() {
            handler.post(() -> {
                count++;
                textView_timer.setText(String.format(Locale.US, "%1$02d", count));



                /*if( count == 100 ) {
                    option1.setLooping(true);
                    option1.start();
                }

                if( count == 300 ) {
                    option1.stop();
                    option1.reset();
                    // リソースの解放
                    option1.release();
                }*/

                if( count == line ) {
                    textView_action.setText("!!");
                }

                if(stage == 1 ) {
                    enemy = line + ( 500 - Dif*100);
                } else if(stage == 2 ) {
                    enemy = line +  ( 300 - Dif*80 );
                } else  if(stage == 3 ){
                    enemy = line + ( 100 - Dif*31 );
                }


                if( enemy == count ) {
                    timer.cancel();
                    textView_result.setText("敗北者じゃけぇ");

                    back_Button.setVisibility(View.VISIBLE);
                    back_Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            count = 0;
                            line = random.nextInt(400)+500;
                            back_Button.setVisibility(View.GONE);
                            textView_result.setText((zero));
                            textView_action.setText((zero));
                            timer = new Timer();

                            timerTask = new CountUpTimerTask();

                            timer.schedule(timerTask, delay, period);


                        }
                    });
                }

            });
        }



    }

    public void onBackPressed() {

    }



}