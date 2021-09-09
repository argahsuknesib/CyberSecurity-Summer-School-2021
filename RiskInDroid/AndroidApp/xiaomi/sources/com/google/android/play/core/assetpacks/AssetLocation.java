package com.google.android.play.core.assetpacks;

public abstract class AssetLocation {
    static AssetLocation a(String str, long j, long j2) {
        return new bg(str, j, j2);
    }

    public abstract long offset();

    public abstract String path();

    public abstract long size();
}
