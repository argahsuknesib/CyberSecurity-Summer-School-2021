package com.google.android.play.core.splitcompat;

import java.io.File;

final class b extends r {

    /* renamed from: a  reason: collision with root package name */
    private final File f3777a;
    private final String b;

    b(File file, String str) {
        if (file != null) {
            this.f3777a = file;
            if (str != null) {
                this.b = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    /* access modifiers changed from: package-private */
    public final File a() {
        return this.f3777a;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return this.f3777a.equals(rVar.a()) && this.b.equals(rVar.b());
        }
    }

    public final int hashCode() {
        return ((this.f3777a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f3777a);
        String str = this.b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
