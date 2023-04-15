package com.example.chineseapplication;

import com.example.chineseapplication.pinyin.Pinyin;
import com.example.chineseapplication.pinyin.PinyinSearch;

import java.util.ArrayList;

public class SearchThread extends Thread{
    private String pinyin;
    private int nPinyin;
    private ArrayList<Pinyin> words;
    public SearchThread(String pinyin,int nPinyin){
        this.pinyin = pinyin;
        this.nPinyin = nPinyin;
    }
    @Override
    public void run(){
        PinyinSearch pinyinSearch = new PinyinSearch(pinyin,nPinyin);
        words = pinyinSearch.getWords();
        System.out.println(pinyin);
        System.out.println(words);
    }
    public ArrayList<Pinyin> getWords() {
        return words;
    }

}
