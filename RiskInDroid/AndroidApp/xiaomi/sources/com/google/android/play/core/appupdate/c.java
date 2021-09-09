package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

final class c implements IntentSenderForResultStarter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f3611a;

    c(Activity activity) {
        this.f3611a = activity;
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        this.f3611a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
