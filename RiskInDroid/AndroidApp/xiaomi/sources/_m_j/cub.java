package _m_j;

import android.annotation.SuppressLint;
import com.sankuai.waimai.router.core.RootUriHandler;

public final class cub {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: O000000o  reason: collision with root package name */
    public static RootUriHandler f14361O000000o;

    public static <I, T extends I> T O000000o(Class<I> cls, String str) {
        return cza.O000000o(cza.O000000o(cls).O00000Oo.get(str), null);
    }

    public static <I, T extends I> T O000000o(Class<I> cls, String str, cyy cyy) {
        return cza.O000000o(cza.O000000o(cls).O00000Oo.get(str), cyy);
    }

    public static <I, T extends I> Class<T> O00000Oo(Class<I> cls, String str) {
        return cza.O000000o(cls).O00000Oo.get(str).O00000Oo;
    }

    public static void O000000o(cvg cvg) {
        RootUriHandler rootUriHandler = f14361O000000o;
        if (rootUriHandler != null) {
            rootUriHandler.O00000Oo(cvg);
            return;
        }
        throw new RuntimeException("请先调用init初始化UriRouter");
    }
}
