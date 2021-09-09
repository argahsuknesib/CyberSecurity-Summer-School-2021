package com.mibi.sdk.component.recharge;

import android.content.Context;
import android.content.Intent;

public interface Recharge {
    boolean available(Context context);

    String getChannel();

    Intent getEntryIntent(boolean z);

    RechargeMethodParser getParser();
}
