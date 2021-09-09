package _m_j;

import android.content.Intent;
import io.reactivex.functions.Function;

/* renamed from: _m_j.-$$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA implements Function {
    public static final /* synthetic */ $$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA INSTANCE = new $$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA();

    private /* synthetic */ $$Lambda$hgb$KsYCkhjigSuaF8XFQyxOf8yDdHA() {
    }

    public final Object apply(Object obj) {
        return Integer.valueOf(((Intent) obj).getIntExtra("current_state", 2));
    }
}
