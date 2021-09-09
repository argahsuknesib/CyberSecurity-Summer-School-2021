package com.miui.tsmclient.model.e;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.model.e.h;
import com.miui.tsmclient.seitsm.TsmRpcModels;
import com.miui.tsmclient.seitsm.a.a;
import java.io.IOException;

public class c extends d {
    private d e;

    public c(d dVar) {
        this.e = dVar;
    }

    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.e.a(context, cardInfo, bundle);
    }

    public BaseResponse a(Context context, CardInfo cardInfo, TsmRpcModels.TsmSessionInfo tsmSessionInfo, Bundle bundle) throws IOException, a, InterruptedException {
        return this.e.a(context, cardInfo, tsmSessionInfo, bundle);
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo, h.a aVar) throws a {
        return this.e.a(context, cardInfo, aVar);
    }

    public TsmRpcModels.TsmSessionInfo a(Context context, CardInfo cardInfo, h.a aVar, boolean z) throws a {
        return this.e.a(context, cardInfo, aVar, z);
    }

    public BaseResponse b(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.e.b(context, cardInfo, bundle);
    }

    public BaseResponse c(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.e.c(context, cardInfo, bundle);
    }

    public BaseResponse d(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.e.d(context, cardInfo, bundle);
    }

    public BaseResponse e(Context context, CardInfo cardInfo, Bundle bundle) {
        return this.e.e(context, cardInfo, bundle);
    }
}
