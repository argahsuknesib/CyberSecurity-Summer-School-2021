package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gwg;
import _m_j.htr;
import _m_j.izb;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.library.common.widget.ResizeLayout;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.regex.Pattern;

public class WifiExtApPasswdInputStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f11831O000000o = true;
    public ObjectAnimator O00000Oo;
    public O000000o O00000o;
    public ObjectAnimator O00000o0;
    public int O00000oO;
    public int O00000oo;
    private String O0000O0o;
    private WifiManager O0000OOo;
    @BindView(6311)
    RelativeLayout mContentView;
    @BindView(6643)
    ImageView mDeviceIcon;
    @BindView(6925)
    TextView mDeviceInfo;
    @BindView(6646)
    ResizeLayout mHeadView;
    @BindView(7147)
    ImageView mIvPwdShow;
    @BindView(6986)
    Button mNextBtn;
    @BindView(7808)
    EditText mPasswordEditor;
    @BindView(6920)
    ImageView mReturnBtn;
    @BindView(7517)
    View mTitleBar;
    @BindView(6836)
    EditText mWifiChooser;
    @BindView(7813)
    View mWifiPassContainer;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O000000o(Message message) {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(16);
        O000000o(context, (int) R.layout.smart_config_ap_passwd_input_step);
        gwg.O000000o(this.mTitleBar);
        this.mTitleBar.setBackgroundColor(this.O000O0oo.getResources().getColor(R.color.mj_color_black_00_transparent));
        gwg.O00000o0((Activity) this.O000O0oo);
        this.mReturnBtn.setImageResource(R.drawable.left_arrow_icon1);
        this.mDeviceInfo.setTextColor(-1);
        this.O0000O0o = (String) htr.O000000o().O000000o("device_model");
        PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.O0000O0o);
        if (pluginInfo != null) {
            this.mDeviceInfo.setText(pluginInfo.O0000Oo0());
        }
        this.O0000OOo = (WifiManager) context.getSystemService("wifi");
        this.mNextBtn.setText((int) R.string.next_button);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass1 */

            public final void onClick(View view) {
                WifiExtApPasswdInputStep.this.b_(false);
            }
        });
        this.mPasswordEditor.setVisibility(0);
        this.mNextBtn.setEnabled(false);
        htr.O000000o().O00000Oo("miui_class");
        this.O00000o = new O000000o(context);
        this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(this.O00000o);
        this.mNextBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass2 */

            public final void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) WifiExtApPasswdInputStep.this.O000O0oo.getSystemService("input_method");
                if (inputMethodManager.isActive() && (WifiExtApPasswdInputStep.this.O000O0oo instanceof Activity) && ((Activity) WifiExtApPasswdInputStep.this.O000O0oo).getCurrentFocus() != null) {
                    inputMethodManager.hideSoftInputFromWindow(((Activity) WifiExtApPasswdInputStep.this.O000O0oo).getCurrentFocus().getWindowToken(), 2);
                }
                String obj = WifiExtApPasswdInputStep.this.mWifiChooser.getText().toString();
                String obj2 = WifiExtApPasswdInputStep.this.mPasswordEditor.getText().toString();
                if (obj.getBytes().length > 32) {
                    izb.O000000o(WifiExtApPasswdInputStep.this.O000O0oo, WifiExtApPasswdInputStep.this.O000O0oo.getString(R.string.dianlimao_ssid_toolong), 0).show();
                } else if (obj2.getBytes().length > 63) {
                    izb.O000000o(WifiExtApPasswdInputStep.this.O000O0oo, WifiExtApPasswdInputStep.this.O000O0oo.getString(R.string.dianlimao_pwd_toolong), 0).show();
                } else {
                    htr.O000000o().O00000Oo("selected_ap_ssid", obj.trim());
                    htr.O000000o().O00000Oo("selected_ap_passwd", obj2.trim());
                    WifiExtApPasswdInputStep.this.O000O0o();
                }
            }
        });
        this.mWifiChooser.setFilters(new InputFilter[]{new InputFilter.LengthFilter(32)});
        this.mPasswordEditor.setText("");
        this.mPasswordEditor.setFilters(new InputFilter[]{new InputFilter.LengthFilter(63)});
        this.mWifiChooser.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                WifiExtApPasswdInputStep.this.O00000Oo();
            }
        });
        this.mPasswordEditor.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass4 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                String replaceAll = Pattern.compile("[一-龥]").matcher(charSequence2).replaceAll("");
                if (!replaceAll.equals(charSequence2)) {
                    WifiExtApPasswdInputStep.this.mPasswordEditor.setText(replaceAll);
                    WifiExtApPasswdInputStep.this.mPasswordEditor.setSelection(replaceAll.length());
                }
            }

            public final void afterTextChanged(Editable editable) {
                WifiExtApPasswdInputStep.this.O00000Oo();
            }
        });
        this.mIvPwdShow.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass5 */

            public final void onClick(View view) {
                int selectionStart = WifiExtApPasswdInputStep.this.mPasswordEditor.getSelectionStart();
                if (WifiExtApPasswdInputStep.this.mPasswordEditor.getInputType() != 144) {
                    WifiExtApPasswdInputStep.this.mPasswordEditor.setInputType(144);
                    WifiExtApPasswdInputStep.this.mIvPwdShow.setImageResource(R.drawable.pwd_show_icon);
                    WifiExtApPasswdInputStep.this.mIvPwdShow.setContentDescription(view.getContext().getString(R.string.hide_passwd));
                } else {
                    WifiExtApPasswdInputStep.this.mPasswordEditor.setInputType(129);
                    WifiExtApPasswdInputStep.this.mIvPwdShow.setImageResource(R.drawable.pwd_hide_icon);
                    WifiExtApPasswdInputStep.this.mIvPwdShow.setContentDescription(view.getContext().getString(R.string.show_passwd));
                }
                WifiExtApPasswdInputStep.this.mPasswordEditor.setSelection(selectionStart);
            }
        });
    }

    public final void O00000Oo() {
        String trim = this.mWifiChooser.getText().toString().trim();
        String trim2 = this.mPasswordEditor.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) || trim2.length() < 8 || TextUtils.isEmpty(trim)) {
            this.mNextBtn.setEnabled(false);
        } else {
            this.mNextBtn.setEnabled(true);
        }
    }

    class O000000o implements ViewTreeObserver.OnGlobalLayoutListener {
        private Context O00000Oo;

        O000000o(Context context) {
            this.O00000Oo = context;
        }

        public final void onGlobalLayout() {
            if (WifiExtApPasswdInputStep.this.O00000oo == 0) {
                WifiExtApPasswdInputStep wifiExtApPasswdInputStep = WifiExtApPasswdInputStep.this;
                wifiExtApPasswdInputStep.O00000oO = wifiExtApPasswdInputStep.mTitleBar.getHeight();
                WifiExtApPasswdInputStep wifiExtApPasswdInputStep2 = WifiExtApPasswdInputStep.this;
                wifiExtApPasswdInputStep2.O00000oo = wifiExtApPasswdInputStep2.mHeadView.getHeight();
                WifiExtApPasswdInputStep wifiExtApPasswdInputStep3 = WifiExtApPasswdInputStep.this;
                Context context = this.O00000Oo;
                wifiExtApPasswdInputStep3.O00000Oo = ObjectAnimator.ofInt(wifiExtApPasswdInputStep3.mHeadView, "height", wifiExtApPasswdInputStep3.O00000oO, wifiExtApPasswdInputStep3.O00000oo).setDuration(300L);
                wifiExtApPasswdInputStep3.O00000Oo.setInterpolator(new AccelerateDecelerateInterpolator());
                wifiExtApPasswdInputStep3.O00000Oo.addListener(new Animator.AnimatorListener(context) {
                    /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass6 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Context f11837O000000o;

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    {
                        this.f11837O000000o = r2;
                    }

                    public final void onAnimationStart(Animator animator) {
                        WifiExtApPasswdInputStep.this.mTitleBar.setBackgroundColor(WifiExtApPasswdInputStep.this.O000O0oo.getResources().getColor(R.color.mj_color_black_00_transparent));
                        WifiExtApPasswdInputStep.this.mDeviceInfo.setTextColor(-1);
                        WifiExtApPasswdInputStep.this.mReturnBtn.setImageDrawable(this.f11837O000000o.getResources().getDrawable(R.drawable.left_arrow_icon1));
                    }

                    public final void onAnimationEnd(Animator animator) {
                        gwg.O00000o0((Activity) this.f11837O000000o);
                        WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                    }
                });
                WifiExtApPasswdInputStep wifiExtApPasswdInputStep4 = WifiExtApPasswdInputStep.this;
                Context context2 = this.O00000Oo;
                wifiExtApPasswdInputStep4.O00000o0 = ObjectAnimator.ofInt(wifiExtApPasswdInputStep4.mHeadView, "height", wifiExtApPasswdInputStep4.O00000oo, wifiExtApPasswdInputStep4.O00000oO).setDuration(300L);
                wifiExtApPasswdInputStep4.O00000o0.setInterpolator(new AccelerateDecelerateInterpolator());
                wifiExtApPasswdInputStep4.O00000o0.addListener(new Animator.AnimatorListener(context2) {
                    /* class com.xiaomi.smarthome.smartconfig.step.WifiExtApPasswdInputStep.AnonymousClass7 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Context f11838O000000o;

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }

                    public final void onAnimationStart(Animator animator) {
                    }

                    {
                        this.f11838O000000o = r2;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        WifiExtApPasswdInputStep.this.mTitleBar.setBackgroundDrawable(this.f11838O000000o.getResources().getDrawable(R.drawable.mj_common_title_bar_bg));
                        WifiExtApPasswdInputStep.this.mDeviceInfo.setTextColor(this.f11838O000000o.getResources().getColor(com.xiaomi.smarthome.quick_connect.R.color.class_V));
                        WifiExtApPasswdInputStep.this.mReturnBtn.setImageDrawable(this.f11838O000000o.getResources().getDrawable(R.drawable.mj_common_title_bar_return));
                        gwg.O00000Oo(((Activity) this.f11838O000000o).getWindow());
                        WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().addOnGlobalLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                    }
                });
                return;
            }
            Rect rect = new Rect();
            View decorView = ((Activity) this.O00000Oo).getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int[] iArr = new int[2];
            WifiExtApPasswdInputStep.this.mPasswordEditor.getLocationInWindow(iArr);
            if (iArr[1] + WifiExtApPasswdInputStep.this.mPasswordEditor.getHeight() > i && WifiExtApPasswdInputStep.this.f11831O000000o && !WifiExtApPasswdInputStep.this.O00000o0.isRunning()) {
                if (WifiExtApPasswdInputStep.this.O00000Oo.isRunning()) {
                    WifiExtApPasswdInputStep.this.O00000Oo.end();
                }
                WifiExtApPasswdInputStep.this.O00000o0.start();
                WifiExtApPasswdInputStep.this.f11831O000000o = false;
                if (Build.VERSION.SDK_INT < 16) {
                    WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().removeGlobalOnLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                } else {
                    WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                }
            } else if (decorView.getHeight() - i < 200 && !WifiExtApPasswdInputStep.this.f11831O000000o && !WifiExtApPasswdInputStep.this.O00000Oo.isRunning()) {
                if (WifiExtApPasswdInputStep.this.O00000o0.isRunning()) {
                    WifiExtApPasswdInputStep.this.O00000Oo.end();
                }
                WifiExtApPasswdInputStep.this.O00000Oo.start();
                WifiExtApPasswdInputStep.this.f11831O000000o = true;
                if (Build.VERSION.SDK_INT < 16) {
                    WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().removeGlobalOnLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                } else {
                    WifiExtApPasswdInputStep.this.mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(WifiExtApPasswdInputStep.this.O00000o);
                }
            }
        }
    }

    public final boolean G_() {
        b_(false);
        return true;
    }
}
