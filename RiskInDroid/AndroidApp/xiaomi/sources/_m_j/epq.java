package _m_j;

import _m_j.eov;
import android.text.TextUtils;
import com.xiaomi.push.service.bi;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class epq {
    private static String O00000oO = (erb.O000000o() + "-");
    private static long O00000oo = 0;
    private static final byte[] O0000O0o = new byte[0];

    /* renamed from: O000000o  reason: collision with root package name */
    public eov.O000000o f15708O000000o;
    public short O00000Oo;
    int O00000o;
    public String O00000o0;
    private byte[] O0000OOo;

    public epq() {
        this.O00000Oo = 2;
        this.O0000OOo = O0000O0o;
        this.O00000o0 = null;
        this.f15708O000000o = new eov.O000000o();
        this.O00000o = 1;
    }

    private epq(eov.O000000o o000000o, short s, byte[] bArr) {
        this.O00000Oo = 2;
        this.O0000OOo = O0000O0o;
        this.O00000o0 = null;
        this.f15708O000000o = o000000o;
        this.O00000Oo = s;
        this.O0000OOo = bArr;
        this.O00000o = 2;
    }

    static epq O00000Oo(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i = slice.getInt(4);
            eov.O000000o o000000o = new eov.O000000o();
            o000000o.O00000Oo(slice.array(), slice.arrayOffset() + 8, s2);
            byte[] bArr = new byte[i];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i);
            return new epq(o000000o, s, bArr);
        } catch (Exception e) {
            duv.O000000o("read Blob err :" + e.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    private static synchronized String O00000oO() {
        String sb;
        synchronized (epq.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(O00000oO);
            long j = O00000oo;
            O00000oo = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer O000000o(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(O00000o());
        }
        byteBuffer.putShort(this.O00000Oo);
        byteBuffer.putShort((short) this.f15708O000000o.O000000o());
        byteBuffer.putInt(this.O0000OOo.length);
        int position = byteBuffer.position();
        this.f15708O000000o.O000000o(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f15708O000000o.O000000o());
        byteBuffer.position(position + this.f15708O000000o.O000000o());
        byteBuffer.put(this.O0000OOo);
        return byteBuffer;
    }

    public final void O000000o(int i) {
        this.f15708O000000o.O000000o(i);
    }

    public final void O000000o(long j, String str, String str2) {
        if (j != 0) {
            this.f15708O000000o.O000000o(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f15708O000000o.O000000o(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f15708O000000o.O00000Oo(str2);
        }
    }

    public final void O000000o(String str) {
        this.f15708O000000o.O00000oO(str);
    }

    public final void O000000o(byte[] bArr, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15708O000000o.O00000Oo(1);
            this.O0000OOo = bi.a(bi.a(str, O000000o()), bArr);
            return;
        }
        this.f15708O000000o.O00000Oo(0);
        this.O0000OOo = bArr;
    }

    public final void O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            try {
                long parseLong = Long.parseLong(str.substring(0, indexOf));
                int indexOf2 = str.indexOf("/", indexOf);
                String substring = str.substring(indexOf + 1, indexOf2);
                String substring2 = str.substring(indexOf2 + 1);
                this.f15708O000000o.O000000o(parseLong);
                this.f15708O000000o.O000000o(substring);
                this.f15708O000000o.O00000Oo(substring2);
            } catch (Exception e) {
                duv.O000000o("Blob parse user err " + e.getMessage());
            }
        }
    }

    public int O00000o() {
        return this.f15708O000000o.O00000Oo() + 8 + this.O0000OOo.length;
    }

    public final byte[] O00000o0() {
        return epr.O000000o(this, this.O0000OOo);
    }

    public final void O000000o(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f15708O000000o.O00000o0(str);
            eov.O000000o o000000o = this.f15708O000000o;
            o000000o.O0000O0o = false;
            o000000o.O0000OOo = "";
            if (!TextUtils.isEmpty(str2)) {
                this.f15708O000000o.O00000o(str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("command should not be empty");
    }

    public final String O000000o() {
        String str = this.f15708O000000o.O0000Oo;
        if ("ID_NOT_AVAILABLE".equals(str)) {
            return null;
        }
        if (this.f15708O000000o.O0000Oo0) {
            return str;
        }
        String O00000oO2 = O00000oO();
        this.f15708O000000o.O00000oO(O00000oO2);
        return O00000oO2;
    }

    public final String O00000Oo() {
        if (!this.f15708O000000o.O00000Oo) {
            return null;
        }
        return Long.toString(this.f15708O000000o.O00000o0) + "@" + this.f15708O000000o.O00000o + "/" + this.f15708O000000o.O00000oO;
    }

    public final byte[] O00000o0(String str) {
        if (this.f15708O000000o.O0000OoO == 1) {
            return epr.O000000o(this, bi.a(bi.a(str, O000000o()), this.O0000OOo));
        }
        if (this.f15708O000000o.O0000OoO == 0) {
            return epr.O000000o(this, this.O0000OOo);
        }
        duv.O000000o("unknow cipher = " + this.f15708O000000o.O0000OoO);
        return epr.O000000o(this, this.O0000OOo);
    }

    @Deprecated
    public static epq O000000o(eqr eqr, String str) {
        int i;
        epq epq = new epq();
        try {
            i = Integer.parseInt(eqr.O0000oOO);
        } catch (Exception e) {
            duv.O000000o("Blob parse chid err " + e.getMessage());
            i = 1;
        }
        epq.O000000o(i);
        epq.O000000o(eqr.O00000o());
        epq.O00000Oo(eqr.O0000oO);
        epq.O00000o0 = eqr.O0000oOo;
        epq.O000000o("XMLMSG", (String) null);
        try {
            epq.O000000o(eqr.O00000Oo().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                epq.O00000Oo = 3;
            } else {
                epq.O00000Oo = 2;
                epq.O000000o("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e2) {
            duv.O000000o("Blob setPayload err： " + e2.getMessage());
        }
        return epq;
    }

    public String toString() {
        return "Blob [chid=" + this.f15708O000000o.f15684O000000o + "; Id=" + O000000o() + "; cmd=" + this.f15708O000000o.O00000oo + "; type=" + ((int) this.O00000Oo) + "; from=" + O00000Oo() + " ]";
    }
}
