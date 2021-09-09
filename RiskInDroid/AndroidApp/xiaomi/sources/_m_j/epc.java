package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.em;
import org.json.JSONException;
import org.json.JSONObject;

public final class epc implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ String f15699O000000o;
    final /* synthetic */ Context O00000Oo;
    final /* synthetic */ String O00000o;
    final /* synthetic */ String O00000o0;
    final /* synthetic */ epb O00000oO;

    public epc(epb epb, String str, Context context, String str2, String str3) {
        this.O00000oO = epb;
        this.f15699O000000o = str;
        this.O00000Oo = context;
        this.O00000o0 = str2;
        this.O00000o = str3;
    }

    public final void run() {
        Context context;
        String str;
        String str2;
        if (!TextUtils.isEmpty(this.f15699O000000o)) {
            try {
                eox.O000000o(this.O00000Oo, this.f15699O000000o, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f15699O000000o);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.O00000o0.equals(optString3)) {
                    if (this.O00000o.equals(optString4)) {
                        if (TextUtils.isEmpty(optString5) || TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4) || TextUtils.isEmpty(optString2)) {
                            eox.O000000o(this.O00000Oo, this.f15699O000000o, 1008, "A receive a incorrect message with empty type");
                            return;
                        }
                        this.O00000oO.O00000o0 = optString3;
                        this.O00000oO.O00000Oo = optString4;
                        epa epa = new epa();
                        epa.O00000Oo = optString;
                        epa.f15697O000000o = optString2;
                        epa.O00000oO = optInt;
                        epa.O00000o = this.f15699O000000o;
                        if ("service".equals(optString5)) {
                            if (!TextUtils.isEmpty(optString)) {
                                this.O00000oO.O0000O0o.get(em.b).O000000o(this.O00000Oo, epa);
                                return;
                            }
                            epa.O00000o0 = "com.xiaomi.mipush.sdk.PushMessageHandler";
                            this.O00000oO.O0000O0o.get(em.c).O000000o(this.O00000Oo, epa);
                            return;
                        } else if (em.f6375a.f28a.equals(optString5)) {
                            this.O00000oO.O0000O0o.get(em.f6375a).O000000o(this.O00000Oo, epa);
                            return;
                        } else if (em.d.f28a.equals(optString5)) {
                            this.O00000oO.O0000O0o.get(em.d).O000000o(this.O00000Oo, epa);
                            return;
                        } else {
                            eox.O000000o(this.O00000Oo, this.f15699O000000o, 1008, "A receive a incorrect message with unknown type ".concat(String.valueOf(optString5)));
                            return;
                        }
                    }
                }
                eox.O000000o(this.O00000Oo, this.f15699O000000o, 1008, "A receive a incorrect message with incorrect package info".concat(String.valueOf(optString3)));
            } catch (JSONException e) {
                duv.O000000o(e);
                context = this.O00000Oo;
                str = this.f15699O000000o;
                str2 = "A meet a exception when receive the message";
            }
        } else {
            context = this.O00000Oo;
            str = "null";
            str2 = "A receive a incorrect message with empty info";
            eox.O000000o(context, str, 1008, str2);
        }
    }
}
