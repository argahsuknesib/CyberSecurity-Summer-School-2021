package com.smarthome.uwb.ui;

import _m_j.dds;
import _m_j.gpp;
import _m_j.iwb;
import _m_j.ixe;
import android.content.Context;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class UwbBindHelper$UwbTagApi$tagDetailStore$2 extends Lambda implements iwb<dds.O000000o<String>> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final UwbBindHelper$UwbTagApi$tagDetailStore$2 f5670O000000o = new UwbBindHelper$UwbTagApi$tagDetailStore$2();

    UwbBindHelper$UwbTagApi$tagDetailStore$2() {
        super(0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final /* synthetic */ Object invoke() {
        dds dds = dds.f14516O000000o;
        Context appContext = ServiceApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        return dds.O000000o(appContext, ixe.O000000o("UwbTagApi_", (Object) gpp.O00000Oo(CoreApi.O000000o().O0000o0())), false);
    }
}
