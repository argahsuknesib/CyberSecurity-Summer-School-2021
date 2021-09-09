package _m_j;

import java.io.OutputStream;

public final class aul {

    /* renamed from: O000000o  reason: collision with root package name */
    public auy f12625O000000o;
    private String O00000Oo = "oob";
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private OutputStream O0000O0o;
    private String O0000OOo = "code";
    private auz O0000Oo;
    private String O0000Oo0;

    public aul(String str) {
        avt.O000000o(str, "Invalid Api key");
        this.O00000o0 = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public final aul O000000o(String str) {
        avt.O000000o((Object) str, "Callback can't be null");
        this.O00000Oo = str;
        return this;
    }

    public final aul O00000Oo(String str) {
        avt.O000000o(str, "Invalid Api secret");
        this.O00000o = str;
        return this;
    }

    public final aul O00000o0(String str) {
        avt.O000000o(str, "Invalid OAuth state");
        this.O00000oo = str;
        return this;
    }

    public final <S extends avj<?>> S O000000o(aum aum) {
        return aum.createService(new avc(this.O00000o0, this.O00000o, this.O00000Oo, this.O00000oO, this.O0000O0o, this.O00000oo, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.f12625O000000o));
    }
}
