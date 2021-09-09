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
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import java.util.Map;

public class ProgressDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTProgressDialog";

    public String getName() {
        return REACT_CLASS;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o0 = themedReactContext;
        if (themedReactContext.hasCurrentActivity()) {
            o000000o.f8514O000000o = new XQProgressHorizontalDialog(themedReactContext.getCurrentActivity());
        } else {
            o000000o.f8514O000000o = new XQProgressHorizontalDialog(themedReactContext);
            fyc.O00000o0("ProgressDialogManager", "createViewInstance error: getCurrentActivity()=null");
        }
        o000000o.f8514O000000o.f9117O000000o = false;
        o000000o.f8514O000000o.setCancelable(false);
        return o000000o;
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8514O000000o != null) {
            o000000o.f8514O000000o.setCancelable(z);
        }
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        o000000o.f8514O000000o.setTitle(str);
    }

    @ReactProp(name = "visible")
    public void setVisible(O000000o o000000o, boolean z) {
        o000000o.O00000Oo = z;
    }

    @ReactProp(name = "message")
    public void setMessage(O000000o o000000o, String str) {
        o000000o.f8514O000000o.setMessage(str);
    }

    @ReactProp(name = "timeout")
    public void setTimeout(O000000o o000000o, int i) {
        o000000o.O00000oo = (long) i;
    }

    @ReactProp(name = "max")
    public void setMax(O000000o o000000o, int i) {
        o000000o.O00000o = i;
    }

    @ReactProp(name = "progress")
    public void setProgress(O000000o o000000o, int i) {
        o000000o.O00000oO = i;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onDismiss", MapBuilder.of("registrationName", "onDismiss")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            o000000o.f8514O000000o.setDismissCallBack(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.ProgressDialogManager.AnonymousClass1 */

                public final void afterDismissCallBack() {
                }

                public final void beforeDismissCallBack() {
                    ((RCTEventEmitter) o000000o.O00000o0.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onDismiss", Arguments.createMap());
                }
            });
        }
    }

    public void onAfterUpdateTransaction(View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            try {
                if (o000000o.f8514O000000o != null) {
                    o000000o.f8514O000000o.O000000o(o000000o.O00000o, o000000o.O00000oO);
                    if (o000000o.O00000Oo) {
                        if (!o000000o.f8514O000000o.isShowing()) {
                            o000000o.f8514O000000o.show();
                            if (view != null && o000000o.O00000oo > 0) {
                                view.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.ProgressDialogManager.AnonymousClass2 */

                                    public final void run() {
                                        O000000o o000000o = o000000o;
                                        o000000o.O00000Oo = false;
                                        ProgressDialogManager.this.onAfterUpdateTransaction(o000000o);
                                    }
                                }, o000000o.O00000oo);
                            }
                        }
                    } else if (o000000o.f8514O000000o.isShowing()) {
                        o000000o.f8514O000000o.dismiss();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void onDropViewInstance(View view) {
        if (view != null && (view instanceof O000000o)) {
            O000000o o000000o = (O000000o) view;
            if (o000000o.f8514O000000o != null && o000000o.f8514O000000o.isShowing()) {
                o000000o.f8514O000000o.dismiss();
            }
            o000000o.f8514O000000o = null;
            o000000o.O00000o0 = null;
            fyc.O00000Oo("RCTProgressDialog", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public XQProgressHorizontalDialog f8514O000000o;
        public boolean O00000Oo;
        public int O00000o = 100;
        public ThemedReactContext O00000o0;
        public int O00000oO;
        public long O00000oo;

        public O000000o(Context context) {
            super(context);
        }
    }
}
