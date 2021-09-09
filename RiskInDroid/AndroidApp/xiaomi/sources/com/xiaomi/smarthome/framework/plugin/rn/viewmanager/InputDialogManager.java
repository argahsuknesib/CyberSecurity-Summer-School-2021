package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyc;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class InputDialogManager extends SimpleViewManager {
    private static String REACT_CLASS = "RCTInputDialog";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public O000000o createViewInstance(ThemedReactContext themedReactContext) {
        O000000o o000000o = new O000000o(themedReactContext);
        o000000o.O00000o = themedReactContext;
        if (themedReactContext.hasCurrentActivity()) {
            o000000o.f8481O000000o = new MLAlertDialog.Builder(themedReactContext.getCurrentActivity());
        } else {
            o000000o.f8481O000000o = new MLAlertDialog.Builder(themedReactContext);
            fyc.O00000o0("InputDialogManager", "createViewInstance error: getCurrentActivity()=null");
        }
        return o000000o;
    }

    @ReactProp(name = "title")
    public void setTitle(O000000o o000000o, String str) {
        if (o000000o.f8481O000000o != null) {
            o000000o.f8481O000000o.O000000o(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setTitle(str);
        }
    }

    @ReactProp(name = "message")
    public void setMessage(O000000o o000000o, String str) {
        if (o000000o.f8481O000000o != null) {
            o000000o.f8481O000000o.O00000Oo(str);
        }
        if (o000000o.O00000o0 != null) {
            o000000o.O00000o0.setMessage(str);
        }
    }

    @ReactProp(defaultBoolean = true, name = "cancelable")
    public void setCancelable(O000000o o000000o, boolean z) {
        if (o000000o.f8481O000000o != null) {
            o000000o.f8481O000000o.O000000o(z);
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
        o000000o.O0000OOo = (long) i;
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(O000000o o000000o, String str) {
        o000000o.O00000oO = str;
    }

    @ReactProp(name = "singleLine")
    public void setSingleLine(O000000o o000000o, boolean z) {
        o000000o.O0000O0o = z;
    }

    @ReactProp(name = "defaultText")
    public void setDefaultText(O000000o o000000o, String str) {
        o000000o.O00000oo = str;
    }

    @ReactProp(name = "cancel")
    public void setCancel(final O000000o o000000o, String str) {
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", i);
                    if (o000000o.O00000o0 != null) {
                        createMap.putString("text", o000000o.O00000o0.getInputView().getText().toString());
                    }
                    fyc.O00000Oo("InputDialogManager", "rn onCancel  Emitter...");
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onCancel", createMap);
                }
            };
            if (o000000o.f8481O000000o != null) {
                o000000o.f8481O000000o.O00000Oo(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-2, str, r0);
                o000000o.O00000o0.getButton(-2).setText(str);
            }
        }
    }

    @ReactProp(name = "confirm")
    public void setConfirm(final O000000o o000000o, String str) {
        if (!TextUtils.isEmpty(str)) {
            AnonymousClass2 r0 = new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("position", i);
                    if (o000000o.O00000o0 != null) {
                        createMap.putString("text", o000000o.O00000o0.getInputView().getText().toString());
                    }
                    fyc.O00000Oo("InputDialogManager", "rn onConfirm  Emitter...");
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onConfirm", createMap);
                }
            };
            if (o000000o.f8481O000000o != null) {
                o000000o.f8481O000000o.O000000o(str, r0);
            }
            if (o000000o.O00000o0 != null) {
                o000000o.O00000o0.setButton(-1, str, r0);
                o000000o.O00000o0.getButton(-1).setText(str);
            }
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onConfirm", MapBuilder.of("registrationName", "onConfirm")).put("onCancel", MapBuilder.of("registrationName", "onCancel")).put("onDismiss", MapBuilder.of("registrationName", "onDismiss")).build();
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            o000000o.f8481O000000o.O000000o(new MLAlertDialog.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.AnonymousClass3 */

                public final void afterDismissCallBack() {
                }

                public final void beforeDismissCallBack() {
                    WritableMap createMap = Arguments.createMap();
                    O000000o o000000o = o000000o;
                    EditText inputView = o000000o.O00000o0.getInputView();
                    if (inputView != null) {
                        ((InputMethodManager) o000000o.getContext().getSystemService("input_method")).hideSoftInputFromWindow(inputView.getWindowToken(), 0);
                    }
                    fyc.O00000Oo("InputDialogManager", "rn onDismiss  Emitter...");
                    ((RCTEventEmitter) o000000o.O00000o.getJSModule(RCTEventEmitter.class)).receiveEvent(o000000o.getId(), "onDismiss", createMap);
                }
            });
        }
    }

    public void onAfterUpdateTransaction(View view) {
        if (view != null && (view instanceof O000000o)) {
            final O000000o o000000o = (O000000o) view;
            try {
                if (o000000o.O00000Oo) {
                    if (o000000o.O00000o0 == null || o000000o.O00000o0.getInputView() == null) {
                        o000000o.f8481O000000o.O000000o(o000000o.O00000oO, o000000o.O0000O0o);
                        o000000o.f8481O000000o.O000000o().setText(o000000o.O00000oo);
                    } else {
                        EditText inputView = o000000o.O00000o0.getInputView();
                        inputView.setHint(o000000o.O00000oO);
                        inputView.setSingleLine(o000000o.O0000O0o);
                        if (o000000o.O0000O0o) {
                            inputView.setEllipsize(TextUtils.TruncateAt.END);
                        }
                        inputView.setText(o000000o.O00000oo);
                    }
                    if (o000000o.O00000o0 != null) {
                        if (!o000000o.O00000o0.isShowing()) {
                            o000000o.O00000o0.show();
                            o000000o.O000000o(o000000o.O00000o0.getInputView());
                            if (o000000o.O0000OOo > 0) {
                                o000000o.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.AnonymousClass4 */

                                    public final void run() {
                                        O000000o o000000o = o000000o;
                                        o000000o.O00000Oo = false;
                                        InputDialogManager.this.onAfterUpdateTransaction(o000000o);
                                    }
                                }, o000000o.O0000OOo);
                            }
                        }
                    } else if (o000000o.f8481O000000o != null) {
                        o000000o.O00000o0 = o000000o.f8481O000000o.O00000oo();
                        o000000o.O000000o(o000000o.O00000o0.getInputView());
                        if (o000000o.O0000OOo > 0) {
                            o000000o.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.AnonymousClass5 */

                                public final void run() {
                                    O000000o o000000o = o000000o;
                                    o000000o.O00000Oo = false;
                                    InputDialogManager.this.onAfterUpdateTransaction(o000000o);
                                }
                            }, o000000o.O0000OOo);
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
            o000000o.f8481O000000o = null;
            o000000o.O00000o = null;
            fyc.O00000Oo("InputDialogManager", "onDropViewInstance..." + view.getId());
        }
        super.onDropViewInstance(view);
    }

    class O000000o extends View {

        /* renamed from: O000000o  reason: collision with root package name */
        public MLAlertDialog.Builder f8481O000000o;
        public boolean O00000Oo;
        public ThemedReactContext O00000o;
        public MLAlertDialog O00000o0;
        public String O00000oO;
        public String O00000oo;
        public boolean O0000O0o;
        public long O0000OOo;

        public O000000o(Context context) {
            super(context);
        }

        public final void O000000o(final EditText editText) {
            if (editText != null) {
                String obj = editText.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    editText.setSelection(obj.length());
                }
                new Timer().schedule(new TimerTask() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.InputDialogManager.O000000o.AnonymousClass1 */

                    public final void run() {
                        ((InputMethodManager) O000000o.this.getContext().getSystemService("input_method")).showSoftInput(editText, 2);
                    }
                }, 200);
            }
        }
    }
}
