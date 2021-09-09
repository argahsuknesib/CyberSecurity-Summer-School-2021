package android.service.controls.actions;

import android.os.Bundle;

public final class CommandAction extends ControlAction {
    public final int getActionType() {
        return 5;
    }

    public CommandAction(String str, String str2) {
        super(str, str2);
    }

    public CommandAction(String str) {
        this(str, null);
    }

    CommandAction(Bundle bundle) {
        super(bundle);
    }
}
