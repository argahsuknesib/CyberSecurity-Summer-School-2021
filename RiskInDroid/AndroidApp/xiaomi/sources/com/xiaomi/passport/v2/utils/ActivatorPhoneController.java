package com.xiaomi.passport.v2.utils;

import android.content.Context;
import com.xiaomi.phonenum.PhoneNumKeeper;
import com.xiaomi.phonenum.PhoneNumKeeperFactory;

public class ActivatorPhoneController {

    /* renamed from: O000000o  reason: collision with root package name */
    PhoneNumKeeper f6350O000000o;

    public ActivatorPhoneController(Context context) {
        this.f6350O000000o = new PhoneNumKeeperFactory().createPhoneNumKeeper(context, "2882303761517565051");
        this.f6350O000000o.setUp(new PhoneNumKeeper.SetupFinishedListener() {
            /* class com.xiaomi.passport.v2.utils.ActivatorPhoneController.AnonymousClass1 */
        });
    }

    public final void O000000o(int i) {
        this.f6350O000000o.invalidatePhoneNum(i);
    }
}
