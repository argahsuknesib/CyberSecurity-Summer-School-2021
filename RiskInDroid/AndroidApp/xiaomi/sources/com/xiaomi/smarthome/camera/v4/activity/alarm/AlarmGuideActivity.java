package com.xiaomi.smarthome.camera.v4.activity.alarm;

import _m_j.clf;
import _m_j.hyy;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.alarm.AlarmSettingV2Activity;

public class AlarmGuideActivity extends CameraBaseActivity implements View.OnClickListener {
    private TextView mNextTxt;
    private TextView mTitleNameTxt;
    private boolean useNewAlarmVideo;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_guide);
        if (this.mCameraDevice != null) {
            initView();
            this.useNewAlarmVideo = getIntent().getBooleanExtra("useNewAlarmVideo", false);
        }
    }

    private void initView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mTitleNameTxt = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleNameTxt.setText(getResources().getString(R.string.housekeeping_v4));
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mNextTxt = (TextView) findViewById(R.id.text_three_menu_next);
        this.mNextTxt.setOnClickListener(this);
        this.mNextTxt.setVisibility(0);
        initHeadImage();
    }

    private void initHeadImage() {
        ImageView imageView = (ImageView) findViewById(R.id.img_housekeeping_guide_head_img);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int i = hyy.O00000Oo(getIntent()).widthPixels;
        imageView.getLayoutParams().width = i;
        if ("chuangmi.camera.ipc021".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_021_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.021a04".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_021_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.ipc022".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_022_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.ip026c".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_026_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.026c02".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_026_c02);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.ip029a".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_029_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else if ("chuangmi.camera.029a02".equals(this.mCameraDevice.getModel())) {
            imageView.setImageResource(R.drawable.activity_guide_housekeeping_img_guide_head_029_2x);
            imageView.getLayoutParams().height = (int) (((float) (i * 513)) / 750.0f);
        } else {
            imageView.getLayoutParams().height = (int) (((float) (i * 493)) / 720.0f);
        }
        imageView.postInvalidate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void onClick(View view) {
        if (view.getId() != R.id.title_bar_return) {
            if (view.getId() == R.id.text_three_menu_next) {
                this.mCameraDevice.O00000oO().O00000oO();
                Intent intent = new Intent();
                intent.putExtra("jump", true);
                clf.O00000Oo();
                if (clf.O00000oO()) {
                    if (this.useNewAlarmVideo) {
                        intent.setClass(this, AlarmSettingV2Activity.class);
                    } else {
                        intent.setClass(this, AlarmSettingV2Activity.class);
                    }
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                } else {
                    intent.setClass(this, AlarmSettingActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            } else {
                return;
            }
        }
        finish();
    }
}
