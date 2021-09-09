package com.amap.api.services.a;

public class dt extends dw {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f3413a = new StringBuilder();
    private boolean b = true;

    public dt() {
    }

    public dt(dw dwVar) {
        super(dwVar);
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        byte[] a2 = bz.a(this.f3413a.toString());
        c(a2);
        this.b = true;
        StringBuilder sb = this.f3413a;
        sb.delete(0, sb.length());
        return a2;
    }

    public void b(byte[] bArr) {
        String a2 = bz.a(bArr);
        if (this.b) {
            this.b = false;
        } else {
            this.f3413a.append(",");
        }
        StringBuilder sb = this.f3413a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }
}
