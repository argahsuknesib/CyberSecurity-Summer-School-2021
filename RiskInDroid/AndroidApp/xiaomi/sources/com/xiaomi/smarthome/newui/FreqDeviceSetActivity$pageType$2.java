package com.xiaomi.smarthome.newui;

import _m_j.iwb;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class FreqDeviceSetActivity$pageType$2 extends Lambda implements iwb<Integer> {
    final /* synthetic */ FreqDeviceSetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FreqDeviceSetActivity$pageType$2(FreqDeviceSetActivity freqDeviceSetActivity) {
        super(0);
        this.this$0 = freqDeviceSetActivity;
    }

    public final /* synthetic */ Object invoke() {
        Intent intent = this.this$0.getIntent();
        int i = 1;
        if (intent != null) {
            i = intent.getIntExtra("pagetype", 1);
        }
        return Integer.valueOf(i);
    }
}
