package android.service.controls.templates;

import android.os.Bundle;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public abstract class ControlTemplate {
    private static final ControlTemplate ERROR_TEMPLATE = new ControlTemplate("") {
        /* class android.service.controls.templates.ControlTemplate.AnonymousClass2 */

        public final int getTemplateType() {
            return -1;
        }
    };
    public static final ControlTemplate NO_TEMPLATE = new ControlTemplate("") {
        /* class android.service.controls.templates.ControlTemplate.AnonymousClass1 */

        public final int getTemplateType() {
            return 0;
        }
    };
    protected final String mTemplateId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TemplateType {
    }

    public abstract int getTemplateType();

    public String getTemplateId() {
        return this.mTemplateId;
    }

    /* access modifiers changed from: package-private */
    public Bundle getDataBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("key_template_type", getTemplateType());
        bundle.putString("key_template_id", this.mTemplateId);
        return bundle;
    }

    private ControlTemplate() {
        this.mTemplateId = "";
    }

    ControlTemplate(Bundle bundle) {
        this.mTemplateId = bundle.getString("key_template_id");
    }

    ControlTemplate(String str) {
        Objects.requireNonNull(str);
        this.mTemplateId = str;
    }

    static ControlTemplate createTemplateFromBundle(Bundle bundle) {
        if (bundle == null) {
            Log.e("ControlTemplate", "Null bundle");
            return ERROR_TEMPLATE;
        }
        bundle.setClassLoader(ControlTemplate.class.getClassLoader());
        int i = bundle.getInt("key_template_type", -1);
        if (i == 0) {
            return NO_TEMPLATE;
        }
        if (i == 1) {
            return new ToggleTemplate(bundle);
        }
        if (i == 2) {
            return new RangeTemplate(bundle);
        }
        if (i == 6) {
            return new ToggleRangeTemplate(bundle);
        }
        if (i == 7) {
            return new TemperatureControlTemplate(bundle);
        }
        if (i == 8) {
            return new StatelessTemplate(bundle);
        }
        try {
            return ERROR_TEMPLATE;
        } catch (Exception e) {
            Log.e("ControlTemplate", "Error creating template", e);
            return ERROR_TEMPLATE;
        }
    }

    public static ControlTemplate getErrorTemplate() {
        return ERROR_TEMPLATE;
    }

    public static ControlTemplate getNoTemplateObject() {
        return NO_TEMPLATE;
    }
}
