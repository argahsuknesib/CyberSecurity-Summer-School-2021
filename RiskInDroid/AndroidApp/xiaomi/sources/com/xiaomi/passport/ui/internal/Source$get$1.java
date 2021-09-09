package com.xiaomi.passport.ui.internal;

import _m_j.ehp;
import _m_j.iuh;
import _m_j.iwc;
import _m_j.ixe;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "V", "it", "Lcom/xiaomi/passport/ui/internal/Result;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class Source$get$1 extends Lambda implements iwc<ehp<V>, iuh> {
    final /* synthetic */ iwc $fail;
    final /* synthetic */ iwc $success;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Source$get$1(iwc iwc, iwc iwc2) {
        super(1);
        this.$success = iwc;
        this.$fail = iwc2;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        ehp ehp = (ehp) obj;
        ixe.O00000o0(ehp, "it");
        if (ehp instanceof ehp.O00000Oo) {
            iwc iwc = this.$success;
            V v = ehp.f15298O000000o;
            if (v == null) {
                ixe.O000000o();
            }
            iwc.invoke(v);
        } else if (ehp instanceof ehp.O000000o) {
            iwc iwc2 = this.$fail;
            Throwable th = ehp.O00000Oo;
            if (th == null) {
                ixe.O000000o();
            }
            iwc2.invoke(th);
        }
        return iuh.f1631O000000o;
    }
}
