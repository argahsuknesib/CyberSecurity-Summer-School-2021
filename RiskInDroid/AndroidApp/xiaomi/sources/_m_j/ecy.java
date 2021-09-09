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

public final class ecy extends GeneratedMessage.Builder implements ecz {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f15176O000000o;
    private List O00000Oo;
    private RepeatedFieldBuilder O00000o0;

    private ecy() {
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    private ecy(GeneratedMessage.BuilderParent builderParent) {
        super(builderParent);
        this.O00000Oo = Collections.emptyList();
        O00000o0();
    }

    public /* synthetic */ ecy(GeneratedMessage.BuilderParent builderParent, byte b) {
        this(builderParent);
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecy mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoMsg$StatsMsg.CrashMsg crashMsg;
        ProtoMsg$StatsMsg.CrashMsg crashMsg2 = null;
        try {
            ProtoMsg$StatsMsg.CrashMsg crashMsg3 = (ProtoMsg$StatsMsg.CrashMsg) ProtoMsg$StatsMsg.CrashMsg.f6062O000000o.parsePartialFrom(codedInputStream, extensionRegistryLite);
            if (crashMsg3 != null) {
                O000000o(crashMsg3);
            }
            return this;
        } catch (InvalidProtocolBufferException e) {
            crashMsg = (ProtoMsg$StatsMsg.CrashMsg) e.getUnfinishedMessage();
            throw e;
        } catch (Throwable th) {
            th = th;
            crashMsg2 = crashMsg;
        }
        if (crashMsg2 != null) {
            O000000o(crashMsg2);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ecy mergeFrom(Message message) {
        if (message instanceof ProtoMsg$StatsMsg.CrashMsg) {
            return O000000o((ProtoMsg$StatsMsg.CrashMsg) message);
        }
        super.mergeFrom(message);
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public ecy clear() {
        super.clear();
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            this.O00000Oo = Collections.emptyList();
            this.f15176O000000o &= -2;
        } else {
            repeatedFieldBuilder.clear();
        }
        return this;
    }

    private void O00000o0() {
        if (ProtoMsg$StatsMsg.CrashMsg.alwaysUseFieldBuilders) {
            O0000OOo();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oo */
    public ProtoMsg$StatsMsg.CrashMsg buildPartial() {
        List list;
        ProtoMsg$StatsMsg.CrashMsg crashMsg = new ProtoMsg$StatsMsg.CrashMsg(this, (byte) 0);
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            if ((this.f15176O000000o & 1) == 1) {
                this.O00000Oo = Collections.unmodifiableList(this.O00000Oo);
                this.f15176O000000o &= -2;
            }
            list = this.O00000Oo;
        } else {
            list = repeatedFieldBuilder.build();
        }
        List unused = crashMsg.bD = list;
        onBuilt();
        return crashMsg;
    }

    private void O0000O0o() {
        if ((this.f15176O000000o & 1) != 1) {
            this.O00000Oo = new ArrayList(this.O00000Oo);
            this.f15176O000000o |= 1;
        }
    }

    private RepeatedFieldBuilder O0000OOo() {
        if (this.O00000o0 == null) {
            List list = this.O00000Oo;
            boolean z = true;
            if ((this.f15176O000000o & 1) != 1) {
                z = false;
            }
            this.O00000o0 = new RepeatedFieldBuilder(list, z, getParentForChildren(), isClean());
            this.O00000Oo = null;
        }
        return this.O00000o0;
    }

    public final ecy O000000o(ecx ecx) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder == null) {
            O0000O0o();
            this.O00000Oo.add(ecx.build());
            onChanged();
        } else {
            repeatedFieldBuilder.addMessage(ecx.build());
        }
        return this;
    }

    public final ecy O000000o(ProtoMsg$StatsMsg.Crash crash) {
        RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
        if (repeatedFieldBuilder != null) {
            repeatedFieldBuilder.addMessage(crash);
        } else if (crash != null) {
            O0000O0o();
            this.O00000Oo.add(crash);
            onChanged();
        } else {
            throw new NullPointerException();
        }
        return this;
    }

    public final ecy O000000o(ProtoMsg$StatsMsg.CrashMsg crashMsg) {
        if (crashMsg == ProtoMsg$StatsMsg.CrashMsg.O000000o()) {
            return this;
        }
        if (this.O00000o0 == null) {
            if (!crashMsg.bD.isEmpty()) {
                if (this.O00000Oo.isEmpty()) {
                    this.O00000Oo = crashMsg.bD;
                    this.f15176O000000o &= -2;
                } else {
                    O0000O0o();
                    this.O00000Oo.addAll(crashMsg.bD);
                }
                onChanged();
            }
        } else if (!crashMsg.bD.isEmpty()) {
            if (this.O00000o0.isEmpty()) {
                this.O00000o0.dispose();
                RepeatedFieldBuilder repeatedFieldBuilder = null;
                this.O00000o0 = null;
                this.O00000Oo = crashMsg.bD;
                this.f15176O000000o &= -2;
                if (ProtoMsg$StatsMsg.CrashMsg.alwaysUseFieldBuilders) {
                    repeatedFieldBuilder = O0000OOo();
                }
                this.O00000o0 = repeatedFieldBuilder;
            } else {
                this.O00000o0.addAllMessages(crashMsg.bD);
            }
        }
        mergeUnknownFields(crashMsg.getUnknownFields());
        return this;
    }

    /* renamed from: O000000o */
    public final ProtoMsg$StatsMsg.CrashMsg build() {
        ProtoMsg$StatsMsg.CrashMsg O00000oo = buildPartial();
        if (O00000oo.isInitialized()) {
            return O00000oo;
        }
        throw newUninitializedMessageException((Message) O00000oo);
    }

    public final Descriptors.Descriptor getDescriptorForType() {
        return ecr.O0000ooo;
    }

    public final GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ecr.O00oOooO.ensureFieldAccessorsInitialized(ProtoMsg$StatsMsg.CrashMsg.class, ecy.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000oO */
    public ecy clone() {
        return new ecy().O000000o(buildPartial());
    }

    public final boolean isInitialized() {
        int i = 0;
        while (true) {
            RepeatedFieldBuilder repeatedFieldBuilder = this.O00000o0;
            if (i >= (repeatedFieldBuilder == null ? this.O00000Oo.size() : repeatedFieldBuilder.getCount())) {
                return true;
            }
            RepeatedFieldBuilder repeatedFieldBuilder2 = this.O00000o0;
            if (!((ProtoMsg$StatsMsg.Crash) (repeatedFieldBuilder2 == null ? this.O00000Oo.get(i) : repeatedFieldBuilder2.getMessage(i))).isInitialized()) {
                return false;
            }
            i++;
        }
    }

    public static /* synthetic */ ecy O00000Oo() {
        return new ecy();
    }
}
