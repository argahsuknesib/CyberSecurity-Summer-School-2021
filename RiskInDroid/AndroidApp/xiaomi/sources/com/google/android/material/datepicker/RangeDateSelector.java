package com.google.android.material.datepicker;

import _m_j.be;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
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

public class RangeDateSelector implements DateSelector<be<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        /* class com.google.android.material.datepicker.RangeDateSelector.AnonymousClass3 */

        public final RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        public final RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }
    };
    private final String invalidRangeEndError = " ";
    private String invalidRangeStartError;
    public Long proposedTextEnd = null;
    public Long proposedTextStart = null;
    public Long selectedEndItem = null;
    public Long selectedStartItem = null;

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
    }

    public /* bridge */ /* synthetic */ void setSelection(Object obj) {
        setSelection((be<Long, Long>) ((be) obj));
    }

    public void select(long j) {
        Long l = this.selectedStartItem;
        if (l == null) {
            this.selectedStartItem = Long.valueOf(j);
        } else if (this.selectedEndItem != null || !isValidRange(l.longValue(), j)) {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j);
        } else {
            this.selectedEndItem = Long.valueOf(j);
        }
    }

    public boolean isSelectionComplete() {
        Long l = this.selectedStartItem;
        return (l == null || this.selectedEndItem == null || !isValidRange(l.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    public void setSelection(be<Long, Long> beVar) {
        Long l;
        if (beVar.f12896O000000o == null || beVar.O00000Oo == null || isValidRange(((Long) beVar.f12896O000000o).longValue(), ((Long) beVar.O00000Oo).longValue())) {
            Long l2 = null;
            if (beVar.f12896O000000o == null) {
                l = null;
            } else {
                l = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) beVar.f12896O000000o).longValue()));
            }
            this.selectedStartItem = l;
            if (beVar.O00000Oo != null) {
                l2 = Long.valueOf(UtcDates.canonicalYearMonthDay(((Long) beVar.O00000Oo).longValue()));
            }
            this.selectedEndItem = l2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public be<Long, Long> getSelection() {
        return new be<>(this.selectedStartItem, this.selectedEndItem);
    }

    public Collection<be<Long, Long>> getSelectedRanges() {
        if (this.selectedStartItem == null || this.selectedEndItem == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new be(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        Long l = this.selectedStartItem;
        if (l != null) {
            arrayList.add(l);
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        if (this.selectedStartItem == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l = this.selectedEndItem;
        if (l == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, DateStrings.getDateString(this.selectedStartItem.longValue()));
        }
        Long l2 = this.selectedStartItem;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, DateStrings.getDateString(l.longValue()));
        }
        be<String, String> dateRangeString = DateStrings.getDateRangeString(l2, l);
        return resources.getString(R.string.mtrl_picker_range_header_selected, dateRangeString.f12896O000000o, dateRangeString.O00000Oo);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<be<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate((int) R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat textInputFormat = UtcDates.getTextInputFormat();
        Long l = this.selectedStartItem;
        if (l != null) {
            editText.setText(textInputFormat.format(l));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l2 = this.selectedEndItem;
        if (l2 != null) {
            editText2.setText(textInputFormat.format(l2));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String textInputHint = UtcDates.getTextInputHint(inflate.getResources(), textInputFormat);
        textInputLayout.setPlaceholderText(textInputHint);
        textInputLayout2.setPlaceholderText(textInputHint);
        SimpleDateFormat simpleDateFormat = textInputFormat;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final TextInputLayout textInputLayout3 = textInputLayout;
        AnonymousClass1 r9 = r0;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        String str = textInputHint;
        final OnSelectionChangedListener<be<Long, Long>> onSelectionChangedListener2 = onSelectionChangedListener;
        AnonymousClass1 r0 = new DateFormatTextWatcher(textInputHint, simpleDateFormat, textInputLayout, calendarConstraints2) {
            /* class com.google.android.material.datepicker.RangeDateSelector.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextStart = l;
                rangeDateSelector.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextStart = null;
                rangeDateSelector.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        };
        editText.addTextChangedListener(r9);
        editText2.addTextChangedListener(new DateFormatTextWatcher(str, simpleDateFormat, textInputLayout2, calendarConstraints2) {
            /* class com.google.android.material.datepicker.RangeDateSelector.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public void onValidDate(Long l) {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextEnd = l;
                rangeDateSelector.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }

            /* access modifiers changed from: package-private */
            public void onInvalidDate() {
                RangeDateSelector rangeDateSelector = RangeDateSelector.this;
                rangeDateSelector.proposedTextEnd = null;
                rangeDateSelector.updateIfValidTextProposal(textInputLayout3, textInputLayout4, onSelectionChangedListener2);
            }
        });
        ViewUtils.requestFocusAndShowKeyboard(editText);
        return inflate;
    }

    public void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener<be<Long, Long>> onSelectionChangedListener) {
        Long l = this.proposedTextStart;
        if (l == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(l.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
    }

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError(null);
        }
    }

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}
