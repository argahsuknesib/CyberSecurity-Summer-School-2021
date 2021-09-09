package com.xiaomi.youpin.login.entity.account;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Calendar;

public final class MiAccountInfo {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f12085O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public ArrayList<String> O00000oO;
    public String O00000oo;
    public String O0000O0o;
    public Bitmap O0000OOo;
    public Calendar O0000Oo;
    public Gender O0000Oo0;

    public enum Gender {
        MALE("m"),
        FEMALE("f");
        
        private String mGender;

        private Gender(String str) {
            this.mGender = str;
        }

        public final String getType() {
            return this.mGender;
        }
    }
}
