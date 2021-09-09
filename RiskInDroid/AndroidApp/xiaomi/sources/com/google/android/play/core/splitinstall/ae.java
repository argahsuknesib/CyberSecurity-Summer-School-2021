package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

final class ae implements IntentSenderForResultStarter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f3798a;

    ae(Activity activity) {
        this.f3798a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f3798a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
