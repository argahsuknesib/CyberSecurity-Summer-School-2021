package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.ggb;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gsy;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;

public class SetLongTimeAlarmActivity extends CameraBaseActivity {
    private String mEndTimeTip;
    private AnimationDrawable mLoadingDrawable;
    private ImageView mLoadingView;
    public String mName;
    public LongTimeAlarm mNewTimer;
    public String mOffTime;
    public String mOnTime;
    public LongTimeAlarm mOriginTimer;
    public int mPos;
    public int mRepeat;
    public boolean[] mSelectedItems;
    private String mStartTimeTip;
    public TextView mTvNameDetail;
    public TextView mTvRepeatDetail;
    private TextView mTvTimerOff;
    private TextView mTvTimerOffDetail;
    private TextView mTvTimerOn;
    private TextView mTvTimerOnDetail;
    private View mViewName;
    private View mViewRepeat;
    private View mViewTimerOff;
    private View mViewTimerOn;
    private XQProgressDialog mXQProgressDialog;

    private void hideProgressView() {
        this.mLoadingDrawable.stop();
        this.mLoadingView.setVisibility(4);
    }

    private void showProgressView() {
        this.mLoadingDrawable.start();
        this.mLoadingView.setVisibility(0);
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.set_long_time_alarm_activity);
        Intent intent = getIntent();
        this.mOriginTimer = (LongTimeAlarm) intent.getParcelableExtra("key_timer");
        this.mPos = intent.getIntExtra("key_position", -1);
        if (this.mOriginTimer == null) {
            gsy.O000000o(6, "SetTimerCommonActivity", "error get timer==null");
            finish();
            return;
        }
        this.mStartTimeTip = getString(R.string.long_time_start_time);
        this.mEndTimeTip = getString(R.string.long_time_end_time);
        this.mLoadingView = (ImageView) findViewById(R.id.mj_loading);
        this.mViewName = findViewById(R.id.view_name);
        this.mTvNameDetail = (TextView) findViewById(R.id.tv_name_detail);
        this.mViewRepeat = findViewById(R.id.view_repeat);
        this.mTvRepeatDetail = (TextView) findViewById(R.id.tv_repeat_detail);
        this.mLoadingDrawable = (AnimationDrawable) this.mLoadingView.getDrawable();
        this.mViewTimerOn = findViewById(R.id.view_timer_on);
        this.mTvTimerOn = (TextView) findViewById(R.id.tv_timer_on);
        this.mTvTimerOnDetail = (TextView) findViewById(R.id.tv_timer_on_detail);
        this.mViewTimerOff = findViewById(R.id.view_timer_off);
        this.mTvTimerOff = (TextView) findViewById(R.id.tv_timer_off);
        this.mTvTimerOffDetail = (TextView) findViewById(R.id.tv_timer_off_detail);
        initTimerField();
        initTitleView();
        this.mSelectedItems = LongTimeAlarmManager.getWeekList(this.mOriginTimer.repeat);
        if (!TextUtils.isEmpty(this.mStartTimeTip)) {
            this.mTvTimerOn.setText(this.mStartTimeTip);
        }
        if (!TextUtils.isEmpty(this.mEndTimeTip)) {
            this.mTvTimerOff.setText(this.mEndTimeTip);
        }
        this.mTvRepeatDetail.setText(LongTimeAlarmManager.getRepeatStr(this, this.mRepeat));
        this.mViewRepeat.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass1 */

            public void onClick(View view) {
                SetLongTimeAlarmActivity.this.showRepeatDialog(new String[]{SetLongTimeAlarmActivity.this.getString(R.string.plug_timer_onetime), SetLongTimeAlarmActivity.this.getString(R.string.plug_timer_everyday), SetLongTimeAlarmActivity.this.getString(R.string.plug_timer_sef_define)});
            }
        });
        this.mTvTimerOnDetail.setText(LongTimeAlarmManager.formatTime(getContext(), this.mRepeat, this.mOnTime, this.mOffTime, true));
        this.mTvTimerOffDetail.setText(LongTimeAlarmManager.formatTime(getContext(), this.mRepeat, this.mOnTime, this.mOffTime, false));
        this.mViewTimerOn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass2 */

            public void onClick(View view) {
                SetLongTimeAlarmActivity.this.showOnTimeDialog();
            }
        });
        this.mViewTimerOff.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass3 */

            public void onClick(View view) {
                SetLongTimeAlarmActivity.this.showOffTimeDialog();
            }
        });
        this.mViewName.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass4 */

            public void onClick(View view) {
                final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(SetLongTimeAlarmActivity.this).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                final EditText editText = clientRemarkInputView.getEditText();
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
                MLAlertDialog O00000oo = new MLAlertDialog.Builder(SetLongTimeAlarmActivity.this).O000000o((int) R.string.long_time_name_dialogue_title).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass4.AnonymousClass2 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        clientRemarkInputView.O000000o(dialogInterface);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass4.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                    }
                }).O00000oo();
                clientRemarkInputView.O000000o(new ClientRemarkInputView.O000000o() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass4.AnonymousClass3 */

                    public void modifyBackName(String str) {
                        SetLongTimeAlarmActivity.this.mName = str;
                        if (!TextUtils.isEmpty(SetLongTimeAlarmActivity.this.mName)) {
                            SetLongTimeAlarmActivity.this.mTvNameDetail.setText(SetLongTimeAlarmActivity.this.mName);
                        } else {
                            SetLongTimeAlarmActivity.this.mTvNameDetail.setText(SetLongTimeAlarmActivity.this.getString(R.string.plug_timer_no_set));
                        }
                    }
                }, O00000oo, SetLongTimeAlarmActivity.this.mName, SetLongTimeAlarmActivity.this.mName);
                final Button button = O00000oo.getButton(-1);
                button.setEnabled(false);
                button.setTextColor(SetLongTimeAlarmActivity.this.getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
                clientRemarkInputView.getEditText().addTextChangedListener(new TextWatcher() {
                    /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass4.AnonymousClass4 */

                    public void afterTextChanged(Editable editable) {
                    }

                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        clientRemarkInputView.setAlertText("");
                        button.setEnabled(true);
                    }

                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String obj = editText.getText().toString();
                        if (obj.length() > 0) {
                            if (gqb.O00000o0(obj)) {
                                clientRemarkInputView.setAlertText(SetLongTimeAlarmActivity.this.getString(R.string.tag_save_data_description));
                            } else if (!ggb.O0000oO(obj)) {
                                clientRemarkInputView.setAlertText(SetLongTimeAlarmActivity.this.getString(R.string.room_name_too_long));
                            } else {
                                clientRemarkInputView.setAlertText("");
                                button.setEnabled(true);
                                return;
                            }
                        }
                        button.setEnabled(false);
                    }
                });
            }
        });
        if (!TextUtils.isEmpty(this.mName)) {
            this.mTvNameDetail.setText(this.mName);
        } else {
            this.mTvNameDetail.setText(getString(R.string.plug_timer_no_set));
        }
        initProgressDialog();
    }

    private void initTimerField() {
        this.mName = this.mOriginTimer.alarmValue;
        this.mOnTime = this.mOriginTimer.time_start;
        this.mOffTime = this.mOriginTimer.time_end;
        this.mRepeat = this.mOriginTimer.repeat;
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.gateway_magnet_location_updating));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void showOffTimeDialog() {
        String str = this.mOffTime;
        final LongTimeChooseTimeDialog longTimeChooseTimeDialog = new LongTimeChooseTimeDialog(this, str, this.mOnTime, str, this.mRepeat, false);
        longTimeChooseTimeDialog.setCancelable(true);
        longTimeChooseTimeDialog.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                TimePicker timePicker = longTimeChooseTimeDialog.getTimePicker();
                if (timePicker != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(timePicker.getCurrentHour());
                    String sb2 = sb.toString();
                    if (sb2.length() < 2) {
                        sb2 = "0".concat(String.valueOf(sb2));
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(timePicker.getCurrentMinute());
                    String sb4 = sb3.toString();
                    if (sb4.length() < 2) {
                        sb4 = "0".concat(String.valueOf(sb4));
                    }
                    SetLongTimeAlarmActivity setLongTimeAlarmActivity = SetLongTimeAlarmActivity.this;
                    setLongTimeAlarmActivity.mOffTime = sb2 + ":" + sb4;
                    SetLongTimeAlarmActivity.this.updateChooseTimeUI();
                }
            }
        });
        longTimeChooseTimeDialog.setNegativeButton(R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        longTimeChooseTimeDialog.show();
        longTimeChooseTimeDialog.setMyCustomTitle(R.string.plug_timer_off_time);
    }

    public void showOnTimeDialog() {
        String str = this.mOnTime;
        final LongTimeChooseTimeDialog longTimeChooseTimeDialog = new LongTimeChooseTimeDialog(this, str, str, this.mOffTime, this.mRepeat, true);
        longTimeChooseTimeDialog.setCancelable(true);
        longTimeChooseTimeDialog.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass7 */

            public void onClick(DialogInterface dialogInterface, int i) {
                TimePicker timePicker = longTimeChooseTimeDialog.getTimePicker();
                if (timePicker != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(timePicker.getCurrentHour());
                    String sb2 = sb.toString();
                    if (sb2.length() < 2) {
                        sb2 = "0".concat(String.valueOf(sb2));
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(timePicker.getCurrentMinute());
                    String sb4 = sb3.toString();
                    if (sb4.length() < 2) {
                        sb4 = "0".concat(String.valueOf(sb4));
                    }
                    SetLongTimeAlarmActivity setLongTimeAlarmActivity = SetLongTimeAlarmActivity.this;
                    setLongTimeAlarmActivity.mOnTime = sb2 + ":" + sb4;
                    SetLongTimeAlarmActivity.this.updateChooseTimeUI();
                }
            }
        });
        longTimeChooseTimeDialog.setNegativeButton(R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass8 */

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        longTimeChooseTimeDialog.show();
        longTimeChooseTimeDialog.setMyCustomTitle(R.string.plug_timer_on_time);
    }

    private void initTitleView() {
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_return_btn);
        imageView.setImageResource(R.drawable.title_cancel_selector);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass9 */

                public void onClick(View view) {
                    if (SetLongTimeAlarmActivity.this.isModified()) {
                        SetLongTimeAlarmActivity.this.showConfirmDialog();
                    } else {
                        SetLongTimeAlarmActivity.this.finish();
                    }
                }
            });
        }
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.long_time_type_period);
        View findViewById = findViewById(R.id.module_a_3_right_iv_confirm_btn);
        if (findViewById != null) {
            findViewById.setContentDescription(getString(R.string.confirm_button));
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass10 */

                public void onClick(View view) {
                    SetLongTimeAlarmActivity setLongTimeAlarmActivity = SetLongTimeAlarmActivity.this;
                    setLongTimeAlarmActivity.mNewTimer = setLongTimeAlarmActivity.buildTimerFromUi();
                    if (TextUtils.isEmpty(SetLongTimeAlarmActivity.this.mNewTimer.alarmValue)) {
                        gqg.O00000Oo((int) R.string.add_feature_empty_tips);
                    } else if (TextUtils.isEmpty(SetLongTimeAlarmActivity.this.mNewTimer.time_start) || TextUtils.isEmpty(SetLongTimeAlarmActivity.this.mNewTimer.time_end)) {
                        gqg.O00000Oo((int) R.string.plug_timer_unset);
                    } else if (!LongTimeAlarmManager.isLegalTimer(SetLongTimeAlarmActivity.this.mNewTimer)) {
                        gqg.O00000Oo((int) R.string.plug_timer_offtime_illegal);
                    } else {
                        Intent intent = SetLongTimeAlarmActivity.this.getIntent();
                        intent.putExtra("key_timer", SetLongTimeAlarmActivity.this.mNewTimer);
                        intent.putExtra("key_position", SetLongTimeAlarmActivity.this.mPos);
                        SetLongTimeAlarmActivity.this.setResult(-1, intent);
                        SetLongTimeAlarmActivity.this.finish();
                    }
                }
            });
        }
    }

    public void showRepeatDialog(String[] strArr) {
        int i = this.mRepeat;
        int i2 = -1;
        if (i != -1) {
            i2 = i != 0 ? i != 127 ? strArr.length : 1 : 0;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_repeat_selection).O000000o(strArr, i2, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.$$Lambda$SetLongTimeAlarmActivity$jfRwvh9Hlvhj4t1onSuYB4Bef64 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SetLongTimeAlarmActivity.this.lambda$showRepeatDialog$0$SetLongTimeAlarmActivity(dialogInterface, i);
            }
        }).O00000o().show();
    }

    public /* synthetic */ void lambda$showRepeatDialog$0$SetLongTimeAlarmActivity(DialogInterface dialogInterface, int i) {
        this.mTvRepeatDetail.setText(getInterNationRepeatString(i));
        updateChooseTimeUI();
        dialogInterface.cancel();
    }

    private String getInterNationRepeatString(int i) {
        if (i == 0) {
            this.mRepeat = 0;
        } else if (i == 1) {
            this.mRepeat = 127;
        } else if (i == 2) {
            showSubRepeatDialog();
        }
        return LongTimeAlarmManager.getRepeatStr(this, this.mRepeat);
    }

    private void showSubRepeatDialog() {
        this.mSelectedItems = LongTimeAlarmManager.getWeekList(this.mRepeat);
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_custom_repeat).O000000o(getResources().getTextArray(R.array.weekday_long_time), this.mSelectedItems, new DialogInterface.OnMultiChoiceClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass13 */

            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SetLongTimeAlarmActivity.this.mSelectedItems[i] = z;
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass12 */

            public void onClick(DialogInterface dialogInterface, int i) {
                SetLongTimeAlarmActivity setLongTimeAlarmActivity = SetLongTimeAlarmActivity.this;
                setLongTimeAlarmActivity.mSelectedItems = LongTimeAlarmManager.getWeekList(setLongTimeAlarmActivity.mRepeat);
            }
        }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass11 */

            public void onClick(DialogInterface dialogInterface, int i) {
                boolean z = false;
                for (boolean z2 : SetLongTimeAlarmActivity.this.mSelectedItems) {
                    z |= z2;
                }
                if (z) {
                    for (int i2 = 0; i2 < SetLongTimeAlarmActivity.this.mSelectedItems.length; i2++) {
                        SetLongTimeAlarmActivity setLongTimeAlarmActivity = SetLongTimeAlarmActivity.this;
                        setLongTimeAlarmActivity.mRepeat = LongTimeAlarmManager.getRepeat(setLongTimeAlarmActivity.mSelectedItems);
                    }
                    TextView textView = SetLongTimeAlarmActivity.this.mTvRepeatDetail;
                    SetLongTimeAlarmActivity setLongTimeAlarmActivity2 = SetLongTimeAlarmActivity.this;
                    textView.setText(LongTimeAlarmManager.getRepeatStr(setLongTimeAlarmActivity2, setLongTimeAlarmActivity2.mRepeat));
                    SetLongTimeAlarmActivity.this.updateChooseTimeUI();
                }
            }
        }).O00000oo();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("original.timer", this.mOriginTimer);
        bundle.putParcelable("current.timer", buildTimerFromUi());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        LongTimeAlarm longTimeAlarm = (LongTimeAlarm) bundle.getParcelable("original.timer");
        if (longTimeAlarm != null) {
            this.mOriginTimer = longTimeAlarm;
        }
        LongTimeAlarm longTimeAlarm2 = (LongTimeAlarm) bundle.getParcelable("current.timer");
        if (longTimeAlarm2 != null) {
            update(longTimeAlarm2);
        }
    }

    private void update(LongTimeAlarm longTimeAlarm) {
        this.mName = longTimeAlarm.alarmValue;
        this.mOnTime = longTimeAlarm.time_start;
        this.mOffTime = longTimeAlarm.time_end;
        this.mRepeat = longTimeAlarm.repeat;
    }

    public void updateChooseTimeUI() {
        this.mTvTimerOnDetail.setText(LongTimeAlarmManager.formatTime(getContext(), this.mRepeat, this.mOnTime, this.mOffTime, true));
        this.mTvTimerOffDetail.setText(LongTimeAlarmManager.formatTime(getContext(), this.mRepeat, this.mOnTime, this.mOffTime, false));
    }

    public void onBackPressed() {
        if (isModified()) {
            showConfirmDialog();
        } else {
            finish();
        }
    }

    public void showConfirmDialog() {
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_dialog_confirm_abort).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.plug_confirm_abort, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SetLongTimeAlarmActivity.AnonymousClass14 */

            public void onClick(DialogInterface dialogInterface, int i) {
                SetLongTimeAlarmActivity.this.finish();
            }
        }).O00000oo();
    }

    public boolean isModified() {
        String str = this.mName;
        if (str == null || this.mOnTime == null || this.mOffTime == null) {
            return false;
        }
        if (str != this.mOriginTimer.alarmValue || !this.mOnTime.equals(this.mOriginTimer.time_start) || !this.mOffTime.equals(this.mOriginTimer.time_end) || this.mOriginTimer.repeat != this.mRepeat) {
            return true;
        }
        return false;
    }

    public LongTimeAlarm buildTimerFromUi() {
        LongTimeAlarm longTimeAlarm = new LongTimeAlarm();
        longTimeAlarm.alarmValue = this.mName;
        longTimeAlarm.enable = true;
        longTimeAlarm.time_start = this.mOnTime;
        longTimeAlarm.time_end = this.mOffTime;
        longTimeAlarm.repeat = this.mRepeat;
        return longTimeAlarm;
    }
}
