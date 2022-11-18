package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SubGame extends AppCompatActivity {
    private MediaPlayer option1 = new MediaPlayer();
    private String filePath_start = "金属ロゴ表示1.mp3";
    private Timer timer;
    private CountUpTimerTask timerTask;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private TextView textView_timer, textView_result, textView_action;
    private long count, delay, period, result, enemy, line;
    private int stage , Dif;
    private String zero;
    private Random random = new Random();



    @SuppressLint("MissingInflatedId")
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sub_game);

        Intent intent = getIntent();

        Dif = intent.getIntExtra("difficulty", 1);

        stage = 1;
        delay = 0;
        period = 10;
        zero = getString(R.string.zero);

        textView_timer = findViewById(R.id.timer);
        textView_timer.setText((zero));
        textView_result = findViewById(R.id.result_up);
        textView_result.setText((zero));
        textView_action = findViewById(R.id.action);
        textView_action.setText((zero));
        final Button next_stage_Button = findViewById(R.id.next);
        next_stage_Button.setVisibility(View.GONE);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final Button back_Button = findViewById(R.id.back);
        back_Button.setVisibility(View.GONE);

        line = random.nextInt(400) + 500;

        timer = new Timer();

        timerTask = new CountUpTimerTask();

        timer.schedule(timerTask, delay, period);

        try (AssetFileDescriptor afdescripter = getAssets().openFd(filePath_start)) {
            option1.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            option1.prepare();
            //fileCheck = true;
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        if (count == 100) {
            option1.setLooping(true);
            option1.start();
        }

        if (count == 300) {
            option1.stop();
            option1.reset();
            // リソースの解放
            option1.release();
        }
        //return fileCheck;
        //}










        /*Button startButton = findViewById(R.id.start_b);
        startButton.setOnClickListener(v -> {
            if (null != timer) {
                timer.cancel();
                timer = null;
            }

            timer = new Timer();

            timerTask = new CountUpTimerTask();

            timer.schedule(timerTask, delay, period);

            count = 0;
            textView_timer.setText(zero);
            timer.cancel();


        });*/
       /*if(stage == 1 ) {
            enemy = line + 500;
        } else if(stage == 2 ) {
            enemy = line +  300;
        } else  if(stage == 3 ){
            enemy = line +  50;
        }*/


       /* if(count >= enemy) {
            timer.cancel();
            textView_result.setText("敗北者");
        }*/


        final Button stopButton = findViewById(R.id.stop_b);
        stopButton.setOnClickListener(v -> {
            if (null != timer) {
                timer.cancel();
                result = count;
                if (enemy > result && result >= line) {
                    //textView2 = findViewById(R.id.result_up);

                    textView_result.setText("You win");
                    stopButton.setVisibility(View.INVISIBLE);
                    next_stage_Button.setVisibility(View.VISIBLE);
                    next_stage_Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            count = 0;
                            line = random.nextInt(400) + 500;
                            next_stage_Button.setVisibility(View.GONE);
                            stopButton.setVisibility(View.VISIBLE);
                            textView_result.setText((zero));
                            textView_action.setText((zero));
                            timer = new Timer();

                            timerTask = new CountUpTimerTask();

                            timer.schedule(timerTask, delay, period);

                            if (stage == 1) {
                                stage = 2;
                            } else if (stage == 2) {
                                stage = 3;
                            }
                        }
                    });

                } else if (result < line) {
                    textView_result.setText("仕切り直し");
                    stopButton.setVisibility(View.INVISIBLE);
                    back_Button.setVisibility(View.VISIBLE);
                    back_Button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            count = 0;
                            line = random.nextInt(400) + 500;
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
                //timer = null;
                //textView_timer.setText((zero));
                //}
            }


        });
    }



    class CountUpTimerTask extends TimerTask {
        Button back_Button = findViewById(R.id.back);


        @Override


        public void run() {
            handler.post(() -> {
                count++;
                /*long mm = count*100 / 1000 / 60;
                long ss = count*100 / 1000 % 60;
                long ms = (count*100 - ss * 1000 - mm * 1000 * 60)/100;
                textView_timer.setText(String.format(Locale.US, "%1$02d:%2$02d.%3$01d", mm, ss, ms));*/
                textView_timer.setText(String.format(Locale.US, "%1$02d", count));



                if( count == 100 ) {
                    option1.setLooping(true);
                    option1.start();
                }

                if( count == 300 ) {
                    option1.stop();
                    option1.reset();
                    // リソースの解放
                    option1.release();
                }

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