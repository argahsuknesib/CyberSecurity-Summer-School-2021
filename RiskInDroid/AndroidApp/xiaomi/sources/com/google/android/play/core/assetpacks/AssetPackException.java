package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.a;
import com.google.android.play.core.tasks.j;

public class AssetPackException extends j {
    @AssetPackErrorCode

    /* renamed from: a  reason: collision with root package name */
    private final int f3623a;

    AssetPackException(@AssetPackErrorCode int i) {
        super(String.format("Asset Pack Download Error(%d): %s", Integer.valueOf(i), a.a(i)));
        if (i != 0) {
            this.f3623a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @AssetPackErrorCode
    public int getErrorCode() {
        return this.f3623a;
    }
}
