package com.tutk;

import _m_j.cki;
import _m_j.jgs;
import _m_j.jgt;
import _m_j.jgu;
import android.text.TextUtils;
import android.util.Log;
import com.tutk.IOTC.Packet;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import java.util.HashMap;
import org.json.JSONObject;
import org.libsodium.jni.SodiumJNI;

public class DecryptUtil {
    static {
        System.loadLibrary("sodiumjni");
    }

    public static String byteToString(byte[] bArr) {
        jgu jgu = jgt.O00000Oo;
        return jgu.O000000o(bArr);
    }

    public static byte[] getShareKey(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        SodiumJNI.crypto_box_beforenm(bArr3, bArr, bArr2);
        return bArr3;
    }

    public static byte[] stringToByte(String str) {
        jgu jgu = jgt.O00000Oo;
        return jgu.O000000o(str);
    }

    public static byte[] getShareKeyApp(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        SodiumJNI.crypto_box_beforenm(bArr3, bArr, bArr2);
        return bArr3;
    }

    public static byte[] stringToByteApp(String str) {
        jgu jgu = jgt.O00000Oo;
        return jgu.O000000o(str);
    }

    public static String byteToStringApp(byte[] bArr) {
        jgu jgu = jgt.O00000Oo;
        return jgu.O000000o(bArr);
    }

    public static byte[] decryptVideo(byte[] bArr, byte[] bArr2, boolean z, int i) throws ArrayIndexOutOfBoundsException {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        boolean z2 = z;
        if (bArr3 == null || bArr4 == null) {
            return bArr3;
        }
        HashMap hashMap = new HashMap();
        byte[] bArr5 = new byte[8];
        System.arraycopy(bArr3, 0, bArr5, 0, 8);
        byte b = bArr3[8] & 255;
        int i2 = b * 8;
        byte[] bArr6 = new byte[i2];
        System.arraycopy(bArr3, 9, bArr6, 0, bArr6.length);
        int i3 = i2 + 9;
        byte[] bArr7 = new byte[(bArr3.length - i3)];
        System.arraycopy(bArr3, i3, bArr7, 0, bArr7.length);
        int i4 = 0;
        int i5 = 0;
        while (i4 < b) {
            int byteArrayToInt = Packet.byteArrayToInt(bArr6, i5, z2);
            int i6 = i5 + 4;
            int byteArrayToInt2 = Packet.byteArrayToInt(bArr6, i6, z2);
            i5 = i6 + 4;
            hashMap.put(Integer.valueOf(byteArrayToInt), Integer.valueOf(byteArrayToInt2));
            for (int i7 = 32; i7 < byteArrayToInt2 - 16; i7 += 160) {
                byte[] bArr8 = new byte[16];
                byte[] bArr9 = new byte[16];
                int i8 = i7 + byteArrayToInt;
                System.arraycopy(bArr7, i8, bArr9, 0, 16);
                jgs.O000000o(bArr8, bArr9, 16, bArr5, bArr4);
                System.arraycopy(bArr8, 0, bArr7, i8, 16);
            }
            i4++;
            z2 = z;
        }
        if (checkNal(bArr7, hashMap, i)) {
            return bArr7;
        }
        Log.e("Video", "fail");
        return null;
    }

    public static byte[] decryptVideoEx(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return bArr;
        }
        if (bArr.length <= 8) {
            return null;
        }
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArr, 0, bArr3, 0, 8);
        int length = bArr.length - 8;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 8, bArr5, 0, length);
        jgs.O000000o(bArr4, bArr5, length, bArr3, bArr2);
        return bArr4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r4 != 5) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        if (r4 != 19) goto L_0x0066;
     */
    private static boolean checkNal(byte[] bArr, HashMap<Integer, Integer> hashMap, int i) {
        int length;
        int i2;
        if (bArr == null) {
            return true;
        }
        int length2 = bArr.length - 3;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            byte b = bArr[i3];
            int i5 = i3 + 1;
            byte b2 = bArr[i5];
            byte b3 = bArr[i3 + 2];
            if (b == 0 && b2 == 0 && b3 == 1) {
                if (i4 != 0) {
                    int i6 = i3 - 1;
                    int i7 = bArr[i6] == 0 ? i6 - i4 : i3 - i4;
                    if (i7 > 48) {
                        return hashMap.containsKey(Integer.valueOf(i4)) && hashMap.get(Integer.valueOf(i4)).intValue() == i7;
                    }
                }
                if (i == 80) {
                    i2 = i3 + 3;
                    byte b4 = bArr[i2] & 31;
                    if (b4 != 1) {
                    }
                    i4 = i2;
                } else {
                    i2 = i3 + 3;
                    int i8 = (bArr[i2] & 126) >> 1;
                    if (i8 != 1) {
                    }
                    i4 = i2;
                }
                i4 = 0;
            }
            i3 = i5;
        }
        if (i4 == 0 || (length = bArr.length - i4) <= 48) {
            return true;
        }
        return hashMap.containsKey(Integer.valueOf(i4)) && hashMap.get(Integer.valueOf(i4)).intValue() == length;
    }

    public static byte[] decryptAudioG711(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return bArr;
        }
        if (bArr.length <= 8) {
            return null;
        }
        byte[] bArr3 = new byte[8];
        System.arraycopy(bArr, 0, bArr3, 0, 8);
        int length = bArr.length - 8;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr, 8, bArr5, 0, length);
        jgs.O000000o(bArr4, bArr5, length, bArr3, bArr2);
        return bArr4;
    }

    public static byte[] encryptAudio(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length <= 8) {
            return bArr;
        }
        byte[] bArr3 = new byte[8];
        byte[] bArr4 = new byte[bArr.length];
        SodiumJNI.randombytes_buf(bArr3, 8);
        jgs.O000000o(bArr4, bArr, bArr.length, bArr3, bArr2);
        byte[] bArr5 = new byte[(bArr.length + 8)];
        System.arraycopy(bArr3, 0, bArr5, 0, 8);
        System.arraycopy(bArr4, 0, bArr5, 8, bArr.length);
        return bArr5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b3 A[Catch:{ Exception -> 0x00cd }] */
    public static void updateTutkPwd(DeviceStat deviceStat, final Callback<XmP2PInfo> callback) {
        TuTkClient.mConnect_Public_Key = System.currentTimeMillis();
        final P2PInfoImp p2PInfoImp = new P2PInfoImp();
        String devicePincode = XmPluginHostApi.instance().getDevicePincode(deviceStat.did);
        p2PInfoImp.setDid(deviceStat.did);
        p2PInfoImp.setModel(deviceStat.model);
        p2PInfoImp.setOnLine(deviceStat.isOnline);
        try {
            String optString = new JSONObject(deviceStat.extrainfo).optString("fw_version");
            if (!TextUtils.isEmpty(optString)) {
                String substring = optString.substring(optString.lastIndexOf("_"));
                if (!TextUtils.isEmpty(substring) && substring.startsWith("_")) {
                    substring = substring.substring(1);
                }
                cki.O00000o("DecryptUtil", "fw_version_postfix:".concat(String.valueOf(substring)));
                if (deviceStat != null) {
                    if (("chuangmi.camera.ipc009".equals(deviceStat.model) && compareDeviceVersion(substring, "0300") >= 0) || "chuangmi.camera.ipc019".equals(deviceStat.model) || DeviceModelManager.getInstance().isFullDecrpt(deviceStat.model)) {
                        p2PInfoImp.isIPC009VideoFullEncryption = true;
                        if (deviceStat != null && ("chuangmi.camera.ipc019e".equals(deviceStat.model) || "chuangmi.camera.ipc017".equals(deviceStat.model))) {
                            p2PInfoImp.isIPC009VideoFullEncryption = true;
                        }
                        if (deviceStat.model.equals("chuangmi.gateway.ipc011")) {
                            p2PInfoImp.useFixedRdtChannelId = true;
                        }
                        if (deviceStat != null || !"chuangmi.camera.ipc009".equals(deviceStat.model) || compareDeviceVersion(substring, "0301") < 0) {
                            p2PInfoImp.isIPC009AudioFullEncryption = false;
                        } else {
                            p2PInfoImp.isIPC009AudioFullEncryption = true;
                        }
                    }
                }
                p2PInfoImp.isIPC009VideoFullEncryption = false;
                p2PInfoImp.isIPC009VideoFullEncryption = true;
                if (deviceStat.model.equals("chuangmi.gateway.ipc011")) {
                }
                if (deviceStat != null) {
                }
                p2PInfoImp.isIPC009AudioFullEncryption = false;
            }
        } catch (Exception e) {
            cki.O00000o("DecryptUtil", "exception:" + e.getLocalizedMessage());
        }
        getKeyPair(p2PInfoImp.mPublicKey, p2PInfoImp.mPrivateKey);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", p2PInfoImp.getDid());
            jSONObject.put("toSignAppData", byteToString(p2PInfoImp.mPublicKey));
            if (!TextUtils.isEmpty(devicePincode)) {
                jSONObject.put("pincode", devicePincode);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        XmPluginHostApi.instance().callSmartHomeApi(p2PInfoImp.getModel(), "/device/devicepass", jSONObject, new Callback<JSONObject>() {
            /* class com.tutk.DecryptUtil.AnonymousClass1 */

            public final void onSuccess(JSONObject jSONObject) {
                int optInt = jSONObject.optInt("ret");
                p2PInfoImp.setUid(jSONObject.optString("p2p_id"));
                String optString = jSONObject.optString("password");
                p2PInfoImp.setPwd(optString);
                String optString2 = jSONObject.optString("p2p_dev_public_key");
                if (!TextUtils.isEmpty(optString2)) {
                    p2PInfoImp.mRemoteKey = optString2;
                }
                p2PInfoImp.mRemoteSing = jSONObject.optString("signForAppData");
                if (!TextUtils.isEmpty(p2PInfoImp.mRemoteSing)) {
                    P2PInfoImp p2PInfoImp = p2PInfoImp;
                    p2PInfoImp.mShareKey = DecryptUtil.getShareKey(DecryptUtil.stringToByte(p2PInfoImp.mRemoteKey), p2PInfoImp.mPrivateKey);
                    cki.O00000o("DecryptUtil", "get share key");
                }
                if (!TextUtils.isEmpty(optString) && optString.length() >= 16) {
                    P2PInfoImp p2PInfoImp2 = p2PInfoImp;
                    p2PInfoImp2.mHualaiShareKey = (optString.substring(0, 16) + optString.substring(0, 16)).getBytes();
                }
                if (TextUtils.isEmpty(p2PInfoImp.getUid()) || (TextUtils.isEmpty(optString) && !DecryptUtil.noNeedPwd(p2PInfoImp.getModel()))) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(optInt, "");
                    }
                    cki.O00000oO("DecryptUtil", "uid or pwd empty");
                    return;
                }
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onSuccess(p2PInfoImp);
                }
            }

            public final void onFailure(int i, String str) {
                cki.O00000oO("DecryptUtil", "error ".concat(String.valueOf(i)));
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public static boolean noNeedPwd(String str) {
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("dun.cateye.nknk500");
    }

    public static int compareDeviceVersion(String str, String str2) {
        cki.O00000o("DecryptUtil", "sourceVersion:" + str + " targetVersion:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("[._]");
        String[] split2 = str2.split("[._]");
        int min = Math.min(split.length, split2.length);
        long j = 0;
        int i = 0;
        while (i < min) {
            j = Long.parseLong(split[i]) - Long.parseLong(split2[i]);
            if (j != 0) {
                break;
            }
            i++;
        }
        if (j != 0) {
            return j > 0 ? 1 : -1;
        }
        for (int i2 = i; i2 < split.length; i2++) {
            if (Long.parseLong(split[i2]) > 0) {
                return 1;
            }
        }
        while (i < split2.length) {
            if (Long.parseLong(split2[i]) > 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static byte[] decryptBigFile(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[16];
        System.arraycopy(bArr, 0, bArr6, 0, 16);
        jgs.O000000o(bArr5, bArr6, 16, bArr2, bArr3);
        System.arraycopy(bArr5, 0, bArr4, 0, 16);
        System.arraycopy(bArr, 16, bArr4, 16, bArr.length - 16);
        return bArr4;
    }

    public static byte[] decryptSmallFile(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[bArr.length];
        jgs.O000000o(bArr4, bArr, bArr.length, bArr2, bArr3);
        return bArr4;
    }

    public static void getKeyPair(byte[] bArr, byte[] bArr2) {
        SodiumJNI.crypto_box_keypair(bArr, bArr2);
    }

    public static void getKeyPairApp(byte[] bArr, byte[] bArr2) {
        SodiumJNI.crypto_box_keypair(bArr, bArr2);
    }
}
