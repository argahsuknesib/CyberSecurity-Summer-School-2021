package android.service.controls.actions;

import android.os.Bundle;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public abstract class ControlAction {
    public static final ControlAction ERROR_ACTION = new ControlAction() {
        /* class android.service.controls.actions.ControlAction.AnonymousClass1 */

        public final int getActionType() {
            return -1;
        }
    };
    private final String mChallengeValue;
    private final String mTemplateId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResponseResult {
    }

    public static final boolean isValidResponse(int i) {
        return i >= 0 && i < 6;
    }

    public abstract int getActionType();

    private ControlAction() {
        this.mTemplateId = "";
        this.mChallengeValue = null;
    }

    ControlAction(String str, String str2) {
        Objects.requireNonNull(str);
        this.mTemplateId = str;
        this.mChallengeValue = str2;
    }

    ControlAction(Bundle bundle) {
        this.mTemplateId = bundle.getString("key_template_id");
        this.mChallengeValue = bundle.getString("key_challenge_value");
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public String getChallengeValue() {
        return this.mChallengeValue;
    }

    /* access modifiers changed from: package-private */
    public Bundle getDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_action_type", getActionType());
        bundle.putString("key_template_id", this.mTemplateId);
        bundle.putString("key_challenge_value", this.mChallengeValue);
        return bundle;
    }

    static ControlAction createActionFromBundle(Bundle bundle) {
        if (bundle == null) {
            Log.e("ControlAction", "Null bundle");
            return ERROR_ACTION;
        }
        int i = bundle.getInt("key_action_type", -1);
        if (i == 1) {
            return new BooleanAction(bundle);
        }
        if (i == 2) {
            return new FloatAction(bundle);
        }
        if (i == 4) {
            return new ModeAction(bundle);
        }
        if (i == 5) {
            return new CommandAction(bundle);
        }
        try {
            return ERROR_ACTION;
        } catch (Exception e) {
            Log.e("ControlAction", "Error creating action", e);
            return ERROR_ACTION;
        }
    }

    public static ControlAction getErrorAction() {
        return ERROR_ACTION;
    }
}
