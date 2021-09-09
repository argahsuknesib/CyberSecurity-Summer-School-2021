package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory {
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = ".concat(String.valueOf(i)));
        if (i > 1) {
            Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = ".concat(String.valueOf(i)));
            return null;
        } else if (i != 1) {
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new a();
            }
            return v1Instance;
        }
    }
}
