package com.xiaomi.smarthome.wificonfig;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fsm;
import _m_j.fso;
import _m_j.hna;
import _m_j.inc;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.qrcode.ScanBarcodeActivity;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.FDDeviceApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.List;
import org.json.JSONObject;

public class ScanBarcodeConnectActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f12015O000000o;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.scan_barcode_connect_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ScanBarcodeConnectActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mj_scan_barcode);
        hna.O000000o().checkPassedForCamera(this, true, new inc() {
            /* class com.xiaomi.smarthome.wificonfig.$$Lambda$ScanBarcodeConnectActivity$ZT2SieoqtCBY91ETM6BGsTzUvuI */

            public final void onAction(List list) {
                ScanBarcodeConnectActivity.this.O000000o(list);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list) {
        Intent intent = new Intent();
        intent.setClass(this, ScanBarcodeActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("scan_result");
            O000000o();
            this.f12015O000000o = XQProgressDialog.O000000o(this, "", getString(R.string.camera_waiting));
            this.f12015O000000o.show();
            FDDeviceApi.getInstance().verifyQrcode(this, stringExtra, null, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    ScanBarcodeConnectActivity.this.O000000o();
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("model");
                        String optString2 = jSONObject.optString("ssid");
                        String optString3 = jSONObject.optString("bssid");
                        fbt fbt = new fbt(ScanBarcodeConnectActivity.this.getContext(), "SmartConfigMainActivity");
                        if (ScanBarcodeConnectActivity.this.getIntent() != null) {
                            fbt.O000000o("connect_source", ScanBarcodeConnectActivity.this.getIntent().getIntExtra("connect_source", 0));
                            fbt.O000000o("connect_unique", ScanBarcodeConnectActivity.this.getIntent().getStringExtra("connect_unique"));
                        }
                        fbt.O000000o("scan_device_model", optString).O000000o("ssid", optString2).O000000o("bssid", optString3).O000000o("model", optString).O000000o("strategy_id", 5);
                        fbs.O000000o(fbt);
                        ScanBarcodeConnectActivity.this.finish();
                    }
                }

                public final void onFailure(fso fso) {
                    ScanBarcodeConnectActivity.this.O000000o();
                    String string = ScanBarcodeConnectActivity.this.getContext().getString(R.string.barcode_bind_error, fso.O00000Oo);
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(ScanBarcodeConnectActivity.this.getContext());
                    builder.O00000Oo(string);
                    builder.O000000o((int) R.string.mj_retry, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            hna.O000000o().checkPassedForCamera(ScanBarcodeConnectActivity.this, true, 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
                                  (wrap: _m_j.hmu : 0x0000: INVOKE  (r3v1 _m_j.hmu) =  type: STATIC call: _m_j.hna.O000000o():_m_j.hmu)
                                  (wrap: com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity : 0x0006: IGET  (r4v2 com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity) = 
                                  (wrap: com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2 : 0x0004: IGET  (r4v1 com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2) = (r2v0 'this' com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2$1 A[THIS]) com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.2.1.O000000o com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2)
                                 com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.2.O000000o com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity)
                                  true
                                  (wrap: com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs : 0x000a: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs) = (r2v0 'this' com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2$1 A[THIS]) call: com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs.<init>(com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2$1):void type: CONSTRUCTOR)
                                 type: INTERFACE call: _m_j.hmu.checkPassedForCamera(android.app.Activity, boolean, _m_j.inc):void in method: com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.2.1.onClick(android.content.DialogInterface, int):void, dex: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v0 com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs) = (r2v0 'this' com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2$1 A[THIS]) call: com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs.<init>(com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.2.1.onClick(android.content.DialogInterface, int):void, dex: classes5.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 106 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 112 more
                                */
                            /*
                                this = this;
                                _m_j.hmu r3 = _m_j.hna.O000000o()
                                com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity$2 r4 = com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass2.this
                                com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity r4 = com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.this
                                com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs r0 = new com.xiaomi.smarthome.wificonfig.-$$Lambda$ScanBarcodeConnectActivity$2$1$BTStOyIL7STBN1Si0vSBbhsvTFs
                                r0.<init>(r2)
                                r1 = 1
                                r3.checkPassedForCamera(r4, r1, r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass2.AnonymousClass1.onClick(android.content.DialogInterface, int):void");
                        }

                        /* access modifiers changed from: private */
                        public /* synthetic */ void O000000o(List list) {
                            Intent intent = new Intent();
                            intent.setClass(ScanBarcodeConnectActivity.this, ScanBarcodeActivity.class);
                            ScanBarcodeConnectActivity.this.startActivityForResult(intent, 1);
                        }
                    });
                    builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.wificonfig.ScanBarcodeConnectActivity.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ScanBarcodeConnectActivity.this.finish();
                        }
                    });
                    builder.O00000oo();
                }
            });
            return;
        }
        finish();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        XQProgressDialog xQProgressDialog = this.f12015O000000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.f12015O000000o = null;
        }
    }
}
