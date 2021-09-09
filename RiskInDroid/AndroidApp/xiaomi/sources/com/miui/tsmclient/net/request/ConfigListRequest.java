package com.miui.tsmclient.net.request;

import com.miui.tsmclient.common.net.ResponseListener;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.GroupConfigInfo;
import com.miui.tsmclient.util.DeviceUtils;
import java.util.Locale;

public class ConfigListRequest extends SecureRequest<GroupConfigInfo> {
    public ConfigListRequest(CardInfo cardInfo, String str, ResponseListener<GroupConfigInfo> responseListener) {
        super(1, "api/%s/clientConfig/queryGroupedConfigs", GroupConfigInfo.class, responseListener);
        addParams("deviceModel", DeviceUtils.getDeviceModel(cardInfo)).addParams("cardName", cardInfo == null ? null : cardInfo.mCardType).addParams("key", str).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", DeviceUtils.getMIUIRomType(cardInfo)).addParams("miuiSystemVersion", DeviceUtils.getRomVersion());
    }
}
