package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

final class zzh implements FastParser.zza<BigDecimal> {
    zzh() {
    }

    public final /* synthetic */ Object zzh(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        return fastParser.zzi(bufferedReader);
    }
}
