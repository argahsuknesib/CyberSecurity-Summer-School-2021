package com.xiaomi.smarthome.miio.page.deviceophistory;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.PullDownDragListView;

public class DeviceOpHistoryListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceOpHistoryListActivity f9902O000000o;
    private View O00000Oo;
    private View O00000o0;

    public DeviceOpHistoryListActivity_ViewBinding(final DeviceOpHistoryListActivity deviceOpHistoryListActivity, View view) {
        this.f9902O000000o = deviceOpHistoryListActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn' and method 'onClick'");
        deviceOpHistoryListActivity.moduleA3ReturnBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                deviceOpHistoryListActivity.onClick(view);
            }
        });
        deviceOpHistoryListActivity.moduleA3ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'moduleA3ReturnTitle'", TextView.class);
        deviceOpHistoryListActivity.moduleA3ReturnMoreMoreBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_more_more_btn, "field 'moduleA3ReturnMoreMoreBtn'", ImageView.class);
        deviceOpHistoryListActivity.titleBar = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'titleBar'", FrameLayout.class);
        deviceOpHistoryListActivity.list = (PullDownDragListView) Utils.findRequiredViewAsType(view, R.id.list, "field 'list'", PullDownDragListView.class);
        deviceOpHistoryListActivity.emptyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.empty_icon, "field 'emptyIcon'", ImageView.class);
        deviceOpHistoryListActivity.commonWhiteEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'commonWhiteEmptyText'", TextView.class);
        deviceOpHistoryListActivity.commonWhiteEmptyText2 = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text_2, "field 'commonWhiteEmptyText2'", TextView.class);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'commonWhiteEmptyView' and method 'onClick'");
        deviceOpHistoryListActivity.commonWhiteEmptyView = (LinearLayout) Utils.castView(findRequiredView2, R.id.common_white_empty_view, "field 'commonWhiteEmptyView'", LinearLayout.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                deviceOpHistoryListActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        DeviceOpHistoryListActivity deviceOpHistoryListActivity = this.f9902O000000o;
        if (deviceOpHistoryListActivity != null) {
            this.f9902O000000o = null;
            deviceOpHistoryListActivity.moduleA3ReturnBtn = null;
            deviceOpHistoryListActivity.moduleA3ReturnTitle = null;
            deviceOpHistoryListActivity.moduleA3ReturnMoreMoreBtn = null;
            deviceOpHistoryListActivity.titleBar = null;
            deviceOpHistoryListActivity.list = null;
            deviceOpHistoryListActivity.emptyIcon = null;
            deviceOpHistoryListActivity.commonWhiteEmptyText = null;
            deviceOpHistoryListActivity.commonWhiteEmptyText2 = null;
            deviceOpHistoryListActivity.commonWhiteEmptyView = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
