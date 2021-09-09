package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class fbw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16052O000000o = "fbw";
    private static volatile fbw O00000oO;
    public String O00000Oo;
    public long O00000o = 0;
    public AtomicBoolean O00000o0 = new AtomicBoolean(false);

    public interface O000000o {
        void O000000o();
    }

    private fbw() {
    }

    public static fbw O000000o() {
        if (O00000oO == null) {
            synchronized (fbw.class) {
                if (O00000oO == null) {
                    O00000oO = new fbw();
                }
            }
        }
        return O00000oO;
    }

    public static String O000000o(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }
}
