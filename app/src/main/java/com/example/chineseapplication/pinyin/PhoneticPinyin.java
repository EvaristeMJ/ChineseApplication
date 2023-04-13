package com.example.chineseapplication.pinyin;

/**
 * A class that represents a phonetic pinyin.
 * A phonetic pinyin is not always valid
 */
public class PhoneticPinyin {
    private String initialPinyin;
    private String finalPinyin;
    private String pinyin;
    private int tone;
    public PhoneticPinyin(String initialPinyin, String finalPinyin, int tone){
        this.initialPinyin = initialPinyin;
        this.finalPinyin = finalPinyin;
        this.tone = tone;
        this.pinyin = initialPinyin + finalPinyin;
    }
    @Override
    public String toString(){
        return pinyin;
    }
    public boolean isValid(){
        return PinyinUtil.isValidPinyin(pinyin);
    }
}
