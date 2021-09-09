package com.xiaomi.smarthome.smartconfig.step;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.widget.FlowGroup;

public class SuccessStep_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private SuccessStep f11830O000000o;

    public SuccessStep_ViewBinding(SuccessStep successStep, View view) {
        this.f11830O000000o = successStep;
        successStep.mIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.smart_config_common_icon, "field 'mIcon'", ImageView.class);
        successStep.mNextButton = (Button) Utils.findRequiredViewAsType(view, R.id.next_btn, "field 'mNextButton'", Button.class);
        successStep.mCheckBox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.check_box_create_launcher, "field 'mCheckBox'", CheckBox.class);
        successStep.mFlowGroup = (FlowGroup) Utils.findRequiredViewAsType(view, R.id.smart_config_tag_choose, "field 'mFlowGroup'", FlowGroup.class);
        successStep.mScrollView = (ScrollView) Utils.findRequiredViewAsType(view, R.id.smart_config_scroll_view, "field 'mScrollView'", ScrollView.class);
        successStep.mChooseContainer = Utils.findRequiredView(view, R.id.choose_container, "field 'mChooseContainer'");
        successStep.mLeftRightBtn = Utils.findRequiredView(view, R.id.next_left_right_button, "field 'mLeftRightBtn'");
        successStep.mLeftBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.left_btn, "field 'mLeftBtn'", TextView.class);
        successStep.mRightBtn = (TextView) Utils.findRequiredViewAsType(view, R.id.right_btn, "field 'mRightBtn'", TextView.class);
    }

    public void unbind() {
        SuccessStep successStep = this.f11830O000000o;
        if (successStep != null) {
            this.f11830O000000o = null;
            successStep.mIcon = null;
            successStep.mNextButton = null;
            successStep.mCheckBox = null;
            successStep.mFlowGroup = null;
            successStep.mScrollView = null;
            successStep.mChooseContainer = null;
            successStep.mLeftRightBtn = null;
            successStep.mLeftBtn = null;
            successStep.mRightBtn = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
