package com.mibi.sdk.component;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class EntryResultUtils {
    public static Intent makeResult(int i, String str) {
        return makeResult(i, str, null);
    }

    public static Intent makeResult(int i, String str, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("code", i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("message", str);
        }
        if (bundle != null) {
            intent.putExtra("result", bundle);
        }
        return intent;
    }

    public static Intent makeResultWithOriginalArgs(int i, String str, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("code", i);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("message", str);
        }
        return intent;
    }
}
