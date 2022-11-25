package com.example.kusa_game;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Game5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);


        final TextView text = (TextView) findViewById(R.id.text);
        final TextView subtext = (TextView) findViewById(R.id.subtext);
        ImageButton rock = (ImageButton) findViewById(R.id.rock);
        ImageButton scissors = (ImageButton) findViewById(R.id.scissors);
        ImageButton paper = (ImageButton) findViewById(R.id.paper);

        //opponentHand 1  "rock"
        //opponentHand 2  "scissors"
        //opponentHand 3  "paper"
        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(1, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(2, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int opponentHand = decideOpponentHand();
                String opponentHandText = changeTextOpponentHand(opponentHand);
                decideGame(3, opponentHand, subtext);
                text.setText(opponentHandText);
            }
        });
    }

    String changeTextOpponentHand(int hand) {
        String handText = "a";
        if (hand == 1) handText = "グー";
        else if (hand == 2) handText = "チョキ";
        else if (hand == 3) handText = "パー";
        return handText;
    }

    int decideOpponentHand() {
        Random rnd = new Random();
        int hand = rnd.nextInt(3) + 1;
        return hand;
    }

    void decideGame(int playerHand, int opponentHand, TextView decidetext) {
        String decision;
        if (playerHand == opponentHand) decision = "あいこだよ！もう一度！";
        else if ((playerHand == 3 && opponentHand == 1) || (playerHand + 1 == opponentHand))
            decision = "やったね！勝ちだ！";
        else decision = "残念...負け";
        decidetext.setText(decision);

    }
}