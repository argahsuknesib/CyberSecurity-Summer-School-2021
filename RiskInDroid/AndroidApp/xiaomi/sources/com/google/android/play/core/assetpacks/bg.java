package com.google.android.play.core.assetpacks;

final class bg extends AssetLocation {

    /* renamed from: a  reason: collision with root package name */
    private final String f3651a;
    private final long b;
    private final long c;

    bg(String str, long j, long j2) {
        if (str != null) {
            this.f3651a = str;
            this.b = j;
            this.c = j2;
            return;
        }
        throw new NullPointerException("Null path");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetLocation) {
            AssetLocation assetLocation = (AssetLocation) obj;
            return this.f3651a.equals(assetLocation.path()) && this.b == assetLocation.offset() && this.c == assetLocation.size();
        }
    }

    public final int hashCode() {
        int hashCode = this.f3651a.hashCode();
        long j = this.b;
        long j2 = this.c;
        return ((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final long offset() {
        return this.b;
    }

    public final String path() {
        return this.f3651a;
    }

    public final long size() {
        return this.c;
    }

    public final String toString() {
        String str = this.f3651a;
        long j = this.b;
        long j2 = this.c;
        StringBuilder sb = new StringBuilder(str.length() + 76);
        sb.append("AssetLocation{path=");
        sb.append(str);
        sb.append(", offset=");
        sb.append(j);
        sb.append(", size=");
        sb.append(j2);
        sb.append("}");
        return sb.toString();
    }
}
