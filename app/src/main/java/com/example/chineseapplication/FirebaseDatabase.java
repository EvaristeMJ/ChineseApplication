package com.example.chineseapplication;

import com.example.chineseapplication.pinyin.Pinyin;
import com.example.chineseapplication.pinyin.PinyinSearch;
import com.example.chineseapplication.pinyin.PinyinUtil;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabase {
    private FirebaseFirestore db;
    public FirebaseDatabase(FirebaseFirestore db){
        this.db = db;
        createPinyinExamplesFile();
    }
    public void createPinyinExamplesFile(){
        String[][] validPinyin = PinyinUtil.phoneticPinyinValid;
        for(int i = 0; i < validPinyin.length;i++){
            for(int j = 0; j < validPinyin[i].length;j++) {
                String pinyin = validPinyin[i][j];
                SearchThread searchThread = new SearchThread(pinyin,2);
                searchThread.start();
                ArrayList<Pinyin> pinyins = new ArrayList<>();
                try {
                    searchThread.join();
                    pinyins = searchThread.getWords();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(pinyins);
                String line = "";
                for (Pinyin pinyin1 : pinyins) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("pinyin", pinyin1.getPinyin());
                    map.put("translation", pinyin1.getTranslation()[0]);
                    System.out.println(pinyin1.getPinyin());
                    db.collection("PinyinExamples").document(pinyin).collection("examples").document(pinyin1.getPinyin()).set(map);
                }
            }
        }
    }
}
