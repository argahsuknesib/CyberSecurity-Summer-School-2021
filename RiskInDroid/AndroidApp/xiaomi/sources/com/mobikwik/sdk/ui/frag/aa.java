package com.mobikwik.sdk.ui.frag;

import android.view.MotionEvent;
import android.view.View;

class aa implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ y f5302a;

    aa(y yVar) {
        this.f5302a = yVar;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.mobikwik.sdk.ui.frag.y.a(com.mobikwik.sdk.ui.frag.y, boolean):void
     arg types: [com.mobikwik.sdk.ui.frag.y, int]
     candidates:
      com.mobikwik.sdk.ui.frag.y.a(com.mobikwik.sdk.ui.frag.y, int):int
      com.mobikwik.sdk.ui.frag.y.a(com.mobikwik.sdk.ui.frag.y, java.lang.String):java.lang.String
      com.mobikwik.sdk.ui.frag.y.a(boolean, java.lang.String):void
      com.mobikwik.sdk.ui.frag.y.a(com.mobikwik.sdk.ui.frag.y, boolean):void */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f5302a.h.isChecked() || this.f5302a.i != 1) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            this.f5302a.c(false);
        }
        return true;
    }
}
