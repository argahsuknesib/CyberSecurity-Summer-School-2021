package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;

final class aa implements b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SplitInstallSessionState f3795a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ ac d;

    aa(ac acVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = acVar;
        this.f3795a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    public final void a() {
        this.d.d.post(new ab(this.d, this.f3795a, 5, 0));
    }

    public final void a(@SplitInstallErrorCode int i) {
        this.d.d.post(new ab(this.d, this.f3795a, 6, i));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void b() {
        if (!this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
            return;
        }
        this.d.f3771a.b("Splits copied and verified more than once.", new Object[0]);
    }
}
