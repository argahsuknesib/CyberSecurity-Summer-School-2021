package com.xiaomi.smarthome.miio.page.msgcentersetting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.TimePicker;

public class InterruptPushTimerSettingActiviy extends BaseActivity implements View.OnClickListener {
    @BindView(5432)
    TextView mConfirmView;
    @BindView(5146)
    TextView mExecuteFrom;
    @BindView(5148)
    TimePicker mExecuteFromPicker;
    @BindView(5150)
    TextView mExecuteTo;
    @BindView(5152)
    TimePicker mExecuteToPicker;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.layout_interrupt_push);
        ButterKnife.bind(this);
        this.mConfirmView.setVisibility(0);
        this.mConfirmView.setText((int) R.string.ok_button);
        this.mExecuteFromPicker.setIs24HourView(Boolean.TRUE);
        this.mExecuteToPicker.setIs24HourView(Boolean.TRUE);
        if (getIntent() != null) {
            Intent intent = getIntent();
            this.mExecuteFromPicker.setCurrentHour(Integer.valueOf(intent.getIntExtra("from_hour", 0)));
            this.mExecuteFromPicker.setCurrentMinute(Integer.valueOf(intent.getIntExtra("from_min", 0)));
            this.mExecuteToPicker.setCurrentHour(Integer.valueOf(intent.getIntExtra("to_hour", 0)));
            this.mExecuteToPicker.setCurrentMinute(Integer.valueOf(intent.getIntExtra("to_min", 0)));
            showNextTriggerHint();
        }
        this.mExecuteFromPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy.AnonymousClass1 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                InterruptPushTimerSettingActiviy.this.showNextTriggerHint();
            }
        });
        this.mExecuteToPicker.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.miio.page.msgcentersetting.InterruptPushTimerSettingActiviy.AnonymousClass2 */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                InterruptPushTimerSettingActiviy.this.showNextTriggerHint();
            }
        });
    }

    public void showNextTriggerHint() {
        int intValue = this.mExecuteFromPicker.getCurrentHour().intValue();
        int intValue2 = this.mExecuteFromPicker.getCurrentMinute().intValue();
        int intValue3 = this.mExecuteToPicker.getCurrentHour().intValue();
        int intValue4 = this.mExecuteToPicker.getCurrentMinute().intValue();
        this.mExecuteFrom.setText(formatTime(intValue, intValue2));
        if (intValue3 < intValue) {
            TextView textView = this.mExecuteTo;
            textView.setText("(" + getResources().getString(R.string.scene_exetime_second_day) + ")" + formatTime(intValue3, intValue4));
            return;
        }
        this.mExecuteTo.setText(formatTime(intValue3, intValue4));
    }

    public static String formatTime(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i < 0 || i >= 10) {
            sb.append(i);
        } else {
            sb.append("0".concat(String.valueOf(i)));
        }
        sb.append(":");
        if (i2 < 0 || i2 >= 10) {
            sb.append(i2);
        } else {
            sb.append("0".concat(String.valueOf(i2)));
        }
        return sb.toString();
    }

    @OnClick({5422, 5432, 5147, 5151})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            setResult(0);
            finish();
        } else if (id == R.id.module_a_3_right_text_btn) {
            Intent intent = new Intent();
            intent.putExtra("from_hour", this.mExecuteFromPicker.getCurrentHour());
            intent.putExtra("from_min", this.mExecuteFromPicker.getCurrentMinute());
            intent.putExtra("to_hour", this.mExecuteToPicker.getCurrentHour());
            intent.putExtra("to_min", this.mExecuteToPicker.getCurrentMinute());
            setResult(-1, intent);
            finish();
        } else if (id == R.id.execute_from_layout) {
            if (this.mExecuteFromPicker.getVisibility() == 0) {
                this.mExecuteFromPicker.setVisibility(8);
            } else {
                this.mExecuteFromPicker.setVisibility(0);
            }
            this.mExecuteToPicker.setVisibility(8);
        } else if (id == R.id.execute_to_layout) {
            if (this.mExecuteToPicker.getVisibility() == 0) {
                this.mExecuteToPicker.setVisibility(8);
            } else {
                this.mExecuteToPicker.setVisibility(0);
            }
            this.mExecuteFromPicker.setVisibility(8);
        }
    }
}
