package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Locale;

public class URI implements Serializable, Cloneable, Comparable {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static String f15429O000000o = "UTF-8";
    protected static String O00000Oo = null;
    protected static String O00000o = null;
    protected static String O00000o0 = null;
    protected static final char[] O00000oO = {'/'};
    protected static final BitSet O00000oo;
    protected static final BitSet O0000O0o = new BitSet(256);
    protected static final BitSet O0000OOo = new BitSet(256);
    protected static final BitSet O0000Oo;
    protected static final BitSet O0000Oo0;
    protected static final BitSet O0000OoO;
    protected static final BitSet O0000Ooo;
    protected static final BitSet O0000o;
    protected static final BitSet O0000o0;
    protected static final BitSet O0000o00;
    protected static final BitSet O0000o0O;
    protected static final BitSet O0000o0o;
    protected static final BitSet O0000oO = O0000oO0;
    protected static final BitSet O0000oO0;
    protected static final BitSet O0000oOO;
    protected static final BitSet O0000oOo;
    protected static final BitSet O0000oo;
    protected static final BitSet O0000oo0;
    protected static final BitSet O0000ooO;
    protected static final BitSet O0000ooo;
    protected static final BitSet O000O00o;
    protected static final BitSet O000O0OO;
    protected static final BitSet O000O0Oo;
    protected static final BitSet O000O0o;
    protected static final BitSet O000O0o0;
    protected static final BitSet O000O0oO;
    protected static final BitSet O000O0oo;
    protected static final BitSet O000OO;
    public static final BitSet O000OO00;
    protected static final BitSet O000OO0o;
    protected static final BitSet O000OOOo;
    protected static final BitSet O000OOo;
    protected static final BitSet O000OOo0;
    protected static final BitSet O000OOoO;
    protected static final BitSet O000OOoo;
    protected static final BitSet O000Oo0;
    protected static final BitSet O000Oo00;
    protected static final BitSet O000Oo0O;
    protected static final BitSet O000Oo0o;
    public static final BitSet O000OoO;
    public static final BitSet O000OoO0 = new BitSet(256);
    public static final BitSet O000OoOO;
    public static final BitSet O000OoOo;
    public static final BitSet O000Ooo;
    public static final BitSet O000Ooo0;
    public static final BitSet O000OooO;
    public static final BitSet O000Oooo;
    public static final BitSet O000o0;
    public static final BitSet O000o00;
    public static final BitSet O000o000;
    public static final BitSet O000o00O;
    public static final BitSet O000o00o;
    public static final BitSet O000o0O;
    public static final BitSet O000o0O0;
    public static final BitSet O000o0OO;
    public static final BitSet O000o0Oo;
    public static final BitSet O000o0o;
    public static final BitSet O000o0o0;
    public static final BitSet O00O0Oo;
    protected static final BitSet O00oOoOo = O000O0Oo;
    protected static final BitSet O00oOooO = O0000O0o;
    protected static final BitSet O00oOooo;
    static final long serialVersionUID = 604752400577948726L;
    protected char[] _authority = null;
    protected char[] _fragment = null;
    protected char[] _host = null;
    protected boolean _is_IPv4address;
    protected boolean _is_IPv6reference;
    protected boolean _is_abs_path;
    protected boolean _is_hier_part;
    protected boolean _is_hostname;
    protected boolean _is_net_path;
    protected boolean _is_opaque_part;
    protected boolean _is_reg_name;
    protected boolean _is_rel_path;
    protected boolean _is_server;
    protected char[] _opaque = null;
    protected char[] _path = null;
    protected int _port = -1;
    protected char[] _query = null;
    protected char[] _scheme = null;
    protected char[] _uri = null;
    protected char[] _userinfo = null;
    protected int hash = 0;
    protected String protocolCharset = null;

    protected URI() {
    }

    static {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            String O000000o2 = O000000o.O000000o(locale);
            O00000o0 = O000000o2;
            O00000Oo = O000000o2;
        }
        try {
            O00000o = System.getProperty("file.encoding");
        } catch (SecurityException unused) {
        }
        if (O00000Oo == null) {
            O00000Oo = O00000o;
        }
        BitSet bitSet = new BitSet(256);
        O00000oo = bitSet;
        bitSet.set(37);
        for (int i = 48; i <= 57; i++) {
            O0000O0o.set(i);
        }
        for (int i2 = 97; i2 <= 122; i2++) {
            O0000OOo.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            O0000OOo.set(i3);
        }
        BitSet bitSet2 = new BitSet(256);
        O0000Oo0 = bitSet2;
        bitSet2.or(O0000OOo);
        O0000Oo0.or(O0000O0o);
        BitSet bitSet3 = new BitSet(256);
        O0000Oo = bitSet3;
        bitSet3.or(O0000O0o);
        for (int i4 = 97; i4 <= 102; i4++) {
            O0000Oo.set(i4);
        }
        for (int i5 = 65; i5 <= 70; i5++) {
            O0000Oo.set(i5);
        }
        BitSet bitSet4 = new BitSet(256);
        O0000OoO = bitSet4;
        bitSet4.or(O00000oo);
        O0000OoO.or(O0000Oo);
        BitSet bitSet5 = new BitSet(256);
        O0000Ooo = bitSet5;
        bitSet5.set(45);
        O0000Ooo.set(95);
        O0000Ooo.set(46);
        O0000Ooo.set(33);
        O0000Ooo.set(126);
        O0000Ooo.set(42);
        O0000Ooo.set(39);
        O0000Ooo.set(40);
        O0000Ooo.set(41);
        BitSet bitSet6 = new BitSet(256);
        O0000o00 = bitSet6;
        bitSet6.or(O0000Oo0);
        O0000o00.or(O0000Ooo);
        BitSet bitSet7 = new BitSet(256);
        O0000o0 = bitSet7;
        bitSet7.set(59);
        O0000o0.set(47);
        O0000o0.set(63);
        O0000o0.set(58);
        O0000o0.set(64);
        O0000o0.set(38);
        O0000o0.set(61);
        O0000o0.set(43);
        O0000o0.set(36);
        O0000o0.set(44);
        BitSet bitSet8 = new BitSet(256);
        O0000o0O = bitSet8;
        bitSet8.or(O0000o0);
        O0000o0O.or(O0000o00);
        O0000o0O.or(O0000OoO);
        BitSet bitSet9 = O0000o0O;
        O0000o0o = bitSet9;
        O0000o = bitSet9;
        BitSet bitSet10 = new BitSet(256);
        O0000oO0 = bitSet10;
        bitSet10.or(O0000o00);
        O0000oO0.or(O0000OoO);
        O0000oO0.set(58);
        O0000oO0.set(64);
        O0000oO0.set(38);
        O0000oO0.set(61);
        O0000oO0.set(43);
        O0000oO0.set(36);
        O0000oO0.set(44);
        BitSet bitSet11 = new BitSet(256);
        O0000oOO = bitSet11;
        bitSet11.or(O0000oO0);
        O0000oOO.set(59);
        O0000oOO.or(O0000oO);
        BitSet bitSet12 = new BitSet(256);
        O0000oOo = bitSet12;
        bitSet12.set(47);
        O0000oOo.or(O0000oOO);
        BitSet bitSet13 = new BitSet(256);
        O0000oo0 = bitSet13;
        bitSet13.set(47);
        O0000oo0.or(O0000oOo);
        BitSet bitSet14 = new BitSet(256);
        O0000oo = bitSet14;
        bitSet14.or(O0000o00);
        O0000oo.or(O0000OoO);
        O0000oo.set(59);
        O0000oo.set(63);
        O0000oo.set(59);
        O0000oo.set(64);
        O0000oo.set(38);
        O0000oo.set(61);
        O0000oo.set(43);
        O0000oo.set(36);
        O0000oo.set(44);
        BitSet bitSet15 = new BitSet(256);
        O0000ooO = bitSet15;
        bitSet15.or(O0000oo);
        O0000ooO.or(O0000o0O);
        BitSet bitSet16 = new BitSet(256);
        O0000ooo = bitSet16;
        bitSet16.or(O0000oo0);
        O0000ooo.or(O0000ooO);
        BitSet bitSet17 = new BitSet(256);
        O00oOooo = bitSet17;
        bitSet17.or(O0000O0o);
        O00oOooo.set(46);
        BitSet bitSet18 = new BitSet(256);
        O000O00o = bitSet18;
        bitSet18.or(O0000Oo);
        O000O00o.set(58);
        O000O00o.or(O00oOooo);
        BitSet bitSet19 = new BitSet(256);
        O000O0OO = bitSet19;
        bitSet19.set(91);
        O000O0OO.or(O000O00o);
        O000O0OO.set(93);
        BitSet bitSet20 = new BitSet(256);
        O000O0Oo = bitSet20;
        bitSet20.or(O0000Oo0);
        O000O0Oo.set(45);
        BitSet bitSet21 = new BitSet(256);
        O000O0o0 = bitSet21;
        bitSet21.or(O000O0Oo);
        O000O0o0.set(46);
        BitSet bitSet22 = new BitSet(256);
        O000O0o = bitSet22;
        bitSet22.or(O000O0o0);
        O000O0o.or(O000O0OO);
        BitSet bitSet23 = new BitSet(256);
        O000O0oO = bitSet23;
        bitSet23.or(O000O0o);
        O000O0oO.set(58);
        O000O0oO.or(O00oOooO);
        BitSet bitSet24 = new BitSet(256);
        O000O0oo = bitSet24;
        bitSet24.or(O0000o00);
        O000O0oo.or(O0000OoO);
        O000O0oo.set(59);
        O000O0oo.set(58);
        O000O0oo.set(38);
        O000O0oo.set(61);
        O000O0oo.set(43);
        O000O0oo.set(36);
        O000O0oo.set(44);
        BitSet bitSet25 = new BitSet(256);
        O000OO00 = bitSet25;
        bitSet25.or(O000O0oo);
        O000OO00.clear(59);
        O000OO00.clear(58);
        O000OO00.clear(64);
        O000OO00.clear(63);
        O000OO00.clear(47);
        BitSet bitSet26 = new BitSet(256);
        O000OO0o = bitSet26;
        bitSet26.or(O000O0oo);
        O000OO0o.set(64);
        O000OO0o.or(O000O0oO);
        BitSet bitSet27 = new BitSet(256);
        O000OO = bitSet27;
        bitSet27.or(O0000o00);
        O000OO.or(O0000OoO);
        O000OO.set(36);
        O000OO.set(44);
        O000OO.set(59);
        O000OO.set(58);
        O000OO.set(64);
        O000OO.set(38);
        O000OO.set(61);
        O000OO.set(43);
        BitSet bitSet28 = new BitSet(256);
        O000OOOo = bitSet28;
        bitSet28.or(O000OO0o);
        O000OOOo.or(O000OO);
        BitSet bitSet29 = new BitSet(256);
        O000OOo0 = bitSet29;
        bitSet29.or(O0000OOo);
        O000OOo0.or(O0000O0o);
        O000OOo0.set(43);
        O000OOo0.set(45);
        O000OOo0.set(46);
        BitSet bitSet30 = new BitSet(256);
        O000OOo = bitSet30;
        bitSet30.or(O0000o00);
        O000OOo.or(O0000OoO);
        O000OOo.set(59);
        O000OOo.set(64);
        O000OOo.set(38);
        O000OOo.set(61);
        O000OOo.set(43);
        O000OOo.set(36);
        O000OOo.set(44);
        BitSet bitSet31 = new BitSet(256);
        O000OOoO = bitSet31;
        bitSet31.or(O000OOo);
        O000OOoO.or(O0000oo0);
        BitSet bitSet32 = new BitSet(256);
        O000OOoo = bitSet32;
        bitSet32.set(47);
        O000OOoo.or(O000OOOo);
        O000OOoo.or(O0000oo0);
        BitSet bitSet33 = new BitSet(256);
        O000Oo00 = bitSet33;
        bitSet33.or(O000OOoo);
        O000Oo00.or(O0000oo0);
        O000Oo00.or(O0000o);
        BitSet bitSet34 = new BitSet(256);
        O000Oo0 = bitSet34;
        bitSet34.or(O000OOoo);
        O000Oo0.or(O0000oo0);
        O000Oo0.or(O000OOoO);
        O000Oo0.or(O0000o);
        BitSet bitSet35 = new BitSet(256);
        O000Oo0O = bitSet35;
        bitSet35.or(O000OOo0);
        O000Oo0O.set(58);
        O000Oo0O.or(O000Oo00);
        O000Oo0O.or(O0000ooO);
        BitSet bitSet36 = new BitSet(256);
        O000Oo0o = bitSet36;
        bitSet36.or(O000Oo0O);
        O000Oo0o.or(O000Oo0);
        O000Oo0o.set(35);
        O000Oo0o.or(O0000o0o);
        for (int i6 = 0; i6 <= 31; i6++) {
            O000OoO0.set(i6);
        }
        O000OoO0.set(127);
        BitSet bitSet37 = new BitSet(256);
        O00O0Oo = bitSet37;
        bitSet37.set(32);
        BitSet bitSet38 = new BitSet(256);
        O000OoO = bitSet38;
        bitSet38.set(60);
        O000OoO.set(62);
        O000OoO.set(35);
        O000OoO.set(37);
        O000OoO.set(34);
        BitSet bitSet39 = new BitSet(256);
        O000OoOO = bitSet39;
        bitSet39.set(123);
        O000OoOO.set(125);
        O000OoOO.set(124);
        O000OoOO.set(92);
        O000OoOO.set(94);
        O000OoOO.set(91);
        O000OoOO.set(93);
        O000OoOO.set(96);
        BitSet bitSet40 = new BitSet(256);
        O000OoOo = bitSet40;
        bitSet40.or(O0000o0O);
        O000OoOo.andNot(O000OOoO);
        BitSet bitSet41 = new BitSet(256);
        O000Ooo0 = bitSet41;
        bitSet41.or(O0000o0O);
        O000Ooo0.andNot(O0000ooO);
        BitSet bitSet42 = new BitSet(256);
        O000Ooo = bitSet42;
        bitSet42.or(O000OOOo);
        O000Ooo.clear(37);
        BitSet bitSet43 = new BitSet(256);
        O000OooO = bitSet43;
        bitSet43.or(O0000ooO);
        O000OooO.clear(37);
        BitSet bitSet44 = new BitSet(256);
        O000Oooo = bitSet44;
        bitSet44.or(O000OO);
        O000Oooo.clear(37);
        BitSet bitSet45 = new BitSet(256);
        O000o000 = bitSet45;
        bitSet45.or(O000O0oo);
        O000o000.clear(37);
        BitSet bitSet46 = new BitSet(256);
        O000o00 = bitSet46;
        bitSet46.or(O000OO00);
        O000o00.clear(37);
        BitSet bitSet47 = new BitSet(256);
        O000o00O = bitSet47;
        bitSet47.or(O000O0OO);
        O000o00O.clear(91);
        O000o00O.clear(93);
        BitSet bitSet48 = new BitSet(256);
        O000o00o = bitSet48;
        bitSet48.or(O000O0o0);
        O000o00o.or(O000o00O);
        BitSet bitSet49 = new BitSet(256);
        O000o0 = bitSet49;
        bitSet49.or(O000OO0o);
        O000o0.or(O000OO);
        O000o0.clear(59);
        O000o0.clear(58);
        O000o0.clear(64);
        O000o0.clear(63);
        O000o0.clear(47);
        BitSet bitSet50 = new BitSet(256);
        O000o0O0 = bitSet50;
        bitSet50.or(O0000oo0);
        O000o0O0.andNot(O00000oo);
        O000o0O0.clear(43);
        BitSet bitSet51 = new BitSet(256);
        O000o0O = bitSet51;
        bitSet51.or(O000OOoO);
        O000o0O.clear(37);
        O000o0O.clear(43);
        BitSet bitSet52 = new BitSet(256);
        O000o0OO = bitSet52;
        bitSet52.or(O0000oo0);
        O000o0OO.clear(47);
        O000o0OO.clear(59);
        O000o0OO.clear(61);
        O000o0OO.clear(63);
        BitSet bitSet53 = new BitSet(256);
        O000o0Oo = bitSet53;
        bitSet53.or(O0000o0O);
        O000o0Oo.clear(37);
        BitSet bitSet54 = new BitSet(256);
        O000o0o0 = bitSet54;
        bitSet54.or(O000o0Oo);
        O000o0o0.andNot(O0000o0);
        BitSet bitSet55 = new BitSet(256);
        O000o0o = bitSet55;
        bitSet55.or(O0000o0O);
        O000o0o.clear(37);
    }

    private static boolean O000000o(char[] cArr, char[] cArr2) {
        if (cArr == null && cArr2 == null) {
            return true;
        }
        if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
            return false;
        }
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] != cArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof URI)) {
            return false;
        }
        URI uri = (URI) obj;
        return O000000o(this._scheme, uri._scheme) && O000000o(this._opaque, uri._opaque) && O000000o(this._authority, uri._authority) && O000000o(this._path, uri._path) && O000000o(this._query, uri._query) && O000000o(this._fragment, uri._fragment);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    public int hashCode() {
        if (this.hash == 0) {
            char[] cArr = this._uri;
            if (cArr != null) {
                for (char c : cArr) {
                    this.hash = (this.hash * 31) + c;
                }
            }
            char[] cArr2 = this._fragment;
            if (cArr2 != null) {
                for (char c2 : cArr2) {
                    this.hash = (this.hash * 31) + c2;
                }
            }
        }
        return this.hash;
    }

    public int compareTo(Object obj) throws ClassCastException {
        URI uri = (URI) obj;
        if (!O000000o(this._authority, uri._authority)) {
            return -1;
        }
        return toString().compareTo(uri.toString());
    }

    public synchronized Object clone() throws CloneNotSupportedException {
        URI uri;
        uri = (URI) super.clone();
        uri._uri = this._uri;
        uri._scheme = this._scheme;
        uri._opaque = this._opaque;
        uri._authority = this._authority;
        uri._userinfo = this._userinfo;
        uri._host = this._host;
        uri._port = this._port;
        uri._path = this._path;
        uri._query = this._query;
        uri._fragment = this._fragment;
        uri.protocolCharset = this.protocolCharset;
        uri._is_hier_part = this._is_hier_part;
        uri._is_opaque_part = this._is_opaque_part;
        uri._is_net_path = this._is_net_path;
        uri._is_abs_path = this._is_abs_path;
        uri._is_rel_path = this._is_rel_path;
        uri._is_reg_name = this._is_reg_name;
        uri._is_server = this._is_server;
        uri._is_hostname = this._is_hostname;
        uri._is_IPv4address = this._is_IPv4address;
        uri._is_IPv6reference = this._is_IPv6reference;
        return uri;
    }

    public static class DefaultCharsetChanged extends RuntimeException {
        private String reason;
        private int reasonCode;

        public DefaultCharsetChanged(int i, String str) {
            super(str);
            this.reason = str;
            this.reasonCode = i;
        }

        public int getReasonCode() {
            return this.reasonCode;
        }

        public String getReason() {
            return this.reason;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static final Hashtable f15430O000000o;

        static {
            Hashtable hashtable = new Hashtable();
            f15430O000000o = hashtable;
            hashtable.put("ar", "ISO-8859-6");
            f15430O000000o.put("be", "ISO-8859-5");
            f15430O000000o.put("bg", "ISO-8859-5");
            f15430O000000o.put("ca", "ISO-8859-1");
            f15430O000000o.put("cs", "ISO-8859-2");
            f15430O000000o.put("da", "ISO-8859-1");
            f15430O000000o.put("de", "ISO-8859-1");
            f15430O000000o.put("el", "ISO-8859-7");
            f15430O000000o.put("en", "ISO-8859-1");
            f15430O000000o.put("es", "ISO-8859-1");
            f15430O000000o.put("et", "ISO-8859-1");
            f15430O000000o.put("fi", "ISO-8859-1");
            f15430O000000o.put("fr", "ISO-8859-1");
            f15430O000000o.put("hr", "ISO-8859-2");
            f15430O000000o.put("hu", "ISO-8859-2");
            f15430O000000o.put("is", "ISO-8859-1");
            f15430O000000o.put("it", "ISO-8859-1");
            f15430O000000o.put("iw", "ISO-8859-8");
            f15430O000000o.put("ja", "Shift_JIS");
            f15430O000000o.put("ko", "EUC-KR");
            f15430O000000o.put("lt", "ISO-8859-2");
            f15430O000000o.put("lv", "ISO-8859-2");
            f15430O000000o.put("mk", "ISO-8859-5");
            f15430O000000o.put("nl", "ISO-8859-1");
            f15430O000000o.put("no", "ISO-8859-1");
            f15430O000000o.put("pl", "ISO-8859-2");
            f15430O000000o.put("pt", "ISO-8859-1");
            f15430O000000o.put("ro", "ISO-8859-2");
            f15430O000000o.put("ru", "ISO-8859-5");
            f15430O000000o.put("sh", "ISO-8859-5");
            f15430O000000o.put("sk", "ISO-8859-2");
            f15430O000000o.put("sl", "ISO-8859-2");
            f15430O000000o.put("sq", "ISO-8859-2");
            f15430O000000o.put("sr", "ISO-8859-5");
            f15430O000000o.put("sv", "ISO-8859-1");
            f15430O000000o.put("tr", "ISO-8859-9");
            f15430O000000o.put("uk", "ISO-8859-5");
            f15430O000000o.put("zh", "GB2312");
            f15430O000000o.put("zh_TW", "Big5");
        }

        public static String O000000o(Locale locale) {
            String str = (String) f15430O000000o.get(locale.toString());
            if (str != null) {
                return str;
            }
            return (String) f15430O000000o.get(locale.getLanguage());
        }
    }

    public String toString() {
        char[] cArr = this._uri;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }
}
