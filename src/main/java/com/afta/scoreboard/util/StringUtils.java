package com.afta.scoreboard.util;

public class StringUtils {

    static public boolean isNullEmptyOrBlank(String s) {
        return s == null || s.isEmpty() || s.isBlank();
    }
}
