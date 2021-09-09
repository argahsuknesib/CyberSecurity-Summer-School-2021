package com.xiaomi.smarthome.uwb.lib.mitv.widget;

import _m_j.hzf;
import _m_j.oOOO00o0;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.uwb.api.UwbMitvApi;
import com.xiaomi.smarthome.uwb.lib.mitv.UwbVoiceManager;
import com.xiaomi.smarthome.uwb.lib.mitv.data.MitvInfo;
import com.xiaomi.smarthome.uwb.lib.mitv.widget.LPImageView;
import com.xiaomi.smarthome.uwb.lib.utils.UIUtils;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;

public class MitvCardView extends RelativeLayout {
    public static final String TAG = "com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView";
    boolean mBlueToothReady = false;
    boolean mIsSupoortMiplay = false;
    boolean mIsSupportXiaoAi = false;
    View mLlVoiceAnim;
    MitvInfo mMitvInfo;
    TextView mMoreBtn;
    View mMoreLayout;
    TextView mNameTv;
    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView.AnonymousClass1 */

        public void onClick(View view) {
            MitvCardView.this.onViewClick(view);
        }
    };
    LPImageView.PadLayoutListener mPadLayoutListener;
    ImageView mPoweIv;
    View.OnClickListener mStatOnClickListener;
    TvPadView mTvPadView;
    LottieAnimationView mTvlAnim;
    UwbVoiceManager mUwbVoiceManager;

    public MitvCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setmStatOnClickListener(View.OnClickListener onClickListener) {
        this.mStatOnClickListener = onClickListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mNameTv = (TextView) findViewById(R.id.name_tv);
        this.mPoweIv = (ImageView) findViewById(R.id.power_iv);
        this.mTvPadView = (TvPadView) findViewById(R.id.pad_l);
        this.mTvlAnim = (LottieAnimationView) findViewById(R.id.tvlAnim);
        this.mLlVoiceAnim = findViewById(R.id.llVoiceAnim);
        this.mTvlAnim.setAnimation("lottie/tvcard_voicecontrol_anim.json");
        this.mTvlAnim.setRepeatCount(Integer.MAX_VALUE);
        this.mTvlAnim.setRepeatMode(2);
        this.mMoreLayout = findViewById(R.id.more_l);
        this.mMoreBtn = (TextView) findViewById(R.id.more_btn);
        this.mPadLayoutListener = new LPImageView.PadLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView.AnonymousClass2 */

            public void onActionExecute(View view, boolean z) {
                UwbLogUtil.w(MitvCardView.TAG, "UwbLogUtilPlus onActionExecute: ".concat(String.valueOf(z)));
                if (z) {
                    if (R.id.ok_btn == view.getId()) {
                        UwbMitvApi.doKeyEvent(66);
                        MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_ok_press);
                    } else if (R.id.left_btn == view.getId()) {
                        UwbMitvApi.doKeyEvent(21);
                        MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_left_press);
                    } else if (R.id.right_btn == view.getId()) {
                        UwbMitvApi.doKeyEvent(22);
                        MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_right_press);
                    } else if (R.id.up_btn == view.getId()) {
                        UwbMitvApi.doKeyEvent(19);
                        MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_up_press);
                    } else if (R.id.down_btn == view.getId()) {
                        UwbMitvApi.doKeyEvent(20);
                        MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_down_press);
                    }
                }
                if (MitvCardView.this.mStatOnClickListener != null) {
                    MitvCardView.this.mStatOnClickListener.onClick(view);
                }
            }

            public void onActionDown(View view) {
                if (R.id.ok_btn == view.getId()) {
                    UwbMitvApi.doKeyEvent(66);
                    MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_ok_press);
                } else if (R.id.left_btn == view.getId()) {
                    UwbMitvApi.doKeyEvent(21);
                    MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_left_press);
                } else if (R.id.right_btn == view.getId()) {
                    UwbMitvApi.doKeyEvent(22);
                    MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_right_press);
                } else if (R.id.up_btn == view.getId()) {
                    UwbMitvApi.doKeyEvent(19);
                    MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_up_press);
                } else if (R.id.down_btn == view.getId()) {
                    UwbMitvApi.doKeyEvent(20);
                    MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_down_press);
                }
                if (MitvCardView.this.mStatOnClickListener != null) {
                    MitvCardView.this.mStatOnClickListener.onClick(view);
                }
            }

            public void onActionUp(View view) {
                MitvCardView.this.mTvPadView.setBackgroundResource(R.drawable.pad_normal);
            }
        };
        this.mTvPadView.setPadViewClickListener(this.mPadLayoutListener);
        findViewById(R.id.hdmi_iv).setOnClickListener(this.mOnClickListener);
        ((LPImageView) findViewById(R.id.volume_reduce)).setListener(new LPImageView.PadLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView.AnonymousClass3 */

            public void onActionUp(View view) {
            }

            public void onActionExecute(View view, boolean z) {
                UwbMitvApi.doKeyEvent(25);
                if (MitvCardView.this.mStatOnClickListener != null) {
                    MitvCardView.this.mStatOnClickListener.onClick(view);
                }
            }

            public void onActionDown(View view) {
                hzf.O00000o(view);
            }
        });
        ((LPImageView) findViewById(R.id.volume_add)).setListener(new LPImageView.PadLayoutListener() {
            /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView.AnonymousClass4 */

            public void onActionUp(View view) {
            }

            public void onActionExecute(View view, boolean z) {
                UwbMitvApi.doKeyEvent(24);
                if (MitvCardView.this.mStatOnClickListener != null) {
                    MitvCardView.this.mStatOnClickListener.onClick(view);
                }
            }

            public void onActionDown(View view) {
                hzf.O00000o(view);
            }
        });
        findViewById(R.id.home_iv).setOnClickListener(this.mOnClickListener);
        findViewById(R.id.back_iv).setOnClickListener(this.mOnClickListener);
        findViewById(R.id.menu_iv).setOnClickListener(this.mOnClickListener);
        findViewById(R.id.miracast_iv).setOnClickListener(this.mOnClickListener);
        findViewById(R.id.ai_iv).setOnTouchListener(new View.OnTouchListener() {
            /* class com.xiaomi.smarthome.uwb.lib.mitv.widget.MitvCardView.AnonymousClass5 */

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!MitvCardView.this.mBlueToothReady) {
                    if (motionEvent.getAction() == 0) {
                        Toast.makeText(MitvCardView.this.getContext(), MitvCardView.this.getContext().getString(R.string.mj_uwb_bluetooth_not_ready), 1).show();
                    }
                    return true;
                } else if (!MitvCardView.this.mIsSupportXiaoAi) {
                    if (motionEvent.getAction() == 0) {
                        Toast.makeText(MitvCardView.this.getContext(), MitvCardView.this.getContext().getString(R.string.mj_uwb_not_support_xiaoai), 1).show();
                    }
                    return true;
                } else if (ContextCompat.O000000o(MitvCardView.this.getContext(), "android.permission.RECORD_AUDIO") != 0) {
                    oOOO00o0.O000000o((Activity) MitvCardView.this.getContext(), new String[]{"android.permission.RECORD_AUDIO"}, 1);
                    return true;
                } else {
                    if (MitvCardView.this.mUwbVoiceManager == null) {
                        MitvCardView.this.mUwbVoiceManager = new UwbVoiceManager();
                    }
                    String str = MitvCardView.TAG;
                    UwbLogUtil.w(str, "UwbLogUtilPlus setOnTouchListener: " + motionEvent.getAction());
                    if (motionEvent.getAction() == 0) {
                        if (MitvCardView.this.mStatOnClickListener != null) {
                            MitvCardView.this.mStatOnClickListener.onClick(view);
                        }
                        hzf.O00000o(view);
                        MitvCardView.this.mUwbVoiceManager.startSpeech();
                        MitvCardView.this.mLlVoiceAnim.setVisibility(0);
                        MitvCardView.this.mTvPadView.setVisibility(8);
                        MitvCardView.this.mTvlAnim.playAnimation();
                        ((ImageView) MitvCardView.this.findViewById(R.id.ai_iv)).setImageResource(R.drawable.ai_btn_press);
                    } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                        MitvCardView.this.mUwbVoiceManager.stopSpeech();
                        MitvCardView.this.mTvlAnim.cancelAnimation();
                        MitvCardView.this.mLlVoiceAnim.setVisibility(8);
                        MitvCardView.this.mTvPadView.setVisibility(0);
                        ((ImageView) MitvCardView.this.findViewById(R.id.ai_iv)).setImageResource(R.drawable.ai_btn);
                    }
                    return true;
                }
            }
        });
    }

    public void showMoreView(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mMoreLayout.setVisibility(0);
            this.mMoreBtn.setOnClickListener(onClickListener);
            this.mMoreBtn.setText((int) R.string.mj_uwb_more_action);
        }
    }

    public void showLoginView(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.mMoreLayout.setVisibility(0);
            this.mMoreBtn.setOnClickListener(onClickListener);
            String string = getContext().getString(R.string.mj_uwb_login_mitv_account);
            SpannableString spannableString = new SpannableString(string);
            if (UIUtils.isEnglish(string.charAt(0))) {
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.login_mitv_account)), 0, 7, 33);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.mijia_login_mitv_account_black)), 7, string.length(), 33);
            } else {
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.login_mitv_account)), 0, 2, 33);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.mijia_login_mitv_account_black)), 2, string.length(), 33);
            }
            this.mMoreBtn.setText(spannableString);
        }
    }

    public void setPowerClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            findViewById(R.id.power_iv).setOnClickListener(onClickListener);
        }
    }

    public void hideMoreView() {
        this.mMoreLayout.setVisibility(8);
    }

    public void setBlueToothReady(boolean z) {
        this.mBlueToothReady = z;
        if (this.mBlueToothReady && this.mIsSupportXiaoAi) {
            ((ImageView) findViewById(R.id.ai_iv)).setImageResource(R.drawable.ai_btn);
        }
    }

    /* access modifiers changed from: package-private */
    public void onViewClick(View view) {
        hzf.O00000oO(view);
        View.OnClickListener onClickListener = this.mStatOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (R.id.hdmi_iv == view.getId()) {
            UwbMitvApi.doSourcePage();
        } else if (R.id.home_iv == view.getId()) {
            UwbMitvApi.doKeyEvent(3);
        } else if (R.id.back_iv == view.getId()) {
            UwbMitvApi.doKeyEvent(4);
        } else if (R.id.menu_iv == view.getId()) {
            UwbMitvApi.doKeyEvent(82);
        } else if (R.id.miracast_iv != view.getId()) {
        } else {
            if (this.mIsSupoortMiplay) {
                MitvInfo mitvInfo = this.mMitvInfo;
                if (mitvInfo == null || TextUtils.isEmpty(mitvInfo.getEhMac()) || TextUtils.isEmpty(this.mMitvInfo.getWifiMac())) {
                    UwbLogUtil.e(TAG, "UwbLogUtilPlus miracast no info!!!");
                    return;
                }
                UwbMitvApi.miracast(getContext(), this.mMitvInfo.getWifiMac(), this.mMitvInfo.getEhMac());
                UwbLogUtil.w(TAG, "UwbLogUtilPlus miracast click, finish");
                Toast.makeText(getContext(), getContext().getString(R.string.mj_uwb_miracast), 1).show();
                ((Activity) getContext()).finish();
                return;
            }
            Toast.makeText(getContext(), getContext().getString(R.string.mj_uwb_not_support_miracast), 1).show();
        }
    }

    public void refreshUI(MitvInfo mitvInfo) {
        this.mMitvInfo = mitvInfo;
        if (!TextUtils.equals(mitvInfo.getTvName(), this.mNameTv.getText())) {
            String str = TAG;
            UwbLogUtil.w(str, "UwbLogUtilPlus refreshUI: " + mitvInfo.getTvName());
            this.mNameTv.setText(mitvInfo.getTvName());
        }
        if (TextUtils.equals(this.mMitvInfo.getSupportXiaoai(), "1")) {
            this.mIsSupportXiaoAi = true;
            if (this.mBlueToothReady && this.mIsSupportXiaoAi) {
                ((ImageView) findViewById(R.id.ai_iv)).setImageResource(R.drawable.ai_btn);
            }
        }
        if (TextUtils.equals(this.mMitvInfo.getMiplayFlag(), "1")) {
            this.mIsSupoortMiplay = true;
            if (this.mIsSupoortMiplay) {
                ((ImageView) findViewById(R.id.miracast_iv)).setImageResource(R.drawable.select_miracast_btn);
            }
        }
    }

    public void showTagPowerTv(boolean z, View.OnClickListener onClickListener) {
        if (z) {
            findViewById(R.id.tag_power_tv).setVisibility(0);
            findViewById(R.id.tag_power_tv).setOnClickListener(onClickListener);
            return;
        }
        findViewById(R.id.tag_power_tv).setVisibility(4);
        findViewById(R.id.tag_power_tv).setOnClickListener(null);
    }
}
