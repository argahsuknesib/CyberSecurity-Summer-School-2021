package com.xiaomi.smarthome.newui.widget;

import _m_j.hwu;
import _m_j.hwx;
import android.content.Context;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;

public class SpanTouchFixTextView extends AppCompatTextView implements hwu {
    private boolean mIsPressedRecord;
    private boolean mNeedForceEventToParent;
    private boolean mTouchSpanHit;

    public SpanTouchFixTextView(Context context) {
        this(context, null);
    }

    public SpanTouchFixTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpanTouchFixTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPressedRecord = false;
        this.mNeedForceEventToParent = false;
        setHighlightColor(0);
    }

    public void setNeedForceEventToParent(boolean z) {
        this.mNeedForceEventToParent = z;
        setFocusable(!z);
        setClickable(!z);
        setLongClickable(!z);
    }

    public void setMovementMethodDefault() {
        setMovementMethodCompat(hwx.O000000o());
    }

    public void setMovementMethodCompat(MovementMethod movementMethod) {
        setMovementMethod(movementMethod);
        if (this.mNeedForceEventToParent) {
            setNeedForceEventToParent(true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getText() instanceof Spannable) || !(getMovementMethod() instanceof hwx)) {
            this.mTouchSpanHit = false;
            return super.onTouchEvent(motionEvent);
        }
        this.mTouchSpanHit = true;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.mNeedForceEventToParent) {
            return this.mTouchSpanHit;
        }
        return onTouchEvent;
    }

    public void setTouchSpanHit(boolean z) {
        if (this.mTouchSpanHit != z) {
            this.mTouchSpanHit = z;
            setPressed(this.mIsPressedRecord);
        }
    }

    public boolean performClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performClick();
    }

    public boolean performLongClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performLongClick();
    }

    public final void setPressed(boolean z) {
        this.mIsPressedRecord = z;
        if (!this.mTouchSpanHit) {
            onSetPressed(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onSetPressed(boolean z) {
        super.setPressed(z);
    }
}
