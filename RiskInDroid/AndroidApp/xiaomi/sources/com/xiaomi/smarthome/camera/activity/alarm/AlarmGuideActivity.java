package com.xiaomi.smarthome.camera.activity.alarm;

import _m_j.ftn;
import _m_j.hzc;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;

public class AlarmGuideActivity extends CameraBaseActivity implements View.OnClickListener {
    private TextView mNextTxt;
    private TextView mTitleNameTxt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.camera_activity_alarm_guide);
        if (this.mCameraDevice != null) {
            initView();
        }
    }

    private void initView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mTitleNameTxt = (TextView) findViewById(R.id.title_bar_title);
        this.mTitleNameTxt.setText(getResources().getString(R.string.housekeeping));
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mNextTxt = (TextView) findViewById(R.id.text_three_menu_next);
        this.mNextTxt.setOnClickListener(this);
        this.mNextTxt.setVisibility(0);
        initHeadImage();
    }

    private void initHeadImage() {
        ImageView imageView = (ImageView) findViewById(R.id.img_housekeeping_guide_head_img);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        imageView.getLayoutParams().width = width;
        imageView.getLayoutParams().height = (int) (((float) (width * 493)) / 720.0f);
        if (this.mCameraDevice.O0000oOO()) {
            Picasso.get().load(ftn.O00000Oo(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("alarm_setting_guide_v3_upgrade"))).into(imageView);
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
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            finish();
        } else if (id == R.id.text_three_menu_next) {
            this.mCameraDevice.O00000oO().O00000oO();
            Intent intent = new Intent();
            intent.putExtra("jump", true);
            intent.setClass(this, AlarmSettingV2Activity.class);
            startActivity(intent);
            finish();
        }
    }
}
