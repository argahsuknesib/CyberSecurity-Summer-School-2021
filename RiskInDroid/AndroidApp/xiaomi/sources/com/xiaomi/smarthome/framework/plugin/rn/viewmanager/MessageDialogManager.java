package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import _m_j.gbu;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Map;

public class MessageDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTMessageDialog";

    public String getName() {
        fyc.O00000Oo("MessageDialogManager", "getName...");
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o = themedReactContext;
        if (themedReactContext.getCurrentActivity() != null) {
            o000000o.f8496O000000o = new MLAlertDialog.Builder(themedReactContext.getCurrentActivity());
        } else {
            fyc.O00000Oo("MessageDialogManager", "currentActivity is null ");
        }
        return o000000o;
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        o000000o.O00000oo = true;
        if (o000000o.f8496O000000o != null) {
            o000000o.f8496O000000o.O000000o(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setTitle(str);
        }
    }

    @ReactProp(name = "visible")
    public void setVisible(O000000o o000000o, boolean z) {
        o000000o.O00000Oo = z;
    }

    @ReactProp(name = "timeout")
    public void setTimeout(O000000o o000000o, int i) {
        o000000o.O00000oO = (long) i;
    }

    @ReactProp(name = "message")
    public void setMessage(O000000o o000000o, String str) {
        o000000o.O00000oo = true;
        if (o000000o.f8496O000000o != null) {
            o000000o.f8496O000000o.O00000Oo(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setMessage(str);
        }
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8496O000000o != null) {
            o000000o.f8496O000000o.O000000o(z);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setCancelable(z);
        }
    }

    @ReactProp(name = "cancel")
    public void setCancel(final O000000o o000000o, String str) {
        o000000o.O00000oo = true;
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", i);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onCancel", createMap);
                }
            };
            if (o000000o.f8496O000000o != null) {
                o000000o.f8496O000000o.O00000Oo(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-2, str, r0);
                o000000o.O00000o0.getButton(-2).setText(str);
            }
        } else if (o000000o.f8496O000000o != null) {
            o000000o.f8496O000000o.O00000Oo(str, (DialogInterface.OnClickListener) null);
        }
    }

    @ReactProp(name = "confirm")
    public void setConfirm(final O000000o o000000o, String str) {
        o000000o.O00000oo = true;
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass2 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", i);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onConfirm", createMap);
                }
            };
            if (o000000o.f8496O000000o != null) {
                o000000o.f8496O000000o.O000000o(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-1, str, r0);
                o000000o.O00000o0.getButton(-1).setText(str);
            }
        } else if (o000000o.f8496O000000o != null) {
            o000000o.f8496O000000o.O000000o(str, (DialogInterface.OnClickListener) null);
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        fyc.O00000Oo("MessageDialogManager", "getExportedCustomDirectEventTypeConstants...");
        return MapBuilder.builder().put("onConfirm", MapBuilder.of("registrationName", "onConfirm")).put("onCancel", MapBuilder.of("registrationName", "onCancel")).put("onDismiss", MapBuilder.of("registrationName", "onDismiss")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            if (o000000o.f8496O000000o != null) {
                o000000o.f8496O000000o.O000000o(new MLAlertDialog.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager.AnonymousClass3 */

                    public final void afterDismissCallBack() {
                    }

                    public final void beforeDismissCallBack() {
                        fyc.O00000Oo("MessageDialogManager", "rn dismiss  is exec...");
                        ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onDismiss", Arguments.createMap());
                    }
                });
            }
        }
    }

    public void onAfterUpdateTransaction(final View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            try {
                MLAlertDialog mLAlertDialog = o000000o.O00000o0;
                if (o000000o.O00000oo) {
                    if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                        mLAlertDialog.dismiss();
                    }
                    gbu.O000000o("MessageDialog  should rebuild dialog...");
                    o000000o.O00000o0 = null;
                    mLAlertDialog = null;
                }
                if (o000000o.O00000Oo) {
                    if (mLAlertDialog != null) {
                        if (!mLAlertDialog.isShowing()) {
                            mLAlertDialog.show();
                            if (view != null && o000000o.O00000oO > 0) {
                                view.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager.AnonymousClass4 */

                                    public final void run() {
                                        o000000o.O00000Oo = false;
                                        MessageDialogManager.this.onAfterUpdateTransaction(view);
                                    }
                                }, o000000o.O00000oO);
                            }
                        }
                    } else if (o000000o.f8496O000000o != null) {
                        o000000o.O00000o0 = o000000o.f8496O000000o.O00000oo();
                        o000000o.O00000oo = false;
                        if (view != null && o000000o.O00000oO > 0) {
                            view.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MessageDialogManager.AnonymousClass5 */

                                public final void run() {
                                    o000000o.O00000Oo = false;
                                    MessageDialogManager.this.onAfterUpdateTransaction(view);
                                }
                            }, o000000o.O00000oO);
                        }
                    }
                } else if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                    mLAlertDialog.dismiss();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void onDropViewInstance(View view) {
        if (view != null && (view instanceof O000000o)) {
            O000000o o000000o = (O000000o) view;
            if (o000000o.O00000o0 != null && o000000o.O00000o0.isShowing()) {
                o000000o.O00000o0.dismiss();
            }
            o000000o.f8496O000000o = null;
            o000000o.O00000o0 = null;
            o000000o.O00000o = null;
            fyc.O00000Oo("RCTMessageDialog", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public MLAlertDialog.Builder f8496O000000o;
        public boolean O00000Oo;
        public ThemedReactContext O00000o;
        public MLAlertDialog O00000o0;
        public long O00000oO;
        public boolean O00000oo = true;

        public O000000o(Context context) {
            super(context);
        }
    }
}
