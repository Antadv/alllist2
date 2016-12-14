package com.coderbike.utils;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 11:54
 */
public class ArrayUtils {

    public static boolean containEqual(String[] strings, String specifyStr) {
        for (String str : strings) {
            if (specifyStr.equals(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static boolean contain(String[] strings, String specifyStr) {
        for (String str : strings) {
            if (specifyStr.contains(str)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
