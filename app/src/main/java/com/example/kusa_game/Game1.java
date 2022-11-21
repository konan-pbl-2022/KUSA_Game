package com.example.kusa_game;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class Game1 extends AppCompatActivity {
    private int difficulty_m;
    private MediaPlayer bgm = new MediaPlayer();
    private String filePath = "魔王魂  イベント24.mp3";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);


            //private boolean audioSetup(){

            //boolean fileCheck = false;

            try (AssetFileDescriptor afdescripter = getAssets().openFd(filePath)) {
                bgm.setDataSource(afdescripter.getFileDescriptor(),
                        afdescripter.getStartOffset(),
                        afdescripter.getLength());
                setVolumeControlStream(AudioManager.STREAM_MUSIC);
                bgm.prepare();
                //fileCheck = true;
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            //return fileCheck;
            //}

            bgm.setLooping(true);
            bgm.start();

            TextView textView = findViewById(R.id.iai);
            textView.setText("見切れ!!居合道");

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(R.drawable.nc77895);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);


            Button Button_easy = (Button) findViewById(R.id.easy);
            Button_easy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioStop();
                    Intent intent = new Intent(Game1.this, SubGame.class);
                    startActivity(intent);
                    intent.putExtra("difficulty", 1);
                }
            });

            Button Button_normal = (Button) findViewById(R.id.normal);
            Button_normal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioStop();
                    Intent intent = new Intent(Game1.this, SubGame.class);
                    intent.putExtra("difficulty", 2);
                    startActivity(intent);
                }
            });


            Button Button_hard = (Button) findViewById(R.id.hard);
            Button_hard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    audioStop();
                    Intent intent = new Intent(Game1.this, SubGame.class);
                    intent.putExtra("difficulty", 3);
                    startActivity(intent);
                }
            });

            /*Button Button_exit = (Button) findViewById(R.id.exit);
            Button_exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent_back_main = new Intent(Game1.this,MainActivity.class);
                    intent_back_main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent_back_main.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent_back_main);
                }
            });*/




    }
        private void audioStop() {
            // 再生終了
            bgm.stop();
            // リセット
            bgm.reset();
            // リソースの解放
            bgm.release();
            bgm = null;
        }

        public void onBackPressed() {

        }

}