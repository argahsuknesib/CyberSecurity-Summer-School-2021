package _m_j;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Map;
import java.util.WeakHashMap;

public class hb extends bh {
    private final O000000o mItemDelegate;
    final RecyclerView mRecyclerView;

    public hb(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        bh itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof O000000o)) {
            this.mItemDelegate = new O000000o(this);
        } else {
            this.mItemDelegate = (O000000o) itemDelegate;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        if (super.performAccessibilityAction(view, i, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
        super.onInitializeAccessibilityNodeInfo(view, clVar);
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(clVar);
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public bh getItemDelegate() {
        return this.mItemDelegate;
    }

    public static class O000000o extends bh {

        /* renamed from: O000000o  reason: collision with root package name */
        final hb f18731O000000o;
        public Map<View, bh> O00000Oo = new WeakHashMap();

        public O000000o(hb hbVar) {
            this.f18731O000000o = hbVar;
        }

        public final bh O000000o(View view) {
            return this.O00000Oo.remove(view);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
            if (this.f18731O000000o.shouldIgnore() || this.f18731O000000o.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
                return;
            }
            this.f18731O000000o.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, clVar);
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                bhVar.onInitializeAccessibilityNodeInfo(view, clVar);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, clVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (this.f18731O000000o.shouldIgnore() || this.f18731O000000o.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i, bundle);
            }
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                if (bhVar.performAccessibilityAction(view, i, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            return this.f18731O000000o.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }

        public final void sendAccessibilityEvent(View view, int i) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                bhVar.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        }

        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                bhVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                return bhVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                bhVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                bhVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            bh bhVar = this.O00000Oo.get(viewGroup);
            if (bhVar != null) {
                return bhVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final cm getAccessibilityNodeProvider(View view) {
            bh bhVar = this.O00000Oo.get(view);
            if (bhVar != null) {
                return bhVar.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
