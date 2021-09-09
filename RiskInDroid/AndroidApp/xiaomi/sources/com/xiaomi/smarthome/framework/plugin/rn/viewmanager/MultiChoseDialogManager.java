package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Map;

public class MultiChoseDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTMultiChoseDialog";

    public String getName() {
        return REACT_CLASS;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o = themedReactContext;
        if (themedReactContext.hasCurrentActivity()) {
            o000000o.f8508O000000o = new MLAlertDialog.Builder(themedReactContext.getCurrentActivity());
        } else {
            o000000o.f8508O000000o = new MLAlertDialog.Builder(themedReactContext);
            fyc.O00000o0("MultiChoseDialogManager", "createViewInstance error: getCurrentActivity()=null");
        }
        return o000000o;
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        if (o000000o.f8508O000000o != null) {
            o000000o.f8508O000000o.O000000o(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setTitle(str);
        }
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8508O000000o != null) {
            o000000o.f8508O000000o.O000000o(z);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setCancelable(z);
        }
    }

    @ReactProp(name = "visible")
    public void setVisible(O000000o o000000o, boolean z) {
        o000000o.O00000Oo = z;
    }

    @ReactProp(name = "timeout")
    public void setTimeout(O000000o o000000o, int i) {
        o000000o.O0000Oo0 = (long) i;
    }

    @ReactProp(name = "dataSource")
    public void setDataSource(O000000o o000000o, ReadableArray readableArray) {
        o000000o.O00000oo = readableArray;
        if (o000000o.O00000oo != null) {
            o000000o.O0000OOo = new boolean[o000000o.O00000oo.size()];
        }
    }

    @ReactProp(name = "dataKey")
    public void setDataKey(O000000o o000000o, String str) {
        o000000o.O0000O0o = str;
    }

    @ReactProp(name = "checkKey")
    public void setCheckKey(O000000o o000000o, String str) {
        o000000o.O00000oO = str;
    }

    @ReactProp(name = "cancel")
    public void setCancel(final O000000o o000000o, String str) {
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", i);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onCancel", createMap);
                }
            };
            if (o000000o.f8508O000000o != null) {
                o000000o.f8508O000000o.O00000Oo(str, r0);
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
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    WritableNativeArray writableNativeArray = new WritableNativeArray();
                    if (o000000o.O0000OOo != null) {
                        for (boolean pushBoolean : o000000o.O0000OOo) {
                            writableNativeArray.pushBoolean(pushBoolean);
                        }
                    }
                    createMap.putArray("position", writableNativeArray);
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onConfirm", createMap);
                }
            };
            if (o000000o.f8508O000000o != null) {
                o000000o.f8508O000000o.O000000o(str, r0);
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
            o000000o.f8508O000000o.O000000o(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass3 */

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
            if (o000000o.O00000oo != null) {
                String[] strArr = new String[o000000o.O00000oo.size()];
                for (int i = 0; i < o000000o.O00000oo.size(); i++) {
                    if (TextUtils.isEmpty(o000000o.O0000O0o)) {
                        strArr[i] = o000000o.O00000oo.getString(i);
                    } else {
                        strArr[i] = o000000o.O00000oo.getMap(i).getString(o000000o.O0000O0o);
                    }
                }
                if (o000000o.O00000oO != null) {
                    for (int i2 = 0; i2 < o000000o.O00000oo.size(); i2++) {
                        ReadableMap map = o000000o.O00000oo.getMap(i2);
                        int i3 = AnonymousClass7.f8507O000000o[map.getType(o000000o.O00000oO).ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                        if (i3 == 5 && map.getBoolean(o000000o.O00000oO)) {
                                            o000000o.O0000OOo[i2] = true;
                                        }
                                    } else if (map.getDouble(o000000o.O00000oO) != 0.0d) {
                                        o000000o.O0000OOo[i2] = true;
                                    }
                                } else if (map.getArray(o000000o.O00000oO) != null) {
                                    o000000o.O0000OOo[i2] = true;
                                }
                            } else if (map.getMap(o000000o.O00000oO) != null) {
                                o000000o.O0000OOo[i2] = true;
                            }
                        } else if (!TextUtils.isEmpty(map.getString(o000000o.O00000oO))) {
                            o000000o.O0000OOo[i2] = true;
                        }
                    }
                }
                o000000o.f8508O000000o.O000000o(strArr, o000000o.O0000OOo, new DialogInterface.OnMultiChoiceClickListener() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass4 */

                    public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putInt("position", i);
                        createMap.putBoolean("check", z);
                        ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(view.getId(), "onCheck", createMap);
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
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass5 */

                                    public final void run() {
                                        o000000o.O00000Oo = false;
                                        MultiChoseDialogManager.this.onAfterUpdateTransaction(view);
                                    }
                                }, o000000o.O0000Oo0);
                            }
                        }
                    } else if (o000000o.f8508O000000o != null) {
                        o000000o.O00000o0 = o000000o.f8508O000000o.O00000oo();
                        if (view != null && o000000o.O0000Oo0 > 0) {
                            view.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager.AnonymousClass6 */

                                public final void run() {
                                    o000000o.O00000Oo = false;
                                    MultiChoseDialogManager.this.onAfterUpdateTransaction(view);
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

    /* renamed from: com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MultiChoseDialogManager$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f8507O000000o = new int[ReadableType.values().length];

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
            f8507O000000o[ReadableType.String.ordinal()] = 1;
            f8507O000000o[ReadableType.Map.ordinal()] = 2;
            f8507O000000o[ReadableType.Array.ordinal()] = 3;
            f8507O000000o[ReadableType.Number.ordinal()] = 4;
            f8507O000000o[ReadableType.Boolean.ordinal()] = 5;
        }
    }

    public void onDropViewInstance(View view) {
        if (view != null && (view instanceof O000000o)) {
            O000000o o000000o = (O000000o) view;
            if (o000000o.O00000o0 != null && o000000o.O00000o0.isShowing()) {
                o000000o.O00000o0.dismiss();
            }
            o000000o.O00000o0 = null;
            o000000o.O00000o = null;
            fyc.O00000Oo("RCTMultiChoseDialog", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public MLAlertDialog.Builder f8508O000000o;
        public boolean O00000Oo;
        public ThemedReactContext O00000o;
        public MLAlertDialog O00000o0;
        public String O00000oO;
        public ReadableArray O00000oo;
        public String O0000O0o;
        public boolean[] O0000OOo;
        public long O0000Oo0;

        public O000000o(Context context) {
            super(context);
        }
    }
}
