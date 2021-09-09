package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class btl extends btp {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f13273O000000o;
    private String O00000Oo;
    private brw O00000oO;
    private Object[] O00000oo;

    public btl(Context context, btp btp, brw brw, String str, Object... objArr) {
        super(btp);
        this.f13273O000000o = context;
        this.O00000Oo = str;
        this.O00000oO = brw;
        this.O00000oo = objArr;
    }

    private String O00000Oo() {
        try {
            return String.format(brs.O00000o0(this.O00000Oo), this.O00000oo);
        } catch (Throwable th) {
            th.printStackTrace();
            bsf.O00000Oo(th, "ofm", "gpj");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] O000000o(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String O000000o2 = brs.O000000o(bArr);
        if (TextUtils.isEmpty(O000000o2)) {
            return null;
        }
        String O000000o3 = brs.O000000o(this.O00000oO.O00000Oo(brs.O000000o(O00000Oo())));
        return brs.O000000o("{\"pinfo\":\"" + O000000o3 + "\",\"els\":[" + O000000o2 + "]}");
    }
}
