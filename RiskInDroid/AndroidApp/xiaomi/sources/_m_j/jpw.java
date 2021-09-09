package _m_j;

import _m_j.jpi;
import _m_j.jrk;
import gK.f;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import ss.u;

public final class jpw implements jqa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final f f2040O000000o = f.O000000o("connection");
    private static final f O00000Oo = f.O000000o("host");
    private static final f O00000o = f.O000000o("proxy-connection");
    private static final f O00000o0 = f.O000000o("keep-alive");
    private static final f O00000oO = f.O000000o("transfer-encoding");
    private static final f O00000oo = f.O000000o("te");
    private static final f O0000O0o = f.O000000o("encoding");
    private static final f O0000OOo = f.O000000o("upgrade");
    private static final List<f> O0000Oo = jqp.O000000o(f2040O000000o, O00000Oo, O00000o0, O00000o, O00000oO);
    private static final List<f> O0000Oo0 = jqp.O000000o(f2040O000000o, O00000Oo, O00000o0, O00000o, O00000oO, jqw.O00000Oo, jqw.O00000o0, jqw.O00000o, jqw.O00000oO, jqw.O00000oo, jqw.O0000O0o);
    private static final List<f> O0000OoO = jqp.O000000o(f2040O000000o, O00000Oo, O00000o0, O00000o, O00000oo, O00000oO, O0000O0o, O0000OOo, jqw.O00000Oo, jqw.O00000o0, jqw.O00000o, jqw.O00000oO, jqw.O00000oo, jqw.O0000O0o);
    private static final List<f> O0000Ooo = jqp.O000000o(f2040O000000o, O00000Oo, O00000o0, O00000o, O00000oo, O00000oO, O0000O0o, O0000OOo);
    private final jqu O0000o0;
    /* access modifiers changed from: private */
    public final jqh O0000o00;
    private jpy O0000o0O;
    private jqv O0000o0o;

    class O000000o extends iqp {
        public O000000o(iqz iqz) {
            super(iqz);
        }

        public final void close() throws IOException {
            jpw.this.O0000o00.O000000o(false, jpw.this);
            super.close();
        }
    }

    public jpw(jqh jqh, jqu jqu) {
        this.O0000o00 = jqh;
        this.O0000o0 = jqu;
    }

    public final iqy O000000o(jri jri, long j) throws IOException {
        return this.O0000o0o.O00000o();
    }

    public final void O000000o(jpy jpy) {
        this.O0000o0O = jpy;
    }

    public final void O000000o(jqe jqe) throws IOException {
        jqe.O000000o(this.O0000o0o.O00000o());
    }

    public final void O00000Oo() throws IOException {
        this.O0000o0o.O00000o().close();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
     arg types: [ss.q, int]
     candidates:
      _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
      _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
      _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
      _m_j.jqp.O000000o(ss.q, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqu.O000000o(java.util.List<_m_j.jqw>, boolean, boolean):_m_j.jqv
     arg types: [java.util.List, boolean, int]
     candidates:
      _m_j.jqu.O000000o(_m_j.jqu, int, int):void
      _m_j.jqu.O000000o(_m_j.jqu, int, java.util.List):void
      _m_j.jqu.O000000o(_m_j.jqu, int, ss.ss.ss.a):void
      _m_j.jqu.O000000o(_m_j.jqu, ss.ss.ss.a, ss.ss.ss.a):void
      _m_j.jqu.O000000o(java.util.List<_m_j.jqw>, boolean, boolean):_m_j.jqv */
    public final void O000000o(jri jri) throws IOException {
        List list;
        if (this.O0000o0o == null) {
            this.O0000o0O.O000000o();
            boolean O000000o2 = jpy.O000000o(jri);
            if (this.O0000o0.f2065O000000o == u.HTTP_2) {
                jpi jpi = jri.O00000o0;
                list = new ArrayList((jpi.f2020O000000o.length / 2) + 4);
                list.add(new jqw(jqw.O00000Oo, jri.O00000Oo));
                list.add(new jqw(jqw.O00000o0, jqd.O000000o(jri.f2095O000000o)));
                list.add(new jqw(jqw.O00000oO, jqp.O000000o(jri.f2095O000000o, false)));
                list.add(new jqw(jqw.O00000o, jri.f2095O000000o.f15491O000000o));
                int length = jpi.f2020O000000o.length / 2;
                for (int i = 0; i < length; i++) {
                    f O000000o3 = f.O000000o(jpi.O000000o(i).toLowerCase(Locale.US));
                    if (!O0000OoO.contains(O000000o3)) {
                        list.add(new jqw(O000000o3, jpi.O00000Oo(i)));
                    }
                }
            } else {
                list = O00000Oo(jri);
            }
            this.O0000o0o = this.O0000o0.O000000o((List<jqw>) list, O000000o2, true);
            this.O0000o0o.O0000OOo.O000000o((long) this.O0000o0O.O00000Oo.O0000ooO, TimeUnit.MILLISECONDS);
            this.O0000o0o.O0000Oo0.O000000o((long) this.O0000o0O.O00000Oo.O0000ooo, TimeUnit.MILLISECONDS);
        }
    }

    public final jrk.O000000o O000000o() throws IOException {
        if (this.O0000o0.f2065O000000o != u.HTTP_2) {
            return O000000o(this.O0000o0o.O00000o0());
        }
        List<jqw> O00000o02 = this.O0000o0o.O00000o0();
        String str = null;
        jpi.O000000o o000000o = new jpi.O000000o();
        int size = O00000o02.size();
        for (int i = 0; i < size; i++) {
            f fVar = O00000o02.get(i).O0000OOo;
            String O000000o2 = O00000o02.get(i).O0000Oo0.O000000o();
            if (fVar.equals(jqw.f2071O000000o)) {
                str = O000000o2;
            } else if (!O0000Ooo.contains(fVar)) {
                o000000o.O000000o(fVar.O000000o(), O000000o2);
            }
        }
        if (str != null) {
            jqg O000000o3 = jqg.O000000o("HTTP/1.1 ".concat(String.valueOf(str)));
            jrk.O000000o o000000o2 = new jrk.O000000o();
            o000000o2.O00000Oo = u.HTTP_2;
            o000000o2.O00000o0 = O000000o3.O00000Oo;
            o000000o2.O00000o = O000000o3.O00000o0;
            return o000000o2.O000000o(o000000o.O000000o());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(ss.q, boolean):java.lang.String
     arg types: [ss.q, int]
     candidates:
      _m_j.jqp.O000000o(java.io.Closeable, java.io.Closeable):void
      _m_j.jqp.O000000o(_m_j.iqz, java.util.concurrent.TimeUnit):boolean
      _m_j.jqp.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.jqp.O000000o(java.lang.String[], java.lang.String):boolean
      _m_j.jqp.O000000o(ss.q, boolean):java.lang.String */
    private static List<jqw> O00000Oo(jri jri) {
        jpi jpi = jri.O00000o0;
        ArrayList arrayList = new ArrayList((jpi.f2020O000000o.length / 2) + 5);
        arrayList.add(new jqw(jqw.O00000Oo, jri.O00000Oo));
        arrayList.add(new jqw(jqw.O00000o0, jqd.O000000o(jri.f2095O000000o)));
        arrayList.add(new jqw(jqw.O0000O0o, "HTTP/1.1"));
        arrayList.add(new jqw(jqw.O00000oo, jqp.O000000o(jri.f2095O000000o, false)));
        arrayList.add(new jqw(jqw.O00000o, jri.f2095O000000o.f15491O000000o));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jpi.f2020O000000o.length / 2;
        for (int i = 0; i < length; i++) {
            f O000000o2 = f.O000000o(jpi.O000000o(i).toLowerCase(Locale.US));
            if (!O0000Oo0.contains(O000000o2)) {
                String O00000Oo2 = jpi.O00000Oo(i);
                if (linkedHashSet.add(O000000o2)) {
                    arrayList.add(new jqw(O000000o2, O00000Oo2));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        } else if (((jqw) arrayList.get(i2)).O0000OOo.equals(O000000o2)) {
                            arrayList.set(i2, new jqw(O000000o2, ((jqw) arrayList.get(i2)).O0000Oo0.O000000o() + 0 + O00000Oo2));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static jrk.O000000o O000000o(List<jqw> list) throws IOException {
        jpi.O000000o o000000o = new jpi.O000000o();
        int size = list.size();
        String str = "HTTP/1.1";
        String str2 = null;
        int i = 0;
        while (i < size) {
            f fVar = list.get(i).O0000OOo;
            String O000000o2 = list.get(i).O0000Oo0.O000000o();
            String str3 = str;
            String str4 = str2;
            int i2 = 0;
            while (i2 < O000000o2.length()) {
                int indexOf = O000000o2.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = O000000o2.length();
                }
                String substring = O000000o2.substring(i2, indexOf);
                if (fVar.equals(jqw.f2071O000000o)) {
                    str4 = substring;
                } else if (fVar.equals(jqw.O0000O0o)) {
                    str3 = substring;
                } else if (!O0000Oo.contains(fVar)) {
                    o000000o.O000000o(fVar.O000000o(), substring);
                }
                i2 = indexOf + 1;
            }
            i++;
            str2 = str4;
            str = str3;
        }
        if (str2 != null) {
            jqg O000000o3 = jqg.O000000o(str + " " + str2);
            jrk.O000000o o000000o2 = new jrk.O000000o();
            o000000o2.O00000Oo = u.SPDY_3;
            o000000o2.O00000o0 = O000000o3.O00000Oo;
            o000000o2.O00000o = O000000o3.O00000o0;
            return o000000o2.O000000o(o000000o.O000000o());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public final jrl O000000o(jrk jrk) throws IOException {
        return new jqc(jrk.O00000oo, iqt.O000000o(new O000000o(this.O0000o0o.O00000oo)));
    }
}
