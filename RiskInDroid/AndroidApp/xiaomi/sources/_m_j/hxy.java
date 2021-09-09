package _m_j;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class hxy {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f964O000000o;
    public String O00000Oo;
    public String O00000o;
    public int O00000o0;
    public boolean O00000oO;
    public int O00000oo;
    public int O0000O0o;
    public String O0000OOo;
    public String O0000Oo;
    public String O0000Oo0;
    public String O0000OoO;

    public hxy(Object obj, String str, int i, String str2, boolean z) {
        this.f964O000000o = O000000o(obj);
        this.O00000Oo = str;
        this.O00000o0 = i;
        this.O00000o = str2;
        this.O00000oO = z;
    }

    public static String O000000o(Object obj) {
        String valueOf = String.valueOf(obj);
        if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals(valueOf, "0") && !TextUtils.equals(valueOf, "null")) {
            try {
                String O000000o2 = fku.O000000o(MessageDigest.getInstance("SHA-256").digest(valueOf.getBytes()));
                return O000000o2.substring(2, O000000o2.length() - 2);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return "";
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("hash_did=");
        sb.append(this.f964O000000o);
        sb.append(",model=");
        sb.append(this.O00000Oo);
        sb.append(",step=");
        sb.append(this.O00000o0);
        sb.append(",firmwareVersion=");
        sb.append(this.O00000o);
        sb.append(",router_level=");
        sb.append(this.O00000oo);
        sb.append(",ssid=");
        sb.append(this.O0000Oo0);
        sb.append(",deviceLevel");
        sb.append(this.O0000O0o);
        sb.append(",extra=");
        sb.append(this.O0000Oo);
        sb.append(",bindkey=");
        sb.append(this.O0000OoO);
        return sb.toString();
    }
}
