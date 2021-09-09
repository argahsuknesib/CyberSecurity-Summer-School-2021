package com.ximalaya.ting.android.opensdk.datatrasfer;

import java.util.HashMap;

public class CommonRequestForMain$1 extends HashMap<String, String> {
    final /* synthetic */ long val$trackId;

    public CommonRequestForMain$1(long j) {
        this.val$trackId = j;
        put("device", "android");
        StringBuilder sb = new StringBuilder();
        sb.append(this.val$trackId);
        put("trackId", sb.toString());
    }
}
