package com.xiaomi.smarthome.uwb.lib.auth;

import _m_j.fio;
import _m_j.fip;
import _m_j.fir;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.idm.UwbDataListener;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.TVUwbDataBuilder;
import com.xiaomi.smarthome.uwb.lib.protocol.UwbDataGenerator;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class UwbStrangerRegister {
    private static int REGISTER_TIMEOUT = 30000;
    private static volatile AuthResultCallback sGlobalAuthResultCallback;
    public Type currentType;
    private byte[] mAppConfirm;
    private UwbConst.AppId mAppId;
    private KeyPair mAppKeyPair;
    private byte[] mAppRandom;
    private AuthResultCallback mAuthResultCallback;
    private byte[] mDevConfirm;
    private PublicKey mDevPubKey;
    private byte[] mDevRandom;
    public final Handler mHandler;
    private boolean mIsStart;
    private byte[] mOob;
    private int mOobCapability;
    private OobRequestCallback mOobRequestCallback;
    private int mProtocolVersion;
    private byte[] mSessionKey;
    private UwbConst.Target mTarget;
    private String mUid;
    private byte[] mUidHash;
    private UwbDataListener mUwbDataListener;

    /* renamed from: com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type = new int[Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type[Type.Register_D1.ordinal()] = 1;
            $SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type[Type.Register_D3.ordinal()] = 2;
            $SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type[Type.Register_D4_1.ordinal()] = 3;
            try {
                $SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type[Type.Register_D4_2.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public UwbStrangerRegister(String str, OobRequestCallback oobRequestCallback, AuthResultCallback authResultCallback) {
        this(str, oobRequestCallback, authResultCallback, UwbConst.AppId.MI_HOME, UwbConst.Target.SEND_DATA_TO_TAG);
    }

    public UwbStrangerRegister(String str, OobRequestCallback oobRequestCallback, AuthResultCallback authResultCallback, UwbConst.AppId appId, UwbConst.Target target) {
        this.mOob = new byte[16];
        this.mIsStart = false;
        this.currentType = null;
        this.mUwbDataListener = new UwbDataListener() {
            /* class com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister.AnonymousClass1 */

            public void onConnectionState(String str, int i) {
            }

            public void onSendPayload(int i) {
            }

            public void onPayloadReceived(Payload payload) {
                if (payload != null) {
                    UwbStrangerRegister.this.currentType = payload.getType();
                    int i = AnonymousClass3.$SwitchMap$com$xiaomi$smarthome$uwb$lib$protocol$format$Type[payload.getType().ordinal()];
                    if (i == 1) {
                        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus UwbStrangerRegister Register_D1 onPayloadReceived: " + TVUwbDataBuilder.byteArrToString(payload.getData()));
                        UwbStrangerRegister.this.onReceiveDevPublicKey(payload.getData());
                    } else if (i == 2) {
                        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus UwbStrangerRegister Register_D3 onPayloadReceived: " + TVUwbDataBuilder.byteArrToString(payload.getData()));
                        UwbStrangerRegister.this.onReceiveDevConfirm(payload.getData());
                    } else if (i == 3) {
                        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus UwbStrangerRegister Register_D4_1 onPayloadReceived: " + TVUwbDataBuilder.byteArrToString(payload.getData()));
                        UwbStrangerRegister.this.onReceiveDevRandom(payload.getData());
                    } else if (i == 4) {
                        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus UwbStrangerRegister Register_D4_2 onPayloadReceived: " + TVUwbDataBuilder.byteArrToString(payload.getData()));
                        UwbStrangerRegister.this.onReceiveCipherKey(payload.getData());
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) {
            /* class com.xiaomi.smarthome.uwb.lib.auth.UwbStrangerRegister.AnonymousClass2 */

            public void handleMessage(Message message) {
                if (message.what == 4096) {
                    UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "tick notify timeout");
                    UwbStrangerRegister.this.mHandler.removeMessages(4096);
                    UwbStrangerRegister.this.onFailed(-2);
                }
            }
        };
        UwbLogUtil.d("Mijia-UWB-StrangerReg", "uid=" + str + ",target=" + target + ",appId=" + appId);
        this.mUid = str;
        this.mOobRequestCallback = oobRequestCallback;
        this.mAuthResultCallback = authResultCallback;
        if (TextUtils.isEmpty(this.mUid)) {
            this.mUid = "0";
        }
        this.mUidHash = UwbDeviceUtil.getUwbHash3B(this.mUid);
        this.mAppKeyPair = fir.O000000o();
        this.mAppRandom = generateRandom();
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "UwbStrangerRegister created:uid=" + str + ",uidHash=" + Arrays.toString(this.mUidHash) + ",mAppKeyPair=" + this.mAppKeyPair + ",mAppRandom=" + this.mAppRandom);
        }
        this.mAppId = appId;
        this.mTarget = target;
    }

    public void startAuth() {
        LogType logType = LogType.LOG_UWB;
        UwbLogUtil.w(logType, "Mijia-UWB-StrangerReg", "startAuth " + this.mUid);
        if (this.mIsStart) {
            UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "startAuth failed, has started");
            return;
        }
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "startAuth print stacktrace+++++++++");
            new Exception().printStackTrace();
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "startAuth print stacktrace---------");
        }
        this.mIsStart = true;
        addUwbDataListener();
        sendStrangerRegisterCmd();
    }

    public void stopAuth() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "stopAuth");
        if (!this.mIsStart) {
            UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "stopAuth failed, has stopped");
        } else {
            onFailed(-3);
        }
    }

    private void addUwbDataListener() {
        UwbIdmManager.getInstance().addUWBDataListener(this.mUwbDataListener);
    }

    private void removeUwbDataListener() {
        UwbIdmManager.getInstance().removeUWBDataListener(this.mUwbDataListener);
    }

    private void sendUwbData(Type type, byte[] bArr) {
        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus sendUwbData: " + TVUwbDataBuilder.byteArrToString(bArr));
        UwbIdmManager.getInstance().sendPayload(UwbApi.getInstance().getUwbDevice().getUwbAddress(), UwbDataGenerator.toPayload(this.mAppId, type, bArr, this.mTarget), UwbConst.Flag.NOT_ENCRYPT);
    }

    private void onSuccess(byte[] bArr) {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "onSuccess");
        if (this.mIsStart) {
            this.mIsStart = false;
            this.mHandler.removeMessages(4096);
            removeUwbDataListener();
            Bundle bundle = new Bundle();
            bundle.putByteArray("stranger_specific_key", bArr);
            AuthResultCallback authResultCallback = this.mAuthResultCallback;
            if (authResultCallback != null) {
                authResultCallback.onSuccess(bundle);
            }
            AuthResultCallback authResultCallback2 = sGlobalAuthResultCallback;
            if (authResultCallback2 != null) {
                authResultCallback2.onSuccess(bundle);
            }
        }
    }

    public static void setGlobalAuthResultCallback(AuthResultCallback authResultCallback) {
        UwbLogUtil.d("Mijia-UWB-StrangerReg", "setGlobalAuthResultCallback ".concat(String.valueOf(authResultCallback)));
        sGlobalAuthResultCallback = authResultCallback;
    }

    public void onFailed(int i) {
        LogType logType = LogType.LOG_UWB;
        UwbLogUtil.e(logType, "Mijia-UWB-StrangerReg", "onFailed: " + i + ",type=" + this.currentType);
        if (this.mIsStart) {
            this.mIsStart = false;
            this.mHandler.removeMessages(4096);
            removeUwbDataListener();
            AuthResultCallback authResultCallback = this.mAuthResultCallback;
            if (authResultCallback != null) {
                authResultCallback.onFailed(i);
            }
            AuthResultCallback authResultCallback2 = sGlobalAuthResultCallback;
            if (authResultCallback2 != null) {
                authResultCallback2.onFailed(i);
            }
        }
    }

    public void continueAuth() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "continueAuth");
        if (!this.mIsStart) {
            this.mIsStart = true;
            addUwbDataListener();
        }
    }

    private void sendStrangerRegisterCmd() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus sendStrangerRegisterCmd");
        this.mHandler.sendEmptyMessageDelayed(4096, (long) REGISTER_TIMEOUT);
        sendUwbData(Type.Register_P1_1, new byte[0]);
    }

    public void onReceiveDevPublicKey(byte[] bArr) {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus onReceiveDevPublicKey");
        if (bArr == null || bArr.length < 67) {
            onFailed(-4);
            return;
        }
        this.mProtocolVersion = bArr[0] & 15;
        this.mOobCapability = ((bArr[1] & 240) << 4) + ((bArr[1] & 15) << 4) + ((bArr[0] & 240) >> 4);
        UwbLogUtil.w("Mijia-UWB-StrangerReg", "protocol version = " + this.mProtocolVersion + ", oob capability = " + this.mOobCapability);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 1, 66);
        copyOfRange[0] = 4;
        try {
            this.mDevPubKey = fio.O000000o(copyOfRange, ((ECPublicKey) this.mAppKeyPair.getPublic()).getParams());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevPublicKey mDevPubKey=" + this.mDevPubKey);
        }
        if (bArr.length > 66) {
            byte b = bArr[66];
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevPublicKey timeout = ".concat(String.valueOf((int) b)));
            REGISTER_TIMEOUT = b * 1000;
            this.mHandler.removeMessages(4096);
            this.mHandler.sendEmptyMessageDelayed(4096, (long) REGISTER_TIMEOUT);
        }
        sendAppPublicKey();
        int i = this.mOobCapability;
        if (i == 1) {
            OobRequestCallback oobRequestCallback = this.mOobRequestCallback;
            if (oobRequestCallback != null) {
                oobRequestCallback.onRequestOob4DigitPin();
            }
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevPublicKey onRequestOob4DigitPin");
        } else if (i == 2) {
            OobRequestCallback oobRequestCallback2 = this.mOobRequestCallback;
            if (oobRequestCallback2 != null) {
                oobRequestCallback2.onRequestOobRanging1M();
            }
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevPublicKey onRequestOobRanging1M");
        } else if (i == 4) {
            OobRequestCallback oobRequestCallback3 = this.mOobRequestCallback;
            if (oobRequestCallback3 != null) {
                oobRequestCallback3.onRequestOobRanging2M();
            }
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevPublicKey onRequestOobRanging2M");
        }
    }

    public boolean set4DigitPinOob(String str) {
        if (this.mDevPubKey == null) {
            return false;
        }
        this.mOob = new byte[16];
        byte[] bytes = str.getBytes();
        System.arraycopy(bytes, 0, this.mOob, 0, bytes.length);
        this.mSessionKey = deriveSessionKey(fir.O000000o(this.mDevPubKey, this.mAppKeyPair.getPrivate()).getEncoded(), this.mOob);
        UwbLogUtil.w("Mijia-UWB-StrangerReg", "UwbLogUtilPlus mSessionKey: " + TVUwbDataBuilder.byteArrToString(this.mSessionKey) + " mOob: " + TVUwbDataBuilder.byteArrToString(this.mOob));
        byte[] aes128Encode = aes128Encode(this.mSessionKey, this.mAppRandom);
        if (aes128Encode.length > 16) {
            this.mAppConfirm = new byte[16];
            byte[] bArr = this.mAppConfirm;
            System.arraycopy(aes128Encode, 0, bArr, 0, bArr.length);
        } else {
            this.mAppConfirm = aes128Encode;
        }
        sendAppConfirm();
        return true;
    }

    private void sendAppPublicKey() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus sendAppPublicKey");
        byte[] O000000o2 = fir.O000000o(this.mAppKeyPair.getPublic());
        byte[] bArr = new byte[(O000000o2.length + this.mUidHash.length)];
        System.arraycopy(O000000o2, 0, bArr, 0, O000000o2.length);
        byte[] bArr2 = this.mUidHash;
        System.arraycopy(bArr2, 0, bArr, O000000o2.length, bArr2.length);
        sendUwbData(Type.Register_P1_2, bArr);
    }

    public void onReceiveDevConfirm(byte[] bArr) {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus onReceiveDevConfirm");
        this.mDevConfirm = bArr;
        this.mSessionKey = deriveSessionKey(fir.O000000o(this.mDevPubKey, this.mAppKeyPair.getPrivate()).getEncoded(), this.mOob);
        byte[] aes128Encode = aes128Encode(this.mSessionKey, this.mAppRandom);
        if (aes128Encode.length > 16) {
            this.mAppConfirm = new byte[16];
            byte[] bArr2 = this.mAppConfirm;
            System.arraycopy(aes128Encode, 0, bArr2, 0, bArr2.length);
        } else {
            this.mAppConfirm = aes128Encode;
        }
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveDevConfirm mAppConfirm=" + Arrays.toString(this.mAppConfirm) + ",mSessionKey=" + Arrays.toString(this.mSessionKey) + ",mDevConfirm=" + Arrays.toString(this.mDevConfirm));
        }
        byte[] bArr3 = this.mAppConfirm;
        if (bArr3 == null || bArr3.length == 0) {
            onFailed(-5);
        } else if (this.mOobCapability != 1) {
            sendAppConfirm();
        }
    }

    private void sendAppConfirm() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus sendAppConfirm");
        sendUwbData(Type.Register_P3, this.mAppConfirm);
    }

    public void onReceiveDevRandom(byte[] bArr) {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus onReceiveDevRandom");
        this.mDevRandom = bArr;
        byte[] aes128Encode = aes128Encode(this.mSessionKey, this.mDevRandom);
        if (aes128Encode.length > 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(aes128Encode, 0, bArr2, 0, 16);
            aes128Encode = bArr2;
        }
        if (ByteUtils.equals(aes128Encode, this.mDevConfirm)) {
            sendAppRandom();
            return;
        }
        sendAppRandom();
        onFailed(-6);
    }

    private void sendAppRandom() {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus sendAppRandom");
        sendUwbData(Type.Register_P4, this.mAppRandom);
    }

    public void onReceiveCipherKey(byte[] bArr) {
        UwbLogUtil.w(LogType.LOG_UWB, "Mijia-UWB-StrangerReg", "UwbLogUtilPlus onReceiveCipherKey");
        byte[] O00000Oo = fir.O00000Oo(this.mSessionKey, Arrays.copyOfRange(this.mDevRandom, 0, 12), bArr);
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-StrangerReg", "onReceiveCipherKey strangerSpecificKey=" + ByteUtils.toHexString(O00000Oo));
        }
        if (O00000Oo == null || O00000Oo.length <= 0) {
            onFailed(-7);
        } else {
            onSuccess(O00000Oo);
        }
    }

    private byte[] deriveSessionKey(byte[] bArr, byte[] bArr2) {
        try {
            fip O000000o2 = fip.O000000o("HmacSHA256");
            O000000o2.O000000o(bArr, bArr2);
            return O000000o2.O000000o("".getBytes(), 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private byte[] generateRandom() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private byte[] getSHA2Digest(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] aes128Encode(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvalidAlgorithmParameterException e4) {
            e4.printStackTrace();
            return null;
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            return null;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            return null;
        }
    }
}
