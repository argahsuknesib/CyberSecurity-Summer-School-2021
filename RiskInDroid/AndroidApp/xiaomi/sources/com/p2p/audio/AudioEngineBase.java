package com.p2p.audio;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class AudioEngineBase {
    protected double O00000oO = 6.0d;
    protected short O00000oo = 32256;
    protected short O0000O0o = -30464;
    public double O0000OOo = Math.pow(10.0d, this.O00000oO / 20.0d);
    protected Context O0000Oo;
    protected int O0000Oo0 = 0;
    public String O0000OoO = "";

    public AudioEngineBase(Context context) {
        this.O0000Oo = context;
        Context context2 = this.O0000Oo;
        if (context2 != null) {
            this.O0000OOo = (double) context2.getSharedPreferences("DB_MULTIPLE_P", 0).getFloat("DB_MULTIPLE", 1.8f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004f, code lost:
        return;
     */
    public synchronized void O00000oO() {
        if (this.O0000Oo != null) {
            if (!TextUtils.isEmpty(this.O0000OoO)) {
                SharedPreferences.Editor edit = this.O0000Oo.getSharedPreferences("DB_MULTIPLE_P", 0).edit();
                edit.putFloat("DB_MULTIPLE" + this.O0000OoO, (float) this.O0000OOo).apply();
                return;
            }
            this.O0000Oo.getSharedPreferences("DB_MULTIPLE_P", 0).edit().putFloat("DB_MULTIPLE", (float) this.O0000OOo).apply();
        }
    }

    public final void O000000o(byte[] bArr, byte[] bArr2, float f) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i += 2) {
                int i2 = i + 1;
                short s = (short) ((int) (((float) ((short) ((bArr[i] & 255) | (bArr[i2] << 8)))) * f));
                short s2 = this.O0000O0o;
                if (s >= s2) {
                    s2 = this.O00000oo;
                    if (s > s2) {
                        this.O0000Oo0++;
                    } else {
                        s2 = s;
                    }
                }
                bArr2[i] = (byte) (s2 & 255);
                bArr2[i2] = (byte) ((s2 >> 8) & 255);
            }
            if (this.O0000Oo0 >= 2) {
                double d = this.O00000oO;
                if (d > 1.0d) {
                    this.O00000oO = d - 1.0d;
                    this.O0000OOo = Math.max(1.0d, Math.pow(10.0d, this.O00000oO / 20.0d));
                }
            }
            this.O0000Oo0 = 0;
        }
    }
}
