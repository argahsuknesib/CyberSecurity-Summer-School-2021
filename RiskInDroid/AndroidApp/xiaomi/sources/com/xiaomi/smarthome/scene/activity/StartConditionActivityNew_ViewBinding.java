package com.xiaomi.smarthome.scene.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.ExpandableItemIndicator;

public class StartConditionActivityNew_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private StartConditionActivityNew f11109O000000o;
    private View O00000Oo;

    public StartConditionActivityNew_ViewBinding(final StartConditionActivityNew startConditionActivityNew, View view) {
        this.f11109O000000o = startConditionActivityNew;
        startConditionActivityNew.mContentListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.content_list_view, "field 'mContentListView'", RecyclerView.class);
        startConditionActivityNew.topFilterLayout = Utils.findRequiredView(view, R.id.top_filter_item, "field 'topFilterLayout'");
        startConditionActivityNew.topDeviceTitleLayout = Utils.findRequiredView(view, R.id.top_device_title_item, "field 'topDeviceTitleLayout'");
        startConditionActivityNew.mModuleA3ReturnTransparentTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.module_a_3_return_title, "field 'mModuleA3ReturnTransparentTitle'", TextView.class);
        startConditionActivityNew.mBuyView = Utils.findRequiredView(view, R.id.buy_empty_view, "field 'mBuyView'");
        startConditionActivityNew.mBuyButton = (Button) Utils.findRequiredViewAsType(view, R.id.btn_see_now, "field 'mBuyButton'", Button.class);
        startConditionActivityNew.mItemIndicator = (ExpandableItemIndicator) Utils.findRequiredViewAsType(view, R.id.btn_expand_indicator, "field 'mItemIndicator'", ExpandableItemIndicator.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.module_a_3_return_btn, "method 'close'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.StartConditionActivityNew_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                startConditionActivityNew.close();
            }
        });
    }

    public void unbind() {
        StartConditionActivityNew startConditionActivityNew = this.f11109O000000o;
        if (startConditionActivityNew != null) {
            this.f11109O000000o = null;
            startConditionActivityNew.mContentListView = null;
            startConditionActivityNew.topFilterLayout = null;
            startConditionActivityNew.topDeviceTitleLayout = null;
            startConditionActivityNew.mModuleA3ReturnTransparentTitle = null;
            startConditionActivityNew.mBuyView = null;
            startConditionActivityNew.mBuyButton = null;
            startConditionActivityNew.mItemIndicator = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
