package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

final class zzd implements FastParser.zza<Double> {
    zzd() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return Double.valueOf(fastParser.zzh(bufferedReader));
    }
}
