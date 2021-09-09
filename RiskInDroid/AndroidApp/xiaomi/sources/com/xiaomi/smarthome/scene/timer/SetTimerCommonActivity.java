package com.xiaomi.smarthome.scene.timer;

import _m_j.fno;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hre;
import _m_j.hrf;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import com.xiaomi.smarthome.scene.timer.dialog.ChooseTimeDialog;
import java.lang.ref.WeakReference;
import java.util.Calendar;

public class SetTimerCommonActivity extends BaseActivity implements hrf.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f11251O000000o;
    private View O00000Oo;
    private View O00000o;
    private int O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private TextView O0000Oo;
    private View O0000Oo0;
    private TextView O0000OoO;
    private boolean O0000Ooo;
    private ImageView O0000o;
    private String O0000o0;
    private String O0000o00;
    private XQProgressDialog O0000o0O;
    private AnimationDrawable O0000o0o;
    private O000000o O0000oO = new O000000o(this);
    private String O0000oO0;
    public String mEndTimeTip;
    public boolean mForceBothTimerSet = true;
    public boolean mIsOffSet;
    public boolean mIsOnSet;
    public boolean mOff;
    public CorntabUtils.CorntabParam mOffTime;
    public boolean mOn;
    public CorntabUtils.CorntabParam mOnTime;
    public CommonTimer mOriginTimer;
    public boolean[] mSelectedItems;
    public String mStartTimeTip;
    public hrf mTimerCommonManager;
    public String mTimerIdentifyRn;
    public TextView mTvRepeatDetail;
    public String offMethod;
    public String offParams;
    public String onMethod;
    public String onParams;

    public void onGetSceneFailed(int i) {
    }

    public void onGetSceneSuccess() {
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<SetTimerCommonActivity> f11265O000000o;

        public O000000o(SetTimerCommonActivity setTimerCommonActivity) {
            this.f11265O000000o = new WeakReference<>(setTimerCommonActivity);
        }

        public final void handleMessage(Message message) {
            SetTimerCommonActivity setTimerCommonActivity = this.f11265O000000o.get();
            if (setTimerCommonActivity != null) {
                int i = message.what;
                if (i == 1) {
                    CommonTimer commonTimer = (CommonTimer) message.obj;
                    if (!(commonTimer == null || commonTimer.O0000o0o == 0)) {
                        gqg.O000000o((int) R.string.about_check_update_new, 1);
                    }
                    setTimerCommonActivity.hideProgressView();
                    setTimerCommonActivity.finish();
                } else if (i == 2) {
                    setTimerCommonActivity.hideProgressView();
                    gqg.O00000Oo((int) R.string.intelligent_plug_failed);
                } else if (i == 3) {
                    setTimerCommonActivity.hideProgressView();
                    gqg.O00000Oo((int) R.string.smarthome_scene_client_deleted);
                }
            }
        }
    }

    public void hideProgressView() {
        this.O0000o0o.stop();
        this.O0000o.setVisibility(4);
    }

    public void showProgressView() {
        this.O0000o0o.start();
        this.O0000o.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.plug_set_timer_activity);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("is_group", false)) {
            this.mTimerCommonManager = hre.O000000o();
        } else {
            this.mTimerCommonManager = hrf.O0000O0o();
        }
        this.mOriginTimer = (CommonTimer) intent.getParcelableExtra("common.timer");
        if (this.mOriginTimer == null) {
            gsy.O000000o(6, "SetTimerCommonActivity", "error get timer==null");
            finish();
        }
        if (!TextUtils.isEmpty(this.mOriginTimer.O00000Oo) && !(this.mTimerCommonManager instanceof hre)) {
            this.mTimerCommonManager.O000000o(fno.O000000o().O000000o(this.mOriginTimer.O00000Oo), this.mOriginTimer.O00000o, this.mOriginTimer.O00000o0);
        }
        this.f11251O000000o = intent.getBooleanExtra("action.add.common.timer", false);
        this.O0000oO0 = intent.getStringExtra("custom_title_text");
        this.O00000o0 = intent.getIntExtra("timer_type", 0);
        this.mTimerIdentifyRn = intent.getStringExtra("timer_identify_rn");
        this.mForceBothTimerSet = intent.getBooleanExtra("both_timer_must_be_set", false);
        this.mStartTimeTip = intent.getStringExtra("on_timer_tips");
        this.mEndTimeTip = intent.getStringExtra("off_timer_tips");
        this.O0000o = (ImageView) findViewById(R.id.mj_loading);
        this.O00000Oo = findViewById(R.id.view_repeat);
        this.mTvRepeatDetail = (TextView) findViewById(R.id.tv_repeat_detail);
        this.O0000o0o = (AnimationDrawable) this.O0000o.getDrawable();
        this.O00000o = findViewById(R.id.view_timer_on);
        this.O00000oO = findViewById(R.id.timer_on_divider);
        this.O00000oo = (TextView) findViewById(R.id.tv_timer_on);
        this.O0000O0o = (TextView) findViewById(R.id.tv_timer_on_detail);
        this.O0000OOo = findViewById(R.id.view_timer_off);
        this.O0000Oo0 = findViewById(R.id.timer_off_divider);
        this.O0000Oo = (TextView) findViewById(R.id.tv_timer_off);
        this.O0000OoO = (TextView) findViewById(R.id.tv_timer_off_detail);
        this.O0000Ooo = this.mOriginTimer.O00000oo;
        this.O0000o0 = this.mOriginTimer.O00000o0;
        this.O0000o00 = this.mOriginTimer.f11210O000000o;
        this.onMethod = this.mOriginTimer.O0000OOo;
        this.onParams = this.mOriginTimer.O0000Oo0;
        this.offMethod = this.mOriginTimer.O0000Ooo;
        this.offParams = this.mOriginTimer.O0000o00;
        this.mOn = this.mOriginTimer.O0000O0o;
        this.mOnTime = (CorntabUtils.CorntabParam) this.mOriginTimer.O0000Oo.clone();
        this.mOff = this.mOriginTimer.O0000OoO;
        this.mOffTime = (CorntabUtils.CorntabParam) this.mOriginTimer.O0000o0.clone();
        ImageView imageView = (ImageView) findViewById(R.id.module_a_3_return_btn);
        imageView.setImageResource(R.drawable.title_cancel_selector);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass12 */

                public final void onClick(View view) {
                    if (SetTimerCommonActivity.this.isModified()) {
                        SetTimerCommonActivity.this.showConfirmDialog();
                    } else {
                        SetTimerCommonActivity.this.finish();
                    }
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        if (!TextUtils.isEmpty(this.O0000oO0)) {
            textView.setText(this.O0000oO0);
        } else if (this.mOn && this.mOff) {
            textView.setText((int) R.string.plug_timer_type_period);
        } else if (this.mOn) {
            textView.setText((int) R.string.plug_timer_type_on);
        } else if (this.mOff) {
            textView.setText((int) R.string.plug_timer_type_off);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.module_a_3_right_iv_confirm_btn);
        if (imageView2 != null) {
            imageView2.setContentDescription(getString(R.string.confirm_button));
            imageView2.setImageResource(R.drawable.mj_selector_rec_confirm);
            imageView2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass13 */

                public final void onClick(View view) {
                    String str;
                    String str2;
                    CommonTimer buildTimerFromUi = SetTimerCommonActivity.this.buildTimerFromUi();
                    if (!SetTimerCommonActivity.this.mTimerCommonManager.O000000o(buildTimerFromUi)) {
                        gqg.O00000Oo((int) R.string.plug_timer_offtime_illegal);
                    } else if (!SetTimerCommonActivity.this.mIsOnSet && !SetTimerCommonActivity.this.mIsOffSet) {
                        gqg.O00000Oo((int) R.string.plug_timer_unset);
                    } else if (SetTimerCommonActivity.this.mForceBothTimerSet && (!buildTimerFromUi.O0000OoO || !buildTimerFromUi.O0000O0o)) {
                        Resources resources = SetTimerCommonActivity.this.getResources();
                        if (!buildTimerFromUi.O0000OoO) {
                            String string = resources.getString(R.string.plug_timer_off_time);
                            if (TextUtils.isEmpty(SetTimerCommonActivity.this.mEndTimeTip)) {
                                str2 = resources.getString(R.string.timer_must_be_set, string);
                            } else {
                                str2 = resources.getString(R.string.timer_must_be_set, SetTimerCommonActivity.this.mEndTimeTip);
                            }
                            gqg.O00000Oo(str2);
                        } else if (!buildTimerFromUi.O0000O0o) {
                            String string2 = resources.getString(R.string.plug_timer_on_time);
                            if (TextUtils.isEmpty(SetTimerCommonActivity.this.mStartTimeTip)) {
                                str = resources.getString(R.string.timer_must_be_set, string2);
                            } else {
                                str = resources.getString(R.string.timer_must_be_set, SetTimerCommonActivity.this.mStartTimeTip);
                            }
                            gqg.O00000Oo(str);
                        }
                    } else if (SetTimerCommonActivity.this.timerHasSet(buildTimerFromUi)) {
                        gqg.O00000Oo((int) R.string.plug_timer_has_setted);
                    } else {
                        SetTimerCommonActivity.this.showProgressView();
                        SetTimerCommonActivity.this.mTimerCommonManager.O000000o(SetTimerCommonActivity.this.mOriginTimer, buildTimerFromUi, SetTimerCommonActivity.this.mTimerIdentifyRn);
                    }
                }
            });
        }
        this.mSelectedItems = (boolean[]) this.mOriginTimer.O0000Oo.O0000O0o.clone();
        if (!TextUtils.isEmpty(this.mStartTimeTip)) {
            this.O00000oo.setText(this.mStartTimeTip);
        }
        if (!TextUtils.isEmpty(this.mEndTimeTip)) {
            this.O0000Oo.setText(this.mEndTimeTip);
        }
        String O000000o2 = this.mOnTime.O000000o((Context) this);
        if (O000000o2.equals(getString(R.string.plug_timer_today)) || O000000o2.equals(getString(R.string.plug_timer_tomorrow))) {
            O000000o2 = getString(R.string.plug_timer_onetime);
        }
        this.mTvRepeatDetail.setText(O000000o2);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SetTimerCommonActivity.this.showRepeatDialog((ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || hrf.O0000O0o().O0000OOo()) ? new String[]{SetTimerCommonActivity.this.getString(R.string.plug_timer_onetime), SetTimerCommonActivity.this.getString(R.string.plug_timer_everyday), SetTimerCommonActivity.this.getString(R.string.plug_timer_sef_define)} : new String[]{SetTimerCommonActivity.this.getString(R.string.plug_timer_onetime), SetTimerCommonActivity.this.getString(R.string.plug_timer_everyday), SetTimerCommonActivity.this.getString(R.string.plug_timer_statutory_workingday), SetTimerCommonActivity.this.getString(R.string.plug_timer_statutory_holidays), SetTimerCommonActivity.this.getString(R.string.plug_timer_sef_define)});
            }
        });
        if (this.mOn && this.mOff) {
            TextView textView2 = this.O0000O0o;
            Context context = getContext();
            CorntabUtils.CorntabParam corntabParam = this.mOnTime;
            textView2.setText(PlugTimer.O000000o(context, corntabParam, this.mOffTime, this.mOn, corntabParam.O00000o0, this.mOnTime.O00000Oo, true));
            TextView textView3 = this.O0000OoO;
            Context context2 = getContext();
            CorntabUtils.CorntabParam corntabParam2 = this.mOnTime;
            CorntabUtils.CorntabParam corntabParam3 = this.mOffTime;
            textView3.setText(PlugTimer.O000000o(context2, corntabParam2, corntabParam3, this.mOn, corntabParam3.O00000o0, this.mOffTime.O00000Oo, false));
            this.mIsOnSet = true;
            this.mIsOffSet = true;
        } else if (this.mOn && !this.mOff) {
            TextView textView4 = this.O0000O0o;
            Context context3 = getContext();
            CorntabUtils.CorntabParam corntabParam4 = this.mOnTime;
            textView4.setText(PlugTimer.O000000o(context3, corntabParam4, this.mOffTime, this.mOn, corntabParam4.O00000o0, this.mOnTime.O00000Oo, true));
            this.mIsOnSet = true;
            this.O0000OoO.setText((int) R.string.plug_timer_no_set);
            this.mIsOffSet = false;
        } else if (!this.mOn && this.mOff) {
            this.O0000O0o.setText((int) R.string.plug_timer_no_set);
            this.mIsOnSet = false;
            TextView textView5 = this.O0000OoO;
            Context context4 = getContext();
            CorntabUtils.CorntabParam corntabParam5 = this.mOnTime;
            CorntabUtils.CorntabParam corntabParam6 = this.mOffTime;
            textView5.setText(PlugTimer.O000000o(context4, corntabParam5, corntabParam6, this.mOn, corntabParam6.O00000o0, this.mOffTime.O00000Oo, false));
            this.mIsOffSet = true;
        } else if (!this.mOn && !this.mOff) {
            this.O0000O0o.setText((int) R.string.plug_timer_no_set);
            this.O0000OoO.setText((int) R.string.plug_timer_no_set);
            this.mIsOnSet = false;
            this.mIsOffSet = false;
        }
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass6 */

            public final void onClick(View view) {
                SetTimerCommonActivity.this.showOnTimeDialog();
            }
        });
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass7 */

            public final void onClick(View view) {
                SetTimerCommonActivity.this.showOffTimeDialog();
            }
        });
        if (TextUtils.isEmpty(this.onMethod) || this.O00000o0 == 2) {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.offMethod) || this.O00000o0 == 1) {
            this.O0000OOo.setVisibility(8);
            this.O0000Oo0.setVisibility(8);
        }
        this.O0000o0O = new XQProgressDialog(this);
        this.O0000o0O.setMessage(getString(R.string.gateway_magnet_location_updating));
        this.O0000o0O.setCancelable(true);
        this.mTimerCommonManager.O000000o(this);
    }

    public void onDestroy() {
        this.mTimerCommonManager.O00000Oo(this);
        this.O0000oO.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
    }

    public void showOffTimeDialog() {
        CorntabUtils.CorntabParam corntabParam = this.mOffTime;
        final ChooseTimeDialog chooseTimeDialog = new ChooseTimeDialog(this, corntabParam, this.mOnTime, corntabParam, this.mOn, this.mOff, false);
        chooseTimeDialog.setCancelable(true);
        chooseTimeDialog.O000000o(new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass8 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                TimePicker timePicker = chooseTimeDialog.f11266O000000o;
                if (timePicker != null) {
                    SetTimerCommonActivity setTimerCommonActivity = SetTimerCommonActivity.this;
                    setTimerCommonActivity.mOff = true;
                    setTimerCommonActivity.mIsOffSet = true;
                    setTimerCommonActivity.mOffTime.O00000o0 = timePicker.getCurrentHour().intValue();
                    SetTimerCommonActivity.this.mOffTime.O00000Oo = timePicker.getCurrentMinute().intValue();
                    SetTimerCommonActivity.this.updateChooseTimeUI();
                }
            }
        });
        chooseTimeDialog.O00000Oo(new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass9 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        chooseTimeDialog.show();
        chooseTimeDialog.O000000o((int) R.string.plug_timer_off_time);
    }

    public void showOnTimeDialog() {
        CorntabUtils.CorntabParam corntabParam = this.mOnTime;
        final ChooseTimeDialog chooseTimeDialog = new ChooseTimeDialog(this, corntabParam, corntabParam, this.mOffTime, this.mOn, this.mOff, true);
        chooseTimeDialog.setCancelable(true);
        chooseTimeDialog.O000000o(new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass10 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                TimePicker timePicker = chooseTimeDialog.f11266O000000o;
                if (timePicker != null) {
                    SetTimerCommonActivity setTimerCommonActivity = SetTimerCommonActivity.this;
                    setTimerCommonActivity.mOn = true;
                    setTimerCommonActivity.mIsOnSet = true;
                    setTimerCommonActivity.mOnTime.O00000o0 = timePicker.getCurrentHour().intValue();
                    SetTimerCommonActivity.this.mOnTime.O00000Oo = timePicker.getCurrentMinute().intValue();
                    SetTimerCommonActivity.this.updateChooseTimeUI();
                }
            }
        });
        chooseTimeDialog.O00000Oo(new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        chooseTimeDialog.show();
        chooseTimeDialog.O000000o((int) R.string.plug_timer_on_time);
    }

    public boolean timerHasSet(CommonTimer commonTimer) {
        for (CommonTimer next : this.mTimerCommonManager.O00000o0()) {
            if (next.O0000O0o == commonTimer.O0000O0o && next.O0000OoO == commonTimer.O0000OoO) {
                if (!next.O0000O0o || (next.O0000Oo.O000000o((Object) commonTimer.O0000Oo) && TextUtils.equals(next.O0000Oo.O0000OOo, commonTimer.O0000Oo.O0000OOo))) {
                    if (!next.O0000OoO) {
                        return true;
                    }
                    if (next.O0000o0.O000000o((Object) commonTimer.O0000o0) && TextUtils.equals(next.O0000o0.O0000OOo, commonTimer.O0000o0.O0000OOo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void showRepeatDialog(String[] strArr) {
        int O00000Oo2 = this.mOnTime.O00000Oo();
        int i = 1;
        if (O00000Oo2 == 0) {
            i = 0;
        } else if (O00000Oo2 != 1) {
            i = O00000Oo2 != 4 ? O00000Oo2 != 5 ? O00000Oo2 != 6 ? -1 : 3 : 2 : strArr.length;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_repeat_selection).O000000o(strArr, i, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.$$Lambda$SetTimerCommonActivity$NQ2TyeIppg6WnOZ3OUmpFFrmFQ4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SetTimerCommonActivity.this.O000000o(dialogInterface, i);
            }
        }).O00000o().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        String str;
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || hrf.O0000O0o().O0000OOo()) {
            if (i == 0) {
                this.mOnTime.O000000o(0);
                this.mOffTime.O000000o(0);
                this.mOnTime.O0000OOo = "";
                this.mOffTime.O0000OOo = "";
            } else if (i == 1) {
                this.mOnTime.O000000o(127);
                this.mOffTime.O000000o(127);
                this.mOnTime.O0000OOo = "";
                this.mOffTime.O0000OOo = "";
            } else if (i == 2) {
                O000000o();
            }
            str = this.mOnTime.O000000o((Context) this);
            if (str.equals(getString(R.string.plug_timer_today)) || str.equals(getString(R.string.plug_timer_tomorrow))) {
                str = getString(R.string.plug_timer_onetime);
            }
        } else {
            if (i == 0) {
                this.mOnTime.O000000o(0);
                this.mOffTime.O000000o(0);
                this.mOnTime.O0000OOo = "";
                this.mOffTime.O0000OOo = "";
            } else if (i == 1) {
                this.mOnTime.O000000o(127);
                this.mOffTime.O000000o(127);
                this.mOnTime.O0000OOo = "";
                this.mOffTime.O0000OOo = "";
            } else if (i == 2) {
                this.mOnTime.O000000o(127);
                this.mOffTime.O000000o(127);
                this.mOnTime.O0000OOo = "cn_workday";
                this.mOffTime.O0000OOo = "cn_workday";
            } else if (i == 3) {
                this.mOnTime.O000000o(127);
                this.mOffTime.O000000o(127);
                this.mOnTime.O0000OOo = "cn_freeday";
                this.mOffTime.O0000OOo = "cn_freeday";
            } else if (i == 4) {
                O000000o();
            }
            str = this.mOnTime.O000000o((Context) this);
            if (str.equals(getString(R.string.plug_timer_today)) || str.equals(getString(R.string.plug_timer_tomorrow))) {
                str = getString(R.string.plug_timer_onetime);
            }
        }
        this.mTvRepeatDetail.setText(str);
        updateChooseTimeUI();
        dialogInterface.cancel();
    }

    private void O000000o() {
        this.mSelectedItems = (boolean[]) this.mOnTime.O0000O0o.clone();
        new MLAlertDialog.Builder(this).O000000o((int) R.string.plug_timer_custom_repeat).O000000o(getResources().getTextArray(R.array.weekday_short), this.mSelectedItems, new DialogInterface.OnMultiChoiceClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SetTimerCommonActivity.this.mSelectedItems[i] = z;
            }
        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                for (int i2 = 0; i2 < SetTimerCommonActivity.this.mOnTime.O0000O0o.length; i2++) {
                    SetTimerCommonActivity.this.mSelectedItems[i2] = SetTimerCommonActivity.this.mOnTime.O0000O0o[i2];
                }
            }
        }).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = false;
                for (boolean z2 : SetTimerCommonActivity.this.mSelectedItems) {
                    z |= z2;
                }
                if (z) {
                    for (int i2 = 0; i2 < SetTimerCommonActivity.this.mSelectedItems.length; i2++) {
                        SetTimerCommonActivity.this.mOnTime.O000000o(i2, SetTimerCommonActivity.this.mSelectedItems[i2]);
                        SetTimerCommonActivity.this.mOffTime.O000000o(i2, SetTimerCommonActivity.this.mSelectedItems[i2]);
                    }
                    SetTimerCommonActivity.this.mOnTime.O0000OOo = "";
                    SetTimerCommonActivity.this.mOffTime.O0000OOo = "";
                    SetTimerCommonActivity.this.mTvRepeatDetail.setText(SetTimerCommonActivity.this.mOnTime.O000000o((Context) SetTimerCommonActivity.this));
                    SetTimerCommonActivity.this.updateChooseTimeUI();
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
        CommonTimer commonTimer = (CommonTimer) bundle.getParcelable("original.timer");
        if (commonTimer != null) {
            this.mOriginTimer = commonTimer;
        }
        CommonTimer commonTimer2 = (CommonTimer) bundle.getParcelable("current.timer");
        if (commonTimer2 != null) {
            this.O0000Ooo = commonTimer2.O00000oo;
            this.O0000o0 = commonTimer2.O00000o0;
            this.onMethod = commonTimer2.O0000OOo;
            this.onParams = commonTimer2.O0000Oo0;
            this.O0000o00 = commonTimer2.f11210O000000o;
            this.offMethod = commonTimer2.O0000Ooo;
            this.offParams = commonTimer2.O0000o00;
            this.mOn = commonTimer2.O0000O0o;
            this.mOnTime = commonTimer2.O0000Oo;
            this.mOff = commonTimer2.O0000OoO;
            this.mOffTime = commonTimer2.O0000o0;
        }
    }

    public void updateChooseTimeUI() {
        if (this.mOn) {
            TextView textView = this.O0000O0o;
            Context context = getContext();
            CorntabUtils.CorntabParam corntabParam = this.mOnTime;
            textView.setText(PlugTimer.O000000o(context, corntabParam, this.mOffTime, this.mOn, corntabParam.O00000o0, this.mOnTime.O00000Oo, true));
        }
        if (this.mOff) {
            TextView textView2 = this.O0000OoO;
            Context context2 = getContext();
            CorntabUtils.CorntabParam corntabParam2 = this.mOnTime;
            CorntabUtils.CorntabParam corntabParam3 = this.mOffTime;
            textView2.setText(PlugTimer.O000000o(context2, corntabParam2, corntabParam3, this.mOn, corntabParam3.O00000o0, this.mOffTime.O00000Oo, false));
        }
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
            /* class com.xiaomi.smarthome.scene.timer.SetTimerCommonActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SetTimerCommonActivity.this.finish();
            }
        }).O00000oo();
    }

    public boolean isModified() {
        return this.mOriginTimer.O0000O0o != this.mOn || !this.mOriginTimer.O0000Oo.equals(this.mOnTime) || this.mOriginTimer.O0000OoO != this.mOff || !this.mOriginTimer.O0000o0.equals(this.mOffTime);
    }

    public CommonTimer buildTimerFromUi() {
        CommonTimer commonTimer = new CommonTimer();
        commonTimer.O00000o0 = this.O0000o0;
        commonTimer.O0000OOo = this.onMethod;
        commonTimer.O0000Oo0 = this.onParams;
        commonTimer.f11210O000000o = this.O0000o00;
        commonTimer.O0000Ooo = this.offMethod;
        commonTimer.O0000o00 = this.offParams;
        commonTimer.O00000oo = true;
        commonTimer.O0000Oo = (CorntabUtils.CorntabParam) this.mOnTime.clone();
        int i = this.O00000o0;
        boolean z = false;
        if (i == 2) {
            commonTimer.O0000O0o = false;
            commonTimer.O0000OoO = true;
        } else if (i == 1) {
            commonTimer.O0000O0o = true;
            commonTimer.O0000OoO = false;
        } else if (i == 0) {
            commonTimer.O0000O0o = this.mOn;
            commonTimer.O0000OoO = this.mOff;
        }
        commonTimer.O0000o0 = (CorntabUtils.CorntabParam) this.mOffTime.clone();
        if (this.mOnTime.O00000Oo() == 0) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            int i2 = instance.get(11);
            int i3 = instance.get(12);
            if (!commonTimer.O0000O0o || (i2 * 60) + i3 < (commonTimer.O0000Oo.O00000o0 * 60) + commonTimer.O0000Oo.O00000Oo) {
                commonTimer.O0000Oo.O00000o = instance2.get(5);
                commonTimer.O0000Oo.O00000oO = instance2.get(2) + 1;
            } else {
                instance2.setTimeInMillis(instance.getTimeInMillis() + 86400000);
                commonTimer.O0000Oo.O00000o = instance2.get(5);
                commonTimer.O0000Oo.O00000oO = instance2.get(2) + 1;
                z = true;
            }
            Calendar instance3 = Calendar.getInstance();
            if (z || (commonTimer.O0000OoO && (i2 * 60) + i3 >= (commonTimer.O0000o0.O00000o0 * 60) + commonTimer.O0000o0.O00000Oo)) {
                instance3.setTimeInMillis(instance.getTimeInMillis() + 86400000);
            }
            commonTimer.O0000o0.O00000o = instance3.get(5);
            commonTimer.O0000o0.O00000oO = instance3.get(2) + 1;
        }
        return commonTimer;
    }

    public void onSetSceneSuccess(CommonTimer commonTimer) {
        Message obtainMessage = this.O0000oO.obtainMessage(1);
        obtainMessage.obj = commonTimer;
        this.O0000oO.sendMessage(obtainMessage);
    }

    public void onSetSceneFailed(fso fso) {
        if (fso.f17063O000000o == -4003406) {
            this.O0000oO.sendMessage(this.O0000oO.obtainMessage(3));
            return;
        }
        this.O0000oO.sendMessage(this.O0000oO.obtainMessage(2));
    }
}
