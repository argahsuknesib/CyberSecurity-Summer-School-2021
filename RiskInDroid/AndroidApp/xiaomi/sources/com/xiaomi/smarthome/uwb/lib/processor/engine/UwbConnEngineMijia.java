package com.xiaomi.smarthome.uwb.lib.processor.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.idm.uwb.IDMUwb;
import com.xiaomi.idm.uwb.IDMUwbDevice;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.idm.uwb.constant.UwbResultCode;
import com.xiaomi.smarthome.uwb.lib.UwbApi;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConEngine;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.UwbDeviceUtil;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import java.util.List;

public class UwbConnEngineMijia implements UwbConEngine {
    private static volatile UwbConnEngineMijia sInstance;
    private boolean isRetryRetrieveKey = false;
    private String key;
    public final IEngineSpecificKeyRetriever keyRetriever;
    public volatile boolean mConnBroken = false;
    private IDMUwb.UwbCallback mDelegateCallback = new IDMUwb.UwbCallback() {
        /* class com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia.AnonymousClass2 */

        public void onPayloadReceived(String str, IDMUwb.Payload payload) {
        }

        public void onSendPayload(UwbResultCode uwbResultCode, int i) {
        }

        public void onSetServerSecurityKey(UwbResultCode uwbResultCode) {
        }

        public void onTagOTA(UwbResultCode uwbResultCode, int i) {
        }

        public void onTagPluggedIn() {
        }

        public void onTagUnplugged() {
        }

        public void onMiConnectConnectionState(UwbResultCode uwbResultCode) {
            if (uwbResultCode == null) {
                UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onMiConnectConnectionState error null");
                return;
            }
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onMiConnectConnectionState:".concat(String.valueOf(uwbResultCode)));
            if (UwbConnEngineMijia.isResultCodeSuccess(uwbResultCode)) {
                UwbLogUtil.e("Mijia-UWB-timestamp", "UwbIdmManager inited");
                boolean isUsingEncrypt = UwbSdk.isUsingEncrypt();
                UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onMiConnectConnectionState needEncrypt: ".concat(String.valueOf(isUsingEncrypt)));
                if (UwbConnEngineMijia.this.mState < 15 || UwbConnEngineMijia.this.mStateError) {
                    UwbConnEngineMijia.this.mHandler.removeMessages(15);
                    UwbConnEngineMijia.this.mHandler.sendEmptyMessage(15);
                    if (!isUsingEncrypt && UwbConnEngineMijia.this.mIEngineCallback != null) {
                        UwbConnEngineMijia.this.mIEngineCallback.onConnEstablished();
                        return;
                    }
                    return;
                }
                UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onMiConnectConnectionState no need send message mState:" + UwbConnEngineMijia.this.mState);
                return;
            }
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onMiConnectConnectionState error:" + uwbResultCode.getCode() + "," + uwbResultCode.getMsg());
            UwbConnEngineMijia uwbConnEngineMijia = UwbConnEngineMijia.this;
            uwbConnEngineMijia.mStateError = true;
            if (uwbConnEngineMijia.mIEngineCallback != null) {
                UwbConnEngineMijia.this.mIEngineCallback.onConnectionError(uwbResultCode.getCode(), "onMiConnectConnectionState error");
            }
        }

        public void onScanState(UwbResultCode uwbResultCode) {
            if (uwbResultCode != null && uwbResultCode.getCode() == UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE.getCode() && UwbConnEngineMijia.this.mIEngineCallback != null) {
                UwbConnEngineMijia.this.mIEngineCallback.onConnectionError(-1021, "onScanState ".concat(String.valueOf(uwbResultCode)));
            }
        }

        public void onScanning(List<IDMUwbDevice> list) {
            if (UwbConnEngineMijia.this.mState == 16) {
                UwbConnEngineMijia.this.mState = 17;
                UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onScanning: will startConnect");
                UwbConnEngineMijia.this.startConnect();
            }
        }

        public void onConnectionState(String str, UwbResultCode uwbResultCode) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus onConnectionState s: ".concat(String.valueOf(str)));
            if (uwbResultCode == null) {
                UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onConnectionState error null");
                return;
            }
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onConnectionState:" + uwbResultCode + ",mState=" + UwbConnEngineMijia.this.mState);
            if (!UwbConnEngineMijia.isResultCodeSuccess(uwbResultCode) && uwbResultCode.getCode() != UwbResultCode.CONNECTED.getCode()) {
                String str2 = uwbResultCode.getCode() + "," + uwbResultCode.getMsg();
                UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onConnectionState error:".concat(String.valueOf(str2)));
                UwbConnEngineMijia uwbConnEngineMijia = UwbConnEngineMijia.this;
                uwbConnEngineMijia.mConnBroken = true;
                if (uwbConnEngineMijia.mIEngineCallback != null) {
                    UwbConnEngineMijia.this.mIEngineCallback.onConnectionError(uwbResultCode.getCode(), "onConnectionState error:".concat(String.valueOf(str2)));
                }
                if (UwbSdk.getSdkConfig().getLogLevel() <= 3 && uwbResultCode.getCode() == UwbResultCode.MI_CONNECT_SERVICE_NOT_AVAILABLE.getCode()) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onConnectionState: !!!!MiConnectService Not Available");
                            Toast.makeText(UwbSdk.getApplication(), "MiConnectService Not Available!!!", 1).show();
                        }
                    });
                }
            } else if (UwbConnEngineMijia.this.mState <= 30 || UwbConnEngineMijia.this.mStateError) {
                UwbLogUtil.e("Mijia-UWB-timestamp", "UwbIdmManager connected");
                UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onConnectionState sendEmptyMessage:30");
                UwbConnEngineMijia.this.mHandler.removeMessages(30);
                UwbConnEngineMijia.this.mHandler.sendEmptyMessage(30);
            } else {
                UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "onConnectionState state already is STATE_CONNECTED, no need call again");
            }
        }

        public void onEstablishSecurityLine(UwbResultCode uwbResultCode) {
            UwbLogUtil.e("Mijia-UWB-timestamp", "onEstablishSecurityLine finished");
            if (uwbResultCode == null) {
                UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onEstablishSecurityLine error null");
                return;
            }
            UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "UwbLogUtilPlus onEstablishSecurityLine:".concat(String.valueOf(uwbResultCode)));
            if (UwbConnEngineMijia.isResultCodeSuccess(uwbResultCode)) {
                UwbConnEngineMijia.this.switchCommunicationType();
                UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "UwbLogUtilPlus isResultCodeSuccess");
                UwbConnEngineMijia uwbConnEngineMijia = UwbConnEngineMijia.this;
                uwbConnEngineMijia.mStateError = false;
                uwbConnEngineMijia.mState = 80;
                if (uwbConnEngineMijia.mIEngineCallback != null) {
                    UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "UwbLogUtilPlus mIEngineCallback.onConnEstablished()");
                    UwbConnEngineMijia.this.mIEngineCallback.onConnEstablished();
                }
                UwbConnEngineMijia.this.onSecurityLineEstablished();
                UwbConnEngineMijia.this.mHandler.sendEmptyMessage(80);
                return;
            }
            String str = uwbResultCode.getCode() + "," + uwbResultCode.getMsg();
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "onEstablishSecurityLine error:".concat(String.valueOf(str)));
            UwbConnEngineMijia uwbConnEngineMijia2 = UwbConnEngineMijia.this;
            uwbConnEngineMijia2.mStateError = true;
            if (uwbConnEngineMijia2.keyRetriever != null) {
                UwbConnEngineMijia.this.keyRetriever.clearCacheKey(UwbConnEngineMijia.this.mUwbScanDevice);
                if (UwbConnEngineMijia.this.shouldRetryRetrieveKey()) {
                    UwbConnEngineMijia.this.doWorkAfterConnected(false);
                } else if (UwbConnEngineMijia.this.mIEngineCallback != null) {
                    UwbConnEngineMijia.this.mIEngineCallback.onEstablishSecurityError(uwbResultCode.getCode(), "onEstablishSecurityLine fail:".concat(String.valueOf(str)));
                }
            } else if (UwbConnEngineMijia.this.mIEngineCallback != null) {
                UwbConnEngineMijia.this.mIEngineCallback.onEstablishSecurityError(uwbResultCode.getCode(), "onEstablishSecurityLine fail:".concat(String.valueOf(str)));
            }
        }

        public void onSwitchCommunicationType(UwbResultCode uwbResultCode) {
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onSwitchCommunicationType ".concat(String.valueOf(uwbResultCode)));
            if (UwbConnEngineMijia.this.mIEngineCallback != null) {
                UwbConnEngineMijia.this.mIEngineCallback.onSwitchCommunication(UwbConnEngineMijia.isResultCodeSuccess(uwbResultCode) ? 0 : uwbResultCode.getCode(), uwbResultCode.getMsg());
            }
        }
    };
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        /* class com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia.AnonymousClass1 */

        public void handleMessage(Message message) {
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "UwbConnEngineMijia handler: " + message.what + ",mState=" + UwbConnEngineMijia.this.mState);
            if (UwbConnEngineMijia.this.mState != message.what) {
                if (message.what == -999999980) {
                    UwbConnEngineMijia.this.test();
                    return;
                }
                UwbConnEngineMijia.this.mState = message.what;
                int i = message.what;
                if (i == 15) {
                    UwbConnEngineMijia.this.startConnect();
                } else if (i == 30) {
                    UwbConnEngineMijia.this.doWorkAfterConnected(true);
                } else if (i == 70) {
                    UwbConnEngineMijia.this.establishSecurityLine(String.valueOf(message.obj), message.arg1, UwbConnEngineMijia.this.uid);
                }
            }
        }
    };
    public UwbConEngine.IEngineStateCallback mIEngineCallback;
    private boolean mNeedBindIotDevice = true;
    public volatile int mState = 0;
    public volatile boolean mStateError = false;
    public final UwbScanDevice mUwbScanDevice;
    private int type;
    public String uid;

    public void onDeviceBinded() {
    }

    public void test() {
        UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "handleIotDeviceType send test payload");
        UwbApi.getInstance().sendPayload(UwbConst.AppId.TAG, Type.JSON, "{\"id\":321123321,\"method\":\"set_properties\",\"params\":[{\"piid\":1,\"siid\":2,\"value\":true,\"did\":\"338480322\"}]}", UwbConst.Target.SEND_DATA_TO_BOUND_DEVICE);
    }

    public UwbConnEngineMijia(UwbScanDevice uwbScanDevice, UwbConEngine.IEngineStateCallback iEngineStateCallback, IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever) {
        this.keyRetriever = iEngineSpecificKeyRetriever;
        this.mUwbScanDevice = uwbScanDevice;
        this.mIEngineCallback = iEngineStateCallback;
    }

    public void destroy(boolean z) {
        this.mState = 90;
        this.mHandler.removeCallbacksAndMessages(null);
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "destroy stopScan=".concat(String.valueOf(z)));
        this.mIEngineCallback = null;
        IEngineSpecificKeyRetriever iEngineSpecificKeyRetriever = this.keyRetriever;
        if (iEngineSpecificKeyRetriever != null) {
            iEngineSpecificKeyRetriever.destroy();
        }
        UwbIdmManager.getInstance().removeDelegateCallback(this.mDelegateCallback);
        UwbIdmManager.getInstance().disconnect(this.mUwbScanDevice.getUwbAddress());
        if (z) {
            UwbIdmManager.getInstance().stopScan();
        }
    }

    public boolean isDestroyed() {
        return this.mState == 90;
    }

    public boolean isSameUwbAddress(UwbScanDevice uwbScanDevice) {
        if (uwbScanDevice == null || this.mUwbScanDevice == null) {
            return false;
        }
        return TextUtils.equals(uwbScanDevice.getUwbAddress(), this.mUwbScanDevice.getUwbAddress());
    }

    public boolean isUwbSetup() {
        if (UwbSdk.getSdkConfig().getLogLevel() >= 3) {
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "isUwbSetup + mState=" + this.mState + ",mStateError=" + this.mStateError + ",mConnBroken=" + this.mConnBroken);
        }
        return this.mState == 80 && !this.mStateError && !this.mConnBroken;
    }

    public int sendPayload(Payload payload) {
        boolean isUsingEncrypt = UwbSdk.isUsingEncrypt();
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "sendPayload mState=" + this.mState + ",needEncrypt=" + isUsingEncrypt);
        if (!isUsingEncrypt || this.mState == 80) {
            UwbIdmManager.getInstance().sendPayload(this.mUwbScanDevice.getUwbAddress(), payload, isUsingEncrypt ? UwbConst.Flag.ENCRYPT : UwbConst.Flag.NOT_ENCRYPT);
            return 0;
        }
        UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "UwbLogUtilPlus cannot send payload when connection not established: " + this.mState);
        return -1;
    }

    public int sendPayload(Payload payload, boolean z) {
        UwbIdmManager.getInstance().sendPayload(this.mUwbScanDevice.getUwbAddress(), payload, z ? UwbConst.Flag.ENCRYPT : UwbConst.Flag.NOT_ENCRYPT);
        return 0;
    }

    public static boolean isResultCodeSuccess(UwbResultCode uwbResultCode) {
        if (uwbResultCode == null) {
            return false;
        }
        return uwbResultCode.getCode() == UwbResultCode.GENERAL_SUCCESS.getCode() || uwbResultCode.getCode() == UwbResultCode.DEFAULT_SUCCESS.getCode() || uwbResultCode.getCode() == UwbResultCode.UWB_LOGIN_SUCCESS.getCode();
    }

    public boolean shouldRetryRetrieveKey() {
        if (this.isRetryRetrieveKey) {
            return false;
        }
        this.isRetryRetrieveKey = true;
        return true;
    }

    public void setupUwb() {
        if (this.mUwbScanDevice == null || this.mState != 0) {
            UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "createConnection no need to create: mState=" + this.mState);
            return;
        }
        this.mStateError = false;
        UwbIdmManager.getInstance().addDelegateCallback(this.mDelegateCallback);
        this.mState = 10;
        UwbLogUtil.e("Mijia-UWB-timestamp", "create UwbIdmManager");
        UwbIdmManager.getInstance().init(UwbSdk.getApplication());
    }

    public void switchCommunicationType() {
        if (this.mUwbScanDevice == null) {
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "cannot switchCommunicationType when no mUwbScanDevice");
        } else {
            UwbIdmManager.getInstance().switchCommunicationType(this.mUwbScanDevice.getUwbAddress());
        }
    }

    public void onSecurityLineEstablished() {
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "onSecurityLineEstablished " + this.mState);
    }

    private void startScan() {
        UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus startScan in engine");
        if (!UwbIdmManager.getInstance().isScanning() && this.mState != 16) {
            UwbLogUtil.w("UwbLogUtilPlus", "UwbLogUtilPlus startScan in engine real startScan");
            this.mState = 16;
            UwbIdmManager.getInstance().startScan(1000, this.mUwbScanDevice.getUwbAddress());
        }
    }

    public void startConnect() {
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "startConnect in mState=" + this.mState + ",mStateError=" + this.mStateError);
        if (this.mState < 20 || this.mStateError) {
            this.mStateError = false;
            if (!UwbDeviceUtil.isLogin(this.mUwbScanDevice) && !UwbDeviceUtil.isBuiltinMitvDeviceType(this.mUwbScanDevice) && !UwbDeviceUtil.isMitvDeviceTagType(this.mUwbScanDevice)) {
                UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "uwb device that needs binding cannot connect. Connecting blocks the ble device finding " + this.mUwbScanDevice.getAccountInfo());
            } else if (this.mState > 30 && !this.mStateError) {
                UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "no need startConnect because mState=" + this.mState + ",mStateError=" + this.mStateError);
            } else if (!UwbIdmManager.getInstance().isScanning()) {
                UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "UwbLogUtilPlus startScan !!!!!: " + UwbIdmManager.getInstance().isScanning());
                startScan();
            } else {
                this.mState = 20;
                UwbLogUtil.e("Mijia-UWB-timestamp", "UwbIdmManager start connect");
                UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "startConnect really");
                UwbIdmManager.getInstance().connect(this.mUwbScanDevice.getUwbAddress());
            }
        } else {
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "startConnect mState is not STATE_INITED:" + this.mState);
        }
    }

    public void setNeedBindIotDevice(boolean z) {
        this.mNeedBindIotDevice = z;
    }

    public void doWorkAfterConnected(boolean z) {
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "doWorkAfterConnected");
        if (this.mState < 60 || this.mStateError) {
            this.mStateError = false;
            this.mState = 60;
            this.keyRetriever.startRetrieveSpecificKey(this.mUwbScanDevice, new KeyRetrieverListener() {
                /* class com.xiaomi.smarthome.uwb.lib.processor.engine.UwbConnEngineMijia.AnonymousClass3 */

                public void onSuccess(String str, int i, String str2) {
                    UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "doWorkAfterConnected retrieve key success");
                    UwbConnEngineMijia uwbConnEngineMijia = UwbConnEngineMijia.this;
                    uwbConnEngineMijia.mStateError = false;
                    uwbConnEngineMijia.uid = str2;
                    uwbConnEngineMijia.establishSecurityLine(str, i, str2);
                }

                public void onError(int i, String str) {
                    UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "doWorkAfterConnected retrieve key onError " + i + "," + str);
                    UwbConnEngineMijia uwbConnEngineMijia = UwbConnEngineMijia.this;
                    uwbConnEngineMijia.mStateError = true;
                    if (uwbConnEngineMijia.mIEngineCallback != null) {
                        UwbConnEngineMijia.this.mIEngineCallback.onEstablishSecurityError(i, "get key error");
                    }
                }
            }, z);
            return;
        }
        UwbLogUtil.w("Mijia-UWB-UwbConnEngineMijia", "no need doWorkAfterConnected: mState=" + this.mState);
    }

    public void reSetup() {
        if (this.mState == 0) {
            return;
        }
        if (this.mState == 20) {
            startConnect();
        } else if (this.mState == 30) {
            doWorkAfterConnected(true);
        } else if (this.mState == 60) {
            doWorkAfterConnected(true);
        } else if (this.mState == 70) {
            establishSecurityLine(this.key, this.type, this.uid);
        }
    }

    public void establishSecurityLine(String str, int i, String str2) {
        UwbLogUtil.e("Mijia-UWB-timestamp", "establishSecurityLine start mState=" + this.mState + ",mStateError=" + this.mStateError);
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "establishSecurityLine " + str + ",type=" + i);
        this.key = str;
        this.type = i;
        this.uid = str2;
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "establishSecurityLine " + str + ",type=" + i + ",uid=" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "establishSecurityLine:key cannot be null");
        } else if ((this.mState == 70 || this.mState == 80) && !this.mStateError) {
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "establishSecurityLine ongoing, no need call again");
        } else {
            this.mStateError = false;
            this.mState = 70;
            byte[] uwbHash3B = UwbDeviceUtil.getUwbHash3B(str2);
            UwbLogUtil.e("Mijia-UWB-UwbConnEngineMijia", "establishSecurityLine will start mState=" + this.mState + ",mStateError=" + this.mStateError);
            UwbIdmManager.getInstance().establishSecurityLine(UwbDeviceUtil.getEstablishSecurityLineAppId(this.mUwbScanDevice), this.mUwbScanDevice.getUwbAddress(), str, uwbHash3B, i == 0 ? UwbConst.LoginType.MEMBER_LOGIN : UwbConst.LoginType.STRANGER_LOGIN);
        }
    }

    public void retrieveKey() {
        UwbLogUtil.d("Mijia-UWB-UwbConnEngineMijia", "retrieveKey");
        doWorkAfterConnected(true);
    }

    public UwbScanDevice getUwbDevice() {
        return this.mUwbScanDevice;
    }

    public boolean isUwbAvailable() {
        return UwbIdmManager.getInstance().isUwbValid();
    }

    public int getState() {
        return this.mState;
    }

    public boolean isStateError() {
        return this.mStateError;
    }
}
