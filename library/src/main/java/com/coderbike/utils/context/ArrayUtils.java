package com.coderbike.utils.context;

/**
 * <p>描述<p/>
 * Created with IDEA
 * author: liubingguang
 * date: 2016/12/13 11:54
 */
public class ArrayUtils {

    public static boolean contain(String[] strings, String specifyStr) {
        for (String str : strings) {
            if (str.equals(specifyStr)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
