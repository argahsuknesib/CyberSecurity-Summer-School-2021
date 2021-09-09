package com.tmall.wireless.vaf.framework;

import _m_j.dmu;
import _m_j.dmv;
import _m_j.doj;
import _m_j.dok;
import _m_j.dol;
import _m_j.don;
import _m_j.dop;
import _m_j.doq;
import _m_j.dor;
import _m_j.dot;
import _m_j.dow;
import _m_j.dpi;
import _m_j.dpk;
import _m_j.dpt;
import _m_j.dpw;
import android.app.Activity;
import android.content.Context;
import android.view.ViewConfiguration;
import com.tmall.wireless.vaf.virtualview.Helper.ImageLoader;

public class VafContext {
    public static int O00000Oo;
    protected static dpw O0000OOo = new dpw();

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f5890O000000o;
    protected dok O00000o;
    protected dmu O00000o0;
    protected dop O00000oO;
    protected dor O00000oo;
    protected dmv O0000O0o;
    protected ImageLoader O0000Oo;
    protected don O0000Oo0;
    protected dpk O0000OoO;
    protected doj O0000Ooo;
    protected dot O0000o0;
    protected dol O0000o00;
    protected dpi O0000o0O;
    protected Activity O0000o0o;

    public final dol O000000o() {
        return this.O0000o00;
    }

    public VafContext(Context context) {
        this(context, (byte) 0);
    }

    private VafContext(Context context, byte b) {
        this.O00000o0 = new dmu();
        this.O00000o = new dok();
        this.O00000oO = new dop();
        this.O00000oo = new dor();
        this.O0000O0o = new dmv();
        this.O0000OoO = new dpk();
        this.O0000Ooo = new doj();
        this.O0000o00 = new dol();
        this.O0000o0 = new dot();
        this.O0000o0O = new dpi();
        this.f5890O000000o = context;
        doq.f14813O000000o = O0000OOo;
        dok dok = this.O00000o;
        dok.O00000o0 = this;
        dok.f14808O000000o.O00000oo = this;
        dpt dpt = dow.O00000o0;
        dpw dpw = O0000OOo;
        dpt.f14842O000000o = dpw;
        dmv dmv = this.O0000O0o;
        dmv.O00000o0 = dpw;
        this.O00000o0.f14795O000000o.O00000o = dmv;
        this.O00000o0.f14795O000000o.O00000oO = O0000OOo;
        this.O00000o0.O000000o();
        this.O0000Oo0 = new don();
        this.O0000Oo0.O000000o(this);
        this.O0000Oo = new ImageLoader(context);
        O00000Oo = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final dpk O00000Oo() {
        return this.O0000OoO;
    }

    public final dop O00000o0() {
        return this.O00000oO;
    }

    public final ImageLoader O00000o() {
        return this.O0000Oo;
    }

    public final void O000000o(ImageLoader.O000000o o000000o) {
        this.O0000Oo.f5891O000000o = o000000o;
    }

    public final dmu O00000oO() {
        return this.O00000o0;
    }

    @Deprecated
    public final Context O00000oo() {
        return this.f5890O000000o;
    }

    public final Context O0000O0o() {
        Activity activity = this.O0000o0o;
        return activity != null ? activity : this.f5890O000000o;
    }

    public final dmv O0000OOo() {
        return this.O0000O0o;
    }

    public static dpw O0000Oo0() {
        return O0000OOo;
    }

    public final dok O0000Oo() {
        return this.O00000o;
    }

    public final don O0000OoO() {
        return this.O0000Oo0;
    }

    public final Activity O0000Ooo() {
        return this.O0000o0o;
    }
}
