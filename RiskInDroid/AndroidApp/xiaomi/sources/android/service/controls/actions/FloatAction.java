package android.service.controls.actions;

import android.os.Bundle;

public final class FloatAction extends ControlAction {
    private final float mNewValue;

    public final int getActionType() {
        return 2;
    }

    public FloatAction(String str, float f) {
        this(str, f, null);
    }

    public FloatAction(String str, float f, String str2) {
        super(str, str2);
        this.mNewValue = f;
    }

    FloatAction(Bundle bundle) {
        super(bundle);
        this.mNewValue = bundle.getFloat("key_new_value");
    }

    public final float getNewValue() {
        return this.mNewValue;
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putFloat("key_new_value", this.mNewValue);
        return dataBundle;
    }
}
