package _m_j;

import _m_j.jpj;
import _m_j.jrg;
import _m_j.jri;
import _m_j.jrj;
import com.sdu.didi.openapi.utils.Utils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import ss.q;

public final class daz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static daz f14427O000000o;
    private jrg O00000Oo;

    public class O000000o implements jpj {
        private final String O00000Oo;

        public O000000o(String str) {
            this.O00000Oo = str;
        }

        public final jrk O000000o(jpj.O000000o o000000o) throws IOException {
            return o000000o.O000000o(o000000o.O000000o().O000000o().O000000o("User-Agent", this.O00000Oo).O000000o());
        }
    }

    public static synchronized daz O000000o() {
        daz daz;
        synchronized (daz.class) {
            if (f14427O000000o == null) {
                f14427O000000o = new daz();
            }
            daz = f14427O000000o;
        }
        return daz;
    }

    private daz() {
        jrg.O000000o o000000o = new jrg.O000000o();
        o000000o.O00000oo.add(new O000000o("didi.sdk" + Utils.getCurrentVersion()));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(3);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (millis == 0) {
                throw new IllegalArgumentException("Timeout too small.");
            } else {
                o000000o.O0000oo = (int) millis;
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                if (timeUnit2 != null) {
                    long millis2 = timeUnit2.toMillis(3);
                    if (millis2 > 2147483647L) {
                        throw new IllegalArgumentException("Timeout too large.");
                    } else if (millis2 == 0) {
                        throw new IllegalArgumentException("Timeout too small.");
                    } else {
                        o000000o.O0000ooO = (int) millis2;
                        TimeUnit timeUnit3 = TimeUnit.SECONDS;
                        if (timeUnit3 != null) {
                            long millis3 = timeUnit3.toMillis(3);
                            if (millis3 > 2147483647L) {
                                throw new IllegalArgumentException("Timeout too large.");
                            } else if (millis3 == 0) {
                                throw new IllegalArgumentException("Timeout too small.");
                            } else {
                                o000000o.O0000ooo = (int) millis3;
                                this.O00000Oo = new jrg(o000000o, (byte) 0);
                            }
                        } else {
                            throw new NullPointerException("unit == null");
                        }
                    }
                } else {
                    throw new NullPointerException("unit == null");
                }
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093 A[Catch:{ IOException -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0 A[Catch:{ IOException -> 0x00f8 }] */
    public final String O000000o(String str, Map<String, String> map) {
        q O00000o;
        Charset charset;
        StringBuilder sb;
        try {
            jri.O000000o o000000o = new jri.O000000o();
            jpk O000000o2 = jpk.O000000o("application/x-www-form-urlencoded");
            String O000000o3 = Utils.O000000o(map);
            Charset charset2 = jqp.O00000o0;
            if (O000000o2 != null) {
                charset2 = O000000o2.f2022O000000o != null ? Charset.forName(O000000o2.f2022O000000o) : null;
                if (charset2 == null) {
                    charset2 = jqp.O00000o0;
                    O000000o2 = jpk.O000000o(O000000o2 + "; charset=utf-8");
                }
            }
            byte[] bytes = O000000o3.getBytes(charset2);
            int length = bytes.length;
            if (bytes != null) {
                jqp.O000000o((long) bytes.length, 0, (long) length);
                boolean z = false;
                jrj.AnonymousClass1 r4 = new jrj(O000000o2, length, bytes, 0) {
                    /* class _m_j.jrj.AnonymousClass1 */

                    /* renamed from: O000000o */
                    final /* synthetic */ jpk f2097O000000o;
                    final /* synthetic */ int O00000Oo;
                    final /* synthetic */ int O00000o = 0;
                    final /* synthetic */ byte[] O00000o0;

                    {
                        this.f2097O000000o = r1;
                        this.O00000Oo = r2;
                        this.O00000o0 = r3;
                    }

                    public final jpk O000000o() {
                        return this.f2097O000000o;
                    }

                    public final void O000000o(iqm iqm) {
                        iqm.O00000Oo(this.O00000o0, this.O00000o, this.O00000Oo);
                    }

                    public final long O00000Oo() {
                        return (long) this.O00000Oo;
                    }
                };
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    sb = new StringBuilder("http:");
                    sb.append(str.substring(3));
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        sb = new StringBuilder("https:");
                        sb.append(str.substring(4));
                    }
                    O00000o = q.O00000o(str);
                    if (O00000o == null) {
                        jrk O000000o4 = this.O00000Oo.O000000o(o000000o.O000000o(O00000o).O000000o("POST", r4).O000000o()).O000000o();
                        if (O000000o4.O00000o0 >= 200 && O000000o4.O00000o0 < 300) {
                            z = true;
                        }
                        if (!z) {
                            return "";
                        }
                        jrl jrl = O000000o4.O0000O0o;
                        byte[] O00000o2 = jrl.O00000o();
                        jpk O000000o5 = jrl.O000000o();
                        if (O000000o5 != null) {
                            charset = jqp.O00000o0;
                            if (O000000o5.f2022O000000o != null) {
                                charset = Charset.forName(O000000o5.f2022O000000o);
                            }
                        } else {
                            charset = jqp.O00000o0;
                        }
                        return new String(O00000o2, charset.name());
                    }
                    throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
                }
                str = sb.toString();
                O00000o = q.O00000o(str);
                if (O00000o == null) {
                }
            } else {
                throw new NullPointerException("content == null");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
