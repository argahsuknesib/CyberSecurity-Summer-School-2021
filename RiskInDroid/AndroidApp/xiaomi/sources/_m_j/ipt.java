package _m_j;

import android.content.Context;
import android.util.Log;
import com.yanzhenjie.yp_permission.PermissionActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class ipt implements ion, ipv, PermissionActivity.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final iqa f1541O000000o = new iqa();
    private static final ipa O00000Oo = new iph();
    private static final ipa O00000o0 = new iox();
    private ipz O00000o;
    private String[] O00000oO;
    private iom<List<String>> O00000oo = new iom<List<String>>() {
        /* class _m_j.ipt.AnonymousClass1 */

        public final /* synthetic */ void O000000o(Context context, Object obj, ion ion) {
            ion.O00000Oo();
        }
    };
    private ioi<List<String>> O0000O0o;
    private ioi<List<String>> O0000OOo;
    private String[] O0000Oo0;

    ipt(ipz ipz) {
        this.O00000o = ipz;
    }

    public final ipv O000000o(String... strArr) {
        this.O00000oO = strArr;
        return this;
    }

    public final ipv O000000o(iom<List<String>> iom) {
        this.O00000oo = iom;
        return this;
    }

    public final ipv O000000o(ioi<List<String>> ioi) {
        this.O0000O0o = ioi;
        return this;
    }

    public final ipv O00000Oo(ioi<List<String>> ioi) {
        this.O0000OOo = ioi;
        return this;
    }

    public final void J_() {
        List<String> O000000o2 = O000000o(O00000Oo, this.O00000o, this.O00000oO);
        this.O0000Oo0 = (String[]) O000000o2.toArray(new String[O000000o2.size()]);
        String[] strArr = this.O0000Oo0;
        if (strArr.length > 0) {
            ipz ipz = this.O00000o;
            ArrayList arrayList = new ArrayList(1);
            for (String str : strArr) {
                if (ipz.O000000o(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                this.O00000oo.O000000o(this.O00000o.O000000o(), arrayList, this);
            } else {
                O00000Oo();
            }
        } else {
            O00000o();
        }
    }

    public final void O00000Oo() {
        PermissionActivity.requestPermission(this.O00000o.O000000o(), this.O0000Oo0, this);
    }

    public final void O00000o0() {
        O00000o();
    }

    public final void O000000o() {
        iqa.O000000o(new Runnable() {
            /* class _m_j.ipt.AnonymousClass2 */

            public final void run() {
                ipt.this.O00000o();
            }
        });
    }

    public final void O00000o() {
        List<String> O000000o2 = O000000o(O00000o0, this.O00000o, this.O00000oO);
        if (O000000o2.isEmpty()) {
            O00000oO();
        } else {
            O000000o(O000000o2);
        }
    }

    private void O00000oO() {
        if (this.O0000O0o != null) {
            List asList = Arrays.asList(this.O00000oO);
            try {
                this.O0000O0o.O000000o(asList);
            } catch (Exception e) {
                Log.e("AndPermission", "Please check the onGranted() method body for bugs.", e);
                ioi<List<String>> ioi = this.O0000OOo;
                if (ioi != null) {
                    ioi.O000000o(asList);
                }
            }
        }
    }

    private void O000000o(List<String> list) {
        ioi<List<String>> ioi = this.O0000OOo;
        if (ioi != null) {
            ioi.O000000o(list);
        }
    }

    private static List<String> O000000o(ipa ipa, ipz ipz, String... strArr) {
        ArrayList arrayList = new ArrayList(1);
        for (String str : strArr) {
            if (!ipa.O000000o(ipz.O000000o(), str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
