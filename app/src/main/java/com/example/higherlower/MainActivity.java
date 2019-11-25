package com.example.higherlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    EditText mGuessInput;

    public void generateRandomNumber() {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }

    public void guess(View view) {
        Log.i("Info", Integer.toString(randomNumber));
        Log.i("Entered Value", mGuessInput.getText().toString());
        int guessValue = Integer.parseInt(mGuessInput.getText().toString());
        String message;
        if (guessValue > randomNumber) {
            message = "Lower";
        } else if (guessValue < randomNumber) {
            message = "Higher!";
        } else {
            message = "You got it!";
            generateRandomNumber();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGuessInput = findViewById(R.id.guess_et);
        generateRandomNumber();
    }

}
