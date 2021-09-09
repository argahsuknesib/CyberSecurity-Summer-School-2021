package com.xiaomi.smarthome.uwb.ui.widget;

import _m_j.iwb;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;"}, k = 3, mv = {1, 5, 1}, xi = 48)
final class SHLoadingDialog$formatter$2 extends Lambda implements iwb<SimpleDateFormat> {
    public static final SHLoadingDialog$formatter$2 INSTANCE = new SHLoadingDialog$formatter$2();

    SHLoadingDialog$formatter$2() {
        super(0);
    }

    public final SimpleDateFormat invoke() {
        return new SimpleDateFormat("HH:mm:ss");
    }
}
