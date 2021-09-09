package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.civ;
import _m_j.clf;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hzf;
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
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.AlarmSelectView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlarmSelectV2Activity extends CameraBaseActivity implements View.OnClickListener, AlarmSelectView.IAlarmChangeListener {
    AlarmSelectView mAlarmSelectView;
    Bitmap mBitmap;
    Button mCancelBtn;
    XQProgressDialog mProgressDialog;
    Button mSelectBtn;
    View mSelectView;
    MLAlertDialog mlAlertDialog;
    int[] sensitive;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_setting_alarm_select_v2);
        initView();
        String O00000Oo = me.O00000Oo(this.mCameraDevice.getDid());
        if (new File(O00000Oo).exists()) {
            this.mBitmap = BitmapFactory.decodeFile(O00000Oo);
        }
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mAlarmSelectView.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
        this.sensitive = getIntent().getIntArrayExtra("sensitive");
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
        gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), findViewById(R.id.title_bar_container));
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
    }

    private void loadData() {
        try {
            if (this.sensitive != null && this.sensitive.length > 0) {
                this.mAlarmSelectView.setSelectStatus(dimension1ToDimension2(this.sensitive));
            }
        } catch (Exception unused) {
        }
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
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("did", this.mCameraDevice.getDid());
                hashMap.put("region", Locale.getDefault().getCountry());
                JSONArray jSONArray = new JSONArray();
                for (int put : dimension2ToDimension1(this.mAlarmSelectView.getCurrentItems())) {
                    jSONArray.put(put);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sensitive", jSONArray);
                hashMap.put("sensitive", jSONObject.toString());
                this.mProgressDialog.show();
                clf.O000000o().O00000oo(this.mCameraDevice.getModel(), hashMap.toString(), new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectV2Activity.AnonymousClass1 */

                    public void onSuccess(JSONObject jSONObject) {
                        if (!AlarmSelectV2Activity.this.isFinishing()) {
                            AlarmSelectV2Activity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectV2Activity.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    if (AlarmSelectV2Activity.this.mProgressDialog.isShowing()) {
                                        AlarmSelectV2Activity.this.mProgressDialog.dismiss();
                                    }
                                    gqg.O000000o((int) R.string.settings_set_success);
                                    AlarmSelectV2Activity.this.mAlarmSelectView.invalidate();
                                    AlarmSelectV2Activity.this.hideSelect();
                                    AlarmSelectV2Activity.this.finish();
                                }
                            });
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!AlarmSelectV2Activity.this.isFinishing()) {
                            civ.O00000o0("AlarmSelectV2Activity", "i:" + i + " s:" + str);
                            AlarmSelectV2Activity.this.runOnUiThread(new Runnable() {
                                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectV2Activity.AnonymousClass1.AnonymousClass2 */

                                public void run() {
                                    if (AlarmSelectV2Activity.this.mProgressDialog.isShowing()) {
                                        AlarmSelectV2Activity.this.mProgressDialog.dismiss();
                                    }
                                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                                }
                            });
                        }
                    }
                });
            } catch (JSONException unused) {
            }
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
                /* class com.xiaomi.smarthome.camera.activity.alarm.AlarmSelectV2Activity.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    AlarmSelectV2Activity.this.finish();
                }
            });
            this.mlAlertDialog = builder.O00000o();
        }
    }

    private int[][] dimension1ToDimension2(int[] iArr) {
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, 4, 8);
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < 8) {
                int i5 = i3 + 1;
                iArr2[i][i4] = iArr[i3];
                i4++;
                i3 = i5;
            }
            i++;
            i2 = i3;
        }
        return iArr2;
    }

    private int[] dimension2ToDimension1(int[][] iArr) {
        int[] iArr2 = new int[32];
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < 8) {
                iArr2[i3] = iArr[i][i4];
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        return iArr2;
    }
}
