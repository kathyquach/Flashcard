package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.presidentQ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.presidentQ)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.presidentA)).setVisibility(View.VISIBLE);
                (findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
            }
        });

        findViewById(R.id.presidentA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.presidentQ)).setVisibility(View.VISIBLE);
                (findViewById(R.id.presidentA)).setVisibility(View.INVISIBLE);
                (findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
            }
        });

        findViewById(R.id.answer_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.incorrect));
                (findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
                (findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
            }
        });

        findViewById(R.id.answer_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
                (findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
            }
        });

        findViewById(R.id.answer_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                (findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.yellow));
                (findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
                (findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.incorrect));
            }
        });

        findViewById(R.id.add_card).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String question = data.getExtras().getString("string1");
                    String answer = data.getExtras().getString("string2");
                    ((TextView)findViewById(R.id.presidentQ)).setText(question);
                    ((TextView)findViewById(R.id.presidentA)).setText(answer);
                    findViewById(R.id.answer_1).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_2).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);
                }
            }
        }
    }

}
