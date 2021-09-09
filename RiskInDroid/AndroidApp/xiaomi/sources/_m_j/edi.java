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

public final class edi extends GeneratedMessage.Builder implements edj {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15182O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private edi() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private edi(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ edi(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edi mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.PageMsg pageMsg;
        ProtoMsg$StatsMsg.PageMsg pageMsg2 = null;
        try {
            ProtoMsg$StatsMsg.PageMsg pageMsg3 = (ProtoMsg$StatsMsg.PageMsg) ProtoMsg$StatsMsg.PageMsg.f6067O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (pageMsg3 != null) {
                O000000o(pageMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            pageMsg = (ProtoMsg$StatsMsg.PageMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            pageMsg2 = pageMsg;
        }
        if (pageMsg2 != null) {
            O000000o(pageMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edi mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.PageMsg) {
            return O000000o((ProtoMsg$StatsMsg.PageMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edi clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15182O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.PageMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.PageMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.PageMsg pageMsg = new ProtoMsg$StatsMsg.PageMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15182O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15182O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = pageMsg.cb = list;
        onBuilt();
        return pageMsg;
    }

    private void O0000O0o() {
        if ((this.f15182O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15182O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15182O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final edi O000000o(edh edh) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            O0000O0o();
            this.O00000Oo.add(edh.build());
            onChanged();
        } else {
            repeatedFieldBuilder.addMessage(edh.build());
        }
        return this;
    }

    public final edi O000000o(ProtoMsg$StatsMsg.Page page) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(page);
        } else if (page != null) {
            O0000O0o();
            this.O00000Oo.add(page);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final edi O000000o(ProtoMsg$StatsMsg.PageMsg pageMsg) {
        if (pageMsg == ProtoMsg$StatsMsg.PageMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!pageMsg.cb.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = pageMsg.cb;
                    this.f15182O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(pageMsg.cb);
                }
                onChanged();
            }
        } else if (!pageMsg.cb.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = pageMsg.cb;
                this.f15182O000000o &= -2;
                if (ProtoMsg$StatsMsg.PageMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(pageMsg.cb);
            }
        }
        mergeUnknownFields(pageMsg.getUnknownFields());
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.PageMsg build() {
        ProtoMsg$StatsMsg.PageMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000O0o;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000OOo.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.PageMsg.class, edi.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public edi clone() {
        return new edi().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.Page) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ edi O00000Oo() {
        return new edi();
    }
}
