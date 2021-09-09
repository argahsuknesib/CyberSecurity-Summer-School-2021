package androidx.appcompat.widget;

import _m_j.OO0000o;
import _m_j.OO0o;
import _m_j.OOO0oO;
import _m_j.OOOo00;
import _m_j.OOOo000;
import _m_j.Oo;
import _m_j.Oo000;
import _m_j.ca;
import _m_j.cb;
import _m_j.o00;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.xiaomi.smarthome.R;

public class AppCompatSpinner extends Spinner implements ca {
    private static final int[] ATTRS_ANDROID_SPINNERMODE = {16843505};
    private final OOO0oO mBackgroundTintHelper;
    int mDropDownWidth;
    private OOOo00 mForwardingListener;
    private O00000o mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    final Rect mTempRect;

    interface O00000o {
        CharSequence O000000o();

        void O000000o(int i);

        void O000000o(int i, int i2);

        void O000000o(Drawable drawable);

        void O000000o(ListAdapter listAdapter);

        void O000000o(CharSequence charSequence);

        void O00000Oo();

        void O00000Oo(int i);

        Drawable O00000o();

        void O00000o0(int i);

        boolean O00000o0();

        int O00000oO();

        int O00000oo();
    }

    public AppCompatSpinner(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, R.attr.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (r12 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r12 != null) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) {
        super(context, attributeSet, i);
        TypedArray typedArray;
        this.mTempRect = new Rect();
        Oo000.O000000o(this, getContext());
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{16842930, 16843126, 16843131, 16843362, R.attr.popupTheme}, i, 0);
        this.mBackgroundTintHelper = new OOO0oO(this);
        if (theme != null) {
            this.mPopupContext = new ContextThemeWrapper(context, theme);
        } else {
            int O0000O0o = O000000o2.O0000O0o(4, 0);
            if (O0000O0o != 0) {
                this.mPopupContext = new ContextThemeWrapper(context, O0000O0o);
            } else {
                this.mPopupContext = context;
            }
        }
        if (i2 == -1) {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, i, 0);
                try {
                    i2 = typedArray.hasValue(0) ? typedArray.getInt(0, 0) : i2;
                } catch (Exception e) {
                    e = e;
                    try {
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                    } catch (Throwable th) {
                        th = th;
                        if (typedArray != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                typedArray = null;
                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
            } catch (Throwable th2) {
                th = th2;
                typedArray = null;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw th;
            }
        }
        if (i2 == 0) {
            this.mPopup = new O000000o();
            this.mPopup.O000000o(O000000o2.O00000o(2));
        } else if (i2 == 1) {
            final O00000o0 o00000o0 = new O00000o0(this.mPopupContext, attributeSet, i);
            Oo O000000o3 = Oo.O000000o(this.mPopupContext, attributeSet, new int[]{16842930, 16843126, 16843131, 16843362, R.attr.popupTheme}, i, 0);
            this.mDropDownWidth = O000000o3.O00000oo(3, -2);
            o00000o0.O000000o(O000000o3.O000000o(1));
            o00000o0.f2711O000000o = O000000o2.O00000o(2);
            O000000o3.f12340O000000o.recycle();
            this.mPopup = o00000o0;
            this.mForwardingListener = new OOOo00(this) {
                /* class androidx.appcompat.widget.AppCompatSpinner.AnonymousClass1 */

                public final OO0o O000000o() {
                    return o00000o0;
                }

                @SuppressLint({"SyntheticAccessor"})
                public final boolean O00000Oo() {
                    if (AppCompatSpinner.this.getInternalPopup().O00000o0()) {
                        return true;
                    }
                    AppCompatSpinner.this.showPopup();
                    return true;
                }
            };
        }
        CharSequence[] textArray = O000000o2.f12340O000000o.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        O000000o2.f12340O000000o.recycle();
        this.mPopupSet = true;
        SpinnerAdapter spinnerAdapter = this.mTempAdapter;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.O000000o(attributeSet, i);
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            o00000o.O000000o(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(OO0000o.O00000Oo(getPopupContext(), i));
    }

    public Drawable getPopupBackground() {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            return o00000o.O00000o();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    public void setDropDownVerticalOffset(int i) {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            o00000o.O000000o(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public int getDropDownVerticalOffset() {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            return o00000o.O00000oO();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public void setDropDownHorizontalOffset(int i) {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            o00000o.O00000o0(i);
            this.mPopup.O00000Oo(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public int getDropDownHorizontalOffset() {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            return o00000o.O00000oo();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    public int getDropDownWidth() {
        if (this.mPopup != null) {
            return this.mDropDownWidth;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.mPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            this.mPopup.O000000o(new O00000Oo(spinnerAdapter, context.getTheme()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        O00000o o00000o = this.mPopup;
        if (o00000o != null && o00000o.O00000o0()) {
            this.mPopup.O00000Oo();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OOOo00 oOOo00 = this.mForwardingListener;
        if (oOOo00 == null || !oOOo00.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean performClick() {
        O00000o o00000o = this.mPopup;
        if (o00000o == null) {
            return super.performClick();
        }
        if (o00000o.O00000o0()) {
            return true;
        }
        showPopup();
        return true;
    }

    public void setPrompt(CharSequence charSequence) {
        O00000o o00000o = this.mPopup;
        if (o00000o != null) {
            o00000o.O000000o(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public CharSequence getPrompt() {
        O00000o o00000o = this.mPopup;
        return o00000o != null ? o00000o.O000000o() : super.getPrompt();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000Oo();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O000000o(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            return oOO0oO.O00000o0();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        OOO0oO oOO0oO = this.mBackgroundTintHelper;
        if (oOO0oO != null) {
            oOO0oO.O00000o();
        }
    }

    /* access modifiers changed from: package-private */
    public int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.mTempRect);
        return i2 + this.mTempRect.left + this.mTempRect.right;
    }

    /* access modifiers changed from: package-private */
    public final O00000o getInternalPopup() {
        return this.mPopup;
    }

    /* access modifiers changed from: package-private */
    public void showPopup() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.mPopup.O000000o(getTextDirection(), getTextAlignment());
        } else {
            this.mPopup.O000000o(-1, -1);
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        O00000o o00000o = this.mPopup;
        savedState.f2715O000000o = o00000o != null && o00000o.O00000o0();
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f2715O000000o && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class androidx.appcompat.widget.AppCompatSpinner.AnonymousClass2 */

                public final void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().O00000o0()) {
                        AppCompatSpinner.this.showPopup();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver == null) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver.removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class androidx.appcompat.widget.AppCompatSpinner.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2715O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2715O000000o = parcel.readByte() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f2715O000000o ? (byte) 1 : 0);
        }
    }

    static class O00000Oo implements ListAdapter, SpinnerAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        private SpinnerAdapter f2710O000000o;
        private ListAdapter O00000Oo;

        public final int getItemViewType(int i) {
            return 0;
        }

        public final int getViewTypeCount() {
            return 1;
        }

        public O00000Oo(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2710O000000o = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.O00000Oo = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2710O000000o;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }

        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.O00000Oo;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.O00000Oo;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }
    }

    class O000000o implements DialogInterface.OnClickListener, O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        AlertDialog f2709O000000o;
        private CharSequence O00000o;
        private ListAdapter O00000o0;

        public final Drawable O00000o() {
            return null;
        }

        public final int O00000oO() {
            return 0;
        }

        public final int O00000oo() {
            return 0;
        }

        O000000o() {
        }

        public final void O00000Oo() {
            AlertDialog alertDialog = this.f2709O000000o;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f2709O000000o = null;
            }
        }

        public final boolean O00000o0() {
            AlertDialog alertDialog = this.f2709O000000o;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public final void O000000o(ListAdapter listAdapter) {
            this.O00000o0 = listAdapter;
        }

        public final void O000000o(CharSequence charSequence) {
            this.O00000o = charSequence;
        }

        public final CharSequence O000000o() {
            return this.O00000o;
        }

        public final void O000000o(int i, int i2) {
            if (this.O00000o0 != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.O00000o;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                this.f2709O000000o = builder.setSingleChoiceItems(this.O00000o0, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
                ListView listView = this.f2709O000000o.f2647O000000o.O0000O0o;
                if (Build.VERSION.SDK_INT >= 17) {
                    listView.setTextDirection(i);
                    listView.setTextAlignment(i2);
                }
                this.f2709O000000o.show();
            }
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.O00000o0.getItemId(i));
            }
            O00000Oo();
        }

        public final void O000000o(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public final void O000000o(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public final void O00000Oo(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public final void O00000o0(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    class O00000o0 extends ListPopupWindow implements O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        CharSequence f2711O000000o;
        ListAdapter O00000Oo;
        final Rect O00000o0 = new Rect();
        private int O0000oO0;

        public O00000o0(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.O0000Ooo = AppCompatSpinner.this;
            O0000OOo();
            this.O0000OoO = 0;
            this.O0000o00 = new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                /* class androidx.appcompat.widget.AppCompatSpinner.O00000o0.AnonymousClass1 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppCompatSpinner.this.setSelection(i);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i, O00000o0.this.O00000Oo.getItemId(i));
                    }
                    O00000o0.this.O00000Oo();
                }
            };
        }

        public final void O000000o(ListAdapter listAdapter) {
            super.O000000o(listAdapter);
            this.O00000Oo = listAdapter;
        }

        public final CharSequence O000000o() {
            return this.f2711O000000o;
        }

        public final void O000000o(CharSequence charSequence) {
            this.f2711O000000o = charSequence;
        }

        public final void O00000o0(int i) {
            this.O0000oO0 = i;
        }

        /* access modifiers changed from: package-private */
        public final void O0000O0o() {
            int i;
            int i2;
            Drawable background = this.O0000o.getBackground();
            int i3 = 0;
            if (background != null) {
                background.getPadding(AppCompatSpinner.this.mTempRect);
                if (o00.O000000o(AppCompatSpinner.this)) {
                    i2 = AppCompatSpinner.this.mTempRect.right;
                } else {
                    i2 = -AppCompatSpinner.this.mTempRect.left;
                }
                i3 = i2;
            } else {
                Rect rect = AppCompatSpinner.this.mTempRect;
                AppCompatSpinner.this.mTempRect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.mDropDownWidth == -2) {
                int compatMeasureContentWidth = AppCompatSpinner.this.compatMeasureContentWidth((SpinnerAdapter) this.O00000Oo, this.O0000o.getBackground());
                int i4 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.mTempRect.left) - AppCompatSpinner.this.mTempRect.right;
                if (compatMeasureContentWidth > i4) {
                    compatMeasureContentWidth = i4;
                }
                O00000o(Math.max(compatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.mDropDownWidth == -1) {
                O00000o((width - paddingLeft) - paddingRight);
            } else {
                O00000o(AppCompatSpinner.this.mDropDownWidth);
            }
            if (o00.O000000o(AppCompatSpinner.this)) {
                i = i3 + (((width - paddingRight) - this.O0000O0o) - this.O0000oO0);
            } else {
                i = i3 + paddingLeft + this.O0000oO0;
            }
            this.O0000OOo = i;
        }

        public final void O000000o(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = this.O0000o.isShowing();
            O0000O0o();
            O0000Oo0();
            super.a_();
            OOOo000 oOOo000 = this.O00000oO;
            oOOo000.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                oOOo000.setTextDirection(i);
                oOOo000.setTextAlignment(i2);
            }
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            OOOo000 oOOo0002 = this.O00000oO;
            if (this.O0000o.isShowing() && oOOo0002 != null) {
                oOOo0002.setListSelectionHidden(false);
                oOOo0002.setSelection(selectedItemPosition);
                if (oOOo0002.getChoiceMode() != 0) {
                    oOOo0002.setItemChecked(selectedItemPosition, true);
                }
            }
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r7 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    /* class androidx.appcompat.widget.AppCompatSpinner.O00000o0.AnonymousClass2 */

                    public final void onGlobalLayout() {
                        O00000o0 o00000o0 = O00000o0.this;
                        AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                        if (!(cb.O000OO0o(appCompatSpinner) && appCompatSpinner.getGlobalVisibleRect(o00000o0.O00000o0))) {
                            O00000o0.this.O00000Oo();
                            return;
                        }
                        O00000o0.this.O0000O0o();
                        O00000o0.super.a_();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r7);
                O000000o(new PopupWindow.OnDismissListener() {
                    /* class androidx.appcompat.widget.AppCompatSpinner.O00000o0.AnonymousClass3 */

                    public final void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r7);
                        }
                    }
                });
            }
        }
    }
}
