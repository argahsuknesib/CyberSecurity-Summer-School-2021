package _m_j;

import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;

public class cuh extends cvg {
    public cuh(Context context, String str) {
        super(context, str);
    }

    public cuh(Context context, String str, HashMap<String, Object> hashMap) {
        super(context, str, hashMap);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg
     arg types: [java.lang.String, int]
     candidates:
      _m_j.cuh.O000000o(java.lang.String, java.lang.String):_m_j.cuh
      _m_j.cvg.O000000o(java.lang.String, boolean):boolean
      _m_j.cvg.O000000o(java.lang.String, java.lang.Object):_m_j.cvg */
    public final cuh O000000o() {
        O000000o("com.sankuai.waimai.router.activity.flags", (Object) 268435456);
        return this;
    }

    public final cuh O000000o(String str, String str2) {
        O00000oo().putString(str, str2);
        return this;
    }

    private synchronized Bundle O00000oo() {
        Bundle bundle;
        bundle = (Bundle) O000000o(Bundle.class, "com.sankuai.waimai.router.activity.intent_extra", null);
        if (bundle == null) {
            bundle = new Bundle();
            O000000o("com.sankuai.waimai.router.activity.intent_extra", bundle);
        }
        return bundle;
    }

    public final /* bridge */ /* synthetic */ cvg O000000o(String str) {
        return (cuh) super.O000000o(str);
    }
}
