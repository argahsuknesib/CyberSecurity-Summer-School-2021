package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class or {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f2371O000000o;
    public int O00000Oo = 0;
    public oq O00000o;
    public String O00000o0;
    public List<oq> O00000oO = Collections.emptyList();
    public oq O00000oo;
    public List<oq> O0000O0o = Collections.emptyList();
    private final List<O000000o> O0000OOo = new ArrayList(3);

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f2372O000000o = 0;
        public int O00000Oo = 0;
        public int O00000o = 0;
        public int O00000o0 = 0;
        public int O00000oO = 0;
        public int O00000oo = 0;
        public int O0000O0o = 0;
        public long O0000OOo = 0;

        /* renamed from: O000000o */
        public final O000000o clone() {
            O000000o o000000o = new O000000o();
            o000000o.f2372O000000o = this.f2372O000000o;
            o000000o.O00000Oo = this.O00000Oo;
            o000000o.O00000o0 = this.O00000o0;
            o000000o.O00000o = this.O00000o;
            o000000o.O00000oO = this.O00000oO;
            o000000o.O00000oo = this.O00000oo;
            o000000o.O0000O0o = this.O0000O0o;
            o000000o.O0000OOo = this.O0000OOo;
            return o000000o;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof O000000o)) {
                O000000o o000000o = (O000000o) obj;
                return this.f2372O000000o == o000000o.f2372O000000o && this.O00000o0 == o000000o.O00000o0 && this.O00000o == o000000o.O00000o && this.O00000oo == o000000o.O00000oo && this.O0000O0o == o000000o.O0000O0o && this.O00000oO == o000000o.O00000oO;
            }
        }

        public final String toString() {
            return String.format(Locale.CHINA, "[type=%d,rssi=%d,lac=%d, cid=%d,sid=%d,nid=%d, bid=%d, time=%d]", Integer.valueOf(this.f2372O000000o), Integer.valueOf(this.O00000Oo), Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Integer.valueOf(this.O00000oO), Integer.valueOf(this.O00000oo), Integer.valueOf(this.O0000O0o), Long.valueOf(this.O0000OOo));
        }
    }

    /* renamed from: O000000o */
    public final or clone() {
        or orVar = new or();
        orVar.f2371O000000o = this.f2371O000000o;
        orVar.O00000Oo = this.O00000Oo;
        orVar.O00000o0 = this.O00000o0;
        oq oqVar = this.O00000o;
        if (oqVar != null) {
            orVar.O00000o = oqVar.clone();
        }
        oq oqVar2 = this.O00000oo;
        if (oqVar2 != null) {
            orVar.O00000oo = oqVar2.clone();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O00000oO);
        orVar.O00000oO = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.O0000O0o);
        orVar.O0000O0o = arrayList2;
        for (O000000o O000000o2 : this.O0000OOo) {
            orVar.O0000OOo.add(O000000o2.clone());
        }
        return orVar;
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("CellStatus:[");
        sb3.append("updateTime=" + this.f2371O000000o + ",");
        sb3.append("cellType=" + this.O00000Oo + ",");
        sb3.append("networkOperator=" + this.O00000o0 + ",");
        if (this.O00000o != null) {
            str = "mainCell=" + this.O00000o.toString() + ",";
        } else {
            str = "mainCell=null ,";
        }
        sb3.append(str);
        if (this.O00000oo != null) {
            str2 = "mainCell2=" + this.O00000oo.toString() + ",";
        } else {
            str2 = "mainCell2=null ,";
        }
        sb3.append(str2);
        List<oq> list = this.O00000oO;
        if (list == null || list.size() <= 0) {
            str3 = "neighbors=null";
        } else {
            ArrayList arrayList = new ArrayList();
            if (this.O00000oO.size() > 5) {
                arrayList.addAll(this.O00000oO);
                sb2 = new StringBuilder("neighbors=");
            } else {
                arrayList.addAll(this.O00000oO);
                sb2 = new StringBuilder("neighbors=");
            }
            sb2.append(arrayList.toString());
            str3 = sb2.toString();
        }
        sb3.append(str3);
        sb3.append(";");
        List<oq> list2 = this.O0000O0o;
        if (list2 == null || list2.size() <= 0) {
            str4 = "cellStateList2=null";
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (this.O0000O0o.size() > 5) {
                arrayList2.addAll(this.O0000O0o);
                sb = new StringBuilder("cellStateList2=");
            } else {
                arrayList2.addAll(this.O0000O0o);
                sb = new StringBuilder("cellStateList2=");
            }
            sb.append(arrayList2.toString());
            str4 = sb.toString();
        }
        sb3.append(str4);
        sb3.append("]");
        StringBuilder sb4 = new StringBuilder(" [HistoryCell:");
        int size = this.O0000OOo.size();
        for (int i = 0; i < size; i++) {
            sb4.append(i);
            sb4.append(":");
            sb4.append(this.O0000OOo.get(i).toString());
            sb4.append(" ");
        }
        sb4.append("]");
        return sb3.toString() + sb4.toString();
    }
}
