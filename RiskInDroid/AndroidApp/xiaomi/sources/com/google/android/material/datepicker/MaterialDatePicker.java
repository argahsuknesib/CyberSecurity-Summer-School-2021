package com.google.android.material.datepicker;

import _m_j.OO0000o;
import _m_j.be;
import _m_j.bh;
import _m_j.cb;
import _m_j.dz;
import _m_j.ei;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.dialog.InsetDialogOnTouchListener;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.xiaomi.smarthome.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class MaterialDatePicker<S> extends dz {
    static final Object CANCEL_BUTTON_TAG = "CANCEL_BUTTON_TAG";
    static final Object CONFIRM_BUTTON_TAG = "CONFIRM_BUTTON_TAG";
    static final Object TOGGLE_BUTTON_TAG = "TOGGLE_BUTTON_TAG";
    private MaterialShapeDrawable background;
    private MaterialCalendar<S> calendar;
    private CalendarConstraints calendarConstraints;
    public Button confirmButton;
    public DateSelector<S> dateSelector;
    private boolean fullscreen;
    private TextView headerSelectionText;
    public CheckableImageButton headerToggleButton;
    private int inputMode;
    private final LinkedHashSet<DialogInterface.OnCancelListener> onCancelListeners = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> onDismissListeners = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> onNegativeButtonClickListeners = new LinkedHashSet<>();
    public final LinkedHashSet<MaterialPickerOnPositiveButtonClickListener<? super S>> onPositiveButtonClickListeners = new LinkedHashSet<>();
    private int overrideThemeResId;
    private PickerFragment<S> pickerFragment;
    private CharSequence titleText;
    private int titleTextResId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface InputMode {
    }

    public static long todayInUtcMilliseconds() {
        return UtcDates.getTodayCalendar().getTimeInMillis();
    }

    public static long thisMonthInUtcMilliseconds() {
        return Month.current().timeInMillis;
    }

    public final String getHeaderText() {
        return this.dateSelector.getSelectionDisplayString(getContext());
    }

    static <S> MaterialDatePicker<S> newInstance(Builder<S> builder) {
        MaterialDatePicker<S> materialDatePicker = new MaterialDatePicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("OVERRIDE_THEME_RES_ID", builder.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", builder.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.calendarConstraints);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", builder.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", builder.titleText);
        bundle.putInt("INPUT_MODE_KEY", builder.inputMode);
        materialDatePicker.setArguments(bundle);
        return materialDatePicker;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.overrideThemeResId);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.dateSelector);
        CalendarConstraints.Builder builder = new CalendarConstraints.Builder(this.calendarConstraints);
        if (this.calendar.getCurrentMonth() != null) {
            builder.setOpenAt(this.calendar.getCurrentMonth().timeInMillis);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", builder.build());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.titleTextResId);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.titleText);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.overrideThemeResId = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.dateSelector = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.titleTextResId = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.titleText = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.inputMode = bundle.getInt("INPUT_MODE_KEY");
    }

    private int getThemeResId(Context context) {
        int i = this.overrideThemeResId;
        if (i != 0) {
            return i;
        }
        return this.dateSelector.getDefaultThemeResId(context);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId(requireContext()));
        Context context = dialog.getContext();
        this.fullscreen = isFullscreen(context);
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(context, R.attr.colorSurface, MaterialDatePicker.class.getCanonicalName());
        this.background = new MaterialShapeDrawable(context, null, R.attr.materialCalendarStyle, 2132739141);
        this.background.initializeElevationOverlay(context);
        this.background.setFillColor(ColorStateList.valueOf(resolveOrThrow));
        this.background.setElevation(cb.O0000oOO(dialog.getWindow().getDecorView()));
        return dialog;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O0000OOo(android.view.View, int):void
     arg types: [android.widget.TextView, int]
     candidates:
      _m_j.cb.O0000OOo(android.view.View, float):void
      _m_j.cb.O0000OOo(android.view.View, int):void */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.fullscreen ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.fullscreen) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(getPaddedPickerWidth(context), -1));
            findViewById2.setMinimumHeight(getDialogPickerHeight(requireContext()));
        }
        this.headerSelectionText = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        cb.O0000OOo((View) this.headerSelectionText, 1);
        this.headerToggleButton = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.titleText;
        if (charSequence != null) {
            textView.setText(charSequence);
        } else {
            textView.setText(this.titleTextResId);
        }
        initHeaderToggle(context);
        this.confirmButton = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.dateSelector.isSelectionComplete()) {
            this.confirmButton.setEnabled(true);
        } else {
            this.confirmButton.setEnabled(false);
        }
        this.confirmButton.setTag(CONFIRM_BUTTON_TAG);
        this.confirmButton.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass1 */

            public void onClick(View view) {
                Iterator<MaterialPickerOnPositiveButtonClickListener<? super S>> it = MaterialDatePicker.this.onPositiveButtonClickListeners.iterator();
                while (it.hasNext()) {
                    it.next().onPositiveButtonClick(MaterialDatePicker.this.getSelection());
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(CANCEL_BUTTON_TAG);
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass2 */

            public void onClick(View view) {
                Iterator<View.OnClickListener> it = MaterialDatePicker.this.onNegativeButtonClickListeners.iterator();
                while (it.hasNext()) {
                    it.next().onClick(view);
                }
                MaterialDatePicker.this.dismiss();
            }
        });
        return inflate;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
     arg types: [com.google.android.material.shape.MaterialShapeDrawable, int, int, int, int]
     candidates:
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.fullscreen) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.background);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.background, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new InsetDialogOnTouchListener(requireDialog(), rect));
        }
        startPickerFragment();
    }

    public final void onStop() {
        this.pickerFragment.clearOnSelectionChangedListeners();
        super.onStop();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.onCancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.onDismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final S getSelection() {
        return this.dateSelector.getSelection();
    }

    public final void updateHeader() {
        String headerText = getHeaderText();
        this.headerSelectionText.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), headerText));
        this.headerSelectionText.setText(headerText);
    }

    public final void startPickerFragment() {
        int themeResId = getThemeResId(requireContext());
        this.calendar = MaterialCalendar.newInstance(this.dateSelector, themeResId, this.calendarConstraints);
        this.pickerFragment = this.headerToggleButton.isChecked() ? MaterialTextInputPicker.newInstance(this.dateSelector, themeResId, this.calendarConstraints) : this.calendar;
        updateHeader();
        ei O000000o2 = getChildFragmentManager().O000000o();
        O000000o2.O00000Oo(R.id.mtrl_calendar_frame, this.pickerFragment, null);
        O000000o2.O00000o();
        this.pickerFragment.addOnSelectionChangedListener(new OnSelectionChangedListener<S>() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass3 */

            public void onSelectionChanged(S s) {
                MaterialDatePicker.this.updateHeader();
                MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.dateSelector.isSelectionComplete());
            }

            public void onIncompleteSelectionChanged() {
                MaterialDatePicker.this.confirmButton.setEnabled(false);
            }
        });
    }

    private void initHeaderToggle(Context context) {
        this.headerToggleButton.setTag(TOGGLE_BUTTON_TAG);
        this.headerToggleButton.setImageDrawable(createHeaderToggleDrawable(context));
        this.headerToggleButton.setChecked(this.inputMode != 0);
        cb.O000000o(this.headerToggleButton, (bh) null);
        updateToggleContentDescription(this.headerToggleButton);
        this.headerToggleButton.setOnClickListener(new View.OnClickListener() {
            /* class com.google.android.material.datepicker.MaterialDatePicker.AnonymousClass4 */

            public void onClick(View view) {
                MaterialDatePicker.this.confirmButton.setEnabled(MaterialDatePicker.this.dateSelector.isSelectionComplete());
                MaterialDatePicker.this.headerToggleButton.toggle();
                MaterialDatePicker materialDatePicker = MaterialDatePicker.this;
                materialDatePicker.updateToggleContentDescription(materialDatePicker.headerToggleButton);
                MaterialDatePicker.this.startPickerFragment();
            }
        });
    }

    public final void updateToggleContentDescription(CheckableImageButton checkableImageButton) {
        String str;
        if (this.headerToggleButton.isChecked()) {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.headerToggleButton.setContentDescription(str);
    }

    private static Drawable createHeaderToggleDrawable(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, OO0000o.O00000Oo(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], OO0000o.O00000Oo(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    static boolean isFullscreen(Context context) {
        return readMaterialCalendarStyleBoolean(context, 16843277);
    }

    static boolean isNestedScrollable(Context context) {
        return readMaterialCalendarStyleBoolean(context, R.attr.nestedScrollable);
    }

    static boolean readMaterialCalendarStyleBoolean(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    private static int getDialogPickerHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height) + (MonthAdapter.MAXIMUM_WEEKS * resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int getPaddedPickerWidth(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i = Month.current().daysInWeek;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i) + ((i - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    public final boolean addOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.add(materialPickerOnPositiveButtonClickListener);
    }

    public final boolean removeOnPositiveButtonClickListener(MaterialPickerOnPositiveButtonClickListener<? super S> materialPickerOnPositiveButtonClickListener) {
        return this.onPositiveButtonClickListeners.remove(materialPickerOnPositiveButtonClickListener);
    }

    public final void clearOnPositiveButtonClickListeners() {
        this.onPositiveButtonClickListeners.clear();
    }

    public final boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.add(onClickListener);
    }

    public final boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.onNegativeButtonClickListeners.remove(onClickListener);
    }

    public final void clearOnNegativeButtonClickListeners() {
        this.onNegativeButtonClickListeners.clear();
    }

    public final boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.add(onCancelListener);
    }

    public final boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.onCancelListeners.remove(onCancelListener);
    }

    public final void clearOnCancelListeners() {
        this.onCancelListeners.clear();
    }

    public final boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.add(onDismissListener);
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.onDismissListeners.remove(onDismissListener);
    }

    public final void clearOnDismissListeners() {
        this.onDismissListeners.clear();
    }

    public static final class Builder<S> {
        CalendarConstraints calendarConstraints;
        final DateSelector<S> dateSelector;
        int inputMode = 0;
        int overrideThemeResId = 0;
        S selection = null;
        CharSequence titleText = null;
        int titleTextResId = 0;

        private Builder(DateSelector<S> dateSelector2) {
            this.dateSelector = dateSelector2;
        }

        public static <S> Builder<S> customDatePicker(DateSelector<S> dateSelector2) {
            return new Builder<>(dateSelector2);
        }

        public static Builder<Long> datePicker() {
            return new Builder<>(new SingleDateSelector());
        }

        public static Builder<be<Long, Long>> dateRangePicker() {
            return new Builder<>(new RangeDateSelector());
        }

        public final Builder<S> setSelection(S s) {
            this.selection = s;
            return this;
        }

        public final Builder<S> setTheme(int i) {
            this.overrideThemeResId = i;
            return this;
        }

        public final Builder<S> setCalendarConstraints(CalendarConstraints calendarConstraints2) {
            this.calendarConstraints = calendarConstraints2;
            return this;
        }

        public final Builder<S> setTitleText(int i) {
            this.titleTextResId = i;
            this.titleText = null;
            return this;
        }

        public final Builder<S> setTitleText(CharSequence charSequence) {
            this.titleText = charSequence;
            this.titleTextResId = 0;
            return this;
        }

        public final Builder<S> setInputMode(int i) {
            this.inputMode = i;
            return this;
        }

        public final MaterialDatePicker<S> build() {
            if (this.calendarConstraints == null) {
                this.calendarConstraints = new CalendarConstraints.Builder().build();
            }
            if (this.titleTextResId == 0) {
                this.titleTextResId = this.dateSelector.getDefaultTitleResId();
            }
            S s = this.selection;
            if (s != null) {
                this.dateSelector.setSelection(s);
            }
            if (this.calendarConstraints.getOpenAt() == null) {
                this.calendarConstraints.setOpenAt(createDefaultOpenAt());
            }
            return MaterialDatePicker.newInstance(this);
        }

        private Month createDefaultOpenAt() {
            long j = this.calendarConstraints.getStart().timeInMillis;
            long j2 = this.calendarConstraints.getEnd().timeInMillis;
            if (!this.dateSelector.getSelectedDays().isEmpty()) {
                long longValue = this.dateSelector.getSelectedDays().iterator().next().longValue();
                if (longValue >= j && longValue <= j2) {
                    return Month.create(longValue);
                }
            }
            long thisMonthInUtcMilliseconds = MaterialDatePicker.thisMonthInUtcMilliseconds();
            if (j <= thisMonthInUtcMilliseconds && thisMonthInUtcMilliseconds <= j2) {
                j = thisMonthInUtcMilliseconds;
            }
            return Month.create(j);
        }
    }
}
