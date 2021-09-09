package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.xiaomi.mico.common.widget.dialog.MLAlertDialog2;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

public class MLAlertController2 {
    public ListAdapter mAdapter;
    private int mAlertDialogLayout;
    public boolean mAutoDismiss;
    View.OnClickListener mButtonHandler;
    public Button mButtonNegative;
    public Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    private int mButtonNegativeTextColor;
    public Button mButtonNeutral;
    public Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonNeutralTextColor;
    public Button mButtonPositive;
    public Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    private int mButtonPositiveTextColor;
    public int mCheckedItem;
    private final Context mContext;
    private boolean mCustomBgTransplant;
    private View mCustomTitleView;
    public final DialogInterface mDialogInterface;
    private boolean mForceInverseBackground;
    public int mGravity;
    public Handler mHandler;
    private Drawable mIcon;
    private int mIconId;
    private ImageView mIconView;
    public int mListItemLayout;
    public int mListLayout;
    public int mListLayoutWithTitle;
    public ListView mListView;
    private CharSequence mMessage;
    private SpannableStringBuilder mMessageBuilder;
    private TextView mMessageView;
    public int mMultiChoiceItemLayout;
    private ScrollView mScrollView;
    public int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    public boolean mTransplantBg;
    public View mView;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified;
    private int mViewSpacingTop;
    private final Window mWindow;

    private static boolean shouldCenterSingleButton(int i) {
        return i == 1 || i == 2 || i == 4;
    }

    static final class ButtonHandler extends Handler {
        private WeakReference<DialogInterface> mDialog;

        public ButtonHandler(DialogInterface dialogInterface) {
            this.mDialog = new WeakReference<>(dialogInterface);
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.mDialog.get(), message.what);
            } else if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public void sendDismissMessage() {
        this.mHandler.obtainMessage(1, this.mDialogInterface).sendToTarget();
    }

    public MLAlertController2(Context context, DialogInterface dialogInterface, Window window) {
        this(context, dialogInterface, window, 80);
    }

    public MLAlertController2(Context context, DialogInterface dialogInterface, Window window, int i) {
        this.mViewSpacingSpecified = false;
        this.mButtonPositiveTextColor = -1;
        this.mButtonNegativeTextColor = -1;
        this.mButtonNeutralTextColor = -1;
        this.mIconId = -1;
        this.mCheckedItem = -1;
        this.mTransplantBg = false;
        this.mAutoDismiss = true;
        this.mCustomBgTransplant = false;
        this.mButtonHandler = new View.OnClickListener() {
            /* class com.xiaomi.mico.common.widget.MLAlertController2.AnonymousClass1 */

            public void onClick(View view) {
                Message message;
                if (view == MLAlertController2.this.mButtonPositive && MLAlertController2.this.mButtonPositiveMessage != null) {
                    message = Message.obtain(MLAlertController2.this.mButtonPositiveMessage);
                } else if (view != MLAlertController2.this.mButtonNegative || MLAlertController2.this.mButtonNegativeMessage == null) {
                    message = (view != MLAlertController2.this.mButtonNeutral || MLAlertController2.this.mButtonNeutralMessage == null) ? null : Message.obtain(MLAlertController2.this.mButtonNeutralMessage);
                } else {
                    message = Message.obtain(MLAlertController2.this.mButtonNegativeMessage);
                }
                if (message != null) {
                    message.sendToTarget();
                }
                if (MLAlertController2.this.mAutoDismiss) {
                    MLAlertController2.this.mHandler.obtainMessage(1, MLAlertController2.this.mDialogInterface).sendToTarget();
                }
            }
        };
        this.mContext = context;
        this.mDialogInterface = dialogInterface;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(dialogInterface);
        this.mAlertDialogLayout = R.layout.ml_alert_dialog2;
        this.mListLayout = R.layout.ml_select_dialog;
        this.mListLayoutWithTitle = R.layout.ml_select_dialog_center;
        this.mMultiChoiceItemLayout = R.layout.ml_select_dialog_multichoice;
        this.mSingleChoiceItemLayout = R.layout.ml_select_dialog_singlechoice;
        this.mListItemLayout = R.layout.ml_select_dialog_item;
        this.mGravity = i;
    }

    static boolean canTextInput(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (canTextInput(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void installContent() {
        this.mWindow.requestFeature(1);
        this.mWindow.setGravity(this.mGravity);
        View view = this.mView;
        if (view == null || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        this.mWindow.setContentView(this.mAlertDialogLayout);
        setupView();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setAudoDismiss(boolean z) {
        this.mAutoDismiss = z;
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setMessage(SpannableStringBuilder spannableStringBuilder) {
        this.mMessageBuilder = spannableStringBuilder;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(this.mMessageBuilder);
            this.mMessageView.setHighlightColor(0);
            this.mMessageView.setText(spannableStringBuilder);
            this.mMessageView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setGravity(int i) {
        this.mGravity = i;
        Window window = this.mWindow;
        if (window != null) {
            window.setGravity(i);
        }
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewSpacingSpecified = false;
    }

    public void setCustomTransplant(boolean z) {
        this.mCustomBgTransplant = z;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }

    public void setButton(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
        } else if (i == -2) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
        } else if (i == -1) {
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void setIcon(int i) {
        this.mIconId = i;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (i > 0) {
            imageView.setImageResource(this.mIconId);
        } else if (i == 0) {
            imageView.setVisibility(8);
        }
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        ImageView imageView = this.mIconView;
        if (imageView != null && this.mIcon != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setInverseBackgroundForced(boolean z) {
        this.mForceInverseBackground = z;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public View getView() {
        return this.mView;
    }

    public Button getButton(int i) {
        if (i == -3) {
            return this.mButtonNeutral;
        }
        if (i == -2) {
            return this.mButtonNegative;
        }
        if (i != -1) {
            return null;
        }
        return this.mButtonPositive;
    }

    public void setBtnTextColor(int i, int i2) {
        if (i == -3) {
            this.mButtonNeutralTextColor = i2;
        } else if (i == -2) {
            this.mButtonNegativeTextColor = i2;
        } else if (i == -1) {
            this.mButtonPositiveTextColor = i2;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListView listView;
        if (i == 82 && (listView = this.mListView) != null && listView.getVisibility() == 0) {
            this.mDialogInterface.dismiss();
        }
        ScrollView scrollView = this.mScrollView;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        ScrollView scrollView = this.mScrollView;
        return scrollView != null && scrollView.executeKeyEvent(keyEvent);
    }

    private void setupView() {
        LinearLayout linearLayout = (LinearLayout) this.mWindow.findViewById(R.id.contentPanel);
        setupContent(linearLayout);
        boolean z = setupButtons();
        LinearLayout linearLayout2 = (LinearLayout) this.mWindow.findViewById(R.id.topPanel);
        boolean z2 = setupTitle(linearLayout2);
        View findViewById = this.mWindow.findViewById(R.id.buttonPanel);
        if (!z) {
            findViewById.setVisibility(8);
        }
        FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(R.id.customPanel);
        if (this.mView != null) {
            FrameLayout frameLayout2 = (FrameLayout) this.mWindow.findViewById(R.id.custom);
            frameLayout2.addView(this.mView);
            if (this.mViewSpacingSpecified) {
                frameLayout2.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                if (this.mCustomBgTransplant) {
                    this.mTransplantBg = true;
                }
            }
            if (this.mListView != null) {
                ((LinearLayout.LayoutParams) frameLayout.getLayoutParams()).weight = 0.0f;
            }
        } else {
            frameLayout.setVisibility(8);
        }
        if (this.mTransplantBg) {
            this.mWindow.findViewById(R.id.parentPanel).setBackgroundColor(this.mContext.getResources().getColor(17170445));
        }
        if (this.mListView != null) {
            this.mWindow.findViewById(R.id.title_divider_line).setVisibility(0);
        } else {
            this.mWindow.findViewById(R.id.title_divider_line).setVisibility(8);
            this.mWindow.findViewById(R.id.title_divider_line_bottom).setVisibility(8);
        }
        if (linearLayout2.getVisibility() == 8 && linearLayout.getVisibility() == 8 && frameLayout.getVisibility() == 8 && z) {
            findViewById.setPadding(findViewById.getPaddingLeft(), findViewById.getPaddingBottom(), findViewById.getPaddingRight(), findViewById.getPaddingBottom());
        }
        setBackground(linearLayout2, linearLayout, frameLayout, z, z2, findViewById);
        if (TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mMessage) && this.mMessageBuilder == null) {
            this.mWindow.findViewById(R.id.empty_view).setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mTitle) && TextUtils.isEmpty(this.mMessage) && this.mMessageBuilder == null && frameLayout.getVisibility() == 8 && z) {
            ((LinearLayout.LayoutParams) findViewById.getLayoutParams()).topMargin = 0;
        }
    }

    private boolean setupTitle(LinearLayout linearLayout) {
        if (this.mCustomTitleView != null) {
            linearLayout.addView(this.mCustomTitleView, 0, new LinearLayout.LayoutParams(-1, -2));
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
        } else {
            boolean z = !TextUtils.isEmpty(this.mTitle);
            this.mIconView = (ImageView) this.mWindow.findViewById(R.id.icon);
            if (z) {
                this.mTitleView = (TextView) this.mWindow.findViewById(R.id.alertTitle);
                this.mTitleView.setText(this.mTitle);
                int i = this.mIconId;
                if (i > 0) {
                    this.mIconView.setImageResource(i);
                } else {
                    Drawable drawable = this.mIcon;
                    if (drawable != null) {
                        this.mIconView.setImageDrawable(drawable);
                    } else if (i == 0) {
                        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
                        this.mIconView.setVisibility(8);
                    }
                }
            } else {
                this.mWindow.findViewById(R.id.title_template).setVisibility(8);
                this.mIconView.setVisibility(8);
                linearLayout.setVisibility(8);
                return false;
            }
        }
        return true;
    }

    private void setupContent(LinearLayout linearLayout) {
        this.mScrollView = (ScrollView) this.mWindow.findViewById(R.id.scrollView);
        this.mScrollView.setFocusable(false);
        this.mMessageView = (TextView) this.mWindow.findViewById(R.id.message);
        TextView textView = this.mMessageView;
        if (textView != null) {
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            SpannableStringBuilder spannableStringBuilder = this.mMessageBuilder;
            if (spannableStringBuilder != null) {
                textView.setText(spannableStringBuilder);
                this.mMessageView.setHighlightColor(0);
                this.mMessageView.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            textView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if (this.mListView != null) {
                linearLayout.removeView(this.mWindow.findViewById(R.id.scrollView));
                linearLayout.addView(this.mListView, new LinearLayout.LayoutParams(-1, -1));
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    private boolean setupButtons() {
        int i;
        this.mButtonPositive = (Button) this.mWindow.findViewById(R.id.button1);
        this.mButtonPositive.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonPositiveText)) {
            this.mButtonPositive.setVisibility(8);
            i = 0;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            this.mButtonPositive.setVisibility(0);
            int i2 = this.mButtonPositiveTextColor;
            if (i2 != -1) {
                this.mButtonPositive.setTextColor(i2);
            }
            i = 1;
        }
        this.mButtonNegative = (Button) this.mWindow.findViewById(R.id.button2);
        this.mButtonNegative.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText)) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            this.mButtonNegative.setVisibility(0);
            i |= 2;
            int i3 = this.mButtonNegativeTextColor;
            if (i3 != -1) {
                this.mButtonNegative.setTextColor(i3);
            }
        }
        this.mButtonNeutral = (Button) this.mWindow.findViewById(R.id.button3);
        this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText)) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            this.mButtonNeutral.setVisibility(0);
            i |= 4;
            int i4 = this.mButtonNeutralTextColor;
            if (i4 != -1) {
                this.mButtonNeutral.setTextColor(i4);
            }
        }
        if (shouldCenterSingleButton(i)) {
            if (i == 1) {
                centerButton(this.mButtonPositive);
            } else if (i == 2) {
                centerButton(this.mButtonNegative);
            } else if (i == 4) {
                centerButton(this.mButtonNeutral);
            }
        }
        return i != 0;
    }

    private void centerButton(TextView textView) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        textView.setLayoutParams(layoutParams);
        textView.setBackgroundResource(R.drawable.dialog_btn_selector);
    }

    private void setBackground(LinearLayout linearLayout, LinearLayout linearLayout2, View view, boolean z, boolean z2, View view2) {
        ListAdapter listAdapter;
        int i;
        if (this.mTransplantBg) {
            int color = this.mContext.getResources().getColor(17170445);
            int color2 = this.mContext.getResources().getColor(17170445);
            int color3 = this.mContext.getResources().getColor(17170445);
            int color4 = this.mContext.getResources().getColor(17170445);
            int color5 = this.mContext.getResources().getColor(17170445);
            int color6 = this.mContext.getResources().getColor(17170445);
            int color7 = this.mContext.getResources().getColor(17170445);
            int color8 = this.mContext.getResources().getColor(17170445);
            int color9 = this.mContext.getResources().getColor(17170445);
            View[] viewArr = new View[4];
            boolean[] zArr = new boolean[4];
            if (z2) {
                viewArr[0] = linearLayout;
                zArr[0] = false;
                i = 1;
            } else {
                i = 0;
            }
            viewArr[i] = linearLayout2.getVisibility() == 8 ? null : linearLayout2;
            zArr[i] = this.mListView != null;
            int i2 = i + 1;
            if (view != null) {
                viewArr[i2] = view;
                zArr[i2] = this.mForceInverseBackground;
                i2++;
            }
            if (z) {
                viewArr[i2] = view2;
                zArr[i2] = true;
            }
            View view3 = null;
            boolean z3 = false;
            boolean z4 = false;
            for (int i3 = 0; i3 < 4; i3++) {
                View view4 = viewArr[i3];
                if (view4 != null) {
                    if (view3 != null) {
                        if (!z4) {
                            view3.setBackgroundResource(z3 ? color6 : color2);
                        } else {
                            view3.setBackgroundResource(z3 ? color7 : color3);
                        }
                        z4 = true;
                    }
                    z3 = zArr[i3];
                    view3 = view4;
                }
            }
            if (view3 != null) {
                if (z4) {
                    if (!z3) {
                        color8 = color4;
                    } else if (z) {
                        color8 = color9;
                    }
                    view3.setBackgroundResource(color8);
                } else {
                    if (z3) {
                        color = color5;
                    }
                    view3.setBackgroundResource(color);
                }
            }
        }
        ListView listView = this.mListView;
        if (listView != null && (listAdapter = this.mAdapter) != null) {
            listView.setAdapter(listAdapter);
            int i4 = this.mCheckedItem;
            if (i4 >= 0) {
                this.mListView.setItemChecked(i4, true);
                this.mListView.setSelection(this.mCheckedItem);
            }
        }
    }

    public static class RecycleListView extends ListView {
        boolean mRecycleOnMeasure = true;

        public RecycleListView(Context context) {
            super(context);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecycleListView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        /* access modifiers changed from: protected */
        public boolean recycleOnMeasure() {
            return this.mRecycleOnMeasure;
        }
    }

    public static class AlertParams {
        public int gravity = 80;
        public ListAdapter mAdapter;
        public boolean mAutoDismiss = true;
        public int mButtonNegativeTextColor = -1;
        public int mButtonNeutralTextColor = -1;
        public int mButtonPositiveTextColor = -1;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public boolean mCustomBgTransplant = false;
        public CharSequence mCustomTitle;
        public View mCustomTitleView;
        public MLAlertDialog2.DismissCallBack mDismissCallBack;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public SpannableStringBuilder mMesageBuilder;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewSpacingBottom;
        public int mViewSpacingLeft;
        public int mViewSpacingRight;
        public boolean mViewSpacingSpecified = false;
        public int mViewSpacingTop;

        public interface OnPrepareListViewListener {
            void onPrepareListView(ListView listView);
        }

        public AlertParams(Context context) {
            this.mContext = context;
            this.mCancelable = true;
            this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void apply(MLAlertController2 mLAlertController2) {
            int i = this.gravity;
            if (i != 80) {
                mLAlertController2.setGravity(i);
            }
            View view = this.mCustomTitleView;
            if (view != null) {
                mLAlertController2.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    mLAlertController2.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    mLAlertController2.setIcon(drawable);
                }
                int i2 = this.mIconId;
                if (i2 >= 0) {
                    mLAlertController2.setIcon(i2);
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                mLAlertController2.setMessage(charSequence2);
            }
            SpannableStringBuilder spannableStringBuilder = this.mMesageBuilder;
            if (spannableStringBuilder != null) {
                mLAlertController2.setMessage(spannableStringBuilder);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (charSequence3 != null) {
                mLAlertController2.setButton(-1, charSequence3, this.mPositiveButtonListener, null);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (charSequence4 != null) {
                mLAlertController2.setButton(-2, charSequence4, this.mNegativeButtonListener, null);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (charSequence5 != null) {
                mLAlertController2.setButton(-3, charSequence5, this.mNeutralButtonListener, null);
            }
            if (this.mForceInverseBackground) {
                mLAlertController2.setInverseBackgroundForced(true);
            }
            mLAlertController2.mTransplantBg = false;
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                if (mLAlertController2.mGravity == 17) {
                    createCenterListView(mLAlertController2);
                } else {
                    createListView(mLAlertController2);
                }
            }
            View view2 = this.mView;
            if (view2 != null) {
                if (this.mViewSpacingSpecified) {
                    mLAlertController2.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
                } else {
                    mLAlertController2.setView(view2);
                }
            }
            mLAlertController2.setAudoDismiss(this.mAutoDismiss);
            mLAlertController2.setCustomTransplant(this.mCustomBgTransplant);
            int i3 = this.mButtonPositiveTextColor;
            if (i3 != -1) {
                mLAlertController2.setBtnTextColor(-1, i3);
            }
            if (this.mButtonNegativeTextColor != -1) {
                mLAlertController2.setBtnTextColor(-2, this.mButtonPositiveTextColor);
            }
            if (this.mButtonNeutralTextColor != -1) {
                mLAlertController2.setBtnTextColor(-3, this.mButtonPositiveTextColor);
            }
        }

        private void createCenterListView(final MLAlertController2 mLAlertController2) {
            ListAdapter listAdapter;
            LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(mLAlertController2.mListLayoutWithTitle, (ViewGroup) null);
            final RecycleListView recycleListView = (RecycleListView) linearLayout.findViewById(R.id.select_dialog_listview);
            Cursor cursor = this.mCursor;
            if (cursor == null) {
                listAdapter = this.mAdapter;
                if (listAdapter == null) {
                    listAdapter = new ArrayAdapter(this.mContext, (int) R.layout.ml_center_item, (int) R.id.text1, this.mItems);
                }
            } else {
                listAdapter = new SimpleCursorAdapter(this.mContext, R.layout.ml_center_item, cursor, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.title);
            if (TextUtils.isEmpty(this.mCustomTitle)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.mCustomTitle);
                textView.setVisibility(0);
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            mLAlertController2.mAdapter = listAdapter;
            recycleListView.setAdapter(listAdapter);
            mLAlertController2.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass1 */

                    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        AlertParams.this.mOnClickListener.onClick(mLAlertController2.mDialogInterface, i);
                        if (!AlertParams.this.mIsSingleChoice) {
                            mLAlertController2.mDialogInterface.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass2 */

                    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i] = recycleListView.isItemChecked(i);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(mLAlertController2.mDialogInterface, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener2 = this.mOnItemSelectedListener;
            if (onItemSelectedListener2 != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener2);
            }
            if (this.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            recycleListView.mRecycleOnMeasure = this.mRecycleOnMeasure;
            mLAlertController2.mView = linearLayout;
            mLAlertController2.mTransplantBg = true;
            mLAlertController2.setCustomTransplant(this.mCustomBgTransplant);
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r9v2 */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARN: Type inference failed for: r1v20, types: [com.xiaomi.mico.common.widget.MLAlertController2$AlertParams$4] */
        /* JADX WARN: Type inference failed for: r1v21, types: [com.xiaomi.mico.common.widget.MLAlertController2$AlertParams$3] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        private void createListView(final MLAlertController2 mLAlertController2) {
            ? r9;
            final RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(mLAlertController2.mListLayout, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                Cursor cursor = this.mCursor;
                if (cursor == null) {
                    final RecycleListView recycleListView2 = recycleListView;
                    r9 = new ArrayAdapter<CharSequence>(this.mContext, mLAlertController2.mMultiChoiceItemLayout, R.id.text1, this.mItems) {
                        /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass3 */

                        public View getView(int i, View view, ViewGroup viewGroup) {
                            View view2 = super.getView(i, view, viewGroup);
                            if (AlertParams.this.mCheckedItems != null && AlertParams.this.mCheckedItems[i]) {
                                recycleListView2.setItemChecked(i, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    final RecycleListView recycleListView3 = recycleListView;
                    final MLAlertController2 mLAlertController22 = mLAlertController2;
                    r9 = new CursorAdapter(this.mContext, cursor, false) {
                        /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass4 */
                        private final int mIsCheckedIndex;
                        private final int mLabelIndex;

                        {
                            Cursor cursor = getCursor();
                            this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                            this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                        }

                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.mLabelIndex));
                            RecycleListView recycleListView = recycleListView3;
                            int position = cursor.getPosition();
                            boolean z = true;
                            if (cursor.getInt(this.mIsCheckedIndex) != 1) {
                                z = false;
                            }
                            recycleListView.setItemChecked(position, z);
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                         arg types: [int, android.view.ViewGroup, int]
                         candidates:
                          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                            return AlertParams.this.mInflater.inflate(mLAlertController22.mMultiChoiceItemLayout, viewGroup, false);
                        }
                    };
                }
            } else {
                int i = this.mIsSingleChoice ? mLAlertController2.mSingleChoiceItemLayout : mLAlertController2.mListItemLayout;
                Cursor cursor2 = this.mCursor;
                if (cursor2 == null) {
                    Object obj = this.mAdapter;
                    if (obj == null) {
                        obj = new ArrayAdapter(this.mContext, i, (int) R.id.text1, this.mItems);
                    }
                    r9 = obj;
                } else {
                    r9 = new SimpleCursorAdapter(this.mContext, i, cursor2, new String[]{this.mLabelColumn}, new int[]{R.id.text1});
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            mLAlertController2.mAdapter = r9;
            mLAlertController2.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass5 */

                    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        AlertParams.this.mOnClickListener.onClick(mLAlertController2.mDialogInterface, i);
                        if (!AlertParams.this.mIsSingleChoice) {
                            mLAlertController2.mDialogInterface.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.xiaomi.mico.common.widget.MLAlertController2.AlertParams.AnonymousClass6 */

                    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i] = recycleListView.isItemChecked(i);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(mLAlertController2.mDialogInterface, i, recycleListView.isItemChecked(i));
                    }
                });
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            } else if (this.mIsMultiChoice) {
                recycleListView.setChoiceMode(2);
            }
            recycleListView.mRecycleOnMeasure = this.mRecycleOnMeasure;
            mLAlertController2.mListView = recycleListView;
            mLAlertController2.setCustomTransplant(this.mCustomBgTransplant);
        }
    }
}
