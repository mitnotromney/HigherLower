package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    EditText mGuessInput;
    TextView mCorrectView;
    Button mButtonPress;
    String message;

    public void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void isPlaying() {
        mCorrectView.setVisibility(View.INVISIBLE);
        mButtonPress.setText("Guess");
    }

    public void hasWon() {
        mCorrectView.setVisibility(View.VISIBLE);
        mButtonPress.setText("Play Again!");
    }

    public void makeToast() {
        Toast toast = new Toast(getApplicationContext());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        toast.setGravity(Gravity.CENTER, 0,0);
    }

    public void guess(View view) {
        Log.i("Info", Integer.toString(randomNumber));

        if (!mGuessInput.getText().toString().equals("")) {

            int guessValue = Integer.parseInt(mGuessInput.getText().toString());

            if (guessValue > randomNumber) {
                message = "Lower";
                isPlaying();
            } else if (guessValue < randomNumber) {
                message = "Higher!";
                isPlaying();
            } else {
                hasWon();
                message = "You got it!";
                generateRandomNumber();
            }
        } else {
            message = "Please make a guess!";
        }
        makeToast();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuessInput = findViewById(R.id.guess_et);
        mCorrectView = findViewById(R.id.correct_tv);
        mButtonPress = findViewById(R.id.guess_bt);
        generateRandomNumber();
    }
}
