package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;

final class bh extends AssetPackLocation {

    /* renamed from: a  reason: collision with root package name */
    private final int f3652a;
    private final String b;
    private final String c;

    bh(int i, String str, String str2) {
        this.f3652a = i;
        this.b = str;
        this.c = str2;
    }

    public final String assetsPath() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackLocation) {
            AssetPackLocation assetPackLocation = (AssetPackLocation) obj;
            return this.f3652a == assetPackLocation.packStorageMethod() && ((str = this.b) == null ? assetPackLocation.path() == null : str.equals(assetPackLocation.path())) && ((str2 = this.c) == null ? assetPackLocation.assetsPath() == null : str2.equals(assetPackLocation.assetsPath()));
        }
    }

    public final int hashCode() {
        int i = (this.f3652a ^ 1000003) * 1000003;
        String str = this.b;
        int i2 = 0;
        int hashCode = (i ^ (str != null ? str.hashCode() : 0)) * 1000003;
        String str2 = this.c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode ^ i2;
    }

    @AssetPackStorageMethod
    public final int packStorageMethod() {
        return this.f3652a;
    }

    public final String path() {
        return this.b;
    }

    public final String toString() {
        int i = this.f3652a;
        String str = this.b;
        String str2 = this.c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str2).length());
        sb.append("AssetPackLocation{packStorageMethod=");
        sb.append(i);
        sb.append(", path=");
        sb.append(str);
        sb.append(", assetsPath=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
