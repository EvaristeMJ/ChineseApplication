package com.example.chineseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chineseapplication.pinyin.PhoneticPinyin;
import com.example.chineseapplication.pinyin.PinyinUtil;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private PhoneticPinyin pinyin;
    private MaterialButton trueButton;
    private MaterialButton falseButton;
    private TextView pinyinTextView;
    private static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pinyin = PinyinUtil.createRandomPhoneticPinyin();
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        pinyinTextView = findViewById(R.id.pinyinText);
        pinyinTextView.setText(pinyin.toString());
        setListeners();
    }
    private void onCorrect(){
        showToast("Correct!");
        score++;
    }
    private void onIncorrect(){
        showToast("Incorrect!");
    }
    private void setListeners(){
        trueButton.setOnClickListener(v -> {
            if(pinyin.isValid()){
                onCorrect();
            }
            else{
                onIncorrect();
            }
            nextPinyin();
        });
        falseButton.setOnClickListener(v -> {
            if(!pinyin.isValid()){
                onCorrect();
            }
            else{
                onIncorrect();
            }
            nextPinyin();
        });
    }
    private void nextPinyin(){
        pinyin = PinyinUtil.createRandomPhoneticPinyin();
        pinyinTextView.setText(pinyin.toString());
    }
    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}