package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.answer_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
                ((TextView)findViewById(R.id.answer_1)).setBackgroundColor(
                        getResources().getColor(R.color.incorrect));
            }
        });

        findViewById(R.id.answer_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
            }
        });

        findViewById(R.id.answer_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((TextView)findViewById(R.id.answer_2)).setBackgroundColor(
                        getResources().getColor(R.color.correct));
                ((TextView)findViewById(R.id.answer_3)).setBackgroundColor(
                        getResources().getColor(R.color.incorrect));
            }
        });

    }

}
