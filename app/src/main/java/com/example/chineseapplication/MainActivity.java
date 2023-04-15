package com.example.chineseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chineseapplication.pinyin.PhoneticPinyin;
import com.example.chineseapplication.pinyin.PinyinUtil;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private PhoneticPinyin pinyin;
    private MaterialButton trueButton;
    private MaterialButton falseButton;
    private MaterialButton nextButton;
    private TextView pinyinTextView;
    private TextView scoreTextView;
    private TextView informationTextView;
    private static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showToast("TEST");
        setContentView(R.layout.activity_main);
        pinyin = PinyinUtil.createRandomPhoneticPinyin();
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.nextButton);
        nextButton.setVisibility(MaterialButton.INVISIBLE);
        nextButton.setEnabled(false);
        pinyinTextView = findViewById(R.id.pinyinText);
        pinyinTextView.setText(pinyin.toString());
        scoreTextView = findViewById(R.id.scoreText);
        informationTextView = findViewById(R.id.informationText);
        informationTextView.setText("Is this a valid pinyin ?");
        setListeners();
    }
    private void onCorrect(){
        showToast("Correct!");
        score++;
        scoreTextView.setText("Score: " + score);
        resultState();
    }
    private void onIncorrect(){
        showToast("Incorrect!");
        resultState();
    }
    private void setListeners(){
        trueButton.setOnClickListener(v -> {
            if(pinyin.isValid()){
                onCorrect();
            }
            else{
                onIncorrect();
            }
        });
        falseButton.setOnClickListener(v -> {
            if(!pinyin.isValid()){
                onCorrect();
            }
            else{
                onIncorrect();
            }
        });
        nextButton.setOnClickListener(v -> {
            nextPinyin();
        });

    }
    private void nextPinyin(){
        pinyin = PinyinUtil.createRandomPhoneticPinyin();
        pinyinTextView.setText(pinyin.toString());
        trueButton.setEnabled(true);
        trueButton.setVisibility(MaterialButton.VISIBLE);
        falseButton.setEnabled(true);
        falseButton.setVisibility(MaterialButton.VISIBLE);
        nextButton.setEnabled(false);
        nextButton.setVisibility(MaterialButton.INVISIBLE);
        informationTextView.setText("Is this a valid pinyin ?");
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void resultState(){
        falseButton.setEnabled(false);
        falseButton.setVisibility(MaterialButton.INVISIBLE);
        trueButton.setEnabled(false);
        trueButton.setVisibility(MaterialButton.INVISIBLE);
        nextButton.setEnabled(true);
        nextButton.setVisibility(MaterialButton.VISIBLE);
        if(pinyin.isValid())
            informationTextView.setText("Example : TODO add research to find example" );
        else {
            informationTextView.setText("Valid pinyin for this initial :\n");
            String[] validPinyin = PinyinUtil.getValidPinyinForInitial(pinyin.getInitialPinyin());
            for (String pinyin : validPinyin) {
                informationTextView.append(pinyin + ",");
            }
        }
    }
}