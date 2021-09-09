package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.SimpleConfigList;
import com.typesafe.config.impl.SimpleConfigObject;
import com.typesafe.config.impl.Tokenizer;
import java.io.File;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

final class dta {

    /* renamed from: O000000o  reason: collision with root package name */
    static dsi f14912O000000o = dtj.O000000o("path parameter");

    static AbstractConfigValue O000000o(Iterator<dtn> it, dsi dsi, dsj dsj, dsa dsa) {
        AbstractConfigValue abstractConfigValue;
        O00000Oo o00000Oo = new O00000Oo(dsj.f14891O000000o, dsi, it, dtl.O00000Oo(dsj.O00000o), dsa);
        O00000o0 O000000o2 = o00000Oo.O000000o();
        if (O000000o2.f14915O000000o == dto.f14930O000000o) {
            O00000o0 O000000o3 = o00000Oo.O000000o();
            if (O000000o3.f14915O000000o == dto.O00000oo || O000000o3.f14915O000000o == dto.O0000OOo) {
                abstractConfigValue = o00000Oo.O00000Oo(O000000o3);
            } else if (o00000Oo.f14914O000000o != ConfigSyntax.JSON) {
                o00000Oo.O000000o(O000000o3);
                abstractConfigValue = o00000Oo.O000000o(false);
            } else if (O000000o3.f14915O000000o == dto.O00000Oo) {
                throw o00000Oo.O000000o("Empty document", (Throwable) null);
            } else {
                throw o00000Oo.O000000o("Document must have an object or array at root, unexpected token: ".concat(String.valueOf(O000000o3)), (Throwable) null);
            }
            O00000o0 O000000o4 = o00000Oo.O000000o();
            if (O000000o4.f14915O000000o == dto.O00000Oo) {
                return abstractConfigValue;
            }
            throw o00000Oo.O000000o("Document has trailing tokens after first object or array: ".concat(String.valueOf(O000000o4)), (Throwable) null);
        }
        throw new ConfigException.BugOrBroken("token stream did not begin with START, had ".concat(String.valueOf(O000000o2)));
    }

    static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final dtn f14915O000000o;
        final List<dtn> O00000Oo;

        O00000o0(dtn dtn, List<dtn> list) {
            this.f14915O000000o = dtn;
            this.O00000Oo = list;
            if (dto.O0000OOo(dtn)) {
                throw new ConfigException.BugOrBroken("tried to annotate a comment with a comment");
            }
        }

        O00000o0(dtn dtn) {
            this(dtn, Collections.emptyList());
        }

        /* access modifiers changed from: package-private */
        public final O00000o0 O000000o(List<dtn> list) {
            if (list.isEmpty()) {
                return this;
            }
            if (this.O00000Oo.isEmpty()) {
                return new O00000o0(this.f14915O000000o, list);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            arrayList.addAll(this.O00000Oo);
            return new O00000o0(this.f14915O000000o, arrayList);
        }

        /* access modifiers changed from: package-private */
        public final dtj O000000o(dtj dtj) {
            if (this.O00000Oo.isEmpty()) {
                return dtj;
            }
            ArrayList arrayList = new ArrayList();
            for (dtn O0000Oo0 : this.O00000Oo) {
                arrayList.add(dto.O0000Oo0(O0000Oo0));
            }
            if (dst.O000000o(arrayList, dtj.O00000oO)) {
                return dtj;
            }
            if (dtj.O00000oO == null) {
                return dtj.O000000o((List<String>) arrayList);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + dtj.O00000oO.size());
            arrayList2.addAll(arrayList);
            arrayList2.addAll(dtj.O00000oO);
            return dtj.O000000o((List<String>) arrayList2);
        }

        /* access modifiers changed from: package-private */
        public final dtj O00000Oo(dtj dtj) {
            if (this.O00000Oo.isEmpty()) {
                return dtj;
            }
            ArrayList arrayList = new ArrayList();
            for (dtn O0000Oo0 : this.O00000Oo) {
                arrayList.add(dto.O0000Oo0(O0000Oo0));
            }
            return dtj.O00000Oo(arrayList);
        }

        public final String toString() {
            return this.f14915O000000o.toString();
        }
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final ConfigSyntax f14914O000000o;
        int O00000Oo;
        private int O00000o = 1;
        int O00000o0;
        private final Stack<O00000o0> O00000oO = new Stack<>();
        private final Iterator<dtn> O00000oo;
        private final dsw O0000O0o;
        private final dsa O0000OOo;
        private final LinkedList<dtb> O0000Oo;
        private final dsi O0000Oo0;

        O00000Oo(ConfigSyntax configSyntax, dsi dsi, Iterator<dtn> it, dsw dsw, dsa dsa) {
            this.O00000oo = it;
            this.f14914O000000o = configSyntax;
            this.O0000Oo0 = dsi;
            this.O0000O0o = dsw;
            this.O0000OOo = dsa;
            this.O0000Oo = new LinkedList<>();
            this.O00000Oo = 0;
            this.O00000o0 = 0;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(O00000o0 o00000o0) {
            if (!dto.O0000OOo(o00000o0.f14915O000000o)) {
                this.O00000oO.push(o00000o0);
                return;
            }
            throw new ConfigException.BugOrBroken("comment token should have been stripped before it was available to put back");
        }

        /* access modifiers changed from: package-private */
        public final O00000o0 O000000o() {
            O00000o0 O00000Oo2 = O00000Oo();
            while (dto.O00000o0(O00000Oo2.f14915O000000o)) {
                this.O00000o = O00000Oo2.f14915O000000o.O00000Oo() + 1;
                O00000Oo2 = O00000Oo();
            }
            int O00000Oo3 = O00000Oo2.f14915O000000o.O00000Oo();
            if (O00000Oo3 >= 0) {
                this.O00000o = O00000Oo3;
            }
            return O00000Oo2;
        }

        private AbstractConfigValue O000000o(AbstractConfigValue abstractConfigValue) {
            O00000o0 o00000o0;
            O00000o0 O00000Oo2 = O00000Oo();
            if (O00000Oo2.f14915O000000o == dto.O00000o0) {
                if (O00000Oo2.O00000Oo.isEmpty()) {
                    o00000o0 = O00000Oo2;
                } else {
                    o00000o0 = new O00000o0(O00000Oo2.f14915O000000o);
                }
                O000000o(o00000o0);
                return abstractConfigValue.O00000Oo((dsi) O00000Oo2.O00000Oo(abstractConfigValue.origin));
            }
            O000000o(O00000Oo2);
            return abstractConfigValue;
        }

        private boolean O00000o0() {
            boolean z = false;
            if (this.f14914O000000o == ConfigSyntax.JSON) {
                O00000o0 O000000o2 = O000000o();
                if (O000000o2.f14915O000000o == dto.O00000o0) {
                    return true;
                }
                O000000o(O000000o2);
                return false;
            }
            O00000o0 O00000Oo2 = O00000Oo();
            while (dto.O00000o0(O00000Oo2.f14915O000000o)) {
                this.O00000o = O00000Oo2.f14915O000000o.O00000Oo() + 1;
                O00000Oo2 = O00000Oo();
                z = true;
            }
            if (O00000Oo2.f14915O000000o == dto.O00000o0) {
                return true;
            }
            O000000o(O00000Oo2);
            return z;
        }

        private static dtm O000000o(dtn dtn) {
            return new dtm(dta.O000000o(dto.O0000o00(dtn).iterator(), dtn.O000000o()), dto.O0000o0(dtn));
        }

        private void O00000o() {
            if (this.f14914O000000o != ConfigSyntax.JSON) {
                ArrayList arrayList = null;
                O00000o0 O000000o2 = O000000o();
                while (true) {
                    if (dto.O000000o(O000000o2.f14915O000000o) || dto.O0000Oo(O000000o2.f14915O000000o) || dto.O0000Ooo(O000000o2.f14915O000000o) || O000000o2.f14915O000000o == dto.O00000oo || O000000o2.f14915O000000o == dto.O0000OOo) {
                        AbstractConfigValue O00000Oo2 = O00000Oo(O000000o2);
                        if (O00000Oo2 != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(O00000Oo2);
                            O000000o2 = O00000Oo();
                        } else {
                            throw new ConfigException.BugOrBroken("no value");
                        }
                    } else {
                        O000000o(O000000o2);
                        if (arrayList != null) {
                            O000000o(new O00000o0(dto.O000000o(dsp.O000000o(arrayList))));
                            return;
                        }
                        return;
                    }
                }
            }
        }

        private dtj O00000oO() {
            return ((dtj) this.O0000Oo0).O000000o(this.O00000o);
        }

        /* access modifiers changed from: package-private */
        public final ConfigException O000000o(String str, Throwable th) {
            return new ConfigException.Parse(O00000oO(), str, th);
        }

        private String O000000o(dtb dtb) {
            if (dtb != null) {
                return dtb.O00000o();
            }
            if (this.O0000Oo.isEmpty()) {
                return null;
            }
            return this.O0000Oo.peek().O00000o();
        }

        private dtb O00000oo() {
            if (!this.O0000Oo.isEmpty()) {
                return new dtb(this.O0000Oo.descendingIterator());
            }
            throw new ConfigException.BugOrBroken("Bug in parser; tried to get current path when at root");
        }

        private String O000000o(String str, String str2) {
            return O000000o(null, this.O00000Oo > 0, str, str2);
        }

        private String O000000o(dtb dtb, boolean z, String str, String str2) {
            String str3;
            String O000000o2 = O000000o(dtb);
            if (str.equals(dto.O00000Oo.toString())) {
                if (O000000o2 == null) {
                    return str2;
                }
                str3 = str2 + " (if you intended '" + O000000o2 + "' to be part of a value, instead of a key, try adding double quotes around the whole value";
            } else if (O000000o2 != null) {
                str3 = str2 + " (if you intended " + str + " to be part of the value for '" + O000000o2 + "', try enclosing the value in double quotes";
            } else {
                str3 = str2 + " (if you intended " + str + " to be part of a key or string value, try enclosing the key or value in double quotes";
            }
            if (z) {
                return str3 + ", or you may be able to rename the file .properties rather than .conf)";
            }
            return str3 + ")";
        }

        /* access modifiers changed from: package-private */
        public final AbstractConfigValue O00000Oo(O00000o0 o00000o0) {
            AbstractConfigValue abstractConfigValue;
            int i = this.O00000o0;
            int i2 = this.O00000Oo;
            if (dto.O000000o(o00000o0.f14915O000000o)) {
                abstractConfigValue = dto.O00000Oo(o00000o0.f14915O000000o);
            } else if (dto.O0000Oo(o00000o0.f14915O000000o)) {
                abstractConfigValue = new ConfigString(o00000o0.f14915O000000o.O000000o(), dto.O0000OoO(o00000o0.f14915O000000o));
            } else if (dto.O0000Ooo(o00000o0.f14915O000000o)) {
                abstractConfigValue = new dsu(o00000o0.f14915O000000o.O000000o(), O000000o(o00000o0.f14915O000000o));
            } else if (o00000o0.f14915O000000o == dto.O00000oo) {
                abstractConfigValue = O000000o(true);
            } else if (o00000o0.f14915O000000o == dto.O0000OOo) {
                abstractConfigValue = O0000O0o();
            } else {
                String dtn = o00000o0.f14915O000000o.toString();
                throw O000000o(O000000o(dtn, "Expecting a value but got wrong token: " + o00000o0.f14915O000000o), (Throwable) null);
            }
            AbstractConfigValue O00000Oo2 = abstractConfigValue.O00000Oo((dsi) o00000o0.O000000o(abstractConfigValue.origin));
            if (this.O00000o0 != i) {
                throw new ConfigException.BugOrBroken("Bug in config parser: unbalanced array count");
            } else if (this.O00000Oo == i2) {
                return O00000Oo2;
            } else {
                throw new ConfigException.BugOrBroken("Bug in config parser: unbalanced equals count");
            }
        }

        private static dso O000000o(dtb dtb, AbstractConfigValue abstractConfigValue) {
            ArrayList arrayList = new ArrayList();
            String str = dtb.f14916O000000o;
            dtb dtb2 = dtb.O00000Oo;
            while (str != null) {
                arrayList.add(str);
                if (dtb2 == null) {
                    break;
                }
                str = dtb2.f14916O000000o;
                dtb2 = dtb2.O00000Oo;
            }
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            SimpleConfigObject simpleConfigObject = new SimpleConfigObject(abstractConfigValue.origin.O000000o((List<String>) null), Collections.singletonMap((String) listIterator.previous(), abstractConfigValue));
            while (listIterator.hasPrevious()) {
                simpleConfigObject = new SimpleConfigObject(abstractConfigValue.origin.O000000o((List<String>) null), Collections.singletonMap(listIterator.previous(), simpleConfigObject));
            }
            return simpleConfigObject;
        }

        private dtb O00000o0(O00000o0 o00000o0) {
            if (this.f14914O000000o != ConfigSyntax.JSON) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    if (!dto.O000000o(o00000o0.f14915O000000o) && !dto.O0000Oo(o00000o0.f14915O000000o)) {
                        break;
                    }
                    arrayList.add(o00000o0.f14915O000000o);
                    o00000o0 = O00000Oo();
                }
                if (!arrayList.isEmpty()) {
                    O000000o(o00000o0);
                    return dta.O000000o(arrayList.iterator(), O00000oO());
                }
                throw O000000o(O000000o("expecting a close brace or a field name here, got ".concat(String.valueOf(o00000o0))), (Throwable) null);
            } else if (dto.O000000o(o00000o0.f14915O000000o, ConfigValueType.STRING)) {
                return new dtb((String) dto.O00000Oo(o00000o0.f14915O000000o).O00000o(), null);
            } else {
                throw O000000o(O000000o("Expecting close brace } or a field name here, got ".concat(String.valueOf(o00000o0))), (Throwable) null);
            }
        }

        private static boolean O00000Oo(dtn dtn) {
            return dto.O0000Oo(dtn) && dto.O0000OoO(dtn).equals("include");
        }

        private static boolean O00000o0(dtn dtn) {
            if (!dto.O0000Oo(dtn)) {
                return false;
            }
            String O0000OoO = dto.O0000OoO(dtn);
            for (int i = 0; i < O0000OoO.length(); i++) {
                if (!dst.O000000o(O0000OoO.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        private void O000000o(Map<String, AbstractConfigValue> map) {
            dso dso;
            O00000o0 O000000o2;
            O00000o0 O000000o3;
            O00000o0 O000000o4 = O000000o();
            while (O00000o0(O000000o4.f14915O000000o)) {
                O000000o4 = O000000o();
            }
            if (dto.O0000Oo(O000000o4.f14915O000000o)) {
                String O0000OoO = dto.O0000OoO(O000000o4.f14915O000000o);
                if (O0000OoO.equals("url(") || O0000OoO.equals("file(") || O0000OoO.equals("classpath(")) {
                    do {
                        O000000o2 = O000000o();
                    } while (O00000o0(O000000o2.f14915O000000o));
                    if (dto.O000000o(O000000o2.f14915O000000o, ConfigValueType.STRING)) {
                        String str = (String) dto.O00000Oo(O000000o2.f14915O000000o).O00000o();
                        do {
                            O000000o3 = O000000o();
                        } while (O00000o0(O000000o3.f14915O000000o));
                        if (!dto.O0000Oo(O000000o3.f14915O000000o) || !dto.O0000OoO(O000000o3.f14915O000000o).equals(")")) {
                            throw O000000o("expecting a close parentheses ')' here, not: ".concat(String.valueOf(O000000o3)), (Throwable) null);
                        } else if (O0000OoO.equals("url(")) {
                            try {
                                dso = (dso) this.O0000O0o.O000000o(this.O0000OOo, new URL(str));
                            } catch (MalformedURLException e) {
                                throw O000000o("include url() specifies an invalid URL: ".concat(String.valueOf(str)), e);
                            }
                        } else if (O0000OoO.equals("file(")) {
                            dso = (dso) this.O0000O0o.O000000o(this.O0000OOo, new File(str));
                        } else if (O0000OoO.equals("classpath(")) {
                            dso = (dso) this.O0000O0o.O00000Oo(this.O0000OOo, str);
                        } else {
                            throw new ConfigException.BugOrBroken("should not be reached");
                        }
                    } else {
                        throw O000000o("expecting a quoted string inside file(), classpath(), or url(), rather than: ".concat(String.valueOf(O000000o2)), (Throwable) null);
                    }
                } else {
                    throw O000000o("expecting include parameter to be quoted filename, file(), classpath(), or url(). No spaces are allowed before the open paren. Not expecting: ".concat(String.valueOf(O000000o4)), (Throwable) null);
                }
            } else if (dto.O000000o(O000000o4.f14915O000000o, ConfigValueType.STRING)) {
                dso = (dso) this.O0000O0o.O000000o(this.O0000OOo, (String) dto.O00000Oo(O000000o4.f14915O000000o).O00000o());
            } else {
                throw O000000o("include keyword is not followed by a quoted string, but by: ".concat(String.valueOf(O000000o4)), (Throwable) null);
            }
            if (this.O00000o0 <= 0 || dso.O0000O0o() == ResolveStatus.RESOLVED) {
                if (!this.O0000Oo.isEmpty()) {
                    dso = dso.O00000Oo(O00000oo());
                }
                for (String str2 : dso.keySet()) {
                    AbstractConfigValue O000000o5 = dso.get((Object) str2);
                    AbstractConfigValue abstractConfigValue = map.get(str2);
                    if (abstractConfigValue != null) {
                        map.put(str2, O000000o5.O00000o0(abstractConfigValue));
                    } else {
                        map.put(str2, O000000o5);
                    }
                }
                return;
            }
            throw O000000o("Due to current limitations of the config parser, when an include statement is nested inside a list value, ${} substitutions inside the included file cannot be resolved correctly. Either move the include outside of the list value or remove the ${} statements from the included file.", (Throwable) null);
        }

        private boolean O00000o(dtn dtn) {
            return this.f14914O000000o == ConfigSyntax.JSON ? dtn == dto.O00000oO : dtn == dto.O00000oO || dtn == dto.O00000o || dtn == dto.O0000Oo;
        }

        /* access modifiers changed from: package-private */
        public final dso O000000o(boolean z) {
            O00000o0 o00000o0;
            HashMap hashMap = new HashMap();
            dtj O00000oO2 = O00000oO();
            dtb dtb = null;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                O00000o0 O000000o2 = O000000o();
                if (O000000o2.f14915O000000o != dto.O0000O0o) {
                    if (O000000o2.f14915O000000o == dto.O00000Oo && !z) {
                        O000000o(O000000o2);
                        break;
                    }
                    if (this.f14914O000000o == ConfigSyntax.JSON || !O00000Oo(O000000o2.f14915O000000o)) {
                        dtb O00000o02 = O00000o0(O000000o2);
                        O00000o0 O000000o3 = O000000o();
                        this.O0000Oo.push(O00000o02);
                        if (O000000o3.f14915O000000o == dto.O0000Oo) {
                            int i = this.O00000o0;
                            if (i <= 0) {
                                this.O00000o0 = i + 1;
                            } else {
                                throw O000000o("Due to current limitations of the config parser, += does not work nested inside a list. += expands to a ${} substitution and the path in ${} cannot currently refer to list elements. You might be able to move the += outside of the list and then refer to it from inside the list with ${}.", (Throwable) null);
                            }
                        }
                        if (this.f14914O000000o == ConfigSyntax.CONF && O000000o3.f14915O000000o == dto.O00000oo) {
                            o00000o0 = O000000o3;
                            z3 = false;
                        } else if (O00000o(O000000o3.f14915O000000o)) {
                            if (O000000o3.f14915O000000o == dto.O00000o) {
                                this.O00000Oo++;
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            O00000o();
                            o00000o0 = O000000o().O000000o(O000000o3.O00000Oo);
                        } else {
                            throw O000000o(O000000o(O000000o3.toString(), "Key '" + O00000o02.O00000o() + "' may not be followed by token: " + O000000o3), (Throwable) null);
                        }
                        AbstractConfigValue O00000Oo2 = O00000Oo(o00000o0.O000000o(O000000o2.O00000Oo));
                        if (O000000o3.f14915O000000o == dto.O0000Oo) {
                            this.O00000o0--;
                            ArrayList arrayList = new ArrayList(2);
                            dsu dsu = new dsu(O00000Oo2.origin, new dtm(O00000oo(), true));
                            SimpleConfigList simpleConfigList = new SimpleConfigList(O00000Oo2.origin, Collections.singletonList(O00000Oo2));
                            arrayList.add(dsu);
                            arrayList.add(simpleConfigList);
                            O00000Oo2 = dsp.O000000o(arrayList);
                        }
                        AbstractConfigValue O000000o4 = O000000o(O00000Oo2);
                        dtb pop = this.O0000Oo.pop();
                        if (z3) {
                            this.O00000Oo--;
                        }
                        String str = O00000o02.f14916O000000o;
                        dtb dtb2 = O00000o02.O00000Oo;
                        if (dtb2 == null) {
                            AbstractConfigValue abstractConfigValue = (AbstractConfigValue) hashMap.get(str);
                            if (abstractConfigValue != null) {
                                if (this.f14914O000000o != ConfigSyntax.JSON) {
                                    O000000o4 = O000000o4.O00000o0(abstractConfigValue);
                                } else {
                                    throw O000000o("JSON does not allow duplicate fields: '" + str + "' was already seen at " + abstractConfigValue.origin.O000000o(), (Throwable) null);
                                }
                            }
                            hashMap.put(str, O000000o4);
                        } else if (this.f14914O000000o != ConfigSyntax.JSON) {
                            dso O000000o5 = O000000o(dtb2, O000000o4);
                            AbstractConfigValue abstractConfigValue2 = (AbstractConfigValue) hashMap.get(str);
                            if (abstractConfigValue2 != null) {
                                O000000o5 = O000000o5.O00000o0((dsg) abstractConfigValue2);
                            }
                            hashMap.put(str, O000000o5);
                        } else {
                            throw new ConfigException.BugOrBroken("somehow got multi-element path in JSON mode");
                        }
                        dtb = pop;
                    } else {
                        O000000o(hashMap);
                    }
                    if (O00000o0()) {
                        z2 = true;
                    } else {
                        O00000o0 O000000o6 = O000000o();
                        if (O000000o6.f14915O000000o == dto.O0000O0o) {
                            if (z) {
                                O00000oO2 = O000000o6.O00000Oo(O00000oO2);
                            } else {
                                throw O000000o(O000000o(dtb, z3, O000000o6.toString(), "unbalanced close brace '}' with no open brace"), (Throwable) null);
                            }
                        } else if (z) {
                            throw O000000o(O000000o(dtb, z3, O000000o6.toString(), "Expecting close brace } or a comma, got ".concat(String.valueOf(O000000o6))), (Throwable) null);
                        } else if (O000000o6.f14915O000000o == dto.O00000Oo) {
                            O000000o(O000000o6);
                        } else {
                            throw O000000o(O000000o(dtb, z3, O000000o6.toString(), "Expecting end of input or a comma, got ".concat(String.valueOf(O000000o6))), (Throwable) null);
                        }
                    }
                } else if (this.f14914O000000o == ConfigSyntax.JSON && z2) {
                    throw O000000o(O000000o(O000000o2.toString(), "expecting a field name after a comma, got a close brace } instead"), (Throwable) null);
                } else if (z) {
                    O00000oO2 = O000000o2.O00000Oo(O00000oO2);
                } else {
                    throw O000000o(O000000o(O000000o2.toString(), "unbalanced close brace '}' with no open brace"), (Throwable) null);
                }
            }
            return new SimpleConfigObject(O00000oO2, hashMap);
        }

        private SimpleConfigList O0000O0o() {
            this.O00000o0++;
            dtj O00000oO2 = O00000oO();
            ArrayList arrayList = new ArrayList();
            O00000o();
            O00000o0 O000000o2 = O000000o();
            if (O000000o2.f14915O000000o == dto.O0000Oo0) {
                this.O00000o0--;
                return new SimpleConfigList(O000000o2.O00000Oo(O00000oO2), Collections.emptyList());
            } else if (dto.O000000o(O000000o2.f14915O000000o) || O000000o2.f14915O000000o == dto.O00000oo || O000000o2.f14915O000000o == dto.O0000OOo) {
                arrayList.add(O000000o(O00000Oo(O000000o2)));
                while (O00000o0()) {
                    O00000o();
                    O00000o0 O000000o3 = O000000o();
                    if (dto.O000000o(O000000o3.f14915O000000o) || O000000o3.f14915O000000o == dto.O00000oo || O000000o3.f14915O000000o == dto.O0000OOo) {
                        arrayList.add(O000000o(O00000Oo(O000000o3)));
                    } else if (this.f14914O000000o == ConfigSyntax.JSON || O000000o3.f14915O000000o != dto.O0000Oo0) {
                        throw O000000o(O000000o("List should have had new element after a comma, instead had token: " + O000000o3 + " (if you want the comma or " + O000000o3 + " to be part of a string value, then double-quote it)"), (Throwable) null);
                    } else {
                        O000000o(O000000o3);
                    }
                }
                O00000o0 O000000o4 = O000000o();
                if (O000000o4.f14915O000000o == dto.O0000Oo0) {
                    this.O00000o0--;
                    return new SimpleConfigList(O000000o4.O00000Oo(O00000oO2), arrayList);
                }
                throw O000000o(O000000o("List should have ended with ] or had a comma, instead had token: " + O000000o4 + " (if you want " + O000000o4 + " to be part of a string value, then double-quote it)"), (Throwable) null);
            } else {
                throw O000000o(O000000o("List should have ] or a first element after the open [, instead had token: " + O000000o2 + " (if you want " + O000000o2 + " to be part of a string value, then double-quote it)"), (Throwable) null);
            }
        }

        private O00000o0 O00000Oo() {
            O00000o0 o00000o0;
            String str;
            boolean z = true;
            if (this.O00000oO.isEmpty()) {
                dtn next = this.O00000oo.next();
                if (dto.O0000OOo(next)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    dtn dtn = null;
                    while (true) {
                        if (!dto.O00000o0(next)) {
                            if (!dto.O0000OOo(next)) {
                                break;
                            }
                            arrayList2.add(next);
                        } else {
                            if (dtn != null && dto.O00000o0(dtn)) {
                                arrayList2.clear();
                            }
                            arrayList.add(next);
                        }
                        dtn = next;
                        next = this.O00000oo.next();
                    }
                    if (!((dto.O00000o0(next) || next == dto.f14930O000000o || next == dto.O0000O0o || next == dto.O0000Oo0 || next == dto.O00000Oo) ? false : true)) {
                        arrayList2.clear();
                    }
                    this.O00000oO.push(new O00000o0(next, arrayList2));
                    ListIterator listIterator = arrayList.listIterator(arrayList.size());
                    while (listIterator.hasPrevious()) {
                        this.O00000oO.push(new O00000o0((dtn) listIterator.previous()));
                    }
                    o00000o0 = this.O00000oO.pop();
                } else {
                    o00000o0 = new O00000o0(next);
                }
            } else {
                o00000o0 = this.O00000oO.pop();
            }
            dtn dtn2 = o00000o0.f14915O000000o;
            if (dto.O00000o0(dtn2) || dtn2 == dto.f14930O000000o || dtn2 == dto.O00000oo || dtn2 == dto.O0000OOo || dtn2 == dto.O00000Oo) {
                z = false;
            }
            if (z) {
                if (this.O00000oO.isEmpty()) {
                    dtn next2 = this.O00000oo.next();
                    if (!dto.O0000OOo(next2)) {
                        this.O00000oO.push(new O00000o0(next2));
                    } else if (o00000o0.O00000Oo.isEmpty()) {
                        o00000o0 = new O00000o0(o00000o0.f14915O000000o, Collections.singletonList(next2));
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.addAll(o00000o0.O00000Oo);
                        arrayList3.add(next2);
                        o00000o0 = new O00000o0(o00000o0.f14915O000000o, arrayList3);
                    }
                } else if (dto.O0000OOo(this.O00000oO.peek().f14915O000000o)) {
                    throw new ConfigException.BugOrBroken("comment token should not have been in buffer: " + this.O00000oO);
                }
            }
            dtn dtn3 = o00000o0.f14915O000000o;
            if (dto.O00000o(dtn3)) {
                dsi O000000o2 = dtn3.O000000o();
                String O00000oO2 = dto.O00000oO(dtn3);
                Throwable O0000O0o2 = dto.O0000O0o(dtn3);
                if (dto.O00000oo(dtn3)) {
                    str = O000000o(dtn3.toString(), O00000oO2);
                } else {
                    str = O000000o(O00000oO2);
                }
                throw new ConfigException.Parse(O000000o2, str, O0000O0o2);
            }
            if (this.f14914O000000o == ConfigSyntax.JSON) {
                if (dto.O0000Oo(dtn3)) {
                    throw O000000o(O000000o("Token not allowed in valid JSON: '" + dto.O0000OoO(dtn3) + "'"), (Throwable) null);
                } else if (dto.O0000Ooo(dtn3)) {
                    throw O000000o(O000000o("Substitutions (${} syntax) not allowed in JSON"), (Throwable) null);
                }
            }
            return o00000o0;
        }

        private String O000000o(String str) {
            String O000000o2 = O000000o((dtb) null);
            if (O000000o2 == null) {
                return str;
            }
            return "in value for key '" + O000000o2 + "': " + str;
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        StringBuilder f14913O000000o;
        boolean O00000Oo = false;

        O000000o(String str) {
            this.f14913O000000o = new StringBuilder(str);
        }

        public final String toString() {
            return "Element(" + this.f14913O000000o.toString() + "," + this.O00000Oo + ")";
        }
    }

    private static void O000000o(List<O000000o> list, boolean z, String str) {
        O000000o o000000o;
        while (true) {
            int indexOf = z ? -1 : str.indexOf(46);
            o000000o = list.get(list.size() - 1);
            if (indexOf < 0) {
                break;
            }
            o000000o.f14913O000000o.append(str.substring(0, indexOf));
            list.add(new O000000o(""));
            str = str.substring(indexOf + 1);
            z = false;
        }
        o000000o.f14913O000000o.append(str);
        if (z && o000000o.f14913O000000o.length() == 0) {
            o000000o.O00000Oo = true;
        }
    }

    public static dtb O000000o(Iterator<dtn> it, dsi dsi) {
        return O000000o(it, dsi, (String) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.dta.O000000o(java.util.List<_m_j.dta$O000000o>, boolean, java.lang.String):void
     arg types: [java.util.ArrayList, int, java.lang.String]
     candidates:
      _m_j.dta.O000000o(java.util.Iterator<_m_j.dtn>, _m_j.dsi, java.lang.String):_m_j.dtb
      _m_j.dta.O000000o(java.util.List<_m_j.dta$O000000o>, boolean, java.lang.String):void */
    private static dtb O000000o(Iterator<dtn> it, dsi dsi, String str) {
        String str2;
        ArrayList<O000000o> arrayList = new ArrayList<>();
        arrayList.add(new O000000o(""));
        if (it.hasNext()) {
            while (it.hasNext()) {
                dtn next = it.next();
                if (dto.O000000o(next, ConfigValueType.STRING)) {
                    O000000o((List<O000000o>) arrayList, true, dto.O00000Oo(next).O0000OoO());
                } else if (next == dto.O00000Oo) {
                    continue;
                } else {
                    if (dto.O000000o(next)) {
                        str2 = dto.O00000Oo(next).O0000OoO();
                    } else if (dto.O0000Oo(next)) {
                        str2 = dto.O0000OoO(next);
                    } else {
                        throw new ConfigException.BadPath(dsi, str, "Token not allowed in path expression: " + next + " (you can double-quote this token if you really want it here)");
                    }
                    O000000o((List<O000000o>) arrayList, false, str2);
                }
            }
            dtc dtc = new dtc();
            for (O000000o o000000o : arrayList) {
                if (o000000o.f14913O000000o.length() != 0 || o000000o.O00000Oo) {
                    dtc.O000000o(o000000o.f14913O000000o.toString());
                } else {
                    throw new ConfigException.BadPath(dsi, str, "path has a leading, trailing, or two adjacent period '.' (use quoted \"\" empty string if you want an empty element)");
                }
            }
            return dtc.O000000o();
        }
        throw new ConfigException.BadPath(dsi, str, "Expecting a field name or path here, but got nothing");
    }

    static dtb O000000o(String str) {
        String str2;
        int i;
        int i2;
        int length = str.length();
        boolean z = true;
        if (length == 0) {
            str2 = str;
        } else {
            int i3 = 0;
            while (i3 < length) {
                char charAt = str.charAt(i3);
                if (charAt != ' ' && charAt != 10) {
                    int codePointAt = str.codePointAt(i3);
                    if (!dst.O000000o(codePointAt)) {
                        break;
                    }
                    i3 += Character.charCount(codePointAt);
                } else {
                    i3++;
                }
            }
            while (length > i3) {
                int i4 = length - 1;
                char charAt2 = str.charAt(i4);
                if (charAt2 != ' ' && charAt2 != 10) {
                    if (Character.isLowSurrogate(charAt2)) {
                        i2 = str.codePointAt(length - 2);
                        i = 2;
                    } else {
                        i2 = str.codePointAt(i4);
                        i = 1;
                    }
                    if (!dst.O000000o(i2)) {
                        break;
                    }
                    length -= i;
                } else {
                    length--;
                }
            }
            str2 = str.substring(i3, length);
        }
        dtb dtb = null;
        if (!str2.isEmpty()) {
            int i5 = 0;
            while (true) {
                if (i5 >= str2.length()) {
                    z = false;
                    break;
                }
                char charAt3 = str2.charAt(i5);
                if (!Character.isLetter(charAt3) && charAt3 != '.') {
                    break;
                }
                i5++;
            }
            if (!z && !str2.startsWith(".") && !str2.endsWith(".") && !str2.contains("..")) {
                dtc dtc = new dtc();
                while (true) {
                    int indexOf = str2.indexOf(46);
                    if (indexOf < 0) {
                        break;
                    }
                    dtc.O000000o(str2.substring(0, indexOf));
                    str2 = str2.substring(indexOf + 1);
                }
                dtc.O000000o(str2);
                dtb = dtc.O000000o();
            }
        }
        if (dtb != null) {
            return dtb;
        }
        StringReader stringReader = new StringReader(str);
        try {
            Iterator<dtn> O000000o2 = Tokenizer.O000000o(f14912O000000o, stringReader, ConfigSyntax.CONF);
            O000000o2.next();
            return O000000o(O000000o2, f14912O000000o, str);
        } finally {
            stringReader.close();
        }
    }
}
