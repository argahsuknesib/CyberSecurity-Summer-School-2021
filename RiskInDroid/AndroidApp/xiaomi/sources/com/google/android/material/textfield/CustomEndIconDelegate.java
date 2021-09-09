package com.google.android.material.textfield;

class CustomEndIconDelegate extends EndIconDelegate {
    CustomEndIconDelegate(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    /* access modifiers changed from: package-private */
    public void initialize() {
        this.textInputLayout.setEndIconOnClickListener(null);
        this.textInputLayout.setEndIconOnLongClickListener(null);
    }
}
