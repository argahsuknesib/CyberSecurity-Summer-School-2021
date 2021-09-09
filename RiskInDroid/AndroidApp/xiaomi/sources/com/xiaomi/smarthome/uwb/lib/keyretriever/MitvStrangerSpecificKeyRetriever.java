package com.xiaomi.smarthome.uwb.lib.keyretriever;

import _m_j.bxa;
import _m_j.bxc;
import _m_j.bxe;
import _m_j.bxl;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.idm.UwbDataListener;
import com.xiaomi.smarthome.uwb.lib.idm.UwbIdmManager;
import com.xiaomi.smarthome.uwb.lib.processor.engine.KeyRetrieverListener;
import com.xiaomi.smarthome.uwb.lib.protocol.UwbDataGenerator;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class MitvStrangerSpecificKeyRetriever extends BaseMitvSpecificKeyRetriever {
    public UwbScanDevice device;
    public KeyRetrieverListener keyRetrieverListener;
    public String tvKey;
    public String uid;
    public boolean useCache;
    public UwbDataListener uwbDataListener = new UwbDataListener() {
        /* class com.xiaomi.smarthome.uwb.lib.keyretriever.MitvStrangerSpecificKeyRetriever.AnonymousClass1 */

        public void onConnectionState(String str, int i) {
        }

        public void onSendPayload(int i) {
        }

        public void onPayloadReceived(Payload payload) {
            if (TextUtils.isEmpty(MitvStrangerSpecificKeyRetriever.this.tvKey) && payload != null) {
                MitvStrangerSpecificKeyRetriever.this.onMitvDidRetrieved(payload);
            }
        }
    };

    public void clearCacheKey(UwbScanDevice uwbScanDevice) {
    }

    public void startKeyRetrieve() {
    }

    public void startRetrieveSpecificKey(UwbScanDevice uwbScanDevice, KeyRetrieverListener keyRetrieverListener2, boolean z) {
        UwbIdmManager.getInstance().addUWBDataListener(this.uwbDataListener);
        this.device = uwbScanDevice;
        this.keyRetrieverListener = keyRetrieverListener2;
        this.useCache = z;
        if (TextUtils.isEmpty(this.tvKey)) {
            retrieveMitvDid();
        } else {
            startKeyRetrieve();
        }
    }

    public void destroy() {
        release();
    }

    public void retrieveMitvDid() {
        UwbLogUtil.e("Mijia-UWB-timestamp", "retrieveMitvDid start");
        UwbLogUtil.d("Mijia-UWB-MitvStrangerKeyRetriever", "retrieveMitvDid");
        Payload generateMitvDidCmdPlayload = UwbDataGenerator.generateMitvDidCmdPlayload();
        if (UwbSdk.getSdkConfig().getLogLevel() <= 3) {
            StringBuilder sb = new StringBuilder("UwbLogUtilPlus retrieveMitvDid ");
            sb.append(generateMitvDidCmdPlayload == null ? null : generateMitvDidCmdPlayload.toString());
            UwbLogUtil.w("Mijia-UWB-MitvStrangerKeyRetriever", sb.toString());
        }
        this.mHandler.sendEmptyMessageDelayed(4096, (long) MITV_DEFAULT_TIMEOUT);
        UwbIdmManager.getInstance().sendPayload(this.device.getUwbAddress(), generateMitvDidCmdPlayload, UwbConst.Flag.NOT_ENCRYPT);
    }

    public void setMitvDid(String str, String str2) {
        DidInfo didInfo = this.device.getDidInfo();
        if (didInfo == null) {
            didInfo = new DidInfo();
            this.device.setDidInfo(didInfo);
        }
        didInfo.setPlainDid(str2);
        this.tvKey = str;
    }

    @SuppressLint({"LongLogTag"})
    public void onMitvDidRetrieved(Payload payload) {
        if (TextUtils.isEmpty(this.tvKey)) {
            UwbLogUtil.e("Mijia-UWB-timestamp", "onMitvDidRetrieved start");
            if (payload != null) {
                bxe.O000000o(new String(payload.getData()), new bxa() {
                    /* class com.xiaomi.smarthome.uwb.lib.keyretriever.MitvStrangerSpecificKeyRetriever.AnonymousClass2 */

                    public void onSuccess(bxc bxc) {
                        UwbLogUtil.d("Mijia-UWB-MitvStrangerKeyRetriever", "UwbLogUtilPlus onMitvDidRetrieved onSuccess");
                        bxl bxl = bxc.O00000Oo;
                        String O000000o2 = bxl.O000000o("tvKey");
                        String O000000o3 = bxl.O000000o("partnerId");
                        UwbLogUtil.w("stranger", "UwbLogUtilPlus onMitvDidRetrieved tvKey: " + O000000o2 + " partnerIdHash: " + O000000o3);
                        if (!TextUtils.isEmpty(O000000o2)) {
                            MitvStrangerSpecificKeyRetriever.this.mHandler.removeMessages(4096);
                            MitvStrangerSpecificKeyRetriever.this.setMitvDid(O000000o2, O000000o3);
                            MitvStrangerSpecificKeyRetriever.this.startKeyRetrieve();
                        } else if (bxl.O000000o() == "onError" && TextUtils.equals(bxl.O000000o("code"), "701")) {
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                /* class com.xiaomi.smarthome.uwb.lib.keyretriever.MitvStrangerSpecificKeyRetriever.AnonymousClass2.AnonymousClass1 */

                                public void run() {
                                    Toast.makeText(UwbSdk.getApplication(), UwbSdk.getApplication().getText(R.string.mj_uwb_connect_fail), 1).show();
                                }
                            });
                            MitvStrangerSpecificKeyRetriever.this.release();
                        }
                    }

                    public void onFailed(int i, String str) {
                        UwbLogUtil.d("Mijia-UWB-MitvStrangerKeyRetriever", "UwbLogUtilPlus onMitvDidRetrieved onFailed " + i + "," + str);
                        if (i != -702) {
                            MitvStrangerSpecificKeyRetriever.this.keyRetrieverListener.onError(i, str);
                            MitvStrangerSpecificKeyRetriever.this.release();
                        }
                    }
                });
            }
        }
    }

    public void release() {
        this.mHandler.removeMessages(4096);
        UwbIdmManager.getInstance().removeUWBDataListener(this.uwbDataListener);
    }
}
