package com.facebook.react.uimanager.events;

public enum TouchEventType {
    START,
    END,
    MOVE,
    CANCEL;

    /* renamed from: com.facebook.react.uimanager.events.TouchEventType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = new int[TouchEventType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.START.ordinal()] = 1;
            $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.END.ordinal()] = 2;
            $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.MOVE.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String getJSEventName(TouchEventType touchEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[touchEventType.ordinal()];
        if (i == 1) {
            return "topTouchStart";
        }
        if (i == 2) {
            return "topTouchEnd";
        }
        if (i == 3) {
            return "topTouchMove";
        }
        if (i == 4) {
            return "topTouchCancel";
        }
        throw new IllegalArgumentException("Unexpected type ".concat(String.valueOf(touchEventType)));
    }
}
