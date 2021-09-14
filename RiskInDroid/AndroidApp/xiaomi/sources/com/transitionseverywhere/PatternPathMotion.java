package com.transitionseverywhere;

import _m_j.drd;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import com.xiaomi.smarthome.R;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:608)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:241)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:122)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:43)
    */
public class PatternPathMotion extends PathMotion {
    private Path O00000Oo;
    private final Matrix O00000o;
    private final Path O00000o0;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: com.transitionseverywhere.PathMotion.<init>():void in method: com.transitionseverywhere.PatternPathMotion.<init>():void, dex: classes4.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: com.transitionseverywhere.PathMotion.<init>():void
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:534)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public PatternPathMotion() {
        /*
            r3 = this;
            r3.<init>()
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r3.O00000o0 = r0
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            r3.O00000o = r0
            android.graphics.Path r0 = r3.O00000o0
            r1 = 1065353216(0x3f800000, float:1.0)
            r2 = 0
            r0.lineTo(r1, r2)
            android.graphics.Path r0 = r3.O00000o0
            r3.O00000Oo = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.PatternPathMotion.<init>():void");
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.O00000o0 = new Path();
        this.O00000o = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.patternPathData});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Path O000000o2 = drd.O000000o(string);
                PathMeasure pathMeasure = new PathMeasure(O000000o2, false);
                float[] fArr = new float[2];
                pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
                float f = fArr[0];
                float f2 = fArr[1];
                pathMeasure.getPosTan(0.0f, fArr, null);
                float f3 = fArr[0];
                float f4 = fArr[1];
                if (f3 == f) {
                    if (f4 == f2) {
                        throw new IllegalArgumentException("pattern must not end at the starting point");
                    }
                }
                this.O00000o.setTranslate(-f3, -f4);
                float f5 = f2 - f4;
                double d = (double) (f - f3);
                double d2 = (double) f5;
                float hypot = 1.0f / ((float) Math.hypot(d, d2));
                this.O00000o.postScale(hypot, hypot);
                this.O00000o.postRotate((float) Math.toDegrees(-Math.atan2(d2, d)));
                O000000o2.transform(this.O00000o, this.O00000o0);
                this.O00000Oo = O000000o2;
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
