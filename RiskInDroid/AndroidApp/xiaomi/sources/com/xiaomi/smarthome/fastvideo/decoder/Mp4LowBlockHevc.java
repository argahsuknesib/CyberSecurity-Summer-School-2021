package com.xiaomi.smarthome.fastvideo.decoder;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashSet;

public class Mp4LowBlockHevc {
    private static final HashSet<String> mMp4Block;

    static {
        HashSet<String> hashSet = new HashSet<>();
        mMp4Block = hashSet;
        hashSet.add("msm8226");
        mMp4Block.add("msm8916");
        mMp4Block.add("msm8064");
        mMp4Block.add("mt6732");
        mMp4Block.add("mt6735");
        mMp4Block.add("mt6737");
    }

    public static boolean isBlock(String str) {
        return mMp4Block.contains(str) || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19;
    }
}
