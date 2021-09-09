package com.mi.global.shop.widget.ptr;

import android.content.Context;
import android.util.AttributeSet;

public class PtrClassicFrameLayout extends PtrFrameLayout {
    private PtrClassicFrameHeader O0000O0o;

    public PtrClassicFrameLayout(Context context) {
        super(context);
        O00000oO();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000oO();
    }

    public PtrClassicFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000oO();
    }

    private void O00000oO() {
        this.O0000O0o = new PtrClassicFrameHeader(getContext());
        setHeaderView(this.O0000O0o);
        O000000o(this.O0000O0o);
    }

    public PtrClassicFrameHeader getHeader() {
        return this.O0000O0o;
    }

    public void setLastUpdateTimeKey(String str) {
        PtrClassicFrameHeader ptrClassicFrameHeader = this.O0000O0o;
        if (ptrClassicFrameHeader != null) {
            ptrClassicFrameHeader.setLastUpdateTimeKey(str);
        }
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        PtrClassicFrameHeader ptrClassicFrameHeader = this.O0000O0o;
        if (ptrClassicFrameHeader != null) {
            ptrClassicFrameHeader.setLastUpdateTimeRelateObject(obj);
        }
    }

    public void setLastRefreshTime(String str) {
        PtrClassicFrameHeader ptrClassicFrameHeader = this.O0000O0o;
        if (ptrClassicFrameHeader != null) {
            ptrClassicFrameHeader.setLastRefreshTime(str);
        }
    }
}
