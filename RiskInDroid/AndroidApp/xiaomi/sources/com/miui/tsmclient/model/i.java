package com.miui.tsmclient.model;

import android.content.Context;
import android.os.Bundle;
import com.miui.tsmclient.a;
import com.miui.tsmclient.entity.CardInfo;

public interface i<T extends CardInfo> extends a {
    BaseResponse a(Context context, CardInfo cardInfo);

    BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle);

    BaseResponse b(Context context, T t, Bundle bundle);

    BaseResponse c(Context context, T t, Bundle bundle);

    BaseResponse d(Context context, T t, Bundle bundle);

    BaseResponse e(Context context, T t, Bundle bundle);

    BaseResponse f(Context context, T t, Bundle bundle);

    BaseResponse g(Context context, T t, Bundle bundle);

    BaseResponse h(Context context, T t, Bundle bundle);
}
