package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Map;

public class SingleChoseDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTSingleChoseDialog";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o = themedReactContext;
        if (themedReactContext.hasCurrentActivity()) {
            o000000o.f8521O000000o = new MLAlertDialog.Builder(themedReactContext.getCurrentActivity());
        } else {
            o000000o.f8521O000000o = new MLAlertDialog.Builder(themedReactContext);
            fyc.O00000o0("SingleChoseDialogManager", "createViewInstance error: getCurrentActivity()=null");
        }
        return o000000o;
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        if (o000000o.f8521O000000o != null) {
            o000000o.f8521O000000o.O000000o(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setTitle(str);
        }
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8521O000000o != null) {
            o000000o.f8521O000000o.O000000o(z);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setCancelable(z);
        }
    }

    @ReactProp(name = "visible")
    public void setVisible(O000000o o000000o, boolean z) {
        o000000o.O00000Oo = z;
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(O000000o o000000o, ReadableArray readableArray) {
        o000000o.O0000O0o = readableArray;
    }

    @ReactProp(name = "timeout")
    public void setTimeout(O000000o o000000o, int i) {
        o000000o.O0000Oo0 = (long) i;
    }

    @ReactProp(name = "dataKey")
    @Deprecated
    public void setDataKey(O000000o o000000o, String str) {
        o000000o.O0000OOo = str;
    }

    @ReactProp(name = "check")
    public void setCheck(O000000o o000000o, int i) {
        o000000o.O00000oO = i;
        if (o000000o.O00000o0 != null && o000000o.O00000oO >= 0 && o000000o.O00000o0.getListView() != null) {
            o000000o.O00000o0.getListView().setItemChecked(o000000o.O00000oO, true);
            o000000o.O00000o0.getListView().setSelection(o000000o.O00000oO);
        }
    }

    @ReactProp(name = "cancel")
    public void setCancel(final O000000o o000000o, String str) {
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", o000000o.O00000oo);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onCancel", createMap);
                    o000000o.O000000o();
                }
            };
            if (o000000o.f8521O000000o != null) {
                o000000o.f8521O000000o.O00000Oo(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-2, str, r0);
            }
        }
    }

    @ReactProp(name = "confirm")
    public void setConfirm(final O000000o o000000o, String str) {
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass2 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", o000000o.O00000oo);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onConfirm", createMap);
                    o000000o.O000000o();
                }
            };
            if (o000000o.f8521O000000o != null) {
                o000000o.f8521O000000o.O000000o(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-1, str, r0);
            }
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onConfirm", MapBuilder.of("registrationName", "onConfirm")).put("onCancel", MapBuilder.of("registrationName", "onCancel")).put("onDismiss", MapBuilder.of("registrationName", "onDismiss")).put("onCheck", MapBuilder.of("registrationName", "onCheck")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            o000000o.f8521O000000o.O000000o(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass3 */

                public final void afterDismissCallBack() {
                }

                public final void beforeDismissCallBack() {
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onDismiss", Arguments.createMap());
                }
            });
        }
    }

    public void onAfterUpdateTransaction(final View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            if (o000000o.O0000O0o != null) {
                int size = o000000o.O0000O0o.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    if (TextUtils.isEmpty(o000000o.O0000OOo)) {
                        strArr[i] = o000000o.O0000O0o.getString(i);
                    } else {
                        strArr[i] = o000000o.O0000O0o.getMap(i).getString(o000000o.O0000OOo);
                    }
                }
                o000000o.f8521O000000o.O000000o(strArr, o000000o.O00000oO, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        o000000o.O00000oo = i;
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("position", i);
                        ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onCheck", createMap);
                    }
                });
            }
            try {
                if (o000000o.O00000Oo) {
                    if (o000000o.O00000o0 != null) {
                        if (!o000000o.O00000o0.isShowing()) {
                            o000000o.O00000o0.show();
                            if (view != null && o000000o.O0000Oo0 > 0) {
                                view.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass5 */

                                    public final void run() {
                                        o000000o.O00000Oo = false;
                                        SingleChoseDialogManager.this.onAfterUpdateTransaction(view);
                                    }
                                }, o000000o.O0000Oo0);
                            }
                        }
                    } else if (o000000o.f8521O000000o != null) {
                        o000000o.O00000o0 = o000000o.f8521O000000o.O00000oo();
                        if (view != null && o000000o.O0000Oo0 > 0) {
                            view.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.SingleChoseDialogManager.AnonymousClass6 */

                                public final void run() {
                                    o000000o.O00000Oo = false;
                                    SingleChoseDialogManager.this.onAfterUpdateTransaction(view);
                                }
                            }, o000000o.O0000Oo0);
                        }
                    }
                } else if (o000000o.O00000o0 != null && o000000o.O00000o0.isShowing()) {
                    o000000o.O00000o0.dismiss();
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
            o000000o.O00000o0 = null;
            o000000o.f8521O000000o = null;
            o000000o.O00000o = null;
            fyc.O00000Oo("SingleChoseDialogManager", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public MLAlertDialog.Builder f8521O000000o;
        public boolean O00000Oo;
        public ThemedReactContext O00000o;
        public MLAlertDialog O00000o0;
        public int O00000oO;
        public int O00000oo;
        public ReadableArray O0000O0o;
        public String O0000OOo;
        public long O0000Oo0;
        private boolean O0000OoO = true;

        public O000000o(Context context) {
            super(context);
        }

        public final void O000000o() {
            if (this.O00000oO >= 0 && this.O00000o0.getListView() != null) {
                this.O00000o0.getListView().setItemChecked(this.O00000oO, true);
                this.O00000o0.getListView().setSelection(this.O00000oO);
            }
        }
    }
}
