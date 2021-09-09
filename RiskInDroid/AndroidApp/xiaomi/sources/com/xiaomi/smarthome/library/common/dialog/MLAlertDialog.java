package com.xiaomi.smarthome.library.common.dialog;

import _m_j.hyy;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertController;
import com.xiaomi.smarthome.utils.DialogBase;
import java.util.Timer;
import java.util.TimerTask;

public class MLAlertDialog extends DialogBase implements DialogInterface {
    public MLAlertController mAlert;
    public Context mContext;
    private O000000o mDismissCallBack;
    public CharSequence[] mItemTexts;
    private int mStartY;

    public enum ButtonStyle {
        Normal,
        Alert
    }

    public interface O000000o {
        void afterDismissCallBack();

        void beforeDismissCallBack();
    }

    protected MLAlertDialog(Context context) {
        this(context, 2132739282);
    }

    protected MLAlertDialog(Context context, boolean z) {
        this(context, z, 2132739282, getGravity(null), 0);
    }

    protected MLAlertDialog(Context context, int i) {
        this(context, i, getGravity(null), 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void
     arg types: [android.content.Context, int, int, int, int]
     candidates:
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, android.content.DialogInterface$OnCancelListener, int, int):void
      com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void */
    protected MLAlertDialog(Context context, int i, int i2, int i3) {
        this(context, false, i, i2, i3);
    }

    protected MLAlertDialog(Context context, boolean z, int i, int i2, int i3) {
        super(context, i);
        this.mStartY = 0;
        this.mAlert = new MLAlertController(context, this, z, getWindow(), i2);
        this.mContext = context;
        this.mStartY = i3;
    }

    protected MLAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, 2132739282);
        this.mStartY = 0;
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new MLAlertController(context, this, getWindow(), getGravity(null));
        this.mContext = context;
    }

    protected MLAlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener, int i, int i2) {
        super(context, 2132739282);
        this.mStartY = 0;
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new MLAlertController(context, this, getWindow(), i);
        this.mContext = context;
        this.mStartY = i2;
    }

    public Button getButton(int i) {
        MLAlertController mLAlertController = this.mAlert;
        if (i == -3) {
            return mLAlertController.O0000oo;
        }
        if (i == -2) {
            return mLAlertController.O0000oO;
        }
        if (i != -1) {
            return null;
        }
        return mLAlertController.O0000o0O;
    }

    public ListView getListView() {
        return this.mAlert.O0000OOo;
    }

    public View getView() {
        return this.mAlert.O0000Oo0;
    }

    public EditText getInputView() {
        return (EditText) this.mAlert.O0000Oo0;
    }

    public CharSequence[] getItemTexts() {
        return this.mItemTexts;
    }

    private void showSoftInput() {
        if (this.mAlert.O0000Oo0 != null && (this.mAlert.O0000Oo0 instanceof EditText)) {
            new Timer().schedule(new TimerTask() {
                /* class com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.AnonymousClass1 */

                public final void run() {
                    ((InputMethodManager) MLAlertDialog.this.getContext().getSystemService("input_method")).showSoftInput(MLAlertDialog.this.mAlert.O0000Oo0, 2);
                }
            }, 200);
        }
    }

    private void hideSoftInput() {
        Context context = this.mContext;
        if (context != null && this.mAlert.O0000Oo0 != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.mAlert.O0000Oo0.getWindowToken(), 0);
        }
    }

    public void dismiss() {
        O000000o o000000o = this.mDismissCallBack;
        if (o000000o != null) {
            o000000o.beforeDismissCallBack();
        }
        hideSoftInput();
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
        O000000o o000000o2 = this.mDismissCallBack;
        if (o000000o2 != null) {
            o000000o2.afterDismissCallBack();
        }
    }

    public void setAudoDismiss(boolean z) {
        MLAlertController mLAlertController = this.mAlert;
        mLAlertController.O000Oo0o = z;
        if (z) {
            mLAlertController.O000Oo0.obtainMessage(1, mLAlertController.O00000Oo).sendToTarget();
        }
    }

    public void setDismissCallBack(O000000o o000000o) {
        this.mDismissCallBack = o000000o;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.O000000o(charSequence);
    }

    public void show() {
        super.show();
        getWindow().getAttributes().y = this.mStartY;
    }

    public void setCustomTitle(View view) {
        this.mAlert.O000O0o = view;
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.O00000Oo(charSequence);
    }

    public void setView(View view) {
        this.mAlert.O00000Oo(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.O000000o(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.O000000o(i, charSequence, null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.O000000o(i, charSequence, onClickListener, null);
    }

    @Deprecated
    public void setButton(CharSequence charSequence, Message message) {
        setButton(-1, charSequence, message);
    }

    @Deprecated
    public void setButton2(CharSequence charSequence, Message message) {
        setButton(-2, charSequence, message);
    }

    @Deprecated
    public void setButton3(CharSequence charSequence, Message message) {
        setButton(-3, charSequence, message);
    }

    @Deprecated
    public void setButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-1, charSequence, onClickListener);
    }

    @Deprecated
    public void setButton2(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-2, charSequence, onClickListener);
    }

    @Deprecated
    public void setButton3(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        setButton(-3, charSequence, onClickListener);
    }

    public void setIcon(int i) {
        this.mAlert.O000000o(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.O000000o(drawable);
    }

    public void setInverseBackgroundForced(boolean z) {
        this.mAlert.O000O0oO = z;
    }

    public void setBtnTextColor(int i, int i2) {
        this.mAlert.O000000o(i, i2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02b1  */
    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        View findViewById;
        MLAlertController mLAlertController = this.mAlert;
        try {
            mLAlertController.O00000o0.requestFeature(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mLAlertController.O00000o0.setGravity(mLAlertController.O000OOoo);
        if (mLAlertController.O0000Oo0 == null || !MLAlertController.O000000o(mLAlertController.O0000Oo0)) {
            mLAlertController.O00000o0.setFlags(131072, 131072);
        }
        mLAlertController.O00000o0.setContentView(mLAlertController.O000OO0o);
        LinearLayout linearLayout = (LinearLayout) mLAlertController.O00000o0.findViewById(R.id.contentPanel);
        mLAlertController.O00oOooo = (ScrollView) mLAlertController.O00000o0.findViewById(R.id.scrollView);
        mLAlertController.O00oOooo.setFocusable(false);
        mLAlertController.O000O0o0 = (TextView) mLAlertController.O00000o0.findViewById(R.id.message);
        if (mLAlertController.O000O0o0 != null) {
            if (mLAlertController.O00000oo != null) {
                mLAlertController.O000O0o0.setGravity(mLAlertController.O000Oo00);
                mLAlertController.O000O0o0.setText(mLAlertController.O00000oo);
            } else if (mLAlertController.O0000O0o != null) {
                mLAlertController.O000O0o0.setGravity(mLAlertController.O000Oo00);
                mLAlertController.O000O0o0.setText(mLAlertController.O0000O0o);
                mLAlertController.O000O0o0.setHighlightColor(0);
                mLAlertController.O000O0o0.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                mLAlertController.O000O0o0.setVisibility(8);
                mLAlertController.O00oOooo.removeView(mLAlertController.O000O0o0);
                if (mLAlertController.O0000OOo != null) {
                    linearLayout.removeView(mLAlertController.O00000o0.findViewById(R.id.scrollView));
                    linearLayout.addView(mLAlertController.O0000OOo, new LinearLayout.LayoutParams(-1, -1));
                    linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                } else {
                    linearLayout.setVisibility(8);
                }
            }
        }
        mLAlertController.O0000o0O = (Button) mLAlertController.O00000o0.findViewById(R.id.button1);
        mLAlertController.O0000o0O.setOnClickListener(mLAlertController.O000OoO);
        if (TextUtils.isEmpty(mLAlertController.O0000o0o)) {
            mLAlertController.O0000o0O.setVisibility(8);
            z = false;
        } else {
            mLAlertController.O0000o0O.setText(mLAlertController.O0000o0o);
            mLAlertController.O0000o0O.setVisibility(0);
            if (mLAlertController.O0000o != -1) {
                mLAlertController.O0000o0O.setTextColor(mLAlertController.O0000o);
            }
            z = true;
        }
        mLAlertController.O0000oO = (Button) mLAlertController.O00000o0.findViewById(R.id.button2);
        mLAlertController.O0000oO.setOnClickListener(mLAlertController.O000OoO);
        if (TextUtils.isEmpty(mLAlertController.O0000oOO)) {
            mLAlertController.O0000oO.setVisibility(8);
        } else {
            mLAlertController.O0000oO.setText(mLAlertController.O0000oOO);
            mLAlertController.O0000oO.setVisibility(0);
            z |= true;
            if (mLAlertController.O0000oOo != -1) {
                mLAlertController.O0000oO.setTextColor(mLAlertController.O0000oOo);
            }
        }
        mLAlertController.O0000oo = (Button) mLAlertController.O00000o0.findViewById(R.id.button3);
        mLAlertController.O0000oo.setOnClickListener(mLAlertController.O000OoO);
        if (TextUtils.isEmpty(mLAlertController.O0000ooO)) {
            mLAlertController.O0000oo.setVisibility(8);
        } else {
            mLAlertController.O0000oo.setText(mLAlertController.O0000ooO);
            mLAlertController.O0000oo.setVisibility(0);
            z |= true;
            if (mLAlertController.O0000ooo != -1) {
                mLAlertController.O0000oo.setTextColor(mLAlertController.O0000ooo);
            }
        }
        if (z || z || z) {
            if (z) {
                mLAlertController.O000000o((TextView) mLAlertController.O0000o0O);
            } else if (z) {
                mLAlertController.O000000o((TextView) mLAlertController.O0000oO);
            } else if (z) {
                mLAlertController.O000000o((TextView) mLAlertController.O0000oo);
            }
        }
        boolean z3 = z;
        LinearLayout linearLayout2 = (LinearLayout) mLAlertController.O00000o0.findViewById(R.id.topPanel);
        if (mLAlertController.O000O0o != null) {
            linearLayout2.addView(mLAlertController.O000O0o, 0, new LinearLayout.LayoutParams(-1, -2));
            mLAlertController.O00000o0.findViewById(R.id.title_template).setVisibility(8);
        } else {
            boolean z4 = !TextUtils.isEmpty(mLAlertController.O00000oO);
            mLAlertController.O000O0Oo = (ImageView) mLAlertController.O00000o0.findViewById(R.id.icon);
            if (z4) {
                mLAlertController.O00oOoOo = (TextView) mLAlertController.O00000o0.findViewById(R.id.alertTitle);
                mLAlertController.O00oOoOo.setText(mLAlertController.O00000oO);
                if (mLAlertController.O000O00o > 0) {
                    mLAlertController.O000O0Oo.setImageResource(mLAlertController.O000O00o);
                } else if (mLAlertController.O000O0OO != null) {
                    mLAlertController.O000O0Oo.setImageDrawable(mLAlertController.O000O0OO);
                } else if (mLAlertController.O000O00o == 0) {
                    mLAlertController.O00oOoOo.setPadding(mLAlertController.O000O0Oo.getPaddingLeft(), mLAlertController.O000O0Oo.getPaddingTop(), mLAlertController.O000O0Oo.getPaddingRight(), mLAlertController.O000O0Oo.getPaddingBottom());
                    mLAlertController.O000O0Oo.setVisibility(8);
                }
                if (TextUtils.isEmpty(mLAlertController.O00000oo)) {
                    mLAlertController.O00oOoOo.setSingleLine(false);
                }
            } else {
                mLAlertController.O00000o0.findViewById(R.id.title_template).setVisibility(8);
                mLAlertController.O000O0Oo.setVisibility(8);
                linearLayout2.setVisibility(8);
                z2 = false;
                findViewById = mLAlertController.O00000o0.findViewById(R.id.buttonPanel);
                if (z3) {
                    findViewById.setVisibility(8);
                } else if (mLAlertController.O00O0Oo == ButtonStyle.Alert) {
                    if (mLAlertController.O0000o0O != null) {
                        if (mLAlertController.O00000o) {
                            mLAlertController.O0000o0O.setBackgroundResource(R.drawable.normal_denied_button);
                        }
                        mLAlertController.O0000o0O.setTextColor(Color.parseColor("#ffF44431"));
                    }
                    if (mLAlertController.O0000oo != null && mLAlertController.O00000o) {
                        mLAlertController.O0000oo.setBackgroundResource(R.drawable.normal_denied_button);
                    }
                    if (mLAlertController.O000O0o0 != null) {
                        mLAlertController.O000O0o0.setTypeface(Typeface.DEFAULT_BOLD);
                        mLAlertController.O000O0o0.setTextSize(2, 16.0f);
                    }
                }
                FrameLayout frameLayout = (FrameLayout) mLAlertController.O00000o0.findViewById(R.id.customPanel);
                if (mLAlertController.O0000Oo0 == null) {
                    FrameLayout frameLayout2 = (FrameLayout) mLAlertController.O00000o0.findViewById(R.id.custom);
                    frameLayout2.addView(mLAlertController.O0000Oo0);
                    if (mLAlertController.O0000o0) {
                        frameLayout2.setPadding(mLAlertController.O0000Oo, mLAlertController.O0000OoO, mLAlertController.O0000Ooo, mLAlertController.O0000o00);
                        if (mLAlertController.O000OoO0) {
                            mLAlertController.O000Oo0O = true;
                        }
                    }
                    if (mLAlertController.O0000OOo != null) {
                        ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
                    }
                } else {
                    frameLayout.setVisibility(8);
                }
                if (!mLAlertController.O000Oo0O) {
                    mLAlertController.O00000o0.findViewById(R.id.parentPanel).setBackgroundColor(mLAlertController.f9084O000000o.getResources().getColor(17170445));
                } else {
                    mLAlertController.O00000o0.findViewById(R.id.parentPanel).setBackgroundResource((mLAlertController.O000OOoo & 80) == 80 ? R.drawable.dialog_main_connect_bg : R.drawable.std_dialog_bg);
                }
                if (mLAlertController.O0000OOo == null) {
                    mLAlertController.O00000o0.findViewById(R.id.title_divider_line).setVisibility(0);
                } else {
                    mLAlertController.O00000o0.findViewById(R.id.title_divider_line).setVisibility(8);
                    mLAlertController.O00000o0.findViewById(R.id.title_divider_line_bottom).setVisibility(8);
                }
                if (linearLayout2.getVisibility() == 8 && linearLayout.getVisibility() == 8 && frameLayout.getVisibility() == 8 && z3) {
                    findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingBottom(), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
                }
                mLAlertController.O000000o(linearLayout2, linearLayout, frameLayout, z3, z2, findViewById);
                if (TextUtils.isEmpty(mLAlertController.O00000oO) && TextUtils.isEmpty(mLAlertController.O00000oo) && mLAlertController.O0000O0o == null) {
                    mLAlertController.O00000o0.findViewById(R.id.empty_view).setVisibility(8);
                }
                if (!TextUtils.isEmpty(mLAlertController.O00000oO) && TextUtils.isEmpty(mLAlertController.O00000oo) && mLAlertController.O0000O0o == null && frameLayout.getVisibility() == 8 && z3) {
                    ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).topMargin = 0;
                }
                hyy.O000000o(this.mContext, this, this.mAlert.O000OOoo);
            }
        }
        z2 = true;
        findViewById = mLAlertController.O00000o0.findViewById(R.id.buttonPanel);
        if (z3) {
        }
        FrameLayout frameLayout3 = (FrameLayout) mLAlertController.O00000o0.findViewById(R.id.customPanel);
        if (mLAlertController.O0000Oo0 == null) {
        }
        if (!mLAlertController.O000Oo0O) {
        }
        if (mLAlertController.O0000OOo == null) {
        }
        findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingBottom(), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        mLAlertController.O000000o(linearLayout2, linearLayout, frameLayout3, z3, z2, findViewById);
        mLAlertController.O00000o0.findViewById(R.id.empty_view).setVisibility(8);
        ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).topMargin = 0;
        hyy.O000000o(this.mContext, this, this.mAlert.O000OOoo);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        MLAlertController mLAlertController = this.mAlert;
        if (i == 82 && mLAlertController.O0000OOo != null && mLAlertController.O0000OOo.getVisibility() == 0) {
            mLAlertController.O00000Oo.dismiss();
        }
        return (mLAlertController.O00oOooo != null && mLAlertController.O00oOooo.executeKeyEvent(keyEvent)) || super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        MLAlertController mLAlertController = this.mAlert;
        return (mLAlertController.O00oOooo != null && mLAlertController.O00oOooo.executeKeyEvent(keyEvent)) || super.onKeyUp(i, keyEvent);
    }

    public static class Builder {

        /* renamed from: O000000o  reason: collision with root package name */
        public final MLAlertController.AlertParams f9096O000000o;
        private Context O00000Oo;

        public final EditText O000000o() {
            return (EditText) this.f9096O000000o.O0000ooo;
        }

        public Builder(Context context) {
            this.O00000Oo = context;
            this.f9096O000000o = new MLAlertController.AlertParams(context);
        }

        public final Builder O000000o(int i) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000OOo = alertParams.f9086O000000o.getText(i);
            return this;
        }

        public final Builder O000000o(CharSequence charSequence) {
            this.f9096O000000o.O0000OOo = charSequence;
            return this;
        }

        public final Builder O00000Oo(int i) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000Oo = alertParams.f9086O000000o.getText(i);
            return this;
        }

        public final Builder O00000Oo(CharSequence charSequence) {
            this.f9096O000000o.O0000Oo = charSequence;
            return this;
        }

        public final Builder O000000o(SpannableStringBuilder spannableStringBuilder) {
            this.f9096O000000o.O0000OoO = spannableStringBuilder;
            return this;
        }

        public final Builder O00000Oo() {
            this.f9096O000000o.O0000Ooo = false;
            return this;
        }

        public final Builder O000000o(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o00 = alertParams.f9086O000000o.getText(i);
            this.f9096O000000o.O0000o0 = onClickListener;
            return this;
        }

        public final Builder O000000o(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o00 = charSequence;
            alertParams.O0000o0 = onClickListener;
            return this;
        }

        public final Builder O00000Oo(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o0O = alertParams.f9086O000000o.getText(i);
            this.f9096O000000o.O0000o0o = onClickListener;
            return this;
        }

        public final Builder O00000Oo(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o0O = charSequence;
            alertParams.O0000o0o = onClickListener;
            return this;
        }

        public final Builder O00000o0(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o = alertParams.f9086O000000o.getText(i);
            MLAlertController.AlertParams alertParams2 = this.f9096O000000o;
            alertParams2.O0000oO0 = onClickListener;
            alertParams2.O00O0Oo = this.O00000Oo.getResources().getColor(R.color.mj_color_gray_heavy);
            return this;
        }

        public final Builder O00000o0(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000o = charSequence;
            alertParams.O00O0Oo = this.O00000Oo.getResources().getColor(R.color.mj_color_gray_heavy);
            this.f9096O000000o.O0000oO0 = onClickListener;
            return this;
        }

        public final Builder O000000o(boolean z) {
            this.f9096O000000o.O0000oO = z;
            return this;
        }

        public final Builder O000000o(DialogInterface.OnCancelListener onCancelListener) {
            this.f9096O000000o.O0000oOO = onCancelListener;
            return this;
        }

        public final Builder O000000o(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O0000ooO = onClickListener;
            return this;
        }

        public final Builder O000000o(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo = listAdapter;
            alertParams.O0000ooO = onClickListener;
            return this;
        }

        public final Builder O000000o(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo0 = alertParams.f9086O000000o.getResources().getTextArray(i);
            MLAlertController.AlertParams alertParams2 = this.f9096O000000o;
            alertParams2.O000OO00 = onMultiChoiceClickListener;
            alertParams2.O00oOoOo = zArr;
            alertParams2.O000O0o0 = true;
            return this;
        }

        public final Builder O000000o(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O000OO00 = onMultiChoiceClickListener;
            alertParams.O00oOoOo = zArr;
            alertParams.O000O0o0 = true;
            return this;
        }

        public final Builder O000000o(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo0 = alertParams.f9086O000000o.getResources().getTextArray(i);
            MLAlertController.AlertParams alertParams2 = this.f9096O000000o;
            alertParams2.O0000ooO = onClickListener;
            alertParams2.O000O0oo = i2;
            alertParams2.O000O0o = true;
            return this;
        }

        public final Builder O000000o(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo0 = charSequenceArr;
            alertParams.O0000ooO = onClickListener;
            alertParams.O000O0oo = i;
            alertParams.O000O0o = true;
            return this;
        }

        public final Builder O000000o(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000oo = listAdapter;
            alertParams.O0000ooO = onClickListener;
            alertParams.O000O0oo = i;
            alertParams.O000O0o = true;
            return this;
        }

        public final Builder O000000o(View view) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000ooo = view;
            alertParams.O000O0Oo = false;
            return this;
        }

        public final Builder O000000o(String str, boolean z) {
            Context context = this.O00000Oo;
            if (context != null) {
                View inflate = View.inflate(context, R.layout.ml_alert_dialog_input_view, null);
                O000000o(inflate, context.getResources().getDimensionPixelSize(R.dimen.alertdialog_button_panel_padding_horizontal), 0, context.getResources().getDimensionPixelSize(R.dimen.alertdialog_button_panel_padding_horizontal), context.getResources().getDimensionPixelSize(R.dimen.alertdialog_custom_panel_padding_bottom));
                EditText editText = (EditText) inflate.findViewById(R.id.input_text);
                editText.setSingleLine(z);
                if (z) {
                    editText.setEllipsize(TextUtils.TruncateAt.END);
                }
                if (!TextUtils.isEmpty(str)) {
                    editText.setHint(str);
                }
                editText.requestFocus();
            }
            return this;
        }

        public final Builder O000000o(O000000o o000000o) {
            this.f9096O000000o.O000Oo00 = o000000o;
            return this;
        }

        public final Builder O000000o(View view, int i, int i2, int i3, int i4) {
            MLAlertController.AlertParams alertParams = this.f9096O000000o;
            alertParams.O0000ooo = view;
            alertParams.O000O0Oo = true;
            alertParams.O00oOooO = i;
            alertParams.O00oOooo = i2;
            alertParams.O000O00o = i3;
            alertParams.O000O0OO = i4;
            return this;
        }

        public final Builder O00000o0() {
            this.f9096O000000o.O000OoO = true;
            return this;
        }

        public final Builder O000000o(ButtonStyle buttonStyle) {
            this.f9096O000000o.O000OoOO = buttonStyle;
            return this;
        }

        public final Builder O00000Oo(boolean z) {
            this.f9096O000000o.O000OOoo = z;
            return this;
        }

        public final MLAlertDialog O00000o() {
            MLAlertDialog mLAlertDialog = new MLAlertDialog(this.f9096O000000o.f9086O000000o, this.f9096O000000o.O000OoO, 2132739282, MLAlertDialog.getGravity(this.f9096O000000o), 0);
            mLAlertDialog.mItemTexts = this.f9096O000000o.O0000oo0;
            this.f9096O000000o.O000000o(mLAlertDialog.mAlert);
            mLAlertDialog.setCancelable(this.f9096O000000o.O0000oO);
            if (this.f9096O000000o.O0000oO) {
                mLAlertDialog.setCanceledOnTouchOutside(true);
            }
            mLAlertDialog.setOnCancelListener(this.f9096O000000o.O0000oOO);
            if (this.f9096O000000o.O0000oOo != null) {
                mLAlertDialog.setOnKeyListener(this.f9096O000000o.O0000oOo);
            }
            mLAlertDialog.setDismissCallBack(this.f9096O000000o.O000Oo00);
            if (!this.f9096O000000o.O0000Ooo) {
                Window window = mLAlertDialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.dimAmount = 0.0f;
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
                window.clearFlags(2);
            }
            return mLAlertDialog;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, android.content.DialogInterface$OnCancelListener, int, int):void
         arg types: [android.content.Context, int, ?[OBJECT, ARRAY], int, int]
         candidates:
          com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, int, int, int):void
          com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.<init>(android.content.Context, boolean, android.content.DialogInterface$OnCancelListener, int, int):void */
        public final MLAlertDialog O00000oO() {
            MLAlertDialog mLAlertDialog = new MLAlertDialog(this.f9096O000000o.f9086O000000o, true, (DialogInterface.OnCancelListener) null, 17, 0);
            mLAlertDialog.mItemTexts = this.f9096O000000o.O0000oo0;
            this.f9096O000000o.O000000o(mLAlertDialog.mAlert);
            mLAlertDialog.setCancelable(this.f9096O000000o.O0000oO);
            if (this.f9096O000000o.O0000oO) {
                mLAlertDialog.setCanceledOnTouchOutside(true);
            }
            mLAlertDialog.setOnCancelListener(this.f9096O000000o.O0000oOO);
            if (this.f9096O000000o.O0000oOo != null) {
                mLAlertDialog.setOnKeyListener(this.f9096O000000o.O0000oOo);
            }
            mLAlertDialog.setDismissCallBack(this.f9096O000000o.O000Oo00);
            return mLAlertDialog;
        }

        public final MLAlertDialog O00000oo() {
            MLAlertDialog O00000o = O00000o();
            O00000o.show();
            return O00000o;
        }

        public final Builder O000000o(int i, int i2) {
            if (i2 == -3) {
                this.f9096O000000o.O00O0Oo = i;
            } else if (i2 == -2) {
                this.f9096O000000o.O000OoO0 = i;
            } else if (i2 == -1) {
                this.f9096O000000o.O000Oo0o = i;
            } else {
                throw new IllegalArgumentException("Button does not exist");
            }
            return this;
        }
    }

    public void setContentPanelHeight(int i) {
        View findViewById = getWindow().findViewById(R.id.contentPanel);
        if (findViewById != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.weight = 0.0f;
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public static int getGravity(MLAlertController.AlertParams alertParams) {
        if (alertParams == null) {
            return 80;
        }
        if (!alertParams.O00000oo || alertParams.O0000oo != null || alertParams.O0000oo0 != null) {
            return alertParams.O00000o;
        }
        if (hyy.O000000o()) {
            return 17;
        }
        return 80;
    }
}
