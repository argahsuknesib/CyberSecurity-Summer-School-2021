package com.xiaomi.smarthome.device.authorization.page;

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

public class DeviceAuthMasterListActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private DeviceAuthMasterListActivity f7081O000000o;
    private View O00000Oo;
    private View O00000o0;

    public DeviceAuthMasterListActivity_ViewBinding(final DeviceAuthMasterListActivity deviceAuthMasterListActivity, View view) {
        this.f7081O000000o = deviceAuthMasterListActivity;
        deviceAuthMasterListActivity.moduleA3ReturnTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'moduleA3ReturnTitle'", TextView.class);
        deviceAuthMasterListActivity.moduleA3ReturnMoreMoreBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_more_more_btn, "field 'moduleA3ReturnMoreMoreBtn'", ImageView.class);
        deviceAuthMasterListActivity.titleBar = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'titleBar'", FrameLayout.class);
        deviceAuthMasterListActivity.list = (PullDownDragListView) Utils.findRequiredViewAsType(view, R.id.list, "field 'list'", PullDownDragListView.class);
        deviceAuthMasterListActivity.emptyIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.empty_icon, "field 'emptyIcon'", ImageView.class);
        deviceAuthMasterListActivity.commonWhiteEmptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'commonWhiteEmptyText'", TextView.class);
        deviceAuthMasterListActivity.commonWhiteEmptyText2 = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text_2, "field 'commonWhiteEmptyText2'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'commonWhiteEmptyView' and method 'onClick'");
        deviceAuthMasterListActivity.commonWhiteEmptyView = (LinearLayout) Utils.castView(findRequiredView, R.id.common_white_empty_view, "field 'commonWhiteEmptyView'", LinearLayout.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                deviceAuthMasterListActivity.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn' and method 'onClick'");
        deviceAuthMasterListActivity.moduleA3ReturnBtn = (ImageView) Utils.castView(findRequiredView2, R.id.module_a_3_return_btn, "field 'moduleA3ReturnBtn'", ImageView.class);
        this.O00000o0 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity_ViewBinding.AnonymousClass2 */

            public final void doClick(View view) {
                deviceAuthMasterListActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        DeviceAuthMasterListActivity deviceAuthMasterListActivity = this.f7081O000000o;
        if (deviceAuthMasterListActivity != null) {
            this.f7081O000000o = null;
            deviceAuthMasterListActivity.moduleA3ReturnTitle = null;
            deviceAuthMasterListActivity.moduleA3ReturnMoreMoreBtn = null;
            deviceAuthMasterListActivity.titleBar = null;
            deviceAuthMasterListActivity.list = null;
            deviceAuthMasterListActivity.emptyIcon = null;
            deviceAuthMasterListActivity.commonWhiteEmptyText = null;
            deviceAuthMasterListActivity.commonWhiteEmptyText2 = null;
            deviceAuthMasterListActivity.commonWhiteEmptyView = null;
            deviceAuthMasterListActivity.moduleA3ReturnBtn = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            this.O00000o0.setOnClickListener(null);
            this.O00000o0 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
