package com.xiaomi.onetrack;

import android.content.Context;
import com.xiaomi.onetrack.OneTrack;
import com.xiaomi.onetrack.g.c;

public class OTUtil {
    public static OneTrack.NetType getNetWorkType(Context context) {
        return c.a(context);
    }
}
