package com.xiaomi.smarthome.uwb.mico;

import android.os.Bundle;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/uwb/mico/UwbMicoActivity$launchPlugin$1", "Lcom/xiaomi/smarthome/frame/plugin/SendMessageCallback;", "onSendSuccess", "", "result", "Landroid/os/Bundle;", "uwb-mico_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbMicoActivity$launchPlugin$1 extends SendMessageCallback {
    final /* synthetic */ UwbMicoActivity this$0;

    UwbMicoActivity$launchPlugin$1(UwbMicoActivity uwbMicoActivity) {
        this.this$0 = uwbMicoActivity;
    }

    public final void onSendSuccess(Bundle bundle) {
        this.this$0.finish();
    }
}
