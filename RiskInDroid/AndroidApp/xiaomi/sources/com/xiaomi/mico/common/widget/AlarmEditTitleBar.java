package com.xiaomi.mico.common.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.xiaomi.mico.common.util.ImmersionUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.setting.alarm.MicoAlarm;
import com.xiaomi.smarthome.R;
import rx.functions.Action1;

public class AlarmEditTitleBar extends RelativeLayout {
    TextView alarmType;
    ImageView imageView;
    TextView mLeftButton;
    TextView mRightButton;
    View topTitle;

    public interface OnLeftButtonClickListener {
        void onLeftButtonClick();
    }

    public interface OnRightButtonClickListener {
        void onRightButtonClick();
    }

    public void setBgImageResource(int i) {
    }

    public AlarmEditTitleBar(Context context) {
        this(context, null);
    }

    public AlarmEditTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate((int) R.layout.widget_alarm_edit_header, this);
        ButterKnife.bind(this);
        this.alarmType = (TextView) findViewById(R.id.edit_type);
        this.mLeftButton = (TextView) findViewById(R.id.cancel);
        this.mRightButton = (TextView) findViewById(R.id.save_btn);
        this.topTitle = findViewById(R.id.top_title);
        this.imageView = (ImageView) findViewById(R.id.edit_bg);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            ImmersionUtil.setImmersivePaddingIfNeeded((Activity) getContext(), this.topTitle);
        }
    }

    public void setAlarmEditType(MicoAlarm micoAlarm) {
        this.imageView.setImageResource(micoAlarm.editDrawId);
        setTitle(String.format(getContext().getString(R.string.alarm_edit), getContext().getString(micoAlarm.nameId)));
    }

    public void setTitle(String str) {
        this.alarmType.setText(str);
    }

    public AlarmEditTitleBar setOnRightButtonClickListener(final OnRightButtonClickListener onRightButtonClickListener) {
        RxUtil.debounceClick(this.mRightButton, new Action1<Void>() {
            /* class com.xiaomi.mico.common.widget.AlarmEditTitleBar.AnonymousClass1 */

            public void call(Void voidR) {
                onRightButtonClickListener.onRightButtonClick();
            }
        });
        return this;
    }

    public AlarmEditTitleBar setOnLeftButtonClickListener(final OnLeftButtonClickListener onLeftButtonClickListener) {
        RxUtil.debounceClick(this.mLeftButton, new Action1<Void>() {
            /* class com.xiaomi.mico.common.widget.AlarmEditTitleBar.AnonymousClass2 */

            public void call(Void voidR) {
                onLeftButtonClickListener.onLeftButtonClick();
            }
        });
        return this;
    }
}
