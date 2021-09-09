package _m_j;

import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IRDTCameraPositionListener;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class chz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13865O000000o = "chz";
    public static final short[] O00000Oo = new short[2];
    public volatile int O00000o = -1;
    public cid O00000o0;

    public interface O000000o {
        void onPositionReceived();
    }

    public interface O00000Oo {
        void onError(String str, int i);

        void onSuccess(String str);
    }

    public class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f13873O000000o;
        public int O00000Oo;
        public int O00000o;
        public int O00000o0;
        public long O00000oO;
    }

    public interface O00000o0 {
        void onError(String str, int i);

        void onReceived(List<O00000o> list);
    }

    public chz(cid cid) {
        this.O00000o0 = cid;
    }

    public final void O000000o(final O000000o o000000o) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac", "F1F2F3F4F5F6");
            jSONObject.put("position", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str = f13865O000000o;
        gsy.O00000Oo(str, "getPosition params=" + jSONObject.toString());
        this.O00000o0.O00oOooO().setRDTCameraPositionListener(new IRDTCameraPositionListener() {
            /* class _m_j.chz.AnonymousClass1 */

            public final void onCameraPositionReceived(byte[] bArr) {
                byte[] bArr2 = new byte[2];
                System.arraycopy(bArr, 0, bArr2, 0, 2);
                short byteArrayToShort = Packet.byteArrayToShort(bArr2, 0, false);
                byte[] bArr3 = new byte[2];
                System.arraycopy(bArr, 2, bArr3, 0, 2);
                short byteArrayToShort2 = Packet.byteArrayToShort(bArr3, 0, false);
                chz.O00000Oo[0] = byteArrayToShort;
                chz.O00000Oo[1] = byteArrayToShort2;
                String str = chz.f13865O000000o;
                gsy.O00000Oo(str, "onCameraPositionReceived hd / vd = " + ((int) byteArrayToShort) + " / " + ((int) byteArrayToShort2));
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.onPositionReceived();
                }
            }
        });
        this.O00000o0.O00oOooO().streamSendMessage(14, 14, jSONObject.toString().getBytes(), null, new IMISSListener() {
            /* class _m_j.chz.AnonymousClass2 */

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
                String str2 = chz.f13865O000000o;
                gsy.O00000Oo(str2, "getPosition onSuccess = " + str + " " + obj);
            }

            public final void onFailed(int i, String str) {
                String str2 = chz.f13865O000000o;
                gsy.O00000Oo(str2, "getPosition onFailed = " + i + " " + str);
            }
        });
    }

    public final void O000000o(final O00000Oo o00000Oo, final String str, int i) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", str);
            jSONObject.put("location", i);
            jSONArray.put(jSONObject);
        } catch (Exception e) {
            civ.O00000o0(f13865O000000o, e.toString());
        }
        String str2 = f13865O000000o;
        civ.O000000o(str2, "ctrlPreSetPosition start " + jSONArray.toString());
        this.O00000o = i;
        this.O00000o0.callMethod("set_preset_position", jSONArray, new Callback<String>() {
            /* class _m_j.chz.AnonymousClass5 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                String str2 = chz.f13865O000000o;
                civ.O000000o(str2, "ctrlPreSetPosition " + str + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("location", -1);
                    String optString = jSONObject.optString("status", "");
                    if (!"ctrl".equals(optString) || optInt == chz.this.O00000o) {
                        o00000Oo.onSuccess(str);
                        return;
                    }
                    String str3 = chz.f13865O000000o;
                    civ.O000000o(str3, "ctrlPreSetPosition " + optString + " " + optInt + "!=" + chz.this.O00000o);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public final void onFailure(int i, String str) {
                String str2 = chz.f13865O000000o;
                civ.O000000o(str2, "ctrlPreSetPosition " + str + str + "--" + i);
                o00000Oo.onError(str, i);
            }
        }, new Parser<String>() {
            /* class _m_j.chz.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }
}
