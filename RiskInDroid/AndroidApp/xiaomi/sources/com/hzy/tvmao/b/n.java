package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;
import com.hzy.tvmao.model.db.bean.ChannelInfo;
import java.util.HashMap;
import java.util.List;

public class n extends a {
    public static String b = "getLineUps";
    public static String c = "getLineupDataAndSave";
    private static n d;
    private HashMap<ChannelInfo.a, ChannelInfo> e;
    private int f;

    public static n c() {
        if (d == null) {
            d = new n();
        }
        return d;
    }

    public void a(int i, int i2, a.c cVar) {
        new o(this, cVar, b, i, i2).a();
    }

    public ChannelInfo a(int i, String str, int i2) {
        if (this.e == null) {
            a(this.f);
        }
        ChannelInfo.a aVar = new ChannelInfo.a();
        aVar.f4428a = i;
        aVar.b = str;
        aVar.c = i2;
        return this.e.get(aVar);
    }

    public void a(int i, int i2, int i3, a.c cVar) {
        new p(this, cVar, c, i3, i2, i).a();
    }

    public boolean a(int i) {
        HashMap<ChannelInfo.a, ChannelInfo> hashMap = this.e;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.e = com.hzy.tvmao.model.db.a.a.a().a(i);
        this.f = i;
        return this.e != null;
    }

    public HashMap<ChannelInfo.a, ChannelInfo> d() {
        if (this.e == null) {
            a(this.f);
        }
        return this.e;
    }

    public List<ChannelInfo> b(int i) {
        return com.hzy.tvmao.model.db.a.a.a().b(i);
    }
}
