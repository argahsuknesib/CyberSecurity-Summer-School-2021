package com.miui.tsmclient.net.request;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.BulletinResponseInfo;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.util.DeviceUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BulletinListSyncRequest extends SecureRequest<BulletinResponseInfo> {
    public BulletinListSyncRequest(String str, CardInfo cardInfo, String str2, Map<String, String> map) {
        super(0, "api/%s/message/query/bulletins", TypeToken.get(BulletinResponseInfo.class));
        addParams("tag", str).addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("lang", Locale.getDefault().toString()).addParams("cplc", str2);
        if (cardInfo != null) {
            map = map == null ? new HashMap<>() : map;
            map.put("cardName", cardInfo.mCardType);
            map.put("aid", cardInfo.mAid);
        }
        if (map != null) {
            addParams("extra", new Gson().toJson(map));
        }
    }
}
