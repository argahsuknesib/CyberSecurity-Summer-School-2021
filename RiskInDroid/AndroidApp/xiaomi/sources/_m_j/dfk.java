package _m_j;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public abstract class dfk {
    public static final Double ONE = Double.valueOf(1.0d);
    public static final Double ZERO = Double.valueOf(0.0d);
    private List<dfk> mChildren;
    private final Map<String, Long> mLastLoopID = new HashMap();
    private final Map<String, Object> mMemoizedValue = new HashMap();
    protected final int mNodeID;
    protected final dev mNodesManager;
    protected final dew mUpdateContext;

    /* access modifiers changed from: protected */
    public abstract Object evaluate();

    public dfk(int i, ReadableMap readableMap, dev dev) {
        this.mLastLoopID.put("", -1L);
        this.mNodeID = i;
        this.mNodesManager = dev;
        this.mUpdateContext = dev.O0000o00;
    }

    public final Object value() {
        if (this.mLastLoopID.containsKey(this.mUpdateContext.O00000Oo) && this.mLastLoopID.get(this.mUpdateContext.O00000Oo).longValue() >= this.mUpdateContext.f14566O000000o) {
            return this.mMemoizedValue.get(this.mUpdateContext.O00000Oo);
        }
        this.mLastLoopID.put(this.mUpdateContext.O00000Oo, Long.valueOf(this.mUpdateContext.f14566O000000o));
        Object evaluate = evaluate();
        this.mMemoizedValue.put(this.mUpdateContext.O00000Oo, evaluate);
        return evaluate;
    }

    public final Double doubleValue() {
        Object value = value();
        if (value == null) {
            return ZERO;
        }
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return Double.valueOf(((Number) value).doubleValue());
        }
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue() ? ONE : ZERO;
        }
        throw new IllegalStateException("Value of node " + this + " cannot be cast to a number");
    }

    public void addChild(dfk dfk) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        this.mChildren.add(dfk);
        dfk.dangerouslyRescheduleEvaluate();
    }

    public void removeChild(dfk dfk) {
        List<dfk> list = this.mChildren;
        if (list != null) {
            list.remove(dfk);
        }
    }

    /* access modifiers changed from: protected */
    public void markUpdated() {
        UiThreadUtil.assertOnUiThread();
        this.mUpdateContext.O00000o0.add(this);
        dev dev = this.mNodesManager;
        dev.O0000OoO = true;
        dev.O000000o();
    }

    /* access modifiers changed from: protected */
    public final void dangerouslyRescheduleEvaluate() {
        this.mLastLoopID.put(this.mUpdateContext.O00000Oo, -1L);
        markUpdated();
    }

    /* access modifiers changed from: protected */
    public final void forceUpdateMemoizedValue(Object obj) {
        this.mMemoizedValue.put(this.mUpdateContext.O00000Oo, obj);
        markUpdated();
    }

    private static void findAndUpdateNodes(dfk dfk, Set<dfk> set, Stack<dfh> stack) {
        if (!set.contains(dfk)) {
            set.add(dfk);
            List<dfk> list = dfk.mChildren;
            if (list != null) {
                for (dfk findAndUpdateNodes : list) {
                    findAndUpdateNodes(findAndUpdateNodes, set, stack);
                }
            }
            if (dfk instanceof dfh) {
                stack.push((dfh) dfk);
            }
        }
    }

    public static void runUpdates(dew dew) {
        UiThreadUtil.assertOnUiThread();
        ArrayList<dfk> arrayList = dew.O00000o0;
        HashSet hashSet = new HashSet();
        Stack stack = new Stack();
        for (int i = 0; i < arrayList.size(); i++) {
            findAndUpdateNodes(arrayList.get(i), hashSet, stack);
            if (i == arrayList.size() - 1) {
                while (!stack.isEmpty()) {
                    ((dfh) stack.pop()).O000000o();
                }
            }
        }
        arrayList.clear();
        dew.f14566O000000o++;
    }
}
