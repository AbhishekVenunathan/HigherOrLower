package com.abhishekvenunathan.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void guessFunction (View view){

        EditText guessText = findViewById(R.id.guessField);
        String guessNumberString = guessText.getText().toString();
        if(TextUtils.isEmpty(guessNumberString)||!TextUtils.isDigitsOnly(guessNumberString)){
            guessText.setError("Enter a valid number");
            return;
        }
        int guessNumber = Integer.parseInt(guessNumberString);

        if (guessNumber > randomNumber){
            Toast.makeText(getApplicationContext(),"Too high!",Toast.LENGTH_SHORT).show();
        }
        else if (guessNumber < randomNumber){
            Toast.makeText(getApplicationContext(),"Too low!",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
            randomGenerator();
        }


    }

    public void randomGenerator(){
        Random random = new Random();
        randomNumber = random.nextInt(21);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomGenerator();

    }
}
