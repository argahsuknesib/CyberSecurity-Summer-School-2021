package _m_j;

import android.util.Log;
import java.util.Map;

public final class dpw extends boh implements bnu {
    private Map<String, Integer> O00000o = new o0O0OOO0();
    private Map<Integer, String> O00000oO = new o0O0OOO0();
    private Map<String, Integer> O00000oo = new o0O0OOO0();
    private Map<Integer, String> O0000O0o = new o0O0OOO0();
    private int O0000OOo;

    public dpw() {
        for (int i = 0; i < boh.O00000o0; i++) {
            this.O00000oo.put(f13165O000000o[i], Integer.valueOf(boh.O00000Oo[i]));
            this.O0000O0o.put(Integer.valueOf(boh.O00000Oo[i]), f13165O000000o[i]);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.<init>(byte[], int, int):void}
     arg types: [byte[], int, short]
     candidates:
      ClspMth{java.lang.String.<init>(int[], int, int):void}
      ClspMth{java.lang.String.<init>(char[], int, int):void}
      ClspMth{java.lang.String.<init>(byte[], int, int):void} */
    public final boolean O000000o(dpu dpu, int i) {
        this.O0000OOo = i;
        int i2 = dpu.O00000o;
        int O00000o0 = dpu.O00000o0();
        int i3 = 0;
        while (i3 < O00000o0) {
            int O00000o02 = dpu.O00000o0();
            short O00000Oo = dpu.O00000Oo();
            if (dpu.O00000o0 + O00000Oo <= i2) {
                String str = new String(dpu.O00000Oo, dpu.O00000o0, (int) O00000Oo);
                this.O00000oO.put(Integer.valueOf(O00000o02), str);
                this.O00000o.put(str, Integer.valueOf(O00000o02));
                dpu.O000000o(O00000Oo);
                i3++;
            } else {
                Log.e("StringLoader_TMTEST", "read string over");
                return false;
            }
        }
        return true;
    }

    public final String O000000o(int i) {
        if (this.O0000O0o.containsKey(Integer.valueOf(i))) {
            return this.O0000O0o.get(Integer.valueOf(i));
        }
        if (this.O00000oO.containsKey(Integer.valueOf(i))) {
            return this.O00000oO.get(Integer.valueOf(i));
        }
        Log.e("StringLoader_TMTEST", "getString null:".concat(String.valueOf(i)));
        return null;
    }

    public final int O000000o(String str) {
        int i = 0;
        if (bnr.O000000o(str)) {
            return 0;
        }
        if (this.O00000oo.containsKey(str)) {
            i = this.O00000oo.get(str).intValue();
        }
        return (i != 0 || !this.O00000o.containsKey(str)) ? i : this.O00000o.get(str).intValue();
    }

    public final boolean O00000Oo(int i) {
        return this.O0000O0o.containsKey(Integer.valueOf(i));
    }
}
