package com.example.chineseapplication.pinyin;

import java.util.ArrayList;

public class Pinyin {
    private final String pinyin;
    private final String[] translations;

    public Pinyin(String pinyin,String[] translations){
        this.pinyin = pinyin;
        this.translations = translations;
    }
    public String getPinyin(){
        return pinyin;
    }
    public String[] getTranslation(){
        return translations;
    }
    public void printTranslation(){
        System.out.println(pinyin);
        for(String translation : translations){
            System.out.println(translation);
        }
    }
}
