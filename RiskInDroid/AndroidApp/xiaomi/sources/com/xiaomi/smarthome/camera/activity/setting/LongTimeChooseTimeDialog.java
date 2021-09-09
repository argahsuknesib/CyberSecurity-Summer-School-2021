package com.xiaomi.smarthome.camera.activity.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class LongTimeChooseTimeDialog extends MLAlertDialog {
    private boolean isChooseOnTime;
    private boolean isShowCustomtitle;
    protected Context mContext;
    private TextView mMyCustomTitle;
    private String mOffTime;
    private String mOnTime;
    private int mRepeat;
    private String mTime;
    private TimePicker mTpTimerOff;
    private TextView mTvTime;

    public LongTimeChooseTimeDialog(Context context, String str, String str2, String str3, int i, boolean z) {
        this(context, 2132739282);
        this.mTime = str;
        this.mOnTime = str2;
        this.mOffTime = str3;
        this.mRepeat = i;
        this.isChooseOnTime = z;
    }

    public LongTimeChooseTimeDialog(Context context, int i) {
        this(context, i, 80, 0, null);
    }

    public void onCreate(Bundle bundle) {
        View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.choose_time_dialog, (ViewGroup) null);
        this.mTvTime = (TextView) inflate.findViewById(R.id.tv_timer_off_hint);
        this.mTpTimerOff = (TimePicker) inflate.findViewById(R.id.tp_timer_off);
        this.mMyCustomTitle = (TextView) inflate.findViewById(R.id.tv_custom_title);
        this.mTpTimerOff.setIs24HourView(Boolean.TRUE);
        String str = this.mTime;
        if (str != null) {
            String[] split = str.split(":");
            int intValue = Integer.valueOf(split[0]).intValue();
            int intValue2 = Integer.valueOf(split[1]).intValue();
            this.mTpTimerOff.setCurrentHour(Integer.valueOf(intValue));
            this.mTpTimerOff.setCurrentMinute(Integer.valueOf(intValue2));
            this.mTvTime.setText(LongTimeAlarmManager.formatTime(this.mContext, this.mRepeat, this.mOnTime, this.mOffTime, this.isChooseOnTime));
        } else {
            String format = new SimpleDateFormat("HH:mm", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
            String[] split2 = format.split(":");
            int intValue3 = Integer.valueOf(split2[0]).intValue();
            int intValue4 = Integer.valueOf(split2[1]).intValue();
            this.mTpTimerOff.setCurrentHour(Integer.valueOf(intValue3));
            this.mTpTimerOff.setCurrentMinute(Integer.valueOf(intValue4));
            this.mTvTime.setText(LongTimeAlarmManager.formatTime(this.mContext, this.mRepeat, format, format, this.isChooseOnTime));
        }
        this.mTpTimerOff.setOnTimeChangedListener(new TimePicker.O00000Oo() {
            /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$LongTimeChooseTimeDialog$51cntVkwMWCNa5OKiLhD2i2FslI */

            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                LongTimeChooseTimeDialog.this.lambda$onCreate$0$LongTimeChooseTimeDialog(timePicker, i, i2);
            }
        });
        if (this.isShowCustomtitle) {
            this.mMyCustomTitle.setVisibility(0);
        } else {
            this.mMyCustomTitle.setVisibility(8);
        }
        setView(inflate);
        super.onCreate(bundle);
    }

    public /* synthetic */ void lambda$onCreate$0$LongTimeChooseTimeDialog(TimePicker timePicker, int i, int i2) {
        Object[] objArr = new Object[2];
        objArr[0] = i < 10 ? "0".concat(String.valueOf(i)) : Integer.valueOf(i);
        objArr[1] = i2 < 10 ? "0".concat(String.valueOf(i2)) : Integer.valueOf(i2);
        String format = String.format("%s:%s", objArr);
        boolean z = this.isChooseOnTime;
        if (z) {
            this.mTvTime.setText(LongTimeAlarmManager.formatTime(this.mContext, this.mRepeat, format, this.mOffTime, z));
        } else {
            this.mTvTime.setText(LongTimeAlarmManager.formatTime(this.mContext, this.mRepeat, this.mOnTime, format, z));
        }
        getButton(-1).setEnabled(true);
    }

    public LongTimeChooseTimeDialog(Context context, int i, int i2, int i3, String str) {
        super(context, i);
        this.isShowCustomtitle = false;
        this.mContext = context;
        this.mTime = str;
    }

    public TimePicker getTimePicker() {
        return this.mTpTimerOff;
    }

    public void setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        setButton(-1, getContext().getString(i), onClickListener);
    }

    public void setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        setButton(-2, getContext().getString(i), onClickListener);
    }

    public void setMyCustomTitle(int i) {
        this.isShowCustomtitle = true;
        TextView textView = this.mMyCustomTitle;
        if (textView != null) {
            textView.setVisibility(0);
            this.mMyCustomTitle.setText(i);
        }
    }
}
