package com.google.android.material.datepicker;

import _m_j.be;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        /* class com.google.android.material.datepicker.SingleDateSelector.AnonymousClass2 */

        public final SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        public final SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }
    };
    public Long selectedItem;

    public int describeContents() {
        return 0;
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    public void clearSelection() {
        this.selectedItem = null;
    }

    public void setSelection(Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    public Collection<be<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedItem;
        if (l != null) {
            arrayList.add(l);
        }
        return arrayList;
    }

    public Long getSelection() {
        return this.selectedItem;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate((int) R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        Long l = this.selectedItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
        }
        final OnSelectionChangedListener<Long> onSelectionChangedListener2 = onSelectionChangedListener;
        editText.addTextChangedListener(new DateFormatTextWatcher(textInputHint, textInputFormat, textInputLayout, calendarConstraints) {
            /* class com.google.android.material.datepicker.SingleDateSelector.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                if (l == null) {
                    SingleDateSelector.this.clearSelection();
                } else {
                    SingleDateSelector.this.select(l.longValue());
                }
                onSelectionChangedListener2.onSelectionChanged(SingleDateSelector.this.getSelection());
            }

            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                onSelectionChangedListener2.onIncompleteSelectionChanged();
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        Long l = this.selectedItem;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, DateStrings.getYearMonthDay(l.longValue()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }
}
