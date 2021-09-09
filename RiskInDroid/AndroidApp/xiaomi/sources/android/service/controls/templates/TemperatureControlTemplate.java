package android.service.controls.templates;

import android.os.Bundle;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class TemperatureControlTemplate extends ControlTemplate {
    private static final int[] modeToFlag = {0, 2, 4, 8, 16, 32};
    private final int mCurrentActiveMode;
    private final int mCurrentMode;
    private final int mModes;
    private final ControlTemplate mTemplate;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModeFlag {
    }

    public final int getTemplateType() {
        return 7;
    }

    public TemperatureControlTemplate(String str, ControlTemplate controlTemplate, int i, int i2, int i3) {
        super(str);
        Objects.requireNonNull(controlTemplate);
        this.mTemplate = controlTemplate;
        if (i < 0 || i >= 6) {
            Log.e("ThermostatTemplate", "Invalid current mode:".concat(String.valueOf(i)));
            this.mCurrentMode = 0;
        } else {
            this.mCurrentMode = i;
        }
        if (i2 < 0 || i2 >= 6) {
            Log.e("ThermostatTemplate", "Invalid current active mode:".concat(String.valueOf(i2)));
            this.mCurrentActiveMode = 0;
        } else {
            this.mCurrentActiveMode = i2;
        }
        this.mModes = i3 & 62;
        int i4 = this.mCurrentMode;
        if (i4 == 0 || (modeToFlag[i4] & this.mModes) != 0) {
            int i5 = this.mCurrentActiveMode;
            if (i5 != 0 && (modeToFlag[i5] & this.mModes) == 0) {
                throw new IllegalArgumentException("Mode " + i2 + " not supported in flag.");
            }
            return;
        }
        throw new IllegalArgumentException("Mode " + this.mCurrentMode + " not supported in flag.");
    }

    TemperatureControlTemplate(Bundle bundle) {
        super(bundle);
        this.mTemplate = ControlTemplate.createTemplateFromBundle(bundle.getBundle("key_template"));
        this.mCurrentMode = bundle.getInt("key_current_mode");
        this.mCurrentActiveMode = bundle.getInt("key_current_active_mode");
        this.mModes = bundle.getInt("key_modes");
    }

    /* access modifiers changed from: package-private */
    public final Bundle getDataBundle() {
        Bundle dataBundle = super.getDataBundle();
        dataBundle.putBundle("key_template", this.mTemplate.getDataBundle());
        dataBundle.putInt("key_current_mode", this.mCurrentMode);
        dataBundle.putInt("key_current_active_mode", this.mCurrentActiveMode);
        dataBundle.putInt("key_modes", this.mModes);
        return dataBundle;
    }

    public final ControlTemplate getTemplate() {
        return this.mTemplate;
    }

    public final int getCurrentMode() {
        return this.mCurrentMode;
    }

    public final int getCurrentActiveMode() {
        return this.mCurrentActiveMode;
    }

    public final int getModes() {
        return this.mModes;
    }
}
