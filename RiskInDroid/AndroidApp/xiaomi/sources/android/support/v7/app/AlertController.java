package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
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
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;

class AlertController {
    ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler = new View.OnClickListener() {
        /* class android.support.v7.app.AlertController.AnonymousClass1 */

        public void onClick(View view) {
            Message message;
            if (view == AlertController.this.mButtonPositive && AlertController.this.mButtonPositiveMessage != null) {
                message = Message.obtain(AlertController.this.mButtonPositiveMessage);
            } else if (view != AlertController.this.mButtonNegative || AlertController.this.mButtonNegativeMessage == null) {
                message = (view != AlertController.this.mButtonNeutral || AlertController.this.mButtonNeutralMessage == null) ? null : Message.obtain(AlertController.this.mButtonNeutralMessage);
            } else {
                message = Message.obtain(AlertController.this.mButtonNegativeMessage);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController.this.mHandler.obtainMessage(1, AlertController.this.mDialog).sendToTarget();
        }
    };
    Button mButtonNegative;
    Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    Button mButtonNeutral;
    Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    Button mButtonPositive;
    Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    int mCheckedItem = -1;
    private final Context mContext;
    private View mCustomTitleView;
    final AppCompatDialog mDialog;
    Handler mHandler;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    int mListItemLayout;
    int mListLayout;
    ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    int mMultiChoiceItemLayout;
    NestedScrollView mScrollView;
    private boolean mShowTitle;
    int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

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

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            return true;
        }
        return false;
    }

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window window) {
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = window;
        this.mHandler = new ButtonHandler(appCompatDialog);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{16842994, R.attr.buttonIconDimen, R.attr.buttonPanelSideLayout, R.attr.horizontalProgressLayout, R.attr.layout, R.attr.listItemLayout, R.attr.listLayout, R.attr.multiChoiceItemLayout, R.attr.progressLayout, R.attr.showTitle, R.attr.singleChoiceItemLayout}, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = obtainStyledAttributes.getResourceId(0, 0);
        this.mButtonPanelSideLayout = obtainStyledAttributes.getResourceId(2, 0);
        this.mListLayout = obtainStyledAttributes.getResourceId(6, 0);
        this.mMultiChoiceItemLayout = obtainStyledAttributes.getResourceId(7, 0);
        this.mSingleChoiceItemLayout = obtainStyledAttributes.getResourceId(10, 0);
        this.mListItemLayout = obtainStyledAttributes.getResourceId(5, 0);
        this.mShowTitle = obtainStyledAttributes.getBoolean(9, true);
        obtainStyledAttributes.recycle();
        appCompatDialog.supportRequestWindowFeature(1);
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
        this.mDialog.setContentView(selectContentView());
        setupView();
    }

    private int selectContentView() {
        int i = this.mButtonPanelSideLayout;
        if (i == 0) {
            return this.mAlertDialogLayout;
        }
        if (this.mButtonPanelLayoutHint == 1) {
            return i;
        }
        return this.mAlertDialogLayout;
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

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int i) {
        this.mView = null;
        this.mViewLayoutResId = i;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int i, int i2, int i3, int i4) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = i;
        this.mViewSpacingTop = i2;
        this.mViewSpacingRight = i3;
        this.mViewSpacingBottom = i4;
    }

    public void setButtonPanelLayoutHint(int i) {
        this.mButtonPanelLayoutHint = i;
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
        this.mIcon = null;
        this.mIconId = i;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (i != 0) {
            imageView.setVisibility(0);
            this.mIconView.setImageResource(this.mIconId);
            return;
        }
        imageView.setVisibility(8);
    }

    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        this.mIconId = 0;
        ImageView imageView = this.mIconView;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public int getIconAttributeResId(int i) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
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

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    @Nullable
    private ViewGroup resolvePanel(@Nullable View view, @Nullable View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void setupView() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.mWindow.findViewById(R.id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R.id.topPanel);
        View findViewById5 = findViewById3.findViewById(R.id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R.id.customPanel);
        setupCustomContent(viewGroup);
        View findViewById7 = viewGroup.findViewById(R.id.topPanel);
        View findViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup resolvePanel = resolvePanel(findViewById7, findViewById4);
        ViewGroup resolvePanel2 = resolvePanel(findViewById8, findViewById5);
        ViewGroup resolvePanel3 = resolvePanel(findViewById9, findViewById6);
        setupContent(resolvePanel2);
        setupButtons(resolvePanel3);
        setupTitle(resolvePanel);
        char c = 0;
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (resolvePanel == null || resolvePanel.getVisibility() == 8) ? false : true;
        boolean z3 = (resolvePanel3 == null || resolvePanel3.getVisibility() == 8) ? false : true;
        if (!(z3 || resolvePanel2 == null || (findViewById2 = resolvePanel2.findViewById(R.id.textSpacerNoButtons)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z2) {
            NestedScrollView nestedScrollView = this.mScrollView;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.mMessage == null && this.mListView == null && !z) && !z) {
                view = resolvePanel.findViewById(R.id.titleDividerNoCustom);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(resolvePanel2 == null || (findViewById = resolvePanel2.findViewById(R.id.textSpacerNoTitle)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.mListView;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view2 = this.mListView;
            if (view2 == null) {
                view2 = this.mScrollView;
            }
            if (view2 != null) {
                if (z3) {
                    c = 2;
                }
                setScrollIndicators(resolvePanel2, view2, z2 | c ? 1 : 0, 3);
            }
        }
        ListView listView2 = this.mListView;
        if (listView2 != null && (listAdapter = this.mAdapter) != null) {
            listView2.setAdapter(listAdapter);
            int i = this.mCheckedItem;
            if (i >= 0) {
                listView2.setItemChecked(i, true);
                listView2.setSelection(i);
            }
        }
    }

    private void setScrollIndicators(ViewGroup viewGroup, View view, int i, int i2) {
        final View findViewById = this.mWindow.findViewById(R.id.scrollIndicatorUp);
        View findViewById2 = this.mWindow.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.setScrollIndicators(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.mMessage != null) {
                this.mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    /* class android.support.v7.app.AlertController.AnonymousClass2 */

                    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                        AlertController.manageScrollIndicators(nestedScrollView, findViewById, view2);
                    }
                });
                this.mScrollView.post(new Runnable() {
                    /* class android.support.v7.app.AlertController.AnonymousClass3 */

                    public void run() {
                        AlertController.manageScrollIndicators(AlertController.this.mScrollView, findViewById, view2);
                    }
                });
                return;
            }
            ListView listView = this.mListView;
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    /* class android.support.v7.app.AlertController.AnonymousClass4 */

                    public void onScrollStateChanged(AbsListView absListView, int i) {
                    }

                    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                        AlertController.manageScrollIndicators(absListView, findViewById, view2);
                    }
                });
                this.mListView.post(new Runnable() {
                    /* class android.support.v7.app.AlertController.AnonymousClass5 */

                    public void run() {
                        AlertController.manageScrollIndicators(AlertController.this.mListView, findViewById, view2);
                    }
                });
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void setupCustomContent(ViewGroup viewGroup) {
        View view = this.mView;
        boolean z = false;
        if (view == null) {
            view = this.mViewLayoutResId != 0 ? LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false) : null;
        }
        if (view != null) {
            z = true;
        }
        if (!z || !canTextInput(view)) {
            this.mWindow.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.mWindow.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.mViewSpacingSpecified) {
                frameLayout.setPadding(this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            }
            if (this.mListView != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void setupTitle(ViewGroup viewGroup) {
        if (this.mCustomTitleView != null) {
            viewGroup.addView(this.mCustomTitleView, 0, new ViewGroup.LayoutParams(-1, -2));
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.mIconView = (ImageView) this.mWindow.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.mTitle)) || !this.mShowTitle) {
            this.mWindow.findViewById(R.id.title_template).setVisibility(8);
            this.mIconView.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.mTitleView = (TextView) this.mWindow.findViewById(R.id.alertTitle);
        this.mTitleView.setText(this.mTitle);
        int i = this.mIconId;
        if (i != 0) {
            this.mIconView.setImageResource(i);
            return;
        }
        Drawable drawable = this.mIcon;
        if (drawable != null) {
            this.mIconView.setImageDrawable(drawable);
            return;
        }
        this.mTitleView.setPadding(this.mIconView.getPaddingLeft(), this.mIconView.getPaddingTop(), this.mIconView.getPaddingRight(), this.mIconView.getPaddingBottom());
        this.mIconView.setVisibility(8);
    }

    private void setupContent(ViewGroup viewGroup) {
        this.mScrollView = (NestedScrollView) this.mWindow.findViewById(R.id.scrollView);
        this.mScrollView.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        this.mMessageView = (TextView) viewGroup.findViewById(16908299);
        TextView textView = this.mMessageView;
        if (textView != null) {
            CharSequence charSequence = this.mMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.mScrollView.removeView(this.mMessageView);
            if (this.mListView != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.mScrollView.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.mScrollView);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.mListView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    static void manageScrollIndicators(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ViewCompat.canScrollVertically(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ViewCompat.canScrollVertically(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void setupButtons(ViewGroup viewGroup) {
        boolean z;
        this.mButtonPositive = (Button) viewGroup.findViewById(16908313);
        this.mButtonPositive.setOnClickListener(this.mButtonHandler);
        boolean z2 = true;
        if (TextUtils.isEmpty(this.mButtonPositiveText)) {
            this.mButtonPositive.setVisibility(8);
            z = false;
        } else {
            this.mButtonPositive.setText(this.mButtonPositiveText);
            this.mButtonPositive.setVisibility(0);
            z = true;
        }
        this.mButtonNegative = (Button) viewGroup.findViewById(16908314);
        this.mButtonNegative.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNegativeText)) {
            this.mButtonNegative.setVisibility(8);
        } else {
            this.mButtonNegative.setText(this.mButtonNegativeText);
            this.mButtonNegative.setVisibility(0);
            z |= true;
        }
        this.mButtonNeutral = (Button) viewGroup.findViewById(16908315);
        this.mButtonNeutral.setOnClickListener(this.mButtonHandler);
        if (TextUtils.isEmpty(this.mButtonNeutralText)) {
            this.mButtonNeutral.setVisibility(8);
        } else {
            this.mButtonNeutral.setText(this.mButtonNeutralText);
            this.mButtonNeutral.setVisibility(0);
            z |= true;
        }
        if (shouldCenterSingleButton(this.mContext)) {
            if (z) {
                centerButton(this.mButtonPositive);
            } else if (z) {
                centerButton(this.mButtonNegative);
            } else if (z) {
                centerButton(this.mButtonNeutral);
            }
        }
        if (!z) {
            z2 = false;
        }
        if (!z2) {
            viewGroup.setVisibility(8);
        }
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.paddingBottomNoButtons, R.attr.paddingTopNoTitle});
            this.mPaddingBottomNoButtons = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.mPaddingTopNoTitle = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (!z2 || !z) {
                setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
            }
        }
    }

    public static class AlertParams {
        public ListAdapter mAdapter;
        public boolean mCancelable;
        public int mCheckedItem = -1;
        public boolean[] mCheckedItems;
        public final Context mContext;
        public Cursor mCursor;
        public View mCustomTitleView;
        public boolean mForceInverseBackground;
        public Drawable mIcon;
        public int mIconAttrId = 0;
        public int mIconId = 0;
        public final LayoutInflater mInflater;
        public String mIsCheckedColumn;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public CharSequence[] mItems;
        public String mLabelColumn;
        public CharSequence mMessage;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public DialogInterface.OnClickListener mOnClickListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mPositiveButtonText;
        public boolean mRecycleOnMeasure = true;
        public CharSequence mTitle;
        public View mView;
        public int mViewLayoutResId;
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

        public void apply(AlertController alertController) {
            View view = this.mCustomTitleView;
            if (view != null) {
                alertController.setCustomTitle(view);
            } else {
                CharSequence charSequence = this.mTitle;
                if (charSequence != null) {
                    alertController.setTitle(charSequence);
                }
                Drawable drawable = this.mIcon;
                if (drawable != null) {
                    alertController.setIcon(drawable);
                }
                int i = this.mIconId;
                if (i != 0) {
                    alertController.setIcon(i);
                }
                int i2 = this.mIconAttrId;
                if (i2 != 0) {
                    alertController.setIcon(alertController.getIconAttributeResId(i2));
                }
            }
            CharSequence charSequence2 = this.mMessage;
            if (charSequence2 != null) {
                alertController.setMessage(charSequence2);
            }
            CharSequence charSequence3 = this.mPositiveButtonText;
            if (charSequence3 != null) {
                alertController.setButton(-1, charSequence3, this.mPositiveButtonListener, null);
            }
            CharSequence charSequence4 = this.mNegativeButtonText;
            if (charSequence4 != null) {
                alertController.setButton(-2, charSequence4, this.mNegativeButtonListener, null);
            }
            CharSequence charSequence5 = this.mNeutralButtonText;
            if (charSequence5 != null) {
                alertController.setButton(-3, charSequence5, this.mNeutralButtonListener, null);
            }
            if (!(this.mItems == null && this.mCursor == null && this.mAdapter == null)) {
                createListView(alertController);
            }
            View view2 = this.mView;
            if (view2 == null) {
                int i3 = this.mViewLayoutResId;
                if (i3 != 0) {
                    alertController.setView(i3);
                }
            } else if (this.mViewSpacingSpecified) {
                alertController.setView(view2, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
            } else {
                alertController.setView(view2);
            }
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        /* JADX WARN: Type inference failed for: r9v0, types: [android.widget.ListAdapter] */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARN: Type inference failed for: r2v6, types: [android.widget.SimpleCursorAdapter] */
        /* JADX WARN: Type inference failed for: r1v19, types: [android.support.v7.app.AlertController$AlertParams$2] */
        /* JADX WARN: Type inference failed for: r1v20, types: [android.support.v7.app.AlertController$AlertParams$1] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        private void createListView(final AlertController alertController) {
            ? r9;
            int i;
            final RecycleListView recycleListView = (RecycleListView) this.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            if (this.mIsMultiChoice) {
                Cursor cursor = this.mCursor;
                if (cursor == null) {
                    final RecycleListView recycleListView2 = recycleListView;
                    r9 = new ArrayAdapter<CharSequence>(this.mContext, alertController.mMultiChoiceItemLayout, 16908308, this.mItems) {
                        /* class android.support.v7.app.AlertController.AlertParams.AnonymousClass1 */

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
                    final AlertController alertController2 = alertController;
                    r9 = new CursorAdapter(this.mContext, cursor, false) {
                        /* class android.support.v7.app.AlertController.AlertParams.AnonymousClass2 */
                        private final int mIsCheckedIndex;
                        private final int mLabelIndex;

                        {
                            Cursor cursor = getCursor();
                            this.mLabelIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mLabelColumn);
                            this.mIsCheckedIndex = cursor.getColumnIndexOrThrow(AlertParams.this.mIsCheckedColumn);
                        }

                        public void bindView(View view, Context context, Cursor cursor) {
                            ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.mLabelIndex));
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
                            return AlertParams.this.mInflater.inflate(alertController2.mMultiChoiceItemLayout, viewGroup, false);
                        }
                    };
                }
            } else {
                if (this.mIsSingleChoice) {
                    i = alertController.mSingleChoiceItemLayout;
                } else {
                    i = alertController.mListItemLayout;
                }
                int i2 = i;
                Cursor cursor2 = this.mCursor;
                if (cursor2 != null) {
                    r9 = new SimpleCursorAdapter(this.mContext, i2, cursor2, new String[]{this.mLabelColumn}, new int[]{16908308});
                } else {
                    ListAdapter listAdapter = this.mAdapter;
                    r9 = listAdapter;
                    if (listAdapter == null) {
                        r9 = new CheckedItemAdapter(this.mContext, i2, 16908308, this.mItems);
                    }
                }
            }
            OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
            if (onPrepareListViewListener != null) {
                onPrepareListViewListener.onPrepareListView(recycleListView);
            }
            alertController.mAdapter = r9;
            alertController.mCheckedItem = this.mCheckedItem;
            if (this.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class android.support.v7.app.AlertController.AlertParams.AnonymousClass3 */

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AlertParams.this.mOnClickListener.onClick(alertController.mDialog, i);
                        if (!AlertParams.this.mIsSingleChoice) {
                            alertController.mDialog.dismiss();
                        }
                    }
                });
            } else if (this.mOnCheckboxClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class android.support.v7.app.AlertController.AlertParams.AnonymousClass4 */

                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (AlertParams.this.mCheckedItems != null) {
                            AlertParams.this.mCheckedItems[i] = recycleListView.isItemChecked(i);
                        }
                        AlertParams.this.mOnCheckboxClickListener.onClick(alertController.mDialog, i, recycleListView.isItemChecked(i));
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
            alertController.mListView = recycleListView;
        }
    }

    static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public CheckedItemAdapter(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }
    }
}
