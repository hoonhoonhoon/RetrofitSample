package com.example.woowahan.retrofitsample.util;

import android.util.Log;

import com.example.woowahan.retrofitsample.BuildConfig;

/**
 * Created by woowahan on 2016. 12. 23..
 */

public class LogUtils {

    public static void debug(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.d(tag, msg);
    }
    public static void info(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.i(tag, msg);
    }
    public static void warn(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.w(tag, msg);
    }
    public static void error(String tag, String msg) {
        if (BuildConfig.DEBUG)
            Log.e(tag, msg);
    }
}
