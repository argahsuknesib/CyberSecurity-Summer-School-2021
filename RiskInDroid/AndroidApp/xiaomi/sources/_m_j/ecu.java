package _m_j;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.RepeatedFieldBuilder;
import com.xiaomi.mobilestats.data.ProtoMsg$StatsMsg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ecu extends GeneratedMessage.Builder implements ecv {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15174O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private ecu() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private ecu(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ ecu(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecu mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.ClientMsg clientMsg;
        ProtoMsg$StatsMsg.ClientMsg clientMsg2 = null;
        try {
            ProtoMsg$StatsMsg.ClientMsg clientMsg3 = (ProtoMsg$StatsMsg.ClientMsg) ProtoMsg$StatsMsg.ClientMsg.f6060O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (clientMsg3 != null) {
                O000000o(clientMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            clientMsg = (ProtoMsg$StatsMsg.ClientMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            clientMsg2 = clientMsg;
        }
        if (clientMsg2 != null) {
            O000000o(clientMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecu mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.ClientMsg) {
            return O000000o((ProtoMsg$StatsMsg.ClientMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ecu clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15174O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.ClientMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.ClientMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.ClientMsg clientMsg = new ProtoMsg$StatsMsg.ClientMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15174O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15174O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = clientMsg.bo = list;
        onBuilt();
        return clientMsg;
    }

    private void O0000O0o() {
        if ((this.f15174O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15174O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15174O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final ecu O000000o(ProtoMsg$StatsMsg.Client client) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(client);
        } else if (client != null) {
            O0000O0o();
            this.O00000Oo.add(client);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final ecu O000000o(ProtoMsg$StatsMsg.ClientMsg clientMsg) {
        if (clientMsg == ProtoMsg$StatsMsg.ClientMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!clientMsg.bo.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = clientMsg.bo;
                    this.f15174O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(clientMsg.bo);
                }
                onChanged();
            }
        } else if (!clientMsg.bo.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = clientMsg.bo;
                this.f15174O000000o &= -2;
                if (ProtoMsg$StatsMsg.ClientMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(clientMsg.bo);
            }
        }
        mergeUnknownFields(clientMsg.getUnknownFields());
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.ClientMsg build() {
        ProtoMsg$StatsMsg.ClientMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000o0O;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000o0o.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.ClientMsg.class, ecu.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ecu clone() {
        return new ecu().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.Client) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ ecu O00000Oo() {
        return new ecu();
    }
}
