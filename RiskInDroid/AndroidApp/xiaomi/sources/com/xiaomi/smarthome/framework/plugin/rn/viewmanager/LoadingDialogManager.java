package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.Map;

public class LoadingDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTLoadingDialog";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o0 = themedReactContext;
        if (themedReactContext.getCurrentActivity() != null) {
            o000000o.f8485O000000o = new XQProgressDialog(themedReactContext.getCurrentActivity());
            o000000o.f8485O000000o.setCancelable(false);
        }
        return o000000o;
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8485O000000o != null) {
            o000000o.f8485O000000o.setCancelable(z);
        }
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        if (o000000o.f8485O000000o != null) {
            o000000o.f8485O000000o.setTitle(str);
        }
    }

    @ReactProp(name = "visible")
    public void setVisible(O000000o o000000o, boolean z) {
        if (o000000o.f8485O000000o != null) {
            o000000o.O00000Oo = z;
        }
    }

    @ReactProp(name = "timeout")
    public void setTimeout(O000000o o000000o, int i) {
        if (o000000o.f8485O000000o != null) {
            o000000o.O00000o = (long) i;
        }
    }

    @ReactProp(name = "message")
    public void setMessage(O000000o o000000o, String str) {
        if (o000000o.f8485O000000o != null) {
            o000000o.f8485O000000o.setMessage(str);
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onDismiss", MapBuilder.of("registrationName", "onDismiss")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            if (o000000o.f8485O000000o != null) {
                o000000o.f8485O000000o.setDismissCallBack(new MLAlertDialog.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.LoadingDialogManager.AnonymousClass1 */

                    public final void afterDismissCallBack() {
                    }

                    public final void beforeDismissCallBack() {
                        ((RCTEventEmitter) o000000o.O00000o0.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onDismiss", Arguments.createMap());
                    }
                });
            }
        }
    }

    public void onAfterUpdateTransaction(View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            try {
                if (o000000o.f8485O000000o == null) {
                    return;
                }
                if (o000000o.O00000Oo) {
                    if (!o000000o.f8485O000000o.isShowing()) {
                        o000000o.f8485O000000o.show();
                        if (view != null && o000000o.O00000o > 0) {
                            view.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.LoadingDialogManager.AnonymousClass2 */

                                public final void run() {
                                    O000000o o000000o = o000000o;
                                    o000000o.O00000Oo = false;
                                    LoadingDialogManager.this.onAfterUpdateTransaction(o000000o);
                                }
                            }, o000000o.O00000o);
                        }
                    }
                } else if (o000000o.f8485O000000o.isShowing()) {
                    o000000o.f8485O000000o.dismiss();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void onDropViewInstance(View view) {
        if (view != null && (view instanceof O000000o)) {
            O000000o o000000o = (O000000o) view;
            if (o000000o.f8485O000000o != null && o000000o.f8485O000000o.isShowing()) {
                o000000o.f8485O000000o.dismiss();
            }
            o000000o.f8485O000000o = null;
            o000000o.O00000o0 = null;
            fyc.O00000Oo("RCTLoadingDialog", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public XQProgressDialog f8485O000000o;
        public boolean O00000Oo;
        public long O00000o;
        public ThemedReactContext O00000o0;

        public O000000o(Context context) {
            super(context);
        }
    }
}
