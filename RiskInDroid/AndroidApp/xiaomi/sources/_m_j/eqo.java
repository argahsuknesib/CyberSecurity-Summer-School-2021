package _m_j;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class eqo implements eqs {

    /* renamed from: O000000o  reason: collision with root package name */
    String f15727O000000o;
    private String O00000Oo;
    private String[] O00000o = null;
    private String[] O00000o0 = null;
    private String O00000oO;
    private List<eqo> O00000oo = null;

    public eqo(String str) {
        this.f15727O000000o = str;
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = null;
    }

    public eqo(String str, String str2, String[] strArr, String[] strArr2, String str3, List<eqo> list) {
        this.f15727O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = strArr;
        this.O00000o = strArr2;
        this.O00000oO = str3;
        this.O00000oo = list;
    }

    public static eqo O000000o(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String next : keySet) {
            strArr[i] = next;
            strArr2[i] = bundle2.getString(next);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(O000000o((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new eqo(string, string2, strArr, strArr2, string3, arrayList);
    }

    public final String O000000o() {
        return !TextUtils.isEmpty(this.O00000oO) ? erb.O00000Oo(this.O00000oO) : this.O00000oO;
    }

    public final String O000000o(String str) {
        if (this.O00000o0 == null) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.O00000o0;
            if (i >= strArr.length) {
                return null;
            }
            if (str.equals(strArr[i])) {
                return this.O00000o[i];
            }
            i++;
        }
    }

    public final void O000000o(eqo eqo) {
        if (this.O00000oo == null) {
            this.O00000oo = new ArrayList();
        }
        if (!this.O00000oo.contains(eqo)) {
            this.O00000oo.add(eqo);
        }
    }

    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f15727O000000o);
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            sb.append(" xmlns=\"");
            sb.append(this.O00000Oo);
            sb.append(jdn.f1779O000000o);
        }
        String[] strArr = this.O00000o0;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.O00000o0.length; i++) {
                if (!TextUtils.isEmpty(this.O00000o[i])) {
                    sb.append(" ");
                    sb.append(this.O00000o0[i]);
                    sb.append("=\"");
                    sb.append(erb.O000000o(this.O00000o[i]));
                    sb.append(jdn.f1779O000000o);
                }
            }
        }
        if (!TextUtils.isEmpty(this.O00000oO)) {
            sb.append(">");
            sb.append(this.O00000oO);
        } else {
            List<eqo> list = this.O00000oo;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            for (eqo O00000Oo2 : this.O00000oo) {
                sb.append(O00000Oo2.O00000Oo());
            }
        }
        sb.append("</");
        sb.append(this.f15727O000000o);
        sb.append(">");
        return sb.toString();
    }

    public final void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000oO = erb.O000000o(str);
        } else {
            this.O00000oO = str;
        }
    }

    public final String toString() {
        return O00000Oo();
    }

    public final Bundle O00000o0() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f15727O000000o);
        bundle.putString("ext_ns", this.O00000Oo);
        bundle.putString("ext_text", this.O00000oO);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.O00000o0;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.O00000o0;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.O00000o[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<eqo> list = this.O00000oo;
        if (list != null && list.size() > 0) {
            List<eqo> list2 = this.O00000oo;
            bundle.putParcelableArray("children", O000000o((eqo[]) list2.toArray(new eqo[list2.size()])));
        }
        return bundle;
    }

    private static Parcelable[] O000000o(eqo[] eqoArr) {
        if (eqoArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[eqoArr.length];
        for (int i = 0; i < eqoArr.length; i++) {
            parcelableArr[i] = eqoArr[i].O00000o0();
        }
        return parcelableArr;
    }
}
