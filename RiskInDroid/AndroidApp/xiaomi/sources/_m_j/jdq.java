package _m_j;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class jdq extends jdl {
    private final Map<String, String> O00000Oo;
    private final int O00000o;
    private final HashSet<Character> O00000o0;
    private final int O00000oO;

    public jdq(Map<CharSequence, CharSequence> map) {
        if (map != null) {
            this.O00000Oo = new HashMap();
            this.O00000o0 = new HashSet<>();
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            for (Map.Entry next : map.entrySet()) {
                this.O00000Oo.put(((CharSequence) next.getKey()).toString(), ((CharSequence) next.getValue()).toString());
                this.O00000o0.add(Character.valueOf(((CharSequence) next.getKey()).charAt(0)));
                int length = ((CharSequence) next.getKey()).length();
                i = length < i ? length : i;
                if (length > i2) {
                    i2 = length;
                }
            }
            this.O00000o = i;
            this.O00000oO = i2;
            return;
        }
        throw new InvalidParameterException("lookupMap cannot be null");
    }

    public final int O000000o(CharSequence charSequence, int i, Writer writer) throws IOException {
        if (!this.O00000o0.contains(Character.valueOf(charSequence.charAt(i)))) {
            return 0;
        }
        int i2 = this.O00000oO;
        if (i + i2 > charSequence.length()) {
            i2 = charSequence.length() - i;
        }
        while (i2 >= this.O00000o) {
            String str = this.O00000Oo.get(charSequence.subSequence(i, i + i2).toString());
            if (str != null) {
                writer.write(str);
                return i2;
            }
            i2--;
        }
        return 0;
    }
}
