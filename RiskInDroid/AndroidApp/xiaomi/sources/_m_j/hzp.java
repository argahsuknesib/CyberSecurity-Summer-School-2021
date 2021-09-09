package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u000e\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/uwb_mijia/UwbConstants;", "", "()V", "TAG_MODEL", "", "TAG_PID", "", "URL_UWB_FOR_NEW_USER_GUIDE", "getURL_UWB_FOR_NEW_USER_GUIDE", "()Ljava/lang/String;", "URL_UWB_FOR_SUPPORT_DEVICES", "getURL_UWB_FOR_SUPPORT_DEVICES", "URL_UWB_FOR_TV_GUIDE", "getURL_UWB_FOR_TV_GUIDE", "appendLocaleParam", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hzp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hzp f1018O000000o = new hzp();

    private hzp() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int
     arg types: [java.lang.String, java.lang.String, int, int, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean):boolean
      _m_j.iyw.O000000o(java.lang.String, java.lang.String, int, int, boolean):boolean
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int */
    public static String O000000o(String str) {
        String O000000o2 = flk.O000000o(ftn.O00000o0(CommonApplication.getAppContext()));
        if (iyo.O000000o((CharSequence) str, "?", 0, false, 6) != -1) {
            return str + "&locale=" + ((Object) O000000o2);
        }
        return str + "?locale=" + ((Object) O000000o2);
    }
}
