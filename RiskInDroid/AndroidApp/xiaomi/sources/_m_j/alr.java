package _m_j;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class alr {

    /* renamed from: O000000o  reason: collision with root package name */
    public final O00000Oo[] f12438O000000o;
    public final HashMap<String, Integer> O00000Oo;
    public final ath[] O00000o;
    public final String[] O00000o0;

    protected alr(O00000Oo[] o00000OoArr, HashMap<String, Integer> hashMap) {
        this.f12438O000000o = o00000OoArr;
        this.O00000Oo = hashMap;
        this.O00000o0 = null;
        this.O00000o = null;
    }

    private alr(alr alr) {
        this.f12438O000000o = alr.f12438O000000o;
        this.O00000Oo = alr.O00000Oo;
        int length = this.f12438O000000o.length;
        this.O00000o0 = new String[length];
        this.O00000o = new ath[length];
    }

    public final alr O000000o() {
        return new alr(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r4.O00000o0[r0] != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        if (r4.O00000o[r0] != null) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    public final boolean O000000o(JsonParser jsonParser, ajt ajt, String str, Object obj) throws IOException, JsonProcessingException {
        Integer num = this.O00000Oo.get(str);
        boolean z = false;
        if (num == null) {
            return false;
        }
        int intValue = num.intValue();
        if (this.f12438O000000o[intValue].O000000o(str)) {
            this.O00000o0[intValue] = jsonParser.O0000OoO();
            jsonParser.O00000o();
            if (obj != null) {
            }
            if (z) {
                O000000o(jsonParser, ajt, obj, intValue);
                this.O00000o0[intValue] = null;
                this.O00000o[intValue] = null;
            }
            return true;
        }
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000Oo(jsonParser);
        this.O00000o[intValue] = ath;
        if (obj != null) {
        }
        if (z) {
        }
        return true;
        z = true;
        if (z) {
        }
        return true;
    }

    public final Object O000000o(JsonParser jsonParser, ajt ajt, Object obj) throws IOException, JsonProcessingException {
        int length = this.f12438O000000o.length;
        for (int i = 0; i < length; i++) {
            if (this.O00000o0[i] == null) {
                if (this.O00000o[i] != null) {
                    throw ajt.O00000Oo("Missing external type id property '" + this.f12438O000000o[i].O00000Oo);
                }
            } else if (this.O00000o[i] != null) {
                O000000o(jsonParser, ajt, obj, i);
            } else {
                alm alm = this.f12438O000000o[i].f12440O000000o;
                throw ajt.O00000Oo("Missing property '" + alm.O00000o() + "' for external type id '" + this.f12438O000000o[i].O00000Oo);
            }
        }
        return obj;
    }

    public void O000000o(JsonParser jsonParser, ajt ajt, Object obj, int i) throws IOException, JsonProcessingException {
        ath ath = new ath(jsonParser.O000000o());
        ath.O00000Oo();
        ath.O00000Oo(this.O00000o0[i]);
        JsonParser O000000o2 = this.O00000o[i].O000000o(jsonParser);
        O000000o2.O00000Oo();
        ath.O00000Oo(O000000o2);
        ath.O00000o0();
        JsonParser O000000o3 = ath.O000000o(jsonParser);
        O000000o3.O00000Oo();
        this.f12438O000000o[i].f12440O000000o.O000000o(O000000o3, ajt, obj);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final ArrayList<O00000Oo> f12439O000000o = new ArrayList<>();
        private final HashMap<String, Integer> O00000Oo = new HashMap<>();

        public final void O000000o(alm alm, String str) {
            Integer valueOf = Integer.valueOf(this.f12439O000000o.size());
            this.f12439O000000o.add(new O00000Oo(alm, str));
            this.O00000Oo.put(alm.O00000o(), valueOf);
            this.O00000Oo.put(str, valueOf);
        }

        public final alr O000000o() {
            ArrayList<O00000Oo> arrayList = this.f12439O000000o;
            return new alr((O00000Oo[]) arrayList.toArray(new O00000Oo[arrayList.size()]), this.O00000Oo);
        }
    }

    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final alm f12440O000000o;
        public final String O00000Oo;

        public O00000Oo(alm alm, String str) {
            this.f12440O000000o = alm;
            this.O00000Oo = str;
        }

        public final boolean O000000o(String str) {
            return str.equals(this.O00000Oo);
        }
    }
}
