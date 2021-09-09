package net.qiujuer.genius.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class SeekBar extends AbsSeekBar {
    private O000000o O0000O0o;

    public interface O000000o {
    }

    public SeekBar(Context context) {
        super(context);
    }

    public SeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnSeekBarChangeListener(O000000o o000000o) {
        this.O0000O0o = o000000o;
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        super.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        super.O00000Oo();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SeekBar.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SeekBar.class.getName());
    }
}
