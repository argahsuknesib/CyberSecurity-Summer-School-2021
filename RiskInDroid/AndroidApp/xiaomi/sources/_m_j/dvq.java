package _m_j;

import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public final class dvq {
    public static byte[] O000000o(String str) {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[22];
        if (str.length() < 4) {
            str = str + "1234";
        }
        dvp.O000000o(bArr2, 0, bArr, 15);
        dvp.O000000o(bArr2, 16, str.getBytes(), 3);
        bArr2[20] = 0;
        bArr2[21] = 0;
        return dvr.O000000o(10002, 22, bArr2);
    }

    public static byte[] O000000o(long j) {
        return dvr.O000000o(10092, 4, dvp.O000000o((int) j));
    }

    public static byte[] O000000o(byte[] bArr) {
        return dvr.O000000o(11082, bArr.length, bArr);
    }

    public static byte[] O00000Oo(long j) {
        byte[] bArr;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", String.valueOf(j));
            bArr = jSONObject.toString().getBytes(Charset.forName("UTF-8"));
        } catch (JSONException unused) {
            cki.O00000oO("CamCommand", "doSendRecordVoiceSuccess fail ");
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return dvr.O000000o(10530, bArr.length, bArr);
    }
}
