package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;

final class zzd implements TextFilterable.StringFilter {
    zzd() {
    }

    public final boolean matches(String str, String str2) {
        return str.startsWith(str2);
    }
}
