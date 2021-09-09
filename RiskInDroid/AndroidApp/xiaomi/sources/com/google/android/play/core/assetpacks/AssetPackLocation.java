package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackStorageMethod;
import com.google.android.play.core.splitcompat.q;

public abstract class AssetPackLocation {

    /* renamed from: a  reason: collision with root package name */
    private static final AssetPackLocation f3625a = new bh(1, null, null);

    static AssetPackLocation a() {
        return f3625a;
    }

    static AssetPackLocation a(String str, String str2) {
        q.a(str, "STORAGE_FILES location path must be non-null");
        q.a(str, "STORAGE_FILES assetsPath must be non-null");
        return new bh(0, str, str2);
    }

    public abstract String assetsPath();

    @AssetPackStorageMethod
    public abstract int packStorageMethod();

    public abstract String path();
}
