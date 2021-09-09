package _m_j;

import a.a.a.a;
import a.a.a.b;
import android.content.Context;
import in.cashify.otex.ExchangeSetup;
import java.util.Map;
import org.json.JSONObject;

public final class O0OO0Oo extends O0Oo0o0 {
    private O0OO0Oo(Context context, String str) {
        super(context, str);
    }

    public /* synthetic */ O0OO0Oo(Context context, String str, byte b) {
        this(context, str);
    }

    public static class O000000o {
        public static O0OO0Oo O000000o(Context context, ExchangeSetup exchangeSetup, a aVar, Map<String, b> map) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (exchangeSetup != null) {
                    exchangeSetup.O000000o(jSONObject2);
                }
                if (aVar != null) {
                    aVar.O000000o(jSONObject2);
                }
                jSONObject.put("di", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                for (String next : map.keySet()) {
                    jSONObject3.put(next, map.get(next).O00000Oo);
                }
                jSONObject.put("dr", jSONObject3);
                jSONObject.put("ts", System.currentTimeMillis());
                return new O0OO0Oo(context, jSONObject.toString(), (byte) 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
