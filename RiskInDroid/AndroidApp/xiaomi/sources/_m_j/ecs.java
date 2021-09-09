package _m_j;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;

public final class ecs extends GeneratedMessage.Builder implements edt {
    public /* synthetic */ ecs(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg protoMsg$StatsMsg;
        ProtoMsg$StatsMsg protoMsg$StatsMsg2 = null;
        try {
            ProtoMsg$StatsMsg protoMsg$StatsMsg3 = (ProtoMsg$StatsMsg) ProtoMsg$StatsMsg.f6058O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (protoMsg$StatsMsg3 != null) {
                O000000o(protoMsg$StatsMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            protoMsg$StatsMsg = (ProtoMsg$StatsMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            protoMsg$StatsMsg2 = protoMsg$StatsMsg;
        }
        if (protoMsg$StatsMsg2 != null) {
            O000000o(protoMsg$StatsMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecs mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg) {
            return O000000o((ProtoMsg$StatsMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ProtoMsg$StatsMsg buildPartial() {
        ProtoMsg$StatsMsg protoMsg$StatsMsg = new ProtoMsg$StatsMsg(this, (byte) 0);
        onBuilt();
        return protoMsg$StatsMsg;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o0 */
    public ProtoMsg$StatsMsg build() {
        ProtoMsg$StatsMsg O00000o = buildPartial();
        if (O00000o.isInitialized()) {
            return O00000o;
        }
        throw newUninitializedMessageException((Message) O00000o);
    }

    public final ecs O000000o(ProtoMsg$StatsMsg protoMsg$StatsMsg) {
        if (protoMsg$StatsMsg == ProtoMsg$StatsMsg.O000000o()) {
            return this;
        }
        mergeUnknownFields(protoMsg$StatsMsg.getUnknownFields());
        return this;
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.f15172O000000o;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O00000Oo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.class, ecs.class);
    }

    public final boolean isInitialized() {
        return true;
    }

    private ecs() {
        boolean unused = ProtoMsg$StatsMsg.alwaysUseFieldBuilders;
    }

    private ecs(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        boolean unused = ProtoMsg$StatsMsg.alwaysUseFieldBuilders;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000Oo */
    public ecs clone() {
        return new ecs().O000000o(buildPartial());
    }

    public static /* synthetic */ ecs O000000o() {
        return new ecs();
    }
}
