package android.service.controls.templates;

import android.os.Bundle;

public final class StatelessTemplate extends ControlTemplate {
    public final int getTemplateType() {
        return 8;
    }

    StatelessTemplate(Bundle bundle) {
        super(bundle);
    }

    public StatelessTemplate(String str) {
        super(str);
    }
}
