package com.example.chineseapplication.pinyin;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class DatabaseHelper {
    FirebaseFirestore db;
    public DatabaseHelper(FirebaseFirestore db){
        this.db = db;
    }
    public ArrayList<Pinyin> getPinyinExamples(String pinyin){
        ArrayList<Pinyin> pinyins = new ArrayList<>();
        System.out.print(pinyin);
        // get pinyin examples from firebase
        db.collection("PinyinExamples").document(pinyin).collection("examples").get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                for(com.google.firebase.firestore.QueryDocumentSnapshot document : task.getResult()){
                    String pinyin1 = document.getString("pinyin");
                    String translation = document.getString("translation");
                    String[] translations = {translation};
                    Pinyin pinyin2 = new Pinyin(pinyin1,translations);
                    pinyins.add(pinyin2);
                    System.out.println(pinyins);
                }
            }
        });
        return pinyins;
    }
}
