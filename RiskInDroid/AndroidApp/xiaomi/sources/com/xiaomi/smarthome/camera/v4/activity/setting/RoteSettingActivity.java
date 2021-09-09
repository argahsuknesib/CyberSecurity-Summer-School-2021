package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.cki;
import _m_j.faw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hzf;
import _m_j.me;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

public class RoteSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    Bitmap mBitMap = null;
    private boolean mIsRote = false;
    ImageView mRoteView;
    Button mSelectView;
    public boolean saving = false;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_rote_setting);
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.select_all_title_bar));
        ((TextView) findViewById(R.id.select_all_title)).setText((int) R.string.rote_title);
        initView();
    }

    private void initView() {
        this.mRoteView = (ImageView) findViewById(R.id.rote_bg);
        findViewById(R.id.rote_select).setOnClickListener(this);
        findViewById(R.id.select_all_cancel).setOnClickListener(this);
        this.mSelectView = (Button) findViewById(R.id.btn_select_all);
        this.mSelectView.setOnClickListener(this);
        this.mSelectView.setVisibility(0);
        String O00000Oo = me.O00000Oo(this.mCameraDevice.getDid());
        if (O00000Oo != null) {
            if (new File(O00000Oo).exists()) {
                this.mBitMap = BitmapFactory.decodeFile(O00000Oo);
            }
            Bitmap bitmap = this.mBitMap;
            if (bitmap == null || bitmap.isRecycled()) {
                this.mBitMap = BitmapFactory.decodeResource(getResources(), R.drawable.camera_default_rote);
            }
            this.mRoteView.setImageBitmap(this.mBitMap);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rote_select) {
            if (this.mIsRote) {
                this.mRoteView.setRotation(0.0f);
                this.mIsRote = false;
                return;
            }
            this.mRoteView.setRotation(180.0f);
            this.mIsRote = true;
        } else if (id == R.id.select_all_cancel) {
            onBackPressed();
        } else if (id != R.id.btn_select_all) {
        } else {
            if (this.mIsRote) {
                save();
                return;
            }
            gqg.O000000o((int) R.string.smb_tip_set_success);
            finish();
        }
    }

    private void save() {
        if (!this.saving) {
            this.saving = true;
            if (this.mCameraSpecDevice != null) {
                Object propertyValueFromCache = getPropertyValueFromCache("camera-control", "image-rollover");
                int i = 180;
                if ((propertyValueFromCache != null ? ((Integer) propertyValueFromCache).intValue() : 0) == 180) {
                    i = 0;
                }
                SpecService O000000o2 = this.mCameraSpecDevice.O000000o("camera-control");
                SpecProperty O000000o3 = this.mCameraSpecDevice.O000000o(O000000o2, "image-rollover");
                if (O000000o2 == null || O000000o3 == null) {
                    this.saving = false;
                    if (!isFinishing()) {
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                        return;
                    }
                    return;
                }
                faw.O000000o().setDeviceProp(this.mCameraDevice.getDid(), O000000o3, Integer.valueOf(i), new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.RoteSettingActivity.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
                     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
                     candidates:
                      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
                      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
                    public void onSuccess(JSONObject jSONObject) {
                        RoteSettingActivity roteSettingActivity = RoteSettingActivity.this;
                        roteSettingActivity.saving = false;
                        if (!roteSettingActivity.isFinishing()) {
                            gqg.O000000o((int) R.string.smb_tip_set_success);
                            try {
                                if (RoteSettingActivity.this.mBitMap != null && !RoteSettingActivity.this.mBitMap.isRecycled()) {
                                    Matrix matrix = new Matrix();
                                    matrix.setRotate(180.0f);
                                    Bitmap createBitmap = Bitmap.createBitmap(RoteSettingActivity.this.mBitMap, 0, 0, RoteSettingActivity.this.mBitMap.getWidth(), RoteSettingActivity.this.mBitMap.getHeight(), matrix, true);
                                    RoteSettingActivity.this.mBitMap.recycle();
                                    RoteSettingActivity.this.mBitMap = null;
                                    String O00000Oo = me.O00000Oo(RoteSettingActivity.this.mCameraDevice.getDid());
                                    if (O00000Oo != null) {
                                        FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                                        createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                        fileOutputStream.close();
                                    }
                                    if (createBitmap != null) {
                                        createBitmap.recycle();
                                    }
                                }
                            } catch (Exception e) {
                                cki.O00000o("RoteSettingActivity", "Exception:" + e.getLocalizedMessage());
                            }
                            RoteSettingActivity.this.finish();
                        }
                    }

                    public void onFailure(fso fso) {
                        RoteSettingActivity roteSettingActivity = RoteSettingActivity.this;
                        roteSettingActivity.saving = false;
                        if (!roteSettingActivity.isFinishing()) {
                            gqg.O000000o((int) R.string.smb_tip_set_fail);
                        }
                    }
                });
                return;
            }
            this.mCameraDevice.O000000o().O000000o(new String[]{"flip"}, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.RoteSettingActivity.AnonymousClass2 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
                 arg types: [java.lang.String, int]
                 candidates:
                  _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                  _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                  _m_j.cll.O000000o(java.lang.String, boolean):boolean */
                public void onSuccess(Void voidR) {
                    RoteSettingActivity.this.mCameraDevice.O000000o().O000000o("flip", !RoteSettingActivity.this.mCameraDevice.O000000o().O000000o("flip", false), new Callback<Void>() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.RoteSettingActivity.AnonymousClass2.AnonymousClass1 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
                         arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
                         candidates:
                          ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
                          ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
                        public void onSuccess(Void voidR) {
                            RoteSettingActivity.this.saving = false;
                            if (!RoteSettingActivity.this.isFinishing()) {
                                gqg.O000000o((int) R.string.smb_tip_set_success);
                                try {
                                    if (RoteSettingActivity.this.mBitMap != null) {
                                        Matrix matrix = new Matrix();
                                        matrix.setRotate(180.0f);
                                        Bitmap createBitmap = Bitmap.createBitmap(RoteSettingActivity.this.mBitMap, 0, 0, RoteSettingActivity.this.mBitMap.getWidth(), RoteSettingActivity.this.mBitMap.getHeight(), matrix, true);
                                        RoteSettingActivity.this.mBitMap.recycle();
                                        RoteSettingActivity.this.mBitMap = null;
                                        String O00000Oo = me.O00000Oo(RoteSettingActivity.this.mCameraDevice.getDid());
                                        if (O00000Oo != null) {
                                            FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                                            createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                            fileOutputStream.close();
                                        }
                                        if (createBitmap != null) {
                                            createBitmap.recycle();
                                        }
                                    }
                                } catch (Exception e) {
                                    cki.O00000o("RoteSettingActivity", "Exception 2:" + e.getLocalizedMessage());
                                }
                                RoteSettingActivity.this.finish();
                            }
                        }

                        public void onFailure(int i, String str) {
                            RoteSettingActivity.this.saving = false;
                            if (!RoteSettingActivity.this.isFinishing()) {
                                gqg.O000000o((int) R.string.smb_tip_set_fail);
                            }
                        }
                    });
                }

                public void onFailure(int i, String str) {
                    RoteSettingActivity roteSettingActivity = RoteSettingActivity.this;
                    roteSettingActivity.saving = false;
                    if (!roteSettingActivity.isFinishing()) {
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitMap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitMap.recycle();
        }
    }
}
