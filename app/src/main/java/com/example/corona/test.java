package com.example.corona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class test extends AppCompatActivity {

    TextView header;
    TextView question;
    Button True;
    Button False;
    int i = 0;
    private String[] questions;
    private int answer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questions = getResources().getStringArray(R.array.test_Q);
        header = findViewById(R.id.header);
        question = findViewById(R.id.question_text_view);
        question.setText(questions[i]);
        True = findViewById(R.id.true_button);
        False = findViewById(R.id.false_button);


    }

    public void both() {
        if (i < questions.length - 1) {
            i += 1;

            header.setText("Question" + i + "/" + questions.length);
            question.setText(questions[i]);
            return;
        } else {
            if (answer >= 6) {
                header.setText("You Have High Risk of Infection.");
                header.setGravity(Gravity.CENTER);


            } else {
                header.setText("Risk of Infetion is unlikely");
            }
            question.setText("");
            True.setVisibility(View.INVISIBLE);
            False.setVisibility(View.INVISIBLE);

        }
    }

    public void right(View view) {
        if (i == 1) {
            answer += (i + 3);
            both();
            return;
        }
        answer += (i + 1);
        both();
    }

    public void wrong(View view) {
        both();
    }
}
