package com.transitionseverywhere;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:608)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:241)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:122)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:43)
    */
@TargetApi(14)
public class ChangeScroll extends Transition {
    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: com.transitionseverywhere.Transition.<init>():void in method: com.transitionseverywhere.ChangeScroll.<init>():void, dex: classes4.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: com.transitionseverywhere.Transition.<init>():void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:534)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public ChangeScroll() {
        /*
            r0 = this;
            r0.<init>()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.ChangeScroll.<init>():void");
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
