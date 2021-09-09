package _m_j;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData;
import java.util.Map;

public class hkm extends hkw implements hkl {

    /* renamed from: O000000o  reason: collision with root package name */
    public hkt f19016O000000o;
    public boolean O00000Oo;
    private WebView O00000o;
    public boolean O00000o0 = false;

    public hkm(WebView webView) {
        this.O00000o = webView;
        this.O00000o.setOverScrollMode(2);
        this.f19016O000000o = new hkt(this, this.O00000o);
        this.O00000o.addJavascriptInterface(this, "MJApi");
        O000000o(new hkp() {
            /* class _m_j.hkm.AnonymousClass1 */

            public final String O000000o() {
                return "default";
            }

            public final void O00000Oo() {
            }

            public final void O000000o(String str, hko hko) {
                String O000000o2 = hkn.O000000o(str);
                if (!TextUtils.isEmpty(O000000o2) && O000000o2.equals("init")) {
                    hkm hkm = hkm.this;
                    hkm.O00000o0 = true;
                    hkt hkt = hkm.f19016O000000o;
                    if (!hkt.O00000o0.isEmpty()) {
                        for (Object O000000o3 : hkt.O00000o0) {
                            hkt.O000000o(O000000o3);
                        }
                        hkt.O00000o0.clear();
                    }
                }
            }
        });
        for (hkr O000000o2 : new hks(this.O00000o).O00000Oo) {
            O000000o(O000000o2);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.O00000o0 = false;
    }

    public void onPageFinished(WebView webView, String str) {
        if (!this.O00000Oo && !this.O00000o0) {
            hkt hkt = this.f19016O000000o;
            String O000000o2 = hkn.O000000o();
            if (!TextUtils.isEmpty(O000000o2)) {
                StringBuilder sb = new StringBuilder(O000000o2);
                for (String next : hkt.O00000Oo.keySet()) {
                    sb.append(String.format("window.MJApi['%s'] = window.MJApi.createAPI('%s');", next, next));
                }
                sb.append(hkn.O00000Oo());
                hkt.O000000o("javascript:" + String.format("(function() { %s })();", sb.toString()));
            }
        }
    }

    public void onDestroy() {
        if (!this.O00000Oo) {
            this.O00000Oo = true;
            hkt hkt = this.f19016O000000o;
            if (!hkt.O00000Oo.isEmpty()) {
                for (Map.Entry<String, hkr> value : hkt.O00000Oo.entrySet()) {
                    hkr hkr = (hkr) value.getValue();
                    if (hkr != null) {
                        hkr.O00000Oo();
                    }
                }
            }
            if (hkt.O00000Oo != null) {
                hkt.O00000Oo.clear();
            }
            hkt.O00000Oo = null;
            hkt.f19021O000000o.clear();
            hkt.f19021O000000o = null;
            hkt.O00000o0.clear();
            hkt.O00000o0 = null;
            this.f19016O000000o = null;
        }
    }

    private void O000000o(hkr hkr) {
        if (!this.O00000Oo) {
            this.f19016O000000o.O000000o(hkr);
        }
    }

    @JavascriptInterface
    public void callJavaHandler(String str, String str2, String str3) {
        if (!this.O00000Oo) {
            hkt hkt = this.f19016O000000o;
            hkr hkr = hkt.O00000Oo.get(str);
            if (hkr != null) {
                hkr.O000000o(str2, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                      (r3v2 'hkr' _m_j.hkr)
                      (r4v0 'str2' java.lang.String)
                      (wrap: _m_j.hkt$1 : 0x0013: CONSTRUCTOR  (r1v1 _m_j.hkt$1) = (r0v1 'hkt' _m_j.hkt), (r5v0 'str3' java.lang.String) call: _m_j.hkt.1.<init>(_m_j.hkt, java.lang.String):void type: CONSTRUCTOR)
                     type: INTERFACE call: _m_j.hkr.O000000o(java.lang.String, _m_j.hko):void in method: _m_j.hkm.callJavaHandler(java.lang.String, java.lang.String, java.lang.String):void, dex: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR  (r1v1 _m_j.hkt$1) = (r0v1 'hkt' _m_j.hkt), (r5v0 'str3' java.lang.String) call: _m_j.hkt.1.<init>(_m_j.hkt, java.lang.String):void type: CONSTRUCTOR in method: _m_j.hkm.callJavaHandler(java.lang.String, java.lang.String, java.lang.String):void, dex: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 45 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: _m_j.hkt, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 51 more
                    */
                /*
                    this = this;
                    boolean r0 = r2.O00000Oo
                    if (r0 == 0) goto L_0x0005
                    return
                L_0x0005:
                    _m_j.hkt r0 = r2.f19016O000000o
                    java.util.Map<java.lang.String, _m_j.hkr> r1 = r0.O00000Oo
                    java.lang.Object r3 = r1.get(r3)
                    _m_j.hkr r3 = (_m_j.hkr) r3
                    if (r3 == 0) goto L_0x001a
                    _m_j.hkt$1 r1 = new _m_j.hkt$1
                    r1.<init>(r5)
                    r3.O000000o(r4, r1)
                    return
                L_0x001a:
                    com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData r3 = new com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackData
                    r3.<init>()
                    com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackStatus r4 = com.xiaomi.smarthome.operation.js_sdk.bridge.CallBackStatus.RESULT_CANCEL
                    r3.status = r4
                    r0.O000000o(r3, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: _m_j.hkm.callJavaHandler(java.lang.String, java.lang.String, java.lang.String):void");
            }

            @JavascriptInterface
            public void callJavaResponse(String str, String str2) {
                if (!this.O00000Oo) {
                    hkt hkt = this.f19016O000000o;
                    if (!TextUtils.isEmpty(str2)) {
                        hkt.f19021O000000o.get(str2).O000000o((CallBackData) new Gson().fromJson(str, CallBackData.class));
                        hkt.f19021O000000o.remove(str2);
                    }
                }
            }

            public final boolean O000000o() {
                return this.O00000Oo;
            }

            public final boolean O00000Oo() {
                return this.O00000o0;
            }
        }
