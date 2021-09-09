package com.xiaomi.smarthome.svg;

import _m_j.gsy;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.svg.SVG;
import com.xiaomi.smarthome.svg.SVGParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xml.sax.SAXException;

public final class CSSParser {

    /* renamed from: O000000o  reason: collision with root package name */
    private MediaType f11857O000000o = null;
    private boolean O00000Oo = false;

    enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        tty,
        tv
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f11860O000000o = null;
        public AttribOp O00000Oo;
        public String O00000o0 = null;

        public O000000o(String str, AttribOp attribOp, String str2) {
            this.f11860O000000o = str;
            this.O00000Oo = attribOp;
            this.O00000o0 = str2;
        }
    }

    static class O0000OOo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Combinator f11864O000000o = null;
        public String O00000Oo = null;
        public List<String> O00000o = null;
        public List<O000000o> O00000o0 = null;

        public O0000OOo(Combinator combinator, String str) {
            this.f11864O000000o = combinator == null ? Combinator.DESCENDANT : combinator;
            this.O00000Oo = str;
        }

        public final void O000000o(String str, AttribOp attribOp, String str2) {
            if (this.O00000o0 == null) {
                this.O00000o0 = new ArrayList();
            }
            this.O00000o0.add(new O000000o(str, attribOp, str2));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f11864O000000o == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.f11864O000000o == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.O00000Oo;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<O000000o> list = this.O00000o0;
            if (list != null) {
                for (O000000o next : list) {
                    sb.append('[');
                    sb.append(next.f11860O000000o);
                    int i = AnonymousClass1.f11858O000000o[next.O00000Oo.ordinal()];
                    if (i == 1) {
                        sb.append('=');
                        sb.append(next.O00000o0);
                    } else if (i == 2) {
                        sb.append("~=");
                        sb.append(next.O00000o0);
                    } else if (i == 3) {
                        sb.append("|=");
                        sb.append(next.O00000o0);
                    }
                    sb.append(']');
                }
            }
            List<String> list2 = this.O00000o;
            if (list2 != null) {
                for (String append : list2) {
                    sb.append(':');
                    sb.append(append);
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.xiaomi.smarthome.svg.CSSParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f11858O000000o = new int[AttribOp.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            f11858O000000o[AttribOp.EQUALS.ordinal()] = 1;
            f11858O000000o[AttribOp.INCLUDES.ordinal()] = 2;
            try {
                f11858O000000o[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<O00000o0> f11861O000000o = null;

        public final void O000000o(O00000o0 o00000o0) {
            if (this.f11861O000000o == null) {
                this.f11861O000000o = new ArrayList();
            }
            for (int i = 0; i < this.f11861O000000o.size(); i++) {
                if (this.f11861O000000o.get(i).f11862O000000o.O00000Oo > o00000o0.f11862O000000o.O00000Oo) {
                    this.f11861O000000o.add(i, o00000o0);
                    return;
                }
            }
            this.f11861O000000o.add(o00000o0);
        }

        public final void O000000o(O00000o o00000o) {
            List<O00000o0> list = o00000o.f11861O000000o;
            if (list != null) {
                if (this.f11861O000000o == null) {
                    this.f11861O000000o = new ArrayList(list.size());
                }
                for (O00000o0 add : o00000o.f11861O000000o) {
                    this.f11861O000000o.add(add);
                }
            }
        }

        public final String toString() {
            if (this.f11861O000000o == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (O00000o0 o00000o0 : this.f11861O000000o) {
                sb.append(o00000o0.toString());
                sb.append(10);
            }
            return sb.toString();
        }
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public O0000O0o f11862O000000o = null;
        public SVG.Style O00000Oo = null;

        public O00000o0(O0000O0o o0000O0o, SVG.Style style) {
            this.f11862O000000o = o0000O0o;
            this.O00000Oo = style;
        }

        public final String toString() {
            return this.f11862O000000o + " {}";
        }
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<O0000OOo> f11863O000000o = null;
        public int O00000Oo = 0;

        public final int O000000o() {
            List<O0000OOo> list = this.f11863O000000o;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final O0000OOo O000000o(int i) {
            return this.f11863O000000o.get(i);
        }

        public final boolean O00000Oo() {
            List<O0000OOo> list = this.f11863O000000o;
            if (list == null) {
                return true;
            }
            return list.isEmpty();
        }

        public final void O00000o0() {
            this.O00000Oo += 100;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            for (O0000OOo append : this.f11863O000000o) {
                sb.append(append);
                sb.append(' ');
            }
            sb.append('(');
            sb.append(this.O00000Oo);
            sb.append(')');
            return sb.toString();
        }
    }

    public CSSParser(MediaType mediaType) {
        this.f11857O000000o = mediaType;
    }

    static class O00000Oo extends SVGParser.O000000o {
        public O00000Oo(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:0x0173 A[EDGE_INSN: B:101:0x0173->B:90:0x0173 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0175  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0186  */
        public final boolean O000000o(O0000O0o o0000O0o) throws SAXException {
            Combinator combinator;
            O0000OOo o0000OOo;
            AttribOp attribOp;
            String str;
            if (O00000o0()) {
                return false;
            }
            int i = this.O00000Oo;
            if (!o0000O0o.O00000Oo()) {
                if (O000000o('>')) {
                    combinator = Combinator.CHILD;
                    O00000o();
                } else if (O000000o('+')) {
                    combinator = Combinator.FOLLOWS;
                    O00000o();
                }
                if (!O000000o('*')) {
                    o0000OOo = new O0000OOo(combinator, null);
                } else {
                    String O000000o2 = O000000o();
                    if (O000000o2 != null) {
                        O0000OOo o0000OOo2 = new O0000OOo(combinator, O000000o2);
                        o0000O0o.O00000Oo++;
                        o0000OOo = o0000OOo2;
                    } else {
                        o0000OOo = null;
                    }
                }
                while (true) {
                    if (O00000o0()) {
                        break;
                    } else if (O000000o('.')) {
                        if (o0000OOo == null) {
                            o0000OOo = new O0000OOo(combinator, null);
                        }
                        String O000000o3 = O000000o();
                        if (O000000o3 != null) {
                            o0000OOo.O000000o("class", AttribOp.EQUALS, O000000o3);
                            o0000O0o.O00000o0();
                        } else {
                            throw new SAXException("Invalid \".class\" selector in <style> element");
                        }
                    } else {
                        if (O000000o('#')) {
                            if (o0000OOo == null) {
                                o0000OOo = new O0000OOo(combinator, null);
                            }
                            String O000000o4 = O000000o();
                            if (O000000o4 != null) {
                                o0000OOo.O000000o("id", AttribOp.EQUALS, O000000o4);
                                o0000O0o.O00000Oo += C.MSG_CUSTOM_BASE;
                            } else {
                                throw new SAXException("Invalid \"#id\" selector in <style> element");
                            }
                        }
                        if (o0000OOo == null) {
                            break;
                        } else if (O000000o('[')) {
                            O00000o();
                            String O000000o5 = O000000o();
                            if (O000000o5 != null) {
                                O00000o();
                                if (O000000o('=')) {
                                    attribOp = AttribOp.EQUALS;
                                } else if (O000000o("~=")) {
                                    attribOp = AttribOp.INCLUDES;
                                } else {
                                    attribOp = O000000o("|=") ? AttribOp.DASHMATCH : null;
                                }
                                if (attribOp != null) {
                                    O00000o();
                                    if (O00000o0()) {
                                        str = null;
                                    } else {
                                        str = O0000oO0();
                                        if (str == null) {
                                            str = O000000o();
                                        }
                                    }
                                    if (str != null) {
                                        O00000o();
                                    } else {
                                        throw new SAXException("Invalid attribute selector in <style> element");
                                    }
                                } else {
                                    str = null;
                                }
                                if (O000000o(']')) {
                                    if (attribOp == null) {
                                        attribOp = AttribOp.EXISTS;
                                    }
                                    o0000OOo.O000000o(O000000o5, attribOp, str);
                                    o0000O0o.O00000o0();
                                } else {
                                    throw new SAXException("Invalid attribute selector in <style> element");
                                }
                            } else {
                                throw new SAXException("Invalid attribute selector in <style> element");
                            }
                        } else if (O000000o(':')) {
                            int i2 = this.O00000Oo;
                            if (O000000o() != null) {
                                if (O000000o('(')) {
                                    O00000o();
                                    if (O000000o() != null) {
                                        O00000o();
                                        if (!O000000o(')')) {
                                            this.O00000Oo = i2 - 1;
                                        }
                                    }
                                }
                                String substring = this.f11900O000000o.substring(i2, this.O00000Oo);
                                if (o0000OOo.O00000o == null) {
                                    o0000OOo.O00000o = new ArrayList();
                                }
                                o0000OOo.O00000o.add(substring);
                                o0000O0o.O00000o0();
                            }
                        }
                    }
                }
                if (o0000OOo == null) {
                    if (o0000O0o.f11863O000000o == null) {
                        o0000O0o.f11863O000000o = new ArrayList();
                    }
                    o0000O0o.f11863O000000o.add(o0000OOo);
                    return true;
                }
                this.O00000Oo = i;
                return false;
            }
            combinator = null;
            if (!O000000o('*')) {
            }
            while (true) {
                if (O00000o0()) {
                }
            }
            if (o0000OOo == null) {
            }
        }

        public final String O00000Oo() {
            if (O00000o0()) {
                return null;
            }
            int i = this.O00000Oo;
            int i2 = this.O00000Oo;
            int charAt = this.f11900O000000o.charAt(this.O00000Oo);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33) {
                if (charAt == 10 || charAt == 13) {
                    break;
                }
                if (!O000000o(charAt)) {
                    i2 = this.O00000Oo + 1;
                }
                charAt = O0000Ooo();
            }
            if (this.O00000Oo > i) {
                return this.f11900O000000o.substring(i, i2);
            }
            this.O00000Oo = i;
            return null;
        }

        public final String O000000o() {
            int i;
            if (O00000o0()) {
                i = this.O00000Oo;
            } else {
                int i2 = this.O00000Oo;
                int i3 = this.O00000Oo;
                int charAt = this.f11900O000000o.charAt(this.O00000Oo);
                if (charAt == 45) {
                    charAt = O0000Ooo();
                }
                if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                    int O0000Ooo = O0000Ooo();
                    while (true) {
                        if ((O0000Ooo < 65 || O0000Ooo > 90) && ((O0000Ooo < 97 || O0000Ooo > 122) && !((O0000Ooo >= 48 && O0000Ooo <= 57) || O0000Ooo == 45 || O0000Ooo == 95))) {
                            break;
                        }
                        O0000Ooo = O0000Ooo();
                    }
                    i3 = this.O00000Oo;
                }
                this.O00000Oo = i2;
                i = i3;
            }
            if (i == this.O00000Oo) {
                return null;
            }
            String substring = this.f11900O000000o.substring(this.O00000Oo, i);
            this.O00000Oo = i;
            return substring;
        }
    }

    static boolean O000000o(List<MediaType> list, MediaType mediaType) {
        for (MediaType next : list) {
            if (next == MediaType.all) {
                return true;
            }
            if (next == mediaType) {
                return true;
            }
        }
        return false;
    }

    static List<MediaType> O000000o(O00000Oo o00000Oo) throws SAXException {
        ArrayList arrayList = new ArrayList();
        while (!o00000Oo.O00000o0()) {
            try {
                arrayList.add(MediaType.valueOf(o00000Oo.O00000Oo(',')));
                if (!o00000Oo.O00000oO()) {
                    break;
                }
            } catch (IllegalArgumentException unused) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private static void O00000o0(O00000Oo o00000Oo) {
        int i = 0;
        while (!o00000Oo.O00000o0()) {
            int intValue = o00000Oo.O0000Oo0().intValue();
            if (intValue != 59 || i != 0) {
                if (intValue == 123) {
                    i++;
                } else if (intValue == 125 && i > 0 && i - 1 == 0) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final O00000o O00000Oo(O00000Oo o00000Oo) throws SAXException {
        O00000o o00000o = new O00000o();
        while (!o00000Oo.O00000o0()) {
            if (!o00000Oo.O000000o("<!--") && !o00000Oo.O000000o("-->")) {
                if (o00000Oo.O000000o('@')) {
                    String O000000o2 = o00000Oo.O000000o();
                    o00000Oo.O00000o();
                    if (O000000o2 != null) {
                        if (this.O00000Oo || !O000000o2.equals("media")) {
                            gsy.O000000o(5, "AndroidSVG CSSParser", String.format("Ignoring @%s rule", O000000o2));
                            O00000o0(o00000Oo);
                        } else {
                            List<MediaType> O000000o3 = O000000o(o00000Oo);
                            if (o00000Oo.O000000o('{')) {
                                o00000Oo.O00000o();
                                if (O000000o(O000000o3, this.f11857O000000o)) {
                                    this.O00000Oo = true;
                                    o00000o.O000000o(O00000Oo(o00000Oo));
                                    this.O00000Oo = false;
                                } else {
                                    O00000Oo(o00000Oo);
                                }
                                if (!o00000Oo.O000000o('}')) {
                                    throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                                }
                            } else {
                                throw new SAXException("Invalid @media rule: missing rule set");
                            }
                        }
                        o00000Oo.O00000o();
                    } else {
                        throw new SAXException("Invalid '@' rule in <style> element");
                    }
                } else if (!O000000o(o00000o, o00000Oo)) {
                    break;
                }
            }
        }
        return o00000o;
    }

    private static SVG.Style O00000o(O00000Oo o00000Oo) throws SAXException {
        SVG.Style style = new SVG.Style();
        do {
            String O000000o2 = o00000Oo.O000000o();
            o00000Oo.O00000o();
            if (!o00000Oo.O000000o(':')) {
                break;
            }
            o00000Oo.O00000o();
            String O00000Oo2 = o00000Oo.O00000Oo();
            if (O00000Oo2 == null) {
                break;
            }
            o00000Oo.O00000o();
            if (o00000Oo.O000000o('!')) {
                o00000Oo.O00000o();
                if (o00000Oo.O000000o("important")) {
                    o00000Oo.O00000o();
                } else {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
            }
            o00000Oo.O000000o(';');
            SVGParser.O000000o(style, O000000o2, O00000Oo2);
            o00000Oo.O00000o();
            if (o00000Oo.O000000o('}')) {
                return style;
            }
        } while (!o00000Oo.O00000o0());
        throw new SAXException("Malformed rule set in <style> element");
    }

    protected static List<String> O000000o(String str) throws SAXException {
        O00000Oo o00000Oo = new O00000Oo(str);
        ArrayList arrayList = null;
        while (!o00000Oo.O00000o0()) {
            String O000000o2 = o00000Oo.O000000o();
            if (O000000o2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(O000000o2);
                o00000Oo.O00000o();
            } else {
                throw new SAXException("Invalid value for \"class\" attribute: ".concat(String.valueOf(str)));
            }
        }
        return arrayList;
    }

    public static boolean O000000o(O0000O0o o0000O0o, SVG.O00O0o0 o00O0o0) {
        ArrayList arrayList = new ArrayList();
        for (SVG.O00O0Oo0 o00O0Oo0 = o00O0o0.O0000oo0; o00O0Oo0 != null; o00O0Oo0 = ((SVG.O00OO0O) o00O0Oo0).O0000oo0) {
            arrayList.add(0, o00O0Oo0);
        }
        int size = arrayList.size() - 1;
        if (o0000O0o.O000000o() == 1) {
            return O000000o(o0000O0o.O000000o(0), arrayList, size, o00O0o0);
        }
        return O000000o(o0000O0o, o0000O0o.O000000o() - 1, arrayList, size, o00O0o0);
    }

    private static boolean O000000o(O0000O0o o0000O0o, int i, List<SVG.O00O0Oo0> list, int i2, SVG.O00O0o0 o00O0o0) {
        while (true) {
            O0000OOo O000000o2 = o0000O0o.O000000o(i);
            if (!O000000o(O000000o2, list, i2, o00O0o0)) {
                return false;
            }
            if (O000000o2.f11864O000000o == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 >= 0) {
                    if (O000000o(o0000O0o, i - 1, list, i2)) {
                        return true;
                    }
                    i2--;
                }
                return false;
            } else if (O000000o2.f11864O000000o == Combinator.CHILD) {
                return O000000o(o0000O0o, i - 1, list, i2);
            } else {
                int O000000o3 = O000000o(list, i2, o00O0o0);
                if (O000000o3 <= 0) {
                    return false;
                }
                o00O0o0 = (SVG.O00O0o0) o00O0o0.O0000oo0.O000000o().get(O000000o3 - 1);
                i--;
            }
        }
    }

    private static boolean O000000o(O0000O0o o0000O0o, int i, List<SVG.O00O0Oo0> list, int i2) {
        while (true) {
            O0000OOo O000000o2 = o0000O0o.O000000o(i);
            SVG.O00O0o0 o00O0o0 = (SVG.O00O0o0) list.get(i2);
            if (!O000000o(O000000o2, list, i2, o00O0o0)) {
                return false;
            }
            if (O000000o2.f11864O000000o == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 > 0) {
                    i2--;
                    if (O000000o(o0000O0o, i - 1, list, i2)) {
                        return true;
                    }
                }
                return false;
            } else if (O000000o2.f11864O000000o == Combinator.CHILD) {
                i--;
                i2--;
            } else {
                int O000000o3 = O000000o(list, i2, o00O0o0);
                if (O000000o3 <= 0) {
                    return false;
                }
                return O000000o(o0000O0o, i - 1, list, i2, (SVG.O00O0o0) o00O0o0.O0000oo0.O000000o().get(O000000o3 - 1));
            }
        }
    }

    private static int O000000o(List<SVG.O00O0Oo0> list, int i, SVG.O00O0o0 o00O0o0) {
        if (i < 0 || list.get(i) != o00O0o0.O0000oo0) {
            return -1;
        }
        int i2 = 0;
        for (SVG.O00OO0O o00oo0o : o00O0o0.O0000oo0.O000000o()) {
            if (o00oo0o == o00O0o0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0080  */
    private static boolean O000000o(O0000OOo o0000OOo, List<SVG.O00O0Oo0> list, int i, SVG.O00O0o0 o00O0o0) {
        if (o0000OOo.O00000Oo != null) {
            if (o0000OOo.O00000Oo.equalsIgnoreCase("G")) {
                if (!(o00O0o0 instanceof SVG.O000O0OO)) {
                    return false;
                }
            } else if (!o0000OOo.O00000Oo.equals(o00O0o0.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        if (o0000OOo.O00000o0 != null) {
            for (O000000o next : o0000OOo.O00000o0) {
                if ("id".equals(next.f11860O000000o)) {
                    if (!next.O00000o0.equals(o00O0o0.O0000o0o)) {
                        return false;
                    }
                } else if (!"class".equals(next.f11860O000000o) || o00O0o0.O0000oOO == null || !o00O0o0.O0000oOO.contains(next.O00000o0)) {
                    return false;
                }
            }
        }
        if (o0000OOo.O00000o == null) {
            return true;
        }
        for (String equals : o0000OOo.O00000o) {
            if (!equals.equals("first-child") || O000000o(list, i, o00O0o0) != 0) {
                return false;
            }
            while (r5.hasNext()) {
            }
        }
        return true;
    }

    private static boolean O000000o(O00000o o00000o, O00000Oo o00000Oo) throws SAXException {
        ArrayList<O0000O0o> arrayList;
        if (o00000Oo.O00000o0()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>(1);
            O0000O0o o0000O0o = new O0000O0o();
            while (!o00000Oo.O00000o0() && o00000Oo.O000000o(o0000O0o)) {
                if (o00000Oo.O00000oO()) {
                    arrayList.add(o0000O0o);
                    o0000O0o = new O0000O0o();
                }
            }
            if (!o0000O0o.O00000Oo()) {
                arrayList.add(o0000O0o);
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        if (o00000Oo.O000000o('{')) {
            o00000Oo.O00000o();
            SVG.Style O00000o2 = O00000o(o00000Oo);
            o00000Oo.O00000o();
            for (O0000O0o o00000o0 : arrayList) {
                o00000o.O000000o(new O00000o0(o00000o0, O00000o2));
            }
            return true;
        }
        throw new SAXException("Malformed rule block in <style> element: missing '{'");
    }
}
