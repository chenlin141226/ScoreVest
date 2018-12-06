package com.hardy.jaffa.myapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeUtils {

    private static final char[] encodeTable = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};

    //时间戳转年月日
    public static String stampToTime(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }


    /**
     * 获取随机String
     *
     * @param len
     * @return
     */
    public static String getRandomString(int len) {
        String returnStr = "";
        char[] ch = new char[len];
        Random rd = new Random();
        for (int i = 0; i < len; i++) {
            ch[i] = (char) (rd.nextInt(9) + 65);
            ch[i] = encodeTable[rd.nextInt(36)];
        }
        returnStr = new String(ch);
        return returnStr;
    }


}
