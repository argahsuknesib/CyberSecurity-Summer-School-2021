package _m_j;

import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.common.Utils;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

public final class cgf implements Recharge {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f13764O000000o = "MIPAYDEDUCT";

    public final String getChannel() {
        return "MIPAYDEDUCT";
    }

    public final Intent getEntryIntent(boolean z) {
        return null;
    }

    public final RechargeMethodParser getParser() {
        return new cgg();
    }

    public final boolean available(Context context) {
        return !Utils.isPad();
    }
}
