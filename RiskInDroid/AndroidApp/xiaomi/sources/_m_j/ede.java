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

public final class ede extends GeneratedMessage.Builder implements edf {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15180O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private ede() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private ede(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ ede(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ede mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.EventMsg eventMsg;
        ProtoMsg$StatsMsg.EventMsg eventMsg2 = null;
        try {
            ProtoMsg$StatsMsg.EventMsg eventMsg3 = (ProtoMsg$StatsMsg.EventMsg) ProtoMsg$StatsMsg.EventMsg.f6065O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (eventMsg3 != null) {
                O000000o(eventMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            eventMsg = (ProtoMsg$StatsMsg.EventMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            eventMsg2 = eventMsg;
        }
        if (eventMsg2 != null) {
            O000000o(eventMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ede mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.EventMsg) {
            return O000000o((ProtoMsg$StatsMsg.EventMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ede clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15180O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.EventMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.EventMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.EventMsg eventMsg = new ProtoMsg$StatsMsg.EventMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15180O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15180O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = eventMsg.bO = list;
        onBuilt();
        return eventMsg;
    }

    private void O0000O0o() {
        if ((this.f15180O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15180O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15180O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final ede O000000o(ProtoMsg$StatsMsg.Event event) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(event);
        } else if (event != null) {
            O0000O0o();
            this.O00000Oo.add(event);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final ede O000000o(ProtoMsg$StatsMsg.EventMsg eventMsg) {
        if (eventMsg == ProtoMsg$StatsMsg.EventMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!eventMsg.bO.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = eventMsg.bO;
                    this.f15180O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(eventMsg.bO);
                }
                onChanged();
            }
        } else if (!eventMsg.bO.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = eventMsg.bO;
                this.f15180O000000o &= -2;
                if (ProtoMsg$StatsMsg.EventMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(eventMsg.bO);
            }
        }
        mergeUnknownFields(eventMsg.getUnknownFields());
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.EventMsg build() {
        ProtoMsg$StatsMsg.EventMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000OoO;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000Ooo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.EventMsg.class, ede.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ede clone() {
        return new ede().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.Event) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ ede O00000Oo() {
        return new ede();
    }
}
