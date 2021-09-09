package cn.com.xm.bt.e;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f3094a;
    private List<UUID> b;
    private String c;
    private d d;
    private boolean e;

    private b(a aVar) {
        this.f3094a = -1;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f3094a = aVar.f3095a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
    }

    public int a() {
        return this.f3094a;
    }

    public List<UUID> b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public d d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public String toString() {
        return "timeout:" + this.f3094a + ",filterUuid size:" + this.b.size() + ",filterAddress:" + this.c + ",needConnectedDevice:" + this.e;
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f3095a = -1;
        /* access modifiers changed from: private */
        public final List<UUID> b = new ArrayList();
        /* access modifiers changed from: private */
        public String c = null;
        /* access modifiers changed from: private */
        public d d = null;
        /* access modifiers changed from: private */
        public boolean e = false;

        public a a(int i) {
            this.f3095a = i;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(d dVar) {
            this.d = dVar;
            return this;
        }

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }
}
