package _m_j;

public final class aij {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final aii f12389O000000o = new aii("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
    public static final aii O00000Oo = new aii(f12389O000000o, "MIME-NO-LINEFEEDS");
    public static final aii O00000o;
    public static final aii O00000o0 = new aii(f12389O000000o, "PEM", true, '=', 64);

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aii.<init>(java.lang.String, java.lang.String, boolean, char, int):void
     arg types: [java.lang.String, java.lang.String, int, int, int]
     candidates:
      _m_j.aii.<init>(_m_j.aii, java.lang.String, boolean, char, int):void
      _m_j.aii.<init>(java.lang.String, java.lang.String, boolean, char, int):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.aii.<init>(_m_j.aii, java.lang.String, boolean, char, int):void
     arg types: [_m_j.aii, java.lang.String, int, int, int]
     candidates:
      _m_j.aii.<init>(java.lang.String, java.lang.String, boolean, char, int):void
      _m_j.aii.<init>(_m_j.aii, java.lang.String, boolean, char, int):void */
    static {
        StringBuffer stringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        stringBuffer.setCharAt(stringBuffer.indexOf("+"), '-');
        stringBuffer.setCharAt(stringBuffer.indexOf("/"), '_');
        O00000o = new aii("MODIFIED-FOR-URL", stringBuffer.toString(), false, 0, Integer.MAX_VALUE);
    }

    public static aii O000000o() {
        return O00000Oo;
    }
}
