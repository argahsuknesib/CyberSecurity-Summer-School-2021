package com.xiaomi.smarthome.camera.activity;

import _m_j.chp;
import _m_j.chy;
import _m_j.cid;
import _m_j.cnr;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.faw;
import _m_j.fax;
import _m_j.fbz;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gkv;
import _m_j.goq;
import _m_j.gsy;
import _m_j.hzf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.mijia.model.CameraImageLoader;
import com.mijia.model.CameraImageLoaderEx;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class CameraBaseActivity extends BaseOrientationSupportActivity {
    public static int count;
    public boolean isV4;
    public cid mCameraDevice;
    public chy mCameraSpecDevice;
    public DeviceStat mDeviceStat;
    public String mDid = "";
    protected boolean mIsResumed = false;

    public Activity activity() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void doCreate(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void handleVideoPlayErrorOnMISS() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mDeviceStat = (DeviceStat) bundle.getParcelable("extra_device");
            if (this.mDeviceStat == null) {
                this.mDeviceStat = (DeviceStat) getIntent().getParcelableExtra("extra_device");
            }
        }
        this.mDid = getIntent().getStringExtra("extra_device_did");
        this.isV4 = getIntent().getBooleanExtra("is_v4", false);
        if (this.mDeviceStat == null) {
            try {
                this.mDeviceStat = XmPluginHostApi.instance().getDeviceByDid(this.mDid);
            } catch (Exception unused) {
                this.mDeviceStat = null;
            }
        }
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat == null) {
            finish();
            return;
        }
        this.mCameraDevice = cid.O000000o(deviceStat, deviceStat.did);
        Device O000000o2 = fno.O000000o().O000000o(this.mDeviceStat.did);
        if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.specUrn)) {
            fbz.O000000o();
            if (fbz.O00000Oo(O000000o2.model)) {
                this.mCameraDevice.setSpecUrn(O000000o2.specUrn);
                this.mCameraSpecDevice = new chy(faw.O000000o().getSpecInstance(O000000o2));
            }
        }
        if (!cnx.O000000o().O00000Oo()) {
            if (this.mCameraDevice.O00000o()) {
                gsy.O00000Oo("CameraPlay", "initConfig(true)");
                initConfig(true);
            } else {
                gsy.O00000Oo("CameraPlay", "initConfig(false)");
                initConfig(false);
            }
        }
        count++;
        doCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        getWindow().setFlags(NotificationCompat.FLAG_HIGH_PRIORITY, NotificationCompat.FLAG_HIGH_PRIORITY);
        this.mIsResumed = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (9999 == i && i2 == 0) {
            finish();
        }
    }

    public void onPause() {
        super.onPause();
        getWindow().clearFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        this.mIsResumed = false;
    }

    public void onStop() {
        super.onStop();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onDestroy() {
        super.onDestroy();
        hzf.O00000Oo((Activity) this);
        hzf.O000000o((Activity) this);
        int i = count - 1;
        count = i;
        if (i <= 0 && cnx.O000000o().O00000Oo()) {
            cid.O0000ooO();
            goq.O000000o($$Lambda$CameraBaseActivity$x_M3ncvcMO9w8WAuBrE2e053o.INSTANCE);
        }
    }

    static /* synthetic */ void lambda$onDestroy$0() {
        try {
            cnx.O000000o().O00000o();
        } catch (Exception e) {
            gsy.O000000o(6, "CameraBaseActivity", "Exception:" + e.getLocalizedMessage());
        }
    }

    public void startActivity(Intent intent) {
        intent.putExtra("extra_device_did", this.mDid);
        intent.putExtra("is_v4", this.isV4);
        super.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        intent.putExtra("extra_device_did", this.mDid);
        intent.putExtra("is_v4", this.isV4);
        super.startActivityForResult(intent, i);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        intent.putExtra("extra_device_did", this.mDid);
        intent.putExtra("is_v4", this.isV4);
        super.startActivityForResult(intent, i, bundle);
    }

    public void runMainThread(Runnable runnable) {
        if (this.mIsResumed) {
            this.mHandler.post(new Runnable(runnable) {
                /* class com.xiaomi.smarthome.camera.activity.$$Lambda$CameraBaseActivity$tyA7j3vyWYPcuLrkNzpCwbDVZp0 */
                private final /* synthetic */ Runnable f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CameraBaseActivity.this.lambda$runMainThread$1$CameraBaseActivity(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$runMainThread$1$CameraBaseActivity(Runnable runnable) {
        if (this.mIsResumed) {
            runnable.run();
        }
    }

    public void openShareVideoActivity(Activity activity, String str, String str2, String str3, int i) {
        CameraJumpUtils.openShareActivity(activity, str, str2, str3, i);
    }

    public void globalPinCodeSettingFunc() {
        CameraJumpUtils.globalPinCodeSettingActivity(this, 102);
    }

    public void globalPinCodeVerifyFunc() {
        DeviceStat deviceStat = this.mDeviceStat;
        if (deviceStat != null && deviceStat.isSetPinCode != 0) {
            CameraJumpUtils.globalPinCodeVerifyActivity(this, this.mDid, 9999);
        }
    }

    public void globalPinCodeOnOffFunc() {
        CameraJumpUtils.globalPinCodeOnOffActivity(this, this.mDid, "", 112);
    }

    public void openSharePictureActivity(String str, String str2, String str3) {
        CameraJumpUtils.openShareActivity(this, str, str2, str3);
    }

    private void initConfig(boolean z) {
        chp.O000000o(this);
        Context applicationContext = getApplicationContext();
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(applicationContext);
        builder.O000000o();
        builder.O0000o0 = true;
        builder.O000000o(new cnr());
        builder.O00000Oo();
        builder.O000000o(QueueProcessingType.LIFO);
        if (z) {
            builder.O0000oO0 = new CameraImageLoaderEx(applicationContext);
        } else {
            builder.O0000oO0 = new CameraImageLoader(applicationContext);
        }
        builder.O0000oOo = true;
        cnw.O000000o o000000o = new cnw.O000000o();
        o000000o.O0000OOo = true;
        o000000o.O0000Oo0 = true;
        builder.O0000oOO = o000000o.O000000o(Bitmap.Config.RGB_565).O000000o();
        cnx.O000000o().O000000o(builder.O00000o0());
    }

    public Object getPropertyValueFromCache(String str, String str2) {
        if (this.mCameraSpecDevice != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SpecService O000000o2 = this.mCameraSpecDevice.O000000o(str);
            SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, str2);
            if (!(O000000o2 == null || O000000o3 == null)) {
                Object propValue = faw.O000000o().getPropValue(this.mCameraDevice.getDid(), fax.O000000o(O000000o3));
                gsy.O00000Oo("CameraBaseActivity", "getPropertyValueFromCache serviceName:" + str + " propertyName:" + str2 + " value:" + propValue);
                return propValue;
            }
        }
        return null;
    }

    private void getPropertiesFromServer(Callback<List<PropertyParam>> callback) {
        ArrayList arrayList = new ArrayList();
        SpecDevice O000000o2 = this.mCameraSpecDevice.O000000o();
        if (O000000o2 != null) {
            for (Map.Entry<Integer, SpecService> value : O000000o2.getServices().entrySet()) {
                for (Map.Entry<Integer, SpecProperty> value2 : ((SpecService) value.getValue()).getProperties().entrySet()) {
                    arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), (SpecProperty) value2.getValue()));
                }
            }
            getPropertiesFromServer(arrayList, callback);
        }
    }

    private void getPropertiesFromServer(List<PropertyParam> list, final Callback<List<PropertyParam>> callback) {
        faw.O00000o().getDeviceSpecProp(gkv.f17949O000000o, list, new fsm<List<PropertyParam>, fso>() {
            /* class com.xiaomi.smarthome.camera.activity.CameraBaseActivity.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<PropertyParam>) ((List) obj));
            }

            public void onSuccess(List<PropertyParam> list) {
                if (!CameraBaseActivity.this.isFinishing()) {
                    for (PropertyParam next : list) {
                        String O000000o2 = fax.O000000o(next.getMiid(), next.getSiid(), next.getPiid());
                        if (next.getResultCode() == 0) {
                            faw.O000000o().notifyPropChangedListener(next.getDid(), O000000o2, next.getValue(), next.getTimestamp(), (byte) 4);
                            SpecService O000000o3 = CameraBaseActivity.this.mCameraSpecDevice.O000000o(next.getSiid());
                            SpecProperty O000000o4 = CameraBaseActivity.this.mCameraSpecDevice.O000000o(next.getSiid(), next.getPiid());
                            if (!(O000000o3 == null || O000000o4 == null)) {
                                LogType logType = LogType.CAMERA;
                                String model = CameraBaseActivity.this.mCameraDevice.getModel();
                                gsy.O00000o0(logType, model, "CameraBaseActivity", "getPropFromServer SName:" + O000000o3.getTypeName() + " PName:" + O000000o4.getDefinition().getTypeName() + " --> " + next.toString());
                            }
                        }
                    }
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(list);
                    }
                }
            }

            public void onFailure(fso fso) {
                if (!CameraBaseActivity.this.isFinishing()) {
                    if (fso != null) {
                        LogType logType = LogType.CAMERA;
                        String model = CameraBaseActivity.this.mCameraDevice.getModel();
                        gsy.O000000o(logType, model, 6, "CameraBaseActivity", "getPropFromServer failed:" + fso.f17063O000000o + fso.O00000Oo);
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                            return;
                        }
                        return;
                    }
                    gsy.O000000o(LogType.CAMERA, CameraBaseActivity.this.mCameraDevice.getModel(), 6, "CameraBaseActivity", "getPropFromServer failed unknown reason");
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onFailure(-10086, "unknown");
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loadPropertiesFromServer(List<Pair<String, String>> list, Callback<List<PropertyParam>> callback) {
        SpecProperty O000000o2;
        if (list == null || list.size() == 0) {
            getPropertiesFromServer(callback);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Pair next : list) {
            SpecService O000000o3 = this.mCameraSpecDevice.O000000o((String) next.first);
            if (!(O000000o3 == null || (O000000o2 = this.mCameraSpecDevice.O000000o(O000000o3, (String) next.second)) == null)) {
                arrayList.add(new PropertyParam(this.mCameraDevice.getDid(), O000000o2));
            }
        }
        getPropertiesFromServer(arrayList, callback);
    }

    /* access modifiers changed from: protected */
    public void setWindowConfiguration(Configuration configuration) {
        if (configuration.orientation == 2) {
            getWindow().setFlags(1024, 1024);
            return;
        }
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
    }

    public void hideStatusBar() {
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(1024);
    }
}
