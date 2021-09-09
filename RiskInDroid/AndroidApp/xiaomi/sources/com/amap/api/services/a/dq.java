package com.amap.api.services.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class dq extends dw {

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f3410a = new ByteArrayOutputStream();

    public dq() {
    }

    public dq(dw dwVar) {
        super(dwVar);
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        byte[] byteArray = this.f3410a.toByteArray();
        try {
            this.f3410a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f3410a = new ByteArrayOutputStream();
        return byteArray;
    }

    public void b(byte[] bArr) {
        try {
            this.f3410a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
