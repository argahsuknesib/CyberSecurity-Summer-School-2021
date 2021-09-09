package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import java.io.FileNotFoundException;

public final class PrintHelper {
    PrintHelperVersionImpl mImpl;

    public interface OnPrintFinishCallback {
        void onFinish();
    }

    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    static final class PrintHelperStubImpl implements PrintHelperVersionImpl {
        int mColorMode;
        int mOrientation;
        int mScaleMode;

        public final void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        public final void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        private PrintHelperStubImpl() {
            this.mScaleMode = 2;
            this.mColorMode = 2;
            this.mOrientation = 1;
        }

        public final void setScaleMode(int i) {
            this.mScaleMode = i;
        }

        public final int getColorMode() {
            return this.mColorMode;
        }

        public final void setColorMode(int i) {
            this.mColorMode = i;
        }

        public final void setOrientation(int i) {
            this.mOrientation = i;
        }

        public final int getOrientation() {
            return this.mOrientation;
        }

        public final int getScaleMode() {
            return this.mScaleMode;
        }
    }

    static class PrintHelperImpl<RealHelper extends PrintHelperKitkat> implements PrintHelperVersionImpl {
        private final RealHelper mPrintHelper;

        protected PrintHelperImpl(RealHelper realhelper) {
            this.mPrintHelper = realhelper;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: RealHelper
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void setScaleMode(int r2) {
            /*
                r1 = this;
                RealHelper r0 = r1.mPrintHelper
                r0.setScaleMode(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperImpl.setScaleMode(int):void");
        }

        public int getScaleMode() {
            return this.mPrintHelper.getScaleMode();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: RealHelper
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void setColorMode(int r2) {
            /*
                r1 = this;
                RealHelper r0 = r1.mPrintHelper
                r0.setColorMode(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperImpl.setColorMode(int):void");
        }

        public int getColorMode() {
            return this.mPrintHelper.getColorMode();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: RealHelper
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void setOrientation(int r2) {
            /*
                r1 = this;
                RealHelper r0 = r1.mPrintHelper
                r0.setOrientation(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperImpl.setOrientation(int):void");
        }

        public int getOrientation() {
            return this.mPrintHelper.getOrientation();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: RealHelper
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void printBitmap(java.lang.String r2, android.graphics.Bitmap r3, final android.support.v4.print.PrintHelper.OnPrintFinishCallback r4) {
            /*
                r1 = this;
                if (r4 == 0) goto L_0x0008
                android.support.v4.print.PrintHelper$PrintHelperImpl$1 r0 = new android.support.v4.print.PrintHelper$PrintHelperImpl$1
                r0.<init>(r4)
                goto L_0x0009
            L_0x0008:
                r0 = 0
            L_0x0009:
                RealHelper r4 = r1.mPrintHelper
                r4.printBitmap(r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperImpl.printBitmap(java.lang.String, android.graphics.Bitmap, android.support.v4.print.PrintHelper$OnPrintFinishCallback):void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: RealHelper
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public void printBitmap(java.lang.String r2, android.net.Uri r3, final android.support.v4.print.PrintHelper.OnPrintFinishCallback r4) throws java.io.FileNotFoundException {
            /*
                r1 = this;
                if (r4 == 0) goto L_0x0008
                android.support.v4.print.PrintHelper$PrintHelperImpl$2 r0 = new android.support.v4.print.PrintHelper$PrintHelperImpl$2
                r0.<init>(r4)
                goto L_0x0009
            L_0x0008:
                r0 = 0
            L_0x0009:
                RealHelper r4 = r1.mPrintHelper
                r4.printBitmap(r2, r3, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.print.PrintHelper.PrintHelperImpl.printBitmap(java.lang.String, android.net.Uri, android.support.v4.print.PrintHelper$OnPrintFinishCallback):void");
        }
    }

    static final class PrintHelperKitkatImpl extends PrintHelperImpl<PrintHelperKitkat> {
        PrintHelperKitkatImpl(Context context) {
            super(new PrintHelperKitkat(context));
        }
    }

    static final class PrintHelperApi20Impl extends PrintHelperImpl<PrintHelperApi20> {
        PrintHelperApi20Impl(Context context) {
            super(new PrintHelperApi20(context));
        }
    }

    static final class PrintHelperApi23Impl extends PrintHelperImpl<PrintHelperApi23> {
        PrintHelperApi23Impl(Context context) {
            super(new PrintHelperApi23(context));
        }
    }

    static final class PrintHelperApi24Impl extends PrintHelperImpl<PrintHelperApi24> {
        PrintHelperApi24Impl(Context context) {
            super(new PrintHelperApi24(context));
        }
    }

    public PrintHelper(Context context) {
        if (!systemSupportsPrint()) {
            this.mImpl = new PrintHelperStubImpl();
        } else if (Build.VERSION.SDK_INT >= 24) {
            this.mImpl = new PrintHelperApi24Impl(context);
        } else if (Build.VERSION.SDK_INT >= 23) {
            this.mImpl = new PrintHelperApi23Impl(context);
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.mImpl = new PrintHelperApi20Impl(context);
        } else {
            this.mImpl = new PrintHelperKitkatImpl(context);
        }
    }

    public final void setScaleMode(int i) {
        this.mImpl.setScaleMode(i);
    }

    public final int getScaleMode() {
        return this.mImpl.getScaleMode();
    }

    public final void setColorMode(int i) {
        this.mImpl.setColorMode(i);
    }

    public final int getColorMode() {
        return this.mImpl.getColorMode();
    }

    public final void setOrientation(int i) {
        this.mImpl.setOrientation(i);
    }

    public final int getOrientation() {
        return this.mImpl.getOrientation();
    }

    public final void printBitmap(String str, Bitmap bitmap) {
        this.mImpl.printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public final void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.mImpl.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public final void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    public final void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.mImpl.printBitmap(str, uri, onPrintFinishCallback);
    }
}
