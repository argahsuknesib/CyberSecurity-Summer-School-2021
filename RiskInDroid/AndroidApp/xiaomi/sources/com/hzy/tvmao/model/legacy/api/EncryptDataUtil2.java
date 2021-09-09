package com.hzy.tvmao.model.legacy.api;

import android.content.Context;
import com.hzy.tvmao.utils.LogUtil;

public class EncryptDataUtil2 {
    public static boolean init(Context context, String str) {
        if (context != null && str != null) {
            return StreamHelper2.init(context, str);
        }
        LogUtil.e("context or key is null");
        return false;
    }

    public static byte[] dec(byte[] bArr) {
        if (bArr != null) {
            return StreamHelper2.dec(bArr);
        }
        LogUtil.e("bytes is null");
        return null;
    }

    public static byte[] enc(byte[] bArr) {
        if (bArr != null) {
            return StreamHelper2.enc(bArr);
        }
        LogUtil.e("bytes is null");
        return null;
    }
}
