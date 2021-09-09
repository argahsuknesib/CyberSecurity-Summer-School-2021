package _m_j;

import java.text.SimpleDateFormat;

final class eci extends ThreadLocal {
    eci() {
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
