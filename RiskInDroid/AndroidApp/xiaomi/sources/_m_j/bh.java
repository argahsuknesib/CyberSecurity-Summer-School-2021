package _m_j;

import _m_j.cl;
import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.xiaomi.smarthome.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bh {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    static final class O000000o extends View.AccessibilityDelegate {

        /* renamed from: O000000o  reason: collision with root package name */
        final bh f12965O000000o;

        O000000o(bh bhVar) {
            this.f12965O000000o = bhVar;
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f12965O000000o.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f12965O000000o.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            View view2 = view;
            cl O000000o2 = cl.O000000o(accessibilityNodeInfo);
            boolean O000OOo0 = cb.O000OOo0(view);
            if (Build.VERSION.SDK_INT >= 28) {
                O000000o2.f13980O000000o.setScreenReaderFocusable(O000OOo0);
            } else {
                O000000o2.O000000o(1, O000OOo0);
            }
            boolean O000OOoO = cb.O000OOoO(view);
            if (Build.VERSION.SDK_INT >= 28) {
                O000000o2.f13980O000000o.setHeading(O000OOoO);
            } else {
                O000000o2.O000000o(2, O000OOoO);
            }
            CharSequence O000OOo = cb.O000OOo(view);
            if (Build.VERSION.SDK_INT >= 28) {
                O000000o2.f13980O000000o.setPaneTitle(O000OOo);
            } else if (Build.VERSION.SDK_INT >= 19) {
                O000000o2.f13980O000000o.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", O000OOo);
            }
            this.f12965O000000o.onInitializeAccessibilityNodeInfo(view2, O000000o2);
            CharSequence text = accessibilityNodeInfo.getText();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
                if (Build.VERSION.SDK_INT >= 19) {
                    O000000o2.f13980O000000o.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                    O000000o2.f13980O000000o.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                    O000000o2.f13980O000000o.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                    O000000o2.f13980O000000o.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                }
                SparseArray<WeakReference<ClickableSpan>> O00000oO = cl.O00000oO(view);
                if (O00000oO != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < O00000oO.size(); i++) {
                        if (O00000oO.valueAt(i).get() == null) {
                            arrayList.add(Integer.valueOf(i));
                        }
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        O00000oO.remove(((Integer) arrayList.get(i2)).intValue());
                    }
                }
                ClickableSpan[] O00000o = cl.O00000o(text);
                if (O00000o != null && O00000o.length > 0) {
                    O000000o2.O00000oO().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
                    SparseArray<WeakReference<ClickableSpan>> O00000oO2 = cl.O00000oO(view);
                    if (O00000oO2 == null) {
                        O00000oO2 = new SparseArray<>();
                        view2.setTag(R.id.tag_accessibility_clickable_spans, O00000oO2);
                    }
                    int i3 = 0;
                    while (O00000o != null && i3 < O00000o.length) {
                        int O000000o3 = cl.O000000o(O00000o[i3], O00000oO2);
                        O00000oO2.put(O000000o3, new WeakReference(O00000o[i3]));
                        ClickableSpan clickableSpan = O00000o[i3];
                        Spanned spanned = (Spanned) text;
                        O000000o2.O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
                        O000000o2.O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
                        O000000o2.O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
                        O000000o2.O000000o("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(O000000o3));
                        i3++;
                    }
                }
            }
            List<cl.O000000o> actionList = bh.getActionList(view);
            for (int i4 = 0; i4 < actionList.size(); i4++) {
                O000000o2.O000000o(actionList.get(i4));
            }
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f12965O000000o.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f12965O000000o.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final void sendAccessibilityEvent(View view, int i) {
            this.f12965O000000o.sendAccessibilityEvent(view, i);
        }

        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f12965O000000o.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            cm accessibilityNodeProvider = this.f12965O000000o.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.f14116O000000o;
            }
            return null;
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f12965O000000o.performAccessibilityAction(view, i, bundle);
        }
    }

    public bh() {
        this(DEFAULT_DELEGATE);
    }

    public bh(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new O000000o(this);
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, clVar.f13980O000000o);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public cm getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new cm(accessibilityNodeProvider);
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        List<cl.O000000o> actionList = getActionList(view);
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= actionList.size()) {
                break;
            }
            cl.O000000o o000000o = actionList.get(i2);
            if (o000000o.O000000o() == i) {
                z = o000000o.O000000o(view, bundle);
                break;
            }
            i2++;
        }
        if (!z && Build.VERSION.SDK_INT >= 16) {
            z = this.mOriginalDelegate.performAccessibilityAction(view, i, bundle);
        }
        return (z || i != R.id.accessibility_action_clickable_span) ? z : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean performClickableSpanAction(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] O00000o = cl.O00000o(view.createAccessibilityNodeInfo().getText());
            int i = 0;
            while (O00000o != null && i < O00000o.length) {
                if (clickableSpan.equals(O00000o[i])) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    static List<cl.O000000o> getActionList(View view) {
        List<cl.O000000o> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
