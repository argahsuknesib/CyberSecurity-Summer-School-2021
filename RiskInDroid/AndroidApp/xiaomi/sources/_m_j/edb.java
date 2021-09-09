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

public final class edb extends GeneratedMessage.Builder implements edc {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15178O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private edb() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private edb(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ edb(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edb mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.ErrorMsg errorMsg;
        ProtoMsg$StatsMsg.ErrorMsg errorMsg2 = null;
        try {
            ProtoMsg$StatsMsg.ErrorMsg errorMsg3 = (ProtoMsg$StatsMsg.ErrorMsg) ProtoMsg$StatsMsg.ErrorMsg.f6063O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (errorMsg3 != null) {
                O000000o(errorMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            errorMsg = (ProtoMsg$StatsMsg.ErrorMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            errorMsg2 = errorMsg;
        }
        if (errorMsg2 != null) {
            O000000o(errorMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public edb mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.ErrorMsg) {
            return O000000o((ProtoMsg$StatsMsg.ErrorMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public edb clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15178O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.ErrorMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.ErrorMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.ErrorMsg errorMsg = new ProtoMsg$StatsMsg.ErrorMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15178O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15178O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = errorMsg.bG = list;
        onBuilt();
        return errorMsg;
    }

    private void O0000O0o() {
        if ((this.f15178O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15178O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15178O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final edb O000000o(ProtoMsg$StatsMsg.ErrorMsg errorMsg) {
        if (errorMsg == ProtoMsg$StatsMsg.ErrorMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!errorMsg.bG.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = errorMsg.bG;
                    this.f15178O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(errorMsg.bG);
                }
                onChanged();
            }
        } else if (!errorMsg.bG.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = errorMsg.bG;
                this.f15178O000000o &= -2;
                if (ProtoMsg$StatsMsg.ErrorMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(errorMsg.bG);
            }
        }
        mergeUnknownFields(errorMsg.getUnknownFields());
        return this;
    }

    public final edb O000000o(ProtoMsg$StatsMsg.ProtoError protoError) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(protoError);
        } else if (protoError != null) {
            O0000O0o();
            this.O00000Oo.add(protoError);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.ErrorMsg build() {
        ProtoMsg$StatsMsg.ErrorMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000oOo;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O0000oo0.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.ErrorMsg.class, edb.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public edb clone() {
        return new edb().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.ProtoError) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ edb O00000Oo() {
        return new edb();
    }
}
