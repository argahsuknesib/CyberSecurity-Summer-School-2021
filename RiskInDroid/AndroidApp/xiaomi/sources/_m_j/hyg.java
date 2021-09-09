package _m_j;

import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.stat.report.StatReporter$1;
import java.util.HashSet;
import org.json.JSONObject;

public class hyg {
    public static final HashSet<String> O00000Oo = new StatReporter$1();

    /* renamed from: O000000o  reason: collision with root package name */
    public String f979O000000o;

    public static final boolean O000000o(String str, String str2) {
        if (!"app".equals(str) && !"plugin".equals(str)) {
            flu O00000oO = flu.O00000oO();
            CommonApplication.getAppContext();
            if (!O00000oO.O000000o()) {
                return false;
            }
            if (!ftn.O0000O0o(CommonApplication.getAppContext()) || O00000Oo.contains(str2)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static final String O000000o(Object obj) {
        if (obj == null) {
            return "";
        }
        String name = obj.getClass().getName();
        String packageName = CommonApplication.getAppContext().getPackageName();
        return name.startsWith(packageName) ? name.replace(packageName, "") : name;
    }

    public hyg(String str) {
        this.f979O000000o = str;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0021 */
    public static JSONObject O000000o(Object... objArr) {
        String obj;
        JSONObject jSONObject = new JSONObject();
        for (int i = 1; i < objArr.length; i += 2) {
            Object obj2 = objArr[i - 1];
            if (!(obj2 == null || (obj = obj2.toString()) == null)) {
                Object obj3 = objArr[i];
                if (obj3 == null) {
                    obj3 = "";
                }
                String str = obj;
                jSONObject.put(str, obj3);
                try {
                    jSONObject.put(str, obj3.toString());
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject;
    }

    public long O000000o(String str, Object... objArr) {
        return hyd.O00000Oo().O000000o(this.f979O000000o, "mihome", str, O000000o(objArr), "", true);
    }

    public long O000000o(String str, JSONObject jSONObject) {
        return hyd.O00000Oo().O000000o(this.f979O000000o, "mihome", str, jSONObject, "", true);
    }

    public long O000000o(String str, String str2, Object... objArr) {
        hyd O00000Oo2 = hyd.O00000Oo();
        String str3 = this.f979O000000o;
        if (str2 == null) {
            str2 = "mihome";
        }
        return O00000Oo2.O000000o(str3, str2, str, O000000o(objArr), "", true);
    }

    public long O000000o(String str, String str2, JSONObject jSONObject, String str3) {
        hyd O00000Oo2 = hyd.O00000Oo();
        String str4 = this.f979O000000o;
        if (str2 == null) {
            str2 = "mihome";
        }
        return O00000Oo2.O000000o(str4, str2, str, jSONObject, str3, true);
    }

    public long O00000Oo(String str, String str2, Object... objArr) {
        return hyd.O00000Oo().O000000o(this.f979O000000o, "mihome", str, O000000o(objArr), str2, true);
    }
}
