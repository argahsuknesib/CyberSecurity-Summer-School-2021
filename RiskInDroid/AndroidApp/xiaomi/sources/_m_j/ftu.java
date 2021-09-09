package _m_j;

import _m_j.gsk;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class ftu {
    private static volatile ftu O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public OkHttpClient f17125O000000o = gse.O000000o();

    private ftu() {
    }

    public static ftu O000000o() {
        if (O00000Oo == null) {
            synchronized (ftu.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ftu();
                }
            }
        }
        return O00000Oo;
    }

    public final gsn O000000o(Date date, Date date2, String str, String str2, final ftt<JSONObject> ftt) {
        if (!gof.O000000o()) {
            ftt.O000000o(ErrorCode.ERROR_NETWORK_ERROR.getCode());
            return null;
        }
        ArrayList arrayList = new ArrayList(15);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        String format2 = simpleDateFormat.format(date2);
        arrayList.add(new gky("appid", "2882303761517233197"));
        arrayList.add(new gky("third_appid", "1435821822"));
        arrayList.add(new gky("third_appsecret", "NWZkYjMwMDFjNGRiMjhjOWRmMTkzNGMxYjRhODcyZWI"));
        arrayList.add(new gky("fromdate", format));
        arrayList.add(new gky("todate", format2));
        arrayList.add(new gky("l", "english"));
        arrayList.add(new gky("v", "1.0"));
        arrayList.add(new gky("call_id", Long.toString(System.currentTimeMillis() / 1000)));
        arrayList.add(new gky("mac_key", str2));
        arrayList.add(new gky("access_token", str));
        return gsg.O000000o(this.f17125O000000o, new gsk.O000000o().O000000o("POST").O00000Oo("https://hmservice.mi-ae.com.cn/user/summary/getData").O000000o(arrayList).O000000o(), new gso() {
            /* class _m_j.ftu.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                O000000o((String) obj);
            }

            public final void O000000o(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code");
                    ErrorCode valueof = ErrorCode.valueof(optInt);
                    if (optInt != 1) {
                        if (optInt != 0) {
                            if (ftt != null) {
                                ftt.O000000o(valueof.getCode());
                                return;
                            }
                            return;
                        }
                    }
                    if (ftt != null) {
                        ftt.O000000o(jSONObject);
                    }
                } catch (JSONException unused) {
                    ftt ftt = ftt;
                    if (ftt != null) {
                        ftt.O000000o(ErrorCode.INVALID.getCode());
                    }
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                ftt ftt = ftt;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.INVALID.getCode());
                }
            }
        });
    }
}
