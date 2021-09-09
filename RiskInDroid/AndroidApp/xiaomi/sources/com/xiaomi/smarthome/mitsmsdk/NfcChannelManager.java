package com.xiaomi.smarthome.mitsmsdk;

import _m_j.fmd;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gfr;
import _m_j.gnl;
import _m_j.gpy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hxi;
import _m_j.hxt;
import _m_j.ibh;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.com.xm.bt.profile.nfc.ApduResponse;
import cn.com.xm.bt.profile.nfc.HMAccessInfo;
import cn.com.xm.bt.profile.nfc.HMAidInfo;
import cn.com.xm.bt.sdk.HMBleDevice;
import cn.com.xm.bt.sdk.IDeviceCallback;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.miui.tsmclient.Facade;
import com.miui.tsmclient.entity.CardInfo;
import com.miui.tsmclient.entity.CardInfoFactory;
import com.miui.tsmclient.entity.CardInfoManager;
import com.miui.tsmclient.entity.MifareCardInfo;
import com.miui.tsmclient.model.BaseResponse;
import com.miui.tsmclient.sesdk.MiPayService;
import com.miui.tsmclient.util.EnvironmentConfig;
import com.miui.tsmclient.util.LogUtils;
import com.miui.tsmclient.util.a;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class NfcChannelManager {
    public static List<String> UNSUPPORT_CLOUD_SIGN_MODELS = Arrays.asList("XMSH06HM");
    public static List<CardInfo> mCardList = new ArrayList();
    public static boolean mIsAuthStart;
    private static List<String> mLockModels;
    private static volatile NfcChannelManager sInstance;
    private static Object sLock = new Object();
    boolean block;
    public CountDownLatch countDownLatch;
    public int mAuthStatus;
    public int mCONNStatus = 3;
    public String mCloudSignature = "";
    public Context mContext;
    private String mDid;
    public Facade mFacade;
    public HMBleDevice mHMBleDevice;
    public boolean mHasBeenAuthOK;
    public boolean mIsPaired;
    public boolean mIsUserHasLock;
    private MiPayService mMiPayService;
    public int mMijiaActiveCardNum;
    public int mMijiaCardNum;
    public String mModel;
    public String mServiceToken;
    private CompositeSubscription mSubscriptions;
    public String mUid;

    static {
        ArrayList arrayList = new ArrayList();
        mLockModels = arrayList;
        arrayList.add("lumi.lock.mcn01");
        mLockModels.add("loock.lock.v5");
    }

    public static NfcChannelManager getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new NfcChannelManager();
                }
            }
        }
        return sInstance;
    }

    private NfcChannelManager() {
    }

    public boolean isBand3Nfc() {
        return "XMSH06HM".equals(this.mModel);
    }

    public void init(Context context, String str, String str2, Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager init");
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            callback.onFailure(-1, "init meets params error!");
            return;
        }
        this.mContext = context;
        this.mFacade = Facade.getFacade(this.mContext);
        this.mMiPayService = new MiPayService();
        this.mCONNStatus = 3;
        this.mAuthStatus = -100;
        this.mModel = str;
        this.mDid = str2;
        this.mSubscriptions = new CompositeSubscription();
        EnvironmentConfig.initialize(CommonApplication.getAppContext());
        MiPayService.setChannel(new ChannelImpl(this.mContext));
        MiPayService.setDeviceInfo(new DeviceInfoImpl());
        MiPayService.setMiOAuth(new MiOAuthImpl(this.mContext));
        MiPayService.setStaging(false);
        this.mUid = CoreApi.O000000o().O0000o0();
        this.mHasBeenAuthOK = false;
        checkUserHasLock();
        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("tsm-auth");
        if (O000000o2 != null) {
            this.mServiceToken = O000000o2.O00000o0 + "," + O000000o2.O00000o;
            callback.onSuccess(Boolean.TRUE);
            return;
        }
        updateServiceToken(callback);
    }

    private void checkUserHasLock() {
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            if (mLockModels.contains(((Device) value.getValue()).model)) {
                this.mIsUserHasLock = true;
            }
        }
    }

    public void updateServiceToken(final Callback<Boolean> callback) {
        gtx O000000o2 = gty.O000000o();
        if (O000000o2 != null) {
            O000000o2.refreshServiceToken("tsm-auth", new ibh<MiServiceTokenInfo, Error>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass1 */

                public void onSuccess(MiServiceTokenInfo miServiceTokenInfo) {
                    if (miServiceTokenInfo == null) {
                        LogUtils.e("get no serviceToken!");
                        callback.onFailure(-2, "get no serviceToken!");
                        return;
                    }
                    NfcChannelManager nfcChannelManager = NfcChannelManager.this;
                    nfcChannelManager.mServiceToken = miServiceTokenInfo.O00000o0 + "," + miServiceTokenInfo.O00000o;
                    MiServiceTokenInfo miServiceTokenInfo2 = new MiServiceTokenInfo();
                    miServiceTokenInfo2.O00000oo = miServiceTokenInfo.O00000oo;
                    miServiceTokenInfo2.O00000Oo = miServiceTokenInfo.O00000Oo;
                    miServiceTokenInfo2.O00000o0 = miServiceTokenInfo.O00000o0;
                    miServiceTokenInfo2.f12086O000000o = miServiceTokenInfo.f12086O000000o;
                    miServiceTokenInfo2.O00000o = miServiceTokenInfo.O00000o;
                    miServiceTokenInfo2.O00000oO = miServiceTokenInfo.O00000oO;
                    CoreApi.O000000o().O0000oOo().O000000o(miServiceTokenInfo2);
                    callback.onSuccess(Boolean.TRUE);
                }

                public void onFailure(Error error) {
                    LogUtils.e("refresh servicetoken failed!");
                    callback.onFailure(-2, "get SID_TSM_AUTH serviceToken failed!");
                }
            });
        }
    }

    public void connectBand(final String str, final Callback<Integer> callback) {
        LogUtils.d("NfcChannelManager connectBracelet");
        if (this.mContext == null || TextUtils.isEmpty(str)) {
            callback.onFailure(-1, "connectBracelet meets params error!");
            return;
        }
        HMBleDevice hMBleDevice = this.mHMBleDevice;
        if (hMBleDevice != null) {
            try {
                hMBleDevice.disconnect();
            } catch (Exception unused) {
            }
        }
        this.countDownLatch = new CountDownLatch(1);
        if (!gfr.O0000OOo) {
            HMBleDevice.enableLog(false);
        }
        this.mIsPaired = false;
        this.mHasBeenAuthOK = false;
        this.mAuthStatus = -100;
        this.mCloudSignature = gpy.O00000o0(CommonApplication.getAppContext(), "sp_nfc_band4", "band_cloud_signature", "");
        LogUtils.d("HMBleDevice CloudSignature = " + this.mCloudSignature);
        if (TextUtils.isEmpty(this.mCloudSignature)) {
            LogUtils.d("need bind!");
            this.mIsPaired = true;
        }
        if (!gnl.O00000Oo()) {
            fmd.O000000o(new BleResponse() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass2 */

                public void onResponse(int i, Object obj) {
                    if (i == 0) {
                        NfcChannelManager nfcChannelManager = NfcChannelManager.this;
                        nfcChannelManager.connect(nfcChannelManager.mIsPaired, str, callback);
                    }
                }
            });
        } else {
            connect(this.mIsPaired, str, callback);
        }
    }

    /* access modifiers changed from: package-private */
    public void saveKey(String str) {
        if (UNSUPPORT_CLOUD_SIGN_MODELS.contains(this.mModel)) {
            gpy.O000000o(CommonApplication.getAppContext(), "sp_nfc_band4", "band_local_signature", str);
        } else {
            gpy.O000000o(CommonApplication.getAppContext(), "sp_nfc_band4", "band_cloud_signature", str);
        }
    }

    public void connect(final boolean z, final String str, final Callback<Integer> callback) {
        LogUtils.d("NfcChannelManager connect");
        this.mSubscriptions.add(Observable.fromCallable(new Callable<Boolean>() {
            /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass4 */

            /* JADX WARNING: Can't wrap try/catch for region: R(5:20|(2:22|23)|24|25|26) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00d0 */
            public Boolean call() throws Exception {
                NfcChannelManager nfcChannelManager = NfcChannelManager.this;
                nfcChannelManager.mHMBleDevice = new HMBleDevice(nfcChannelManager.mContext, str);
                NfcChannelManager.this.mHMBleDevice.setPair(z);
                NfcChannelManager.this.mHMBleDevice.setAutoConnect(false);
                if (NfcChannelManager.UNSUPPORT_CLOUD_SIGN_MODELS.contains(NfcChannelManager.this.mModel)) {
                    String O00000o0 = gpy.O00000o0(CommonApplication.getAppContext(), "sp_nfc_band4", "band_local_signature", "");
                    if (TextUtils.isEmpty(O00000o0)) {
                        O00000o0 = UUID.randomUUID().toString();
                        NfcChannelManager.this.mHMBleDevice.setPair(true);
                    } else {
                        NfcChannelManager.this.mHMBleDevice.setPair(false);
                    }
                    LogUtils.d("NfcChannelManager", "HMBleDevice read local  key=".concat(String.valueOf(O00000o0)));
                    NfcChannelManager.this.mHMBleDevice.setKey(O00000o0);
                } else if (!z) {
                    NfcChannelManager.this.mHMBleDevice.setKey(NfcChannelManager.this.mCloudSignature);
                }
                NfcChannelManager.mIsAuthStart = true;
                NfcChannelManager.this.mHMBleDevice.connect(new IDeviceCallback() {
                    /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass4.AnonymousClass1 */

                    public void onAuthStateChanged(int i, int i2) {
                        LogUtils.d("NfcChannelManager", "onAuthStateChanged ,state=" + i + ",errorCode=" + i2);
                        NfcChannelManager.this.mAuthStatus = i;
                        if (i == 2) {
                            LogUtils.d("NfcChannelManager", "HMBleDevice.AUTH_STATE_KNOCK");
                            callback.onSuccess(2);
                        } else if (i == 3) {
                            LogUtils.d("NfcChannelManager", "HMBleDevice.AUTH_STATE_KNOCK_SUCCESS");
                            callback.onSuccess(3);
                        } else if (i == 4) {
                            LogUtils.e("HMBleDevice.AUTH_STATE_DENY!");
                            NfcChannelManager.this.mHasBeenAuthOK = false;
                            NfcChannelManager.this.countDownLatch.countDown();
                        } else if (i == 1 && i2 == 5) {
                            LogUtils.e("HMBleDevice.AUTH_ERROR_KEY_ERROR!");
                            if (NfcChannelManager.this.mHMBleDevice != null) {
                                try {
                                    NfcChannelManager.this.mHMBleDevice.disconnect();
                                } catch (Exception unused) {
                                }
                            }
                            if (NfcChannelManager.UNSUPPORT_CLOUD_SIGN_MODELS.contains(NfcChannelManager.this.mModel)) {
                                gpy.O00000Oo(CommonApplication.getAppContext(), "sp_nfc_band4", "band_local_signature");
                                NfcChannelManager.this.connect(true, str, callback);
                                return;
                            }
                            NfcChannelManager.this.mCloudSignature = gpy.O00000o0(CommonApplication.getAppContext(), "sp_nfc_band4", "band_cloud_signature", "");
                            if (!TextUtils.isEmpty(NfcChannelManager.this.mCloudSignature)) {
                                gpy.O000000o(CommonApplication.getAppContext(), "sp_nfc_band4", "band_cloud_signature", "");
                                NfcChannelManager.this.connect(true, str, callback);
                            }
                        } else if (i == 1 && i2 == 4 && NfcChannelManager.this.isBand3Nfc()) {
                            if (NfcChannelManager.this.mHMBleDevice != null) {
                                try {
                                    NfcChannelManager.this.mHMBleDevice.disconnect();
                                } catch (Exception unused2) {
                                }
                            }
                            gpy.O00000Oo(CommonApplication.getAppContext(), "sp_nfc_band4", "band_local_signature");
                            NfcChannelManager.this.connect(true, str, callback);
                        }
                    }

                    public void onConnectionStateChanged(int i) {
                        LogUtils.d("NfcChannelManager", "ConnectionStateChanged state=".concat(String.valueOf(i)));
                        NfcChannelManager.this.mCONNStatus = i;
                        if (i == 0) {
                            LogUtils.d("NfcChannelManager", "HMBleDevice.CONN_SUCCESS key=" + NfcChannelManager.this.mHMBleDevice.getKey());
                            if (!TextUtils.isEmpty(NfcChannelManager.this.mHMBleDevice.getKey())) {
                                NfcChannelManager.this.saveKey(NfcChannelManager.this.mHMBleDevice.getKey());
                            }
                            NfcChannelManager.this.mHMBleDevice.setPair(false);
                            NfcChannelManager.this.mHasBeenAuthOK = true;
                        } else if (!(i == 2 || i == 3)) {
                            return;
                        }
                        NfcChannelManager.this.countDownLatch.countDown();
                    }

                    public byte[] onSignature(String str, String str2) {
                        LogUtils.e("HMBleDevice. onSignature!");
                        return NfcChannelManager.this.getSignature(str, str2);
                    }
                });
                try {
                    NfcChannelManager.this.countDownLatch.await(120, TimeUnit.SECONDS);
                    LogUtils.e("countDownLatch open!");
                    NfcChannelManager.mIsAuthStart = false;
                    if (NfcChannelManager.this.mAuthStatus == 4) {
                        callback.onFailure(5, "auth failed!");
                        return Boolean.FALSE;
                    } else if (NfcChannelManager.this.mHasBeenAuthOK) {
                        callback.onSuccess(0);
                        return Boolean.TRUE;
                    } else {
                        if (NfcChannelManager.this.mHMBleDevice != null) {
                            NfcChannelManager.this.mHMBleDevice.disconnect();
                        }
                        callback.onFailure(-7, "connect failed!");
                        return Boolean.FALSE;
                    }
                } catch (Exception unused) {
                    callback.onFailure(-7, "connect failed!");
                    return Boolean.FALSE;
                }
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<Boolean>("connect complete", "connect error occurred") {
            /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass3 */

            public void onNext(Boolean bool) {
            }
        }));
    }

    public void getAllCards(final Callback<String> callback) {
        LogUtils.d("NfcChannelManager getAllCards");
        if (this.mContext == null) {
            LogUtils.e("getAllCards failed as context is null!");
            callback.onFailure(-3, "context is null!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            this.mSubscriptions.add(Observable.fromCallable(new Callable<List<CardInfo>>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass6 */

                public List<CardInfo> call() throws Exception {
                    return NfcChannelManager.this.mFacade.fetchCards(CardInfoFactory.makeCardInfo("MIFARE_ENTRANCE", null));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<List<CardInfo>>("fetchCards complete", "fetchCards error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass5 */

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    onNext((List<CardInfo>) ((List) obj));
                }

                public void onNext(List<CardInfo> list) {
                    if (list == null || list.size() == 0) {
                        LogUtils.e("get none card!");
                        callback.onFailure(-4, "get none card!");
                        return;
                    }
                    NfcChannelManager.mCardList.clear();
                    NfcChannelManager.mCardList.addAll(list);
                    NfcChannelManager.this.mMijiaCardNum = 0;
                    WritableArray createArray = Arguments.createArray();
                    for (CardInfo next : list) {
                        if (next instanceof MifareCardInfo) {
                            MifareCardInfo mifareCardInfo = (MifareCardInfo) next;
                            createArray.pushMap(NfcChannelManager.transferCardToMap(mifareCardInfo, mifareCardInfo.getProductId()));
                            if ("66666-00211".equals(mifareCardInfo.getProductId())) {
                                NfcChannelManager.this.mMijiaCardNum++;
                            }
                        }
                    }
                    callback.onSuccess(createArray.toString());
                }
            }));
        }
    }

    public void issueDoorCard(Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager issueDoorCard");
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("issueDoorCard failed!");
            callback.onFailure(-3, "context is null or device is not connect");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            final MifareCardInfo mifareCardInfo = new MifareCardInfo();
            mifareCardInfo.mMifareCardType = 2;
            final Bundle bundle = new Bundle();
            bundle.putString("extra_door_card_product_id", "66666-00211");
            final Callback<Boolean> callback2 = callback;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<BaseResponse>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass8 */

                public BaseResponse call() throws Exception {
                    return NfcChannelManager.this.mFacade.issue(mifareCardInfo, bundle);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<BaseResponse>("issue complete", "issue error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass7 */

                public void onNext(BaseResponse baseResponse) {
                    if (baseResponse.isSuccess()) {
                        NfcChannelManager.this.mHMBleDevice.openApduChannel();
                        byte[] hexStringToByte = NfcChannelManager.hexStringToByte(mifareCardInfo.mAid);
                        if (!NfcChannelManager.this.mHMBleDevice.setAidInfoSync(new HMAidInfo(1, 2, hexStringToByte.length, hexStringToByte))) {
                            LogUtils.e("setAidInfoSync failed!");
                            callback2.onFailure(-5, "setAidInfoSync failed!");
                            return;
                        }
                        NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                        callback2.onSuccess(Boolean.TRUE);
                        return;
                    }
                    LogUtils.e("issueDoorCard failed! error = " + baseResponse.mResultCode);
                    callback2.onFailure(baseResponse.mResultCode, "issueDoorCard failed!");
                }
            }));
        }
    }

    public void deleteCard(String str, Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager deleteCard");
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("deleteCard failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            final MifareCardInfo cardByAid = getCardByAid(str);
            if (cardByAid == null) {
                LogUtils.e("deleteCard failed as no card found!");
                callback.onFailure(-4, "no card found!");
                return;
            }
            final Callback<Boolean> callback2 = callback;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<BaseResponse>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass10 */

                public BaseResponse call() throws Exception {
                    return CardInfoManager.getInstance(NfcChannelManager.this.mContext).deleteCard(cardByAid, new Bundle());
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<BaseResponse>("deleteCard complete", "deleteCard error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass9 */

                public void onNext(BaseResponse baseResponse) {
                    if (baseResponse.isSuccess()) {
                        NfcChannelManager.this.mHMBleDevice.openApduChannel();
                        byte[] hexStringToByte = NfcChannelManager.hexStringToByte(cardByAid.mAid);
                        if (!NfcChannelManager.this.mHMBleDevice.setAidInfoSync(new HMAidInfo(2, 2, hexStringToByte.length, hexStringToByte))) {
                            LogUtils.e("setAidInfoSync failed!");
                            callback2.onFailure(-5, "setAidInfoSync failed!");
                            return;
                        }
                        NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                        callback2.onSuccess(Boolean.TRUE);
                        return;
                    }
                    LogUtils.e("deleteCard failed finally!");
                    callback2.onFailure(baseResponse.mResultCode, baseResponse.mMsg);
                }
            }));
        }
    }

    public void setDefaultCard(String str, Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager setDefaultCard");
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("setDefaultCard failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            final MifareCardInfo cardByAid = getCardByAid(str);
            if (cardByAid == null) {
                LogUtils.e("setDefaultCard failed as no card found!");
                callback.onFailure(-4, "no card found!");
                return;
            }
            final Callback<Boolean> callback2 = callback;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<Boolean>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass12 */

                public Boolean call() throws Exception {
                    return Boolean.valueOf(a.b(NfcChannelManager.this.mContext, cardByAid));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<Boolean>("setDefaultCard complete", "setDefaultCard error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass11 */

                public void onNext(Boolean bool) {
                    if (bool.booleanValue()) {
                        NfcChannelManager.this.mHMBleDevice.openApduChannel();
                        byte[] hexStringToByte = NfcChannelManager.hexStringToByte(cardByAid.mAid);
                        if (!NfcChannelManager.this.mHMBleDevice.setAidInfoSync(new HMAidInfo(3, 2, hexStringToByte.length, hexStringToByte))) {
                            LogUtils.e("setAidInfoSync failed!");
                            callback2.onFailure(-5, "setAidInfoSync failed!");
                            return;
                        }
                        NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                        callback2.onSuccess(Boolean.TRUE);
                        return;
                    }
                    LogUtils.e("setDefaultCard failed finally!");
                    callback2.onFailure(-8, "setDefaultCard failed!");
                }
            }));
        }
    }

    public void updateCard(String str, Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager updateCard + ".concat(String.valueOf(str)));
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("updateCard failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            final MifareCardInfo transferMapToCard = transferMapToCard(str);
            if (transferMapToCard == null) {
                LogUtils.e("updateCard failed as no card found!");
                callback.onFailure(-4, "no card found!");
                return;
            }
            final Callback<Boolean> callback2 = callback;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<BaseResponse>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass14 */

                public BaseResponse call() throws Exception {
                    return NfcChannelManager.this.mFacade.updateCard(transferMapToCard);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<BaseResponse>("updateCard complete", "updateCard error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass13 */

                public void onNext(BaseResponse baseResponse) {
                    if (baseResponse.isSuccess()) {
                        NfcChannelManager.this.mHMBleDevice.openApduChannel();
                        byte[] hexStringToByte = NfcChannelManager.hexStringToByte(transferMapToCard.mAid);
                        int length = hexStringToByte.length;
                        LogUtils.d("NfcChannelManager setAccessInfoSync name = " + transferMapToCard.mCardName);
                        if (!NfcChannelManager.this.mHMBleDevice.setAccessInfoSync(new HMAccessInfo(transferMapToCard.mCardName, length, hexStringToByte))) {
                            LogUtils.e("setAccessInfoSync failed!");
                            callback2.onFailure(-6, "setAccessInfoSync failed!");
                            return;
                        }
                        NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                        callback2.onSuccess(Boolean.TRUE);
                        return;
                    }
                    LogUtils.e("updateCard failed finally!");
                    callback2.onFailure(-9, "updateCard failed!");
                }
            }));
        }
    }

    public void checkDefaultCard(final String str, final Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager checkDefaultCard");
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("checkDefaultCard failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            this.mSubscriptions.add(Observable.fromCallable(new Callable<Boolean>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass16 */

                public Boolean call() throws Exception {
                    NfcChannelManager.this.mHMBleDevice.openApduChannel();
                    byte[] hexStringToByte = NfcChannelManager.hexStringToByte(str);
                    int length = hexStringToByte.length;
                    byte[] cRSBytes = NfcChannelManager.this.getCRSBytes(length, hexStringToByte);
                    LogUtils.d("NfcChannelManager", " responseCRS".concat(String.valueOf(NfcChannelManager.this.mHMBleDevice.sendApduData(cRSBytes, cRSBytes.length, false))));
                    byte[] statusBytes = NfcChannelManager.this.getStatusBytes(length, hexStringToByte);
                    LogUtils.d("NfcChannelManager", "responseStatus:".concat(String.valueOf(NfcChannelManager.this.mHMBleDevice.sendApduData(statusBytes, statusBytes.length, false))));
                    NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                    return Boolean.valueOf(NfcChannelManager.this.checkDefaultCardByStatusBytes(statusBytes));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<Boolean>("checkDefaultCard complete", "checkDefaultCard error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass15 */

                public void onNext(Boolean bool) {
                    callback.onSuccess(bool);
                }
            }));
        }
    }

    public boolean checkDefaultCardByStatusBytes(byte[] bArr) {
        if (bArr != null && bArr.length >= 7) {
            int i = 0;
            while (i < bArr.length - 5) {
                if ((bArr[i] & 255) != 159 || (bArr[i + 1] & 255) != 112) {
                    i++;
                } else if ((bArr[i + 4] & 255) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void checkActivateCard(final String str, final Callback<Boolean> callback) {
        LogUtils.d("NfcChannelManager checkActivateCard");
        if (this.mContext == null || this.mHMBleDevice == null) {
            LogUtils.e("checkActivateCard failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            this.mSubscriptions.add(Observable.fromCallable(new Callable<Boolean>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass18 */

                public Boolean call() throws Exception {
                    NfcChannelManager.this.mHMBleDevice.openApduChannel();
                    byte[] hexStringToByte = NfcChannelManager.hexStringToByte(str);
                    byte[] activateBytes = NfcChannelManager.this.getActivateBytes(hexStringToByte.length, hexStringToByte);
                    LogUtils.d("NfcChannelManager", " responseCRS".concat(String.valueOf(NfcChannelManager.this.mHMBleDevice.sendApduData(activateBytes, activateBytes.length, false))));
                    NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                    return Boolean.valueOf(NfcChannelManager.this.checkActivateCardByActivateBytes(activateBytes));
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<Boolean>("checkActivateCard complete", "checkActivateCard error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass17 */

                public void onNext(Boolean bool) {
                    callback.onSuccess(bool);
                }
            }));
        }
    }

    public boolean checkActivateCardByActivateBytes(byte[] bArr) {
        if (bArr != null && bArr.length >= 7) {
            int i = 0;
            while (i < bArr.length - 5) {
                if ((bArr[i] & 255) != 159 || (bArr[i + 1] & 255) != 12) {
                    i++;
                } else if ((bArr[i + 3] & 255) == 7) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void getDefaultCardAndActivateInfo(Callback<WritableArray> callback) {
        LogUtils.d("NfcChannelManager getDefaultCardAndActivateInfo");
        if (this.mContext == null || this.mHMBleDevice == null || mCardList.size() == 0) {
            LogUtils.e("getDefaultCardAndActivateInfo failed!");
            callback.onFailure(-3, "context is null or device is not connect!");
        } else if (this.mCONNStatus != 0) {
            LogUtils.e("device is not connected!");
            callback.onFailure(-7, "device is not connected!");
        } else {
            final WritableArray createArray = Arguments.createArray();
            final Callback<WritableArray> callback2 = callback;
            this.mSubscriptions.add(Observable.fromCallable(new Callable<Boolean>() {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass20 */

                public Boolean call() throws Exception {
                    NfcChannelManager.this.mHMBleDevice.openApduChannel();
                    NfcChannelManager.this.mMijiaActiveCardNum = 0;
                    for (int i = 0; i < NfcChannelManager.mCardList.size(); i++) {
                        String str = NfcChannelManager.mCardList.get(i).mAid;
                        byte[] hexStringToByte = NfcChannelManager.hexStringToByte(str);
                        int length = hexStringToByte.length;
                        byte[] activateBytes = NfcChannelManager.this.getActivateBytes(length, hexStringToByte);
                        ApduResponse sendApduData = NfcChannelManager.this.mHMBleDevice.sendApduData(activateBytes, activateBytes.length, false);
                        LogUtils.d("NfcChannelManager", " responseCRS".concat(String.valueOf(sendApduData)));
                        if (sendApduData == null) {
                            return Boolean.FALSE;
                        }
                        boolean checkActivateCardByActivateBytes = NfcChannelManager.this.checkActivateCardByActivateBytes(sendApduData.getData());
                        if (checkActivateCardByActivateBytes) {
                            NfcChannelManager.this.mMijiaActiveCardNum++;
                        }
                        byte[] cRSBytes = NfcChannelManager.this.getCRSBytes(length, hexStringToByte);
                        LogUtils.d("NfcChannelManager", " responseCRS".concat(String.valueOf(NfcChannelManager.this.mHMBleDevice.sendApduData(cRSBytes, cRSBytes.length, false))));
                        byte[] statusBytes = NfcChannelManager.this.getStatusBytes(length, hexStringToByte);
                        ApduResponse sendApduData2 = NfcChannelManager.this.mHMBleDevice.sendApduData(statusBytes, statusBytes.length, false);
                        LogUtils.d("NfcChannelManager", "responseStatus:".concat(String.valueOf(sendApduData2)));
                        if (sendApduData2 == null) {
                            return Boolean.FALSE;
                        }
                        boolean checkDefaultCardByStatusBytes = NfcChannelManager.this.checkDefaultCardByStatusBytes(sendApduData2.getData());
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("aid", str);
                        createMap.putBoolean("isDefault", checkDefaultCardByStatusBytes);
                        createMap.putBoolean("isActivate", checkActivateCardByActivateBytes);
                        createArray.pushMap(createMap);
                    }
                    NfcChannelManager.this.mHMBleDevice.closeApduChannel();
                    return Boolean.TRUE;
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Facade.SimpleSubscriber<Boolean>("getDefaultCardAndActivateInfo complete", "getDefaultCardAndActivateInfo error occurred") {
                /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass19 */

                public void onNext(Boolean bool) {
                    if (bool.booleanValue()) {
                        hxt hxt = hxi.O0000Oo;
                        String str = NfcChannelManager.this.mUid;
                        String model = NfcChannelManager.this.getModel();
                        int i = NfcChannelManager.this.mMijiaCardNum;
                        int i2 = NfcChannelManager.this.mMijiaActiveCardNum;
                        boolean z = NfcChannelManager.this.mIsUserHasLock;
                        hxt.f960O000000o.O000000o("band_mijia_card_result", "uid", str, "model", model, "allcardnum", Integer.valueOf(i), "activecardnum", Integer.valueOf(i2), "haslock", Integer.valueOf(z ? 1 : 0));
                        callback2.onSuccess(createArray);
                        return;
                    }
                    callback2.onFailure(-7, "band is not connected!");
                }
            }));
        }
    }

    private static MifareCardInfo getCardByAid(String str) {
        for (int i = 0; i < mCardList.size(); i++) {
            if (TextUtils.equals(str, mCardList.get(i).mAid) && (mCardList.get(i) instanceof MifareCardInfo)) {
                return (MifareCardInfo) mCardList.get(i);
            }
        }
        return null;
    }

    public static WritableMap transferCardToMap(MifareCardInfo mifareCardInfo, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("cardArt", mifareCardInfo.mCardArt);
        createMap.putInt("cardFace", mifareCardInfo.mCardFace);
        createMap.putInt("fingerFlag", mifareCardInfo.mFingerAuthFlag);
        createMap.putInt("mifareCardType", mifareCardInfo.mMifareCardType);
        createMap.putInt("vcStatus", mifareCardInfo.mVCStatus);
        createMap.putString("aid", mifareCardInfo.mAid);
        createMap.putInt("cardBalance", mifareCardInfo.mCardBalance);
        createMap.putInt("cardGroupId", mifareCardInfo.mCardGroupId);
        createMap.putString("name", mifareCardInfo.mCardName);
        createMap.putString("cardType", mifareCardInfo.mCardType);
        createMap.putInt("groupType", mifareCardInfo.mGroupType);
        createMap.putBoolean("hasIssue", mifareCardInfo.mHasIssue);
        createMap.putBoolean("isDefault", mifareCardInfo.mIsDefault);
        createMap.putBoolean("isPack", mifareCardInfo.mIsPack);
        createMap.putBoolean("isReadSECorrectly", mifareCardInfo.mIsReadSECorrectly);
        createMap.putInt("issueFee", mifareCardInfo.mIssueFee);
        createMap.putString("productId", str);
        return createMap;
    }

    public static MifareCardInfo transferMapToCard(String str) {
        MifareCardInfo mifareCardInfo = null;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("NativeMap");
            if (optJSONObject == null) {
                return null;
            }
            MifareCardInfo cardByAid = getCardByAid(optJSONObject.optString("aid"));
            if (cardByAid == null) {
                try {
                    LogUtils.d("NfcChannelManager no card found!");
                    return null;
                } catch (JSONException e) {
                    e = e;
                    mifareCardInfo = cardByAid;
                    e.printStackTrace();
                    return mifareCardInfo;
                }
            } else {
                cardByAid.mCardArt = optJSONObject.optString("cardArt", cardByAid.mCardArt);
                cardByAid.mCardFace = optJSONObject.optInt("cardFace", cardByAid.mCardFace);
                cardByAid.mFingerAuthFlag = optJSONObject.optInt("fingerFlag", cardByAid.mFingerAuthFlag);
                cardByAid.mMifareCardType = optJSONObject.optInt("mifareCardType", cardByAid.mMifareCardType);
                cardByAid.mVCStatus = optJSONObject.optInt("vcStatus", cardByAid.mVCStatus);
                cardByAid.mAid = optJSONObject.optString("aid", cardByAid.mAid);
                cardByAid.mCardBalance = optJSONObject.optInt("cardBalance", cardByAid.mCardBalance);
                cardByAid.mCardGroupId = optJSONObject.optInt("cardGroupId", cardByAid.mCardGroupId);
                cardByAid.mCardName = optJSONObject.optString("name", cardByAid.mCardName);
                cardByAid.mCardType = optJSONObject.optString("cardType", cardByAid.mCardType);
                cardByAid.mGroupType = optJSONObject.optInt("groupType", cardByAid.mGroupType);
                cardByAid.mHasIssue = optJSONObject.optBoolean("hasIssue", cardByAid.mHasIssue);
                cardByAid.mIsDefault = optJSONObject.optBoolean("isDefault", cardByAid.mIsDefault);
                cardByAid.mIsPack = optJSONObject.optBoolean("isPack", cardByAid.mIsPack);
                cardByAid.mIsReadSECorrectly = optJSONObject.optBoolean("isReadSECorrectly", cardByAid.mIsReadSECorrectly);
                cardByAid.mIssueFee = optJSONObject.optInt("issueFee", cardByAid.mIssueFee);
                return cardByAid;
            }
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return mifareCardInfo;
        }
    }

    public static WritableArray transferStrToCardInfos(String str) {
        WritableArray createArray = Arguments.createArray();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    createArray.pushMap(transferStrToCardInfo(jSONObject.toString()));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return createArray;
    }

    public static WritableMap transferStrToCardInfo(String str) {
        WritableMap createMap = Arguments.createMap();
        String str2 = "isReadSECorrectly";
        try {
            JSONObject jSONObject = new JSONObject(str);
            createMap.putString("cardArt", jSONObject.optString("cardArt"));
            createMap.putInt("cardFace", jSONObject.optInt("cardFace"));
            createMap.putInt("fingerFlag", jSONObject.optInt("fingerFlag"));
            createMap.putInt("mifareCardType", jSONObject.optInt("mifareCardType"));
            createMap.putInt("vcStatus", jSONObject.optInt("vcStatus"));
            createMap.putString("aid", jSONObject.optString("aid"));
            createMap.putInt("cardBalance", jSONObject.optInt("cardBalance"));
            createMap.putInt("cardGroupId", jSONObject.optInt("cardGroupId"));
            createMap.putString("name", jSONObject.optString("name"));
            createMap.putString("cardType", jSONObject.optString("cardType"));
            createMap.putInt("groupType", jSONObject.optInt("groupType"));
            createMap.putBoolean("hasIssue", jSONObject.optBoolean("hasIssue"));
            createMap.putBoolean("isDefault", jSONObject.optBoolean("isDefault"));
            String str3 = "isPack";
            createMap.putBoolean(str3, jSONObject.optBoolean(str3));
            String str4 = str2;
            createMap.putBoolean(str4, jSONObject.optBoolean(str4));
            createMap.putInt("issueFee", jSONObject.optInt("issueFee"));
            createMap.putString("productId", jSONObject.optString("productId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return createMap;
    }

    public static WritableArray transferStrToActivateInfo(String str) {
        WritableArray createArray = Arguments.createArray();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("aid", jSONObject.getString("aid"));
                    createMap.putBoolean("isDefault", jSONObject.getBoolean("isDefault"));
                    createMap.putBoolean("isActivate", jSONObject.getBoolean("isActivate"));
                    createArray.pushMap(createMap);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return createArray;
    }

    public String getModel() {
        return this.mModel;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public String getDid() {
        return this.mDid;
    }

    public void setDid(String str) {
        this.mDid = str;
    }

    public String getServiceToken() {
        return this.mServiceToken;
    }

    public void setServiceToken(String str) {
        this.mServiceToken = str;
    }

    public String getUid() {
        return this.mUid;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public HMBleDevice getHMBleDevice() {
        return this.mHMBleDevice;
    }

    public void setHMBleDevice(HMBleDevice hMBleDevice) {
        this.mHMBleDevice = hMBleDevice;
    }

    public void deInit() {
        LogUtils.d("NfcChannelManager deInit");
        HMBleDevice hMBleDevice = this.mHMBleDevice;
        if (hMBleDevice != null) {
            try {
                hMBleDevice.disconnect();
            } catch (Exception unused) {
            }
        }
        Facade facade = this.mFacade;
        if (facade != null) {
            facade.clearData();
            this.mFacade.release();
        }
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (toByte(charArray[i2 + 1]) | (toByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    private static int toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public byte[] getStatusBytes(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Byte.MIN_VALUE);
        arrayList.add((byte) -14);
        arrayList.add((byte) 64);
        arrayList.add((byte) 2);
        arrayList.add(Byte.valueOf((byte) (i + 2)));
        arrayList.add((byte) 79);
        arrayList.add(Byte.valueOf((byte) i));
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Byte.valueOf(bArr[i2]));
        }
        arrayList.add((byte) 0);
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bArr2[i3] = ((Byte) arrayList.get(i3)).byteValue();
        }
        return bArr2;
    }

    public byte[] getCRSBytes(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte) 0);
        arrayList.add((byte) -92);
        arrayList.add((byte) 4);
        arrayList.add((byte) 0);
        arrayList.add((byte) 9);
        arrayList.add((byte) -96);
        arrayList.add((byte) 0);
        arrayList.add((byte) 0);
        arrayList.add((byte) 1);
        arrayList.add((byte) 81);
        arrayList.add((byte) 67);
        arrayList.add((byte) 82);
        arrayList.add((byte) 83);
        arrayList.add((byte) 0);
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bArr2[i2] = ((Byte) arrayList.get(i2)).byteValue();
        }
        return bArr2;
    }

    public byte[] getActivateBytes(int i, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte) 0);
        arrayList.add((byte) -92);
        arrayList.add((byte) 4);
        arrayList.add((byte) 0);
        arrayList.add(Byte.valueOf((byte) i));
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Byte.valueOf(bArr[i2]));
        }
        byte[] bArr2 = new byte[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bArr2[i3] = ((Byte) arrayList.get(i3)).byteValue();
        }
        return bArr2;
    }

    public byte[] getSignature(String str, String str2) {
        LogUtils.d("NfcChannelManager", "getSignature.");
        this.block = true;
        ((gdt) gdv.f17570O000000o.getServiceInterface()).O000000o(this.mContext, str, str2, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.mitsmsdk.NfcChannelManager.AnonymousClass21 */

            public void onSuccess(JSONObject jSONObject) {
                LogUtils.d("NfcChannelManager", "result = ".concat(String.valueOf(jSONObject)));
                if (jSONObject != null) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        NfcChannelManager.this.mCloudSignature = optJSONObject.optString("signature", "");
                        NfcChannelManager.this.block = false;
                        return;
                    }
                    return;
                }
                LogUtils.d("NfcChannelManager", "getSignature result is null!");
            }

            public void onFailure(fso fso) {
                NfcChannelManager.this.block = false;
            }
        });
        while (this.block) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LogUtils.d("NfcChannelManager", "signature0 = " + this.mCloudSignature);
        return Base64.decode(this.mCloudSignature, 2);
    }
}
