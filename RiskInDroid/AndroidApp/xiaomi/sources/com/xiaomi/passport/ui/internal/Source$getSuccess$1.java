package com.xiaomi.passport.ui.internal;

import _m_j.eic;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.utils.AccountLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "V", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
public final class Source$getSuccess$1 extends Lambda implements iwc<Throwable, iuh> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Source$getSuccess$1 f6261O000000o = new Source$getSuccess$1();

    Source$getSuccess$1() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ixe.O00000o0(th, "it");
        eic.O000000o o000000o = eic.O00000Oo;
        if (eic.f15314O000000o) {
            th.printStackTrace();
        } else {
            AccountLog.e("Source", "request fail", th);
        }
        return iuh.f1631O000000o;
    }
}
