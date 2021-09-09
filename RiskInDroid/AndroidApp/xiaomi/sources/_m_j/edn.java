package _m_j;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;

public final class edn extends GeneratedMessage.Builder implements edo {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15184O000000o;
    private Object O00000Oo;
    private Object O00000o0;

    public /* synthetic */ edn(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edn mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.ProtoMap protoMap;
        ProtoMsg$StatsMsg.ProtoMap protoMap2 = null;
        try {
            ProtoMsg$StatsMsg.ProtoMap protoMap3 = (ProtoMsg$StatsMsg.ProtoMap) ProtoMsg$StatsMsg.ProtoMap.f6069O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (protoMap3 != null) {
                O000000o(protoMap3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            protoMap = (ProtoMsg$StatsMsg.ProtoMap) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            protoMap2 = protoMap;
        }
        if (protoMap2 != null) {
            O000000o(protoMap2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edn mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.ProtoMap) {
            return O000000o((ProtoMsg$StatsMsg.ProtoMap) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public edn clear() {
        super.clear();
        this.O00000Oo = "";
        this.f15184O000000o &= -2;
        this.O00000o0 = "";
        this.f15184O000000o &= -3;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ProtoMsg$StatsMsg.ProtoMap buildPartial() {
        int i = 0;
        ProtoMsg$StatsMsg.ProtoMap protoMap = new ProtoMsg$StatsMsg.ProtoMap(this, (byte) 0);
        int i2 = this.f15184O000000o;
        if ((i2 & 1) == 1) {
            i = 1;
        }
        Object unused = protoMap.bg = this.O00000Oo;
        if ((i2 & 2) == 2) {
            i |= 2;
        }
        Object unused2 = protoMap.f6070cn = this.O00000o0;
        int unused3 = protoMap.aA = i;
        onBuilt();
        return protoMap;
    }

    public final edn O000000o(ProtoMsg$StatsMsg.ProtoMap protoMap) {
        if (protoMap == ProtoMsg$StatsMsg.ProtoMap.O000000o()) {
            return this;
        }
        if (protoMap.O00000Oo()) {
            this.f15184O000000o |= 1;
            this.O00000Oo = protoMap.bg;
            onChanged();
        }
        if (protoMap.O00000o0()) {
            this.f15184O000000o |= 2;
            this.O00000o0 = protoMap.f6070cn;
            onChanged();
        }
        mergeUnknownFields(protoMap.getUnknownFields());
        return this;
    }

    public final edn O000000o(String str) {
        if (str != null) {
            this.f15184O000000o |= 1;
            this.O00000Oo = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.ProtoMap build() {
        ProtoMsg$StatsMsg.ProtoMap O00000oO = buildPartial();
        if (O00000oO.isInitialized()) {
            return O00000oO;
        }
        throw newUninitializedMessageException((Message) O00000oO);
    }

    public final edn O00000Oo(String str) {
        if (str != null) {
            this.f15184O000000o |= 2;
            this.O00000o0 = str;
            onChanged();
            return this;
        }
        throw new NullPointerException();
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O00000o0;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O00000o.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.ProtoMap.class, edn.class);
    }

    private edn() {
        this.O00000Oo = "";
        this.O00000o0 = "";
        boolean unused = ProtoMsg$StatsMsg.ProtoMap.alwaysUseFieldBuilders;
    }

    private edn(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = "";
        this.O00000o0 = "";
        boolean unused = ProtoMsg$StatsMsg.ProtoMap.alwaysUseFieldBuilders;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edn clone() {
        return new edn().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        if (!((this.f15184O000000o & 1) == 1)) {
            return false;
        }
        return (this.f15184O000000o & 2) == 2;
    }

    public static /* synthetic */ edn O00000Oo() {
        return new edn();
    }
}
