package com.google.android.play.core.assetpacks;

import java.util.Arrays;

final class bl extends dx {

    /* renamed from: a  reason: collision with root package name */
    private final String f3656a;
    private final long b;
    private final int c;
    private final boolean d;
    private final byte[] e;

    bl(String str, long j, int i, boolean z, byte[] bArr) {
        this.f3656a = str;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = bArr;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f3656a;
    }

    /* access modifiers changed from: package-private */
    public final long b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final int c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final byte[] e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dx) {
            dx dxVar = (dx) obj;
            String str = this.f3656a;
            if (str == null ? dxVar.a() == null : str.equals(dxVar.a())) {
                if (this.b == dxVar.b() && this.c == dxVar.c() && this.d == dxVar.d()) {
                    if (Arrays.equals(this.e, dxVar instanceof bl ? ((bl) dxVar).e : dxVar.e())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f3656a;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return ((((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ Arrays.hashCode(this.e);
    }

    public final String toString() {
        String str = this.f3656a;
        long j = this.b;
        int i = this.c;
        boolean z = this.d;
        String arrays = Arrays.toString(this.e);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 104 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
