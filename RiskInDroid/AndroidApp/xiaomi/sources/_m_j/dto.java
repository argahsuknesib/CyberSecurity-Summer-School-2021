package _m_j;

import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.AbstractConfigValue;
import com.typesafe.config.impl.ConfigBoolean;
import com.typesafe.config.impl.ConfigNull;
import com.typesafe.config.impl.ConfigNumber;
import com.typesafe.config.impl.ConfigString;
import com.typesafe.config.impl.ResolveStatus;
import com.typesafe.config.impl.TokenType;
import java.util.List;

public final class dto {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dtn f14930O000000o = dtn.O000000o(TokenType.START, "start of file");
    public static final dtn O00000Oo = dtn.O000000o(TokenType.END, "end of file");
    public static final dtn O00000o = dtn.O000000o(TokenType.EQUALS, "'='");
    public static final dtn O00000o0 = dtn.O000000o(TokenType.COMMA, "','");
    public static final dtn O00000oO = dtn.O000000o(TokenType.COLON, "':'");
    public static final dtn O00000oo = dtn.O000000o(TokenType.OPEN_CURLY, "'{'");
    public static final dtn O0000O0o = dtn.O000000o(TokenType.CLOSE_CURLY, "'}'");
    public static final dtn O0000OOo = dtn.O000000o(TokenType.OPEN_SQUARE, "'['");
    public static final dtn O0000Oo = dtn.O000000o(TokenType.PLUS_EQUALS, "'+='");
    public static final dtn O0000Oo0 = dtn.O000000o(TokenType.CLOSE_SQUARE, "']'");

    static class O0000OOo extends dtn {

        /* renamed from: O000000o  reason: collision with root package name */
        final AbstractConfigValue f14935O000000o;

        O0000OOo(AbstractConfigValue abstractConfigValue) {
            super(TokenType.VALUE, abstractConfigValue.origin);
            this.f14935O000000o = abstractConfigValue;
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O0000OOo;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) && ((O0000OOo) obj).f14935O000000o.equals(this.f14935O000000o);
        }

        public final int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f14935O000000o.hashCode();
        }

        public final String toString() {
            if (this.f14935O000000o.O0000O0o() == ResolveStatus.RESOLVED) {
                return "'" + this.f14935O000000o.O00000o() + "' (" + this.f14935O000000o.O00000o0().name() + ")";
            }
            return "'<unresolved value>' (" + this.f14935O000000o.O00000o0().name() + ")";
        }
    }

    static class O00000Oo extends dtn {
        O00000Oo(dsi dsi) {
            super(TokenType.NEWLINE, dsi);
        }

        public final String toString() {
            return "'\\n'@" + O00000Oo();
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O00000Oo;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) && ((O00000Oo) obj).O00000Oo() == O00000Oo();
        }

        public final int hashCode() {
            return ((super.hashCode() + 41) * 41) + O00000Oo();
        }
    }

    static class O0000O0o extends dtn {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f14934O000000o;

        O0000O0o(dsi dsi, String str) {
            super(TokenType.UNQUOTED_TEXT, dsi);
            this.f14934O000000o = str;
        }

        public final String toString() {
            return "'" + this.f14934O000000o + "'";
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O0000O0o;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) && ((O0000O0o) obj).f14934O000000o.equals(this.f14934O000000o);
        }

        public final int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.f14934O000000o.hashCode();
        }
    }

    static class O00000o0 extends dtn {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f14933O000000o;
        final boolean O00000Oo;
        private final String O00000o;
        final Throwable O00000o0;

        O00000o0(dsi dsi, String str, String str2, boolean z, Throwable th) {
            super(TokenType.PROBLEM, dsi);
            this.O00000o = str;
            this.f14933O000000o = str2;
            this.O00000Oo = z;
            this.O00000o0 = th;
        }

        public final String toString() {
            return '\'' + this.O00000o + '\'' + " (" + this.f14933O000000o + ")";
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O00000o0;
        }

        public final boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            return o00000o0.O00000o.equals(this.O00000o) && o00000o0.f14933O000000o.equals(this.f14933O000000o) && o00000o0.O00000Oo == this.O00000Oo && dst.O000000o(o00000o0.O00000o0, this.O00000o0);
        }

        public final int hashCode() {
            int hashCode = (((((((super.hashCode() + 41) * 41) + this.O00000o.hashCode()) * 41) + this.f14933O000000o.hashCode()) * 41) + Boolean.valueOf(this.O00000Oo).hashCode()) * 41;
            Throwable th = this.O00000o0;
            return th != null ? (hashCode + th.hashCode()) * 41 : hashCode;
        }
    }

    static class O000000o extends dtn {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f14931O000000o;

        O000000o(dsi dsi, String str) {
            super(TokenType.COMMENT, dsi);
            this.f14931O000000o = str;
        }

        public final String toString() {
            return "'#" + this.f14931O000000o + "' (COMMENT)";
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O000000o;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) && ((O000000o) obj).f14931O000000o.equals(this.f14931O000000o);
        }

        public final int hashCode() {
            return (((super.hashCode() + 41) * 41) + this.f14931O000000o.hashCode()) * 41;
        }
    }

    static class O00000o extends dtn {

        /* renamed from: O000000o  reason: collision with root package name */
        final boolean f14932O000000o;
        final List<dtn> O00000Oo;

        O00000o(dsi dsi, boolean z, List<dtn> list) {
            super(TokenType.SUBSTITUTION, dsi);
            this.f14932O000000o = z;
            this.O00000Oo = list;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            for (dtn dtn : this.O00000Oo) {
                sb.append(dtn.toString());
            }
            return "'${" + sb.toString() + "}'";
        }

        /* access modifiers changed from: protected */
        public final boolean O000000o(Object obj) {
            return obj instanceof O00000o;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) && ((O00000o) obj).O00000Oo.equals(this.O00000Oo);
        }

        public final int hashCode() {
            return ((super.hashCode() + 41) * 41) + this.O00000Oo.hashCode();
        }
    }

    public static boolean O000000o(dtn dtn) {
        return dtn instanceof O0000OOo;
    }

    static AbstractConfigValue O00000Oo(dtn dtn) {
        if (dtn instanceof O0000OOo) {
            return ((O0000OOo) dtn).f14935O000000o;
        }
        throw new ConfigException.BugOrBroken("tried to get value of non-value token ".concat(String.valueOf(dtn)));
    }

    static boolean O00000o0(dtn dtn) {
        return dtn instanceof O00000Oo;
    }

    static boolean O00000o(dtn dtn) {
        return dtn instanceof O00000o0;
    }

    static String O00000oO(dtn dtn) {
        if (dtn instanceof O00000o0) {
            return ((O00000o0) dtn).f14933O000000o;
        }
        throw new ConfigException.BugOrBroken("tried to get problem message from ".concat(String.valueOf(dtn)));
    }

    static boolean O00000oo(dtn dtn) {
        if (dtn instanceof O00000o0) {
            return ((O00000o0) dtn).O00000Oo;
        }
        throw new ConfigException.BugOrBroken("tried to get problem suggestQuotes from ".concat(String.valueOf(dtn)));
    }

    static Throwable O0000O0o(dtn dtn) {
        if (dtn instanceof O00000o0) {
            return ((O00000o0) dtn).O00000o0;
        }
        throw new ConfigException.BugOrBroken("tried to get problem cause from ".concat(String.valueOf(dtn)));
    }

    static boolean O0000OOo(dtn dtn) {
        return dtn instanceof O000000o;
    }

    static String O0000Oo0(dtn dtn) {
        if (dtn instanceof O000000o) {
            return ((O000000o) dtn).f14931O000000o;
        }
        throw new ConfigException.BugOrBroken("tried to get comment text from ".concat(String.valueOf(dtn)));
    }

    public static boolean O0000Oo(dtn dtn) {
        return dtn instanceof O0000O0o;
    }

    static String O0000OoO(dtn dtn) {
        if (dtn instanceof O0000O0o) {
            return ((O0000O0o) dtn).f14934O000000o;
        }
        throw new ConfigException.BugOrBroken("tried to get unquoted text from ".concat(String.valueOf(dtn)));
    }

    public static boolean O0000Ooo(dtn dtn) {
        return dtn instanceof O00000o;
    }

    static List<dtn> O0000o00(dtn dtn) {
        if (dtn instanceof O00000o) {
            return ((O00000o) dtn).O00000Oo;
        }
        throw new ConfigException.BugOrBroken("tried to get substitution from ".concat(String.valueOf(dtn)));
    }

    static boolean O0000o0(dtn dtn) {
        if (dtn instanceof O00000o) {
            return ((O00000o) dtn).f14932O000000o;
        }
        throw new ConfigException.BugOrBroken("tried to get substitution optionality from ".concat(String.valueOf(dtn)));
    }

    public static dtn O000000o(dsi dsi) {
        return new O00000Oo(dsi);
    }

    public static dtn O000000o(dsi dsi, String str, String str2, boolean z, Throwable th) {
        return new O00000o0(dsi, str, str2, z, th);
    }

    public static dtn O000000o(dsi dsi, String str) {
        return new O000000o(dsi, str);
    }

    public static dtn O00000Oo(dsi dsi, String str) {
        return new O0000O0o(dsi, str);
    }

    public static dtn O000000o(dsi dsi, boolean z, List<dtn> list) {
        return new O00000o(dsi, z, list);
    }

    static dtn O000000o(AbstractConfigValue abstractConfigValue) {
        return new O0000OOo(abstractConfigValue);
    }

    public static dtn O00000o0(dsi dsi, String str) {
        return O000000o(new ConfigString(dsi, str));
    }

    public static dtn O000000o(dsi dsi, double d, String str) {
        return O000000o(ConfigNumber.O000000o(dsi, d, str));
    }

    public static dtn O000000o(dsi dsi, long j, String str) {
        return O000000o(ConfigNumber.O000000o(dsi, j, str));
    }

    public static dtn O00000Oo(dsi dsi) {
        return O000000o(new ConfigNull(dsi));
    }

    public static dtn O000000o(dsi dsi, boolean z) {
        return O000000o(new ConfigBoolean(dsi, z));
    }

    static boolean O000000o(dtn dtn, ConfigValueType configValueType) {
        return (dtn instanceof O0000OOo) && O00000Oo(dtn).O00000o0() == configValueType;
    }
}
