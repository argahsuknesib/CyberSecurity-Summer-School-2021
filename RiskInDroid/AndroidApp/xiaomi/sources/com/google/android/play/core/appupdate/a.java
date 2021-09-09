package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.aa;
import com.google.android.play.core.listener.b;

public final class a extends b<InstallState> {
    public a(Context context) {
        super(new aa("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    public final void a(Context context, Intent intent) {
        Intent intent2 = intent;
        if (context.getPackageName().equals(intent2.getStringExtra("package.name"))) {
            this.f3771a.a("List of extras in received intent:", new Object[0]);
            for (String next : intent.getExtras().keySet()) {
                this.f3771a.a("Key: %s; value: %s", next, intent.getExtras().get(next));
            }
            aa aaVar = this.f3771a;
            aaVar.a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
            aaVar.a("Key: %s; value: %s", "install.status", Integer.valueOf(intent2.getIntExtra("install.status", 0)));
            aaVar.a("Key: %s; value: %s", "error.code", Integer.valueOf(intent2.getIntExtra("error.code", 0)));
            InstallState a2 = InstallState.a(intent2.getIntExtra("install.status", 0), intent2.getLongExtra("bytes.downloaded", 0), intent2.getLongExtra("total.bytes.to.download", 0), intent2.getIntExtra("error.code", 0), intent2.getStringExtra("package.name"));
            this.f3771a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", a2);
            a(a2);
            return;
        }
        this.f3771a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent2.getStringExtra("package.name"));
    }
}
