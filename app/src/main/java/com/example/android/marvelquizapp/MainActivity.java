package com.example.android.marvelquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int CorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Check Answer
    public void submitQuestions(View view) {

        CorrectAnswers = 0;

        if (this.cAnswerQ1()) {
            CorrectAnswers++;
        }
        if (this.cAnswerQ2()) {
            CorrectAnswers++;
        }
        if (this.cAnswerQ3()) {
            CorrectAnswers++;
        }
        if (this.cAnswerQ4()) {
            CorrectAnswers++;
        }
        if (this.cAnswerQ5()) {
            CorrectAnswers++;
        }

        this.showToastResult(CorrectAnswers);
    }

    //Q1
    public boolean cAnswerQ1() {
        return ((RadioButton) findViewById(R.id.Q1B3)).isChecked();
    }

    public void resetQ1() {
        ((RadioGroup) findViewById(R.id.rb1)).clearCheck();
    }

    //Q2
    public boolean cAnswerQ2() {
        return ((RadioButton) findViewById(R.id.Q2B2)).isChecked();
    }

    public void resetQ2() {
        ((RadioGroup) findViewById(R.id.rb2)).clearCheck();
    }

    //Q3
    public boolean cAnswerQ3() {
        String answer = ((EditText) findViewById(R.id.Q3A)).getText().toString();
        return answer.contains("Robert Downey Jr.");
    }

    public void resetQ3() {
        ((EditText) findViewById(R.id.Q3A)).setText("");
    }

    //Q4
    public boolean cAnswerQ4() {
        return (((CheckBox) findViewById(R.id.Q4CB1)).isChecked() &&
                ((CheckBox) findViewById(R.id.Q4CB2)).isChecked() &&
                !((CheckBox) findViewById(R.id.Q4CB3)).isChecked() &&
                ((CheckBox) findViewById(R.id.Q4CB4)).isChecked() &&
                ((CheckBox) findViewById(R.id.Q4CB5)).isChecked() &&
                ((CheckBox) findViewById(R.id.Q4CB6)).isChecked() &&
                ((CheckBox) findViewById(R.id.Q4CB7)).isChecked());
    }

    public void resetQ4() {
        ((CheckBox) findViewById(R.id.Q4CB1)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB2)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB3)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB4)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB5)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB6)).setChecked(false);
        ((CheckBox) findViewById(R.id.Q4CB7)).setChecked(false);
    }

    //Q5
    public boolean cAnswerQ5() {
        return ((RadioButton) findViewById(R.id.Q5B1)).isChecked();
    }

    public void resetQ5() {
        ((RadioGroup) findViewById(R.id.rb5)).clearCheck();
    }

    //Message
    public void showToastResult(int CorrectAnswers) {

        if (CorrectAnswers == 5) {
            Toast.makeText(this, getString(R.string.score) + " " + CorrectAnswers + "/5. " + getString(R.string.congratulations), Toast.LENGTH_SHORT).show();
        } else if (CorrectAnswers < 3) {
            Toast.makeText(this, getString(R.string.score) + " " + CorrectAnswers + "/5. " + getString(R.string.better), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.score) + " " + CorrectAnswers + "/5. " + getString(R.string.close), Toast.LENGTH_SHORT).show();
        }
    }

    //Reset
    public void resetQuestions(View view) {
        resetQ1();
        resetQ2();
        resetQ3();
        resetQ4();
        resetQ5();
    }
}