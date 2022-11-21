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

    private ImageView image_reimu_start = findViewById(R.id.reimu_start);
    private ImageView image_tiruno_start = findViewById(R.id.tiruno_start);
    private ImageView image_remiria_start = findViewById(R.id.remiria_start);
    private ImageView image_marisa_start = findViewById(R.id.marisa_start);
    private ImageView image_reimu_lose1 = findViewById(R.id.reimu_lose1);
    private ImageView image_reimu_win1 = findViewById(R.id.reimu_win1);
    private ImageView image_reimu_lose2 = findViewById(R.id.reimu_lose2);
    private ImageView image_reimu_win2 = findViewById(R.id.reimu_win2);
    private ImageView image_reimu_win3 = findViewById(R.id.reimu_win3);
    private ImageView image_tiruno_win = findViewById(R.id.tiruno_win);
    private ImageView image_tiruno_lose = findViewById(R.id.tiruno_lose);
    private ImageView image_remiria_win = findViewById(R.id.remiria_win);
    private ImageView image_remiria_lose = findViewById(R.id.remiria_lose);
    private ImageView image_marisa_win = findViewById(R.id.marisa_win);
    private ImageView image_marisa_lose = findViewById(R.id.marisa_lose);
    private Bitmap bitmap_RS = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_start);
    private Matrix matrix_reimu_start = new Matrix();
    private Bitmap bitmap_reimu_start = Bitmap.createBitmap(bitmap_RS, 0, 0, bitmap_RS.getWidth(), bitmap_RS.getHeight(), matrix_reimu_start, false);
    private Bitmap bitmap_RL1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose1);
    private Matrix matrix_reimu_lose1 = new Matrix();
    private Bitmap bitmap_reimu_lose1 = Bitmap.createBitmap(bitmap_RL1, 0, 0, bitmap_RL1.getWidth(), bitmap_RL1.getHeight(), matrix_reimu_lose1, false);
    private Bitmap bitmap_RW1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win1);
    private Matrix matrix_reimu_win1 = new Matrix();
    private Bitmap bitmap_reimu_win1 = Bitmap.createBitmap(bitmap_RW1, 0, 0, bitmap_RW1.getWidth(), bitmap_RW1.getHeight(), matrix_reimu_win1, false);
    private Bitmap bitmap_RL2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose2);
    private Matrix matrix_reimu_lose2 = new Matrix();
    private Bitmap bitmap_reimu_lose2 = Bitmap.createBitmap(bitmap_RL2, 0, 0, bitmap_RL2.getWidth(), bitmap_RL2.getHeight(), matrix_reimu_lose2, false);
    private Bitmap bitmap_RW2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win2);
    private Matrix matrix_reimu_win2 = new Matrix();
    private Bitmap bitmap_reimu_win2 = Bitmap.createBitmap(bitmap_RW2, 0, 0, bitmap_RW2.getWidth(), bitmap_RW2.getHeight(), matrix_reimu_win2, false);
    private Bitmap bitmap_RW3 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win3);
    private Matrix matrix_reimu_win3 = new Matrix();
    private Bitmap bitmap_reimu_win3 = Bitmap.createBitmap(bitmap_RW3, 0, 0, bitmap_RW3.getWidth(), bitmap_RW3.getHeight(), matrix_reimu_win3, false);
    private Drawable Drawable_tiruno_start = getResources().getDrawable(R.drawable.tiruno_start);
    private Drawable Drawable_remiria_start= getResources().getDrawable(R.drawable.remiria_start);
    private Drawable Drawable_marisa_start = getResources().getDrawable(R.drawable.marisa_start);
    private Drawable Drawable_tiruno_win = getResources().getDrawable(R.drawable.tiruno_win);
    private Drawable Drawable_tiruno_lose = getResources().getDrawable(R.drawable.tiruno_lose);
    private Drawable Drawable_remiria_win = getResources().getDrawable(R.drawable.remiria_win);
    private Drawable Drawable_remiria_lose = getResources().getDrawable(R.drawable.remiria_lose);
    private Drawable Drawable_marisa_win = getResources().getDrawable(R.drawable.marisa_win);
    private Drawable Drawable_marisa_lose = getResources().getDrawable(R.drawable.marisa_lose);


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

        /*ImageView image_reimu_start = findViewById(R.id.reimu_start);*/
        //Drawable Drawable_reimu = getResources().getDrawable(R.drawable.reimu);
        //image_reimu.setImageDrawable(Drawable_reimu);
        /*Bitmap bitmap_RS = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_start);*/
        /*Matrix matrix_reimu_start = new Matrix();*/
        matrix_reimu_start.preScale(-1, 1);
        /*Bitmap bitmap_reimu_start = Bitmap.createBitmap(bitmap_RS, 0, 0, bitmap_RS.getWidth(), bitmap_RS.getHeight(), matrix_reimu_start, false);*/
        image_reimu_start.setImageBitmap(bitmap_reimu_start);


        /*ImageView image_tiruno_start = findViewById(R.id.tiruno_start);
        ImageView image_remiria_start = findViewById(R.id.remiria_start);
        ImageView image_marisa_start = findViewById(R.id.marisa_start);*/
        /*Drawable Drawable_tiruno_start = getResources().getDrawable(R.drawable.tiruno_start);*/
        /*Drawable Drawable_remiria_start= getResources().getDrawable(R.drawable.remiria_start);*/
        /*Drawable Drawable_marisa_start = getResources().getDrawable(R.drawable.marisa_start);*/
        image_tiruno_start.setImageDrawable(Drawable_tiruno_start);
        image_remiria_start.setImageDrawable(Drawable_remiria_start);
        image_marisa_start.setImageDrawable(Drawable_marisa_start);

        if( stage == 1 ) {
            image_tiruno_start.setVisibility(View.VISIBLE);
            image_remiria_start.setVisibility(View.INVISIBLE);
            image_marisa_start.setVisibility(View.INVISIBLE);
        }else if(stage == 2) {
            image_tiruno_start.setVisibility(View.INVISIBLE);
            image_remiria_start.setVisibility(View.VISIBLE);
            image_marisa_start.setVisibility(View.INVISIBLE);
        }else if(stage == 3) {
            image_tiruno_start.setVisibility(View.INVISIBLE);
            image_remiria_start.setVisibility(View.INVISIBLE);
            image_marisa_start.setVisibility(View.VISIBLE);
        }

            //image_enemy.setImageDrawable(Drawable_enemy);



        /*ImageView image_reimu_win1 = findViewById(R.id.reimu_win1);*/
        //Drawable Drawable_reimu_win1 = getResources().getDrawable(R.drawable.reimu_win1);
        //image_reimu_win1.setImageDrawable(Drawable_reimu_win1);
        /*Bitmap bitmap_RW1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win1);*/
        /*Matrix matrix_reimu_win1 = new Matrix();*/
        matrix_reimu_win1.preScale(-1, 1);
        /*Bitmap bitmap_reimu_win1 = Bitmap.createBitmap(bitmap_RW1, 0, 0, bitmap_RW1.getWidth(), bitmap_RW1.getHeight(), matrix_reimu_win1, false);*/
        image_reimu_win1.setImageBitmap(bitmap_reimu_win1);
        image_reimu_win1.setVisibility(View.INVISIBLE);

        /*ImageView image_reimu_win2 = findViewById(R.id.reimu_win2);*/
        //Drawable Drawable_reimu_win2 = getResources().getDrawable(R.drawable.reimu_win2);
        //image_reimu_win2.setImageDrawable(Drawable_reimu_win2);
        /*Bitmap bitmap_RW2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win2);*/
        /*Matrix matrix_reimu_win2 = new Matrix();*/
        matrix_reimu_win2.preScale(-1, 1);
        /*Bitmap bitmap_reimu_win2 = Bitmap.createBitmap(bitmap_RW2, 0, 0, bitmap_RW2.getWidth(), bitmap_RW2.getHeight(), matrix_reimu_win2, false);*/
        image_reimu_win2.setImageBitmap(bitmap_reimu_win2);
        image_reimu_win2.setVisibility(View.INVISIBLE);

        /*ImageView image_reimu_win3 = findViewById(R.id.reimu_win3);*/
        //Drawable Drawable_reimu_win3 = getResources().getDrawable(R.drawable.reimu_win3);
        //image_reimu_win3.setImageDrawable(Drawable_reimu_win3);
        /*Bitmap bitmap_RW3 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win3);*/
        /*Matrix matrix_reimu_win3 = new Matrix();*/
        matrix_reimu_win3.preScale(-1, 1);
        /*Bitmap bitmap_reimu_win3 = Bitmap.createBitmap(bitmap_RW3, 0, 0, bitmap_RW3.getWidth(), bitmap_RW3.getHeight(), matrix_reimu_win3, false);*/
        image_reimu_win3.setImageBitmap(bitmap_reimu_win3);
        image_reimu_win3.setVisibility(View.INVISIBLE);


        /*ImageView image_tiruno_win = findViewById(R.id.tiruno_win);*/
        /*Drawable Drawable_tiruno_win = getResources().getDrawable(R.drawable.tiruno_win);*/
        image_tiruno_win.setImageDrawable(Drawable_tiruno_win);
        image_tiruno_win.setVisibility(View.INVISIBLE);

        /*ImageView image_tiruno_lose = findViewById(R.id.tiruno_lose);*/
        /*Drawable Drawable_tiruno_lose = getResources().getDrawable(R.drawable.tiruno_lose);*/
        image_tiruno_lose.setImageDrawable(Drawable_tiruno_lose);
        image_tiruno_lose.setVisibility(View.INVISIBLE);

        /*ImageView image_remiria_win = findViewById(R.id.remiria_win);*/
        /*Drawable Drawable_remiria_win = getResources().getDrawable(R.drawable.remiria_win);*/
        image_remiria_win.setImageDrawable(Drawable_remiria_win);
        image_remiria_win.setVisibility(View.INVISIBLE);

        /*ImageView image_remiria_lose = findViewById(R.id.remiria_lose);*/
        /*Drawable Drawable_remiria_lose = getResources().getDrawable(R.drawable.remiria_lose);*/
        image_remiria_lose.setImageDrawable(Drawable_remiria_lose);
        image_remiria_lose.setVisibility(View.INVISIBLE);

        /*ImageView image_marisa_win = findViewById(R.id.marisa_win);*/
        /*Drawable Drawable_marisa_win = getResources().getDrawable(R.drawable.marisa_win);*/
        image_marisa_win.setImageDrawable(Drawable_marisa_win);
        image_marisa_win.setVisibility(View.INVISIBLE);

        /*ImageView image_marisa_lose = findViewById(R.id.marisa_lose);*/
        /*Drawable Drawable_marisa_lose = getResources().getDrawable(R.drawable.marisa_lose);*/
        image_marisa_lose.setImageDrawable(Drawable_marisa_lose);
        image_marisa_lose.setVisibility(View.INVISIBLE);



        /*textView_timer = findViewById(R.id.timer);
        textView_timer.setText((zero));*/
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

            /*


                if( stage == 1 ) {
                    image_reimu_win1.setVisibility(View.VISIBLE);
                    image_reimu_start.setVisibility(View.INVISIBLE);
                    image_tiruno_start.setVisibility(View.INVISIBLE);
                    image_tiruno_lose.setVisibility(View.VISIBLE);
                }else if(stage == 2) {
                    image_reimu_win2.setVisibility(View.VISIBLE);
                    image_reimu_start.setVisibility(View.INVISIBLE);
                    image_remiria_start.setVisibility(View.INVISIBLE);
                    image_remiria_lose.setVisibility(View.VISIBLE);
                }else if(stage == 3) {
                    image_reimu_win3.setVisibility(View.VISIBLE);
                    image_reimu_start.setVisibility(View.INVISIBLE);
                    image_marisa_start.setVisibility(View.INVISIBLE);
                    image_marisa_lose.setVisibility(View.VISIBLE);
                }
                */

                stopButton.setVisibility(View.INVISIBLE);
                next_stage_Button.setVisibility(View.VISIBLE);
                next_stage_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count = 0;
                        line = random.nextInt(400)+500;

                        next_stage_Button.setVisibility(View.GONE);
                        stopButton.setVisibility(View.VISIBLE);
                        /*textView_result.setText((zero));
                        textView_action.setText((zero));*/
                        timer = new Timer();

                        timerTask = new CountUpTimerTask();

                        timer.schedule(timerTask, delay, period);

                        if( stage == 1) {
                            stage = 2;
                        /*  image_reimu_win1.setVisibility(View.INVISIBLE);
                            image_reimu_start.setVisibility(View.VISIBLE);
                            image_tiruno_lose.setVisibility(View.INVISIBLE);
                            image_remiria_start.setVisibility(View.VISIBLE);*/

                        } else if( stage == 2) {
                            stage = 3;
                            /*  image_reimu_win2.setVisibility(View.INVISIBLE);
                            image_reimu_start.setVisibility(View.VISIBLE);
                            image_remiria_lose.setVisibility(View.INVISIBLE);
                            image_marisa_start.setVisibility(View.VISIBLE);*/
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
                        /*textView_action.setText((zero));
                        textView_result.setText((zero));*/
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
                /*textView_timer.setText(String.format(Locale.US, "%1$02d", count));*/



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

                        /*


                    if( stage == 1 ) {
                        image_reimu_lose1.setVisibility(View.VISIBLE);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_tiruno_start.setVisibility(View.INVISIBLE);
                        image_tiruno_win.setVisibility(View.VISIBLE);
                    }else if(stage == 2) {
                        image_reimu_lose2.setVisibility(View.VISIBLE);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_remiria_start.setVisibility(View.INVISIBLE);
                        image_remiria_win.setVisibility(View.VISIBLE);
                    }else if(stage == 3) {
                        //image_reimu_lose3.setVisibility(View.VISIBLE);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_marisa_start.setVisibility(View.INVISIBLE);
                        image_marisa_win.setVisibility(View.VISIBLE);
                    }
                    */

                    /*back_Button.setVisibility(View.VISIBLE);
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
                    */
                }

            });
        }



    }

    public void onBackPressed() {

    }



}