package com.example.chineseapplication.pinyin;

/**
 * A class that represents a phonetic pinyin.
 * A phonetic pinyin is not always valid
 */
public class PhoneticPinyin {
    private String initialPinyin;
    private String finalPinyin;
    private String pinyin;
    private String displayPinyin;
    private int tone;
    private boolean valid;
    public PhoneticPinyin(String initialPinyin, String finalPinyin, int tone){
        this.initialPinyin = initialPinyin;
        this.finalPinyin = finalPinyin;
        this.tone = tone;
        this.pinyin = initialPinyin + finalPinyin;
        String upperInitial = initialPinyin.substring(0,1).toUpperCase() + initialPinyin.substring(1);
        this.displayPinyin = upperInitial + finalPinyin;
        this.valid = PinyinUtil.isValidPinyin(pinyin);
    }
    @Override
    public String toString(){
        return displayPinyin;
    }
    public boolean isValid(){
        return valid;
    }
    public String getInitialPinyin() {
        return initialPinyin;
    }
    public String getFinalPinyin() {
        return finalPinyin;
    }
    public String getPinyin() {
        return pinyin;
    }
}
