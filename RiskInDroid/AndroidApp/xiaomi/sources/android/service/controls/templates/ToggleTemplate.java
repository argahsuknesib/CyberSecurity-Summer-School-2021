package android.service.controls.templates;

import android.os.Bundle;
import java.util.Objects;

public final class ToggleTemplate extends ControlTemplate {
    private final ControlButton mButton;

    public final int getTemplateType() {
        return 1;
    }

    public ToggleTemplate(String str, ControlButton controlButton) {
        super(str);
        Objects.requireNonNull(controlButton);
        this.mButton = controlButton;
    }

    ToggleTemplate(Bundle bundle) {
        super(bundle);
        this.mButton = (ControlButton) bundle.getParcelable("key_button");
    }

    public final boolean isChecked() {
        return this.mButton.isChecked();
    }

    public final CharSequence getContentDescription() {
        return this.mButton.getActionDescription();
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putParcelable("key_button", this.mButton);
        return dataBundle;
    }
}
