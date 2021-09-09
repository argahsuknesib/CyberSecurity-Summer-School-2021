package _m_j;

import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

public final class cfk implements Recharge {

    /* renamed from: O000000o  reason: collision with root package name */
    private final String f13719O000000o = "ALIPAYDEDUCT";

    public final boolean available(Context context) {
        return true;
    }

    public final String getChannel() {
        return "ALIPAYDEDUCT";
    }

    public final Intent getEntryIntent(boolean z) {
        return null;
    }

    public final RechargeMethodParser getParser() {
        return new cga();
    }
}
