package _m_j;

import android.graphics.drawable.NinePatchDrawable;
import java.util.HashMap;

public final class iqe {

    /* renamed from: O000000o  reason: collision with root package name */
    private static iqe f1553O000000o;
    private HashMap<String, NinePatchDrawable> O00000Oo = new HashMap<>();

    public static iqe O000000o() {
        if (f1553O000000o == null) {
            f1553O000000o = new iqe();
        }
        return f1553O000000o;
    }

    protected iqe() {
    }

    public final void O000000o(String str, NinePatchDrawable ninePatchDrawable) {
        this.O00000Oo.put(str, ninePatchDrawable);
    }

    public final NinePatchDrawable O000000o(String str) {
        return this.O00000Oo.get(str);
    }

    public final boolean O00000Oo(String str) {
        return this.O00000Oo.containsKey(str);
    }
}
