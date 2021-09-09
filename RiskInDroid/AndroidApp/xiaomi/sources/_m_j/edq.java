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

public final class edq extends GeneratedMessage.Builder implements edr {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15186O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private edq() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private edq(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ edq(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.ViewMsg viewMsg;
        ProtoMsg$StatsMsg.ViewMsg viewMsg2 = null;
        try {
            ProtoMsg$StatsMsg.ViewMsg viewMsg3 = (ProtoMsg$StatsMsg.ViewMsg) ProtoMsg$StatsMsg.ViewMsg.f6072O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (viewMsg3 != null) {
                O000000o(viewMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            viewMsg = (ProtoMsg$StatsMsg.ViewMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            viewMsg2 = viewMsg;
        }
        if (viewMsg2 != null) {
            O000000o(viewMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edq mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.ViewMsg) {
            return O000000o((ProtoMsg$StatsMsg.ViewMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edq clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15186O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.ViewMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.ViewMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.ViewMsg viewMsg = new ProtoMsg$StatsMsg.ViewMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15186O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15186O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = viewMsg.cA = list;
        onBuilt();
        return viewMsg;
    }

    private void O0000O0o() {
        if ((this.f15186O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15186O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15186O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final edq O000000o(ProtoMsg$StatsMsg.View view) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(view);
        } else if (view != null) {
            O0000O0o();
            this.O00000Oo.add(view);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final edq O000000o(ProtoMsg$StatsMsg.ViewMsg viewMsg) {
        if (viewMsg == ProtoMsg$StatsMsg.ViewMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!viewMsg.cA.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = viewMsg.cA;
                    this.f15186O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(viewMsg.cA);
                }
                onChanged();
            }
        } else if (!viewMsg.cA.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = viewMsg.cA;
                this.f15186O000000o &= -2;
                if (ProtoMsg$StatsMsg.ViewMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(viewMsg.cA);
            }
        }
        mergeUnknownFields(viewMsg.getUnknownFields());
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.ViewMsg build() {
        ProtoMsg$StatsMsg.ViewMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O000O0OO;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O000O0Oo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.ViewMsg.class, edq.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public edq clone() {
        return new edq().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.View) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ edq O00000Oo() {
        return new edq();
    }
}
