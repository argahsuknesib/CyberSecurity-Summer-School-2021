package a.a.a.f.d;

import _m_j.O0Oo0o0;
import android.content.Context;
import in.cashify.otex.ExchangeSetup;
import org.json.JSONObject;

public final class a extends O0Oo0o0 {

    public static class b {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Context f2622O000000o;

        public b(Context context) {
            this.f2622O000000o = context;
        }

        public final a O000000o(ExchangeSetup exchangeSetup, a.a.a.a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (exchangeSetup != null) {
                    exchangeSetup.O000000o(jSONObject);
                }
                if (aVar != null) {
                    aVar.O000000o(jSONObject);
                }
                return new a(this.f2622O000000o, jSONObject.toString(), (byte) 0);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private a(Context context, String str) {
        super(context, str);
    }

    public /* synthetic */ a(Context context, String str, byte b2) {
        this(context, str);
    }
}
