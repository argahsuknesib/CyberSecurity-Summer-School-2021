package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public final class dfx extends Event<dfx> {
    public final short getCoalescingKey() {
        return 0;
    }

    public final String getEventName() {
        return "topDismissed";
    }

    public dfx(int i) {
        super(i);
    }

    public final void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), Arguments.createMap());
    }
}
