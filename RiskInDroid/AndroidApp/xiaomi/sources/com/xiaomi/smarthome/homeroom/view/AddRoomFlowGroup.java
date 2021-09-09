package com.xiaomi.smarthome.homeroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.library.common.widget.FlowGroupV2;

public class AddRoomFlowGroup extends FlowGroupV2 {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f8991O000000o;
    private String O00000oo;
    private int O0000O0o;

    public interface O000000o {
    }

    public AddRoomFlowGroup(Context context) {
        super(context);
    }

    public AddRoomFlowGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddRoomFlowGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getCurrentSelectType() {
        return this.O0000O0o;
    }

    public String getCurrentSelectValue() {
        return this.O00000oo;
    }

    public Object getSelected() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && childAt.isSelected()) {
                return childAt.getTag();
            }
        }
        return null;
    }

    public void setOnTagClickListener(O000000o o000000o) {
        this.f8991O000000o = o000000o;
    }
}
