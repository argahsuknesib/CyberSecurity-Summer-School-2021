package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.gqg;
import _m_j.me;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.AlarmSelectView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;

public class AlarmSelectActivity extends CameraBaseActivity implements View.OnClickListener, AlarmSelectView.IAlarmChangeListener {
    AlarmSelectView mAlarmSelectView;
    Bitmap mBitmap;
    Button mCancelBtn;
    XQProgressDialog mProgressDialog;
    Button mSelectBtn;
    View mSelectView;
    MLAlertDialog mlAlertDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_setting_alarm_select);
        initView();
        String O00000Oo = me.O00000Oo(this.mCameraDevice.getDid());
        if (new File(O00000Oo).exists()) {
            this.mBitmap = BitmapFactory.decodeFile(O00000Oo);
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mAlarmSelectView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
        loadData();
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                this.mBitmap.recycle();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        ((TextView) findViewById(R.id.select_all_title)).setText((int) R.string.setting_alarm_area);
        this.mSelectView = findViewById(R.id.select_all_title_bar);
        this.mSelectBtn = (Button) findViewById(R.id.btn_select_all);
        this.mCancelBtn = (Button) findViewById(R.id.select_all_cancel);
        this.mSelectBtn.setVisibility(8);
        this.mSelectBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        this.mProgressDialog = new XQProgressDialog(this);
        this.mAlarmSelectView = (AlarmSelectView) findViewById(R.id.alarm_select_view);
        this.mAlarmSelectView.setChangeListener(this);
        this.mProgressDialog.setMessage(getString(R.string.loading_data));
        this.mProgressDialog.show();
    }

    private void loadData() {
        this.mCameraDevice.O0000o0O().O00000Oo(new Callback<int[][]>() {
            /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectActivity.AnonymousClass1 */

            public void onSuccess(int[][] iArr) {
                if (!AlarmSelectActivity.this.isFinishing()) {
                    if (AlarmSelectActivity.this.mProgressDialog.isShowing()) {
                        AlarmSelectActivity.this.mProgressDialog.dismiss();
                    }
                    AlarmSelectActivity.this.mAlarmSelectView.setSelectStatus(iArr);
                }
            }

            public void onFailure(int i, String str) {
                if (!AlarmSelectActivity.this.isFinishing()) {
                    if (AlarmSelectActivity.this.mProgressDialog.isShowing()) {
                        AlarmSelectActivity.this.mProgressDialog.dismiss();
                    }
                    gqg.O000000o(AlarmSelectActivity.this.getString(R.string.tip_no_info));
                }
            }
        });
    }

    private void showSelect() {
        if (this.mSelectBtn.getVisibility() != 0) {
            this.mSelectBtn.setVisibility(0);
        }
    }

    public void hideSelect() {
        if (this.mSelectBtn.getVisibility() != 8) {
            this.mSelectBtn.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_select_all) {
            if (!this.mAlarmSelectView.isChange()) {
                gqg.O000000o((int) R.string.alarm_select_need_chose);
                return;
            }
            this.mProgressDialog.setMessage(getString(R.string.alarm_select_set_ing));
            if (this.mAlarmSelectView.isCloseAll()) {
                gqg.O000000o((int) R.string.setting_alarm_none);
                this.mAlarmSelectView.reset();
                return;
            }
            this.mProgressDialog.show();
            this.mCameraDevice.O0000o0O().O000000o(new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectActivity.AnonymousClass2 */

                public void onSuccess(Void voidR) {
                    if (!AlarmSelectActivity.this.isFinishing()) {
                        if (AlarmSelectActivity.this.mProgressDialog.isShowing()) {
                            AlarmSelectActivity.this.mProgressDialog.dismiss();
                        }
                        gqg.O000000o((int) R.string.settings_set_success);
                        AlarmSelectActivity.this.mAlarmSelectView.invalidate();
                        AlarmSelectActivity.this.hideSelect();
                        AlarmSelectActivity.this.finish();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!AlarmSelectActivity.this.isFinishing()) {
                        if (AlarmSelectActivity.this.mProgressDialog.isShowing()) {
                            AlarmSelectActivity.this.mProgressDialog.dismiss();
                        }
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                    }
                }
            }, this.mAlarmSelectView.getCurrentItems());
        } else if (id != R.id.select_all_cancel) {
        } else {
            if (this.mSelectBtn.getVisibility() != 0 || !this.mSelectBtn.isEnabled()) {
                finish();
                return;
            }
            initAlertDlg();
            if (!this.mlAlertDialog.isShowing()) {
                this.mlAlertDialog.show();
            }
        }
    }

    public void onBackPressed() {
        if (this.mSelectBtn.getVisibility() != 0 || !this.mSelectBtn.isEnabled()) {
            super.onBackPressed();
            return;
        }
        initAlertDlg();
        if (!this.mlAlertDialog.isShowing()) {
            this.mlAlertDialog.show();
        }
    }

    public void onChange() {
        if (this.mAlarmSelectView.isChange()) {
            this.mSelectBtn.setEnabled(true);
            showSelect();
            return;
        }
        this.mSelectBtn.setEnabled(false);
    }

    private void initAlertDlg() {
        if (this.mlAlertDialog == null) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.common_give_up);
            builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            builder.O00000Oo((int) R.string.alarm_select_give_up);
            builder.O000000o((int) R.string.common_give_up, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectActivity.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    AlarmSelectActivity.this.finish();
                }
            });
            this.mlAlertDialog = builder.O00000o();
        }
    }
}
