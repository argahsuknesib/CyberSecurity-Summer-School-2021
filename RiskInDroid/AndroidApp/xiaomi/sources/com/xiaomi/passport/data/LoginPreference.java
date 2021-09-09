package com.xiaomi.passport.data;

public final class LoginPreference {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f6199O000000o;
    public String O00000Oo;
    public PhoneLoginType O00000o0;

    public LoginPreference(String str, String str2, PhoneLoginType phoneLoginType) {
        this.f6199O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = phoneLoginType;
    }

    public enum PhoneLoginType {
        ticket("ticket"),
        password("password");
        
        private final String value;

        private PhoneLoginType(String str) {
            this.value = str;
        }
    }
}
