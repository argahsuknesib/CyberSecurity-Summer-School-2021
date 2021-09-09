package _m_j;

import com.xiaovv.player.HSMediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

public final class iht {
    public static String O000000o(byte[] bArr) {
        int[] iArr = new int[4];
        long[] jArr = new long[1];
        if (!HSMediaPlayer.getPanoParamBySei(bArr, iArr, jArr)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("camType", iArr[0]);
            jSONObject.put("panoX", iArr[1]);
            jSONObject.put("panoY", iArr[2]);
            jSONObject.put("panoR", iArr[3]);
            jSONObject.put("timestamp", jArr[0]);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
