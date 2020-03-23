package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
//                (findViewById(R.id.presidentQ)).setVisibility(View.INVISIBLE);
//                (findViewById(R.id.presidentA)).setVisibility(View.VISIBLE);
//                (findViewById(R.id.answer_1)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));
//                (findViewById(R.id.answer_2)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));
//                (findViewById(R.id.answer_3)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));

//                View answerSideView = findViewById(R.id.presidentA);
//                View questionSideView = findViewById(R.id.presidentQ);
//
//                // get the center for the clipping circle
//                int cx = answerSideView.getWidth() / 2;
//                int cy = answerSideView.getHeight() / 2;
//
//                // get the final radius for the clipping circle
//                float finalRadius = (float) Math.hypot(cx, cy);
//
//                // create the animator for this view (the start radius is zero)
//                Animator anim = ViewAnimationUtils.createCircularReveal(answerSideView, cx, cy, 0f, finalRadius);
//
//                // hide the question and show the answer to prepare for playing the animation!
//                questionSideView.setVisibility(View.INVISIBLE);
//                answerSideView.setVisibility(View.VISIBLE);
//
//                anim.setDuration(1000);
//                anim.start();

                findViewById(R.id.presidentQ).setCameraDistance(25000);
                findViewById(R.id.presidentA).setCameraDistance(25000);

                findViewById(R.id.presidentQ).animate()
                        .rotationY(90)
                        .setDuration(200)
                        .start();

                findViewById(R.id.presidentQ).animate()
                        .rotationY(90)
                        .setDuration(200)
                        .withEndAction(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        findViewById(R.id.presidentQ).setVisibility(View.INVISIBLE);
                                        findViewById(R.id.presidentA).setVisibility(View.VISIBLE);
                                        // second quarter turn
                                        findViewById(R.id.presidentA).setRotationY(-90);
                                        findViewById(R.id.presidentA).animate()
                                                .rotationY(0)
                                                .setDuration(200)
                                                .start();
                                    }
                                }
                        ).start();

            }
        });

        findViewById(R.id.presidentA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                (findViewById(R.id.presidentQ)).setVisibility(View.VISIBLE);
//                (findViewById(R.id.presidentA)).setVisibility(View.INVISIBLE);
//                (findViewById(R.id.answer_1)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));
//                (findViewById(R.id.answer_2)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));
//                (findViewById(R.id.answer_3)).setBackgroundColor(
//                        getResources().getColor(R.color.yellow));

                findViewById(R.id.presidentQ).setCameraDistance(25000);
                findViewById(R.id.presidentA).setCameraDistance(25000);

                findViewById(R.id.presidentA).animate()
                        .rotationY(90)
                        .setDuration(200)
                        .start();

                findViewById(R.id.presidentA).animate()
                        .rotationY(90)
                        .setDuration(200)
                        .withEndAction(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        findViewById(R.id.presidentA).setVisibility(View.INVISIBLE);
                                        findViewById(R.id.presidentQ).setVisibility(View.VISIBLE);
                                        // second quarter turn
                                        findViewById(R.id.presidentQ).setRotationY(-90);
                                        findViewById(R.id.presidentQ).animate()
                                                .rotationY(0)
                                                .setDuration(200)
                                                .start();
                                    }
                                }
                        ).start();

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
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
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
                String prevQ = allFlashcards.get(currentCardDisplayedIndex).getQuestion();
                String prevA = allFlashcards.get(currentCardDisplayedIndex).getAnswer();

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
                    final Animation leftOutAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_out);
                    final Animation rightInAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.right_in);
                    leftOutAnim.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            // this method is called when the animation first starts
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // this method is called when the animation is finished playing
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // we don't need to worry about this method
                        }
                    });
                    findViewById(R.id.presidentQ).startAnimation(leftOutAnim);
                    findViewById(R.id.presidentQ).startAnimation(rightInAnim);
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
