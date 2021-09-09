package com.xiaomi.smarthome.homeroom;

import _m_j.iwn;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "thiz", "", "that"}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class DeviceListAssemble$reorderCategory$2 extends Lambda implements iwn<String, String, Boolean> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final DeviceListAssemble$reorderCategory$2 f8820O000000o = new DeviceListAssemble$reorderCategory$2();

    DeviceListAssemble$reorderCategory$2() {
        super(2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final /* synthetic */ Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        ixe.O00000o(str, "thiz");
        ixe.O00000o(str2, "that");
        return Boolean.valueOf(ixe.O000000o((Object) str, (Object) str2));
    }
}
