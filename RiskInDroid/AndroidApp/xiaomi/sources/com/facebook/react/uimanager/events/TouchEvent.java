package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import androidx.core.util.Pools;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.SoftAssertions;

public class TouchEvent extends Event<TouchEvent> {
    private static final Pools.O00000Oo<TouchEvent> EVENTS_POOL = new Pools.O00000Oo<>(3);
    private short mCoalescingKey;
    private MotionEvent mMotionEvent;
    private TouchEventType mTouchEventType;
    private float mViewX;
    private float mViewY;

    public static TouchEvent obtain(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        TouchEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new TouchEvent();
        }
        acquire.init(i, touchEventType, motionEvent, j, f, f2, touchEventCoalescingKeyHelper);
        return acquire;
    }

    private TouchEvent() {
    }

    private void init(int i, TouchEventType touchEventType, MotionEvent motionEvent, long j, float f, float f2, TouchEventCoalescingKeyHelper touchEventCoalescingKeyHelper) {
        super.init(i);
        short s = 0;
        SoftAssertions.assertCondition(j != Long.MIN_VALUE, "Gesture start time must be initialized");
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            touchEventCoalescingKeyHelper.addCoalescingKey(j);
        } else if (action == 1) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 2) {
            s = touchEventCoalescingKeyHelper.getCoalescingKey(j);
        } else if (action == 3) {
            touchEventCoalescingKeyHelper.removeCoalescingKey(j);
        } else if (action == 5 || action == 6) {
            touchEventCoalescingKeyHelper.incrementCoalescingKey(j);
        } else {
            throw new RuntimeException("Unhandled MotionEvent action: ".concat(String.valueOf(action)));
        }
        this.mTouchEventType = touchEventType;
        this.mMotionEvent = MotionEvent.obtain(motionEvent);
        this.mCoalescingKey = s;
        this.mViewX = f;
        this.mViewY = f2;
    }

    public void onDispose() {
        ((MotionEvent) Assertions.assertNotNull(this.mMotionEvent)).recycle();
        this.mMotionEvent = null;
        EVENTS_POOL.release(this);
    }

    public String getEventName() {
        return TouchEventType.getJSEventName((TouchEventType) Assertions.assertNotNull(this.mTouchEventType));
    }

    /* renamed from: com.facebook.react.uimanager.events.TouchEvent$1  reason: invalid class name */
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
            $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.CANCEL.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.MOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public boolean canCoalesce() {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[((TouchEventType) Assertions.assertNotNull(this.mTouchEventType)).ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4) {
            return true;
        }
        throw new RuntimeException("Unknown touch event type: " + this.mTouchEventType);
    }

    public short getCoalescingKey() {
        return this.mCoalescingKey;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        TouchesHelper.sendTouchEvent(rCTEventEmitter, (TouchEventType) Assertions.assertNotNull(this.mTouchEventType), getViewTag(), this);
    }

    public MotionEvent getMotionEvent() {
        Assertions.assertNotNull(this.mMotionEvent);
        return this.mMotionEvent;
    }

    public float getViewX() {
        return this.mViewX;
    }

    public float getViewY() {
        return this.mViewY;
    }
}
