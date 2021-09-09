package com.facebook.react.uimanager.layoutanimation;

enum LayoutAnimationType {
    CREATE,
    UPDATE,
    DELETE;

    /* renamed from: com.facebook.react.uimanager.layoutanimation.LayoutAnimationType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType = new int[LayoutAnimationType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[LayoutAnimationType.CREATE.ordinal()] = 1;
            $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[LayoutAnimationType.UPDATE.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[LayoutAnimationType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String toString(LayoutAnimationType layoutAnimationType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$layoutanimation$LayoutAnimationType[layoutAnimationType.ordinal()];
        if (i == 1) {
            return "create";
        }
        if (i == 2) {
            return "update";
        }
        if (i == 3) {
            return "delete";
        }
        throw new IllegalArgumentException("Unsupported LayoutAnimationType: ".concat(String.valueOf(layoutAnimationType)));
    }
}
