package android.service.controls.actions;

import android.os.Bundle;

public final class ModeAction extends ControlAction {
    private final int mNewMode;

    public final int getActionType() {
        return 4;
    }

    public ModeAction(String str, int i, String str2) {
        super(str, str2);
        this.mNewMode = i;
    }

    public ModeAction(String str, int i) {
        this(str, i, null);
    }

    ModeAction(Bundle bundle) {
        super(bundle);
        this.mNewMode = bundle.getInt("key_mode");
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putInt("key_mode", this.mNewMode);
        return dataBundle;
    }

    public final int getNewMode() {
        return this.mNewMode;
    }
}
