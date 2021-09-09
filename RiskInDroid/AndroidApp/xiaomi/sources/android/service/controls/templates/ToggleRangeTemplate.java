package android.service.controls.templates;

import android.os.Bundle;
import java.util.Objects;

public final class ToggleRangeTemplate extends ControlTemplate {
    private final ControlButton mControlButton;
    private final RangeTemplate mRangeTemplate;

    public final int getTemplateType() {
        return 6;
    }

    ToggleRangeTemplate(Bundle bundle) {
        super(bundle);
        this.mControlButton = (ControlButton) bundle.getParcelable("key_button");
        this.mRangeTemplate = new RangeTemplate(bundle.getBundle("key_range"));
    }

    public ToggleRangeTemplate(String str, ControlButton controlButton, RangeTemplate rangeTemplate) {
        super(str);
        Objects.requireNonNull(controlButton);
        Objects.requireNonNull(rangeTemplate);
        this.mControlButton = controlButton;
        this.mRangeTemplate = rangeTemplate;
    }

    public ToggleRangeTemplate(String str, boolean z, CharSequence charSequence, RangeTemplate rangeTemplate) {
        this(str, new ControlButton(z, charSequence), rangeTemplate);
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putParcelable("key_button", this.mControlButton);
        dataBundle.putBundle("key_range", this.mRangeTemplate.getDataBundle());
        return dataBundle;
    }

    public final RangeTemplate getRange() {
        return this.mRangeTemplate;
    }

    public final boolean isChecked() {
        return this.mControlButton.isChecked();
    }

    public final CharSequence getActionDescription() {
        return this.mControlButton.getActionDescription();
    }
}
