package com.google.android.material.timepicker;

import _m_j.OO0000o;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.timepicker.TimePickerView;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;
import java.util.Locale;

class TimePickerTextInputPresenter implements TimePickerPresenter, TimePickerView.OnSelectionChange {
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final ChipTextInputComboView hourTextInput;
    private final TextWatcher hourTextWatcher = new TextWatcherAdapter() {
        /* class com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass2 */

        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setHour(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setHour(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    private final EditText minuteEditText;
    private final ChipTextInputComboView minuteTextInput;
    private final TextWatcher minuteTextWatcher = new TextWatcherAdapter() {
        /* class com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass1 */

        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.this.time.setMinute(0);
                    return;
                }
                TimePickerTextInputPresenter.this.time.setMinute(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };
    public final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        Resources resources = linearLayout.getResources();
        this.minuteTextInput = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.hourTextInput = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        ((TextView) this.minuteTextInput.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) this.hourTextInput.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_hour));
        this.minuteTextInput.setTag(R.id.selection_type, 12);
        this.hourTextInput.setTag(R.id.selection_type, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        AnonymousClass3 r0 = new View.OnClickListener() {
            /* class com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass3 */

            public void onClick(View view) {
                TimePickerTextInputPresenter.this.onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        this.hourTextInput.setOnClickListener(r0);
        this.minuteTextInput.setOnClickListener(r0);
        this.hourTextInput.addInputFilter(timeModel.getHourInputValidator());
        this.minuteTextInput.addInputFilter(timeModel.getMinuteInputValidator());
        this.hourEditText = this.hourTextInput.getTextInput().getEditText();
        this.minuteEditText = this.minuteTextInput.getTextInput().getEditText();
        if (Build.VERSION.SDK_INT < 21) {
            int color = MaterialColors.getColor(linearLayout, R.attr.colorPrimary);
            setCursorDrawableColor(this.hourEditText, color);
            setCursorDrawableColor(this.minuteEditText, color);
        }
        this.controller = new TimePickerTextInputKeyController(this.hourTextInput, this.minuteTextInput, timeModel);
        this.hourTextInput.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_hour_selection));
        this.minuteTextInput.setChipDelegate(new ClickActionDelegate(linearLayout.getContext(), R.string.material_minute_selection));
        initialize();
    }

    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private void setTime(TimeModel timeModel) {
        removeTextWatchers();
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", Integer.valueOf(timeModel.minute));
        String format2 = String.format(locale, "%02d", Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(format);
        this.hourTextInput.setText(format2);
        addTextWatchers();
        updateSelection();
    }

    private void setupPeriodToggle() {
        this.toggle = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            /* class com.google.android.material.timepicker.TimePickerTextInputPresenter.AnonymousClass4 */

            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
                TimePickerTextInputPresenter.this.time.setPeriod(i == R.id.material_clock_period_pm_button ? 1 : 0);
            }
        });
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.toggle;
        if (materialButtonToggleGroup != null) {
            materialButtonToggleGroup.check(this.time.period == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
        }
    }

    public void onSelectionChanged(int i) {
        this.time.selection = i;
        boolean z = true;
        this.minuteTextInput.setChecked(i == 12);
        ChipTextInputComboView chipTextInputComboView = this.hourTextInput;
        if (i != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
        updateSelection();
    }

    public void show() {
        this.timePickerView.setVisibility(0);
    }

    public void hide() {
        View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild == null) {
            this.timePickerView.setVisibility(8);
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.O000000o(this.timePickerView.getContext(), InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.timePickerView.setVisibility(8);
    }

    public void invalidate() {
        setTime(this.time);
    }

    private static void setCursorDrawableColor(EditText editText, int i) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable O00000Oo = OO0000o.O00000Oo(context, i2);
            O00000Oo.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{O00000Oo, O00000Oo});
        } catch (Throwable unused) {
        }
    }

    public void resetChecked() {
        boolean z = true;
        this.minuteTextInput.setChecked(this.time.selection == 12);
        ChipTextInputComboView chipTextInputComboView = this.hourTextInput;
        if (this.time.selection != 10) {
            z = false;
        }
        chipTextInputComboView.setChecked(z);
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }
}
