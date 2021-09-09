package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private GeneratedMessage.BuilderParent parent;

    public SingleFieldBuilder(MType mtype, GeneratedMessage.BuilderParent builderParent, boolean z) {
        this.message = (GeneratedMessage) Internal.checkNotNull(mtype);
        this.parent = builderParent;
        this.isClean = z;
    }

    public void dispose() {
        this.parent = null;
    }

    public MType getMessage() {
        if (this.message == null) {
            this.message = (GeneratedMessage) this.builder.buildPartial();
        }
        return this.message;
    }

    public MType build() {
        this.isClean = true;
        return getMessage();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: MType
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
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public BType getBuilder() {
        /*
            r2 = this;
            BType r0 = r2.builder
            if (r0 != 0) goto L_0x001a
            MType r0 = r2.message
            com.google.protobuf.Message$Builder r0 = r0.newBuilderForType(r2)
            com.google.protobuf.GeneratedMessage$Builder r0 = (com.google.protobuf.GeneratedMessage.Builder) r0
            r2.builder = r0
            BType r0 = r2.builder
            MType r1 = r2.message
            r0.mergeFrom(r1)
            BType r0 = r2.builder
            r0.markClean()
        L_0x001a:
            BType r0 = r2.builder
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.SingleFieldBuilder.getBuilder():com.google.protobuf.GeneratedMessage$Builder");
    }

    public IType getMessageOrBuilder() {
        Object obj = this.builder;
        if (obj != null) {
            return obj;
        }
        return this.message;
    }

    public SingleFieldBuilder<MType, BType, IType> setMessage(MType mtype) {
        this.message = (GeneratedMessage) Internal.checkNotNull(mtype);
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    public SingleFieldBuilder<MType, BType, IType> mergeFrom(MType mtype) {
        if (this.builder == null) {
            MType mtype2 = this.message;
            if (mtype2 == mtype2.getDefaultInstanceForType()) {
                this.message = mtype;
                onChanged();
                return this;
            }
        }
        getBuilder().mergeFrom((Message) mtype);
        onChanged();
        return this;
    }

    public SingleFieldBuilder<MType, BType, IType> clear() {
        MType mtype;
        MType mtype2 = this.message;
        if (mtype2 != null) {
            mtype = mtype2.getDefaultInstanceForType();
        } else {
            mtype = this.builder.getDefaultInstanceForType();
        }
        this.message = (GeneratedMessage) mtype;
        BType btype = this.builder;
        if (btype != null) {
            btype.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    private void onChanged() {
        GeneratedMessage.BuilderParent builderParent;
        if (this.builder != null) {
            this.message = null;
        }
        if (this.isClean && (builderParent = this.parent) != null) {
            builderParent.markDirty();
            this.isClean = false;
        }
    }

    public void markDirty() {
        onChanged();
    }
}
