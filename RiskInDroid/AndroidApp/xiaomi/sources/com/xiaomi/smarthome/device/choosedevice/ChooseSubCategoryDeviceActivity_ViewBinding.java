package com.xiaomi.smarthome.device.choosedevice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.ChooseDeviceNestedParent;
import com.xiaomi.smarthome.library.common.widget.FixHeightGridView;

public class ChooseSubCategoryDeviceActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private ChooseSubCategoryDeviceActivity f7248O000000o;

    public ChooseSubCategoryDeviceActivity_ViewBinding(ChooseSubCategoryDeviceActivity chooseSubCategoryDeviceActivity, View view) {
        this.f7248O000000o = chooseSubCategoryDeviceActivity;
        chooseSubCategoryDeviceActivity.mMoreBackImg = (ImageView) Utils.findRequiredViewAsType(view, R.id.more_back_img, "field 'mMoreBackImg'", ImageView.class);
        chooseSubCategoryDeviceActivity.mAddDeviceHeadTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.add_device_head_title, "field 'mAddDeviceHeadTitle'", TextView.class);
        chooseSubCategoryDeviceActivity.mSubCategoryDeviceLayout = Utils.findRequiredView(view, R.id.category_devices_page, "field 'mSubCategoryDeviceLayout'");
        chooseSubCategoryDeviceActivity.mSubCategoryScrollView = (ChooseDeviceNestedParent) Utils.findRequiredViewAsType(view, R.id.sub_category_scrollview, "field 'mSubCategoryScrollView'", ChooseDeviceNestedParent.class);
        chooseSubCategoryDeviceActivity.mSubCategoryTv = (TextView) Utils.findRequiredViewAsType(view, R.id.sub_category_name_title, "field 'mSubCategoryTv'", TextView.class);
        chooseSubCategoryDeviceActivity.mSubCatoryListView = (FixHeightGridView) Utils.findRequiredViewAsType(view, R.id.sub_device_list, "field 'mSubCatoryListView'", FixHeightGridView.class);
        chooseSubCategoryDeviceActivity.arrowUnSelected = Utils.findRequiredView(view, R.id.choose_sub_new_down, "field 'arrowUnSelected'");
        chooseSubCategoryDeviceActivity.arrowSelected = Utils.findRequiredView(view, R.id.choose_sub_new_up, "field 'arrowSelected'");
    }

    public void unbind() {
        ChooseSubCategoryDeviceActivity chooseSubCategoryDeviceActivity = this.f7248O000000o;
        if (chooseSubCategoryDeviceActivity != null) {
            this.f7248O000000o = null;
            chooseSubCategoryDeviceActivity.mMoreBackImg = null;
            chooseSubCategoryDeviceActivity.mAddDeviceHeadTitle = null;
            chooseSubCategoryDeviceActivity.mSubCategoryDeviceLayout = null;
            chooseSubCategoryDeviceActivity.mSubCategoryScrollView = null;
            chooseSubCategoryDeviceActivity.mSubCategoryTv = null;
            chooseSubCategoryDeviceActivity.mSubCatoryListView = null;
            chooseSubCategoryDeviceActivity.arrowUnSelected = null;
            chooseSubCategoryDeviceActivity.arrowSelected = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
