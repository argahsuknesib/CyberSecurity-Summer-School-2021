package com.xiaomi.mico.api.exception;

import android.content.Intent;

public class NeedUserInteractionException extends Exception {
    private static final long serialVersionUID = 4951225316343246487L;
    private Intent mIntent;

    public NeedUserInteractionException(Intent intent) {
        super("User Interaction Needed.");
        this.mIntent = intent;
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}
