package _m_j;

import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;

public class gtt {
    public static volatile gtt O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public SoundPool f18273O000000o;
    public int O00000Oo;
    public int O00000o0;
    public gpq O00000oO = new gpq("LiteSoundManager");
    public volatile Handler O00000oo;
    public volatile boolean O0000O0o = false;

    public static gtt O000000o() {
        if (O00000o == null) {
            synchronized (gtt.class) {
                if (O00000o == null) {
                    O00000o = new gtt();
                }
            }
        }
        return O00000o;
    }

    private gtt() {
        this.O00000oO.start();
        this.O00000oo = new Handler(this.O00000oO.getLooper()) {
            /* class _m_j.gtt.AnonymousClass1 */

            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        if (gtt.this.f18273O000000o != null) {
                            try {
                                gtt.this.f18273O000000o.unload(gtt.this.O00000Oo);
                                gtt.this.f18273O000000o.unload(gtt.this.O00000o0);
                                gtt.this.f18273O000000o.release();
                                gtt.this.f18273O000000o = null;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        gtt.this.O00000oO.getLooper().quit();
                    }
                } else if (!gtt.this.O0000O0o) {
                    try {
                        gtt.this.f18273O000000o = new SoundPool(1, 1, 0);
                        gtt.this.O00000Oo = gtt.this.f18273O000000o.load(CommonApplication.getAppContext(), R.raw.geek_click_down, 1);
                        gtt.this.O00000o0 = gtt.this.f18273O000000o.load(CommonApplication.getAppContext(), R.raw.geek_click_up, 1);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (gtt.this.O0000O0o) {
                        gtt.this.O00000oo.sendEmptyMessage(2);
                    }
                }
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public final void O00000Oo() {
        if (!this.O0000O0o && this.f18273O000000o != null && gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "lite_config_click_sound", true)) {
            try {
                this.f18273O000000o.play(this.O00000Oo, 1.0f, 1.0f, 0, 0, 1.0f);
            } catch (Exception unused) {
            }
        }
    }
}
