package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class NFCWifiListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCWifiListActivity f10467O000000o;

    public NFCWifiListActivity_ViewBinding(NFCWifiListActivity nFCWifiListActivity, View view) {
        this.f10467O000000o = nFCWifiListActivity;
        nFCWifiListActivity.mRecyclerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerList'", RecyclerView.class);
        nFCWifiListActivity.mPullRefreshLL = (PtrFrameLayout) Utils.findRequiredViewAsType(view, R.id.pull_down_refresh, "field 'mPullRefreshLL'", PtrFrameLayout.class);
    }

    public void unbind() {
        NFCWifiListActivity nFCWifiListActivity = this.f10467O000000o;
        if (nFCWifiListActivity != null) {
            this.f10467O000000o = null;
            nFCWifiListActivity.mRecyclerList = null;
            nFCWifiListActivity.mPullRefreshLL = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
