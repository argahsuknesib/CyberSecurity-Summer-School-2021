package com.mibi.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class AlertDialog extends Dialog implements DialogInterface {
    private AlertParams mAlertParams;
    public ListView mList;
    private ListAdapter mListAdapter;
    private TextView mMessageText;
    private Button mNegativeButton;
    private Button mPositiveButton;
    private TextView mTitleText;

    protected AlertDialog(Context context) {
        super(context);
    }

    protected AlertDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    protected AlertDialog(Context context, int i) {
        super(context, i);
    }

    public void setParams(AlertParams alertParams) {
        this.mAlertParams = alertParams;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        if (getWindow() != null) {
            getWindow().requestFeature(1);
        }
        if (this.mAlertParams.mItems != null) {
            setContentView((int) R.layout.mipay_alert_dialog_list);
        } else if (this.mAlertParams.mView == null) {
            setContentView((int) R.layout.mipay_alert_dialog);
        } else {
            setContentView(this.mAlertParams.mView);
        }
        this.mMessageText = (TextView) findViewById(R.id.message);
        this.mTitleText = (TextView) findViewById(R.id.title);
        this.mNegativeButton = (Button) findViewById(R.id.button1);
        this.mPositiveButton = (Button) findViewById(R.id.button2);
        this.mList = (ListView) findViewById(R.id.list);
        apply(this.mAlertParams);
        if (getWindow() != null) {
            getWindow().setGravity(80);
            getWindow().setLayout(-1, -2);
            getWindow().setBackgroundDrawableResource(R.drawable.mipay_alert_dialog_bg);
        }
    }

    public TextView getMessageView() {
        return this.mMessageText;
    }

    private void apply(AlertParams alertParams) {
        if (alertParams.mTitle != null) {
            this.mTitleText.setVisibility(0);
            this.mTitleText.setText(alertParams.mTitle);
        } else {
            this.mTitleText.setVisibility(8);
        }
        if (alertParams.mMessage != null) {
            this.mMessageText.setVisibility(0);
            this.mMessageText.setText(alertParams.mMessage);
        }
        if (alertParams.mClickable) {
            this.mMessageText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (alertParams.mNegativeButtonText != null) {
            this.mNegativeButton.setVisibility(0);
            this.mNegativeButton.setText(alertParams.mNegativeButtonText);
            final DialogInterface.OnClickListener onClickListener = alertParams.mNegativeButtonListener;
            this.mNegativeButton.setOnClickListener(new View.OnClickListener() {
                /* class com.mibi.sdk.widget.AlertDialog.AnonymousClass1 */

                public void onClick(View view) {
                    DialogInterface.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick(AlertDialog.this, -2);
                    }
                    AlertDialog.this.dismiss();
                }
            });
        }
        if (alertParams.mPositiveButtonText != null) {
            this.mPositiveButton.setVisibility(0);
            this.mPositiveButton.setText(alertParams.mPositiveButtonText);
            final DialogInterface.OnClickListener onClickListener2 = alertParams.mPositiveButtonListener;
            this.mPositiveButton.setOnClickListener(new View.OnClickListener() {
                /* class com.mibi.sdk.widget.AlertDialog.AnonymousClass2 */

                public void onClick(View view) {
                    DialogInterface.OnClickListener onClickListener = onClickListener2;
                    if (onClickListener != null) {
                        onClickListener.onClick(AlertDialog.this, -1);
                    }
                    AlertDialog.this.dismiss();
                }
            });
        }
        if (!(alertParams.mItems == null || this.mList == null)) {
            final DialogInterface.OnClickListener onClickListener3 = alertParams.mOnClickListener;
            if (alertParams.mIsSingleChoice) {
                this.mList.setChoiceMode(1);
                this.mListAdapter = new ArrayAdapter(getContext(), (int) R.layout.mipay_alert_list_single_item, 16908308, alertParams.mItems);
            } else {
                this.mListAdapter = new ArrayAdapter(getContext(), (int) R.layout.mipay_alert_dialog_list_item, (int) R.id.title, alertParams.mItems);
            }
            this.mList.setAdapter(this.mListAdapter);
            this.mList.setDivider(getContext().getResources().getDrawable(R.drawable.mipay_divider));
            this.mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.mibi.sdk.widget.AlertDialog.AnonymousClass3 */

                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    onClickListener3.onClick(AlertDialog.this, i);
                    AlertDialog.this.mList.setItemChecked(i, true);
                }
            });
            if (alertParams.mCheckedItem >= 0) {
                this.mList.setItemChecked(alertParams.mCheckedItem, true);
            }
        }
        setCancelable(alertParams.mCancelable);
        if (alertParams.mCancelable) {
            setCanceledOnTouchOutside(true);
        } else {
            setCanceledOnTouchOutside(false);
        }
    }

    static class AlertParams {
        public boolean mCancelable;
        public int mCheckedItem;
        public boolean mClickable;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public CharSequence mTitle;
        public View mView;

        private AlertParams() {
            this.mCheckedItem = -1;
        }
    }

    public static class Builder {
        private AlertParams mAlertParams = new AlertParams();
        private Context mContext;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setMessage(CharSequence charSequence) {
            this.mAlertParams.mMessage = charSequence;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mAlertParams.mTitle = charSequence;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.mAlertParams.mCancelable = z;
            return this;
        }

        public Builder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.mAlertParams.mPositiveButtonText = this.mContext.getText(i);
            this.mAlertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertParams alertParams = this.mAlertParams;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            this.mAlertParams.mNegativeButtonText = this.mContext.getText(i);
            this.mAlertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertParams alertParams = this.mAlertParams;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public Builder setView(View view) {
            this.mAlertParams.mView = view;
            return this;
        }

        public Builder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertParams alertParams = this.mAlertParams;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public Builder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertParams alertParams = this.mAlertParams;
            alertParams.mItems = charSequenceArr;
            alertParams.mCheckedItem = i;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public Builder setClickable(boolean z) {
            this.mAlertParams.mClickable = z;
            return this;
        }

        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.mContext);
            alertDialog.setParams(this.mAlertParams);
            return alertDialog;
        }
    }
}
