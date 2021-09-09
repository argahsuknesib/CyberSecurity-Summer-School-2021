package com.miui.tsmclient.entity;

import android.content.Context;
import com.miui.tsmclient.util.DeviceUtils;
import java.util.HashMap;
import java.util.Map;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private CardInfo f3869a;
    private a b;

    public enum a {
        ISSUE(1),
        RECHARGE(2),
        TRANSFER_OUT(4),
        TRANSFER_IN(5),
        AFTER_SALE(10);
        
        private int f;

        private a(int i) {
            this.f = i;
        }
    }

    public enum b {
        ANDROID(0),
        IOS(1);
        
        private int c;

        private b(int i) {
            this.c = i;
        }
    }

    public i(CardInfo cardInfo, a aVar) {
        this.f3869a = cardInfo;
        this.b = aVar;
    }

    public Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        CardInfo cardInfo = this.f3869a;
        if (cardInfo != null) {
            hashMap.put("cardName", cardInfo.mCardType);
        }
        a aVar = this.b;
        if (aVar != null) {
            hashMap.put("cardActionType", aVar.toString());
        }
        hashMap.put("deviceModel", DeviceUtils.getDeviceModel(null));
        hashMap.put("miuiRomType", DeviceUtils.getMIUIRomType(null));
        hashMap.put("miuiSystemVersion", DeviceUtils.getRomVersion());
        hashMap.put("OS", b.ANDROID.toString());
        return hashMap;
    }
}
