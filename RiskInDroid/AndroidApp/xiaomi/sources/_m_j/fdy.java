package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BleMessageParser$3;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleKeyValuePair;
import com.xiaomi.smarthome.core.server.internal.bluetooth.blecore.BleNetRequest;
import com.xiaomi.smarthome.device.Device;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fdy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, IBleResponse> f16140O000000o = new ConcurrentHashMap();

    public static void O000000o(String str, IBleResponse iBleResponse) {
        if (!TextUtils.isEmpty(str) && iBleResponse != null) {
            f16140O000000o.put(str, iBleResponse);
        }
    }

    public static void O000000o(String str) {
        f16140O000000o.remove(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fdy.O000000o(_m_j.fdy$O000000o, boolean):byte[]
     arg types: [_m_j.fdy$O000000o, int]
     candidates:
      _m_j.fdy.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleResponse):void
      _m_j.fdy.O000000o(_m_j.fdy$O000000o, boolean):byte[] */
    public static byte[] O000000o(byte[] bArr) {
        return O000000o(new O000000o(0, (byte) 3, (byte) 1, bArr), false);
    }

    private static byte[] O000000o(O000000o o000000o, boolean z) {
        byte[] bArr = o000000o.O00000o;
        if (z && o000000o.O00000o != null && o000000o.O00000o.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(o000000o.O00000o);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ByteBuffer order = ByteBuffer.allocate(bArr != null ? bArr.length + 5 : 5).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 1);
        order.putShort(o000000o.f16143O000000o);
        order.put((byte) (o000000o.O00000o0 | (o000000o.O00000Oo << 4)));
        order.put((byte) ((z ? 1 : 0) << true));
        if (bArr != null) {
            order.put(bArr);
        }
        return order.array();
    }

    private static O000000o O00000Oo(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            fte.O00000Oo("MiBTChannelUtil parse data invalid");
            return null;
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        order.get();
        short s = order.getShort();
        byte b = order.get();
        byte b2 = order.get();
        byte[] bArr2 = new byte[0];
        if (bArr.length > 5) {
            bArr2 = Arrays.copyOfRange(bArr, 5, bArr.length);
        }
        byte b3 = (byte) (b & 15);
        byte b4 = (byte) ((b & 255) >> 4);
        if (((byte) ((b2 & 255) >> 5)) == 1 && bArr2.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                byte[] bArr3 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                bArr2 = byteArrayOutputStream.toByteArray();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new O000000o(s, b4, b3, bArr2);
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r7v5, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v7, types: [org.json.JSONArray] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012e  */
    public static void O000000o(String str, byte[] bArr, final IBleChannelWriter iBleChannelWriter) {
        JSONObject jSONObject;
        Device O00000oo;
        String str2;
        final JSONArray jSONArray;
        O000000o O00000Oo = O00000Oo(bArr);
        if (O00000Oo != null) {
            byte b = O00000Oo.O00000Oo;
            if (b == 1) {
                try {
                    jSONObject = new JSONObject(new String(O00000Oo.O00000o));
                } catch (Exception unused) {
                    jSONObject = null;
                }
                final short s = O00000Oo.f16143O000000o;
                if (jSONObject == null) {
                    fte.O00000Oo("doRpc failure, jsonObject is null");
                    O000000o((byte) 1, s, false, null, iBleChannelWriter);
                    return;
                }
                String optString = jSONObject.optString("did");
                String optString2 = jSONObject.optString("method");
                String optString3 = jSONObject.optString("params");
                if (!TextUtils.isEmpty(optString3)) {
                    String substring = optString3.substring(0, 1);
                    if (TextUtils.equals(substring, "[")) {
                        try {
                            str2 = new JSONArray(optString3);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (TextUtils.equals(substring, "{")) {
                            try {
                                str2 = new JSONObject(optString3);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        }
                        O00000oo = fec.O00000o0().O00000oo(optString);
                        if (O00000oo != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("id", (int) ((Math.random() * 100000.0d) + 100000.0d));
                                jSONObject2.put("method", optString2);
                                jSONObject2.put("params", optString3);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                            fej O00000o0 = fec.O00000o0();
                            O00000oo.getToken();
                            O00000o0.O000000o(optString, jSONObject2.toString(), new feu() {
                                /* class _m_j.fdy.AnonymousClass1 */

                                public final void O000000o(String str) {
                                    fdy.O000000o((byte) 1, s, true, str != null ? str.getBytes() : null, true, iBleChannelWriter);
                                }

                                public final void O000000o(int i) {
                                    fte.O00000Oo("doRpc failure, shError = ".concat(String.valueOf(i)));
                                    fdy.O000000o((byte) 1, s, false, null, iBleChannelWriter);
                                }

                                public final void O000000o(int i, Object obj) {
                                    fte.O00000Oo("doRpc failure, shError = " + i + ", errorInfo = " + obj.toString());
                                    fdy.O000000o((byte) 1, s, false, obj.toString() != null ? obj.toString().getBytes() : null, iBleChannelWriter);
                                }
                            });
                            return;
                        }
                        fte.O00000Oo("doRpc failure, device is null");
                        O000000o((byte) 1, s, false, null, iBleChannelWriter);
                        return;
                    }
                    optString3 = str2;
                    O00000oo = fec.O00000o0().O00000oo(optString);
                    if (O00000oo != null) {
                    }
                }
                optString3 = "";
                O00000oo = fec.O00000o0().O00000oo(optString);
                if (O00000oo != null) {
                }
            } else if (b == 2) {
                try {
                    jSONArray = new JSONArray(new String(O00000Oo.O00000o));
                } catch (Exception unused2) {
                    jSONArray = null;
                }
                final short s2 = O00000Oo.f16143O000000o;
                if (jSONArray == null || jSONArray.length() <= 0) {
                    fte.O00000Oo("getDeviceProp failure, jsonArray is null");
                    O000000o((byte) 2, s2, false, null, iBleChannelWriter);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BleKeyValuePair("data", jSONArray.toString()));
                BleNetRequest.O000000o o000000o = new BleNetRequest.O000000o();
                o000000o.f6799O000000o = "POST";
                o000000o.O00000Oo = "/device/batchdevicedatas";
                o000000o.O00000o0 = arrayList;
                fec.O00000o0().O000000o(o000000o.O000000o(), new fer() {
                    /* class _m_j.fdy.AnonymousClass2 */

                    public final void O000000o(String str) {
                        JSONObject jSONObject;
                        try {
                            jSONObject = new JSONObject(str).optJSONObject("result");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject = null;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("props", jSONObject);
                            JSONObject jSONObject3 = new JSONObject();
                            int i = 0;
                            while (i < jSONArray.length()) {
                                try {
                                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                                    if (optJSONObject != null) {
                                        String optString = optJSONObject.optString("did");
                                        if (!TextUtils.isEmpty(optString)) {
                                            Device O00000oo = fec.O00000o0().O00000oo(optString);
                                            if (O00000oo != null) {
                                                jSONObject3.put(optString, O00000oo.isOnline() ? 1 : 0);
                                            } else {
                                                jSONObject3.put(optString, 0);
                                            }
                                        }
                                    }
                                    i++;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            jSONObject2.put("onlines", jSONObject3);
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        fdy.O000000o((byte) 2, s2, true, jSONObject2.toString().getBytes(), iBleChannelWriter);
                    }

                    public final void O000000o(int i, String str) {
                        fte.O00000Oo("getDeviceProp failure, ".concat(String.valueOf(str)));
                        fdy.O000000o((byte) 2, s2, false, str != null ? str.getBytes() : null, iBleChannelWriter);
                    }
                });
            } else if (b == 3) {
                byte[] bArr2 = O00000Oo.O00000o;
                IBleResponse iBleResponse = f16140O000000o.get(str);
                if (iBleResponse != null) {
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("extra.byte.array", bArr2);
                    try {
                        iBleResponse.onResponse(0, bundle);
                    } catch (RemoteException unused3) {
                    }
                }
            } else if (b == 4) {
                O000000o((byte) 4, O00000Oo.f16143O000000o, true, O00000Oo.O00000o, iBleChannelWriter);
            }
        }
    }

    public static void O000000o(byte b, short s, boolean z, byte[] bArr, IBleChannelWriter iBleChannelWriter) {
        O000000o(b, s, z, bArr, false, iBleChannelWriter);
    }

    public static void O000000o(byte b, short s, boolean z, byte[] bArr, boolean z2, IBleChannelWriter iBleChannelWriter) {
        fte.O00000Oo(String.format("BleMessageParser onResult msg_type = %d, id = %d, result = %b, returnMsg = %s", Byte.valueOf(b), Short.valueOf(s), Boolean.valueOf(z), bArr != null ? new String(bArr) : ""));
        byte[] O000000o2 = O000000o(new O000000o(s, b, z ? (byte) 1 : 0, bArr), z2);
        if (iBleChannelWriter != null) {
            try {
                iBleChannelWriter.write(O000000o2, 0, new BleMessageParser$3());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public short f16143O000000o = 0;
        byte O00000Oo = 0;
        public byte[] O00000o;
        byte O00000o0 = 0;

        public O000000o(short s, byte b, byte b2, byte[] bArr) {
            this.f16143O000000o = s;
            this.O00000Oo = b;
            this.O00000o0 = b2;
            this.O00000o = bArr;
        }

        public final String toString() {
            return "MiBTChannelUtil{id=" + ((int) this.f16143O000000o) + ", type=" + ((int) this.O00000Oo) + ", data='" + this.O00000o + '\'' + '}';
        }
    }
}
