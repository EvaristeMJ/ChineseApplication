package com.example.chineseapplication.pinyin;

import java.util.ArrayList;

public class PinyinUtil {
    /**
     * The list of initials in pinyin system.
     */
    public static final String[] initials = {"y", "w", "b", "p", "m", "f", "d", "t", "n", "l", "z", "c", "s", "zh", "ch", "sh", "r", "j", "q", "x", "g", "k", "h"};
    /**
     * The list of finals in pinyin system.
     */
    public static final String[] finals = {"i", "ia", "iao", "ie", "iu", "ian", "in", "iang", "ing", "iong", "u", "ua", "uo", "uai", "ui", "uan", "un", "uang", "ueng",
            "ü", "üe", "üan", "ün", "a", "o", "e", "er", "ai", "ei", "ao", "ou", "an", "en", "ang", "eng", "ong"};
    /**
     * A list of valid tones.
     * From 1 to 5.
     */
    public static final String[] tones = {"1", "2", "3", "4", "5"};
    /**
     * A 2D array of valid pinyin.
     */
    public static final String[][] phoneticPinyinValid = {
            {"yi", "ya", "yao", "ye", "you", "yan", "yin", "yang", "ying", "yong"},
            {"wu", "wa", "wo", "wai", "wei", "wan", "wen", "wang", "weng"},
            {"ba","bo","bai","bei","bao","ban","ben","bang","beng","bi","biao","bie","bian","bin","bing","bu"},
            {"pa","po","pai","pei","pao","pou","pan","pen","pang","peng","pi","piao","pie","pian","pin","ping","pu"},
            {"ma","mo","mai","mei","mao","mou","man","men","mang","meng","mi","miao","mie","mian","min","ming","mu","me"},
            {"fa","fo","fei","fou","fan","fen","fang","feng","fu"},
            {"da","de","dai","dei","dei","dao","dou","dan","den","dang","deng","dong","di","diao","die","diu","dian","ding","du","duo","dui"},
            {  "ta", "te", "tai", "tei", "tao", "tou", "tan", "tang", "teng", "ti", "tie", "tiao", "tian", "ting", "tu", "tuo", "tui", "tuan", "tun", "tong"},
            {"na","ne","nai","nei","nao","nou","nan","nen","nang","neng","ni","nia","nie","niao","niu","nian","nin","niang","ning","nu","nuo","nuan","nun","nong","nü","nüe"},
            {  "la",
                    "lo",
                    "le",
                    "lai",
                    "lei",
                    "lao",
                    "lou",
                    "lan",
                    "lang",
                    "leng",
                    "li",
                    "lia",
                    "lie",
                    "liao",
                    "liu",
                    "lian",
                    "lin",
                    "liang",
                    "ling",
                    "lu",
                    "luo",
                    "luan",
                    "lun",
                    "long",
                    "lüe",
                    "lün"},
            {"za","ze","zai","zei","zao","zou","zan","zen","zang","zeng","zi","zuo","zui","zuan","zun","zong"},
            { "ci",
                    "ca",
                    "ce",
                    "cai",
                    "cao",
                    "cou",
                    "can",
                    "cen",
                    "cang",
                    "ceng",
                    "cu",
                    "cuo",
                    "cui",
                    "cuan",
                    "cun",
                    "cong"},
            {"sa","se","sai","sao","sou","san","sen","sang","seng","si","suo","sui","suan","sun","song"},
            {"zhi",
                    "zha",
                    "zhe",
                    "zhai",
                    "zhei",
                    "zhao",
                    "zhou",
                    "zhan",
                    "zhen",
                    "zhang",
                    "zheng",
                    "zhu",
                    "zhua",
                    "zhuo",
                    "zhuai",
                    "zhuan",
                    "zhun",
                    "zhuang",
                    "zhong"},
            {"chi",
                    "cha",
                    "che",
                    "chai",
                    "chao",
                    "chou",
                    "chan",
                    "chen",
                    "chang",
                    "cheng",
                    "chu",
                    "chua",
                    "chuo",
                    "chuai",
                    "chuan",
                    "chun",
                    "chuang",
                    "chong"},
            {"shi",
                    "sha",
                    "she",
                    "shai",
                    "shei",
                    "shao",
                    "shou",
                    "shan",
                    "shen",
                    "shang",
                    "sheng",
                    "shu",
                    "shua",
                    "shuo",
                    "shuai",
                    "shuan",
                    "shun",
                    "shuang"},
            {"ri",
                    "re",
                    "rao",
                    "rou",
                    "ran",
                    "ren",
                    "rang",
                    "reng",
                    "ru",
                    "ruo",
                    "rui",
                    "ruan",
                    "run",
                    "rong"},
            {"ji",
                    "jia",
                    "jie",
                    "jiao",
                    "jiu",
                    "jian",
                    "jin",
                    "jiang",
                    "jing",
                    "ju",
                    "jue",
                    "juan",
                    "jun",
                    "jiong"},
            {"qi",
                    "qia",
                    "qie",
                    "qiao",
                    "qiu",
                    "qian",
                    "qin",
                    "qiang",
                    "qing",
                    "qu",
                    "que",
                    "quan",
                    "qun",
                    "qiong"},
            {"xi",
                    "xia",
                    "xie",
                    "xiao",
                    "xiu",
                    "xian",
                    "xin",
                    "xiang",
                    "xing",
                    "xu",
                    "xue",
                    "xuan",
                    "xun",
                    "xiong"},
            {
                    "ge",
                    "gai",
                    "gei",
                    "gao",
                    "gou",
                    "gan",
                    "gen",
                    "gang",
                    "geng",
                    "gu",
                    "gua",
                    "guo",
                    "guai",
                    "gui",
                    "guan",
                    "gun",
                    "guang",
                    "gong"},
            {"ka",
                    "ke",
                    "kai",
                    "kei",
                    "kao",
                    "kou",
                    "kan",
                    "ken",
                    "kang",
                    "keng",
                    "ku",
                    "kua",
                    "kuo",
                    "kuai",
                    "kui",
                    "kuan",
                    "kun",
                    "kuang",
                    "kong"},
            { "ha",
                    "he",
                    "hai",
                    "hei",
                    "hao",
                    "hou",
                    "han",
                    "hen",
                    "hang",
                    "heng",
                    "hu",
                    "hua",
                    "huo",
                    "huai",
                    "hui",
                    "huan",
                    "hun",
                    "huang",
                    "hong"}
    };

    /**
     * Create a PhoneticPinyin with the given initial and final
     * The result pinyin might be invalid
     * @param i initial index
     * @param j final index
     * @return a PhoneticPinyin
     */
    public static PhoneticPinyin createPhoneticPinyin(int i, int j) {
        return new PhoneticPinyin(initials[i], finals[j], 0);
    }
    /**
     * Create a random PhoneticPinyin
     * The result pinyin might be invalid
     * @return a random PhoneticPinyin
     */
    public static PhoneticPinyin createRandomPhoneticPinyin() {
        int i = (int) (Math.random() * initials.length);
        int j = (int) (Math.random() * finals.length);
        return new PhoneticPinyin(initials[i], finals[j], 0);
    }

    /**
     * @param pinyin to check
     * @return true if the pinyin is valid
     */
    public static boolean isValidPinyin(String pinyin){
        for(String[] p: phoneticPinyinValid){
            for(String s: p){
                if(s.equals(pinyin)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the valid pinyin list for the given initial
     * @param initial
     * @return the array of valid pinyin
     */
    public static String[] getValidPinyinForInitial(String initial) {
        for(int i = 0; i < initials.length; i++){
            if(initials[i].equals(initial)){
                return phoneticPinyinValid[i];
            }
        }
        return null;
    }
}
