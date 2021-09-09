package _m_j;

import android.content.Intent;
import io.reactivex.functions.Function;

/* renamed from: _m_j.-$$Lambda$gzs$6Vvg-oYQ6lx1tSNyPIEORqoROdQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$gzs$6VvgoYQ6lx1tSNyPIEORqoROdQ implements Function {
    public static final /* synthetic */ $$Lambda$gzs$6VvgoYQ6lx1tSNyPIEORqoROdQ INSTANCE = new $$Lambda$gzs$6VvgoYQ6lx1tSNyPIEORqoROdQ();

    private /* synthetic */ $$Lambda$gzs$6VvgoYQ6lx1tSNyPIEORqoROdQ() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((Intent) obj).getBooleanExtra("main_extra_camera_edit_mode_is_edit_mode", false));
    }
}
