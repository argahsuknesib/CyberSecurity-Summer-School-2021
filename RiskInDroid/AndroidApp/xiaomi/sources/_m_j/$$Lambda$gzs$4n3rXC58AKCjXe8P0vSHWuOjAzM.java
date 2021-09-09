package _m_j;

import android.content.Intent;
import io.reactivex.functions.Function;

/* renamed from: _m_j.-$$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM implements Function {
    public static final /* synthetic */ $$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM INSTANCE = new $$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM();

    private /* synthetic */ $$Lambda$gzs$4n3rXC58AKCjXe8P0vSHWuOjAzM() {
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((Intent) obj).getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }
}
