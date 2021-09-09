package com.google.android.play.core.assetpacks;

final class bk extends dq {

    /* renamed from: a  reason: collision with root package name */
    private final int f3655a;
    private final String b;
    private final long c;
    private final long d;
    private final int e;

    bk(int i, String str, long j, long j2, int i2) {
        this.f3655a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f3655a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final long c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof dq) {
            dq dqVar = (dq) obj;
            return this.f3655a == dqVar.a() && ((str = this.b) == null ? dqVar.b() == null : str.equals(dqVar.b())) && this.c == dqVar.c() && this.d == dqVar.d() && this.e == dqVar.e();
        }
    }

    public final int hashCode() {
        int i = (this.f3655a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str != null ? str.hashCode() : 0;
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public final String toString() {
        int i = this.f3655a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
