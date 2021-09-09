package com.miui.tsmclient.net.request;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.common.net.request.SecureRequest;
import com.miui.tsmclient.entity.CardExtraInfo;
import com.miui.tsmclient.entity.CardInfo;
import java.io.IOException;
import java.util.Locale;

public class a extends SecureRequest<CardExtraInfo> {

    /* renamed from: a  reason: collision with root package name */
    private CardInfo f3889a;
    private String b;

    public a(CardInfo cardInfo, String str) {
        super(0, "api/%s/spcard/queryBusCard", TypeToken.get(CardExtraInfo.class));
        this.f3889a = cardInfo;
        this.b = str;
        addParams("deviceModel", com.miui.tsmclient.util.a.b(this.f3889a)).addParams("type", cardInfo.mCardType).addParams("cardNo", cardInfo.mCardNo).addParams("realCardNo", cardInfo.mRealCardNo).addParams("lang", Locale.getDefault().toString()).addParams("miuiRomType", com.miui.tsmclient.util.a.a(this.f3889a)).addParams("miuiSystemVersion", com.miui.tsmclient.util.a.a());
    }

    public void addExtraParams() throws IOException {
        super.addExtraParams();
        if (TextUtils.isEmpty(this.f3889a.mAid) || TextUtils.isEmpty(this.b)) {
            throw new IOException("params can't be null");
        }
        addParams("aid", this.f3889a.mAid);
        addParams("cplc", this.b);
    }
}
