package com.miui.tsmclient.model;

import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.a.d;
import com.miui.tsmclient.model.b.b;
import com.miui.tsmclient.model.e.a;

public class g {
    public static i a(String str) {
        return CardInfo.SPTC_TYPE_SET.contains(str) ? new b(str) : TextUtils.equals(str, "BANKCARD") ? new com.miui.tsmclient.model.a.b() : TextUtils.equals(str, "VSIM") ? new a() : TextUtils.equals(str, "MIFARE_ENTRANCE") ? new com.miui.tsmclient.model.d.b() : TextUtils.equals(str, "EID") ? new com.miui.tsmclient.model.c.b() : TextUtils.equals(str, "QRBANKCARD") ? new d() : new m(str);
    }
}
