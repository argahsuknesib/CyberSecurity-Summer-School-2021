package _m_j;

import _m_j.ggb;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class gvs extends gvq<O000000o> {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f18391O000000o;
        public List<String> O00000Oo;
        public LinkedHashMap<String, LinkedHashMap<String, List<String>>> O00000o0;

        public O000000o(int i, List<String> list) {
            this.f18391O000000o = i;
            if (list == null || list.isEmpty()) {
                this.O00000Oo = list;
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str = list.get(i2);
                    if (!TextUtils.isEmpty(str) && fno.O000000o().O000000o(str) != null) {
                        arrayList.add(str);
                    }
                }
            }
            this.O00000Oo = arrayList;
            this.O00000o0 = ggb.O00000o0.O000000o(arrayList);
        }
    }
}
