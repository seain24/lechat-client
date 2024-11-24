package com.lechat.android.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Seain
 * @Date: on 2024-10-20 17:42.
 * @Description: 图像工具类
 */
public final class PictureUtil {
    private static Map<Integer, String> mHeadPathMap = new HashMap<Integer, String>();

    public static void SetHeadPath(int uAccountID, String path) {
        if (StringUtils.isNotBlank(path)) {
            mHeadPathMap.put(uAccountID, path);
        }
    }
}
