package _m_j;

import com.facebook.react.bridge.ReadableMap;
import java.util.Stack;

public class dfn extends dfs {

    /* renamed from: O000000o  reason: collision with root package name */
    final Stack<Integer> f14580O000000o = new Stack<>();
    String O00000Oo;

    public dfn(int i, ReadableMap readableMap, dev dev) {
        super(i, readableMap, dev);
    }

    public final void O000000o(Object obj) {
        dfk O000000o2 = this.mNodesManager.O000000o(this.f14580O000000o.peek().intValue(), dfk.class);
        String str = this.mUpdateContext.O00000Oo;
        this.mUpdateContext.O00000Oo = this.O00000Oo;
        ((dfs) O000000o2).O000000o(obj);
        this.mUpdateContext.O00000Oo = str;
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        String str = this.mUpdateContext.O00000Oo;
        this.mUpdateContext.O00000Oo = this.O00000Oo;
        Object value = this.mNodesManager.O000000o(this.f14580O000000o.peek().intValue(), dfk.class).value();
        this.mUpdateContext.O00000Oo = str;
        return value;
    }
}
