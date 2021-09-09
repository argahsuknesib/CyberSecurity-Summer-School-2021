package com.xiaomi.smarthome.newui.card;

import _m_j.hcc;
import _m_j.hcc.O000000o;
import _m_j.hcf;
import _m_j.hcy;
import _m_j.hdg;
import _m_j.hhk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseCardRender<C extends hcc<E, T>, E extends hcc.O000000o<T>, T> implements hcy<String> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ArrayList<? extends hcf<C, E, T>> f10206O000000o;
    public final C O00000Oo;
    public final Context O00000o;
    protected final ViewGroup O00000o0;
    public final Device O00000oO;
    protected DataInitState O00000oo = DataInitState.NOT;
    public int O0000O0o = 0;
    public hdg O0000OOo;

    public enum LayoutPosition {
        TITLE,
        CONTENT
    }

    public abstract LayoutPosition O000000o(ViewGroup viewGroup);

    public abstract hhk O00000Oo();

    public abstract View O00000o0();

    public final void O000000o(hdg hdg) {
        this.O0000OOo = hdg;
    }

    public enum DataInitState {
        DONE("done"),
        DOING("doing"),
        NOT("not");
        
        String desc;

        private DataInitState(String str) {
            this.desc = str;
        }

        public final String toString() {
            return this.desc;
        }
    }

    public final void O000000o(DataInitState dataInitState) {
        this.O00000oo = dataInitState;
    }

    public BaseCardRender(C c, ArrayList<? extends hcf<C, E, T>> arrayList, ViewGroup viewGroup, Context context, Device device) {
        this.O00000Oo = c;
        this.f10206O000000o = arrayList;
        this.O00000o0 = viewGroup;
        this.O00000o = context;
        this.O00000oO = device;
    }

    public final View O00000o() {
        return this.O00000o0.getChildAt(0);
    }

    public final void O00000oO() {
        Iterator<? extends hcf<C, E, T>> it = this.f10206O000000o.iterator();
        while (it.hasNext()) {
            ((hcf) it.next()).O000000o();
        }
    }

    public final boolean O00000oo() {
        return this.O00000oO.isSetPinCode == 0 || this.O0000O0o == 2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void O000000o(Class<?> cls) {
        Intent intent;
        this.O0000O0o = 1;
        Intent intent2 = new Intent(this.O00000o, cls);
        intent2.putExtra("extra_device_did", this.O00000oO.did);
        intent2.putExtra("verfy_pincode_first", true);
        Context context = this.O00000o;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            intent2.putExtras(intent);
        }
        ((Activity) this.O00000o).startActivityForResult(intent2, 4);
    }

    public void O000000o() {
        Iterator<? extends hcf<C, E, T>> it = this.f10206O000000o.iterator();
        while (it.hasNext()) {
            ((hcf) it.next()).O000000o(this.O00000oo);
        }
    }
}
