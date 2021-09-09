package com.miui.tsmclient.model.e;

import android.content.Context;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static h f3880a = new h();
    private com.miui.tsmclient.seitsm.a b = new com.miui.tsmclient.seitsm.a();
    private Map<String, TsmRpcModels.TsmSessionInfo> c = new HashMap();

    public enum a {
        INSTALL,
        DELETE,
        RECHARGE,
        LOCK,
        QUERY,
        PREPARE_PAY,
        PERSO,
        SAVEKEY,
        TRANSFER_OUT,
        TRANSFER_IN,
        OUT_INSTALL,
        OUT_RECHARGE,
        OUT_RETURN,
        INTERNAL_RETURN,
        READ_CARD
    }

    private h() {
    }

    public static h a() {
        return f3880a;
    }

    private String b(CardInfo cardInfo, a aVar) {
        if (cardInfo == null || aVar == null) {
            return null;
        }
        return cardInfo.mCardType + "_" + aVar.toString();
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo) throws com.miui.tsmclient.seitsm.a.a {
        return this.b.a(context, cardInfo);
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo, a aVar, boolean z) throws com.miui.tsmclient.seitsm.a.a {
        TsmRpcModels.TsmSessionInfo tsmSessionInfo;
        String b2 = b(cardInfo, aVar);
        synchronized (this.c) {
            if (!this.c.containsKey(b2) || z) {
                this.c.put(b2, this.b.a(context, cardInfo));
            }
            tsmSessionInfo = this.c.get(b2);
        }
        return tsmSessionInfo;
    }

    public TsmRpcModels.TsmSessionInfo a(CardInfo cardInfo, a aVar) {
        TsmRpcModels.TsmSessionInfo remove;
        synchronized (this.c) {
            remove = this.c.remove(b(cardInfo, aVar));
        }
        return remove;
    }
}
