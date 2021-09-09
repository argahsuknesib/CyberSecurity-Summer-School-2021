package com.mi.global.shop.activity;

import _m_j.ccr;
import android.content.Context;
import android.content.Intent;

public class LaunchWebActivity extends WebActivity {
    public static void startActivityStandard(Context context, String str) {
        ccr.O00000Oo("LaunchWebActivity", "url:".concat(String.valueOf(str)));
        Intent intent = new Intent(context, LaunchWebActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }
}
