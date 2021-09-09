package _m_j;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.yanzhenjie.permission.source.ContextSource;
import java.util.List;

public final class ind {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final O00000o0 f1492O000000o;

    interface O00000o0 {
        ini O000000o(ioh ioh);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f1492O000000o = new O00000Oo((byte) 0);
        } else {
            f1492O000000o = new O000000o((byte) 0);
        }
    }

    public static boolean O000000o(Activity activity, List<String> list) {
        iog iog = new iog(activity);
        for (String O000000o2 : list) {
            if (!iog.O000000o(O000000o2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(Activity activity, String... strArr) {
        iog iog = new iog(activity);
        for (String O000000o2 : strArr) {
            if (!iog.O000000o(O000000o2)) {
                return true;
            }
        }
        return false;
    }

    public static inj O000000o(Activity activity) {
        return new iof(new iog(activity));
    }

    public static ini O00000Oo(Activity activity) {
        return f1492O000000o.O000000o(new iog(activity));
    }

    public static ini O000000o(Context context) {
        return f1492O000000o.O000000o(new ContextSource(context));
    }

    static class O000000o implements O00000o0 {
        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }

        public final ini O000000o(ioh ioh) {
            return new ine(ioh);
        }
    }

    static class O00000Oo implements O00000o0 {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final ini O000000o(ioh ioh) {
            return new inf(ioh);
        }
    }
}
