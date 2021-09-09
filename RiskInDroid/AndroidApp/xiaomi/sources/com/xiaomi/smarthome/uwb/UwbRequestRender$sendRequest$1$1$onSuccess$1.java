package com.xiaomi.smarthome.uwb;

import _m_j.fsm;
import _m_j.fso;
import _m_j.ixe;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n"}, d2 = {"com/xiaomi/smarthome/uwb/UwbRequestRender$sendRequest$1$1$onSuccess$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "", "Lcom/xiaomi/smarthome/device/api/spec/operation/PropertyParam;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-card_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbRequestRender$sendRequest$1$1$onSuccess$1 extends fsm<List<PropertyParam>, fso> {
    final /* synthetic */ E $cardItem;
    final /* synthetic */ Device $device;
    final /* synthetic */ T $prop;
    final /* synthetic */ Ref.ObjectRef<Object> $propValue;
    final /* synthetic */ List<PropertyParam> $transformParam;
    final /* synthetic */ UwbRequestRender<C, E, T> this$0;

    UwbRequestRender$sendRequest$1$1$onSuccess$1(E e, Device device, T t, Ref.ObjectRef<Object> objectRef, UwbRequestRender<C, E, T> uwbRequestRender, List<PropertyParam> list) {
        this.$cardItem = e;
        this.$device = device;
        this.$prop = t;
        this.$propValue = objectRef;
        this.this$0 = uwbRequestRender;
        this.$transformParam = list;
    }

    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        onSuccess((List<PropertyParam>) ((List) obj));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: E
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final void onSuccess(java.util.List<com.xiaomi.smarthome.device.api.spec.operation.PropertyParam> r5) {
        /*
            r4 = this;
            E r5 = r4.$cardItem
            if (r5 != 0) goto L_0x0006
            r5 = 0
            goto L_0x000e
        L_0x0006:
            com.xiaomi.smarthome.device.Device r0 = r4.$device
            T r1 = r4.$prop
            java.lang.Object r5 = r5.O00000Oo(r0, r1)
        L_0x000e:
            if (r5 == 0) goto L_0x001a
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r0 = r4.$propValue
            T r0 = r0.element
            boolean r5 = _m_j.ixe.O000000o(r5, r0)
            if (r5 == 0) goto L_0x002e
        L_0x001a:
            android.os.Handler r5 = com.xiaomi.smarthome.application.CommonApplication.getGlobalHandler()
            com.xiaomi.smarthome.uwb.UwbRequestRender<C, E, T> r0 = r4.this$0
            com.xiaomi.smarthome.device.Device r1 = r4.$device
            java.util.List<com.xiaomi.smarthome.device.api.spec.operation.PropertyParam> r2 = r4.$transformParam
            com.xiaomi.smarthome.uwb.-$$Lambda$UwbRequestRender$sendRequest$1$1$onSuccess$1$OyoBqLMISBOAgTTD0T-vCu8uNnw r3 = new com.xiaomi.smarthome.uwb.-$$Lambda$UwbRequestRender$sendRequest$1$1$onSuccess$1$OyoBqLMISBOAgTTD0T-vCu8uNnw
            r3.<init>(r0, r1, r2)
            r0 = 1000(0x3e8, double:4.94E-321)
            r5.postDelayed(r3, r0)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.uwb.UwbRequestRender$sendRequest$1$1$onSuccess$1.onSuccess(java.util.List):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0  reason: not valid java name */
    public static final void m517onSuccess$lambda0(UwbRequestRender uwbRequestRender, Device device, List list) {
        ixe.O00000o(uwbRequestRender, "this$0");
        uwbRequestRender.getSpecPropsFromServer(false, device, list, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onFailure$lambda-1  reason: not valid java name */
    public static final void m516onFailure$lambda1(UwbRequestRender uwbRequestRender, Device device, List list) {
        ixe.O00000o(uwbRequestRender, "this$0");
        uwbRequestRender.getSpecPropsFromServer(false, device, list, null);
    }

    public final void onFailure(fso fso) {
        CommonApplication.getGlobalHandler().postDelayed(new Runnable(this.$device, this.$transformParam) {
            /* class com.xiaomi.smarthome.uwb.$$Lambda$UwbRequestRender$sendRequest$1$1$onSuccess$1$ytdC3y0LznEV_NZWmgknT8P1ByY */
            private final /* synthetic */ Device f$1;
            private final /* synthetic */ List f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                UwbRequestRender$sendRequest$1$1$onSuccess$1.m516onFailure$lambda1(UwbRequestRender.this, this.f$1, this.f$2);
            }
        }, 1000);
    }
}
