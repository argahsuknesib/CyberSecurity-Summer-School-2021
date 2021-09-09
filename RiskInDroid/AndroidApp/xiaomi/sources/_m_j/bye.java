package _m_j;

import android.os.Build;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

public class bye {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final SimpleDateFormat f13404O000000o = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String O00000Oo = bxw.O00000Oo().O000000o();
    public static int O00000o;
    public static String O00000o0 = Build.MODEL;
    public int O00000oO = -1;
    public String O00000oo;
    public String O0000O0o;
    public int O0000OOo;
    public long O0000Oo;
    public long O0000Oo0;
    public String O0000OoO;
    public String O0000Ooo;
    public StringBuilder O0000o = new StringBuilder();
    public String O0000o0;
    public boolean O0000o00;
    public ArrayList<String> O0000o0O = new ArrayList<>();
    public StringBuilder O0000o0o = new StringBuilder();
    public StringBuilder O0000oO = new StringBuilder();
    public StringBuilder O0000oO0 = new StringBuilder();

    static {
        O00000o = -1;
        O00000o = byf.O000000o();
        if (bxw.O00000Oo() != null) {
        }
    }

    public static bye O000000o() {
        bye bye = new bye();
        bye.O0000OOo = (int) bxw.O00000o;
        bye.O00000oO = O00000o;
        bye.O00000oo = String.valueOf(byf.O00000Oo());
        bye.O0000O0o = String.valueOf(byf.O00000o0());
        return bye;
    }

    public final bye O00000Oo() {
        StringBuilder sb = this.O0000o0o;
        sb.append("cpu_core = ");
        sb.append(this.O00000oO);
        sb.append("\r\n");
        StringBuilder sb2 = this.O0000o0o;
        sb2.append("freeMemory = ");
        sb2.append(this.O00000oo);
        sb2.append("\r\n");
        StringBuilder sb3 = this.O0000o0o;
        sb3.append("totalMemory = ");
        sb3.append(this.O0000O0o);
        sb3.append("\r\n");
        StringBuilder sb4 = this.O0000oO0;
        sb4.append("time = ");
        sb4.append(this.O0000Oo0);
        sb4.append("\r\n");
        StringBuilder sb5 = this.O0000oO0;
        sb5.append("thread_time = ");
        sb5.append(this.O0000Oo);
        sb5.append("\r\n");
        StringBuilder sb6 = this.O0000oO0;
        sb6.append("time_start = ");
        sb6.append(this.O0000OoO);
        sb6.append("\r\n");
        StringBuilder sb7 = this.O0000oO0;
        sb7.append("time_end = ");
        sb7.append(this.O0000Ooo);
        sb7.append("\r\n");
        StringBuilder sb8 = this.O0000o;
        sb8.append("cpu_busy = ");
        sb8.append(this.O0000o00);
        sb8.append("\r\n");
        StringBuilder sb9 = this.O0000o;
        sb9.append("cpu_rate = ");
        sb9.append(this.O0000o0);
        sb9.append("\r\n");
        ArrayList<String> arrayList = this.O0000o0O;
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb10 = new StringBuilder();
            Iterator<String> it = this.O0000o0O.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    sb10.append(next);
                    sb10.append("\r\n");
                }
            }
            StringBuilder sb11 = this.O0000oO;
            sb11.append("stack = ");
            sb11.append(sb10.toString());
            sb11.append("\r\n");
        }
        return this;
    }

    public final JSONObject O00000o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("block_hold", this.O0000OOo);
            jSONObject.put("cpu_core", this.O00000oO);
            jSONObject.put("freeMemory", this.O00000oo);
            jSONObject.put("totalMemory", this.O0000O0o);
            jSONObject.put("time", this.O0000Oo0);
            jSONObject.put("thread_time", this.O0000Oo);
            jSONObject.put("time_start", this.O0000OoO);
            jSONObject.put("time_end", this.O0000Ooo);
            jSONObject.put("cpu_busy", this.O0000o00);
            jSONObject.put("cpu_rate", this.O0000o0);
            if (this.O0000o0O != null && !this.O0000o0O.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.O0000o0O.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append("\r\n");
                }
                jSONObject.put("stack", sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return String.valueOf(this.O0000o0o) + ((Object) this.O0000oO0) + ((Object) this.O0000o) + ((Object) this.O0000oO);
    }
}
