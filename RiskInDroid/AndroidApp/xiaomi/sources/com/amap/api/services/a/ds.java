package com.amap.api.services.a;

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

public class ds extends dw {

    /* renamed from: a  reason: collision with root package name */
    private Context f3412a;
    private String b;
    private cc e;
    private Object[] f;

    public ds(Context context, dw dwVar, cc ccVar, String str, Object... objArr) {
        super(dwVar);
        this.f3412a = context;
        this.b = str;
        this.e = ccVar;
        this.f = objArr;
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = bz.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String b2 = b(this.f3412a);
        return bz.a("{\"pinfo\":\"" + b2 + "\",\"els\":[" + a2 + "]}");
    }

    private String a(Context context) {
        try {
            return String.format(bz.c(this.b), this.f);
        } catch (Throwable th) {
            th.printStackTrace();
            cl.c(th, "ofm", "gpj");
            return "";
        }
    }

    private String b(Context context) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        return bz.a(this.e.b(bz.a(a(context))));
    }
}
