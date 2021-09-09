package com.xiaomi.smarthome.nfctag.idmimpl;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.idm.tap.dispatcher.impl.AbstractActionExecutor;
import com.xiaomi.smarthome.nfctag.ui.NFCEmptyguideActivity;

public class MijiaEmptyNfcTagExecutor extends AbstractActionExecutor {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f10383O000000o;

    public MijiaEmptyNfcTagExecutor(Context context) {
        this.f10383O000000o = context;
    }

    public boolean execute() {
        Context context = this.f10383O000000o;
        if (context == null) {
            return false;
        }
        this.f10383O000000o.startActivity(new Intent(context, NFCEmptyguideActivity.class));
        return true;
    }
}
