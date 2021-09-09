package com.xiaomi.mico.common.util;

import android.content.Context;
import android.graphics.Typeface;

public class TypefaceUtil {
    private static Typeface sFZJT;

    public static Typeface FZJT(Context context) {
        if (sFZJT == null) {
            sFZJT = Typeface.createFromAsset(context.getAssets(), "fonts/fangzheng_qingke_benyue_song_jianti.ttf");
        }
        return sFZJT;
    }
}
