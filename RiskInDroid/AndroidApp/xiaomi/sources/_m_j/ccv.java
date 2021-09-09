package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.mi.mistatistic.sdk.controller.MiStatOptions;
import com.mi.mistatistic.sdk.data.EventData;
import java.util.ArrayList;

public abstract class ccv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static MiStatOptions f13641O000000o;

    public static MiStatOptions O000000o() {
        if (f13641O000000o == null) {
            f13641O000000o = new MiStatOptions.O000000o().f5062O000000o;
        }
        return f13641O000000o;
    }

    public static final void O000000o(String str, String str2, String str3, String str4) {
        O000000o(str, str2, str3, str4, null);
    }

    public static final void O000000o(String str, String str2, String str3, String str4, String str5) {
        cdq cdq;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.w("MiStat", "eventId and pageId must not empty.");
            return;
        }
        if (!TextUtils.isEmpty(str3)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EventData(str3, str4, "string"));
            cdq = new cdq(str, str2, null, arrayList);
        } else {
            cdq = new cdq(str, str2, null, null);
        }
        cdb.O000000o(cdq);
    }

    public static void O00000Oo(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EventData(str4, str5, "string"));
        cdb.O000000o(new cdq(str, str2, str3, arrayList));
    }

    public static final void O000000o(String str, String str2, String str3) {
        cdb.O000000o(new cdr(str, str2, str3));
    }

    public static final void O00000Oo(String str, String str2, String str3) {
        if (cdg.O000000o() != null) {
            cdg.O000000o().O000000o(str, str2, str3);
        }
    }
}
