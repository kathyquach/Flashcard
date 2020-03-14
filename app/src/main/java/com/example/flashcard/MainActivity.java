package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(this);
        allFlashcards = flashcardDatabase.getAllCards();

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

        flashcardDatabase = new FlashcardDatabase(getApplicationContext());
        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.presidentQ)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.presidentA)).setText(allFlashcards.get(0).getAnswer());
        }

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // advance our pointer index so we can show the next card
                currentCardDisplayedIndex++;

                // make sure we don't get an IndexOutOfBoundsError if we are viewing the last indexed card in our list
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }
                if (allFlashcards.size() == 0) {

                }
                else {
                    // set the question and answer TextViews with data from the database
                    ((TextView) findViewById(R.id.presidentQ)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                    ((TextView) findViewById(R.id.presidentA)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                    ((TextView) findViewById(R.id.presidentQ)).setTextColor(getResources().getColor(R.color.black));
                    ((TextView) findViewById(R.id.presidentA)).setTextColor(getResources().getColor(R.color.black));
                    findViewById(R.id.presidentQ).setBackgroundResource(R.drawable.question_background);
                    findViewById(R.id.presidentA).setBackgroundResource(R.drawable.answer_background);
                }
            }
        });


        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashcardDatabase.deleteCard(((TextView)findViewById(R.id.presidentQ)).getText().toString());
                allFlashcards = flashcardDatabase.getAllCards();
                currentCardDisplayedIndex++;
                if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                    currentCardDisplayedIndex = 0;
                }
                if (allFlashcards.size() == 0) {
                    ((TextView) findViewById(R.id.presidentQ)).setText("Add a card!");
                    ((TextView) findViewById(R.id.presidentA)).setText("Add a card!");
                    ((TextView) findViewById(R.id.presidentQ)).setTextColor(getResources().getColor(R.color.gray));
                    ((TextView) findViewById(R.id.presidentA)).setTextColor(getResources().getColor(R.color.gray));
                    findViewById(R.id.presidentQ).setBackgroundColor(getResources().getColor(R.color.lightBlue));
                    findViewById(R.id.presidentA).setBackgroundColor(getResources().getColor(R.color.lightBlue));
                }
                else {
                    ((TextView) findViewById(R.id.presidentQ)).setTextColor(getResources().getColor(R.color.black));
                    ((TextView) findViewById(R.id.presidentA)).setTextColor(getResources().getColor(R.color.black));
                    findViewById(R.id.presidentQ).setBackgroundResource(R.drawable.question_background);
                    findViewById(R.id.presidentA).setBackgroundResource(R.drawable.answer_background);
                    ((TextView) findViewById(R.id.presidentQ)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                    ((TextView) findViewById(R.id.presidentA)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                }
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
                    ((TextView) findViewById(R.id.presidentQ)).setTextColor(getResources().getColor(R.color.black));
                    ((TextView) findViewById(R.id.presidentA)).setTextColor(getResources().getColor(R.color.black));
                    findViewById(R.id.presidentQ).setBackgroundResource(R.drawable.question_background);
                    findViewById(R.id.presidentA).setBackgroundResource(R.drawable.answer_background);
                    ((TextView)findViewById(R.id.presidentQ)).setText(question);
                    ((TextView)findViewById(R.id.presidentA)).setText(answer);
                    flashcardDatabase.insertCard(new Flashcard(question, answer));
                }
            }
        }
    }

}
