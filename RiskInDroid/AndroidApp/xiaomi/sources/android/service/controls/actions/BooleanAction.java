package android.service.controls.actions;

import android.os.Bundle;

public final class BooleanAction extends ControlAction {
    private final boolean mNewState;

    public final int getActionType() {
        return 1;
    }

    public BooleanAction(String str, boolean z) {
        this(str, z, null);
    }

    public BooleanAction(String str, boolean z, String str2) {
        super(str, str2);
        this.mNewState = z;
    }

    BooleanAction(Bundle bundle) {
        super(bundle);
        this.mNewState = bundle.getBoolean("key_new_state");
    }

    public final boolean getNewState() {
        return this.mNewState;
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putBoolean("key_new_state", this.mNewState);
        return dataBundle;
    }
}
