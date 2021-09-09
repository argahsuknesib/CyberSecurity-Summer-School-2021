package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    private final AccessibilityManager accessibilityManager;
    public final ListPopupWindow modalListPopup;
    private final Rect tempRect;

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, 0), attributeSet, i);
        this.tempRect = new Rect();
        Context context2 = getContext();
        Context context3 = context2;
        AttributeSet attributeSet2 = attributeSet;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context3, attributeSet2, new int[]{16843296}, i, 2132739002, new int[0]);
        if (obtainStyledAttributes.hasValue(0) && obtainStyledAttributes.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        this.modalListPopup = new ListPopupWindow(context2);
        this.modalListPopup.O0000OOo();
        ListPopupWindow listPopupWindow = this.modalListPopup;
        listPopupWindow.O0000Ooo = this;
        listPopupWindow.O0000Oo0();
        this.modalListPopup.O000000o(getAdapter());
        this.modalListPopup.O0000o00 = new AdapterView.OnItemClickListener() {
            /* class com.google.android.material.textfield.MaterialAutoCompleteTextView.AnonymousClass1 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object obj;
                View view2 = null;
                if (i < 0) {
                    ListPopupWindow listPopupWindow = MaterialAutoCompleteTextView.this.modalListPopup;
                    obj = !listPopupWindow.O0000o.isShowing() ? null : listPopupWindow.O00000oO.getSelectedItem();
                } else {
                    obj = MaterialAutoCompleteTextView.this.getAdapter().getItem(i);
                }
                MaterialAutoCompleteTextView.this.updateText(obj);
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        ListPopupWindow listPopupWindow2 = MaterialAutoCompleteTextView.this.modalListPopup;
                        if (listPopupWindow2.O0000o.isShowing()) {
                            view2 = listPopupWindow2.O00000oO.getSelectedView();
                        }
                        view = view2;
                        i = MaterialAutoCompleteTextView.this.modalListPopup.O0000Ooo();
                        ListPopupWindow listPopupWindow3 = MaterialAutoCompleteTextView.this.modalListPopup;
                        if (!listPopupWindow3.O0000o.isShowing()) {
                            j = Long.MIN_VALUE;
                        } else {
                            j = listPopupWindow3.O00000oO.getSelectedItemId();
                        }
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.modalListPopup.O00000oO, view, i, j);
                }
                MaterialAutoCompleteTextView.this.modalListPopup.O00000Oo();
            }
        };
        obtainStyledAttributes.recycle();
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 == null || !accessibilityManager2.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.modalListPopup.a_();
        }
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.modalListPopup.O000000o(getAdapter());
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor != null && findTextInputLayoutAncestor.isProvidingHint() && super.getHint() == null && ManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    public CharSequence getHint() {
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        if (findTextInputLayoutAncestor == null || !findTextInputLayoutAncestor.isProvidingHint()) {
            return super.getHint();
        }
        return findTextInputLayoutAncestor.getHint();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), measureContentWidth()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    private int measureContentWidth() {
        ListAdapter adapter = getAdapter();
        TextInputLayout findTextInputLayoutAncestor = findTextInputLayoutAncestor();
        int i = 0;
        if (adapter == null || findTextInputLayoutAncestor == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int min = Math.min(adapter.getCount(), Math.max(0, this.modalListPopup.O0000Ooo()) + 15);
        View view = null;
        int i2 = 0;
        for (int max = Math.max(0, min - 15); max < min; max++) {
            int itemViewType = adapter.getItemViewType(max);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = adapter.getView(max, view, findTextInputLayoutAncestor);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        Drawable background = this.modalListPopup.O0000o.getBackground();
        if (background != null) {
            background.getPadding(this.tempRect);
            i2 += this.tempRect.left + this.tempRect.right;
        }
        return i2 + findTextInputLayoutAncestor.getEndIconView().getMeasuredWidth();
    }

    private TextInputLayout findTextInputLayoutAncestor() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: SimpleMethodDetails{com.google.android.material.textfield.MaterialAutoCompleteTextView.setText(java.lang.CharSequence, boolean):void}
     arg types: [java.lang.CharSequence, int]
     candidates:
      ClspMth{android.widget.EditText.setText(java.lang.CharSequence, android.widget.TextView$BufferType):void}
      ClspMth{android.widget.TextView.setText(int, android.widget.TextView$BufferType):void}
      ClspMth{android.widget.TextView.setText(java.lang.CharSequence, android.widget.TextView$BufferType):void}
      SimpleMethodDetails{com.google.android.material.textfield.MaterialAutoCompleteTextView.setText(java.lang.CharSequence, boolean):void} */
    public <T extends ListAdapter & Filterable> void updateText(Object obj) {
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(obj), false);
            return;
        }
        ListAdapter adapter = getAdapter();
        setAdapter(null);
        setText(convertSelectionToString(obj));
        setAdapter(adapter);
    }
}
