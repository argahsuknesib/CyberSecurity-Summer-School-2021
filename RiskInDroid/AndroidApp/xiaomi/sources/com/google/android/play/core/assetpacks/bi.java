package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;

final class bi extends AssetPackState {

    /* renamed from: a  reason: collision with root package name */
    private final String f3653a;
    private final int b;
    private final int c;
    private final long d;
    private final long e;
    private final int f;

    bi(String str, int i, int i2, long j, long j2, int i3) {
        if (str != null) {
            this.f3653a = str;
            this.b = i;
            this.c = i2;
            this.d = j;
            this.e = j2;
            this.f = i3;
            return;
        }
        throw new NullPointerException("Null name");
    }

    public final long bytesDownloaded() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f3653a.equals(assetPackState.name()) && this.b == assetPackState.status() && this.c == assetPackState.errorCode() && this.d == assetPackState.bytesDownloaded() && this.e == assetPackState.totalBytesToDownload() && this.f == assetPackState.transferProgressPercentage();
        }
    }

    @AssetPackErrorCode
    public final int errorCode() {
        return this.c;
    }

    public final int hashCode() {
        int hashCode = this.f3653a.hashCode();
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f;
    }

    public final String name() {
        return this.f3653a;
    }

    @AssetPackStatus
    public final int status() {
        return this.b;
    }

    public final String toString() {
        String str = this.f3653a;
        int i = this.b;
        int i2 = this.c;
        long j = this.d;
        long j2 = this.e;
        int i3 = this.f;
        StringBuilder sb = new StringBuilder(str.length() + 185);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.e;
    }

    public final int transferProgressPercentage() {
        return this.f;
    }
}
