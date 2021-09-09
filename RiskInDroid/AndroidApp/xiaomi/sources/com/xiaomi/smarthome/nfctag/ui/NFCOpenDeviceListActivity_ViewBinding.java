package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class NFCOpenDeviceListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCOpenDeviceListActivity f10451O000000o;
    private View O00000Oo;

    public NFCOpenDeviceListActivity_ViewBinding(final NFCOpenDeviceListActivity nFCOpenDeviceListActivity, View view) {
        this.f10451O000000o = nFCOpenDeviceListActivity;
        nFCOpenDeviceListActivity.mModuleA3ReturnTransparentTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mModuleA3ReturnTransparentTitle'", TextView.class);
        nFCOpenDeviceListActivity.mContentListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.content_list_view, "field 'mContentListView'", RecyclerView.class);
        nFCOpenDeviceListActivity.topFilterLayout = Utils.findRequiredView(view, R.id.top_filter_item, "field 'topFilterLayout'");
        nFCOpenDeviceListActivity.topDeviceTitleLayout = Utils.findRequiredView(view, R.id.top_device_title_item, "field 'topDeviceTitleLayout'");
        nFCOpenDeviceListActivity.mEmptyView = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.common_white_empty_view, "field 'mEmptyView'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'close'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCOpenDeviceListActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                nFCOpenDeviceListActivity.close();
            }
        });
    }

    public void unbind() {
        NFCOpenDeviceListActivity nFCOpenDeviceListActivity = this.f10451O000000o;
        if (nFCOpenDeviceListActivity != null) {
            this.f10451O000000o = null;
            nFCOpenDeviceListActivity.mModuleA3ReturnTransparentTitle = null;
            nFCOpenDeviceListActivity.mContentListView = null;
            nFCOpenDeviceListActivity.topFilterLayout = null;
            nFCOpenDeviceListActivity.topDeviceTitleLayout = null;
            nFCOpenDeviceListActivity.mEmptyView = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
