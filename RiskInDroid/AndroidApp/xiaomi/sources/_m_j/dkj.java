package _m_j;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.common.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public final class dkj extends dkk {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f14743O000000o;
    private int O0000o0;
    private int O0000o0O = 100;
    private Thread O0000o0o = null;

    public dkj(Context context, int i, Throwable th, dkf dkf) {
        super(context, i, dkf);
        O000000o(99, th);
    }

    public dkj(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        O000000o(2, th);
        this.O0000o0o = thread;
    }

    private void O000000o(int i, Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f14743O000000o = stringWriter.toString();
            this.O0000o0 = i;
            printWriter.close();
        }
    }

    public final boolean O000000o(JSONObject jSONObject) {
        dmb.O000000o(jSONObject, "er", this.f14743O000000o);
        jSONObject.put("ea", this.O0000o0);
        int i = this.O0000o0;
        if (i != 2 && i != 3) {
            return true;
        }
        new b(this.O0000Ooo).O000000o(jSONObject, this.O0000o0o);
        return true;
    }

    public final f O00000Oo() {
        return f.ERROR;
    }
}
