package _m_j;

import android.text.TextUtils;
import com.loc.t;
import java.net.URLConnection;
import java.util.Map;

public final class bsw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f13254O000000o = 0;
    public static String O00000Oo = "";
    private static bsw O00000o0;

    public interface O000000o {
        URLConnection O000000o();
    }

    public static bsw O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new bsw();
        }
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b A[Catch:{ t -> 0x0093, Throwable -> 0x0091 }] */
    public static bta O000000o(bsz bsz, boolean z) throws t {
        String str;
        String O000000o2;
        if (bsz != null) {
            try {
                if (bsz.O00000o0() == null || "".equals(bsz.O00000o0())) {
                    throw new t("request url is empty");
                }
                bsy bsy = new bsy(bsz.O00000o0, bsz.O00000o, bsz.O00000oO == null ? null : bsz.O00000oO, z);
                byte[] O00000o = bsz.O00000o();
                if (O00000o != null) {
                    if (O00000o.length != 0) {
                        Map<String, String> O00000Oo2 = bsz.O00000Oo();
                        if (O00000Oo2 != null) {
                            String O000000o3 = bsy.O000000o(O00000Oo2);
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(bsz.O00000o0());
                            stringBuffer.append("?");
                            stringBuffer.append(O000000o3);
                            str = stringBuffer.toString();
                            String str2 = str;
                            boolean O0000Ooo = bsz.O0000Ooo();
                            String O0000OoO = bsz.O0000OoO();
                            Map<String, String> O000000o4 = bsz.O000000o();
                            byte[] O00000o2 = bsz.O00000o();
                            if (O00000o2 == null || O00000o2.length == 0) {
                                O000000o2 = bsy.O000000o(bsz.O00000Oo());
                                if (!TextUtils.isEmpty(O000000o2)) {
                                    O00000o2 = brs.O000000o(O000000o2);
                                }
                            }
                            return bsy.O000000o(str2, O0000Ooo, O0000OoO, O000000o4, O00000o2, bsz.O0000o00());
                        }
                    }
                }
                str = bsz.O00000o0();
                String str22 = str;
                boolean O0000Ooo2 = bsz.O0000Ooo();
                String O0000OoO2 = bsz.O0000OoO();
                Map<String, String> O000000o42 = bsz.O000000o();
                byte[] O00000o22 = bsz.O00000o();
                O000000o2 = bsy.O000000o(bsz.O00000Oo());
                if (!TextUtils.isEmpty(O000000o2)) {
                }
                return bsy.O000000o(str22, O0000Ooo2, O0000OoO2, O000000o42, O00000o22, bsz.O0000o00());
            } catch (t e) {
                throw e;
            } catch (Throwable th) {
                th.printStackTrace();
                throw new t("未知的错误");
            }
        } else {
            throw new t("requeust is null");
        }
    }

    public static byte[] O000000o(bsz bsz) throws t {
        try {
            bta O000000o2 = O000000o(bsz, true);
            if (O000000o2 != null) {
                return O000000o2.f13259O000000o;
            }
            return null;
        } catch (t e) {
            throw e;
        } catch (Throwable unused) {
            throw new t("未知的错误");
        }
    }

    public static byte[] O00000Oo(bsz bsz) throws t {
        try {
            bta O000000o2 = O000000o(bsz, false);
            if (O000000o2 != null) {
                return O000000o2.f13259O000000o;
            }
            return null;
        } catch (t e) {
            throw e;
        } catch (Throwable th) {
            bsc.O000000o(th, "bm", "msp");
            throw new t("未知的错误");
        }
    }
}
