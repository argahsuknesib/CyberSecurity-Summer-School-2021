package com.facebook.react.views.scroll;

public enum ScrollEventType {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;

    /* renamed from: com.facebook.react.views.scroll.ScrollEventType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$scroll$ScrollEventType = new int[ScrollEventType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$com$facebook$react$views$scroll$ScrollEventType[ScrollEventType.BEGIN_DRAG.ordinal()] = 1;
            $SwitchMap$com$facebook$react$views$scroll$ScrollEventType[ScrollEventType.END_DRAG.ordinal()] = 2;
            $SwitchMap$com$facebook$react$views$scroll$ScrollEventType[ScrollEventType.SCROLL.ordinal()] = 3;
            $SwitchMap$com$facebook$react$views$scroll$ScrollEventType[ScrollEventType.MOMENTUM_BEGIN.ordinal()] = 4;
            $SwitchMap$com$facebook$react$views$scroll$ScrollEventType[ScrollEventType.MOMENTUM_END.ordinal()] = 5;
        }
    }

    public static String getJSEventName(ScrollEventType scrollEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$scroll$ScrollEventType[scrollEventType.ordinal()];
        if (i == 1) {
            return "topScrollBeginDrag";
        }
        if (i == 2) {
            return "topScrollEndDrag";
        }
        if (i == 3) {
            return "topScroll";
        }
        if (i == 4) {
            return "topMomentumScrollBegin";
        }
        if (i == 5) {
            return "topMomentumScrollEnd";
        }
        throw new IllegalArgumentException("Unsupported ScrollEventType: ".concat(String.valueOf(scrollEventType)));
    }

    public final String getJSEventName() {
        return getJSEventName(this);
    }
}
