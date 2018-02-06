package com.example.android.funquiztwo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.graphics.Typeface.BOLD_ITALIC;
import static android.graphics.Typeface.NORMAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {

        //First answer result
        EditText Answer1 = findViewById(R.id.Answer1);
        String Answer1Value = Answer1.getText().toString().toUpperCase();


        //Second answer result
        RadioGroup Answer2 = findViewById(R.id.Answer2);
        int Answer2Value = Answer2.getCheckedRadioButtonId();

        //Third answer result
        RadioGroup Answer3 = findViewById(R.id.Answer3);
        int Answer3Value = Answer3.getCheckedRadioButtonId();

        //Forth answer result
        RadioGroup Answer4 = findViewById(R.id.Answer4);
        int Answer4Value = Answer4.getCheckedRadioButtonId();

        //Forth answer result
        RadioGroup Answer5 = findViewById(R.id.Answer5);
        int Answer5Value = Answer5.getCheckedRadioButtonId();

        //calculate the total score
        int score = calculateScore(Answer1Value, Answer2Value, Answer3Value, Answer4Value, Answer5Value);

        //Display total score
        displayMessage(score);
        dismissKeyboard(Answer1);
    }

    //hide keyboard
    public void dismissKeyboard(EditText Answer1) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(Answer1.getWindowToken(), 0);
    }

    //Display on screen
    public void displayMessage(int message) {
        String message1 = String.valueOf(message);
        message1 = getString(R.string.your_score_is ) + message1 + "\n" + resultsBack();
        Toast toast = Toast.makeText(this, message1, Toast.LENGTH_LONG);
        toast.show();
    }

    //Getting the radio button id
    public String getRadioButtonAnswer(int radioButtonId) {

        RadioButton radioButtonAnswer2 = findViewById(radioButtonId);
        if (radioButtonAnswer2 != null) {
            return radioButtonAnswer2.getText().toString();

        }
        return "";
    }

    //Getting answers for feedback
    public boolean isCheckBoxAnswer(int resourceID) {
        CheckBox checkbox = findViewById(resourceID);
        return checkbox.isChecked();
    }

    //Feedback message for feedback
    public String resultsBack() {
        if (isCheckBoxAnswer(R.id.CheckBoxAns1)
                || isCheckBoxAnswer(R.id.CheckBoxAns2)
                || isCheckBoxAnswer(R.id.CheckBoxAns3)
                || isCheckBoxAnswer(R.id.CheckBoxAns4)) {
            if (isCheckBoxAnswer(R.id.CheckBoxAns1)
                    && isCheckBoxAnswer(R.id.CheckBoxAns2)
                    && isCheckBoxAnswer(R.id.CheckBoxAns3)
                    && isCheckBoxAnswer(R.id.CheckBoxAns4)) {
                return getString(R.string.thank_you );
            } else {
                return getString(R.string.thanks);
            }
        } else {
            return getString(R.string.really);
        }

    }

    //Every correct answer is 1 point. Calculates the total score
    public int calculateScore(String answer1, int selectedRadioButton2, int selectedRadioButton3, int selectedRadioButton4, int selectedRadioButton5) {

        String radioButtonAnswer2Text = getRadioButtonAnswer(selectedRadioButton2);
        String radioButtonAnswer3Text = getRadioButtonAnswer(selectedRadioButton3);
        String radioButtonAnswer4Text = getRadioButtonAnswer(selectedRadioButton4);
        String radioButtonAnswer5Text = getRadioButtonAnswer(selectedRadioButton5);

        int score = 0;
        answer1 = answer1.trim();
        if (answer1.equals(getString(R.string.NAME)) || (answer1.equals(getString(R.string.Name))) || (answer1.equals(getString(R.string.namee)))) {
            score = increaseScore(score, 1);
        }

        if (radioButtonAnswer2Text.equals(getString(R.string.fortytwo))) {
            score = increaseScore(score, 1);
        }
        if (radioButtonAnswer3Text.equals(getString(R.string.We_dont_do_functions))) {
            score = increaseScore(score, 1);
        }
        if (radioButtonAnswer4Text.equals(getString(R.string.They_make_up_everything))) {
            score = increaseScore(score, 1);

            if (radioButtonAnswer5Text.equals(getString(R.string.Shh)))
                score = increaseScore(score, 1);

        }

        return score;
    }

    public void onRadioButtonClicked(View v) {
        //require to import the RadioButton class
        RadioButton rb1 = findViewById(R.id.Radio_Button_One);
        RadioButton rb2 = findViewById(R.id.Radio_Button_Two);
        RadioButton rb3 = findViewById(R.id.Radio_Button_Three);
        RadioButton rb4 = findViewById(R.id.Radio_Button_Four);

        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.Radio_Button_One:
                if (checked)
                    //if button one is selected
                    //set the checked radio button's text style bold italic
                    rb1.setTypeface(null, BOLD_ITALIC);
                //include toast message
                Toast.makeText(this, R.string.Well_thats, Toast.LENGTH_SHORT).show();
                //set the other three radio buttons text style to default
                rb2.setTypeface(null, NORMAL);
                // reqire to import Typeface class
                rb3.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);
                break;

            case R.id.Radio_Button_Two:
                if (checked)
                    //if button two is selected
                    //set the checked radio button's text style bold italic
                    rb2.setTypeface(null, BOLD_ITALIC);
                //include toast message
                Toast.makeText(this, R.string.Stop, Toast.LENGTH_SHORT).show();
                //set the other three radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb3.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);


                break;

            case R.id.Radio_Button_Three:
                if (checked)
                    //if button three is selected
                    //set the checked radio button's text style bold italic
                    rb3.setTypeface(null, BOLD_ITALIC);
                // include toast message
                Toast.makeText(this, R.string.When_was, Toast.LENGTH_SHORT).show();
                //set the other three radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb2.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);
                break;

            case R.id.Radio_Button_Four:
                if (checked)
                    //if button four is selected
                    //set the checked radio button's text style bold italic
                    rb4.setTypeface(null, BOLD_ITALIC);
                //include toast
                Toast.makeText(this, R.string.May_i, Toast.LENGTH_SHORT).show();
                //set the other two radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb2.setTypeface(null, NORMAL);
                rb3.setTypeface(null, NORMAL);
                break;
        }
    }

    public void onRadioButtonClickedA(View v) {
        //require to import the RadioButton class
        RadioButton rb1 = findViewById(R.id.Radio_Button_OneA);
        RadioButton rb2 = findViewById(R.id.Radio_Button_TwoA);
        RadioButton rb3 = findViewById(R.id.Radio_Button_ThreeA);
        RadioButton rb4 = findViewById(R.id.Radio_Button_FourA);

        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.Radio_Button_OneA:
                if (checked)
                    //if button one is selected
                    //set the checked radio button's text style bold italic
                    rb1.setTypeface(null, BOLD_ITALIC);
                //include toast message
                Toast.makeText(this, R.string.Thanks_for_the_support, Toast.LENGTH_SHORT).show();
                //set the other three radio buttons text style to default
                rb2.setTypeface(null, NORMAL);
                // reqire to import Typeface class
                rb3.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);
                break;

            case R.id.Radio_Button_TwoA:
                if (checked)
                    //if button two is selected
                    //set the checked radio button's text style bold italic
                    rb2.setTypeface(null, BOLD_ITALIC);
                //include toast message
                Toast.makeText(this, R.string.Yoda, Toast.LENGTH_SHORT).show();
                //set the other two radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb3.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);


                break;

            case R.id.Radio_Button_ThreeA:
                if (checked)
                    //if button three is selected
                    //set the checked radio button's text style bold italic
                    rb3.setTypeface(null, BOLD_ITALIC);
                // include toast message
                Toast.makeText(this, R.string.Hope, Toast.LENGTH_SHORT).show();
                //set the other two radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb2.setTypeface(null, NORMAL);
                rb4.setTypeface(null, NORMAL);
                break;

            case R.id.Radio_Button_FourA:
                if (checked)
                    //if button four is selected
                    //set the checked radio button's text style bold italic
                    rb4.setTypeface(null, BOLD_ITALIC);
                //include toast
                Toast.makeText(this, R.string.Post_man, Toast.LENGTH_SHORT).show();
                //set the other two radio buttons text style to default
                rb1.setTypeface(null, NORMAL);
                rb2.setTypeface(null, NORMAL);
                rb3.setTypeface(null, NORMAL);

                break;
        }
    }

    //increase the total score
    private int increaseScore(int score, int addUp) {
        score = score + addUp;
        return score;
    }
}
