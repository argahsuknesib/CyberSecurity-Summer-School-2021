package _m_j;

import android.content.Intent;
import io.reactivex.functions.Function;

/* renamed from: _m_j.-$$Lambda$gzs$LuXbXYeINNuR6GEt-RygH-0mUJA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$gzs$LuXbXYeINNuR6GEtRygH0mUJA implements Function {
    public static final /* synthetic */ $$Lambda$gzs$LuXbXYeINNuR6GEtRygH0mUJA INSTANCE = new $$Lambda$gzs$LuXbXYeINNuR6GEtRygH0mUJA();

    private /* synthetic */ $$Lambda$gzs$LuXbXYeINNuR6GEtRygH0mUJA() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((Intent) obj).getBooleanExtra("main_extra_card_edit_mode_is_edit_mode", false));
    }
}
