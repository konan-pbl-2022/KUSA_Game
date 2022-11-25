package com.example.kusa_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SubGame extends AppCompatActivity {

    //private MediaPlayer option1 = new MediaPlayer();
    private String filePath_start = "metal.mp3";
    private String filePath_wind = "wind.mp3";
    private String filePath_go = "go.mp3";
    private String filePath_shouka = "syouka.mp3";
    private String filePath_kori = "kori.mp3";
    private String filePath_zasyu = "zasyu.mp3";
    private String filePath_ou = "ou.mp3";
    private String filePath_tera = "tera.mp3";
    private String filePath_ko = "ko.mp3";
    private Timer timer;
    private CountUpTimerTask timerTask;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private TextView textView_timer, textView_result, textView_action, textView_end;
    private long delay, period, result, enemy;
    private long line, count;
    private int Dif, lose;
    private int stage;
    private String zero;
    private Random random = new Random();
    private MediaPlayer option_go = new MediaPlayer();
    private MediaPlayer option_wind = new MediaPlayer();
    private MediaPlayer option_kori = new MediaPlayer();
    private MediaPlayer option_zasyu = new MediaPlayer();
    private MediaPlayer option_tera = new MediaPlayer();





    @SuppressLint("MissingInflatedId")
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_sub_game);
        MediaPlayer option1 = new MediaPlayer();
        MediaPlayer option_shouka = new MediaPlayer();
        MediaPlayer option_ou = new MediaPlayer();
        MediaPlayer option_ko = new MediaPlayer();





        Intent intent = getIntent();

        Dif = intent.getIntExtra("difficulty", 1);

        stage = 1;
        delay = 0;
        period = 10;
        zero = getString(R.string.zero);

        ImageView imageView_game1 = findViewById(R.id.imageView_game1);
        imageView_game1.setImageResource(R.drawable.nc77380);


        ImageView image_kouma = findViewById(R.id.kouma);
        image_kouma.setImageResource(R.drawable.kouma);

        ImageView image_jinja = findViewById(R.id.jinja);
        image_jinja.setImageResource(R.drawable.jinja);


        ImageView image_reimu_start = findViewById(R.id.reimu_start);
        Drawable Drawable_reimu = getResources().getDrawable(R.drawable.reimu_start);
        image_reimu_start.setImageDrawable(Drawable_reimu);
        Bitmap bitmap_RS = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_start);
        Matrix matrix_reimu_start = new Matrix();
        matrix_reimu_start.preScale(-1, 1);
        Bitmap bitmap_reimu_start = Bitmap.createBitmap(bitmap_RS, 0, 0, bitmap_RS.getWidth(), bitmap_RS.getHeight(), matrix_reimu_start, false);
        image_reimu_start.setImageBitmap(bitmap_reimu_start);


        ImageView image_tiruno_start = findViewById(R.id.tiruno_start);
        ImageView image_remiria_start = findViewById(R.id.remiria_start);
        ImageView image_marisa_start = findViewById(R.id.marisa_start);
        Drawable Drawable_tiruno_start = getResources().getDrawable(R.drawable.tiruno_start);
        Drawable Drawable_remiria_start= getResources().getDrawable(R.drawable.remiria_start);
        Drawable Drawable_marisa_start = getResources().getDrawable(R.drawable.marisa_start);
        image_tiruno_start.setImageDrawable(Drawable_tiruno_start);
        image_remiria_start.setImageDrawable(Drawable_remiria_start);
        image_marisa_start.setImageDrawable(Drawable_marisa_start);

        if( stage == 1 ) {
            image_tiruno_start.setVisibility(View.VISIBLE);
            imageView_game1.setVisibility(View.VISIBLE);
            image_remiria_start.setVisibility(View.INVISIBLE);
            image_kouma.setVisibility(View.INVISIBLE);
            image_marisa_start.setVisibility(View.INVISIBLE);
            image_jinja.setVisibility(View.INVISIBLE);
        }else if(stage == 2) {
            image_tiruno_start.setVisibility(View.INVISIBLE);
            //imageView_game1.setVisibility(View.INVISIBLE);
            image_remiria_start.setVisibility(View.VISIBLE);
            //image_kouma.setVisibility(View.VISIBLE);
            image_marisa_start.setVisibility(View.INVISIBLE);
            //image_jinja.setVisibility(View.INVISIBLE);
        }else if(stage == 3) {
            image_tiruno_start.setVisibility(View.INVISIBLE);
            //imageView_game1.setVisibility(View.INVISIBLE);
            image_remiria_start.setVisibility(View.INVISIBLE);
            //image_kouma.setVisibility(View.INVISIBLE);
            image_marisa_start.setVisibility(View.VISIBLE);
            //image_jinja.setVisibility(View.VISIBLE);
        }


        ImageView image_reimu_lose1 = findViewById(R.id.reimu_lose1);
        Bitmap bitmap_RL1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose1);
        Matrix matrix_reimu_lose1 = new Matrix();
        Bitmap bitmap_reimu_lose1 = Bitmap.createBitmap(bitmap_RL1, 0, 0, bitmap_RL1.getWidth(), bitmap_RL1.getHeight(), matrix_reimu_lose1, false);
        matrix_reimu_lose1.preScale(-1, 1);
        image_reimu_lose1.setImageBitmap(bitmap_reimu_lose1);
        image_reimu_lose1.setVisibility(View.INVISIBLE);

        ImageView image_reimu_lose2 = findViewById(R.id.reimu_lose2);
        Bitmap bitmap_RL2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose2);
        Matrix matrix_reimu_lose2 = new Matrix();
        Bitmap bitmap_reimu_lose2 = Bitmap.createBitmap(bitmap_RL2, 0, 0, bitmap_RL2.getWidth(), bitmap_RL2.getHeight(), matrix_reimu_lose2, false);
        matrix_reimu_lose2.preScale(-1, 1);
        image_reimu_lose2.setImageBitmap(bitmap_reimu_lose2);
        image_reimu_lose2.setVisibility(View.INVISIBLE);

        ImageView image_reimu_lose3 = findViewById(R.id.reimu_lose3);
        Bitmap bitmap_RL3 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose3);
        Matrix matrix_reimu_lose3 = new Matrix();
        Bitmap bitmap_reimu_lose3 = Bitmap.createBitmap(bitmap_RL3, 0, 0, bitmap_RL3.getWidth(), bitmap_RL3.getHeight(), matrix_reimu_lose3, false);
        matrix_reimu_lose3.preScale(-1, 1);
        image_reimu_lose3.setImageBitmap(bitmap_reimu_lose3);
        image_reimu_lose3.setVisibility(View.INVISIBLE);

        ImageView image_reimu_win1 = findViewById(R.id.reimu_win1);
        Bitmap bitmap_RW1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win1);
        Matrix matrix_reimu_win1 = new Matrix();
        matrix_reimu_win1.preScale(-1, 1);
        Bitmap bitmap_reimu_win1 = Bitmap.createBitmap(bitmap_RW1, 0, 0, bitmap_RW1.getWidth(), bitmap_RW1.getHeight(), matrix_reimu_win1, false);
        image_reimu_win1.setImageBitmap(bitmap_reimu_win1);
        image_reimu_win1.setVisibility(View.INVISIBLE);

        ImageView image_reimu_win2 = findViewById(R.id.reimu_win2);
        Bitmap bitmap_RW2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win2);
        Matrix matrix_reimu_win2 = new Matrix();
        matrix_reimu_win2.preScale(-1, 1);
        Bitmap bitmap_reimu_win2 = Bitmap.createBitmap(bitmap_RW2, 0, 0, bitmap_RW2.getWidth(), bitmap_RW2.getHeight(), matrix_reimu_win2, false);
        image_reimu_win2.setImageBitmap(bitmap_reimu_win2);
        image_reimu_win2.setVisibility(View.INVISIBLE);

        ImageView image_reimu_win3 = findViewById(R.id.reimu_win3);
        Bitmap bitmap_RW3 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_win3);
        Matrix matrix_reimu_win3 = new Matrix();
        matrix_reimu_win3.preScale(-1, 1);
        Bitmap bitmap_reimu_win3 = Bitmap.createBitmap(bitmap_RW3, 0, 0, bitmap_RW3.getWidth(), bitmap_RW3.getHeight(), matrix_reimu_win3, false);
        image_reimu_win3.setImageBitmap(bitmap_reimu_win3);
        image_reimu_win3.setVisibility(View.INVISIBLE);


        ImageView image_tiruno_win = findViewById(R.id.tiruno_win);
        Drawable Drawable_tiruno_win = getResources().getDrawable(R.drawable.tiruno_win);
        image_tiruno_win.setImageDrawable(Drawable_tiruno_win);
        image_tiruno_win.setVisibility(View.INVISIBLE);

        ImageView image_tiruno_lose = findViewById(R.id.tiruno_lose);
        Drawable Drawable_tiruno_lose = getResources().getDrawable(R.drawable.tiruno_lose);
        image_tiruno_lose.setImageDrawable(Drawable_tiruno_lose);
        image_tiruno_lose.setVisibility(View.INVISIBLE);

        ImageView image_remiria_win = findViewById(R.id.remiria_win);
        Drawable Drawable_remiria_win = getResources().getDrawable(R.drawable.remiria_win);
        image_remiria_win.setImageDrawable(Drawable_remiria_win);
        image_remiria_win.setVisibility(View.INVISIBLE);

        ImageView image_remiria_lose = findViewById(R.id.remiria_lose);
        Drawable Drawable_remiria_lose = getResources().getDrawable(R.drawable.remiria_lose);
        image_remiria_lose.setImageDrawable(Drawable_remiria_lose);
        image_remiria_lose.setVisibility(View.INVISIBLE);

        ImageView image_marisa_win = findViewById(R.id.marisa_win);
        Drawable Drawable_marisa_win = getResources().getDrawable(R.drawable.marisa_win);
        image_marisa_win.setImageDrawable(Drawable_marisa_win);
        image_marisa_win.setVisibility(View.INVISIBLE);

        ImageView image_marisa_lose = findViewById(R.id.marisa_lose);
        Drawable Drawable_marisa_lose = getResources().getDrawable(R.drawable.marisa_lose);
        image_marisa_lose.setImageDrawable(Drawable_marisa_lose);
        image_marisa_lose.setVisibility(View.INVISIBLE);

        ImageView image_oharai = findViewById(R.id.oharai);
        Drawable Drawable_oharai = getResources().getDrawable(R.drawable.oharai);
        image_oharai.setImageDrawable(Drawable_oharai);
        image_oharai.setVisibility(View.INVISIBLE);

        Bitmap bitmap_T = BitmapFactory.decodeResource(getResources(), R.drawable.turuhasi);
        Matrix matrix_turuhasi = new Matrix();
        Bitmap bitmap_turuhasi = Bitmap.createBitmap(bitmap_T, 0, 0, bitmap_T.getWidth(), bitmap_T.getHeight(), matrix_turuhasi, false);
        ImageView image_turuhasi = findViewById(R.id.turuhasi);
        matrix_turuhasi.preScale(-1, 1);
        image_turuhasi.setImageBitmap(bitmap_turuhasi);
        image_turuhasi.setVisibility(View.INVISIBLE);

        ImageView image_hyouketu = findViewById(R.id.hyouketu);
        Drawable Drawable_hyouketu = getResources().getDrawable(R.drawable.hyouketu);
        image_hyouketu.setImageDrawable(Drawable_hyouketu);
        image_hyouketu.setVisibility(View.INVISIBLE);

        ImageView image_ti = findViewById(R.id.ti);
        Drawable Drawable_ti = getResources().getDrawable(R.drawable.ti);
        image_ti.setImageDrawable(Drawable_ti);
        image_ti.setVisibility(View.INVISIBLE);

        ImageView image_ti_2 = findViewById(R.id.ti_2);
        Drawable Drawable_ti_2 = getResources().getDrawable(R.drawable.ti_2);
        image_ti_2.setImageDrawable(Drawable_ti_2);
        image_ti_2.setVisibility(View.INVISIBLE);

        textView_end = findViewById(R.id.end_game);
        textView_end.setText((zero));
//        textView_timer = findViewById(R.id.timer);
//        textView_timer.setText((zero));
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


        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_start))
        {
            option1.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            option1.prepare();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


//        if( count == 100 ) {
//            option1.setLooping(true);
        option1.start();
//            option1.stop();
//            option1.reset();
//            // リソースの解放
//            option1.release();
//        }
//        if( count == 300 ) {
//            option1.stop();
//            option1.reset();
//            // リソースの解放
//            option1.release();
//        }


        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_wind))
        {
            option_wind.setDataSource(afdescripter.getFileDescriptor(),
                    afdescripter.getStartOffset(),
                    afdescripter.getLength());
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            option_wind.prepare();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        option_wind.start();


        Button stopButton = findViewById(R.id.stop_b);
        stopButton.setOnClickListener(v -> {

            timer.cancel();
            result = count;
            if( enemy > result && result >= line) {

                textView_result.setText("You win");
                option_wind.stop();
                option_wind.reset();
                option_go.stop();
                option_go.reset();

                if( stage == 1) {
                    try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_shouka))
                    {
                        option_shouka.setDataSource(afdescripter.getFileDescriptor(),
                                afdescripter.getStartOffset(),
                                afdescripter.getLength());
                        setVolumeControlStream(AudioManager.STREAM_MUSIC);
                        option_shouka.prepare();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    option_shouka.start();
                } else if( stage == 2 ) {
                    try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_ou))
                    {
                        option_ou.setDataSource(afdescripter.getFileDescriptor(),
                                afdescripter.getStartOffset(),
                                afdescripter.getLength());
                        setVolumeControlStream(AudioManager.STREAM_MUSIC);
                        option_ou.prepare();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    option_ou.start();
                }else if( stage == 3 ) {

                    try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_ko))
                    {
                        option_ko.setDataSource(afdescripter.getFileDescriptor(),
                                afdescripter.getStartOffset(),
                                afdescripter.getLength());
                        setVolumeControlStream(AudioManager.STREAM_MUSIC);
                        option_ko.prepare();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    option_ko.start();

                    count = 3000;

                    timer = new Timer();

                    timerTask = new CountUpTimerTask();

                    timer.schedule(timerTask, delay, period);

                }


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
                    stopButton.setVisibility(View.INVISIBLE);
                    textView_end.setText("また挑戦してね!");
                    image_reimu_win3.setVisibility(View.VISIBLE);
                    image_reimu_start.setVisibility(View.INVISIBLE);
                    image_oharai.setVisibility(View.VISIBLE);
                    image_marisa_start.setVisibility(View.INVISIBLE);
                    image_marisa_lose.setVisibility(View.VISIBLE);
                }


                stopButton.setVisibility(View.INVISIBLE);
                if( stage == 1 || stage == 2) {
                    next_stage_Button.setVisibility(View.VISIBLE);
                }
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
                            option1.start();
                            option_shouka.stop();

                            try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_wind))
                            {
                                option_wind.setDataSource(afdescripter.getFileDescriptor(),
                                        afdescripter.getStartOffset(),
                                        afdescripter.getLength());
                                setVolumeControlStream(AudioManager.STREAM_MUSIC);
                                option_wind.prepare();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            option_wind.start();

                            imageView_game1.setVisibility(View.INVISIBLE);
                            image_kouma.setVisibility(View.VISIBLE);
                            image_reimu_win1.setVisibility(View.INVISIBLE);
                            image_reimu_start.setVisibility(View.VISIBLE);
                            image_tiruno_lose.setVisibility(View.INVISIBLE);
                            image_remiria_start.setVisibility(View.VISIBLE);

                        } else if( stage == 2) {
                            stage = 3;
                            option1.start();
                            option_ou.stop();

                            try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_wind))
                            {
                                option_wind.setDataSource(afdescripter.getFileDescriptor(),
                                        afdescripter.getStartOffset(),
                                        afdescripter.getLength());
                                setVolumeControlStream(AudioManager.STREAM_MUSIC);
                                option_wind.prepare();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            option_wind.start();
                            image_kouma.setVisibility(View.INVISIBLE);
                            image_jinja.setVisibility(View.VISIBLE);
                            image_reimu_win2.setVisibility(View.INVISIBLE);
                            image_reimu_start.setVisibility(View.VISIBLE);
                            image_remiria_lose.setVisibility(View.INVISIBLE);
                            image_marisa_start.setVisibility(View.VISIBLE);

                        }
                    }
                });

            } else if ( result < line ) {
                textView_result.setText("仕切り直し");
                option_wind.stop();
                option_wind.reset();
                option_go.stop();
                option_go.reset();
                stopButton.setVisibility(View.INVISIBLE);
                back_Button.setVisibility(View.VISIBLE);
                back_Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        count = 0;
                        line = random.nextInt(400)+500;

                        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_wind))
                        {
                            option_wind.setDataSource(afdescripter.getFileDescriptor(),
                                    afdescripter.getStartOffset(),
                                    afdescripter.getLength());
                            setVolumeControlStream(AudioManager.STREAM_MUSIC);
                            option_wind.prepare();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        option_wind.start();

                        option1.start();

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


        ImageView image_reimu_start = findViewById(R.id.reimu_start);
        Bitmap bitmap_RS = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_start);
        Matrix matrix_reimu_start = new Matrix();
        Bitmap bitmap_reimu_start = Bitmap.createBitmap(bitmap_RS, 0, 0, bitmap_RS.getWidth(), bitmap_RS.getHeight(), matrix_reimu_start, false);


        ImageView image_reimu_lose1 = findViewById(R.id.reimu_lose1);
        Bitmap bitmap_RL1 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose1);
        Matrix matrix_reimu_lose1 = new Matrix();


        ImageView image_reimu_lose2 = findViewById(R.id.reimu_lose2);
        Bitmap bitmap_RL2 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose2);
        Matrix matrix_reimu_lose2 = new Matrix();


        ImageView image_reimu_lose3 = findViewById(R.id.reimu_lose3);
        Bitmap bitmap_RL3 = BitmapFactory.decodeResource(getResources(), R.drawable.reimu_lose3);
        Matrix matrix_reimu_lose3 = new Matrix();


        ImageView image_tiruno_start = findViewById(R.id.tiruno_start);

        ImageView image_hyouketu = findViewById(R.id.hyouketu);

        ImageView image_tiruno_win = findViewById(R.id.tiruno_win);

        ImageView image_remiria_start = findViewById(R.id.remiria_start);

        ImageView image_ti = findViewById(R.id.ti);

        ImageView image_remiria_win = findViewById(R.id.remiria_win);

        ImageView image_marisa_start = findViewById(R.id.marisa_start);

        ImageView image_ti_2 = findViewById(R.id.ti_2);

        ImageView image_marisa_win = findViewById(R.id.marisa_win);

        Bitmap bitmap_T = BitmapFactory.decodeResource(getResources(), R.drawable.turuhasi);
        Matrix matrix_turuhasi = new Matrix();
        ImageView image_turuhasi = findViewById(R.id.turuhasi);



        @Override

        public void run() {
            handler.post(() -> {
                count++;
//                textView_timer.setText(String.format(Locale.US, "%1$02d", count));



//                if( count == 100 ) {
//                    option1.setLooping(true);
//                    option1.start();
//                }
//
//                if( count == 300 ) {
//                    option1.stop();
//                    option1.reset();
//                    // リソースの解放
//                    option1.release();
//                option_wind.stop();
//                option_wind.reset();
//                }


                if( count == line-20 ) {
                    try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_go))
                    {
                        option_go.setDataSource(afdescripter.getFileDescriptor(),
                                afdescripter.getStartOffset(),
                                afdescripter.getLength());
                        setVolumeControlStream(AudioManager.STREAM_MUSIC);
                        option_go.prepare();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    option_go.start();
                }


//                option_wind.reset();

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

                    option_wind.stop();


                    if( stage == 1 ) {
                        lose = 1;
                    }else if(stage == 2) {
                        lose = 2;
                    }else if(stage == 3) {
                        lose = 3;
                    }

                    if( lose == 1 ) {
                        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_kori))
                        {
                            option_kori.setDataSource(afdescripter.getFileDescriptor(),
                                    afdescripter.getStartOffset(),
                                    afdescripter.getLength());
                            setVolumeControlStream(AudioManager.STREAM_MUSIC);
                            option_kori.prepare();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        option_kori.start();
                        matrix_reimu_lose1.preScale(-1, 1);
                        Bitmap bitmap_reimu_lose1 = Bitmap.createBitmap(bitmap_RL1, 0, 0, bitmap_RL1.getWidth(), bitmap_RL1.getHeight(), matrix_reimu_lose1, false);
                        image_reimu_lose1.setImageBitmap(bitmap_reimu_lose1);
                        image_reimu_lose1.setVisibility(View.VISIBLE);
                        image_reimu_start.setImageBitmap(bitmap_reimu_start);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_tiruno_start.setVisibility(View.INVISIBLE);
                        image_tiruno_win.setVisibility(View.VISIBLE);
                        image_hyouketu.setVisibility(View.VISIBLE);
                    }else if( lose == 2 ) {
                        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_zasyu))
                        {
                            option_zasyu.setDataSource(afdescripter.getFileDescriptor(),
                                    afdescripter.getStartOffset(),
                                    afdescripter.getLength());
                            setVolumeControlStream(AudioManager.STREAM_MUSIC);
                            option_zasyu.prepare();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        option_zasyu.start();
                        matrix_reimu_lose2.preScale(-1, 1);
                        Bitmap bitmap_reimu_lose2 = Bitmap.createBitmap(bitmap_RL2, 0, 0, bitmap_RL2.getWidth(), bitmap_RL2.getHeight(), matrix_reimu_lose2, false);
                        image_reimu_lose2.setImageBitmap(bitmap_reimu_lose2);
                        image_reimu_lose2.setVisibility(View.VISIBLE);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_remiria_start.setVisibility(View.INVISIBLE);
                        image_remiria_win.setVisibility(View.VISIBLE);
                        image_ti.setVisibility(View.VISIBLE);
                    }else if( lose == 3 ) {
                        try(AssetFileDescriptor afdescripter = getAssets().openFd(filePath_tera))
                        {
                            option_tera.setDataSource(afdescripter.getFileDescriptor(),
                                    afdescripter.getStartOffset(),
                                    afdescripter.getLength());
                            setVolumeControlStream(AudioManager.STREAM_MUSIC);
                            option_tera.prepare();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        option_tera.start();
                        matrix_reimu_lose3.preScale(-1, 1);
                        Bitmap bitmap_reimu_lose3 = Bitmap.createBitmap(bitmap_RL3, 0, 0, bitmap_RL3.getWidth(), bitmap_RL3.getHeight(), matrix_reimu_lose3, false);
                        image_reimu_lose3.setImageBitmap(bitmap_reimu_lose3);
                        image_reimu_lose3.setVisibility(View.VISIBLE);
                        image_reimu_start.setVisibility(View.INVISIBLE);
                        image_marisa_start.setVisibility(View.INVISIBLE);
                        image_marisa_win.setVisibility(View.VISIBLE);
                        matrix_turuhasi.preScale(-1, 1);
                        Bitmap bitmap_turuhasi = Bitmap.createBitmap(bitmap_T, 0, 0, bitmap_T.getWidth(), bitmap_T.getHeight(), matrix_turuhasi, false);
                        image_turuhasi.setImageBitmap(bitmap_turuhasi);
                        image_turuhasi.setVisibility(View.VISIBLE);
                        image_ti_2.setVisibility(View.VISIBLE);
                    }

                    if( lose == 1 || lose == 2 || lose == 3) {
                        count = 3000;
                        /*textView_end.setVisibility(View.INVISIBLE);
                        textView_end = findViewById(R.id.end_game);*/
                        Button stopButton = findViewById(R.id.stop_b);
                        stopButton.setVisibility(View.INVISIBLE);
                        textView_end.setText("もう一度挑戦してね!");

                        timer = new Timer();

                        timerTask = new CountUpTimerTask();

                        timer.schedule(timerTask, delay, period);
                    }


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
                    });*/

                }

                if( count == 3300 ) {
                    Intent intent_back = new Intent(SubGame.this,MainActivity.class);
                    intent_back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent_back.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent_back);
                }

            });
        }



    }

    public void onBackPressed() {

    }



}