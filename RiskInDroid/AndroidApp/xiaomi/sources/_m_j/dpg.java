package _m_j;

import android.view.View;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dpg {

    /* renamed from: O000000o  reason: collision with root package name */
    List<dpf> f14832O000000o = new ArrayList();
    public Object O00000Oo;
    private o0O0OOO0<dpf, List<O000000o>> O00000o = new o0O0OOO0<>();
    public View O00000o0;

    interface O00000Oo {
        Object O000000o(Object obj);

        boolean O000000o(String str);
    }

    public static class O000000o {
        private static final Object O00000o = new Object();

        /* renamed from: O000000o  reason: collision with root package name */
        public dpf f14833O000000o;
        public int O00000Oo;
        public String O00000o0;
        private O00000Oo O00000oO;
        private o0O0OOO0<Integer, Object> O00000oo = new o0O0OOO0<>();
        private int O0000O0o = 0;

        public O000000o(dpf dpf, int i, String str, int i2) {
            this.f14833O000000o = dpf;
            this.O00000Oo = i;
            this.O00000o0 = str;
            this.O0000O0o = i2;
            if (this.O00000o0 == null) {
                return;
            }
            if (bns.O00000Oo(str)) {
                this.O00000oO = new O00000o((byte) 0);
                this.O00000oO.O000000o(this.O00000o0);
                return;
            }
            this.O00000oO = new O00000o0((byte) 0);
            this.O00000oO.O000000o(this.O00000o0);
        }

        public final void O000000o(Object obj, boolean z) {
            Object obj2 = this.O00000oo.get(Integer.valueOf(obj.hashCode()));
            if (obj2 == null) {
                obj2 = this.O00000oO.O000000o(obj);
                if (obj2 == null) {
                    obj2 = O00000o;
                } else {
                    String O00000o2 = bns.O00000o(obj2);
                    int i = this.O0000O0o;
                    if (i == 3) {
                        obj2 = Integer.valueOf(bns.O00000o0(O00000o2));
                    } else if (i == 8) {
                        String[] split = O00000o2.split("\\|");
                        int i2 = 0;
                        for (String trim : split) {
                            String trim2 = trim.trim();
                            if (bnr.O000000o("bold", trim2)) {
                                i2 |= 1;
                            } else if (bnr.O000000o("italic", trim2)) {
                                i2 |= 2;
                            } else if (bnr.O000000o("styleStrike", trim2)) {
                                i2 |= 8;
                            }
                        }
                        obj2 = Integer.valueOf(i2);
                    } else if (i != 5) {
                        if (i == 6) {
                            String[] split2 = O00000o2.split("\\|");
                            int i3 = 0;
                            for (String trim3 : split2) {
                                String trim4 = trim3.trim();
                                if (bnr.O000000o("left", trim4)) {
                                    i3 |= 1;
                                } else if (bnr.O000000o("right", trim4)) {
                                    i3 |= 2;
                                } else if (bnr.O000000o("h_center", trim4)) {
                                    i3 |= 4;
                                } else if (bnr.O000000o("top", trim4)) {
                                    i3 |= 8;
                                } else if (bnr.O000000o("bottom", trim4)) {
                                    i3 |= 16;
                                } else {
                                    if (!bnr.O000000o("v_center", trim4)) {
                                        if (!bnr.O000000o("center", trim4)) {
                                            break;
                                        }
                                        i3 |= 4;
                                    }
                                    i3 |= 32;
                                }
                            }
                            obj2 = Integer.valueOf(i3);
                        }
                    } else if ("invisible".equals(O00000o2)) {
                        obj2 = 0;
                    } else if ("gone".equals(O00000o2)) {
                        obj2 = 2;
                    } else {
                        obj2 = 1;
                    }
                }
                this.O00000oo.put(Integer.valueOf(obj.hashCode()), obj2);
            }
            if (obj2 != O00000o) {
                switch (this.O0000O0o) {
                    case 0:
                        if (obj2 instanceof Number) {
                            Integer O00000o02 = bns.O00000o0(obj2);
                            if (O00000o02 != null) {
                                this.f14833O000000o.O00000o0(this.O00000Oo, O00000o02.intValue());
                                return;
                            }
                            return;
                        }
                        String obj3 = obj2.toString();
                        if (obj3.endsWith("rp")) {
                            Integer O00000o03 = bns.O00000o0((Object) obj3.substring(0, obj3.length() - 2));
                            if (O00000o03 != null) {
                                this.f14833O000000o.O00000Oo(this.O00000Oo, O00000o03.intValue());
                                return;
                            }
                            return;
                        }
                        Integer O00000o04 = bns.O00000o0(obj2);
                        if (O00000o04 != null) {
                            this.f14833O000000o.O00000o0(this.O00000Oo, O00000o04.intValue());
                            return;
                        }
                        return;
                    case 1:
                        if (obj2 instanceof Number) {
                            Float O00000Oo2 = bns.O00000Oo(obj2);
                            if (O00000Oo2 != null) {
                                this.f14833O000000o.O00000Oo(this.O00000Oo, O00000Oo2.floatValue());
                                return;
                            }
                            return;
                        }
                        String obj4 = obj2.toString();
                        if (obj4.endsWith("rp")) {
                            Float O00000Oo3 = bns.O00000Oo((Object) obj4.substring(0, obj4.length() - 2));
                            if (O00000Oo3 != null) {
                                this.f14833O000000o.O000000o(this.O00000Oo, O00000Oo3.floatValue());
                                return;
                            }
                            return;
                        }
                        Float O00000Oo4 = bns.O00000Oo(obj2);
                        if (O00000Oo4 != null) {
                            this.f14833O000000o.O00000Oo(this.O00000Oo, O00000Oo4.floatValue());
                            return;
                        }
                        return;
                    case 2:
                        this.f14833O000000o.O000000o(this.O00000Oo, bns.O00000o(obj2));
                        return;
                    case 3:
                    case 5:
                    case 6:
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        Integer O00000o05 = bns.O00000o0(obj2);
                        if (O00000o05 != null) {
                            this.f14833O000000o.O00000o0(this.O00000Oo, O00000o05.intValue());
                            return;
                        }
                        return;
                    case 4:
                        Boolean O000000o2 = bns.O000000o(obj2);
                        if (O000000o2 != null) {
                            this.f14833O000000o.O00000o0(this.O00000Oo, O000000o2.booleanValue() ? 1 : 0);
                            return;
                        } else {
                            this.f14833O000000o.O00000o0(this.O00000Oo, 0);
                            return;
                        }
                    case 7:
                        this.f14833O000000o.O00000Oo(obj2);
                        return;
                    default:
                        return;
                }
            }
        }

        public final void O000000o(int i) {
            this.O00000oo.remove(Integer.valueOf(i));
        }
    }

    public final void O000000o(dpf dpf, int i, String str, int i2) {
        List list = this.O00000o.get(dpf);
        if (list == null) {
            list = new ArrayList();
            this.O00000o.put(dpf, list);
            this.f14832O000000o.add(dpf);
        }
        list.add(new O000000o(dpf, i, str, i2));
    }

    public final List<O000000o> O000000o(dpf dpf) {
        return this.O00000o.get(dpf);
    }

    static class O00000o0 implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private List<Object> f14835O000000o;
        private String O00000Oo;
        private int O00000o0;

        private O00000o0() {
            this.f14835O000000o = new LinkedList();
        }

        /* synthetic */ O00000o0(byte b) {
            this();
        }

        public final boolean O000000o(String str) {
            if (!(str == null || str.length() == 0)) {
                this.O00000Oo = str;
                int length = str.length();
                this.f14835O000000o.clear();
                if (str.charAt(0) == '$' && str.charAt(1) == '{') {
                    int i = length - 1;
                    if (str.charAt(i) == '}') {
                        StringBuilder sb = new StringBuilder();
                        this.O00000o0 = 2;
                        for (int i2 = 2; i2 < i; i2++) {
                            char charAt = str.charAt(i2);
                            if (charAt == '.') {
                                int i3 = this.O00000o0;
                                if (i3 == 3) {
                                    sb.append(charAt);
                                } else if (i3 == 4) {
                                    this.O00000o0 = 2;
                                } else {
                                    String sb2 = sb.toString();
                                    try {
                                        this.f14835O000000o.add(Integer.valueOf(Integer.parseInt(sb2)));
                                    } catch (NumberFormatException unused) {
                                        this.f14835O000000o.add(sb2);
                                    }
                                    sb.delete(0, sb.length());
                                }
                            } else if (charAt != '[') {
                                if (charAt != ']') {
                                    sb.append(charAt);
                                } else if (this.O00000o0 != 3) {
                                    return false;
                                } else {
                                    String sb3 = sb.toString();
                                    try {
                                        this.f14835O000000o.add(Integer.valueOf(Integer.parseInt(sb3)));
                                    } catch (NumberFormatException unused2) {
                                        this.f14835O000000o.add(sb3);
                                    }
                                    sb.delete(0, sb.length());
                                    this.O00000o0 = 4;
                                }
                            } else if (this.O00000o0 != 2) {
                                return false;
                            } else {
                                if (sb.length() > 0) {
                                    String sb4 = sb.toString();
                                    try {
                                        this.f14835O000000o.add(Integer.valueOf(Integer.parseInt(sb4)));
                                    } catch (NumberFormatException unused3) {
                                        this.f14835O000000o.add(sb4);
                                    }
                                    sb.delete(0, sb.length());
                                }
                                this.O00000o0 = 3;
                            }
                        }
                        if (this.O00000o0 == 2) {
                            String sb5 = sb.toString();
                            try {
                                this.f14835O000000o.add(Integer.valueOf(Integer.parseInt(sb5)));
                            } catch (NumberFormatException unused4) {
                                this.f14835O000000o.add(sb5);
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        public final Object O000000o(Object obj) {
            Object obj2 = null;
            if (this.f14835O000000o.size() <= 0) {
                return this.O00000Oo;
            }
            if (obj == null) {
                return null;
            }
            int i = 0;
            int size = this.f14835O000000o.size();
            while (i < size) {
                Object obj3 = this.f14835O000000o.get(i);
                if (obj3 instanceof String) {
                    String obj4 = obj3.toString();
                    if (!obj4.equalsIgnoreCase("this")) {
                        if (!(obj instanceof JSONObject)) {
                            return obj2;
                        }
                        obj = ((JSONObject) obj).opt(obj4);
                    }
                } else if (!(obj3 instanceof Integer)) {
                    continue;
                    i++;
                    obj = obj2;
                } else if (!(obj instanceof JSONArray)) {
                    return obj2;
                } else {
                    obj = ((JSONArray) obj).opt(((Integer) obj3).intValue());
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
            return obj2;
        }
    }

    static class O00000o implements O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private int f14834O000000o;
        private O00000o0 O00000Oo;
        private O00000o0 O00000o;
        private O00000o0 O00000o0;
        private String O00000oO;

        private O00000o() {
        }

        /* synthetic */ O00000o(byte b) {
            this();
        }

        public final boolean O000000o(String str) {
            if (!(str == null || str.length() == 0)) {
                this.O00000oO = str;
                int length = str.length();
                if (str.charAt(0) == '@' && str.charAt(1) == '{') {
                    int i = length - 1;
                    if (str.charAt(i) == '}') {
                        StringBuilder sb = new StringBuilder();
                        this.f14834O000000o = 1;
                        for (int i2 = 2; i2 < i; i2++) {
                            char charAt = str.charAt(i2);
                            if (charAt != ':') {
                                if (charAt != '?') {
                                    sb.append(charAt);
                                } else if (this.f14834O000000o == 1) {
                                    this.O00000Oo = new O00000o0((byte) 0);
                                    this.O00000Oo.O000000o(sb.toString().trim());
                                    sb.delete(0, sb.length());
                                    this.f14834O000000o = 2;
                                }
                            } else if (this.f14834O000000o == 2) {
                                this.O00000o0 = new O00000o0((byte) 0);
                                this.O00000o0.O000000o(sb.toString().trim());
                                sb.delete(0, sb.length());
                                this.f14834O000000o = 3;
                            }
                        }
                        if (this.f14834O000000o == 3) {
                            this.O00000o = new O00000o0((byte) 0);
                            this.O00000o.O000000o(sb.toString().trim());
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
            if (_m_j.bnr.O000000o(((java.lang.String) r0).toLowerCase(), "false") != false) goto L_0x006d;
         */
        public final Object O000000o(Object obj) {
            O00000o0 o00000o0 = this.O00000Oo;
            if (o00000o0 == null || this.O00000o0 == null || this.O00000o == null) {
                return this.O00000oO;
            }
            if (obj == null) {
                return null;
            }
            Object O000000o2 = o00000o0.O000000o(obj);
            boolean z = false;
            if (O000000o2 != null) {
                if (O000000o2 instanceof Boolean) {
                    z = ((Boolean) O000000o2).booleanValue();
                } else {
                    if (O000000o2 instanceof String) {
                        CharSequence charSequence = (CharSequence) O000000o2;
                        if (!bnr.O000000o(charSequence)) {
                            if (!bnr.O000000o(charSequence, "null")) {
                            }
                        }
                    } else if (!(O000000o2 instanceof JSONObject)) {
                    }
                    z = true;
                }
            }
            if (z) {
                return this.O00000o0.O000000o(obj);
            }
            return this.O00000o.O000000o(obj);
        }
    }
}
