package com.miui.tsmclient.model;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.miui.tsmclient.entity.CardInfo;

public class f {

    /* renamed from: a  reason: collision with root package name */
    protected Context f3882a;
    protected String b;

    public f(Context context) {
        this.f3882a = context;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            int i = 0;
            while (true) {
                if (i < stackTrace.length) {
                    if (TextUtils.equals(getClass().getName(), stackTrace[i].getClassName()) && i < stackTrace.length - 1) {
                        this.b = stackTrace[i + 1].getClassName();
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        if (this.b == null) {
            this.b = toString();
        }
    }

    public BaseResponse a(Context context, CardInfo cardInfo, Bundle bundle) {
        if (cardInfo == null) {
            return new BaseResponse(1, new Object[0]);
        }
        BaseResponse d = e.a().a(this.b, cardInfo.mCardType).d(context, cardInfo, bundle);
        return d == null ? new BaseResponse(-2, new Object[0]) : d;
    }

    public void a() {
        e.a().a(this.b);
    }
}
