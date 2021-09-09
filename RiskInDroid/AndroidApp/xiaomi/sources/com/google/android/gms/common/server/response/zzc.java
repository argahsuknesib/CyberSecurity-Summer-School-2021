package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

final class zzc implements FastParser.zza<Float> {
    zzc() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return Float.valueOf(fastParser.zzg(bufferedReader));
    }
}
