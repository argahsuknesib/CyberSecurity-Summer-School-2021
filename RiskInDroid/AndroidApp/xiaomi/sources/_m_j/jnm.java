package _m_j;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class jnm {

    /* renamed from: O000000o  reason: collision with root package name */
    private Reader f1974O000000o;
    private jnf O00000Oo = new jng();
    private List<jnn> O00000o;
    private jnh O00000o0;
    private jnl O00000oO;

    public jnm(Reader reader) {
        this.f1974O000000o = reader;
        this.O00000Oo.O000000o(true);
        jnt.O000000o(this.O00000Oo);
        this.O00000o0 = new jnh(this.O00000Oo);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new jno());
        arrayList.add(new jnj());
        arrayList.add(new jni());
        this.O00000o = arrayList;
        this.O00000oO = new jnl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x0190 A[EDGE_INSN: B:130:0x0190->B:80:0x0190 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01db  */
    public final synchronized jnp O000000o() throws IOException {
        int i;
        int i2;
        boolean z;
        jnh jnh;
        boolean z2;
        int i3;
        boolean z3;
        while (true) {
            jnh jnh2 = this.O00000o0;
            jnp pollFirst = jnh2.O0000Oo0.pollFirst();
            while (true) {
                i = 0;
                if (pollFirst == null) {
                    break;
                }
                if (jnh2.O0000Oo.O000000o() && !jnh2.O0000Oo0.isEmpty()) {
                    if (2 == pollFirst.O00000o) {
                        jnp peekFirst = jnh2.O0000Oo0.peekFirst();
                        if (16 == peekFirst.O00000o) {
                            z3 = pollFirst.O000000o(peekFirst, 16);
                        } else {
                            z3 = 32 == peekFirst.O00000o ? pollFirst.O000000o(peekFirst, 48) : false;
                        }
                        if (z3) {
                            jnh2.O0000Oo0.pollFirst();
                        }
                    }
                    if (16 == pollFirst.O00000o && !jnh2.O0000Oo0.isEmpty()) {
                        jnp peekFirst2 = jnh2.O0000Oo0.peekFirst();
                        if (32 == peekFirst2.O00000o ? pollFirst.O000000o(peekFirst2, 48) : false) {
                            jnh2.O0000Oo0.pollFirst();
                        }
                    }
                }
                jnt.O000000o();
                if (jnt.O000000o(jnh2.f1971O000000o, pollFirst.f1976O000000o, pollFirst.O00000Oo)) {
                    pollFirst = jnh2.O0000Oo0.pollFirst();
                } else {
                    String valueOf = String.valueOf(jnh2.f1971O000000o, pollFirst.f1976O000000o, pollFirst.O00000Oo);
                    if (valueOf == null) {
                        pollFirst.O00000o0 = "";
                        pollFirst.O00000Oo = 0;
                    } else {
                        pollFirst.O00000o0 = valueOf;
                        pollFirst.O00000Oo = valueOf.length();
                    }
                }
            }
            if (pollFirst != null) {
                return pollFirst;
            }
            jnh jnh3 = this.O00000o0;
            Reader reader = this.f1974O000000o;
            if (jnh3.O00000o0 == 0) {
                i2 = reader.read(jnh3.f1971O000000o);
            } else {
                int i4 = jnh3.O00000oO - jnh3.O00000o;
                if (i4 > 0) {
                    System.arraycopy(jnh3.f1971O000000o, jnh3.O00000o, jnh3.f1971O000000o, 0, i4);
                    i3 = i4;
                } else {
                    i3 = 0;
                }
                i2 = reader.read(jnh3.f1971O000000o, i4, 4096 - i4) + i3;
            }
            jnh3.O00000oO = i2;
            jnh3.O00000o = 0;
            if (i2 <= 0) {
                jnh jnh4 = this.O00000o0;
                jnh4.O00000oo.clear();
                jnh4.O0000O0o = new jnr();
                jnh4.O00000oO = 0;
                jnh4.O00000o0 = 0;
                jnh4.O00000Oo = new int[4096];
                jnh4.O00000o = 0;
                jnh4.O0000Oo0.clear();
                jnh4.f1971O000000o = new char[4096];
                jnh4.O0000OOo.clear();
                return null;
            }
            jnh jnh5 = this.O00000o0;
            jnh5.O00000o = 0;
            jnh5.f1971O000000o[jnh5.O00000o] = jnk.O00000Oo(jnh5.f1971O000000o[jnh5.O00000o]);
            jnh5.O00000Oo[jnh5.O00000o] = jnk.O000000o(jnh5.f1971O000000o[jnh5.O00000o]);
            do {
                for (jnn O000000o2 : this.O00000o) {
                    O000000o2.O000000o(this.O00000o0);
                }
                jnh jnh6 = this.O00000o0;
                if (jnh6.O00000oO == 4096 && jnh6.O00000o < jnh6.O00000oO - 1 && jnh6.O00000o > jnh6.O00000oO - 100) {
                    if (!(jnh6.O00000oo.size() > 0)) {
                        z = true;
                        if (!z) {
                            break;
                        }
                        jnh jnh7 = this.O00000o0;
                        if (jnh7.O00000o < jnh7.O00000oO - 1) {
                            jnh7.O00000o++;
                            jnh7.f1971O000000o[jnh7.O00000o] = jnk.O00000Oo(jnh7.f1971O000000o[jnh7.O00000o]);
                            jnh7.O00000Oo[jnh7.O00000o] = jnk.O000000o(jnh7.f1971O000000o[jnh7.O00000o]);
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            } while (z2);
            for (jnn O000000o3 : this.O00000o) {
                O000000o3.O000000o();
            }
            jnh jnh8 = this.O00000o0;
            boolean O000000o4 = this.O00000Oo.O000000o();
            jnr jnr = jnh8.O0000O0o;
            jnq jnq = new jnq();
            for (jnp O00000Oo2 = jnr.O00000Oo(); O00000Oo2 != null; O00000Oo2 = jnr.O00000Oo()) {
                if (!jnq.O000000o(O00000Oo2)) {
                    if (jnq.O00000oo != 1) {
                        if (O000000o4) {
                            jnh8.O000000o(jnl.O000000o(jnq.O00000o));
                            jnq = new jnq();
                            jnq.O000000o(O00000Oo2);
                        }
                    }
                    jnh8.O000000o(jnq);
                    jnq = new jnq();
                    jnq.O000000o(O00000Oo2);
                }
            }
            if (jnq.O00000oo != 1) {
                if (O000000o4) {
                    jnh8.O000000o(jnl.O000000o(jnq.O00000o));
                    jnh = this.O00000o0;
                    while (i <= jnh.O00000o) {
                        if (jnh.O00000Oo[i] != 0) {
                            jnq jnq2 = jnh.O0000OOo.get(Integer.valueOf(i));
                            if (jnq2 != null) {
                                jnp O00000Oo3 = jnq2.O00000Oo();
                                while (O00000Oo3 != null) {
                                    jnh.O0000Oo0.add(O00000Oo3);
                                    i = O00000Oo3.f1976O000000o + O00000Oo3.O00000Oo;
                                    O00000Oo3 = jnq2.O00000Oo();
                                    if (O00000Oo3 != null) {
                                        while (i < O00000Oo3.f1976O000000o) {
                                            jnh.O000000o(i);
                                            i++;
                                        }
                                    }
                                }
                            } else {
                                jnh.O000000o(i);
                            }
                        }
                        i++;
                    }
                    jnh.O0000OOo.clear();
                    jnh jnh9 = this.O00000o0;
                    jnh9.O00000o0 += jnh9.O00000o;
                }
            }
            jnh8.O000000o(jnq);
            jnh = this.O00000o0;
            while (i <= jnh.O00000o) {
            }
            jnh.O0000OOo.clear();
            jnh jnh92 = this.O00000o0;
            jnh92.O00000o0 += jnh92.O00000o;
        }
    }
}
