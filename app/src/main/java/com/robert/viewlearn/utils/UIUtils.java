package com.robert.viewlearn.utils;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.Random;

/**
 * @author: robert
 * @date: 2017-09-12
 * @time: 19:24
 * @说明:
 */
public class UIUtils {

    private static Random sRandom;

    private UIUtils() {

    }

    static {
        sRandom = new Random();
    }

    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        DisplayMetrics displayMetrics =
                context.getResources().getDisplayMetrics();
        size[0] = displayMetrics.widthPixels;
        size[1] = displayMetrics.heightPixels;
        return size;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static String getRandomColorStr() {
        String r = Integer.toHexString(sRandom.nextInt(256)).toUpperCase();
        String g = Integer.toHexString(sRandom.nextInt(256)).toUpperCase();
        String b = Integer.toHexString(sRandom.nextInt(256)).toUpperCase();
        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;
        return "#"+r + g + b;
    }

    public static int getRandomColorInt(){
        return sRandom.nextInt(0xffffff);
    }
}
