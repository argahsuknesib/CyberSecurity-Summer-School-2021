package com.xiaomi.smarthome.camera.activity.setting;

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
import java.io.File;
import java.io.FileOutputStream;

public class RoteSettingActivity extends CameraBaseActivity implements View.OnClickListener {
    Bitmap mBitMap = null;
    private boolean mIsRote = false;
    ImageView mRoteView;
    Button mSelectView;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_rote_setting);
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
            if (this.mBitMap == null) {
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
            activity();
            gqg.O000000o((int) R.string.smb_tip_set_success);
            finish();
        }
    }

    private void save() {
        this.mCameraDevice.O000000o().O000000o(new String[]{"flip"}, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.RoteSettingActivity.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.cll.O000000o(java.lang.String, boolean):boolean
             arg types: [java.lang.String, int]
             candidates:
              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
              _m_j.cll.O000000o(java.lang.String, boolean):boolean */
            public void onSuccess(Void voidR) {
                RoteSettingActivity.this.mCameraDevice.O000000o().O000000o("flip", !RoteSettingActivity.this.mCameraDevice.O000000o().O000000o("flip", false), new Callback<Void>() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.RoteSettingActivity.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap}
                     arg types: [android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, int]
                     candidates:
                      ClspMth{android.graphics.Bitmap.createBitmap(android.util.DisplayMetrics, int[], int, int, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap}
                      ClspMth{android.graphics.Bitmap.createBitmap(android.graphics.Bitmap, int, int, int, int, android.graphics.Matrix, boolean):android.graphics.Bitmap} */
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
                    public void onSuccess(Void voidR) {
                        Bitmap bitmap;
                        Exception e;
                        if (!RoteSettingActivity.this.isFinishing()) {
                            RoteSettingActivity.this.activity();
                            gqg.O000000o((int) R.string.smb_tip_set_success);
                            if (RoteSettingActivity.this.mBitMap != null) {
                                try {
                                    Matrix matrix = new Matrix();
                                    matrix.setRotate(180.0f);
                                    bitmap = Bitmap.createBitmap(RoteSettingActivity.this.mBitMap, 0, 0, RoteSettingActivity.this.mBitMap.getWidth(), RoteSettingActivity.this.mBitMap.getHeight(), matrix, true);
                                    try {
                                        RoteSettingActivity.this.mBitMap.recycle();
                                        RoteSettingActivity.this.mBitMap = null;
                                        String O00000Oo = me.O00000Oo(RoteSettingActivity.this.mCameraDevice.getDid());
                                        if (O00000Oo != null) {
                                            FileOutputStream fileOutputStream = new FileOutputStream(O00000Oo);
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                            fileOutputStream.close();
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        if (bitmap != null) {
                                        }
                                        RoteSettingActivity.this.finish();
                                    }
                                } catch (Exception e3) {
                                    Exception exc = e3;
                                    bitmap = null;
                                    e = exc;
                                    e.printStackTrace();
                                    if (bitmap != null) {
                                    }
                                    RoteSettingActivity.this.finish();
                                }
                                if (bitmap != null) {
                                    bitmap.recycle();
                                }
                            }
                            RoteSettingActivity.this.finish();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!RoteSettingActivity.this.isFinishing()) {
                            RoteSettingActivity.this.activity();
                            gqg.O000000o((int) R.string.smb_tip_set_fail);
                        }
                    }
                });
            }

            public void onFailure(int i, String str) {
                if (!RoteSettingActivity.this.isFinishing()) {
                    RoteSettingActivity.this.activity();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitMap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBitMap.recycle();
        }
    }
}
