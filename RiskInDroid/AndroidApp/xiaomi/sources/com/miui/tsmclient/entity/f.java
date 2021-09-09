package com.miui.tsmclient.entity;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class f {
    @SerializedName("aid")

    /* renamed from: a  reason: collision with root package name */
    private String f3865a;
    @SerializedName("events")
    private List<a> b;

    public static class a {
        /* access modifiers changed from: private */
        @SerializedName("data")

        /* renamed from: a  reason: collision with root package name */
        public String f3866a;
        @SerializedName("defaultDesc")
        private String b;
        @SerializedName("cnDesc")
        private String c;
        @SerializedName("isSuccess")
        private boolean d;
        @SerializedName("type")
        private String e;

        public String a() {
            return ("zh".equalsIgnoreCase(Locale.getDefault().getLanguage()) || "cn".equalsIgnoreCase(Locale.getDefault().getCountry())) ? this.c : this.b;
        }

        public boolean b() {
            return this.d;
        }

        public String c() {
            return this.e;
        }
    }

    public boolean a(String str) {
        String str2 = this.f3865a;
        if (str2 == null) {
            return false;
        }
        return Pattern.compile(str2).matcher(str).matches();
    }

    public a b(String str) {
        if (this.b != null && !TextUtils.isEmpty(str)) {
            for (a next : this.b) {
                if (!TextUtils.isEmpty(next.f3866a) && Pattern.compile(next.f3866a).matcher(str).matches()) {
                    return next;
                }
            }
        }
        return null;
    }
}
