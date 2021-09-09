package _m_j;

import android.content.Context;
import android.media.AudioManager;

public final class cqh {

    /* renamed from: O000000o  reason: collision with root package name */
    public static AudioManager f14240O000000o;
    private static AudioManager.OnAudioFocusChangeListener O00000Oo = new AudioManager.OnAudioFocusChangeListener() {
        /* class _m_j.cqh.AnonymousClass1 */

        public final void onAudioFocusChange(int i) {
            if (cqh.f14240O000000o == null) {
                wd.O00000Oo("Huang", "afChangeListener audioManager is null ");
            }
            if (i == -3) {
                wd.O00000Oo("Huang", "afChangeListener: LOSS");
                cqh.f14240O000000o.abandonAudioFocus(this);
            } else if (i == -2) {
                wd.O00000Oo("Huang", "afChangeListener: AUDIOFOCUS_LOSS_TRANSIENT");
                cqh.f14240O000000o.abandonAudioFocus(this);
            } else if (i == -1) {
                wd.O00000Oo("Huang", "afChangeListener: AUDIOFOCUS_LOSS");
                cqh.f14240O000000o.abandonAudioFocus(this);
            } else if (i == 1) {
                wd.O00000Oo("Huang", "afChangeListener: AUDIOFOCUS_GAIN");
            } else if (i == 2) {
                wd.O00000Oo("Huang", "afChangeListener: AUDIOFOCUS_GAIN_TRANSIENT");
            } else if (i == 3) {
                wd.O00000Oo("Huang", "afChangeListener: GAIN");
            } else if (i != 4) {
                wd.O00000Oo("Huang", "afChangeListener: DEFAULT");
                cqh.f14240O000000o.abandonAudioFocus(this);
            } else {
                wd.O00000Oo("Huang", "afChangeListener: AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE");
            }
        }
    };

    public static void O000000o(Context context, String str) {
        if (context == null) {
            wd.O00000o0("Huang", "request: applicationContext is null");
            return;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        f14240O000000o = audioManager;
        audioManager.requestAudioFocus(O00000Oo, 0, 4);
        wd.O000000o("Huang", "request: ".concat(String.valueOf(str)));
    }

    public static void O00000Oo(Context context, String str) {
        if (context == null) {
            wd.O00000o0("Huang", "abandon: applicationContext is null");
            return;
        }
        try {
            if (f14240O000000o == null) {
                f14240O000000o = (AudioManager) context.getSystemService("audio");
            }
            if (f14240O000000o != null) {
                f14240O000000o.abandonAudioFocus(O00000Oo);
            }
            wd.O000000o("Huang", "abandon: ".concat(String.valueOf(str)));
        } catch (Exception e) {
            e.printStackTrace();
            wd.O00000o0("Huang", "abandon exception=" + e.getMessage());
        }
    }
}
