package com.google.android.material.timepicker;

import _m_j.dz;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import com.xiaomi.smarthome.R;
import java.util.LinkedHashSet;
import java.util.Set;

public final class MaterialTimePicker extends dz {
    private TimePickerPresenter activePresenter;
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    private int clockIcon;
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    public int inputMode = 0;
    private int keyboardIcon;
    public MaterialButton modeButton;
    public final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    public final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private ViewStub textInputStub;
    private LinearLayout textInputView;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    public TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private int titleResId = 0;
    private String titleText;

    public static MaterialTimePicker newInstance(Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", builder.time);
        bundle.putInt("TIME_PICKER_INPUT_MODE", builder.inputMode);
        bundle.putInt("TIME_PICKER_TITLE_RES", builder.titleTextResId);
        if (builder.titleText != null) {
            bundle.putString("TIME_PICKER_TITLE_TEXT", builder.titleText.toString());
        }
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    public final int getMinute() {
        return this.time.minute;
    }

    public final int getHour() {
        return this.time.hour % 24;
    }

    public final int getInputMode() {
        return this.inputMode;
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        Dialog dialog = new Dialog(requireContext(), resolve == null ? 0 : resolve.data);
        Context context = dialog.getContext();
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialTimePicker.class.getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialTimePickerStyle, 2132739190);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.clockIcon, R.attr.keyboardIcon}, R.attr.materialTimePickerStyle, 2132739190);
        this.clockIcon = obtainStyledAttributes.getResourceId(0, 0);
        this.keyboardIcon = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        restoreState(bundle);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.time);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.inputMode);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.titleResId);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.titleText);
    }

    private void restoreState(Bundle bundle) {
        if (bundle != null) {
            this.time = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
            if (this.time == null) {
                this.time = new TimeModel();
            }
            this.inputMode = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
            this.titleResId = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
            this.titleText = bundle.getString("TIME_PICKER_TITLE_TEXT");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate((int) R.layout.material_timepicker_dialog, viewGroup);
        this.timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.timePickerView.setOnDoubleTapListener(new TimePickerView.OnDoubleTapListener() {
            /* class com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass1 */

            public void onDoubleTap() {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.inputMode = 1;
                materialTimePicker.updateInputMode(materialTimePicker.modeButton);
                MaterialTimePicker.this.timePickerTextInputPresenter.resetChecked();
            }
        });
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        int i = this.titleResId;
        if (i != 0) {
            textView.setText(i);
        }
        updateInputMode(this.modeButton);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass2 */

            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.positiveButtonListeners) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass3 */

            public void onClick(View view) {
                for (View.OnClickListener onClick : MaterialTimePicker.this.negativeButtonListeners) {
                    onClick.onClick(view);
                }
                MaterialTimePicker.this.dismiss();
            }
        });
        this.modeButton.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.timepicker.MaterialTimePicker.AnonymousClass4 */

            public void onClick(View view) {
                MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
                materialTimePicker.inputMode = materialTimePicker.inputMode == 0 ? 1 : 0;
                MaterialTimePicker materialTimePicker2 = MaterialTimePicker.this;
                materialTimePicker2.updateInputMode(materialTimePicker2.modeButton);
            }
        });
        return viewGroup2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancel : this.cancelListeners) {
            onCancel.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismiss : this.dismissListeners) {
            onDismiss.onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final void updateInputMode(MaterialButton materialButton) {
        TimePickerPresenter timePickerPresenter = this.activePresenter;
        if (timePickerPresenter != null) {
            timePickerPresenter.hide();
        }
        this.activePresenter = initializeOrRetrieveActivePresenterForMode(this.inputMode);
        this.activePresenter.show();
        this.activePresenter.invalidate();
        Pair<Integer, Integer> dataForMode = dataForMode(this.inputMode);
        materialButton.setIconResource(((Integer) dataForMode.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) dataForMode.second).intValue()));
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int i) {
        if (i == 0) {
            TimePickerClockPresenter timePickerClockPresenter2 = this.timePickerClockPresenter;
            if (timePickerClockPresenter2 == null) {
                timePickerClockPresenter2 = new TimePickerClockPresenter(this.timePickerView, this.time);
            }
            this.timePickerClockPresenter = timePickerClockPresenter2;
            return this.timePickerClockPresenter;
        }
        if (this.timePickerTextInputPresenter == null) {
            this.textInputView = (LinearLayout) this.textInputStub.inflate();
            this.timePickerTextInputPresenter = new TimePickerTextInputPresenter(this.textInputView, this.time);
        }
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    private Pair<Integer, Integer> dataForMode(int i) {
        if (i == 0) {
            return new Pair<>(Integer.valueOf(this.keyboardIcon), Integer.valueOf((int) R.string.material_timepicker_text_input_mode_description));
        }
        if (i == 1) {
            return new Pair<>(Integer.valueOf(this.clockIcon), Integer.valueOf((int) R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: ".concat(String.valueOf(i)));
    }

    /* access modifiers changed from: package-private */
    public final TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    public final boolean addOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public final boolean removeOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }

    public final void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public final boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public final boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public final void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public final boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public final boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public final void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public final boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public final void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public static final class Builder {
        public int inputMode;
        public TimeModel time = new TimeModel();
        public CharSequence titleText;
        public int titleTextResId = 0;

        public final Builder setInputMode(int i) {
            this.inputMode = i;
            return this;
        }

        public final Builder setHour(int i) {
            this.time.setHourOfDay(i);
            return this;
        }

        public final Builder setMinute(int i) {
            this.time.setMinute(i);
            return this;
        }

        public final Builder setTimeFormat(int i) {
            int i2 = this.time.hour;
            int i3 = this.time.minute;
            this.time = new TimeModel(i);
            this.time.setMinute(i3);
            this.time.setHourOfDay(i2);
            return this;
        }

        public final Builder setTitleText(int i) {
            this.titleTextResId = i;
            return this;
        }

        public final Builder setTitleText(CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }

        public final MaterialTimePicker build() {
            return MaterialTimePicker.newInstance(this);
        }
    }
}
