package com.transitionseverywhere;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:608)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:241)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:122)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:43)
    */
@TargetApi(14)
public abstract class Visibility extends Transition {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String[] f5912O000000o = {"android:visibility:visibility", "android:visibility:parent"};
    private int O00000Oo;
    private int O00000o0;
    int O00oOoOo;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: com.transitionseverywhere.Transition.<init>():void in method: com.transitionseverywhere.Visibility.<init>():void, dex: classes4.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: com.transitionseverywhere.Transition.<init>():void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:534)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 6 more
        */
    public Visibility() {
        /*
            r1 = this;
            r1.<init>()
            r0 = 3
            r1.O00oOoOo = r0
            r0 = -1
            r1.O00000Oo = r0
            r1.O00000o0 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Visibility.<init>():void");
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00oOoOo = 3;
        this.O00000Oo = -1;
        this.O00000o0 = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.transitionVisibilityMode});
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            O000000o(i);
        }
    }

    public final Visibility O000000o(int i) {
        if ((i & -4) == 0) {
            this.O00oOoOo = i;
            return this;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}
