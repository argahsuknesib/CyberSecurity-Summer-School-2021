package com.xiaomi.mico.common.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.xiaomi.mico.common.widget.MLAlertController2;
import com.xiaomi.smarthome.R;
import java.util.Timer;
import java.util.TimerTask;

public class MLAlertDialog2 extends Dialog implements DialogInterface {
    public MLAlertController2 mAlert;
    protected Context mContext;
    private DismissCallBack mDismissCallBack;
    public CharSequence[] mItemTexts;
    private int mStartY;

    public interface DismissCallBack {
        void afterDismissCallBack();

        void beforeDismissCallBack();
    }

    protected MLAlertDialog2(Context context) {
        this(context, 2132739282);
    }

    protected MLAlertDialog2(Context context, int i) {
        this(context, i, 80, 0);
    }

    protected MLAlertDialog2(Context context, int i, int i2, int i3) {
        super(context, i);
        this.mStartY = 0;
        this.mAlert = new MLAlertController2(context, this, getWindow(), i2);
        this.mContext = context;
        this.mStartY = i3;
    }

    protected MLAlertDialog2(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, 2132739282);
        this.mStartY = 0;
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new MLAlertController2(context, this, getWindow(), 80);
        this.mContext = context;
    }

    protected MLAlertDialog2(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener, int i, int i2) {
        super(context, 2132739282);
        this.mStartY = 0;
        setCancelable(z);
        setOnCancelListener(onCancelListener);
        this.mAlert = new MLAlertController2(context, this, getWindow(), i);
        this.mContext = context;
        this.mStartY = i2;
    }

    public Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public ListView getListView() {
        return this.mAlert.getListView();
    }

    public View getView() {
        return this.mAlert.getView();
    }

    public EditText getInputView() {
        return (EditText) this.mAlert.getView();
    }

    public CharSequence[] getItemTexts() {
        return this.mItemTexts;
    }

    private void showSoftInput() {
        if (this.mAlert.getView() != null && (this.mAlert.getView() instanceof EditText)) {
            new Timer().schedule(new TimerTask() {
                /* class com.xiaomi.mico.common.widget.dialog.MLAlertDialog2.AnonymousClass1 */

                public void run() {
                    ((InputMethodManager) MLAlertDialog2.this.getContext().getSystemService("input_method")).showSoftInput(MLAlertDialog2.this.mAlert.getView(), 2);
                }
            }, 200);
        }
    }

    private void hideSoftInput() {
        Context context = this.mContext;
        if (context != null && this.mAlert.getView() != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(this.mAlert.getView().getWindowToken(), 0);
        }
    }

    public void dismiss() {
        DismissCallBack dismissCallBack = this.mDismissCallBack;
        if (dismissCallBack != null) {
            dismissCallBack.beforeDismissCallBack();
        }
        hideSoftInput();
        try {
            super.dismiss();
            this.mContext = null;
        } catch (Exception unused) {
        }
        DismissCallBack dismissCallBack2 = this.mDismissCallBack;
        if (dismissCallBack2 != null) {
            dismissCallBack2.afterDismissCallBack();
        }
    }

    public void setAudoDismiss(boolean z) {
        this.mAlert.setAudoDismiss(z);
        if (z) {
            this.mAlert.sendDismissMessage();
        }
    }

    public void setDismissCallBack(DismissCallBack dismissCallBack) {
        this.mDismissCallBack = dismissCallBack;
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void show() {
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.y = this.mStartY;
        attributes.width = -1;
        attributes.height = -2;
        getWindow().setAttributes(attributes);
    }

    public void setCustomTitle(View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setMessage(CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    public void setView(View view) {
        this.mAlert.setView(view);
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }

    public void setButton(int i, CharSequence charSequence, Message message) {
        this.mAlert.setButton(i, charSequence, null, message);
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null);
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
        this.mAlert.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setInverseBackgroundForced(boolean z) {
        this.mAlert.setInverseBackgroundForced(z);
    }

    public void setBtnTextColor(int i, int i2) {
        this.mAlert.setBtnTextColor(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mAlert.installContent();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyDown(i, keyEvent) || super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mAlert.onKeyUp(i, keyEvent) || super.onKeyUp(i, keyEvent);
    }

    public static class Builder {
        private final MLAlertController2.AlertParams P;
        private Context mContext;

        public EditText getInputView() {
            return (EditText) this.P.mView;
        }

        public Builder(Context context) {
            this.mContext = context;
            this.P = new MLAlertController2.AlertParams(context);
        }

        public Builder setTitle(int i) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.P.mTitle = charSequence;
            return this;
        }

        public Builder setCustomTitle(View view) {
            this.P.mCustomTitleView = view;
            return this;
        }

        public Builder setMessage(int i) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.P.mMessage = charSequence;
            return this;
        }

        public Builder setMessage(SpannableStringBuilder spannableStringBuilder) {
            this.P.mMesageBuilder = spannableStringBuilder;
            return this;
        }

        public Builder setIcon(int i) {
            this.P.mIconId = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.P.mIcon = drawable;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.P.mCancelable = z;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.P.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.P.mOnKeyListener = onKeyListener;
            return this;
        }

        public Builder setItems(int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            MLAlertController2.AlertParams alertParams2 = this.P;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            MLAlertController2.AlertParams alertParams2 = this.P;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i2;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public Builder setView(View view) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public Builder setInputView(String str, boolean z) {
            Context context = this.mContext;
            if (context != null) {
                View inflate = View.inflate(context, R.layout.ml_alert_dialog_input_view, null);
                setView(inflate, context.getResources().getDimensionPixelSize(R.dimen.alertdialog_button_panel_padding_horizontal), 0, context.getResources().getDimensionPixelSize(R.dimen.alertdialog_button_panel_padding_horizontal), context.getResources().getDimensionPixelSize(R.dimen.alertdialog_custom_panel_padding_bottom));
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

        public void setCustomTitle(CharSequence charSequence) {
            this.P.mCustomTitle = charSequence;
        }

        public Builder setDismissCallBack(DismissCallBack dismissCallBack) {
            this.P.mDismissCallBack = dismissCallBack;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i;
            alertParams.mViewSpacingTop = i2;
            alertParams.mViewSpacingRight = i3;
            alertParams.mViewSpacingBottom = i4;
            return this;
        }

        public Builder setView(View view, int i, int i2, int i3, int i4, boolean z) {
            MLAlertController2.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i;
            alertParams.mViewSpacingTop = i2;
            alertParams.mViewSpacingRight = i3;
            alertParams.mViewSpacingBottom = i4;
            alertParams.mCustomBgTransplant = z;
            return this;
        }

        public Builder setInverseBackgroundForced(boolean z) {
            this.P.mForceInverseBackground = z;
            return this;
        }

        public Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.mRecycleOnMeasure = z;
            return this;
        }

        public Builder setAudoDismiss(boolean z) {
            this.P.mAutoDismiss = z;
            return this;
        }

        public MLAlertDialog2 create() {
            MLAlertDialog2 mLAlertDialog2 = new MLAlertDialog2(this.P.mContext);
            mLAlertDialog2.mItemTexts = this.P.mItems;
            this.P.apply(mLAlertDialog2.mAlert);
            mLAlertDialog2.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                mLAlertDialog2.setCanceledOnTouchOutside(true);
            }
            mLAlertDialog2.setOnCancelListener(this.P.mOnCancelListener);
            if (this.P.mOnKeyListener != null) {
                mLAlertDialog2.setOnKeyListener(this.P.mOnKeyListener);
            }
            mLAlertDialog2.setDismissCallBack(this.P.mDismissCallBack);
            return mLAlertDialog2;
        }

        public MLAlertDialog2 createCenter() {
            MLAlertDialog2 mLAlertDialog2 = new MLAlertDialog2(this.P.mContext, true, null, 17, 0);
            mLAlertDialog2.mItemTexts = this.P.mItems;
            this.P.apply(mLAlertDialog2.mAlert);
            mLAlertDialog2.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                mLAlertDialog2.setCanceledOnTouchOutside(true);
            }
            mLAlertDialog2.setOnCancelListener(this.P.mOnCancelListener);
            if (this.P.mOnKeyListener != null) {
                mLAlertDialog2.setOnKeyListener(this.P.mOnKeyListener);
            }
            mLAlertDialog2.setDismissCallBack(this.P.mDismissCallBack);
            return mLAlertDialog2;
        }

        public MLAlertDialog2 show() {
            MLAlertDialog2 create = create();
            create.show();
            WindowManager.LayoutParams attributes = create.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            create.getWindow().setAttributes(attributes);
            return create;
        }

        public MLAlertDialog2 showCenter() {
            MLAlertDialog2 createCenter = createCenter();
            createCenter.show();
            WindowManager.LayoutParams attributes = createCenter.getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            createCenter.getWindow().setAttributes(attributes);
            return createCenter;
        }

        public Builder setBtnTextColor(int i, int i2) {
            if (i2 == -3) {
                this.P.mButtonNeutralTextColor = i;
            } else if (i2 == -2) {
                this.P.mButtonNegativeTextColor = i;
            } else if (i2 == -1) {
                this.P.mButtonPositiveTextColor = i;
            } else {
                throw new IllegalArgumentException("Button does not exist");
            }
            return this;
        }

        public Builder setGravity(int i) {
            this.P.gravity = i;
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
}
