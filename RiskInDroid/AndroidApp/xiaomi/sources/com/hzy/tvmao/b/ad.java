package com.hzy.tvmao.b;

import android.text.TextUtils;
import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.db.bean.ChannelInfo;
import com.hzy.tvmao.model.legacy.api.i;
import java.util.List;

class ad extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ w g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(w wVar, a.c cVar, String str, int i, String str2) {
        super(cVar, str);
        this.g = wVar;
        this.e = i;
        this.f = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        String str;
        List<ChannelInfo> c = com.hzy.tvmao.model.db.a.a.a().c(this.e);
        StringBuffer stringBuffer = new StringBuffer();
        for (ChannelInfo next : c) {
            boolean isEmpty = TextUtils.isEmpty(next.countryId);
            StringBuilder sb = new StringBuilder();
            sb.append(next.channelId);
            sb.append("|");
            sb.append((int) next.isHd);
            if (isEmpty) {
                str = "";
            } else {
                str = "|" + next.countryId;
            }
            sb.append(str);
            sb.append(",");
            stringBuffer.append(sb.toString());
        }
        return new com.hzy.tvmao.b.a.a(i.b(this.f, stringBuffer.toString()));
    }
}
