package com.reactnativecommunity.webview.events;

import _m_j.ixe;
import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reactnativecommunity/webview/events/TopLoadingErrorEvent;", "Lcom/facebook/react/views/webview/events/TopLoadingErrorEvent;", "viewId", "", "mEventData", "Lcom/facebook/react/bridge/WritableMap;", "(ILcom/facebook/react/bridge/WritableMap;)V", "android_debug"}, k = 1, mv = {1, 1, 16})
public final class TopLoadingErrorEvent extends com.facebook.react.views.webview.events.TopLoadingErrorEvent {
    private final WritableMap mEventData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopLoadingErrorEvent(int i, WritableMap writableMap) {
        super(i, writableMap);
        ixe.O00000o0(writableMap, "mEventData");
        this.mEventData = writableMap;
    }
}
