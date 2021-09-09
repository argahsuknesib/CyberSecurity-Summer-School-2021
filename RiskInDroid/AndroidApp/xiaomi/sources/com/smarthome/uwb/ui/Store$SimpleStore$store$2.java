package com.smarthome.uwb.ui;

import _m_j.dds;
import _m_j.iwb;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003H\n"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "T"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class Store$SimpleStore$store$2 extends Lambda implements iwb<SharedPreferences> {
    final /* synthetic */ dds.O000000o<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Store$SimpleStore$store$2(dds.O000000o<T> o000000o) {
        super(0);
        this.this$0 = o000000o;
    }

    public final /* synthetic */ Object invoke() {
        return this.this$0.f14517O000000o.getSharedPreferences(this.this$0.O00000Oo, 0);
    }
}
