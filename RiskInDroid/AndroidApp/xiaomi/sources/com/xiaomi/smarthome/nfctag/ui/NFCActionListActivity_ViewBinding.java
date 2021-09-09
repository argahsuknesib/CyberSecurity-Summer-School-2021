package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class NFCActionListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCActionListActivity f10402O000000o;

    public NFCActionListActivity_ViewBinding(NFCActionListActivity nFCActionListActivity, View view) {
        this.f10402O000000o = nFCActionListActivity;
        nFCActionListActivity.mRecyclerList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerList'", RecyclerView.class);
        nFCActionListActivity.emptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'emptyView'");
        nFCActionListActivity.nfcHint = (TextView) Utils.findRequiredViewAsType(view, R.id.nfc_hint, "field 'nfcHint'", TextView.class);
    }

    public void unbind() {
        NFCActionListActivity nFCActionListActivity = this.f10402O000000o;
        if (nFCActionListActivity != null) {
            this.f10402O000000o = null;
            nFCActionListActivity.mRecyclerList = null;
            nFCActionListActivity.emptyView = null;
            nFCActionListActivity.nfcHint = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
