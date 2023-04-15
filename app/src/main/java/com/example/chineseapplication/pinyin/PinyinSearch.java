package com.example.chineseapplication.pinyin;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class PinyinSearch {
    private String url = "https://www.mdbg.net/chinese/dictionary?page=worddict&wdrst=0&wdqb=";
    private HttpURLConnection connection;
    private int nPinyin;
    public PinyinSearch(String pinyin,int nPinyin){
        this.nPinyin = nPinyin;
        try {
            String getQuery = "p%3A" + pinyin;
            connection = (HttpURLConnection) new URL(this.url + getQuery).openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // get the words from the website (Really ugly code but it works)
    public ArrayList<Pinyin> getWords(){
        ArrayList<Pinyin> words = new ArrayList<>();
        String content = "";
        try {
            InputStream inputStream = connection.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while((length = inputStream.read(buffer)) != -1){
                content = content + new String(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(content.length());
        for(int i = 0; i < nPinyin; i++){
            int index = content.indexOf("<div class=\"pinyin\" title=\"Mandarin Pinyin");
            if(index == -1){
                break;
            }
            content = content.substring(index);
            String temp = content.substring(0,content.indexOf("</a>") + 1);
            String word = "";
            while(temp.contains("<span class=\"")){
                temp = temp.substring(temp.indexOf("<span class=\"") + 1);
                word = word + temp.substring(temp.indexOf(">") + 1, temp.indexOf("</span>"));
            }
            content = content.substring(content.indexOf("</a>") + 1);
            content = content.substring(content.indexOf("<div class=\"defs\">") + 1);
            content = content.substring(17);
            String temp2 = content.substring(0, content.indexOf("</div>"));
            String[] definitions = temp2.split("<strong>/</strong>");
            if(!definitions[0].contains("<a class=\"word\" title=\"Lookup word\" href=\"dictionary?wdqr")) {
                Pinyin pinyin = new Pinyin(word, definitions);
                words.add(pinyin);
            }
        }
        ArrayList<Pinyin> resWords = new ArrayList<>();
        for(int i = 0; i < Integer.min(words.size(),nPinyin); i++){
            int random = (int) (Math.random() * words.size());
            // make sure that the word is not already in the list
            while(resWords.contains(words.get(random))){
                random = (int) (Math.random() * words.size());
            }
            resWords.add(words.get(random));
        }
        System.out.println(resWords);
        return resWords;
    }
}
