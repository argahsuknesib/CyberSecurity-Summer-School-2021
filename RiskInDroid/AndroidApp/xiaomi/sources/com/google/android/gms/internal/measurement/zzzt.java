package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzzt extends IOException {
    private zzaal zzbst = null;

    public zzzt(String str) {
        super(str);
    }

    static zzzt zztm() {
        return new zzzt("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzzt zztn() {
        return new zzzt("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
