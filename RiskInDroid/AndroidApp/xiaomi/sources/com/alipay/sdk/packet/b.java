package com.alipay.sdk.packet;

import android.text.TextUtils;
import com.alipay.sdk.util.c;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f3195a;
    private final String b;

    public b(String str, String str2) {
        this.f3195a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f3195a;
    }

    public final String b() {
        return this.b;
    }

    public final JSONObject c() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new JSONObject(this.b);
        } catch (Exception e) {
            c.a(e);
            return null;
        }
    }

    public final String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f3195a, this.b);
    }
}
