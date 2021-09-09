package _m_j;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import cn.bingoogolapple.bgabanner.transformer.TransitionEffect;
import com.google.android.exoplayer2.C;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class lr implements ViewPager.O0000OOo {
    public abstract void O000000o(View view);

    public abstract void O000000o(View view, float f);

    public abstract void O00000Oo(View view, float f);

    public void transformPage(View view, float f) {
        if (f >= -1.0f) {
            if (f <= 0.0f) {
                O000000o(view, f);
                return;
            } else if (f <= 1.0f) {
                O00000Oo(view, f);
                return;
            }
        }
        O000000o(view);
    }

    /* renamed from: _m_j.lr$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f2172O000000o = new int[TransitionEffect.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f2172O000000o[TransitionEffect.Default.ordinal()] = 1;
            f2172O000000o[TransitionEffect.Alpha.ordinal()] = 2;
            f2172O000000o[TransitionEffect.Rotate.ordinal()] = 3;
            f2172O000000o[TransitionEffect.Cube.ordinal()] = 4;
            f2172O000000o[TransitionEffect.Flip.ordinal()] = 5;
            f2172O000000o[TransitionEffect.Accordion.ordinal()] = 6;
            f2172O000000o[TransitionEffect.ZoomFade.ordinal()] = 7;
            f2172O000000o[TransitionEffect.Fade.ordinal()] = 8;
            f2172O000000o[TransitionEffect.ZoomCenter.ordinal()] = 9;
            f2172O000000o[TransitionEffect.ZoomStack.ordinal()] = 10;
            f2172O000000o[TransitionEffect.Stack.ordinal()] = 11;
            f2172O000000o[TransitionEffect.Depth.ordinal()] = 12;
            try {
                f2172O000000o[TransitionEffect.Zoom.ordinal()] = 13;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static lr O000000o(TransitionEffect transitionEffect) {
        switch (AnonymousClass1.f2172O000000o[transitionEffect.ordinal()]) {
            case 1:
                return new lt();
            case 2:
                return new lq();
            case 3:
                return new lx();
            case 4:
                return new ls();
            case 5:
                return new lw();
            case 6:
                return new lp();
            case 7:
                return new ma();
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return new lv();
            case 9:
                return new lz();
            case 10:
                return new mc();
            case 11:
                return new ly();
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return new lu();
            case 13:
                return new mb();
            default:
                return new lt();
        }
    }
}
