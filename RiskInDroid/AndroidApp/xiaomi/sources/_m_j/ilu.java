package _m_j;

import java.nio.ByteBuffer;

public final class ilu {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1452O000000o = -1;
    public ByteBuffer O00000Oo;
    int O00000o;
    public boolean O00000o0;
    public boolean O00000oO;
    public int O00000oo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public ilu() {
        imc.O000000o("dl_mp3", (Object) "======================BufferItem Constructor()");
        this.O00000o0 = false;
        this.O00000o = 0;
        this.O00000oO = false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            this.O00000Oo = ByteBuffer.wrap(byteBuffer.array());
            this.O00000o = byteBuffer.array().length;
            imc.O000000o("dl_mp3", (Object) ("======================BufferItem setBuffer0(" + this.O00000o + ")"));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.imc.O000000o(java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.imc.O000000o(java.lang.String, java.lang.String):void
      _m_j.imc.O000000o(java.lang.String, java.lang.Object):void */
    public final void O000000o(byte[] bArr) {
        if (bArr != null) {
            this.O00000Oo = ByteBuffer.wrap(bArr);
            this.O00000o = bArr.length;
            imc.O000000o("dl_mp3", (Object) ("======================BufferItem setBuffer1(" + this.O00000o + ")"));
        }
    }
}
