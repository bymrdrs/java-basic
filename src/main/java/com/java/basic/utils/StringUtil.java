package com.java.basic.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    /**
     * 字符串转List
     */
    public static List<String> stringToList(String s) {
        String[] ss = s.split(",");
        return Arrays.asList(ss);
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.stringToList("篮球,足球,排球"));
    }

}
