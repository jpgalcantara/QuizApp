package com.jpalcantara.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialize score for each question and total score
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Question 1. Only one radio button will be selected at a time. If the right radio button is selected you get 1 point.
    public void onRadioButtonClicked1(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioDrawing:
                if (checked)
                    score1 = 0;
                    break;
            case R.id.radioEating:
                if (checked)
                    score1 = 1;
                    break;
            case R.id.radioStirring:
                if (checked)
                    score1 = 0;
                break;
            case R.id.radioWriting:
                if (checked)
                    score1 = 0;
                break;
        }
    }

    //Question 3. When the right check boxes are selected you get 1 point.
    public void onCheckBoxSelected(View view) {
        CheckBox baseball = (CheckBox) findViewById(R.id.checkBoxBaseball);
        CheckBox basketball = (CheckBox) findViewById(R.id.checkBoxBasketball);
        CheckBox football = (CheckBox) findViewById(R.id.checkBoxFootball);
        CheckBox trackField = (CheckBox) findViewById(R.id.checkBoxTrackField);

        if ((baseball.isChecked() && football.isChecked()) && (!basketball.isChecked() && !trackField.isChecked()))  {
            score3 = 1;
        } else {
            score3 = 0;
        }

    }

    //Question 5. Only one radio button will be selected at a time. If the right radio button is selected you get 1 point.
    public void onRadioButtonClicked2(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioTrue:
                if (checked)
                    score5 = 1;
                break;
            case R.id.radioFalse:
                if (checked)
                    score5 = 0;
                break;
        }
    }

    //When Submit Answer button is clicked do the following
    public void onSubmitAnswersClicked(View view) {

        //Question 2. Initialize EditText
        EditText countryField = (EditText) findViewById(R.id.editTextCountry);
        String country = countryField.getText().toString().toLowerCase();

        //Question 2. Run method and pass the value of country
        secondAnswer(country);


        //Question 4. Initialize EditText
        EditText numberField = (EditText) findViewById(R.id.editTextNumber);
        String number = numberField.getText().toString();

        //Question 4. Run method and pass the number value
        fourthAnswer(number);


        //Method used to pass the scores of questions 1 to 5
        calculateScore(score1, score2, score3, score4, score5);

        //Toast message for total score
        if (totalScore == 5) {
            Toast toast = Toast.makeText(getApplicationContext(), "Great Job! You got the perfect score of " + totalScore + "!", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Your score is " + totalScore + " out of 5. Try again.", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    //Method to calculate totalScore
    private int calculateScore(int answer1, int answer2, int answer3, int answer4, int answer5) {
        totalScore = answer1 + answer2 + answer3 + answer4 + answer5;
        return totalScore;
    }

    //Question 2. If the right country is typed in, you get 1 point.
    private int secondAnswer(String country) {
        if (country.equals("japan")) {
            score2 = 1;
        } else {
            score2 = 0;
        }
        return score2;
    }

    //Question 4. If the right number is typed in, you get 1 point.
    private int fourthAnswer(String number) {
        if (number.equals("1000")) {
            score4 = 1;
        } else {
            score4 = 0;
        }
        return score4;
    }

}
