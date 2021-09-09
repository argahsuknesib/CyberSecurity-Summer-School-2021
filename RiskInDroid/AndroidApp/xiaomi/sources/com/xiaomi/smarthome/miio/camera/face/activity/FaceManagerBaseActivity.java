package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.chp;
import _m_j.chr;
import _m_j.cid;
import _m_j.cnr;
import _m_j.cnw;
import _m_j.cnx;
import _m_j.gsy;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.mijia.model.CameraImageLoader;
import com.mijia.model.CameraImageLoaderEx;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiaomi.smarthome.device.api.BaseDevice;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;

public class FaceManagerBaseActivity extends BaseActivity {
    private static int count;
    protected static FaceManager mFaceManager;
    protected cid cameraDevice;
    private volatile boolean initByFaceManager = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mFaceManager == null) {
            try {
                String stringExtra = getIntent().getStringExtra("extra_device_did");
                boolean booleanExtra = getIntent().getBooleanExtra("isFromRn", false);
                DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(stringExtra);
                if (booleanExtra) {
                    chr.O000000o(stringExtra, deviceByDid.model);
                }
                mFaceManager = FaceManager.getInstance(new BaseDevice(deviceByDid));
                this.cameraDevice = cid.O000000o(deviceByDid, deviceByDid.did);
                if (!cnx.O000000o().O00000Oo()) {
                    this.initByFaceManager = true;
                    if (this.cameraDevice.O00000o()) {
                        gsy.O00000Oo("CameraPlay", "initConfig(true)");
                        initConfig(true);
                    } else {
                        gsy.O00000Oo("CameraPlay", "initConfig(false)");
                        initConfig(false);
                    }
                }
            } catch (Exception e) {
                gsy.O000000o(6, "FaceManagerBaseActivity", e.getLocalizedMessage());
            }
        }
        count++;
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
        cnw.O000000o O000000o2 = o000000o.O000000o(Bitmap.Config.RGB_565);
        O000000o2.O0000o00 = true;
        builder.O0000oOO = O000000o2.O000000o();
        cnx.O000000o().O000000o(builder.O00000o0());
    }

    public void onDestroy() {
        super.onDestroy();
        int i = count - 1;
        count = i;
        if (i == 0) {
            mFaceManager.releaseFaceImage();
            mFaceManager = null;
            if (this.initByFaceManager && cnx.O000000o().O00000Oo()) {
                this.initByFaceManager = false;
                cnx.O000000o().O00000o();
            }
        }
    }
}
