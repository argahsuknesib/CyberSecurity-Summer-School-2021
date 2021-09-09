package _m_j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class jns implements Comparable<jns> {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<Character, Character> f1979O000000o = new HashMap(16, 0.95f);
    private Map<Character, jns> O00000Oo;
    private Character O00000o;
    private jns[] O00000o0;
    private int O00000oO = 0;
    private int O00000oo = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.O00000o.compareTo(((jns) obj).O00000o);
    }

    jns(Character ch) {
        if (ch != null) {
            this.O00000o = ch;
            return;
        }
        throw new IllegalArgumentException("参数为空异常，字符不能为空");
    }

    private boolean O000000o() {
        return this.O00000oO > 0;
    }

    /* access modifiers changed from: package-private */
    public final jnu O000000o(char[] cArr, int i, int i2) {
        return O000000o(cArr, i, i2, (jnu) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[EDGE_INSN: B:25:0x0057->B:24:0x0057 ?: BREAK  , SYNTHETIC] */
    public final jnu O000000o(char[] cArr, int i, int i2, jnu jnu) {
        int i3 = i2;
        jns jns = this;
        while (true) {
            if (jnu == null) {
                jnu = new jnu();
                jnu.O00000o0 = i;
            } else {
                jnu.f1981O000000o = 0;
            }
            jnu.O00000o = i;
            Character ch = new Character(cArr[i]);
            jns[] jnsArr = jns.O00000o0;
            Map<Character, jns> map = jns.O00000Oo;
            if (jnsArr != null) {
                int binarySearch = Arrays.binarySearch(jnsArr, 0, jns.O00000oO, new jns(ch));
                if (binarySearch >= 0) {
                    jns = jnsArr[binarySearch];
                    if (jns == null) {
                        break;
                    } else if (i3 > 1) {
                        i++;
                        i3--;
                    } else if (i3 == 1) {
                        if (jns.O00000oo == 1) {
                            jnu.O00000Oo();
                        }
                        if (jns.O000000o()) {
                            jnu.O00000o();
                            jnu.O00000Oo = jns;
                        }
                    }
                }
            } else if (map != null) {
                jns = map.get(ch);
                if (jns == null) {
                }
            }
            jns = null;
            if (jns == null) {
            }
        }
        return jnu;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(char[] cArr) {
        O000000o(cArr, 0, cArr.length, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008d, code lost:
        return;
     */
    private synchronized void O000000o(char[] cArr, int i, int i2, int i3) {
        jns jns;
        Character ch = new Character(cArr[i]);
        Character ch2 = f1979O000000o.get(ch);
        if (ch2 == null) {
            f1979O000000o.put(ch, ch);
        } else {
            ch = ch2;
        }
        if (this.O00000oO <= 3) {
            jns[] O00000Oo2 = O00000Oo();
            jns = new jns(ch);
            int binarySearch = Arrays.binarySearch(O00000Oo2, 0, this.O00000oO, jns);
            jns jns2 = binarySearch >= 0 ? O00000Oo2[binarySearch] : null;
            if (jns2 != null || i3 != 1) {
                jns = jns2;
            } else if (this.O00000oO < 3) {
                O00000Oo2[this.O00000oO] = jns;
                this.O00000oO++;
                Arrays.sort(O00000Oo2, 0, this.O00000oO);
            } else {
                Map<Character, jns> O00000o02 = O00000o0();
                O000000o(O00000Oo2, O00000o02);
                O00000o02.put(ch, jns);
                this.O00000oO++;
                this.O00000o0 = null;
            }
        } else {
            Map<Character, jns> O00000o03 = O00000o0();
            jns = O00000o03.get(ch);
            if (jns == null && i3 == 1) {
                jns = new jns(ch);
                O00000o03.put(ch, jns);
                this.O00000oO++;
            }
        }
        if (jns != null) {
            if (i2 > 1) {
                jns.O000000o(cArr, i + 1, i2 - 1, i3);
            } else if (i2 == 1) {
                jns.O00000oo = i3;
            }
        }
    }

    private jns[] O00000Oo() {
        if (this.O00000o0 == null) {
            synchronized (this) {
                if (this.O00000o0 == null) {
                    this.O00000o0 = new jns[3];
                }
            }
        }
        return this.O00000o0;
    }

    private Map<Character, jns> O00000o0() {
        if (this.O00000Oo == null) {
            synchronized (this) {
                if (this.O00000Oo == null) {
                    this.O00000Oo = new HashMap(6, 0.8f);
                }
            }
        }
        return this.O00000Oo;
    }

    private static void O000000o(jns[] jnsArr, Map<Character, jns> map) {
        for (jns jns : jnsArr) {
            if (jns != null) {
                map.put(jns.O00000o, jns);
            }
        }
    }
}
