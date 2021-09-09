package _m_j;

import _m_j.auh;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.google.gson.Gson;
import java.io.File;

public final class gcu extends PDFView implements atr, att, atu, atv, atx, atz, aub {
    private static gcu O000Oo0O;
    private ThemedReactContext O000O0Oo;
    private float O000O0o = 1.0f;
    private boolean O000O0o0 = false;
    private float O000O0oO = 1.0f;
    private float O000O0oo = 3.0f;
    private String O000OO = "";
    private String O000OO00;
    private int O000OO0o = 10;
    private boolean O000OOOo = true;
    private boolean O000OOo = false;
    private boolean O000OOo0 = true;
    private boolean O000OOoO = false;
    private boolean O000OOoo = false;
    private FitPolicy O000Oo0 = FitPolicy.WIDTH;
    private boolean O000Oo00 = false;
    private float O000Oo0o = 0.0f;
    private float O000OoO0 = 0.0f;
    private float O00O0Oo = 0.0f;
    private int O00oOoOo = 1;

    public gcu(ThemedReactContext themedReactContext) {
        super(themedReactContext, null);
        this.O000O0Oo = themedReactContext;
        O000Oo0O = this;
    }

    public final void O000000o(int i, int i2) {
        int i3 = i + 1;
        this.O00oOoOo = i3;
        O000000o(String.format("%s %s / %s", this.O000OO00, Integer.valueOf(i3), Integer.valueOf(i2)));
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", "pageChanged|" + i3 + "|" + i2);
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public final void a_(int i) {
        this.O0000Oo = this.O000O0o;
        WritableMap createMap = Arguments.createMap();
        Gson gson = new Gson();
        createMap.putString("message", "loadComplete|" + i + "|" + ((float) getWidth()) + "|" + ((float) getHeight()) + "|" + gson.toJson(getTableOfContents()));
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public final void O000000o(Throwable th) {
        WritableMap createMap = Arguments.createMap();
        if (th.getMessage().contains("Password required or incorrect password")) {
            createMap.putString("message", "error|Password required or incorrect password.");
        } else {
            createMap.putString("message", "error|" + th.getMessage());
        }
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
    }

    public final void O000000o() {
        auh.O00000Oo.O00000Oo = this.O000O0oO;
        auh.O00000Oo.f12622O000000o = this.O000O0oo;
    }

    public final boolean O000000o(MotionEvent motionEvent) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("message", "pageSingleTap|" + this.O00oOoOo + "|" + motionEvent.getX() + "|" + motionEvent.getY());
        ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
        return true;
    }

    public final void a_(float f, float f2) {
        if (this.O000Oo0o == 0.0f) {
            this.O000Oo0o = f;
        }
        float f3 = this.O000OoO0;
        if (f3 > 0.0f) {
            float f4 = this.O00O0Oo;
            if (f4 > 0.0f && !(f == f3 && f2 == f4)) {
                auh.O00000Oo.O00000Oo = this.O000O0oO;
                auh.O00000Oo.f12622O000000o = this.O000O0oo;
                WritableMap createMap = Arguments.createMap();
                createMap.putString("message", "scaleChanged|" + (f / this.O000Oo0o));
                ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
            }
        }
        this.O000OoO0 = f;
        this.O00O0Oo = f2;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O0000OoO) {
            O00000oo();
        }
    }

    public final void O00000oo() {
        O000000o(String.format("drawPdf path:%s %s", this.O000OO00, Integer.valueOf(this.O00oOoOo)));
        if (this.O000OO00 != null) {
            setMinZoom(this.O000O0oO);
            setMaxZoom(this.O000O0oo);
            setMidZoom((this.O000O0oo + this.O000O0oO) / 2.0f);
            auh.O00000Oo.O00000Oo = this.O000O0oO;
            auh.O00000Oo.f12622O000000o = this.O000O0oo;
            PDFView.O000000o O000000o2 = O000000o(O00000Oo(this.O000OO00));
            O000000o2.O0000OOo = this.O00oOoOo - 1;
            O000000o2.O0000Oo0 = this.O000O0o0;
            O000000o2.O00000o = this;
            O000000o2.O00000Oo = this;
            O000000o2.O00000o0 = this;
            O000000o2.O00000oo = this;
            O000000o2.f3603O000000o = this;
            O000000o2.O00000oO = this;
            O000000o2.O0000o00 = this.O000OO0o;
            O000000o2.O0000OoO = this.O000OO;
            O000000o2.O0000Ooo = this.O000OOOo;
            O000000o2.O0000o0O = this.O000Oo0;
            O000000o2.O0000o = this.O000Oo00;
            O000000o2.O0000o0 = this.O000OOoO;
            O000000o2.O0000o0o = this.O000OOoo;
            O000000o2.O0000Oo = this.O000OOo0;
            O000000o2.O0000O0o = this;
            O000000o2.O000000o();
        }
    }

    public final void setPath(String str) {
        this.O000OO00 = str;
    }

    public final void setPage(int i) {
        if (i <= 1) {
            i = 1;
        }
        this.O00oOoOo = i;
    }

    public final void setScale(float f) {
        this.O000O0o = f;
    }

    public final void setMinScale(float f) {
        this.O000O0oO = f;
    }

    public final void setMaxScale(float f) {
        this.O000O0oo = f;
    }

    public final void setHorizontal(boolean z) {
        this.O000O0o0 = z;
    }

    public final void setSpacing(int i) {
        this.O000OO0o = i;
    }

    public final void setPassword(String str) {
        this.O000OO = str;
    }

    public final void setEnableAntialiasing(boolean z) {
        this.O000OOOo = z;
    }

    public final void setEnableAnnotationRendering(boolean z) {
        this.O000OOo0 = z;
    }

    public final void setEnablePaging(boolean z) {
        this.O000OOo = z;
        if (this.O000OOo) {
            this.O000OOoO = true;
            this.O000OOoo = true;
            this.O000Oo00 = true;
            return;
        }
        this.O000OOoO = false;
        this.O000OOoo = false;
        this.O000Oo00 = false;
    }

    public final void setFitPolicy(int i) {
        if (i == 0) {
            this.O000Oo0 = FitPolicy.WIDTH;
        } else if (i != 1) {
            this.O000Oo0 = FitPolicy.BOTH;
        } else {
            this.O000Oo0 = FitPolicy.HEIGHT;
        }
    }

    private static void O000000o(String str) {
        gsy.O000000o(3, "PdfView", str);
    }

    private static Uri O00000Oo(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null || parse.getScheme().isEmpty()) {
            return Uri.fromFile(new File(str));
        }
        return parse;
    }

    public final void O000000o(auc auc) {
        String str = auc.f12617O000000o.O00000o0;
        Integer num = auc.f12617O000000o.O00000Oo;
        if (str != null && !str.isEmpty()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("message", "linkPressed|".concat(String.valueOf(str)));
            ((RCTEventEmitter) ((ReactContext) getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "topChange", createMap);
        } else if (num != null) {
            O000000o(num.intValue());
        }
    }
}
