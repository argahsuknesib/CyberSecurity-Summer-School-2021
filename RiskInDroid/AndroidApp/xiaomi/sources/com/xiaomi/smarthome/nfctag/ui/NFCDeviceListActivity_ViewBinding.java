package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class NFCDeviceListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCDeviceListActivity f10421O000000o;

    public NFCDeviceListActivity_ViewBinding(NFCDeviceListActivity nFCDeviceListActivity, View view) {
        this.f10421O000000o = nFCDeviceListActivity;
        nFCDeviceListActivity.mRecyclerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerList'", RecyclerView.class);
        nFCDeviceListActivity.txt_hint = (TextView) Utils.findRequiredViewAsType(view, R.id.txt_hint, "field 'txt_hint'", TextView.class);
    }

    public void unbind() {
        NFCDeviceListActivity nFCDeviceListActivity = this.f10421O000000o;
        if (nFCDeviceListActivity != null) {
            this.f10421O000000o = null;
            nFCDeviceListActivity.mRecyclerList = null;
            nFCDeviceListActivity.txt_hint = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
