package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.legacy.api.data.ManualMatchData;
import com.hzy.tvmao.model.legacy.api.i;
import com.hzy.tvmao.model.legacy.api.n;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.sdk.bean.Channel;
import com.kookong.sdk.bean.ManualMatchLineupData;
import java.util.ArrayList;
import java.util.List;

class v extends a.C0035a {
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ String g;
    final /* synthetic */ q h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    v(q qVar, a.c cVar, String str, int i, int i2, String str2) {
        super(cVar, str);
        this.h = qVar;
        this.e = i;
        this.f = i2;
        this.g = str2;
    }

    /* access modifiers changed from: protected */
    public com.hzy.tvmao.b.a.a b() {
        n<ManualMatchData> a2 = i.a(this.e, this.f, this.g);
        if (a2.a()) {
            ManualMatchData manualMatchData = (ManualMatchData) a2.e;
            List<ManualMatchData.Ch> list = manualMatchData.getList();
            ArrayList arrayList = null;
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (ManualMatchData.Ch create : list) {
                    arrayList.add(Channel.create(create));
                }
            }
            ManualMatchLineupData manualMatchLineupData = new ManualMatchLineupData();
            manualMatchLineupData.setLid(manualMatchData.getLid());
            manualMatchLineupData.setList(arrayList);
            manualMatchLineupData.setResult(manualMatchData.getResult());
            manualMatchLineupData.setResultCode(manualMatchData.getResultCode());
            LogUtil.d("manualMatchLineupData get: " + manualMatchLineupData.toString());
            return new com.hzy.tvmao.b.a.a(1, "manualLineup", manualMatchLineupData);
        }
        LogUtil.e("manualMatchDataServletResult.isOk() = false");
        return new com.hzy.tvmao.b.a.a(a2);
    }
}
