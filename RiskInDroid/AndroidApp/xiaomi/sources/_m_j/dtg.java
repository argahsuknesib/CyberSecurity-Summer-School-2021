package _m_j;

import com.typesafe.config.impl.AbstractConfigValue;
import java.util.HashMap;
import java.util.Map;

final class dtg {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Map<dsx, AbstractConfigValue> f14919O000000o = new HashMap();

    dtg() {
    }

    /* access modifiers changed from: package-private */
    public final AbstractConfigValue O000000o(dsx dsx) {
        return this.f14919O000000o.get(dsx);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dsx dsx, AbstractConfigValue abstractConfigValue) {
        this.f14919O000000o.put(dsx, abstractConfigValue);
    }
}
