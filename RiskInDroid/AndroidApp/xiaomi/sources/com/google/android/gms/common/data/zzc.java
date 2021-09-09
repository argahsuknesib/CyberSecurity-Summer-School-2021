package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;

final class zzc implements TextFilterable.StringFilter {
    zzc() {
    }

    public final boolean matches(String str, String str2) {
        return str.contains(str2);
    }
}
