package com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter;

import _m_j.grk;
import _m_j.grl;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class Section {
    public State O00000o = State.LOADED;
    public boolean O00000oO;
    public boolean O00000oo;
    public boolean O0000O0o;
    public Integer O0000OOo;
    public int O0000Oo;
    public Integer O0000Oo0;
    public Integer O0000OoO;
    public Integer O0000Ooo;
    public Integer O0000o00;

    public enum State {
        LOADING,
        LOADED,
        FAILED,
        EMPTY
    }

    public abstract int O000000o();

    public void O000000o(RecyclerView.O000OOo0 o000OOo0) {
    }

    public abstract void O000000o(RecyclerView.O000OOo0 o000OOo0, int i);

    public abstract RecyclerView.O000OOo0 O00000Oo(View view);

    public Section(grk grk) {
        boolean z = true;
        this.O00000oO = true;
        this.O00000oo = false;
        this.O0000O0o = false;
        this.O0000OOo = grk.f18180O000000o;
        this.O0000Oo0 = grk.O00000Oo;
        this.O0000Oo = grk.O00000o0;
        this.O0000OoO = grk.O00000o;
        this.O0000Ooo = grk.O00000oO;
        this.O0000o00 = grk.O00000oo;
        this.O00000oo = this.O0000OOo != null;
        this.O0000O0o = this.O0000Oo0 == null ? false : z;
    }

    /* renamed from: com.xiaomi.smarthome.library.common.widget.sectionedrecyclerviewadapter.Section$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final /* synthetic */ int[] f9327O000000o = new int[State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f9327O000000o[State.LOADING.ordinal()] = 1;
            f9327O000000o[State.FAILED.ordinal()] = 2;
            f9327O000000o[State.EMPTY.ordinal()] = 3;
            try {
                f9327O000000o[State.LOADED.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final int O00000Oo() {
        int i = AnonymousClass1.f9327O000000o[this.O00000o.ordinal()];
        int i2 = 1;
        if (!(i == 1 || i == 2 || i == 3)) {
            if (i == 4) {
                i2 = O000000o();
            } else {
                throw new IllegalStateException("Invalid state");
            }
        }
        return i2 + (this.O00000oo ? 1 : 0) + (this.O0000O0o ? 1 : 0);
    }

    public RecyclerView.O000OOo0 O000000o(View view) {
        return new grl.O000000o(view);
    }
}
