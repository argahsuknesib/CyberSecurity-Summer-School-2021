package com.google.android.gms.common.data;

import com.google.android.gms.common.data.TextFilterable;

final class zze implements TextFilterable.StringFilter {
    zze() {
    }

    public final boolean matches(String str, String str2) {
        if (str.startsWith(str2)) {
            return true;
        }
        String valueOf = String.valueOf(str2);
        return str.contains(valueOf.length() != 0 ? " ".concat(valueOf) : new String(" "));
    }
}
