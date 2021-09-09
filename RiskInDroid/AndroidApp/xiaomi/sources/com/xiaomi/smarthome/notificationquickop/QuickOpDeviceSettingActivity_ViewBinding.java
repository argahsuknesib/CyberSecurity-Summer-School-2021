package com.xiaomi.smarthome.notificationquickop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class QuickOpDeviceSettingActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private QuickOpDeviceSettingActivity f10493O000000o;
    private View O00000Oo;

    public QuickOpDeviceSettingActivity_ViewBinding(final QuickOpDeviceSettingActivity quickOpDeviceSettingActivity, View view) {
        this.f10493O000000o = quickOpDeviceSettingActivity;
        quickOpDeviceSettingActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
        quickOpDeviceSettingActivity.emptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'emptyView'");
        quickOpDeviceSettingActivity.emptyText = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'emptyText'", TextView.class);
        quickOpDeviceSettingActivity.emptyDevideLine = Utils.findRequiredView(view, R.id.empty_devide_line, "field 'emptyDevideLine'");
        quickOpDeviceSettingActivity.topBar = Utils.findRequiredView(view, R.id.title_bar, "field 'topBar'");
        quickOpDeviceSettingActivity.tittle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'tittle'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "field 'backBtn' and method 'onClick'");
        quickOpDeviceSettingActivity.backBtn = (ImageView) Utils.castView(findRequiredView, R.id.module_a_3_return_btn, "field 'backBtn'", ImageView.class);
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                quickOpDeviceSettingActivity.onClick(view);
            }
        });
        quickOpDeviceSettingActivity.switchBtn = (SwitchButton) Utils.findRequiredViewAsType(view, R.id.switch_setting, "field 'switchBtn'", SwitchButton.class);
        quickOpDeviceSettingActivity.switchView = Utils.findRequiredView(view, R.id.switch_setting_view, "field 'switchView'");
        quickOpDeviceSettingActivity.mTopPanel = Utils.findRequiredView(view, R.id.top_panel, "field 'mTopPanel'");
        quickOpDeviceSettingActivity.mTopSpace = Utils.findRequiredView(view, R.id.top_space, "field 'mTopSpace'");
        quickOpDeviceSettingActivity.mResultView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.recycler_view_result, "field 'mResultView'", RecyclerView.class);
        quickOpDeviceSettingActivity.animBody = Utils.findRequiredView(view, R.id.anim_body, "field 'animBody'");
        quickOpDeviceSettingActivity.mSelectTip = Utils.findRequiredView(view, R.id.select_tip, "field 'mSelectTip'");
    }

    public void unbind() {
        QuickOpDeviceSettingActivity quickOpDeviceSettingActivity = this.f10493O000000o;
        if (quickOpDeviceSettingActivity != null) {
            this.f10493O000000o = null;
            quickOpDeviceSettingActivity.mRecyclerView = null;
            quickOpDeviceSettingActivity.emptyView = null;
            quickOpDeviceSettingActivity.emptyText = null;
            quickOpDeviceSettingActivity.emptyDevideLine = null;
            quickOpDeviceSettingActivity.topBar = null;
            quickOpDeviceSettingActivity.tittle = null;
            quickOpDeviceSettingActivity.backBtn = null;
            quickOpDeviceSettingActivity.switchBtn = null;
            quickOpDeviceSettingActivity.switchView = null;
            quickOpDeviceSettingActivity.mTopPanel = null;
            quickOpDeviceSettingActivity.mTopSpace = null;
            quickOpDeviceSettingActivity.mResultView = null;
            quickOpDeviceSettingActivity.animBody = null;
            quickOpDeviceSettingActivity.mSelectTip = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
