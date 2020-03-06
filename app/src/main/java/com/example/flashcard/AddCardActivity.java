package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textQ = ((EditText)findViewById(R.id.editTextQ)).getText().toString();
                String textA = ((EditText)findViewById(R.id.editTextA)).getText().toString();
                Intent data = new Intent();
                data.putExtra("string1", textQ);
                data.putExtra("string2", textA);
                setResult(RESULT_OK, data);
                finish();
            }
        });

    }
}
