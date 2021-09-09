package _m_j;

import android.content.Context;
import android.content.SharedPreferences;

public final class ikz {
    private static ikz O00000o;
    private static byte[] O00000oO = new byte[0];
    private static boolean O00000oo = false;
    private static boolean O0000O0o = true;

    /* renamed from: O000000o  reason: collision with root package name */
    public SharedPreferences f1428O000000o;
    public boolean O00000Oo = false;
    public boolean O00000o0 = false;
    private Context O0000OOo;
    private float O0000Oo = 0.0f;
    private boolean O0000Oo0 = false;

    private ikz(Context context) {
        this.O0000OOo = context.getApplicationContext();
        this.f1428O000000o = this.O0000OOo.getSharedPreferences("xmplayer_config", 0);
    }

    public static ikz O000000o(Context context) {
        if (O00000o == null) {
            synchronized (O00000oO) {
                if (O00000o == null) {
                    O00000o = new ikz(context);
                }
            }
        }
        return O00000o;
    }

    public final boolean O000000o() {
        return this.f1428O000000o.getBoolean("KEY_USE_TRACK_HIGH_BITRATE", false);
    }

    public final boolean O00000Oo() {
        return this.f1428O000000o.getBoolean("KEY_USE_SYSTEM_PLAYER", false);
    }

    public final boolean O00000o0() {
        if (!this.O0000Oo0) {
            this.O0000Oo0 = this.f1428O000000o.getBoolean("KEY_SDK_HANDLE_AUDIO_FOCUS", true);
        }
        return this.O0000Oo0;
    }

    public final float O00000o() {
        float f = this.O0000Oo;
        if (f != 0.0f) {
            return f;
        }
        this.O0000Oo = this.f1428O000000o.getFloat("KEY_SDK_RECEVICE_AUDIO_FOCUS_TYPE_DUCK_VOLUME", 0.3f);
        return this.O0000Oo;
    }

    public final boolean O00000oO() {
        if (!O00000oo) {
            O00000oo = this.f1428O000000o.getBoolean("OPENSDK_KEY_SDK_USE_PREVENT_HIJACK", false);
        }
        return O00000oo;
    }

    public final boolean O00000oo() {
        if (O0000O0o) {
            O0000O0o = this.f1428O000000o.getBoolean("OPENSDK_KEY_SDK_USE_SYSTEM_LOCK_SCREEN", true);
        }
        return O0000O0o;
    }
}
