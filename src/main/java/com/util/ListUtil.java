package com.util;

import java.util.List;

public class ListUtil {

    public static Boolean isBlank(List<?> list) {
        if (list == null || list.size() == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
