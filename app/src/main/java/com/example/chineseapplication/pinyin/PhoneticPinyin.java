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
    private boolean valid;
    public PhoneticPinyin(String initialPinyin, String finalPinyin, int tone){
        this.initialPinyin = initialPinyin;
        this.finalPinyin = finalPinyin;
        this.tone = tone;
        this.pinyin = initialPinyin + finalPinyin;
        this.valid = PinyinUtil.isValidPinyin(pinyin);
    }
    @Override
    public String toString(){
        return pinyin;
    }
    public boolean isValid(){
        return valid;
    }
    public String getInitialPinyin() {
        return initialPinyin;
    }
}
