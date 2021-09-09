package _m_j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

public final class cnw {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f14156O000000o;
    public final int O00000Oo;
    public final Drawable O00000o;
    public final int O00000o0;
    public final Drawable O00000oO;
    public final Drawable O00000oo;
    public final boolean O0000O0o;
    public final boolean O0000OOo;
    public final ImageScaleType O0000Oo;
    public final boolean O0000Oo0;
    public final BitmapFactory.Options O0000OoO;
    public final int O0000Ooo;
    public final coi O0000o;
    public final Object O0000o0;
    public final boolean O0000o00;
    public final cor O0000o0O;
    public final cor O0000o0o;
    public final boolean O0000oO;
    public final Handler O0000oO0;

    /* synthetic */ cnw(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private cnw(O000000o o000000o) {
        this.f14156O000000o = o000000o.f14157O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo;
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
        this.O0000OoO = o000000o.O0000OoO;
        this.O0000Ooo = o000000o.O0000Ooo;
        this.O0000o00 = o000000o.O0000o00;
        this.O0000o0 = o000000o.O0000o0;
        this.O0000o0O = o000000o.O0000o0O;
        this.O0000o0o = o000000o.O0000o0o;
        this.O0000o = o000000o.O0000o;
        this.O0000oO0 = o000000o.O0000oO0;
        this.O0000oO = o000000o.O0000oO;
    }

    public final boolean O000000o() {
        return this.O0000o0o != null;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f14157O000000o = 0;
        public int O00000Oo = 0;
        public Drawable O00000o = null;
        public int O00000o0 = 0;
        public Drawable O00000oO = null;
        public Drawable O00000oo = null;
        public boolean O0000O0o = false;
        public boolean O0000OOo = false;
        public ImageScaleType O0000Oo = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        public boolean O0000Oo0 = false;
        public BitmapFactory.Options O0000OoO = new BitmapFactory.Options();
        public int O0000Ooo = 0;
        public coi O0000o = new coj();
        public Object O0000o0 = null;
        public boolean O0000o00 = false;
        public cor O0000o0O = null;
        public cor O0000o0o = null;
        public boolean O0000oO = false;
        public Handler O0000oO0 = null;

        public final O000000o O000000o(Bitmap.Config config) {
            if (config != null) {
                this.O0000OoO.inPreferredConfig = config;
                return this;
            }
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }

        public final cnw O000000o() {
            return new cnw(this, (byte) 0);
        }
    }
}
