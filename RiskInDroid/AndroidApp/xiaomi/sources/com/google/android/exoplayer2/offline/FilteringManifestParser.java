package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.util.List;

public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {
    private final ParsingLoadable.Parser<? extends T> parser;
    private final List<StreamKey> streamKeys;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser2, List<StreamKey> list) {
        this.parser = parser2;
        this.streamKeys = list;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: T
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final T parse(android.net.Uri r2, java.io.InputStream r3) throws java.io.IOException {
        /*
            r1 = this;
            com.google.android.exoplayer2.upstream.ParsingLoadable$Parser<? extends T> r0 = r1.parser
            java.lang.Object r2 = r0.parse(r2, r3)
            com.google.android.exoplayer2.offline.FilterableManifest r2 = (com.google.android.exoplayer2.offline.FilterableManifest) r2
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r3 = r1.streamKeys
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0013
            goto L_0x001b
        L_0x0013:
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r3 = r1.streamKeys
            java.lang.Object r2 = r2.copy(r3)
            com.google.android.exoplayer2.offline.FilterableManifest r2 = (com.google.android.exoplayer2.offline.FilterableManifest) r2
        L_0x001b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.FilteringManifestParser.parse(android.net.Uri, java.io.InputStream):com.google.android.exoplayer2.offline.FilterableManifest");
    }
}
