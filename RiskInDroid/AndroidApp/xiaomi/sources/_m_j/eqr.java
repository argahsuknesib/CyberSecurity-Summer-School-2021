package _m_j;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class eqr {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f15731O000000o = null;
    private static String O00000Oo = (erb.O000000o() + "-");
    private static long O00000o0 = 0;
    protected static final String O0000o0 = Locale.getDefault().getLanguage().toLowerCase();
    public static final DateFormat O0000o0O;
    private List<eqo> O00000o = new CopyOnWriteArrayList();
    private final Map<String, Object> O00000oO = new HashMap();
    String O0000o = null;
    protected String O0000o0o = f15731O000000o;
    public String O0000oO = null;
    public String O0000oO0 = null;
    public String O0000oOO = null;
    public String O0000oOo = null;
    protected equ O0000oo0 = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        O0000o0O = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public eqr() {
    }

    public eqr(Bundle bundle) {
        this.O0000oO0 = bundle.getString("ext_to");
        this.O0000oO = bundle.getString("ext_from");
        this.O0000oOO = bundle.getString("ext_chid");
        this.O0000o = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.O00000o = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                this.O00000o.add(eqo.O000000o((Bundle) parcelable));
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.O0000oo0 = new equ(bundle2);
        }
    }

    private synchronized Object O00000Oo(String str) {
        if (this.O00000oO == null) {
            return null;
        }
        return this.O00000oO.get(str);
    }

    public static synchronized String O00000o0() {
        String sb;
        synchronized (eqr.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O00000Oo);
            long j = O00000o0;
            O00000o0 = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String O00000oo() {
        return O0000o0;
    }

    private synchronized Collection<eqo> O0000O0o() {
        if (this.O00000o == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.O00000o));
    }

    private synchronized Collection<String> O0000OOo() {
        if (this.O00000oO == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.O00000oO.keySet()));
    }

    public Bundle O000000o() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.O0000o0o)) {
            bundle.putString("ext_ns", this.O0000o0o);
        }
        if (!TextUtils.isEmpty(this.O0000oO)) {
            bundle.putString("ext_from", this.O0000oO);
        }
        if (!TextUtils.isEmpty(this.O0000oO0)) {
            bundle.putString("ext_to", this.O0000oO0);
        }
        if (!TextUtils.isEmpty(this.O0000o)) {
            bundle.putString("ext_pkt_id", this.O0000o);
        }
        if (!TextUtils.isEmpty(this.O0000oOO)) {
            bundle.putString("ext_chid", this.O0000oOO);
        }
        equ equ = this.O0000oo0;
        if (equ != null) {
            bundle.putBundle("ext_ERROR", equ.O000000o());
        }
        List<eqo> list = this.O00000o;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (eqo O00000o02 : this.O00000o) {
                bundleArr[i] = O00000o02.O00000o0();
                i++;
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public final void O000000o(eqo eqo) {
        this.O00000o.add(eqo);
    }

    public abstract String O00000Oo();

    public final String O00000o() {
        if ("ID_NOT_AVAILABLE".equals(this.O0000o)) {
            return null;
        }
        if (this.O0000o == null) {
            this.O0000o = O00000o0();
        }
        return this.O0000o;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:32|33|34|35|36|37|38|39|40|41|42|60|62|63) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:64|(0)|(0)|72|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010e, code lost:
        if (r4 == null) goto L_0x0111;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0125 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0109 A[SYNTHETIC, Splitter:B:56:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011b A[SYNTHETIC, Splitter:B:66:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0122 A[SYNTHETIC, Splitter:B:70:0x0122] */
    public final synchronized String O00000oO() {
        StringBuilder sb;
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        String str;
        sb = new StringBuilder();
        for (eqo O00000Oo2 : O0000O0o()) {
            sb.append(O00000Oo2.O00000Oo());
        }
        if (this.O00000oO != null && !this.O00000oO.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String next : O0000OOo()) {
                Object O00000Oo3 = O00000Oo(next);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(erb.O000000o(next));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (O00000Oo3 instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(O00000Oo3);
                    str = "</value>";
                } else if (O00000Oo3 instanceof Long) {
                    sb.append("long\">");
                    sb.append(O00000Oo3);
                    str = "</value>";
                } else if (O00000Oo3 instanceof Float) {
                    sb.append("float\">");
                    sb.append(O00000Oo3);
                    str = "</value>";
                } else if (O00000Oo3 instanceof Double) {
                    sb.append("double\">");
                    sb.append(O00000Oo3);
                    str = "</value>";
                } else if (O00000Oo3 instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(O00000Oo3);
                    str = "</value>";
                } else if (O00000Oo3 instanceof String) {
                    sb.append("string\">");
                    sb.append(erb.O000000o((String) O00000Oo3));
                    str = "</value>";
                } else {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream.writeObject(O00000Oo3);
                                sb.append("java-object\">");
                                sb.append(erb.O000000o(byteArrayOutputStream.toByteArray()));
                                sb.append("</value>");
                                objectOutputStream.close();
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    if (objectOutputStream != null) {
                                    }
                                    if (byteArrayOutputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = null;
                            e = e;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            objectOutputStream = null;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                        e = e;
                        e.printStackTrace();
                        if (objectOutputStream != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                    byteArrayOutputStream.close();
                    sb.append("</property>");
                }
                sb.append(str);
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            eqr eqr = (eqr) obj;
            equ equ = this.O0000oo0;
            if (equ == null ? eqr.O0000oo0 != null : !equ.equals(eqr.O0000oo0)) {
                return false;
            }
            String str = this.O0000oO;
            if (str == null ? eqr.O0000oO != null : !str.equals(eqr.O0000oO)) {
                return false;
            }
            if (!this.O00000o.equals(eqr.O00000o)) {
                return false;
            }
            String str2 = this.O0000o;
            if (str2 == null ? eqr.O0000o != null : !str2.equals(eqr.O0000o)) {
                return false;
            }
            String str3 = this.O0000oOO;
            if (str3 == null ? eqr.O0000oOO != null : !str3.equals(eqr.O0000oOO)) {
                return false;
            }
            Map<String, Object> map = this.O00000oO;
            if (map == null ? eqr.O00000oO != null : !map.equals(eqr.O00000oO)) {
                return false;
            }
            String str4 = this.O0000oO0;
            if (str4 == null ? eqr.O0000oO0 != null : !str4.equals(eqr.O0000oO0)) {
                return false;
            }
            String str5 = this.O0000o0o;
            return str5 == null ? eqr.O0000o0o == null : str5.equals(eqr.O0000o0o);
        }
    }

    public int hashCode() {
        String str = this.O0000o0o;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.O0000o;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.O0000oO0;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.O0000oO;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.O0000oOO;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.O00000o.hashCode()) * 31) + this.O00000oO.hashCode()) * 31;
        equ equ = this.O0000oo0;
        if (equ != null) {
            i = equ.hashCode();
        }
        return hashCode5 + i;
    }

    public final eqo O000000o(String str) {
        for (eqo next : this.O00000o) {
            if (str.equals(next.f15727O000000o)) {
                return next;
            }
        }
        return null;
    }
}
