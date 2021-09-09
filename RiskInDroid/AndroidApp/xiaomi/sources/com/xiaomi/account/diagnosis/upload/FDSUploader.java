package com.xiaomi.account.diagnosis.upload;

import _m_j.dvx;
import _m_j.dvz;
import _m_j.dwb;
import _m_j.dwf;
import _m_j.dwj;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.infra.galaxy.fds.android.exception.GalaxyFDSClientException;
import java.io.File;

public class FDSUploader {
    private FDSUploader() {
    }

    private static byte[] encode(byte[] bArr) {
        byte[] bArr2 = new byte[256];
        for (int i = 0; i < "0xCAFEBABE".getBytes().length; i++) {
            bArr2[i] = "0xCAFEBABE".getBytes()[i % "0xCAFEBABE".getBytes().length];
        }
        byte[] bArr3 = new byte[bArr.length];
        int i2 = 0;
        byte b = 0;
        for (int i3 = 0; i3 < bArr3.length; i3++) {
            i2 = (i2 + 1) & 255;
            b = (b + bArr2[i2]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = (byte) b2;
            bArr3[i3] = (byte) (bArr2[(bArr2[b] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        return bArr3;
    }

    private static String d(String str) {
        return new String(encode(Base64.decode(str, 2)));
    }

    public static dwf upload(File file, String str) {
        dvx dvx = new dvx();
        if (TextUtils.isEmpty(str)) {
            str = d("G25iajFoZiJzLmFAWR5IWVFfXVkeU19d");
        }
        dvx.O0000Ooo = str;
        dvx.O0000Oo = true;
        dvx.O0000OoO = false;
        dvx.O00000o = 5242880;
        dwb dwb = new dwb(d("OUtaT1NwVAs2RlAEeAcEdQV4"), d("PUtCcHIzdy5ZcDZaamQbUmR+d0QIWGZ0ZwVbeWABfHt8SF9oekJXBA=="));
        dwj.O000000o(dwb, "credential");
        dvx.O0000Oo0 = dwb;
        try {
            return new dvz(dvx).O000000o(d("HGlhZ24pcy9z"), file.getName(), file);
        } catch (GalaxyFDSClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
